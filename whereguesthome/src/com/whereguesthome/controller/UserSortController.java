package com.whereguesthome.controller;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whereguesthome.service.SortService;

@Controller
@RequestMapping("jsp")
public class UserSortController {
	@Autowired
	  private SortService sortService;
		
		//查询所有商品分类
		@RequestMapping(value="index",method=RequestMethod.POST)
		public void findAll(HttpServletResponse res) throws Exception{
			res.setContentType("text/html; charset=UTF-8");
			
			String value=sortService.findJosn();
			
			res.getWriter().println(value);
		}
	}


