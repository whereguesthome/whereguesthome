package com.whereguesthome.pojo;

/**
 * 用户扩展类
 * 
 * @author 陈志伟
 *
 * @date Aug 29, 2017 5:55:54 PM
 */
public class UserCustom extends User {
	private int page = 1;// 当前页码
	private int pagesize;// 分页总页数

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

}
