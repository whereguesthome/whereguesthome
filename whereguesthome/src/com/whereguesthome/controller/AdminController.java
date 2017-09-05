package com.whereguesthome.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.whereguesthome.pojo.Admin;
import com.whereguesthome.service.AdminService;

/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */
@Controller
@RequestMapping("admin")
@SessionAttributes("a")
public class AdminController {

	@Autowired
	private AdminService adminService;

	// 管理员登录界面
	@RequestMapping(value = "/denglu", method = RequestMethod.POST)
	public String findById(HttpSession session, Model model, String aName, Admin admin) {

		boolean flag = adminService.selectByNmae(session, model, aName, admin);
		if (flag) {
			return "admin/home";

		} else {
			return "admin/index";
		}
	}

	// 注销，清空session
	@RequestMapping(value = "/zhuxiao", method = RequestMethod.GET)
	public String outLogin(HttpSession session, SessionStatus sessionStatus) {
		session.removeAttribute("a");// 我这里是先取出httpsession中的user属性
		session.invalidate(); // 然后是让httpsession失效
		sessionStatus.setComplete();// 最后是调用sessionStatus方法
		return "admin/index";
	}

	// 请求登录页面
	@RequestMapping(value = "/shouye")
	public String denglu() {
		return "admin/index";
	}

	// 管理员界面顶部界面
	@RequestMapping(value = "topa", method = RequestMethod.GET)
	public String top() {
		return "admin/top";
	}

	// 管理员界面左侧界面
	@RequestMapping(value = "lefta", method = RequestMethod.GET)
	public String left() {
		return "admin/left";
	}

	@RequestMapping(value = "bottoma", method = RequestMethod.GET)
	public String bottom() {
		return "admin/bottom";
	}

	@RequestMapping(value = "welcomea", method = RequestMethod.GET)
	public String welcome() {
		return "admin/welcome";
	}

}
