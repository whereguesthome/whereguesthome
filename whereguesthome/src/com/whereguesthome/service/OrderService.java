package com.whereguesthome.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.whereguesthome.pojo.Order;

public interface OrderService {

	// 查询未删除的订单,oDel值未0表示未删除 1已删除
	List<Order> queryOrderByOdel(Integer uId, Integer oDel);

	// 逻辑删除订单，将oDel值改为1则表示前台已经删除
	int delOrderByODel(Integer oId, Integer oDel);

	// 修改订单状态 0已经发货 1订单已经完成
	int updateOrderByOTag(Integer oId, Integer oTag);

	// 提交订单
	void submitOrder(Order order, Integer[] gid,HttpSession session);

	// 获取所有订单信息
	void selectByPrimaryKey(Model model, HttpSession session);

}
