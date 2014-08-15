package com.lingfeng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.lingfeng.dao.sys.ConfigDao;
import com.lingfeng.model.sys.Config;

import core.dao.BaseDao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Repository
public class ConfigDaoImpl extends BaseDao<Config> implements ConfigDao {

	public ConfigDaoImpl() {
		super(Config.class);
	}

}
