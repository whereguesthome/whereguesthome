package com.whereguesthome.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.whereguesthome.pojo.Admin;

/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */
public interface AdminService {

	/**
	 * @param model
	 * @param aName 根据名字查询条件
	 * @param admin 管理员POJO
	 * @return
	 */
	//查询管理员信息
	boolean selectByNmae(HttpSession session,Model model, String aName, Admin admin);
}
