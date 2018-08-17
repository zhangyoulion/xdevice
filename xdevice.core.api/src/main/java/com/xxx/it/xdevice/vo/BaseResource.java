package com.xxx.it.xdevice.vo;

import java.io.Serializable;
import java.util.Date;

public class BaseResource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8677819982854948848L;
	private long createdBy;
	private long lastUpdateBy;
	private Date creationDate;
	private Date lastUpdateDate;

	public long getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}

	public long getLastUpdateBy() {
		return lastUpdateBy;
	}

	public void setLastUpdateBy(long lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getLastUpdateDate() {
		return lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdateDate) {
		this.lastUpdateDate = lastUpdateDate;
	}

}