package com.lingfeng.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lingfeng.dao.sys.SensorDataDao;
import com.lingfeng.model.sys.SensorData;
import com.lingfeng.service.sys.SensorDataService;

import core.service.BaseService;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Service
public class SensorDataServiceImpl extends BaseService<SensorData> implements SensorDataService {

	private SensorDataDao sensorDataDao;

	@Resource
	public void setSensorDataDao(SensorDataDao sensorDataDao) {
		this.sensorDataDao = sensorDataDao;
		this.dao = sensorDataDao;
	}

	@Override
	public List<Object[]> doGetSensorDataStatistics(Short sensorType) {
		return sensorDataDao.doGetSensorDataStatistics(sensorType);
	}

	@Override
	public List<Object[]> doGetEnhanceSensorDataStatistics(List<Object[]> list) {
		List<Object[]> enhanceList = new ArrayList<Object[]>();
		for (Object[] objectArray : list) {
			String[] sted = String.valueOf(objectArray[4]).split(",");
			Object[] object = new Object[] { objectArray[0], objectArray[1], objectArray[2], objectArray[3], String.valueOf(sted[0]), String.valueOf(sted[sted.length - 1]) };
			enhanceList.add(object);
		}
		return enhanceList;
	}

}
