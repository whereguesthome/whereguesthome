package com.whereguesthome.service;

import com.whereguesthome.pojo.Shopcar;

/**
 * 购物车业务逻辑
 * 
 * @author hp1
 *
 */

public interface ShopcarService {

	// 购物车商品列表显示模块
	public Shopcar displayShopcar();

	// 把商品从购物车删除出去
	public int deleteShopcarById(Integer uid, Integer gid);

	// 修改购物车当前商品的数量
	public int modifyShopcarIndex(Shopcar shopcar);

	// 添加商品到购物车
	public void addShopcar(Shopcar shopcar);
	

}
