package com.whereguesthome.service;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.whereguesthome.pojo.Shopcar;

/**
 * ���ﳵҵ���߼�
 * 
 * @author hp1
 *
 */
public interface ShopcarService {

	// 显示当前用户所有商品信息
	public void displayShopcar(Integer id, Model model);

	// 在购物车里移除一条商品信息
	void deleteShopcarById(Integer uid, Integer gid, Model model);

	// 修改商品的数量
	void modifyShopcarIndex(Shopcar shopcar);

	// 添加商品到购物车ﳵ
	void addShopcar(Shopcar shopcar, HttpSession session, Model model);

}
