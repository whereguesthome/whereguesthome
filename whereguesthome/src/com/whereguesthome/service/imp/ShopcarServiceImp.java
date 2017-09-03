package com.whereguesthome.service.imp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.whereguesthome.mapper.ShopcarMapper;
import com.whereguesthome.pojo.Shopcar;
import com.whereguesthome.pojo.ShopcarQueryVo;
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
			/*
			 * List<Shopcar> shopcar =
			 * shopcarMapper.findShopcarList(user.getuId());
			 */
			List<Shopcar> shopcar = shopcarMapper.findShopcarList(13);
			model.addAttribute("shopcar", shopcar);
		}
	}

	// 根据用户id,商品id确定商品的唯一性
	// 页面传过来的商品id,用户把商品从当前用户购物车中清除
	// 批量删除循环执行以下方法
	@Override
	public void deleteShopcarById(Integer[] gid, Model model, HttpSession session) {
		String msg = null;
		// 获取用户session信息
		User user = (User) session.getAttribute("user");
		if (user != null && gid != null) {
			for (int i : gid) {
				shopcarMapper.deleteShopcarById(user.getuId(), i);
			}
			msg = "商品删除成功,编号为";
			model.addAttribute("msg", msg);
		} else {
			msg = "商品删除失败,因为id为空";
			model.addAttribute("msg", msg);
		}

	}

	// 修改商品的数量
	// 只能添加商品数量
	// 提交订单
	@Override
	public void modifyShopcarIndex(Integer[] gid, HttpSession session, Double sums, Model model) {
		User user = (User) session.getAttribute("user");
		List<Shopcar> shopcar1 = new ArrayList<>();
		Shopcar shopcar = null;
		if (gid != null) {
			for (Integer i : gid) {
				shopcar = shopcarMapper.findShopcarList1(user.getuId(), i);
				shopcar1.add(shopcar);
			}
		}
		if (sums != null) {
			session.setAttribute("sums", sums);
		}
		model.addAttribute("shopcar1", shopcar1);

	}

	// 添加商品到购物车
	// 判断用户购物车是否登录
	// 如果登录可以添加到购物车
	// 如果没有登录不可以添加到购物车
	@Override
	public void addShopcar(Shopcar shopcar, HttpSession session, HttpServletResponse response) {
		// 获取session
		String msg = null;
		int a = 0;// 商品默认不存在
		int b = 0;// 购物车同种商品的数量
		if (shopcar.getU_id() == null) {
			msg = "用户未登录,不可以添加到购物车";
		} else {
			// 判断当前用户购买商品是否已经存在
			List<Shopcar> shopcar1 = shopcarMapper.findShopcarList(shopcar.getU_id());
			for (Shopcar shopcar2 : shopcar1) {
				if (shopcar.getG_id().equals(shopcar2.getGoods().getgId())) {
					a = 1;
					b = shopcar2.getS_num();
				}
			}
			if (a == 1) {
				shopcar.setS_num(b + shopcar.getS_num());
				shopcarMapper.updateShopcarById(shopcar);
				msg = "商品添加成功";
			}
			if (a == 0) {
				shopcarMapper.insertShopcar(shopcar);
				msg = "商品添加成功";
			}
		}
		try {
			response.getWriter().write(msg);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
