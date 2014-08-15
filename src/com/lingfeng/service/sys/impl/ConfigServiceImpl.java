package com.lingfeng.service.sys.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.lingfeng.dao.sys.ConfigDao;
import com.lingfeng.model.sys.Config;
import com.lingfeng.service.sys.ConfigService;

import core.service.BaseService;
import core.web.SystemCache;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
@Service
public class ConfigServiceImpl extends BaseService<Config> implements ConfigService {

	private ConfigDao configDao;

	@Resource
	public void setConfigDao(ConfigDao configDao) {
		this.configDao = configDao;
		this.dao = configDao;
	}

	@Override
	public List<Config> getConfigList(List<Config> resultList) {
		List<Config> configList = new ArrayList<Config>();
		for (Config entity : resultList) {
			Config config = new Config();
			config.setId(entity.getId());
			config.setConfigTypeName(SystemCache.DICTIONARY.get("CONFIG_TYPE").getItems().get(String.valueOf(entity.getConfigType())).getValue());
			config.setConfigType(entity.getConfigType());
			config.setConfigValue(entity.getConfigValue());
			configList.add(config);
		}
		return configList;
	}

}
