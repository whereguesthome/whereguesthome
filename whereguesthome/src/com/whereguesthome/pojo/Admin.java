package com.whereguesthome.pojo;


public class Admin {
    private Integer aId;

    private String aName;

    private String aPasswor;

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getaName() {
        return aName;
    }

    public void setaName(String aName) {
        this.aName = aName == null ? null : aName.trim();
    }

    public String getaPasswor() {
        return aPasswor;
    }

    public void setaPasswor(String aPasswor) {
        this.aPasswor = aPasswor == null ? null : aPasswor.trim();
    }
}