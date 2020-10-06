package com.xdj.www.entity;

public class ShoppingReportWithBLOBs extends ShoppingReport {
    private String content;

    private String handleInfo;

    //用户
    private ShoppingUser user;

    //商品
    private ShoppingGoodsWithBLOBs goods;

    private ShoppingReportSubject subject;

    //附件1
    private ShoppingAccessory acc1;

    //附件2
    private ShoppingAccessory acc2;

    //附件3
    private ShoppingAccessory acc3;

    public ShoppingUser getUser() {
        return user;
    }

    public void setUser(ShoppingUser user) {
        this.user = user;
    }

    public ShoppingGoodsWithBLOBs getGoods() {
        return goods;
    }

    public void setGoods(ShoppingGoodsWithBLOBs goods) {
        this.goods = goods;
    }

    public ShoppingReportSubject getSubject() {
        return subject;
    }

    public void setSubject(ShoppingReportSubject subject) {
        this.subject = subject;
    }

    public ShoppingAccessory getAcc1() {
        return acc1;
    }

    public void setAcc1(ShoppingAccessory acc1) {
        this.acc1 = acc1;
    }

    public ShoppingAccessory getAcc2() {
        return acc2;
    }

    public void setAcc2(ShoppingAccessory acc2) {
        this.acc2 = acc2;
    }

    public ShoppingAccessory getAcc3() {
        return acc3;
    }

    public void setAcc3(ShoppingAccessory acc3) {
        this.acc3 = acc3;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getHandleInfo() {
        return handleInfo;
    }

    public void setHandleInfo(String handleInfo) {
        this.handleInfo = handleInfo == null ? null : handleInfo.trim();
    }
}