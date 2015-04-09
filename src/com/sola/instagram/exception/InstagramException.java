package com.sola.instagram.exception;

@SuppressWarnings("serial")
public class InstagramException extends Exception {
	//Error type, Authorization Exception 
	private String error_type;
	//Response code ie. 400, 500
	private int code;
	public InstagramException(String message,String error_type) {
		super(message);
		this.error_type= error_type;
	}
	public String getError_type() {
		return error_type;
	}
	public void setError_type(String error_type) {
		this.error_type = error_type;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
 
}
