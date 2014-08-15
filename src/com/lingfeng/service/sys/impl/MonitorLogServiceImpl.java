package com.lingfeng.service.sys.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lingfeng.dao.sys.MonitorLogDao;
import com.lingfeng.model.sys.MonitorLog;
import com.lingfeng.service.sys.MonitorLogService;

import core.service.BaseService;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Service
public class MonitorLogServiceImpl extends BaseService<MonitorLog> implements MonitorLogService {

	private MonitorLogDao monitorLogDao;

	@Resource
	public void setMonitorLogDao(MonitorLogDao monitorLogDao) {
		this.monitorLogDao = monitorLogDao;
		this.dao = monitorLogDao;
	}

	@Override
	public List<MonitorLog> querySensorMonitorLog() {
		return monitorLogDao.querySensorMonitorLog();
	}

}
