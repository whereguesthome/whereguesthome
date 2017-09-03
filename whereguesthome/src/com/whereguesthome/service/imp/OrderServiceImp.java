 package com.whereguesthome.service.imp;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.whereguesthome.mapper.OrderMapper;
import com.whereguesthome.pojo.Order;
import com.whereguesthome.service.OrderService;

@Service("orderSer")
public class OrderServiceImp implements OrderService{

	//注入Mapper
	@Autowired
	private OrderMapper orderMapper;
	
	@Override
	public List<Order> queryOrderByOdel(Integer uId, Integer oDel) {
		return orderMapper.queryOrderByOdel(uId, oDel);
	}

	@Override
	public int delOrderByODel(Integer oId, Integer oDel) {
		return orderMapper.delOrderByODel(oId, oDel);
	}

	@Override
	public int updateOrderByOTag(Integer oId, Integer oTag) {
		return orderMapper.updateOrderByOTag(oId, oTag);
	}
	
	

}
