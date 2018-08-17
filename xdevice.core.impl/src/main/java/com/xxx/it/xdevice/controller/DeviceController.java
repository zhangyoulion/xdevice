package com.xxx.it.xdevice.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.xxx.it.xdevice.service.IDeviceService;
import com.xxx.it.xdevice.vo.DeviceVO;

@Controller
@RequestMapping("/device")
public class DeviceController {
	private final static Logger logger = Logger.getLogger(DeviceController.class);

	@Autowired
	private IDeviceService deviceService;

	@RequestMapping(
		value={
			"/page/index",
			"/device/list"
		}
	)
	public String index(Model model) {
		model.addAttribute("greeting", "Welcome to xdevice");
		logger.info("model: " + model.toString());
		return "device/device_list";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	@ResponseBody
	public Object save(@RequestBody Map<String, String> param) {
		logger.info(">>> param:" + param);
		return "param: " + param;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	@ResponseBody
	public Object update(@RequestBody Map<String, String> param) {
		logger.info(">>> param:" + param);
		return "param: " + param;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object delete(@PathVariable String id) {
		logger.info(">>> param:" + id);
		return "param: " + id;
	}

	@RequestMapping(value = "/list/{page}/{pageSize}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> list(@PathVariable int pageSize, @PathVariable int page,
			HttpSession session) {
		logger.info(">>> page=" + page + ", pageSize=" + pageSize);
		logger.info(session.getId());
		List<DeviceVO> list = deviceService.findList();
		logger.info(">>> list size:" + list.size());
		return new ResponseEntity<Object>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Object find(@PathVariable("id") String id) {
		logger.info(">>> id:" + id);

		return "id=" + id;
	}

	@RequestMapping(value = "/produce", method = RequestMethod.GET, produces = { "application/json;charset=UTF-8" })
	@ResponseBody
	public ResponseEntity<Map> produce() {
		Map<String, Object> retMap = new HashMap<String, Object>();
		List<DeviceVO> list = deviceService.findList();
		logger.info(">>> list size:" + list.size());
		retMap.put("list", list);
		retMap.put("code", "0");
		retMap.put("message", "success");
		return new ResponseEntity<Map>(retMap, HttpStatus.OK);
	}

	@RequestMapping(value = "/consumer/{id}", consumes = { "application/JSON",
			"application/XML" })
	public @ResponseBody
	Object consumer(@PathVariable("id") String id) {
		logger.info(">>> id:" + id);
		return "id=" + id;
	}

	/**
	 * 若只上传一个文件，则只需MultipartFile类型接收文件即可，而无需显式指定@RequestParam
	 * 若想上传多个文件，则这里就要用MultipartFile[]类型来接收文件，且需指定@RequestParam
	 * 上传多个文件时：前台表单中的所有文件域都要写为<input type="file" name="myfiles"/> 并且表单类型为：<form
	 * action="${ctx}/mydemo/upload" method="POST"
	 * enctype="multipart/form-data">
	 * 但如果前台用的是ajaxfileupload.js这种类似的组件，那就不需要显式的编写表单了，按照组件要求提交文件就行了
	 */
	@RequestMapping(value = "/upload")
	public String upload(String name, @RequestParam MultipartFile[] myfiles,
			HttpServletResponse response) throws IOException {
		// 可以在上传文件的同时接收其它参数
		System.out.println("收到用户[" + name + "]的文件上传请求");
		response.setContentType("text/plain; charset=UTF-8");
		PrintWriter out = response.getWriter();
		for (MultipartFile myfile : myfiles) {
			if (myfile.isEmpty()) {
				out.print("1`请选择文件后上传");
				out.flush();
				return null;
			} else {
				System.out.println("文件原名：" + myfile.getOriginalFilename());
				System.out.println("文件名称：" + myfile.getName());
				System.out.println("文件长度：" + myfile.getSize());
				System.out.println("文件类型：" + myfile.getContentType());
				System.out
						.println("===================================================");
				// 以下两种方式都能实现文件的保存
				// myfile.transferTo(new File(""));
				// FileUtils.copyInputStreamToFile(myfile.getInputStream(), new
				// File(""));
			}
		}
		out.print("0`文件保存路径");
		out.flush();
		return null;
	}
}