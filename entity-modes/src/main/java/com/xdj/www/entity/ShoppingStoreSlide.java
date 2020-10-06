package com.xdj.www.entity;

import java.util.Date;

public class ShoppingStoreSlide extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String url;

    private Long accId;

    private Long storeId;

    private ShoppingAccessory sliderImg;

    public ShoppingAccessory getSliderImg() {
        return sliderImg;
    }

    public void setSliderImg(ShoppingAccessory sliderImg) {
        this.sliderImg = sliderImg;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getAccId() {
        return accId;
    }

    public void setAccId(Long accId) {
        this.accId = accId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }
}
