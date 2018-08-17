package com.xxx.it.xdevice.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 权限检查：如登录检测，进入处理器检测检测是否登录，如果没有直接返回到登录页面
 * 
 * @author Youlion88
 * 
 */
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {
	
	private final static Logger logger = Logger.getLogger(AuthorizationInterceptor.class);
	
	private String loginUrl = "/userlogin";
	private String loginPageUrl = "/userlogin/page/login";
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		logger.info("servletPath: "+request.getServletPath());
		HttpSession session = request.getSession();
		
		//1、请求到登录页面 放行  
	    if(request.getServletPath().startsWith(loginUrl)) {  
	        return true;  
	    }  
	          
	    //2、TODO 比如退出、首页等页面无需登录，即此处要放行 允许游客的请求  
	          
	    //3、如果用户已经登录 放行    
	    if(session.getAttribute("username") != null) {  
	        //更好的实现方式的使用cookie  
	        return true;  
	    }
	    
	    //jax 请求不拦截 
	    if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")){ 
            return true;
        }
	    
	    //4、非法请求 即这些请求需要登录后才能访问  
	    //重定向到登录页面  
	    response.sendRedirect(request.getContextPath() + loginPageUrl);  
	    return false;  
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		
	}
}