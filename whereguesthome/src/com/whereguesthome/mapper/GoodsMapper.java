package com.whereguesthome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.whereguesthome.pojo.Goods;

public interface GoodsMapper {
	
	//根据ID删除商品信息
    int deleteByPrimaryKey(Integer gId);

    //插入商品信息
    int insertSelective(Goods record);

    //根据ID查询商品信息
    Goods selectByPrimaryKey(Integer gId);

    //根据ID更新商品信息
    int updateByPrimaryKeySelective(Goods record);

    //查询所有的商品信息
    @Select("select g_id gId,g_name gName,g_price gPrice,g_saleprice gSaleprice,g_describes gDescribes,"
    		+ "g_contents gContents,g_photo gPhoto,g_repertory gRepertory,g_saledate gSaledate,"
    		+ "s_id sId,g_status gStatus from goods")
    List<Goods> selectAll();
}