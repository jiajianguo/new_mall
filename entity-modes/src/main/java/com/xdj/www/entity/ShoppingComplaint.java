package com.xdj.www.entity;

import java.util.Date;

public class ShoppingComplaint extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date appealTime;

    private Date handleTime;

    private Integer status;

    private String type;

    private Long csId;

    private Long fromAcc1Id;

    private Long fromAcc2Id;

    private Long fromAcc3Id;

    private Long fromUserId;

    private Long handleUserId;

    private Long ofId;

    private Long toAcc1Id;

    private Long toAcc2Id;

    private Long toAcc3Id;

    private Long toUserId;

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

    public Date getAppealTime() {
        return appealTime;
    }

    public void setAppealTime(Date appealTime) {
        this.appealTime = appealTime;
    }

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getCsId() {
        return csId;
    }

    public void setCsId(Long csId) {
        this.csId = csId;
    }

    public Long getFromAcc1Id() {
        return fromAcc1Id;
    }

    public void setFromAcc1Id(Long fromAcc1Id) {
        this.fromAcc1Id = fromAcc1Id;
    }

    public Long getFromAcc2Id() {
        return fromAcc2Id;
    }

    public void setFromAcc2Id(Long fromAcc2Id) {
        this.fromAcc2Id = fromAcc2Id;
    }

    public Long getFromAcc3Id() {
        return fromAcc3Id;
    }

    public void setFromAcc3Id(Long fromAcc3Id) {
        this.fromAcc3Id = fromAcc3Id;
    }

    public Long getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(Long fromUserId) {
        this.fromUserId = fromUserId;
    }

    public Long getHandleUserId() {
        return handleUserId;
    }

    public void setHandleUserId(Long handleUserId) {
        this.handleUserId = handleUserId;
    }

    public Long getOfId() {
        return ofId;
    }

    public void setOfId(Long ofId) {
        this.ofId = ofId;
    }

    public Long getToAcc1Id() {
        return toAcc1Id;
    }

    public void setToAcc1Id(Long toAcc1Id) {
        this.toAcc1Id = toAcc1Id;
    }

    public Long getToAcc2Id() {
        return toAcc2Id;
    }

    public void setToAcc2Id(Long toAcc2Id) {
        this.toAcc2Id = toAcc2Id;
    }

    public Long getToAcc3Id() {
        return toAcc3Id;
    }

    public void setToAcc3Id(Long toAcc3Id) {
        this.toAcc3Id = toAcc3Id;
    }

    public Long getToUserId() {
        return toUserId;
    }

    public void setToUserId(Long toUserId) {
        this.toUserId = toUserId;
    }
}