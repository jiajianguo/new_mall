package com.xdj.www.entity;

public class ShoppingConsultWithBLOBs extends ShoppingConsult {
    private String consultContent;

    private String consultReply;

    private ShoppingUser consult_user;

    //回复用户
    private ShoppingUser reply_user;

    //商品
    private ShoppingGoodsWithBLOBs goods;

    public ShoppingUser getReply_user() {
        return reply_user;
    }

    public void setReply_user(ShoppingUser reply_user) {
        this.reply_user = reply_user;
    }

    public ShoppingGoodsWithBLOBs getGoods() {
        return goods;
    }

    public void setGoods(ShoppingGoodsWithBLOBs goods) {
        this.goods = goods;
    }

    public ShoppingUser getConsult_user() {
        return consult_user;
    }

    public void setConsult_user(ShoppingUser consult_user) {
        this.consult_user = consult_user;
    }

    public String getConsultContent() {
        return consultContent;
    }

    public void setConsultContent(String consultContent) {
        this.consultContent = consultContent == null ? null : consultContent.trim();
    }

    public String getConsultReply() {
        return consultReply;
    }

    public void setConsultReply(String consultReply) {
        this.consultReply = consultReply == null ? null : consultReply.trim();
    }
}
