package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingBargain extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date bargainTime;

    private Integer maximum;

    private BigDecimal rebate;

    private String state;

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

    public Date getBargainTime() {
        return bargainTime;
    }

    public void setBargainTime(Date bargainTime) {
        this.bargainTime = bargainTime;
    }

    public Integer getMaximum() {
        return maximum;
    }

    public void setMaximum(Integer maximum) {
        this.maximum = maximum;
    }

    public BigDecimal getRebate() {
        return rebate;
    }

    public void setRebate(BigDecimal rebate) {
        this.rebate = rebate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }
}