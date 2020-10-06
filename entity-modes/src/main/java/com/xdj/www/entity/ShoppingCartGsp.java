package com.xdj.www.entity;

public class ShoppingCartGsp extends BaseEntity{
    private Long cartId;

    private Long gspId;

    public Long getCartId() {
        return cartId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }

    public Long getGspId() {
        return gspId;
    }

    public void setGspId(Long gspId) {
        this.gspId = gspId;
    }
}