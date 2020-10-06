package com.xdj.www.entity;

import java.util.Date;

public class ShoppingDeliveryGoods extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer dStatus;

    private Long dAdminUserId;

    private Long dDeliveryGoodsId;

    private Long dGoodsId;

    private Date dBeginTime;

    private Date dEndTime;

    private Date dAuditTime;

    private Date dRefuseTime;

    private ShoppingGoodsWithBLOBs d_goods;

    private ShoppingGoodsWithBLOBs d_delivery_goods;

    public ShoppingGoodsWithBLOBs getD_delivery_goods() {
        return d_delivery_goods;
    }

    public void setD_delivery_goods(ShoppingGoodsWithBLOBs d_delivery_goods) {
        this.d_delivery_goods = d_delivery_goods;
    }

    public ShoppingGoodsWithBLOBs getD_goods() {
        return d_goods;
    }

    public void setD_goods(ShoppingGoodsWithBLOBs d_goods) {
        this.d_goods = d_goods;
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

    public Integer getdStatus() {
        return dStatus;
    }

    public void setdStatus(Integer dStatus) {
        this.dStatus = dStatus;
    }

    public Long getdAdminUserId() {
        return dAdminUserId;
    }

    public void setdAdminUserId(Long dAdminUserId) {
        this.dAdminUserId = dAdminUserId;
    }

    public Long getdDeliveryGoodsId() {
        return dDeliveryGoodsId;
    }

    public void setdDeliveryGoodsId(Long dDeliveryGoodsId) {
        this.dDeliveryGoodsId = dDeliveryGoodsId;
    }

    public Long getdGoodsId() {
        return dGoodsId;
    }

    public void setdGoodsId(Long dGoodsId) {
        this.dGoodsId = dGoodsId;
    }

    public Date getdBeginTime() {
        return dBeginTime;
    }

    public void setdBeginTime(Date dBeginTime) {
        this.dBeginTime = dBeginTime;
    }

    public Date getdEndTime() {
        return dEndTime;
    }

    public void setdEndTime(Date dEndTime) {
        this.dEndTime = dEndTime;
    }

    public Date getdAuditTime() {
        return dAuditTime;
    }

    public void setdAuditTime(Date dAuditTime) {
        this.dAuditTime = dAuditTime;
    }

    public Date getdRefuseTime() {
        return dRefuseTime;
    }

    public void setdRefuseTime(Date dRefuseTime) {
        this.dRefuseTime = dRefuseTime;
    }
}
