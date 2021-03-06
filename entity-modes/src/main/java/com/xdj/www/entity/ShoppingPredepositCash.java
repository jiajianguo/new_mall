package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

public class ShoppingPredepositCash extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String cashAccount;

    private BigDecimal cashAmount;

    private String cashBank;

    private Integer cashPayStatus;

    private String cashPayment;

    private String cashSn;

    private Integer cashStatus;

    private String cashUsername;

    private Long cashAdminId;

    private Long cashUserId;

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

    public String getCashAccount() {
        return cashAccount;
    }

    public void setCashAccount(String cashAccount) {
        this.cashAccount = cashAccount == null ? null : cashAccount.trim();
    }

    public BigDecimal getCashAmount() {
        return cashAmount;
    }

    public void setCashAmount(BigDecimal cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getCashBank() {
        return cashBank;
    }

    public void setCashBank(String cashBank) {
        this.cashBank = cashBank == null ? null : cashBank.trim();
    }

    public Integer getCashPayStatus() {
        return cashPayStatus;
    }

    public void setCashPayStatus(Integer cashPayStatus) {
        this.cashPayStatus = cashPayStatus;
    }

    public String getCashPayment() {
        return cashPayment;
    }

    public void setCashPayment(String cashPayment) {
        this.cashPayment = cashPayment == null ? null : cashPayment.trim();
    }

    public String getCashSn() {
        return cashSn;
    }

    public void setCashSn(String cashSn) {
        this.cashSn = cashSn == null ? null : cashSn.trim();
    }

    public Integer getCashStatus() {
        return cashStatus;
    }

    public void setCashStatus(Integer cashStatus) {
        this.cashStatus = cashStatus;
    }

    public String getCashUsername() {
        return cashUsername;
    }

    public void setCashUsername(String cashUsername) {
        this.cashUsername = cashUsername == null ? null : cashUsername.trim();
    }

    public Long getCashAdminId() {
        return cashAdminId;
    }

    public void setCashAdminId(Long cashAdminId) {
        this.cashAdminId = cashAdminId;
    }

    public Long getCashUserId() {
        return cashUserId;
    }

    public void setCashUserId(Long cashUserId) {
        this.cashUserId = cashUserId;
    }
}