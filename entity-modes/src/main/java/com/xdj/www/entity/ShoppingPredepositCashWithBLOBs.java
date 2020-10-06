package com.xdj.www.entity;

public class ShoppingPredepositCashWithBLOBs extends ShoppingPredepositCash {
    private String cashAdminInfo;

    private String cashInfo;

    //现金支付用户
    private ShoppingUser cash_user;

    //管理用户
    private ShoppingUser cash_admin;

    public ShoppingUser getCash_admin() {
        return cash_admin;
    }

    public void setCash_admin(ShoppingUser cash_admin) {
        this.cash_admin = cash_admin;
    }

    public ShoppingUser getCash_user() {
        return cash_user;
    }

    public void setCash_user(ShoppingUser cash_user) {
        this.cash_user = cash_user;
    }

    public String getCashAdminInfo() {
        return cashAdminInfo;
    }

    public void setCashAdminInfo(String cashAdminInfo) {
        this.cashAdminInfo = cashAdminInfo == null ? null : cashAdminInfo.trim();
    }

    public String getCashInfo() {
        return cashInfo;
    }

    public void setCashInfo(String cashInfo) {
        this.cashInfo = cashInfo == null ? null : cashInfo.trim();
    }
}