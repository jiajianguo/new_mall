package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

public class ShoppingGoodsReturn extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String returnId;

    private Long ofId;

    private Long userId;

    private String returnInfo;

    private List<ShoppingGoodsReturnitem> items;

    public List<ShoppingGoodsReturnitem> getItems() {
        return items;
    }

    public void setItems(List<ShoppingGoodsReturnitem> items) {
        this.items = items;
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

    public String getReturnId() {
        return returnId;
    }

    public void setReturnId(String returnId) {
        this.returnId = returnId == null ? null : returnId.trim();
    }

    public Long getOfId() {
        return ofId;
    }

    public void setOfId(Long ofId) {
        this.ofId = ofId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getReturnInfo() {
        return returnInfo;
    }

    public void setReturnInfo(String returnInfo) {
        this.returnInfo = returnInfo == null ? null : returnInfo.trim();
    }
}
