package com.lingfeng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.lingfeng.dao.sys.SysUserDao;
import com.lingfeng.model.sys.SysUser;

import core.dao.BaseDao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Repository
public class SysUserDaoImpl extends BaseDao<SysUser> implements SysUserDao {

	public SysUserDaoImpl() {
		super(SysUser.class);
	}

}
