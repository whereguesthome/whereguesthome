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

@Controller
@RequestMapping("admin")
@SessionAttributes("a")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@RequestMapping(value="/denglu",method=RequestMethod.POST)
	public String findById(Model model,String aName,Admin admin){
		
		Admin a = adminService.selectByNmae(aName);
		if(a.getaName().equals(admin.getaName())&&a.getaPasswor().equals(admin.getaPasswor())){
			model.addAttribute("a", a);
			return "admin/home";
			
		}else{
			model.addAttribute("a", "鐧诲綍澶辫触");
			return "admin/index";
		}
	}
	
	
	@RequestMapping(value="/zhuxiao",method=RequestMethod.GET)
	public String outLogin(HttpSession session,SessionStatus sessionStatus){
        session.removeAttribute("a");//我这里是先取出httpsession中的user属性
        session.invalidate();  //然后是让httpsession失效
        sessionStatus.setComplete();//最后是调用sessionStatus方法
        return "admin/index";
    }
	
	@RequestMapping(value="/shouye")
	public String denglu(){
        return "admin/index";
    }
	
	@RequestMapping(value="topa",method=RequestMethod.GET)
	public String top(){
		return "admin/top";
	}
	
	@RequestMapping(value="lefta",method=RequestMethod.GET)
	public String left(){
		return "admin/left";
	}
	
	@RequestMapping(value="bottoma",method=RequestMethod.GET)
	public String bottom(){
		return "admin/bottom";
	}
	
	@RequestMapping(value="welcomea",method=RequestMethod.GET)
	public String welcome(){
		return "admin/welcome";
	}
	
	
}
