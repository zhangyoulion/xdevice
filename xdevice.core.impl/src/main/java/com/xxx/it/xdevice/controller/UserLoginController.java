package com.xxx.it.xdevice.controller;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登录认证的控制器
 */
@Controller
@RequestMapping("/userlogin")
public class UserLoginController {
	private final static Logger logger = Logger.getLogger(UserLoginController.class);

	@RequestMapping(value = "/page/login")
	public String loginPage() {
		return "user/login";
	}
	
	@RequestMapping(value = "/page/register")
	public String registerPage() {
		return "user/register";
	}
	
	/**
	 * 注冊
	 * 
	 * @param session
	 *            HttpSession
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	@RequestMapping(value = "/register")
	public String register(HttpSession session, String username, String password) throws Exception {
		logger.info("register...");
		
		// 重定向
		return "redirect:page/login";
	}
	
	/**
	 * 登录
	 * 
	 * @param session
	 *            HttpSession
	 * @param username
	 *            用户名
	 * @param password
	 *            密码
	 * @return
	 */
	@RequestMapping(value = "/login")
	public String login(HttpSession session, String username, String password) throws Exception {
		logger.info("login...");
		if ("1234".equals(password)) {
			// 在Session里保存信息
			session.setAttribute("username", username);	
		}
		// 重定向
		return "redirect:/device/page/index";
	}

	/**
	 * 退出系统
	 * 
	 * @param session
	 *            Session
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception {
		logger.info("logout...");
		// 清除Session
		session.invalidate();

		return "redirect:page/login";
	}

}