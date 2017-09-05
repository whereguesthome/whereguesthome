package com.whereguesthome.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whereguesthome.pojo.User;
import com.whereguesthome.service.UserService;

@Controller
@RequestMapping("admin/user")
public class UpdateUserController {

	@Autowired
	private UserService userService;
	
	//查询编辑用户信息
		@RequestMapping(value="userInfo")
		public String list(HttpServletRequest req,Model m){
			User user=(User) req.getSession().getAttribute("user");
			User u=userService.findByuId(user.getuName());
			m.addAttribute("u", u);
			return "admin/user/userInfo";
		}
		
		//确认修改用户信息
		@RequestMapping(value="update",method=RequestMethod.POST )
		public String update(User us,HttpServletRequest req,Integer uId){
			User user=(User) req.getSession().getAttribute("user");			
			us.setuId(user.getuId());			
			userService.updateUser(us);
			return "redirect:/admin/user/gos";
		}
}
