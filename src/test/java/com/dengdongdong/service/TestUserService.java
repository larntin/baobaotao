package com.dengdongdong.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.dengdongdong.model.User;
import com.dengdongdong.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestUserService {

	@Autowired
	private UserService userService;
	
	@Test
	public void hasMacthUser() {
		boolean b1 = userService.hasMacthUser("ddd", "123");
		boolean b2 = userService.hasMacthUser("ddd", "1234");
	}
	
	@Test
	public void loginSuccess() {
		User u1 = new User();
		u1.setUserId(1);
		u1.setUserName("admin");
		u1.setPwd("123456");
		userService.loginSuccess(u1);
	}
}
