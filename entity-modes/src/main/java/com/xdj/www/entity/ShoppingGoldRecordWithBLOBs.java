package com.xdj.www.entity;

public class ShoppingGoldRecordWithBLOBs extends ShoppingGoldRecord {
    private String goldAdminInfo;

    private String goldExchangeInfo;

    public String getGoldAdminInfo() {
        return goldAdminInfo;
    }

    public void setGoldAdminInfo(String goldAdminInfo) {
        this.goldAdminInfo = goldAdminInfo == null ? null : goldAdminInfo.trim();
    }

    public String getGoldExchangeInfo() {
        return goldExchangeInfo;
    }

    public void setGoldExchangeInfo(String goldExchangeInfo) {
        this.goldExchangeInfo = goldExchangeInfo == null ? null : goldExchangeInfo.trim();
    }
}