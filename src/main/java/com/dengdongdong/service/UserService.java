package com.dengdongdong.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dengdongdong.dao.LoginLogDao;
import com.dengdongdong.dao.UserDao;
import com.dengdongdong.model.LoginLog;
import com.dengdongdong.model.User;

@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private LoginLogDao loginLogDao;
	
	public boolean hasMacthUser(String userName, String password) {
		int macthCount = userDao.getMactchCount(userName, password);
		return macthCount > 0;
	}
	
	public void loginSuccess(User user) {
		user.setCredits(5 + user.getCredits());
		LoginLog loginLog = new LoginLog();
		loginLog.setLoginDate(new Date());
		loginLog.setUserId(user.getUserId());
		loginLog.setIp(user.getLastIp());
		userDao.updateLoginInfo(user);
		loginLogDao.insertLoginLog(loginLog);
	}
	
	public User findUserByUserName(String name) {
		return userDao.findUserByUserName(name);
	}
}
