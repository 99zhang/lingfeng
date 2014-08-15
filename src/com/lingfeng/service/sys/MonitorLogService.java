package com.lingfeng.service.sys;

import java.util.List;

import com.lingfeng.model.sys.MonitorLog;

import core.service.Service;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface MonitorLogService extends Service<MonitorLog> {

	List<MonitorLog> querySensorMonitorLog();

}
