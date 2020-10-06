package com.xdj.www.entity;

public class ShoppingGoodsCombin extends BaseEntity{
    private Long shoppingGoodsId;

    private Long combinGoodsId;

    public Long getShoppingGoodsId() {
        return shoppingGoodsId;
    }

    public void setShoppingGoodsId(Long shoppingGoodsId) {
        this.shoppingGoodsId = shoppingGoodsId;
    }

    public Long getCombinGoodsId() {
        return combinGoodsId;
    }

    public void setCombinGoodsId(Long combinGoodsId) {
        this.combinGoodsId = combinGoodsId;
    }
}