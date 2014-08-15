package com.lingfeng.service.sys.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lingfeng.dao.sys.SensorLastDataDao;
import com.lingfeng.model.sys.SensorLastData;
import com.lingfeng.service.sys.SensorLastDataService;

import core.service.BaseService;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Service
public class SensorLastDataServiceImpl extends BaseService<SensorLastData> implements SensorLastDataService {

	private SensorLastDataDao sensorLastDataDao;

	@Resource
	public void setSensorLastDataDao(SensorLastDataDao sensorLastDataDao) {
		this.sensorLastDataDao = sensorLastDataDao;
		this.dao = sensorLastDataDao;
	}

}
