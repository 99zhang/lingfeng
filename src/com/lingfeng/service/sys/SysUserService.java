package com.lingfeng.service.sys;

import java.util.List;

import com.lingfeng.model.sys.SysUser;

import core.service.Service;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface SysUserService extends Service<SysUser> {

	List<SysUser> getSysUserList(List<SysUser> resultList);

}
