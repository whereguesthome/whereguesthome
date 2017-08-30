package com.whereguesthome.pojo;

import java.util.List;

public class Sort {
	private Integer sId;

	private String sName;

	private List<Goods> listGoods;

	public List<Goods> getListGoods() {
		return listGoods;
	}

	public void setListGoods(List<Goods> listGoods) {
		this.listGoods = listGoods;
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName == null ? null : sName.trim();
	}
}