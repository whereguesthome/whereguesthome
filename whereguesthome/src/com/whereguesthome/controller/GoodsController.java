package com.whereguesthome.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.whereguesthome.service.GoodsService;

/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */
@Controller
@RequestMapping("admin/product")
public class GoodsController {

	@Autowired
	private GoodsService goodsService;
	
	//查询所有的商品
	@RequestMapping(value="/")
	public String findAll(Model model){
		
		goodsService.selectAll(model);
		return "admin/product/list";
	}

	//商品的添加
	@RequestMapping(value="/add")
	public String add(Model model){
		
		return "admin/product/add";
	}
}
