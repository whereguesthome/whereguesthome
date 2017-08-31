package com.whereguesthome.pojo;



public class Shopcar {
	private Integer u_id;
	private Integer g_id;
	private Integer s_num;
	private User user;// �û���Ϣ
	private Goods goods;

	public Integer getU_id() {
		return u_id;
	}

	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}

	public Integer getG_id() {
		return g_id;
	}

	public void setG_id(Integer g_id) {
		this.g_id = g_id;
	}

	public Integer getS_num() {
		return s_num;
	}

	public void setS_num(Integer s_num) {
		this.s_num = s_num;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

}
