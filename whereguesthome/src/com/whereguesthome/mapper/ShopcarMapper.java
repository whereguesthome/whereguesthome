package com.whereguesthome.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
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

	public Shopcar findShopcarList(Integer id);

	// 根据用户id,商品id删除商品
	@Delete("DELETE FROM shopcar WHERE u_id=#{uid} and g_id=#{gid}")
	public int deleteShopcarById(Integer uid, Integer gid);

	// 修改商品信息
	@Update("UPDATE shopcar SET s_num=#{s_num} WHERE u_id=#{u_id} AND g_id=#{g_id}")
	public int updateShopcarById(Shopcar shopcar);

	// 添加商品ﳵ
	@Insert("INSERT INTO shopcar VALUES(#{u_id},#{g_id},#{s_num})")
	public boolean insertShopcar(Shopcar shopcar);

}
