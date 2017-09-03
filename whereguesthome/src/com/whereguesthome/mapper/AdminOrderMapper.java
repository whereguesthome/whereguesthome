package com.whereguesthome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.whereguesthome.pojo.GoodsItems;
import com.whereguesthome.pojo.Order;

public interface AdminOrderMapper {

	  	int deleteByPrimaryKey(Integer oId);

	    int insertSelective(Order record);

	    Order selectByPrimaryKey(Integer oId);

	    int updateByPrimaryKeySelective(Order record);

	    List<Order> selectAll();
	    
		List<GoodsItems> gfindAll(@Param("uId") Integer uId);
}
