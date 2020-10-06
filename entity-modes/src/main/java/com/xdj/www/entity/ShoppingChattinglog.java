package com.xdj.www.entity;

import java.util.Date;

public class ShoppingChattinglog extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long userId;

    private Long chattingId;

    private Integer mark;

    private String content;

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

    public Long getChattingId() {
        return chattingId;
    }

    public void setChattingId(Long chattingId) {
        this.chattingId = chattingId;
    }

    public Integer getMark() {
        return mark;
    }

    public void setMark(Integer mark) {
        this.mark = mark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}