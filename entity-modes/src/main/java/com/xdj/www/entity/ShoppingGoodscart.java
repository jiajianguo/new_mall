package com.xdj.www.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","fieldHandler"})
public class ShoppingGoodscart extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer count;

    private BigDecimal price;

    private Long goodsId;

    private Long ofId;

    private String cartType;

    private Long scId;

    private String specInfo;

    private ShoppingGoodsWithBLOBs goods;

    private ShoppingStorecart sc;

    private  ShoppingOrderformWithBLOBs of;

    private List<ShoppingGoodsspecproperty> gsps;

    public List<ShoppingGoodsspecproperty> getGsps() {
        return gsps;
    }

    public ShoppingOrderformWithBLOBs getOf() {
        return of;
    }

    public void setOf(ShoppingOrderformWithBLOBs of) {
        this.of = of;
    }

    public void setGsps(List<ShoppingGoodsspecproperty> gsps) {
        this.gsps = gsps;
    }

    public ShoppingStorecart getSc() {
        return sc;
    }

    public void setSc(ShoppingStorecart sc) {
        this.sc = sc;
    }

    public ShoppingGoodsWithBLOBs getGoods() {
        return goods;
    }

    public void setGoods(ShoppingGoodsWithBLOBs goods) {
        this.goods = goods;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAddtime() {
        return addtime;
    }

    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    public Boolean getDeletestatus() {
        return deletestatus;
    }

    public void setDeletestatus(Boolean deletestatus) {
        this.deletestatus = deletestatus;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getOfId() {
        return ofId;
    }

    public void setOfId(Long ofId) {
        this.ofId = ofId;
    }

    public String getCartType() {
        return cartType;
    }

    public void setCartType(String cartType) {
        this.cartType = cartType == null ? null : cartType.trim();
    }

    public Long getScId() {
        return scId;
    }

    public void setScId(Long scId) {
        this.scId = scId;
    }

    public String getSpecInfo() {
        return specInfo;
    }

    public void setSpecInfo(String specInfo) {
        this.specInfo = specInfo == null ? null : specInfo.trim();
    }
}
