package com.whereguesthome.pojo;

import java.util.Date;
//商品实体类
public class Goods {
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
    
    private Sort sort;

    public Sort getSort() {
		return sort;
	}

	public void setSort(Sort sort) {
		this.sort = sort;
	}

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
        this.gName = gName == null ? null : gName.trim();
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
        this.gDescribes = gDescribes == null ? null : gDescribes.trim();
    }

    public String getgContents() {
        return gContents;
    }

    public void setgContents(String gContents) {
        this.gContents = gContents == null ? null : gContents.trim();
    }

    public String getgPhoto() {
        return gPhoto;
    }

    public void setgPhoto(String gPhoto) {
        this.gPhoto = gPhoto == null ? null : gPhoto.trim();
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
}