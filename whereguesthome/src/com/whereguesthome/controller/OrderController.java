package com.whereguesthome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whereguesthome.service.OrderService;

@Controller
@RequestMapping("admin/user")
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	
//查询未删除的订单,oDel值未0表示未删除 1已删除
	@RequestMapping(value="/")
	public String queryOrderByOdel(Integer uId,Integer oDel){
		orderService.queryOrderByOdel(uId, oDel);
		return "admin/user/order";
	}
	
	//逻辑删除订单，将oDel值改为1则表示前台已经删除
	public String delOrderByODel(Integer oId,Integer oDel){
		orderService.delOrderByODel(oId, oDel);
		return "redirect:/admin/user/order";
	}
	
	//修改订单状态 0已经发货 1订单已经完成
	public String updateOrderByOTag(Integer oId, Integer oTag){
		orderService.updateOrderByOTag(oId, oTag);
		return "redirect:/admin/user/order";
	} 
	
	@RequestMapping(value="gos",method=RequestMethod.GET)
	public String gocontent(){
		return "admin/user/content";
	}
	
	

}
