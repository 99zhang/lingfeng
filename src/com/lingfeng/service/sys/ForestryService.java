package com.lingfeng.service.sys;

import java.util.List;

import com.lingfeng.model.sys.Forestry;

import core.service.Service;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface ForestryService extends Service<Forestry> {

	List<Forestry> getForestryList(List<Forestry> resultList);

}
