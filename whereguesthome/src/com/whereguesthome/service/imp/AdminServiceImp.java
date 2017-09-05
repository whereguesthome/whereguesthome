package com.whereguesthome.service.imp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.whereguesthome.mapper.AdminMapper;
import com.whereguesthome.pojo.Admin;
import com.whereguesthome.service.AdminService;

/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */
@Service
public class AdminServiceImp implements AdminService {

	@Autowired
	private AdminMapper adminMapper;

	// 查询管理员信息,执行登录
	// 测试代码
	@Override
	public boolean selectByNmae(HttpSession session,Model model, String aName, Admin admin) {
		boolean flag = false;
		Admin a = adminMapper.selectByNmae(aName);
		if (a != null) {
			if (a.getaName().equals(admin.getaName()) && a.getaPasswor().equals(admin.getaPasswor())) {
				session.setAttribute("a", a);
				flag = true;

			} else {
				model.addAttribute("b", "密码或用户名错误");
				flag = false;
			}
		} else {
			model.addAttribute("b", "密码或用户名错误");
			flag = false;
		}

		return flag;
	}

}
