package com.whereguesthome.service;

import java.util.List;
import com.whereguesthome.pojo.Goods;

public interface GoodsService {
	    
	//根据ID删除商品信息
    int deleteByPrimaryKey(Integer gId);

    //插入商品信息
    int insertSelective(Goods record);

    //根据ID查询商品信息
    Goods selectByPrimaryKey(Integer gId);

    //根据ID更新商品信息
    int updateByPrimaryKeySelective(Goods record);

    //查询所有的商品信息
    List<Goods> selectAll();
}
