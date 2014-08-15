package com.lingfeng.core;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.lingfeng.model.sys.SysUser;

import core.controller.ExtJSBaseController;
import core.extjs.ExtJSBaseParameter;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public abstract class LingfengBaseController<E extends ExtJSBaseParameter> extends ExtJSBaseController<E> implements Constant {

	public SysUser getCurrentSysUser() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return (SysUser) request.getSession().getAttribute(SESSION_SYS_USER);
	}

}
