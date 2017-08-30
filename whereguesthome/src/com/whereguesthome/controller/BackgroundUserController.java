package com.whereguesthome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whereguesthome.service.UserService;

/**
 * 后台用户管理
 * 
 * @author 陈志伟
 *
 * @date Aug 29, 2017 4:24:00 PM
 */
@Controller
@RequestMapping("admin/user")
public class BackgroundUserController {
	@Autowired
	private UserService userService;

	// 分页显示所有用户列表
	@RequestMapping(value = "/", method = { RequestMethod.GET, RequestMethod.POST })
	public String displayUserList(Model model, Integer pageNumber) {
		userService.backgroundUserDisplay(model, pageNumber);
		return "admin/user/list";

	}

	// 删除一个用户
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(Integer id, Model model) {
		userService.deleteUserById(id, model);
		return "redirect:/admin/user/";
	}

}
