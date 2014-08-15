package com.lingfeng.service.sys;

import java.util.List;

import com.lingfeng.model.sys.Sensor;

import core.service.Service;
import core.support.QueryResult;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface SensorService extends Service<Sensor> {

	List<Sensor> querySensorBySensorType(Short sensorType);

	List<Sensor> querySensorLastData();

	QueryResult<Sensor> querySensorList(Sensor sensor);

	List<Sensor> querySensorLastDataWithEpcId();

	List<Sensor> queryForestrySensorLastData();

}
