package com.xxx.it.xdevice.vo;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Repository;

@Repository
@XmlRootElement
public class DeviceVO extends BaseResource {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2483972277497672493L;
	private String id;
	private String deviceBrand;
	private String deviceName;
	private String deviceModel;
	private String deviceOSVersion;
	private String sn;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDeviceBrand() {
		return deviceBrand;
	}
	public void setDeviceBrand(String deviceBrand) {
		this.deviceBrand = deviceBrand;
	}
	public String getDeviceName() {
		return deviceName;
	}
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}
	public String getDeviceModel() {
		return deviceModel;
	}
	public void setDeviceModel(String deviceModel) {
		this.deviceModel = deviceModel;
	}
	public String getDeviceOSVersion() {
		return deviceOSVersion;
	}
	public void setDeviceOSVersion(String deviceOSVersion) {
		this.deviceOSVersion = deviceOSVersion;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}

}