package com.whereguesthome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("admin/user")
public class AddressController {

	// 跳转到收获地址界面
	@RequestMapping(value = "address")
	public String list() {
		return "admin/user/address";
	}

}
