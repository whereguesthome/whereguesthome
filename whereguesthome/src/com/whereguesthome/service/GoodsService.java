package com.whereguesthome.service;
import org.springframework.ui.Model;

import com.whereguesthome.pojo.Goods;

public interface GoodsService {
	    
	//根据ID删除商品信息
    int deleteByPrimaryKey(Integer gId,Model model);

    //插入商品信息
    int insertSelective(Goods record,Model model);

    //根据ID查询商品信息
    void selectByPrimaryKey(Integer gId,Model model);

    //更新商品信息
    int updateByPrimaryKeySelective(Goods record,Model model);

    //查询所有的商品信息
    void selectAll(Model model);
}
