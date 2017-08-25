package com.whereguesthome.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whereguesthome.mapper.GoodsMapper;
import com.whereguesthome.pojo.Goods;
import com.whereguesthome.service.GoodsService;

@Service
public class GoodsServiceImp implements GoodsService {

	@Autowired
	private GoodsMapper goodsMapper;

	// 查询所有的商品信息
	@Override
	public List<Goods> selectAll() {
		return goodsMapper.selectAll();
	}

	// 根据ID删除商品信息
	@Override
	public int deleteByPrimaryKey(Integer gId) {
		return goodsMapper.deleteByPrimaryKey(gId);
	}

	// 添加商品信息
	@Override
	public int insertSelective(Goods record) {
		return goodsMapper.insertSelective(record);
	}

	// 根据ID查询商品信息
	@Override
	public Goods selectByPrimaryKey(Integer gId) {
		return goodsMapper.selectByPrimaryKey(gId);
	}

	// 根据ID更新商品信息
	@Override
	public int updateByPrimaryKeySelective(Goods record) {
		return goodsMapper.updateByPrimaryKeySelective(record);
	}
   
	//用户查看所有商品信息
	@Override
	public List<Goods> findAll(Integer  gId) {		
		
		return goodsMapper.findAll(gId);
	}
	//用户查看单个商品信息
	@Override
	public Goods selectBygId(Integer gId) {
		
		return goodsMapper.selectBygId(gId);
	}
}
