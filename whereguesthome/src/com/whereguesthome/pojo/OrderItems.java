package com.whereguesthome.pojo;

import java.util.List;

/**
 * 订单扩展类
 * 
 * @author 陈志伟
 *
 * @date Sep 4, 2017 2:50:23 AM
 */
public class OrderItems extends Order{
	private List<Goods> goods;
	private Order order;

	public List<Goods> getGoods() {
		return goods;
	}

	public void setGoods(List<Goods> goods) {
		this.goods = goods;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

}
