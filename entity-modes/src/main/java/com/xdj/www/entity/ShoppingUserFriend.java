package com.xdj.www.entity;

import java.util.Date;

public class ShoppingUserFriend extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long fromuserId;

    private Long touserId;

    private ShoppingUser from_user;

    private ShoppingUser to_user;

    public ShoppingUser getFrom_user() {
        return from_user;
    }

    public void setFrom_user(ShoppingUser from_user) {
        this.from_user = from_user;
    }

    public ShoppingUser getTo_user() {
        return to_user;
    }

    public void setTo_user(ShoppingUser to_user) {
        this.to_user = to_user;
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

    public Long getFromuserId() {
        return fromuserId;
    }

    public void setFromuserId(Long fromuserId) {
        this.fromuserId = fromuserId;
    }

    public Long getTouserId() {
        return touserId;
    }

    public void setTouserId(Long touserId) {
        this.touserId = touserId;
    }
}