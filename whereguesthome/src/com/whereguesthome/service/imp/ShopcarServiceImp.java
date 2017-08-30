package com.whereguesthome.service.imp;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;

import com.whereguesthome.mapper.ShopcarMapper;
import com.whereguesthome.pojo.Shopcar;

import com.whereguesthome.pojo.User;
import com.whereguesthome.service.ShopcarService;

/**
 * ���ﳵҵ���߼�ʵ��
 * 
 * @author hp1
 *
 */
public class ShopcarServiceImp implements ShopcarService {
	@Autowired
	private ShopcarMapper shopcarMapper;

	// 点击购物车显示当前用户购物车的商品列表
	@Override
	public void displayShopcar(Model model, HttpSession session) {
		// 从数据库获取当前用户商品的列表
		// 获取用户session信息
		User user = (User) session.getAttribute("user");
		if (user == null) {
			model.addAttribute("msg", "请登录");
		} else {
			List<Shopcar> shopcar = shopcarMapper.findShopcarList(user.getuId());
			model.addAttribute("shopcar", shopcar);
		}
	}

	// 根据用户id,商品id确定商品的唯一性
	// 页面传过来的商品id,用户把商品从当前用户购物车中清除
	// 批量删除循环执行以下方法
	@Override
	public void deleteShopcarById(Integer uid, Integer gid, Model model) {
		String msg = null;
		if (uid != null && gid != null) {
			int a = shopcarMapper.deleteShopcarById(uid, gid);
			msg = "商品删除成功,编号为" + a + "";
			model.addAttribute("msg", msg);
		} else {
			msg = "商品删除失败,因为id为空";
			model.addAttribute("msg", msg);
		}

	}

	// 修改商品的数量
	// 只能添加商品数量
	@Override
	public void modifyShopcarIndex(Shopcar shopcar) {
		if (shopcar != null) {
			shopcarMapper.updateShopcarById(shopcar);
		}
	}

	// 添加商品到购物车
	// 判断用户购物车是否登录
	// 如果登录可以添加到购物车
	// 如果没有登录不可以添加到购物车
	@Override
	public void addShopcar(Shopcar shopcar, HttpSession session, HttpServletResponse response) {
		// 获取session
		String msg = null;
		User user = (User) session.getAttribute("user");
		try {
			if (user == null) {
				msg = "用户未登录,不可以添加到购物车";
				response.getWriter().write(msg);
			} else {
				shopcarMapper.insertShopcar(shopcar);
				msg = "添加购物车成功";
				response.getWriter().write(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
