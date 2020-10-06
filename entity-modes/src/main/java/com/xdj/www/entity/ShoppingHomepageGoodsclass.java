package com.xdj.www.entity;

import java.util.Date;

public class ShoppingHomepageGoodsclass extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long userId;

    private Long gcId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGcId() {
        return gcId;
    }

    public void setGcId(Long gcId) {
        this.gcId = gcId;
    }
}