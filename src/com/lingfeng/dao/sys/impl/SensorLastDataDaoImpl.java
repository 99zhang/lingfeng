package com.lingfeng.dao.sys.impl;

import org.springframework.stereotype.Repository;

import com.lingfeng.dao.sys.SensorLastDataDao;
import com.lingfeng.model.sys.SensorLastData;

import core.dao.BaseDao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Repository
public class SensorLastDataDaoImpl extends BaseDao<SensorLastData> implements SensorLastDataDao {

	public SensorLastDataDaoImpl() {
		super(SensorLastData.class);
	}

}
