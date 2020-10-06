package com.xdj.www.entity;

import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingGoodsclassWithBLOBs extends ShoppingGoodsclass {
    private String seoDescription;

    private String seoKeywords;


    private List<ShoppingGoodsclassWithBLOBs> childs;

    private List<ShoppingGoodsWithBLOBs> goods;

    private ShoppingGoodsclassWithBLOBs parent;

    private ShoppingGoodstype goodsType;

    public ShoppingGoodstype getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(ShoppingGoodstype goodsType) {
        this.goodsType = goodsType;
    }

    public ShoppingGoodsclassWithBLOBs getParent() {
        return parent;
    }

    public void setParent(ShoppingGoodsclassWithBLOBs parent) {
        this.parent = parent;
    }

    public List<ShoppingGoodsWithBLOBs> getGoods() {
        return goods;
    }

    public void setGoods(List<ShoppingGoodsWithBLOBs> goods) {
        this.goods = goods;
    }

    public List<ShoppingGoodsclassWithBLOBs> getChilds() {
        return childs;
    }

    public void setChilds(List<ShoppingGoodsclassWithBLOBs> childs) {
        this.childs = childs;
    }

    public String getSeoDescription() {
        return seoDescription;
    }

    public void setSeoDescription(String seoDescription) {
        this.seoDescription = seoDescription == null ? null : seoDescription.trim();
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords == null ? null : seoKeywords.trim();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
