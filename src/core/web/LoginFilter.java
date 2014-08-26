package core.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.lingfeng.core.Constant;
import com.lingfeng.model.sys.SysUser;

/**
 * @author David.Wang
 * @email wangfeng090809@gmail.com
 */
public class LoginFilter implements Filter {
	private Logger logger = Logger.getLogger(LoginFilter.class);
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		logger.info("Inside doFilter");
		
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		String contextPath = request.getContextPath();
		String url = request.getRequestURI();
		logger.info(",url is:"+url);
		url = url.replace(contextPath, "");
		if (url.startsWith("/sys") && !url.contains("/sys/sysuser/login") && !url.contains("/sys/attachment/getFlower") && !url.contains("/sys/sysuser/externalVerifySysUser")) {
			SysUser sysUser = (SysUser) request.getSession().getAttribute(Constant.SESSION_SYS_USER);
			if (null == sysUser) {
				logger.warn("User time out:");
				response.sendRedirect(contextPath + "/login.jsp");
				return;
			}else{
				logger.info("Current user:"+sysUser.getUserName());
			}
			// SessionThreadLocal.setThreadSysUser(sysUser);
		}
		if (request.getMethod().equalsIgnoreCase("get")) {
			request = new GetHttpServletRequestWrapper(request, "UTF-8");
		}

		filterChain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
