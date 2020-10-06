package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

public class ShoppingGoodsFloor extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String gfCss;

    private Boolean gfDisplay;

    private Integer gfGoodsCount;

    private Integer gfLevel;

    private String gfName;

    private Integer gfSequence;

    private Long parentId;


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

    public String getGfCss() {
        return gfCss;
    }

    public void setGfCss(String gfCss) {
        this.gfCss = gfCss == null ? null : gfCss.trim();
    }

    public Boolean getGfDisplay() {
        return gfDisplay;
    }

    public void setGfDisplay(Boolean gfDisplay) {
        this.gfDisplay = gfDisplay;
    }

    public Integer getGfGoodsCount() {
        return gfGoodsCount;
    }

    public void setGfGoodsCount(Integer gfGoodsCount) {
        this.gfGoodsCount = gfGoodsCount;
    }

    public Integer getGfLevel() {
        return gfLevel;
    }

    public void setGfLevel(Integer gfLevel) {
        this.gfLevel = gfLevel;
    }

    public String getGfName() {
        return gfName;
    }

    public void setGfName(String gfName) {
        this.gfName = gfName == null ? null : gfName.trim();
    }

    public Integer getGfSequence() {
        return gfSequence;
    }

    public void setGfSequence(Integer gfSequence) {
        this.gfSequence = gfSequence;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
