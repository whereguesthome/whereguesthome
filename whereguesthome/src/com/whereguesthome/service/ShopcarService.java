package com.whereguesthome.service;

import com.whereguesthome.pojo.Shopcar;

/**
 * ���ﳵҵ���߼�
 * 
 * @author hp1
 *
 */

public interface ShopcarService {

	// ���ﳵ��Ʒ�б���ʾģ��
	public Shopcar displayShopcar();

	// ����Ʒ�ӹ��ﳵɾ����ȥ
	public int deleteShopcarById(Integer uid, Integer gid);

	// �޸Ĺ��ﳵ��ǰ��Ʒ������
	public int modifyShopcarIndex(Shopcar shopcar);

	// �����Ʒ�����ﳵ
	public void addShopcar(Shopcar shopcar);
	

}
