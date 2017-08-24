package com.whereguesthome.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.whereguesthome.pojo.Shopcar;

/**
 * 购物车持久层
 * 
 * @author hp1
 *
 */
public interface ShopcarMapper {
	// 根据用户id查询当前用户购买的商品

	public Shopcar findShopcarList(Integer id);

	// 根据商品id删除当前商品
	@Delete("DELETE FROM shopcar WHERE u_id=#{uid} and g_id=#{gid}")
	public int deleteShopcarById(Integer uid, Integer gid);

	// 根据id修改商品数量
	@Update("UPDATE shopcar SET s_num=#{s_num} WHERE u_id=#{u_id} AND g_id=#{g_id}")
	public int updateShopcarById(Shopcar shopcar);

	// 添加商品到购物车
	@Insert("INSERT INTO shopcar VALUES(#{u_id},#{g_id},#{s_num})")
	public boolean insertShopcar(Shopcar shopcar);

}
