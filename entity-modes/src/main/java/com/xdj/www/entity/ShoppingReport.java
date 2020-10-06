package com.xdj.www.entity;

import java.util.Date;

public class ShoppingReport extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date handleTime;

    private Integer result;

    private Integer status;

    private Long acc1Id;

    private Long acc2Id;

    private Long acc3Id;

    private Long goodsId;

    private Long subjectId;

    private Long userId;

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

    public Date getHandleTime() {
        return handleTime;
    }

    public void setHandleTime(Date handleTime) {
        this.handleTime = handleTime;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAcc1Id() {
        return acc1Id;
    }

    public void setAcc1Id(Long acc1Id) {
        this.acc1Id = acc1Id;
    }

    public Long getAcc2Id() {
        return acc2Id;
    }

    public void setAcc2Id(Long acc2Id) {
        this.acc2Id = acc2Id;
    }

    public Long getAcc3Id() {
        return acc3Id;
    }

    public void setAcc3Id(Long acc3Id) {
        this.acc3Id = acc3Id;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Long subjectId) {
        this.subjectId = subjectId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}