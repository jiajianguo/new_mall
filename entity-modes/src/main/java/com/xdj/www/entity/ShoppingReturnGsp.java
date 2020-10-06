package com.xdj.www.entity;

public class ShoppingReturnGsp extends BaseEntity{
    private Long itemId;

    private Long gspId;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public Long getGspId() {
        return gspId;
    }

    public void setGspId(Long gspId) {
        this.gspId = gspId;
    }
}