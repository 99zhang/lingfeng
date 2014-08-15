package com.lingfeng.controller.sys;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingfeng.core.LingfengBaseController;
import com.lingfeng.model.sys.Authority;
import com.lingfeng.model.sys.RoleAuthority;
import com.lingfeng.service.sys.AuthorityService;
import com.lingfeng.service.sys.RoleAuthorityService;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Controller
@RequestMapping("/sys/authority")
public class AuthorityController extends LingfengBaseController<Authority> {

	@Resource
	private AuthorityService authorityService;
	@Resource
	private RoleAuthorityService roleAuthorityService;

	@RequestMapping("/getAuthority")
	public void getAuthority(HttpServletRequest request, HttpServletResponse response) throws Exception {
		Short role = Short.valueOf(request.getParameter("globalRoleId"));
		List<Authority> mainMenuList = authorityService.queryByParentIdAndRole(role);
		List resultList = new ArrayList();
		for (int i = 0; i < mainMenuList.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.element("id", mainMenuList.get(i).getId());
			jsonObject.element("sortOrder", mainMenuList.get(i).getSortOrder());
			jsonObject.element("menuCode", mainMenuList.get(i).getMenuCode());
			jsonObject.element("text", mainMenuList.get(i).getMenuName());
			jsonObject.element("menuConfig", mainMenuList.get(i).getMenuConfig());
			jsonObject.element("buttons", mainMenuList.get(i).getButtons());
			jsonObject.element("expanded", mainMenuList.get(i).getExpanded());
			jsonObject.element("checked", mainMenuList.get(i).getChecked());
			jsonObject.element("leaf", mainMenuList.get(i).getLeaf());
			jsonObject.element("url", mainMenuList.get(i).getUrl());
			jsonObject.element("iconCls", mainMenuList.get(i).getIconCls());

			JSONArray jsonArray = new JSONArray();
			List<Authority> childrenMenuList = authorityService.queryChildrenByParentIdAndRole(mainMenuList.get(i).getId(), role);
			for (int j = 0; j < childrenMenuList.size(); j++) {
				JSONObject childrenJsonObject = new JSONObject();

				String buttons = authorityService.querySurfaceAuthorityList(roleAuthorityService.queryByProerties("role", role), childrenMenuList.get(j).getId(), childrenMenuList.get(j).getButtons());

				childrenJsonObject.element("id", childrenMenuList.get(j).getId());
				childrenJsonObject.element("sortOrder", childrenMenuList.get(j).getSortOrder());
				childrenJsonObject.element("menuCode", childrenMenuList.get(j).getMenuCode());
				childrenJsonObject.element("text", childrenMenuList.get(j).getMenuName());
				childrenJsonObject.element("menuConfig", childrenMenuList.get(j).getMenuConfig());
				childrenJsonObject.element("buttons", buttons);
				childrenJsonObject.element("expanded", childrenMenuList.get(j).getExpanded());
				childrenJsonObject.element("checked", childrenMenuList.get(j).getChecked());
				childrenJsonObject.element("leaf", childrenMenuList.get(j).getLeaf());
				childrenJsonObject.element("url", childrenMenuList.get(j).getUrl());
				childrenJsonObject.element("iconCls", childrenMenuList.get(j).getIconCls());
				jsonArray.add(childrenJsonObject);
			}
			jsonObject.element("children", jsonArray);
			resultList.add(jsonObject);
		}
		writeJSON(response, resultList);
	}

	@RequestMapping("/getAuthorizationList")
	public void getAuthorizationList(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String roleParam = request.getParameter("role");
		List<String> authorityIdList = new ArrayList<String>();
		if (roleParam != null) {
			List<RoleAuthority> roleAuthorityList = roleAuthorityService.queryByProerties("role", Short.valueOf(roleParam));
			for (RoleAuthority roleAuthority : roleAuthorityList) {
				authorityIdList.add(roleAuthority.getAuthorityId());
			}
		}

		List<Authority> mainMenuList = authorityService.queryByProerties("parentId", null);
		List resultList = new ArrayList();
		for (int i = 0; i < mainMenuList.size(); i++) {
			JSONObject jsonObject = new JSONObject();
			jsonObject.element("id", mainMenuList.get(i).getId());
			jsonObject.element("text", mainMenuList.get(i).getMenuName());
			jsonObject.element("expanded", mainMenuList.get(i).getExpanded());

			if (authorityIdList.contains(mainMenuList.get(i).getId().toString())) {
				jsonObject.element("checked", true);
			} else {
				jsonObject.element("checked", false);
			}

			jsonObject.element("leaf", mainMenuList.get(i).getLeaf());

			JSONArray jsonArray = new JSONArray();
			List<Authority> childrenMenuList = authorityService.queryByProerties("parentId", mainMenuList.get(i).getId());
			for (int j = 0; j < childrenMenuList.size(); j++) {
				JSONObject childrenJsonObject = new JSONObject();
				childrenJsonObject.element("id", childrenMenuList.get(j).getId());
				childrenJsonObject.element("text", childrenMenuList.get(j).getMenuName());
				childrenJsonObject.element("expanded", childrenMenuList.get(j).getExpanded());
				if (authorityIdList.contains(childrenMenuList.get(j).getId().toString())) {
					childrenJsonObject.element("checked", true);
				} else {
					childrenJsonObject.element("checked", false);
				}

				if (childrenMenuList.get(j).getButtons().length() == 0) {
					childrenJsonObject.element("leaf", true);
				} else {
					childrenJsonObject.element("leaf", false);
				}

				JSONArray buttonJSONArray = new JSONArray();
				String[] buttons = childrenMenuList.get(j).getButtons().split(",");
				for (int z = 0; z < buttons.length; z++) {
					JSONObject buttonChildrenJSONObject = new JSONObject();
					buttonChildrenJSONObject.element("id", childrenMenuList.get(j).getId() + buttons[z]);
					String buttonText = null;
					if (buttons[z].equalsIgnoreCase("Add")) {
						buttonText = "添加";
					} else if (buttons[z].equalsIgnoreCase("Edit")) {
						buttonText = "修改";
					} else if (buttons[z].equalsIgnoreCase("Delete")) {
						buttonText = "删除";
					} else if (buttons[z].equalsIgnoreCase("View")) {
						buttonText = "查看";
					} else if (buttons[z].equalsIgnoreCase("Import")) {
						buttonText = "导入";
					} else if (buttons[z].equalsIgnoreCase("Query")) {
						buttonText = "查询";
					}
					buttonChildrenJSONObject.element("text", buttonText);
					buttonChildrenJSONObject.element("expanded", true);

					if (authorityIdList.contains(childrenMenuList.get(j).getId() + buttons[z])) {
						buttonChildrenJSONObject.element("checked", true);
					} else {
						buttonChildrenJSONObject.element("checked", false);
					}

					buttonChildrenJSONObject.element("leaf", true);
					buttonJSONArray.add(buttonChildrenJSONObject);
				}
				childrenJsonObject.element("children", buttonJSONArray);

				jsonArray.add(childrenJsonObject);

			}
			jsonObject.element("children", jsonArray);
			resultList.add(jsonObject);
		}
		writeJSON(response, resultList);
	}

}
