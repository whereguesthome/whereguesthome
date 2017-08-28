package com.whereguesthome.controller;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whereguesthome.pojo.Sort;
import com.whereguesthome.service.SortService;

/**
 * @author GongZhen
 *
 * @date 2017年8月25日
 */

@Controller
@RequestMapping("admin/category")
public class SortController {

	@Autowired
	private SortService sortService;

	// 查看所有分类的信息
	@RequestMapping(value = "/")
	public String selectAll(Model model) {
		sortService.SelectAll(model);
		return "admin/category/list";
	}

	// 跳转到添加分类页面
	@RequestMapping("add")
	public String add() {
		return "admin/category/add";
	}

	//添加成功跳转到分类首页
	@RequestMapping(value="addgo",method=RequestMethod.POST)
	public String insertSelective(Sort record,Model model){
		
		boolean flag = sortService.insertSelective(record, model);
		if(flag){
		return "redirect:/admin/category/";
	}else{
		return "redirect:add";
	}
	
}
	//跳转到编辑页面
	@RequestMapping(value="{sId}",method=RequestMethod.GET)
	public String selectByPrimaryKey(@PathVariable Integer sId, Model model){
		sortService.selectByPrimaryKey(sId, model);
		return "admin/category/edit";
	}
	
	//更新分类信息
	@RequestMapping(value="editgo",method=RequestMethod.POST)
	public String updateByPrimaryKeySelective(Sort record, Model model){
		int a = sortService.updateByPrimaryKeySelective(record, model);
		if(a>0){
			return "redirect:/admin/category/";
		}else{
			return "admin/category/edit";
		}	
	}
	
	@RequestMapping(value="{sId}/delete",method=RequestMethod.GET)
	public String deleteByPrimaryKey(@PathVariable Integer sId, Model model) throws IOException{
		int a = sortService.deleteByPrimaryKey(sId, model);
		
		if(a>0){
			return "redirect:/admin/category/";
			
		}else{
			return "redirect:/admin/category/";
		}	
	}
	
}
