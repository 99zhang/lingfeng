package com.lingfeng.controller.sys;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingfeng.core.LingfengBaseController;
import com.lingfeng.model.sys.SensorData;
import com.lingfeng.service.sys.SensorDataService;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Controller
@RequestMapping("/sys/sensordata")
public class SensorDataController extends LingfengBaseController<SensorData> {

	@Resource
	private SensorDataService sensorDataService;

	@RequestMapping(value = "/getSensorDataStatistics")
	public void getSensorDataStatistics(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Object[]> list = sensorDataService.doGetSensorDataStatistics(Short.valueOf(request.getParameter("sensorType")));
		List<Object[]> enhanceList = sensorDataService.doGetEnhanceSensorDataStatistics(list);
		writeJSON(response, enhanceList);
	}

}
