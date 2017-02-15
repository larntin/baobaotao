package com.dengdongdong.model;

import java.io.Serializable;
import java.util.Date;

public class LoginLog implements Serializable{
	private static final long serialVersionUID = -5947007620026364614L;
	
	private int loginLogId;
	public int getLoginLogId() {
		return loginLogId;
	}
	public void setLoginLogId(int loginLogId) {
		this.loginLogId = loginLogId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public Date getLoginDate() {
		return loginDate;
	}
	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	private int userId;
	private String ip;
	private Date loginDate;
}
