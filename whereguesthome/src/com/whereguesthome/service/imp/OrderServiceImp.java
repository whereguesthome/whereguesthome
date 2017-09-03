package com.whereguesthome.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.whereguesthome.mapper.AdminMapper;
import com.whereguesthome.mapper.AdminOrderMapper;
import com.whereguesthome.mapper.ItemsMapper;
import com.whereguesthome.mapper.OrderMapper;
import com.whereguesthome.mapper.ShopcarMapper;
import com.whereguesthome.md5.paymentID;
import com.whereguesthome.pojo.GoodsItems;
import com.whereguesthome.pojo.Items;
import com.whereguesthome.pojo.Order;
import com.whereguesthome.pojo.OrderItems;
import com.whereguesthome.pojo.Shopcar;
import com.whereguesthome.pojo.User;
import com.whereguesthome.service.OrderService;

@Service("orderSer")
public class OrderServiceImp implements OrderService {

	// 注入Mapper
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private ShopcarMapper shopcarMapper;
	@Autowired
	private ItemsMapper itemsMapper;

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

	// 提交订单
	@Override
	public void submitOrder(Order order, Integer[] gid, HttpSession session) {
		// 获取用户session信息
		User user = (User) session.getAttribute("user");
		Items items = new Items();
		// 生成订单编号
		String string = paymentID.getpaymentID();
		if (order != null) {
			/* order.setoTime(new Date()); */
			order.setO_orderId(string);
			order.setoTag("未发货");
			orderMapper.insertSelective(order);
		}
		// 根据订单编号查询商品列表
		Order order1 = orderMapper.selectById(string);
		// 添加到订单项表
		items.setoId(order1.getoId());
		// 删除购物车里确认的订单
		if (gid != null) {
			for (Integer integer : gid) {
				// 添加数量到订单项
				Shopcar shopcar = shopcarMapper.findShopcarList1(user.getuId(), integer);
				items.setiCount(shopcar.getS_num());
				shopcarMapper.deleteShopcarById(order.getuId(), integer);
				// 商品添加到订单项
				items.setgId(integer);
				itemsMapper.insertSelective(items);
			}
		}
	}

	// 获取订单所有信息
	@Override
	public void selectByPrimaryKey(Model model, HttpSession session) {
		List<OrderItems> list1 = new ArrayList<OrderItems>();
		// 获取用户session信息
		User user = (User) session.getAttribute("user");
		// 获取当前用户所有订单的id

		List<Order> list = orderMapper.selectAll(user.getuId());
		for (Order order : list) {
			// 获取当前用户所有订单的id
			OrderItems orderItems = orderMapper.select(order.getoId());
			if (orderItems != null) {
				orderItems.setOrder(order);
			}

			list1.add(orderItems);
		}
		model.addAttribute("list1", list1);

	}

}
