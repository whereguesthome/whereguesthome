package com.whereguesthome.controller;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.whereguesthome.pojo.Goods;
import com.whereguesthome.service.GoodsService;
import com.whereguesthome.service.SortService;

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
	
	@Autowired
	private SortService sortService;
	//查询所有的商品
	@RequestMapping(value="/")
	public String findAll(Model model){
		
		goodsService.selectAll(model);
		/*goodsService.selectlistSort(model);*/
		return "admin/product/list";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.GET)
	public String add(Model model){
		sortService.SelectAll(model);
		return "admin/product/add";
	}
	
	//商品的添加
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	public String addgo(HttpServletRequest request,Model model,Goods record,MultipartFile photo) throws IOException{
		
		int i = goodsService.insertSelective(request,photo,record, model);
		if(i>0){
			return "redirect:/admin/product/";
		}else{
			return "admin/product/add";
		}
		
	}
	
	//商品的编辑
	@RequestMapping(value="{gId}",method=RequestMethod.GET)
	public String binaji(@PathVariable Integer gId, Model model) throws IOException{
			
		goodsService.selectByPrimaryKey(gId, model);
			
		return "admin/product/edit";
			
		}
}
