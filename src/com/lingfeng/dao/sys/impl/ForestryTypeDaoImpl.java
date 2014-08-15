package com.lingfeng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.lingfeng.dao.sys.ForestryTypeDao;
import com.lingfeng.model.sys.ForestryType;

import core.dao.BaseDao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Repository
public class ForestryTypeDaoImpl extends BaseDao<ForestryType> implements ForestryTypeDao {

	public ForestryTypeDaoImpl() {
		super(ForestryType.class);
	}

}
