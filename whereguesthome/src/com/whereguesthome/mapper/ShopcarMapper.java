package com.whereguesthome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import com.whereguesthome.pojo.Shopcar;

/**
 * 购物车Service
 * 
 * @author hp1
 *
 */
public interface ShopcarMapper {
	// 根据用户id查询所有商品

	public List<Shopcar> findShopcarList(Integer id);

	// 根据用户id,商品id删除商品
	@Delete("DELETE FROM shopcar WHERE u_id=#{uid} and g_id=#{gid}")
	public int deleteShopcarById(@Param("uid") Integer uid, @Param("gid") Integer gid);

	// 修改商品信息
	@Update("UPDATE shopcar SET s_num=#{s_num} WHERE u_id=#{u_id} AND g_id=#{g_id}")
	public int updateShopcarById(Shopcar shopcar);

	// 添加商品ﳵ
	@Insert("INSERT INTO shopcar VALUES(#{u_id},#{g_id},#{s_num})")
	public void insertShopcar(Shopcar shopcar);

	// 根据商品id和用户id查询数据
	public Shopcar findShopcarList1(@Param("u_id") Integer u_id, @Param("g_id") Integer g_id);
}
