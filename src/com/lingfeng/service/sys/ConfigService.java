package com.lingfeng.service.sys;

import java.util.List;

import com.lingfeng.model.sys.Config;

import core.service.Service;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface ConfigService extends Service<Config> {

	List<Config> getConfigList(List<Config> resultList);

}
