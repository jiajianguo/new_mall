package com.xdj.www.entity;

import java.util.Date;

public class ShoppingWatermark extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Float wmImageAlpha;

    private Boolean wmImageOpen;

    private Integer wmImagePos;

    private String wmText;

    private String wmTextColor;

    private String wmTextFont;

    private Integer wmTextFontSize;

    private Boolean wmTextOpen;

    private Integer wmTextPos;

    private Long storeId;

    private Long wmImageId;

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

    public Float getWmImageAlpha() {
        return wmImageAlpha;
    }

    public void setWmImageAlpha(Float wmImageAlpha) {
        this.wmImageAlpha = wmImageAlpha;
    }

    public Boolean getWmImageOpen() {
        return wmImageOpen;
    }

    public void setWmImageOpen(Boolean wmImageOpen) {
        this.wmImageOpen = wmImageOpen;
    }

    public Integer getWmImagePos() {
        return wmImagePos;
    }

    public void setWmImagePos(Integer wmImagePos) {
        this.wmImagePos = wmImagePos;
    }

    public String getWmText() {
        return wmText;
    }

    public void setWmText(String wmText) {
        this.wmText = wmText == null ? null : wmText.trim();
    }

    public String getWmTextColor() {
        return wmTextColor;
    }

    public void setWmTextColor(String wmTextColor) {
        this.wmTextColor = wmTextColor == null ? null : wmTextColor.trim();
    }

    public String getWmTextFont() {
        return wmTextFont;
    }

    public void setWmTextFont(String wmTextFont) {
        this.wmTextFont = wmTextFont == null ? null : wmTextFont.trim();
    }

    public Integer getWmTextFontSize() {
        return wmTextFontSize;
    }

    public void setWmTextFontSize(Integer wmTextFontSize) {
        this.wmTextFontSize = wmTextFontSize;
    }

    public Boolean getWmTextOpen() {
        return wmTextOpen;
    }

    public void setWmTextOpen(Boolean wmTextOpen) {
        this.wmTextOpen = wmTextOpen;
    }

    public Integer getWmTextPos() {
        return wmTextPos;
    }

    public void setWmTextPos(Integer wmTextPos) {
        this.wmTextPos = wmTextPos;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getWmImageId() {
        return wmImageId;
    }

    public void setWmImageId(Long wmImageId) {
        this.wmImageId = wmImageId;
    }
}