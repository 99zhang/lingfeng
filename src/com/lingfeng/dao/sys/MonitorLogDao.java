package com.lingfeng.dao.sys;

import java.util.List;

import com.lingfeng.model.sys.MonitorLog;

import core.dao.Dao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface MonitorLogDao extends Dao<MonitorLog> {

	List<MonitorLog> querySensorMonitorLog();

}
