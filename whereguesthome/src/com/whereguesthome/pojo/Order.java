package com.whereguesthome.pojo;

import java.util.Date;

public class Order {
    private Integer oId;

    private Integer uId;

    private String oRealname;

    private String oAddress;

    private String oZip;

    private String oPhone;

    private String oPayment;

    private String oRemarks;

    private Date oTime;

    private String oTag;

    private Double oPrice;

    public Integer getoId() {
        return oId;
    }

    public void setoId(Integer oId) {
        this.oId = oId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getoRealname() {
        return oRealname;
    }

    public void setoRealname(String oRealname) {
        this.oRealname = oRealname == null ? null : oRealname.trim();
    }

    public String getoAddress() {
        return oAddress;
    }

    public void setoAddress(String oAddress) {
        this.oAddress = oAddress == null ? null : oAddress.trim();
    }

    public String getoZip() {
        return oZip;
    }

    public void setoZip(String oZip) {
        this.oZip = oZip == null ? null : oZip.trim();
    }

    public String getoPhone() {
        return oPhone;
    }

    public void setoPhone(String oPhone) {
        this.oPhone = oPhone == null ? null : oPhone.trim();
    }

    public String getoPayment() {
        return oPayment;
    }

    public void setoPayment(String oPayment) {
        this.oPayment = oPayment == null ? null : oPayment.trim();
    }

    public String getoRemarks() {
        return oRemarks;
    }

    public void setoRemarks(String oRemarks) {
        this.oRemarks = oRemarks == null ? null : oRemarks.trim();
    }

    public Date getoTime() {
        return oTime;
    }

    public void setoTime(Date oTime) {
        this.oTime = oTime;
    }

    public String getoTag() {
        return oTag;
    }

    public void setoTag(String oTag) {
        this.oTag = oTag == null ? null : oTag.trim();
    }

    public Double getoPrice() {
        return oPrice;
    }

    public void setoPrice(Double oPrice) {
        this.oPrice = oPrice;
    }
}