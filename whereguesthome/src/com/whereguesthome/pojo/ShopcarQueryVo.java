package com.whereguesthome.pojo;

import java.util.List;

/**
 * 购物车包装类
 * 
 * @author 陈志伟
 *
 * @date Sep 2, 2017 4:13:40 PM
 */
public class ShopcarQueryVo {

	private Shopcar shopcar;
	//批量购物车信息
	private List<Shopcar> shopcars;

	public Shopcar getShopcar() {
		return shopcar;
	}

	public void setShopcar(Shopcar shopcar) {
		this.shopcar = shopcar;
	}

	public List<Shopcar> getShopcars() {
		return shopcars;
	}

	public void setShopcars(List<Shopcar> shopcars) {
		this.shopcars = shopcars;
	}

}
