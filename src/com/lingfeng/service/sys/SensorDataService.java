package com.lingfeng.service.sys;

import java.util.List;

import com.lingfeng.model.sys.SensorData;

import core.service.Service;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface SensorDataService extends Service<SensorData> {

	List<Object[]> doGetSensorDataStatistics(Short sensorType);

	List<Object[]> doGetEnhanceSensorDataStatistics(List<Object[]> list);

}
