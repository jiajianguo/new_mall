package com.xdj.www.entity;

import java.util.Date;

public class ShoppingHomeAddention extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long attentionHomepageId;

    private Long attentionedId;

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

    public Long getAttentionHomepageId() {
        return attentionHomepageId;
    }

    public void setAttentionHomepageId(Long attentionHomepageId) {
        this.attentionHomepageId = attentionHomepageId;
    }

    public Long getAttentionedId() {
        return attentionedId;
    }

    public void setAttentionedId(Long attentionedId) {
        this.attentionedId = attentionedId;
    }
}