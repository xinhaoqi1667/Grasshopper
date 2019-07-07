package com.hp.entity;
//返回json格式通用类
public class Result {

	private String resultCode;//返回状态码
	private String reason;//返回状态消息
	
	
	public Result() {
		// TODO Auto-generated constructor stub
	}
	public Result(String resultCode, String reason) {
		this.resultCode = resultCode;
		this.reason = reason;
	}
	
	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
	
	
}
