package com.whereguesthome.pojo;

public class Address {
    private Integer pId;

    private Integer uId;

    private String pAddress;

    private String pPhone;

    private String pRealname;

    private String pZip;

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getuId() {
        return uId;
    }

    public void setuId(Integer uId) {
        this.uId = uId;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress == null ? null : pAddress.trim();
    }

    public String getpPhone() {
        return pPhone;
    }

    public void setpPhone(String pPhone) {
        this.pPhone = pPhone == null ? null : pPhone.trim();
    }

    public String getpRealname() {
        return pRealname;
    }

    public void setpRealname(String pRealname) {
        this.pRealname = pRealname == null ? null : pRealname.trim();
    }

    public String getpZip() {
        return pZip;
    }

    public void setpZip(String pZip) {
        this.pZip = pZip == null ? null : pZip.trim();
    }
}