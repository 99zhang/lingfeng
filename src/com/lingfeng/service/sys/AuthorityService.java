package com.lingfeng.service.sys;

import java.util.List;

import com.lingfeng.model.sys.Authority;
import com.lingfeng.model.sys.RoleAuthority;

import core.service.Service;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface AuthorityService extends Service<Authority> {

	List<Authority> queryByParentIdAndRole(Short role);

	List<Authority> queryChildrenByParentIdAndRole(Long parentId, Short role);

	String querySurfaceAuthorityList(List<RoleAuthority> queryByProerties, Long id, String buttons);

}
