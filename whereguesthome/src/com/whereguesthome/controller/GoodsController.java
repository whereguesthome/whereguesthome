package com.whereguesthome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.whereguesthome.pojo.Goods;
import com.whereguesthome.service.GoodsService;

@Controller
@RequestMapping("admin/product")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	//查询所有的商品
	@RequestMapping(value="/")
	public String findAll(Model model){
		
		List<Goods> goodslist = goodsService.selectAll();
		model.addAttribute("goodslist", goodslist);
		return "admin/product/list";
	}

	//商品的添加
	@RequestMapping(value="/add")
	public String add(Model model){
		
		return "admin/product/add";
	}
}
