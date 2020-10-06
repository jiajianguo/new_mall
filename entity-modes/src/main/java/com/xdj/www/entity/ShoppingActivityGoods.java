package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
public class ShoppingActivityGoods extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer agStatus;

    private Long actId;

    private Long agAdminId;

    private Long agGoodsId;

    private BigDecimal agPrice;

    private ShoppingGoods ag_goods;

    //活动
    private ShoppingActivity act;

    public ShoppingGoods getAg_goods() {
        return ag_goods;
    }

    public void setAg_goods(ShoppingGoods ag_goods) {
        this.ag_goods = ag_goods;
    }

    public ShoppingActivity getAct() {
        return act;
    }

    public void setAct(ShoppingActivity act) {
        this.act = act;
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

    public Integer getAgStatus() {
        return agStatus;
    }

    public void setAgStatus(Integer agStatus) {
        this.agStatus = agStatus;
    }

    public Long getActId() {
        return actId;
    }

    public void setActId(Long actId) {
        this.actId = actId;
    }

    public Long getAgAdminId() {
        return agAdminId;
    }

    public void setAgAdminId(Long agAdminId) {
        this.agAdminId = agAdminId;
    }

    public Long getAgGoodsId() {
        return agGoodsId;
    }

    public void setAgGoodsId(Long agGoodsId) {
        this.agGoodsId = agGoodsId;
    }

    public BigDecimal getAgPrice() {
        return agPrice;
    }

    public void setAgPrice(BigDecimal agPrice) {
        this.agPrice = agPrice;
    }
}
