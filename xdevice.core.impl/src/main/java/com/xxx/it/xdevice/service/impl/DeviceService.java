package com.xxx.it.xdevice.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.it.xdevice.dao.IDeviceDao;
import com.xxx.it.xdevice.service.IDeviceService;
import com.xxx.it.xdevice.vo.DeviceVO;

@Service
public class DeviceService implements IDeviceService {
	private final static Logger logger = Logger.getLogger(DeviceService.class);

	@Autowired
	private IDeviceDao deviceDao;
	
	public List<DeviceVO> findList() {
		List<DeviceVO> list = new ArrayList<DeviceVO>();
		list = deviceDao.findAll();
		return list;
	}
}