package com.lingfeng.dao.sys;

import java.util.List;

import com.lingfeng.model.sys.Authority;

import core.dao.Dao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface AuthorityDao extends Dao<Authority> {

	List<Authority> queryByParentIdAndRole(Short role);

	List<Authority> queryChildrenByParentIdAndRole(Long parentId, Short role);

}
