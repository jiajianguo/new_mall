package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
public class ShoppingIntegralGoodscart extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer count;

    private Integer integral;

    private BigDecimal transFee;

    private Long goodsId;

    private Long orderId;

    private ShoppingIntegralGoods goods;

    private ShoppingIntegralGoodsorder order;

    @Override
    public String toString() {
        return "ShoppingIntegralGoodscart{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", deletestatus=" + deletestatus +
                ", count=" + count +
                ", integral=" + integral +
                ", transFee=" + transFee +
                ", goodsId=" + goodsId +
                ", orderId=" + orderId +
                ", goods=" + goods +
                ", order=" + order +
                '}';
    }

    public ShoppingIntegralGoodsorder getOrder() {
        return order;
    }

    public void setOrder(ShoppingIntegralGoodsorder order) {
        this.order = order;
    }

    public ShoppingIntegralGoods getGoods() {
        return goods;
    }

    public void setGoods(ShoppingIntegralGoods goods) {
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

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public BigDecimal getTransFee() {
        return transFee;
    }

    public void setTransFee(BigDecimal transFee) {
        this.transFee = transFee;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }
}
