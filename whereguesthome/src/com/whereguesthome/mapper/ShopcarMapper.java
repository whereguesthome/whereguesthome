package com.whereguesthome.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import com.whereguesthome.pojo.Shopcar;

/**
 * ���ﳵ�־ò�
 * 
 * @author hp1
 *
 */
public interface ShopcarMapper {
	// �����û�id��ѯ��ǰ�û��������Ʒ

	public Shopcar findShopcarList(Integer id);

	// ������Ʒidɾ����ǰ��Ʒ
	@Delete("DELETE FROM shopcar WHERE u_id=#{uid} and g_id=#{gid}")
	public int deleteShopcarById(Integer uid, Integer gid);

	// ����id�޸���Ʒ����
	@Update("UPDATE shopcar SET s_num=#{s_num} WHERE u_id=#{u_id} AND g_id=#{g_id}")
	public int updateShopcarById(Shopcar shopcar);

	// �����Ʒ�����ﳵ
	@Insert("INSERT INTO shopcar VALUES(#{u_id},#{g_id},#{s_num})")
	public boolean insertShopcar(Shopcar shopcar);

}
