package com.xdj.www.entity;

import java.util.Date;

public class ShoppingStoregradeLog extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Boolean logEdit;

    private String storeGradeInfo;

    private Integer storeGradeStatus;

    private Long storeId;

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

    public Boolean getLogEdit() {
        return logEdit;
    }

    public void setLogEdit(Boolean logEdit) {
        this.logEdit = logEdit;
    }

    public String getStoreGradeInfo() {
        return storeGradeInfo;
    }

    public void setStoreGradeInfo(String storeGradeInfo) {
        this.storeGradeInfo = storeGradeInfo == null ? null : storeGradeInfo.trim();
    }

    public Integer getStoreGradeStatus() {
        return storeGradeStatus;
    }

    public void setStoreGradeStatus(Integer storeGradeStatus) {
        this.storeGradeStatus = storeGradeStatus;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}