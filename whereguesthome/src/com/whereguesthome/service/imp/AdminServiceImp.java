package com.whereguesthome.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.whereguesthome.mapper.AdminMapper;
import com.whereguesthome.pojo.Admin;
import com.whereguesthome.service.AdminService;
/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */
@Service
public class AdminServiceImp implements AdminService{

	@Autowired
	private AdminMapper adminMapper;
	
	//查询管理员信息,执行登录
	@Override
	public boolean selectByNmae(Model model, String aName, Admin admin) {
		boolean flag = false;
		Admin a = adminMapper.selectByNmae(aName);
		if(a!=null){
			if(a.getaName().equals(admin.getaName())&&a.getaPasswor().equals(admin.getaPasswor())){
				model.addAttribute("a", a);
				flag =true;
				
			}else{
				model.addAttribute("a", "密码或用户名错误");
				flag = false;
			}
		}else{
			model.addAttribute("a", "密码或用户名错误");
			flag = false;
		}
		
		return flag;
	}

	
}
