package com.lingfeng.dao.sys.impl;

import java.util.List;

import org.hibernate.SQLQuery;
import org.springframework.stereotype.Repository;

import com.lingfeng.dao.sys.AuthorityDao;
import com.lingfeng.model.sys.Authority;

import core.dao.BaseDao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Repository
public class AuthorityDaoImpl extends BaseDao<Authority> implements AuthorityDao {

	public AuthorityDaoImpl() {
		super(Authority.class);
	}

	@Override
	public List<Authority> queryByParentIdAndRole(Short role) {
		SQLQuery query = getSession().createSQLQuery("select a.* from authority a,role_authority ra where concat(a.id) = ra.authority_id and a.parent_id is null and ra.role = ?");
		query.setParameter(0, role);
		query.addEntity(Authority.class);
		return query.list();
	}

	@Override
	public List<Authority> queryChildrenByParentIdAndRole(Long parentId, Short role) {
		SQLQuery query = getSession().createSQLQuery("select a.* from authority a,role_authority ra where concat(a.id) = ra.authority_id and a.parent_id = ? and ra.role = ?");
		query.setParameter(0, parentId);
		query.setParameter(1, role);
		query.addEntity(Authority.class);
		return query.list();
	}

}
