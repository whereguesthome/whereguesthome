package com.whereguesthome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whereguesthome.pojo.Goods;
import com.whereguesthome.service.GoodsService;

@Controller
@RequestMapping("jsp")
public class UserGoodsController {
	@Autowired
	private GoodsService goodsService;
	//用户查询所有商品信息
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String findAll(Model m,Integer gId){
		
		List<Goods> goods1=goodsService.findAll(1);	
		List<Goods> goods2=goodsService.findAll(2);	
		
		m.addAttribute("goods1", goods1);
		m.addAttribute("goods2", goods2);
		
		return "jsp/index";
	}
	@RequestMapping(value="/{gId}",method=RequestMethod.GET)
	public String selectBygId(Model m,@PathVariable Integer gId){
		Goods goodsBygId=goodsService.selectBygId(gId);
		m.addAttribute("goodsBygId", goodsBygId);
		return "jsp/product_info";
	}
}
