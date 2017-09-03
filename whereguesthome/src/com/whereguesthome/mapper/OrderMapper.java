package com.whereguesthome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.whereguesthome.pojo.Order;
import com.whereguesthome.pojo.OrderItems;

public interface OrderMapper {
	int deleteByPrimaryKey(Integer oId);

	int insert(Order record);

	int insertSelective(Order record);

	Order selectByPrimaryKey(Integer oId);

	int updateByPrimaryKeySelective(Order record);

	int updateByPrimaryKey(Order record);

	// 查询未删除的订单,oDel值未0表示未删除 1已删除
	List<Order> queryOrderByOdel(Integer uId, Integer oDel);

	// 逻辑删除订单，将oDel值改为1则表示前台已经删除
	@Update("update order set o_del=#{oDel} where o_id=#{oId}")
	int delOrderByODel(Integer oId, Integer oDel);

	// 修改订单状态 0已经发货 1订单已经完成
	@Update("update order set o_Tag=#{oTag} where o_id=#{oId}")
	int updateOrderByOTag(Integer oId, Integer oTag);

	// 插入订单
	@Insert("INSERT INTO `order`(o_id,u_id,o_realname,o_address,o_phone,o_payment,o_price) "
			+ "VALUES(#{oId},#{uId},#{oRealname},#{oAddress},#{oPhone},#{oPayment},#{oPrice})")
	int insert1(Order record);

	// 获取单个订单信息对应商品信息
	OrderItems select(Integer o_orderId);

	// 根据用户id查询订单
	List<Order> selectAll(Integer uId);

	// 根据订单编号查询订单信息
	Order selectById(String o_orderId);

}
