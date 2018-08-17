package com.xxx.it.xdevice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * Performance Monitor
 * 
 * @author Youlion88
 * 
 */
public class PerformanceMonitorInterceptor extends HandlerInterceptorAdapter {
	
	private final static Logger logger = Logger.getLogger(PerformanceMonitorInterceptor.class);
	
	private NamedThreadLocal<Long> startTimeThreadLocal = new NamedThreadLocal<Long>("watchStartTime");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		long beginTime = System.currentTimeMillis();// 1、开始时间
		startTimeThreadLocal.set(beginTime);// 线程绑定变量（该数据只有当前请求的线程可见）
		return true;// 继续流程
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		long endTime = System.currentTimeMillis();// 2、结束时间
		long beginTime = startTimeThreadLocal.get();// 得到线程绑定的局部变量（开始时间）
		long costTime = endTime - beginTime;// 3、消耗的时间
		logger.info(String.format("URI: %s, cost: %d ms", request.getRequestURI(), costTime));
		if (costTime > 500) {// 此处认为处理时间超过500毫秒的请求为慢请求
			// TODO 记录到日志文件
			logger.info(String.format(">>>URI: %s cost: %d ms, timeout", request.getRequestURI(), costTime));
		}
	}
}