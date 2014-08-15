package com.lingfeng.model.sys.param;

import core.extjs.ExtJSBaseParameter;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public class ConfigParameter extends ExtJSBaseParameter {

	private static final long serialVersionUID = -2197040433315922797L;
	private String configTypeName;

	public String getConfigTypeName() {
		return configTypeName;
	}

	public void setConfigTypeName(String configTypeName) {
		this.configTypeName = configTypeName;
	}

}
