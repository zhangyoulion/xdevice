package com.xxx.it.xdevice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 日志记录：记录请求信息的日志，以便进行信息监控、信息统计、计算PV（Page View）等
 * 
 * @author Youlion88
 * 
 */
public class RequestLogInterceptor extends HandlerInterceptorAdapter {
	
	private final static Logger logger = Logger.getLogger(RequestLogInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
	    return true;  
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
}