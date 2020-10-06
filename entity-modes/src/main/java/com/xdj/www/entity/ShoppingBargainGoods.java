package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingBargainGoods extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private BigDecimal bgPrice;

    private Integer bgStatus;

    private Date bgTime;

    private Long bgAdminUserId;

    private Long bgGoodsId;

    private Integer bgCount;

    private BigDecimal bgRebate;

    private Date auditTime;

    private ShoppingGoodsWithBLOBs bg_goods;

    public ShoppingGoodsWithBLOBs getBg_goods() {
        return bg_goods;
    }

    public void setBg_goods(ShoppingGoodsWithBLOBs bg_goods) {
        this.bg_goods = bg_goods;
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

    public BigDecimal getBgPrice() {
        return bgPrice;
    }

    public void setBgPrice(BigDecimal bgPrice) {
        this.bgPrice = bgPrice;
    }

    public Integer getBgStatus() {
        return bgStatus;
    }

    public void setBgStatus(Integer bgStatus) {
        this.bgStatus = bgStatus;
    }

    public Date getBgTime() {
        return bgTime;
    }

    public void setBgTime(Date bgTime) {
        this.bgTime = bgTime;
    }

    public Long getBgAdminUserId() {
        return bgAdminUserId;
    }

    public void setBgAdminUserId(Long bgAdminUserId) {
        this.bgAdminUserId = bgAdminUserId;
    }

    public Long getBgGoodsId() {
        return bgGoodsId;
    }

    public void setBgGoodsId(Long bgGoodsId) {
        this.bgGoodsId = bgGoodsId;
    }

    public Integer getBgCount() {
        return bgCount;
    }

    public void setBgCount(Integer bgCount) {
        this.bgCount = bgCount;
    }

    public BigDecimal getBgRebate() {
        return bgRebate;
    }

    public void setBgRebate(BigDecimal bgRebate) {
        this.bgRebate = bgRebate;
    }

    public Date getAuditTime() {
        return auditTime;
    }

    public void setAuditTime(Date auditTime) {
        this.auditTime = auditTime;
    }
}
