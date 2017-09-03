package com.whereguesthome.service;

import org.springframework.ui.Model;

import com.whereguesthome.pojo.Order;

public interface AdminOrderService {

	int deleteByPrimaryKey(Model model,Integer oId);

    int insertSelective(Order record);

    void selectByPrimaryKey(Model model,Integer oId,Integer uId);

    int updateByPrimaryKeySelective(Order record);

    void selectAll(Model model);
	
}
