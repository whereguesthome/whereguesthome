package com.whereguesthome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.whereguesthome.md5.md5jdkUtil;
import com.whereguesthome.pojo.User;
import com.whereguesthome.service.UserService;
@Controller
@SessionAttributes("user")
@RequestMapping("jsp")
public class UserController {
	
	@Autowired
	private UserService userService;
	
    //用户登陆页面
	@RequestMapping(value="/dlu", method = RequestMethod.GET)
	public String login() {
		return "jsp/login";
	}
	//用户注册页面
	@RequestMapping(value="/zhuc", method = RequestMethod.GET)
	public String register() {
		return "jsp/register";
	}
	// 用户注册
	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String insert(User record, HttpServletRequest request) {
		String uName = "";
		// 1 验证用户名是否为空
		if (record != null && null != record.getuName() && !"".equals(record.getuName())) {
			uName = record.getuName();
		} else {
			return "jsp/register";
		}
		// 2 严重用户名是否重复
		if (userService.uname(uName)) {
			request.setAttribute("users", "用户名存在，请重新注册");
			return "jsp/register";
		} else {

			userService.insert(record);

			return "jsp/login";
		}

	}

	// 用户登录验证
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String findAll(String uName, String uPassword, Model m, HttpServletRequest request) {
		List<User> list = userService.findAll();
		boolean flag = false;
	  String md5=md5jdkUtil.getMd5(uPassword);
		for (User users : list) {
			if (users.getuName().equals(uName) && users.getuPassword().equals(md5)) {				
				  request.getSession().setAttribute("user",users);
					 /* ; @SessionAttributes配置后，原始的request获取ssesion存放数据失效*/
					// 登录成功保存用户登录状态							
				flag = true;
                break;
				
			}else{
				flag = false;
			}
		   }if (flag ) {			  
			   return "redirect:/jsp/index";
		}else{
			m.addAttribute("users", "用户名或密码错误");
			return "jsp/login";	
		}

	}

	// 用户退出
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "jsp/register";
	}

}
