package com.xdj.www.entity;

import java.util.Date;

public class ShoppingChattingfriend extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer type;

    private Long friendId;

    private Long userId;

    private Long frienduserId;

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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getFriendId() {
        return friendId;
    }

    public void setFriendId(Long friendId) {
        this.friendId = friendId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getFrienduserId() {
        return frienduserId;
    }

    public void setFrienduserId(Long frienduserId) {
        this.frienduserId = frienduserId;
    }
}