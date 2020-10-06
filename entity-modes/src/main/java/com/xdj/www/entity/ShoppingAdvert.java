package com.xdj.www.entity;

import java.util.Date;

/**
 * @author Administrator
 */
public class ShoppingAdvert extends BaseEntity{
    private Long id;
    private Date addtime;
    private Boolean deletestatus;
    private Date adBeginTime;
    private Integer adClickNum;
    private Date adEndTime;
    private Integer adGold;
    private Integer adSlideSequence;
    private Integer adStatus;
    private String adText;
    private String adTitle;
    private String adUrl;
    private Long adAccId;
    private Long adApId;
    private Long adUserId;
    private ShoppingAccessory adAcc;

    public ShoppingAccessory getAdAcc() {
        return adAcc;
    }

    public void setAdAcc(ShoppingAccessory adAcc) {
        this.adAcc = adAcc;
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
    public Date getAdBeginTime() {
        return adBeginTime;
    }
    public void setAdBeginTime(Date adBeginTime) {
        this.adBeginTime = adBeginTime;
    }
    public Integer getAdClickNum() {
        return adClickNum;
    }
    public void setAdClickNum(Integer adClickNum) {
        this.adClickNum = adClickNum;
    }

    public Date getAdEndTime() {
        return adEndTime;
    }

    public void setAdEndTime(Date adEndTime) {
        this.adEndTime = adEndTime;
    }

    public Integer getAdGold() {
        return adGold;
    }

    public void setAdGold(Integer adGold) {
        this.adGold = adGold;
    }

    public Integer getAdSlideSequence() {
        return adSlideSequence;
    }

    public void setAdSlideSequence(Integer adSlideSequence) {
        this.adSlideSequence = adSlideSequence;
    }

    public Integer getAdStatus() {
        return adStatus;
    }

    public void setAdStatus(Integer adStatus) {
        this.adStatus = adStatus;
    }

    public String getAdText() {
        return adText;
    }

    public void setAdText(String adText) {
        this.adText = adText == null ? null : adText.trim();
    }

    public String getAdTitle() {
        return adTitle;
    }

    public void setAdTitle(String adTitle) {
        this.adTitle = adTitle == null ? null : adTitle.trim();
    }

    public String getAdUrl() {
        return adUrl;
    }

    public void setAdUrl(String adUrl) {
        this.adUrl = adUrl == null ? null : adUrl.trim();
    }

    public Long getAdAccId() {
        return adAccId;
    }

    public void setAdAccId(Long adAccId) {
        this.adAccId = adAccId;
    }

    public Long getAdApId() {
        return adApId;
    }

    public void setAdApId(Long adApId) {
        this.adApId = adApId;
    }

    public Long getAdUserId() {
        return adUserId;
    }

    public void setAdUserId(Long adUserId) {
        this.adUserId = adUserId;
    }
}
