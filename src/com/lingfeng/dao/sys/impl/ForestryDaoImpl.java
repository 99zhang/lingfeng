package com.lingfeng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.lingfeng.dao.sys.ForestryDao;
import com.lingfeng.model.sys.Forestry;

import core.dao.BaseDao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Repository
public class ForestryDaoImpl extends BaseDao<Forestry> implements ForestryDao {

	public ForestryDaoImpl() {
		super(Forestry.class);
	}

}
