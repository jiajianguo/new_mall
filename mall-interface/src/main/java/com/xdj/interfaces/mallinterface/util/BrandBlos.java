package com.xdj.interfaces.mallinterface.util;

import com.xdj.www.entity.ShoppingGoodsbrand;

import java.util.List;

public class BrandBlos {
    private String word;
    private List<ShoppingGoodsbrand> brands;

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<ShoppingGoodsbrand> getBrands() {
        return brands;
    }

    public void setBrands(List<ShoppingGoodsbrand> brands) {
        this.brands = brands;
    }
}
