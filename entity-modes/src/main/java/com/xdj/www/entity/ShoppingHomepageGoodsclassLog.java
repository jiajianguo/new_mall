package com.xdj.www.entity;

import java.util.Date;

public class ShoppingHomepageGoodsclassLog extends BaseEntity {
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long goodsclassId;

    private Long homepagegoodsclassId;

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

    public Long getGoodsclassId() {
        return goodsclassId;
    }

    public void setGoodsclassId(Long goodsclassId) {
        this.goodsclassId = goodsclassId;
    }

    public Long getHomepagegoodsclassId() {
        return homepagegoodsclassId;
    }

    public void setHomepagegoodsclassId(Long homepagegoodsclassId) {
        this.homepagegoodsclassId = homepagegoodsclassId;
    }
}