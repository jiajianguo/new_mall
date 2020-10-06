package com.xdj.www.entity;

public class ShoppingPredepositWithBLOBs extends ShoppingPredeposit {
    private String pdAdminInfo;

    private String pdRemittanceInfo;

    public String getPdAdminInfo() {
        return pdAdminInfo;
    }

    public void setPdAdminInfo(String pdAdminInfo) {
        this.pdAdminInfo = pdAdminInfo == null ? null : pdAdminInfo.trim();
    }

    public String getPdRemittanceInfo() {
        return pdRemittanceInfo;
    }

    public void setPdRemittanceInfo(String pdRemittanceInfo) {
        this.pdRemittanceInfo = pdRemittanceInfo == null ? null : pdRemittanceInfo.trim();
    }
}