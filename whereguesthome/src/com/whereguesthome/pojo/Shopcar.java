package com.whereguesthome.pojo;

import java.util.List;

public class Shopcar {

	private int u_id;// �û�id
	private int g_id;// ��Ʒid
	private int s_num;// ��Ʒ����
	private User user;// �û���Ϣ
	private List<Goods> list;// ��Ʒ�б�

	public int getU_id() {
		return u_id;
	}

	public void setU_id(int u_id) {
		this.u_id = u_id;
	}

	public int getG_id() {
		return g_id;
	}

	public void setG_id(int g_id) {
		this.g_id = g_id;
	}

	public int getS_num() {
		return s_num;
	}

	public void setS_num(int s_num) {
		this.s_num = s_num;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Goods> getList() {
		return list;
	}

	public void setList(List<Goods> list) {
		this.list = list;
	}

}
