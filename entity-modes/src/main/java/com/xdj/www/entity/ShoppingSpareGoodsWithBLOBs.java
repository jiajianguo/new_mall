package com.xdj.www.entity;

public class ShoppingSpareGoodsWithBLOBs extends ShoppingSpareGoods {
    private String content;

    private String seodescribe;

    private String seokeyword;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getSeodescribe() {
        return seodescribe;
    }

    public void setSeodescribe(String seodescribe) {
        this.seodescribe = seodescribe == null ? null : seodescribe.trim();
    }

    public String getSeokeyword() {
        return seokeyword;
    }

    public void setSeokeyword(String seokeyword) {
        this.seokeyword = seokeyword == null ? null : seokeyword.trim();
    }
}