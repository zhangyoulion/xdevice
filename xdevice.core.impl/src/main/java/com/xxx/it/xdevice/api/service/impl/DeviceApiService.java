package com.xxx.it.xdevice.api.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.xxx.it.xdevice.api.service.IDeviceApiService;
import com.xxx.it.xdevice.dao.IDeviceDao;
import com.xxx.it.xdevice.vo.DeviceVO;

@Service
public class DeviceApiService implements IDeviceApiService {
	private final static Logger logger = Logger.getLogger(DeviceApiService.class);

	@Inject
	private IDeviceDao deviceDao;

	public Map findList(int page, int pageSize) {
		logger.info("find list");
		Map<String, Object> retMap = new HashMap<String, Object>();
		List<DeviceVO> list = new ArrayList<DeviceVO>();
		list = deviceDao.findAll();
		retMap.put("list", list);
		return retMap;
	}
}