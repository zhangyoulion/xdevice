package com.xxx.it.xdevice.exception;

public class ApplicationException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5245040241283199812L;
	private String errorCode;

	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public ApplicationException() {
		super();
	}
	public ApplicationException(String errorCode, String message) {
		super();
		this.setStackTrace(this.getStackTrace());
	}
}