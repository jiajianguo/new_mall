package com.xdj.www.entity;

public class ShoppingGoodstypeSpec extends BaseEntity{
    private Long typeId;

    private Long specId;

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }
}