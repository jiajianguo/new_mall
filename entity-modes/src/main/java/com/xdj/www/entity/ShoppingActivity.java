package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingActivity extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date acBeginTime;

    private Date acEndTime;

    private Integer acSequence;

    private Integer acStatus;

    private String acTitle;

    private Long acAccId;

    private BigDecimal acRebate;

    private String acContent;

    private ShoppingAccessory ac_acc;

    public ShoppingAccessory getAc_acc() {
        return ac_acc;
    }

    public void setAc_acc(ShoppingAccessory ac_acc) {
        this.ac_acc = ac_acc;
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

    public Date getAcBeginTime() {
        return acBeginTime;
    }

    public void setAcBeginTime(Date acBeginTime) {
        this.acBeginTime = acBeginTime;
    }

    public Date getAcEndTime() {
        return acEndTime;
    }

    public void setAcEndTime(Date acEndTime) {
        this.acEndTime = acEndTime;
    }

    public Integer getAcSequence() {
        return acSequence;
    }

    public void setAcSequence(Integer acSequence) {
        this.acSequence = acSequence;
    }

    public Integer getAcStatus() {
        return acStatus;
    }

    public void setAcStatus(Integer acStatus) {
        this.acStatus = acStatus;
    }

    public String getAcTitle() {
        return acTitle;
    }

    public void setAcTitle(String acTitle) {
        this.acTitle = acTitle == null ? null : acTitle.trim();
    }

    public Long getAcAccId() {
        return acAccId;
    }

    public void setAcAccId(Long acAccId) {
        this.acAccId = acAccId;
    }

    public BigDecimal getAcRebate() {
        return acRebate;
    }

    public void setAcRebate(BigDecimal acRebate) {
        this.acRebate = acRebate;
    }

    public String getAcContent() {
        return acContent;
    }

    public void setAcContent(String acContent) {
        this.acContent = acContent == null ? null : acContent.trim();
    }
}
