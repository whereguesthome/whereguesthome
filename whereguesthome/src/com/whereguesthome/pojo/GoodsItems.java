package com.whereguesthome.pojo;

import java.util.Date;

public class GoodsItems {

	private Integer gId;

    private String gName;

    private Double gPrice;

    private Double gSaleprice;

    private String gDescribes;

    private String gContents;

    private String gPhoto;

    private Integer gRepertory;

    private Date gSaledate;

    private Integer sId;

    private Integer gStatus;
    private Integer iCount;
	public Integer getgId() {
		return gId;
	}
	public void setgId(Integer gId) {
		this.gId = gId;
	}
	public String getgName() {
		return gName;
	}
	public void setgName(String gName) {
		this.gName = gName;
	}
	public Double getgPrice() {
		return gPrice;
	}
	public void setgPrice(Double gPrice) {
		this.gPrice = gPrice;
	}
	public Double getgSaleprice() {
		return gSaleprice;
	}
	public void setgSaleprice(Double gSaleprice) {
		this.gSaleprice = gSaleprice;
	}
	public String getgDescribes() {
		return gDescribes;
	}
	public void setgDescribes(String gDescribes) {
		this.gDescribes = gDescribes;
	}
	public String getgContents() {
		return gContents;
	}
	public void setgContents(String gContents) {
		this.gContents = gContents;
	}
	public String getgPhoto() {
		return gPhoto;
	}
	public void setgPhoto(String gPhoto) {
		this.gPhoto = gPhoto;
	}
	public Integer getgRepertory() {
		return gRepertory;
	}
	public void setgRepertory(Integer gRepertory) {
		this.gRepertory = gRepertory;
	}
	public Date getgSaledate() {
		return gSaledate;
	}
	public void setgSaledate(Date gSaledate) {
		this.gSaledate = gSaledate;
	}
	public Integer getsId() {
		return sId;
	}
	public void setsId(Integer sId) {
		this.sId = sId;
	}
	public Integer getgStatus() {
		return gStatus;
	}
	public void setgStatus(Integer gStatus) {
		this.gStatus = gStatus;
	}
	public Integer getiCount() {
		return iCount;
	}
	public void setiCount(Integer iCount) {
		this.iCount = iCount;
	}

}