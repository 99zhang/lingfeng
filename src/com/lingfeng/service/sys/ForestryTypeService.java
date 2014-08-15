package com.lingfeng.service.sys;

import java.util.List;

import com.lingfeng.model.sys.ForestryType;

import core.service.Service;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public interface ForestryTypeService extends Service<ForestryType> {

	List<ForestryType> getForestryTypeList(List<ForestryType> resultList);

}
