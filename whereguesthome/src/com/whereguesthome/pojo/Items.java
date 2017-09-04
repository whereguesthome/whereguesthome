package com.whereguesthome.pojo;

//订单项
public class Items {
    private Integer oId;//订单id

    private Integer gId;//商品id

    private Integer iCount;//数量

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

    public Integer getiCount() {
        return iCount;
    }

    public void setiCount(Integer iCount) {
        this.iCount = iCount;
    }
}