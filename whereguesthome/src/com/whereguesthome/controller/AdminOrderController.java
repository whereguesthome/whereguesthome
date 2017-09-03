package com.whereguesthome.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whereguesthome.service.AdminOrderService;

@Controller
@RequestMapping(value="admin/order")
public class AdminOrderController {

	@Autowired
	private AdminOrderService adminOrderService;
	
	@RequestMapping(value="/" ,method=RequestMethod.GET)
	public String orderlist(Model model){
		
		adminOrderService.selectAll(model);
		return "admin/order/list";
		
	}
	
	@RequestMapping(value="xianqing" ,method=RequestMethod.POST)
	public String ordergo(Model model,Integer oId,Integer uId){
		
		adminOrderService.selectByPrimaryKey(model, oId, uId);
		return "admin/order/orderdetails";
		
	}
	
	@RequestMapping(value="{oId}/delete" ,method=RequestMethod.GET)
	public String delete(Model model,@PathVariable Integer oId){
		
		int i = adminOrderService.deleteByPrimaryKey(model, oId);
		if(i>0){
			return "redirect:/admin/order/";
		}else{
			return  "redirect:/admin/order/";
		}
		
		
	}
	
	@RequestMapping(value="dim" ,method=RequestMethod.POST)
	public String dimSelectAll(HttpServletRequest request,Model model){
		
		adminOrderService.selectAllDim(request, model);
		return "admin/order/list";
	}
}
