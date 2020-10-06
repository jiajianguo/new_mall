package com.xdj.www.entity;

import java.util.Date;

public class ShoppingZtcGoldLog extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String zglContent;

    private Integer zglGold;

    private Integer zglType;

    private Long zglGoodsId;

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

    public String getZglContent() {
        return zglContent;
    }

    public void setZglContent(String zglContent) {
        this.zglContent = zglContent == null ? null : zglContent.trim();
    }

    public Integer getZglGold() {
        return zglGold;
    }

    public void setZglGold(Integer zglGold) {
        this.zglGold = zglGold;
    }

    public Integer getZglType() {
        return zglType;
    }

    public void setZglType(Integer zglType) {
        this.zglType = zglType;
    }

    public Long getZglGoodsId() {
        return zglGoodsId;
    }

    public void setZglGoodsId(Long zglGoodsId) {
        this.zglGoodsId = zglGoodsId;
    }
}