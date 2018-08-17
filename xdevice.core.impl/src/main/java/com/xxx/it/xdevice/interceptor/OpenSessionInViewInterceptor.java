package com.xxx.it.xdevice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * OpenSessionInView: Hibernate，在进入处理器打开Session，在完成后关闭Session
 * 
 * @author Youlion88
 * 
 */
public class OpenSessionInViewInterceptor extends HandlerInterceptorAdapter {
	
	private final static Logger logger = Logger.getLogger(OpenSessionInViewInterceptor.class);
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
	    return true;  
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
}