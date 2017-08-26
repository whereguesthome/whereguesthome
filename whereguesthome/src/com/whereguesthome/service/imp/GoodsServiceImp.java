package com.whereguesthome.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.whereguesthome.mapper.GoodsMapper;
import com.whereguesthome.pojo.Goods;
import com.whereguesthome.service.GoodsService;

@Service
public class GoodsServiceImp implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	// 查询所有的商品信息
	@Override
	public void selectAll(Model model) {
		List<Goods> goodslist = goodsMapper.selectAll();
		model.addAttribute("goodslist", goodslist);
	}

	// 根据ID删除商品信息
	@Override
	public int deleteByPrimaryKey(Integer gId,Model model) {
		String msg = null;
		int i = goodsMapper.deleteByPrimaryKey(gId);
		int a = 0;
		if(i>0){
			msg="删除成功！";
			model.addAttribute("msg", msg);
			a = 1;
		}else{
			msg="删除成功！";
			model.addAttribute("msg", msg);
			a = 0;
		}
		return a;
	}

	// 添加商品信息
	@Override
	public int insertSelective(Goods record,Model model) {
		String msg = null;
		int i = goodsMapper.insertSelective(record);
		int a = 0;
		if(i>0){
			msg = "添加成功!";
			model.addAttribute("msg", msg);
			a = 1;
			
		}else{
			msg = "添加失败!";
			model.addAttribute("msg", msg);
			a = 0;
		}
		return a;
	}

	// 根据ID查询商品信息
	@Override
	public void selectByPrimaryKey(Integer gId,Model model) {
		Goods goods = goodsMapper.selectByPrimaryKey(gId);
		String msg = null;
		if(goods!=null){
			model.addAttribute("goods", goods);
			
		}else{
			msg = "没有改商品信息";
			model.addAttribute("msg", msg);
		}
	}

	// 根据ID更新商品信息
	@Override
	public int updateByPrimaryKeySelective(Goods record,Model model) {
		String msg = null;
		int a = 0;
		
		int i = goodsMapper.updateByPrimaryKeySelective(record);
		
		if(i>0){
			msg= "更新成功！";
			model.addAttribute("msg", msg);
			a = 1;
		}else{
			msg= "更新失败！";
			model.addAttribute("msg", msg);
			a = 0;
		}
		return a;
		
	}

}
