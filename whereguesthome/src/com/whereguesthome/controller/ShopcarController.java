package com.whereguesthome.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whereguesthome.pojo.Shopcar;
import com.whereguesthome.service.ShopcarService;

@Controller
@RequestMapping("jsp/")
public class ShopcarController {
	@Autowired
	private ShopcarService shopcarService;

	// ajax请求添加到购物车
	@RequestMapping(value = "addShopcar", method = RequestMethod.POST)
	public void addShopcar(Shopcar shopcar, HttpSession session, HttpServletResponse response) {
		shopcarService.addShopcar(shopcar, session, response);
	}

	// 显示当前购物车所有信息
	@RequestMapping(value = "cart", method = RequestMethod.GET)
	public String showShopcar(Model model, HttpSession session) {
		System.out.println("你好");
		shopcarService.displayShopcar(model, session);
		return "jsp/cart";
	}

	// 批量删除购物车的一条数据
	@RequestMapping(value = "cart/delete", method = RequestMethod.POST)
	public String delete(Integer[] gid, Model model, HttpSession session) {
		shopcarService.deleteShopcarById(gid, model, session);
		return "redirect:/jsp/cart";
	}

	// 修改商品的数量
	@RequestMapping(value = "cart/modify", method = RequestMethod.POST)
	public void modify(Shopcar shopcar) {
		shopcarService.modifyShopcarIndex(shopcar);
	}

}
