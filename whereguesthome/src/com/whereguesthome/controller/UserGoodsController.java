package com.whereguesthome.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.whereguesthome.pojo.Goods;
import com.whereguesthome.pojo.PageBean;
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
	//查询单个商品
	@RequestMapping(value="/{gId}",method=RequestMethod.GET)
	public String selectBygId(Model m,@PathVariable Integer gId){
		Goods goodsBygId=goodsService.selectBygId(gId);
		m.addAttribute("goodsBygId", goodsBygId);
		return "jsp/product_info";
	}
	
	//商品分页
		@RequestMapping(value="product")
		public String list(Model m,Integer sId,HttpServletRequest req) throws Exception{
			PageBean<Goods> pagebean=new PageBean<>();
			pagebean.setTotalRecord(goodsService.getTotalRecord(sId));
			pagebean.setPageSize(6);
	      int pageNumber=1;
	      if (req.getParameter("pageNumber")!=null) {
	    	  pageNumber=Integer.valueOf(req.getParameter("pageNumber"));
			}
			
			pagebean.setPageNumber(pageNumber);
			int StartIndex=pagebean.getStartIndex();
			List<Goods> list=goodsService.getByPage(sId, StartIndex,pagebean.getPageSize());
			pagebean.setData(list);
			m.addAttribute("pagebean", pagebean);
			return "jsp/product_list";
		}
		
		//模糊查询
		@RequestMapping(value="list")
		public String findParam(String gName,Model m,HttpServletRequest req) throws Exception{		
			PageBean<Goods> pagebean=new PageBean<>();
			pagebean.setTotalRecord(goodsService.findParam(gName));
			pagebean.setPageSize(5);
	      int pageNumber=1;
	      if (req.getParameter("pageNumber")!=null) {
	    	  pageNumber=Integer.valueOf(req.getParameter("pageNumber"));
			}			
			pagebean.setPageNumber(pageNumber);
			int StartIndex=pagebean.getStartIndex();
			List<Goods> list=goodsService.findParamPage(gName, pagebean.getPageSize(), StartIndex);
			pagebean.setData(list);
			m.addAttribute("pagebean", pagebean);		
			return "jsp/list";
		}
}