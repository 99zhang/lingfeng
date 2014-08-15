package com.lingfeng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.lingfeng.dao.sys.RoleAuthorityDao;
import com.lingfeng.model.sys.RoleAuthority;

import core.dao.BaseDao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Repository
public class RoleAuthorityDaoImpl extends BaseDao<RoleAuthority> implements RoleAuthorityDao {

	public RoleAuthorityDaoImpl() {
		super(RoleAuthority.class);
	}
}
