package com.hp.entity;
//����json��ʽͨ����
public class Result {

	private String resultCode;//����״̬��
	private String reason;//����״̬��Ϣ
	
	
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
