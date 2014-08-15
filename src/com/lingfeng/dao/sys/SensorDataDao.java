package com.lingfeng.dao.sys;

import java.util.List;

import com.lingfeng.model.sys.SensorData;

import core.dao.Dao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface SensorDataDao extends Dao<SensorData> {

	List<Object[]> doGetSensorDataStatistics(Short sensorType);

}
