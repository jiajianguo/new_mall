package com.xdj.www.entity;

public class ShoppingEvaluateWithBLOBs extends ShoppingEvaluate {
    private String evaluateAdminInfo;

    private String evaluateInfo;

    private String evaluateSellerInfo;

    private String goodsSpec;

    private ShoppingUser evaluate_user;
    //评价商品
    private ShoppingGoodsWithBLOBs evaluate_goods;

    //订单
    private ShoppingOrderformWithBLOBs of;

    public ShoppingOrderformWithBLOBs getOf() {
        return of;
    }

    public void setOf(ShoppingOrderformWithBLOBs of) {
        this.of = of;
    }

    public ShoppingGoodsWithBLOBs getEvaluate_goods() {
        return evaluate_goods;
    }

    public void setEvaluate_goods(ShoppingGoodsWithBLOBs evaluate_goods) {
        this.evaluate_goods = evaluate_goods;
    }

    public ShoppingUser getEvaluate_user() {
        return evaluate_user;
    }

    public void setEvaluate_user(ShoppingUser evaluate_user) {
        this.evaluate_user = evaluate_user;
    }

    public String getEvaluateAdminInfo() {
        return evaluateAdminInfo;
    }

    public void setEvaluateAdminInfo(String evaluateAdminInfo) {
        this.evaluateAdminInfo = evaluateAdminInfo == null ? null : evaluateAdminInfo.trim();
    }

    public String getEvaluateInfo() {
        return evaluateInfo;
    }

    public void setEvaluateInfo(String evaluateInfo) {
        this.evaluateInfo = evaluateInfo == null ? null : evaluateInfo.trim();
    }

    public String getEvaluateSellerInfo() {
        return evaluateSellerInfo;
    }

    public void setEvaluateSellerInfo(String evaluateSellerInfo) {
        this.evaluateSellerInfo = evaluateSellerInfo == null ? null : evaluateSellerInfo.trim();
    }

    public String getGoodsSpec() {
        return goodsSpec;
    }

    public void setGoodsSpec(String goodsSpec) {
        this.goodsSpec = goodsSpec == null ? null : goodsSpec.trim();
    }
}
