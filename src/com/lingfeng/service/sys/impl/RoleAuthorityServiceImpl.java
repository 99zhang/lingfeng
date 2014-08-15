package com.lingfeng.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lingfeng.dao.sys.RoleAuthorityDao;
import com.lingfeng.model.sys.RoleAuthority;
import com.lingfeng.service.sys.RoleAuthorityService;

import core.service.BaseService;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Service
public class RoleAuthorityServiceImpl extends BaseService<RoleAuthority> implements RoleAuthorityService {

	private RoleAuthorityDao roleAuthorityDao;

	@Resource
	public void setRoleAuthorityDao(RoleAuthorityDao roleAuthorityDao) {
		this.roleAuthorityDao = roleAuthorityDao;
		this.dao = roleAuthorityDao;
	}

}
