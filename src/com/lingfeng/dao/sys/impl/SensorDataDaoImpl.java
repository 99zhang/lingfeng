package com.lingfeng.dao.sys.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.lingfeng.dao.sys.SensorDataDao;
import com.lingfeng.model.sys.SensorData;

import core.dao.BaseDao;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Repository
public class SensorDataDaoImpl extends BaseDao<SensorData> implements SensorDataDao {

	public SensorDataDaoImpl() {
		super(SensorData.class);
	}

	@Override
	public List<Object[]> doGetSensorDataStatistics(Short sensorType) {
		Query query = getSession()
				.createSQLQuery(
						"select concat(date_format(record_time, '%H'),':00') name,round(avg(sensor_value),2) data1,max(sensor_value) mx,min(sensor_value) mn,cast(group_concat(sensor_value) as char) gc from sensor_data sd where sensor_type = ? group by date_format(record_time, '%Y-%m-%d %H')");
		query.setParameter(0, sensorType);
		return query.list();
	}

}
