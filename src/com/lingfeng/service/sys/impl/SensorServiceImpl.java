package com.lingfeng.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lingfeng.dao.sys.SensorDao;
import com.lingfeng.model.sys.Sensor;
import com.lingfeng.service.sys.SensorService;

import core.service.BaseService;
import core.support.QueryResult;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Service
public class SensorServiceImpl extends BaseService<Sensor> implements SensorService {

	private SensorDao sensorDao;

	@Resource
	public void setSensorDao(SensorDao sensorDao) {
		this.sensorDao = sensorDao;
		this.dao = sensorDao;
	}

	@Override
	public List<Sensor> querySensorBySensorType(Short sensorType) {
		return sensorDao.querySensorBySensorType(sensorType);
	}

	@Override
	public List<Sensor> querySensorLastData() {
		return sensorDao.querySensorLastData();
	}

	@Override
	public QueryResult<Sensor> querySensorList(Sensor sensor) {
		return sensorDao.querySensorList(sensor);
	}

	@Override
	public List<Sensor> querySensorLastDataWithEpcId() {
		return sensorDao.querySensorLastDataWithEpcId();
	}

	@Override
	public List<Sensor> queryForestrySensorLastData() {
		return sensorDao.queryForestrySensorLastData();
	}

}
