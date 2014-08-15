package com.lingfeng.controller.sys;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lingfeng.core.LingfengBaseController;
import com.lingfeng.model.sys.SensorLastData;
import com.lingfeng.service.sys.SensorLastDataService;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Controller
@RequestMapping("/sys/sensorlastdata")
public class SensorLastDataController extends LingfengBaseController<SensorLastData> {

	@Resource
	private SensorLastDataService sensorLastDataService;

}
