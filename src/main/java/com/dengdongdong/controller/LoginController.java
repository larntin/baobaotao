package com.dengdongdong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.dengdongdong.model.User;
import com.dengdongdong.service.UserService;

// @Controller注解可以将任何一个POJO对象标注为SpringMVC的控制器，用于处理HTTP请求
@Controller
public class LoginController {
	@Autowired
	UserService userService;
	
	@RequestMapping("/index.html")
	public String loginPage() {
		return "login";
	}
	
	@RequestMapping("/loginCheck.html")
	public ModelAndView loginCheck(HttpServletRequest request, LoginCommand loginCommand){
		boolean bValidateUser = userService.hasMacthUser(loginCommand.getUserName(), loginCommand.getUserPwd());
		if(!bValidateUser) {
			return new ModelAndView("login", "error", "用户名和密码错误");
		} else {
			User user = userService.findUserByUserName(loginCommand.getUserName());
			user.setLastIp(request.getRemoteAddr());
			user.setLastVisit(new Date());
			userService.loginSuccess(user);
			request.getSession().setAttribute("user", user);
			return new ModelAndView("main");
		}
	}
}
