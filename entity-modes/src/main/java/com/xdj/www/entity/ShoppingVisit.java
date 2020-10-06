package com.xdj.www.entity;

import java.util.Date;

public class ShoppingVisit extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date visittime;

    private Long homepageId;

    private Long userId;

    private ShoppingUser user;

    public ShoppingUser getUser() {
        return user;
    }

    public void setUser(ShoppingUser user) {
        this.user = user;
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

    public Date getVisittime() {
        return visittime;
    }

    public void setVisittime(Date visittime) {
        this.visittime = visittime;
    }

    public Long getHomepageId() {
        return homepageId;
    }

    public void setHomepageId(Long homepageId) {
        this.homepageId = homepageId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
