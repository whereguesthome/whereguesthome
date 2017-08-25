package com.whereguesthome.service;

import com.whereguesthome.pojo.Shopcar;

/**
 * ���ﳵҵ���߼�
 * 
 * @author hp1
 *
 */
public interface ShopcarService {

	// 显示当前用户所有商品信息
	public Shopcar displayShopcar();

	// 在购物车里移除一条商品信息
	public int deleteShopcarById(Integer uid, Integer gid);

	//修改商品的数量
	public int modifyShopcarIndex(Shopcar shopcar);

	// 添加商品到购物车ﳵ
	public void addShopcar(Shopcar shopcar);

}
