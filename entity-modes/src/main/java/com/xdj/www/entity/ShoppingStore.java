package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
public class ShoppingStore extends BaseEntity{
    private Long id;
    private Date addtime;
    private Boolean deletestatus;
    private Boolean cardApprove;
    private Boolean realstoreApprove;
    private String storeAddress;
    private Integer storeCredit;
    private String storeMsn;
    private String storeName;
    private String storeOwer;
    private String storeOwerCard;
    private String storeQq;
    private Boolean storeRecommend;
    private Date storeRecommendTime;
    private Integer storeStatus;
    private String storeTelephone;
    private String storeZip;
    private String template;
    private Date validity;
    private Long areaId;
    private Long cardId;
    private Long gradeId;
    private Long scId;
    private Long storeBannerId;
    private Long storeLicenseId;

    private Long storeLogoId;

    private Long updateGradeId;

    private Integer domainModifyCount;

    private String storeSecondDomain;

    private Integer favoriteCount;

    private BigDecimal storeLat;

    private BigDecimal storeLng;

    private String storeWw;

    private String mapType;

    private Date deliveryBeginTime;

    private Date deliveryEndTime;

    private Date combinBeginTime;

    private Date combinEndTime;

    private Date weixinBeginTime;

    private Date weixinEndTime;

    private Integer weixinStatus;

    private String weixinAppid;

    private String weixinAppsecret;

    private String weixinToken;

    private Long weixinQrImgId;

    private String weixinAccount;

    private Long storeWeixinLogoId;

    private String weixinStoreName;

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

    public Boolean getCardApprove() {
        return cardApprove;
    }

    public void setCardApprove(Boolean cardApprove) {
        this.cardApprove = cardApprove;
    }

    public Boolean getRealstoreApprove() {
        return realstoreApprove;
    }

    public void setRealstoreApprove(Boolean realstoreApprove) {
        this.realstoreApprove = realstoreApprove;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress == null ? null : storeAddress.trim();
    }

    public Integer getStoreCredit() {
        return storeCredit;
    }

    public void setStoreCredit(Integer storeCredit) {
        this.storeCredit = storeCredit;
    }

    public String getStoreMsn() {
        return storeMsn;
    }

    public void setStoreMsn(String storeMsn) {
        this.storeMsn = storeMsn == null ? null : storeMsn.trim();
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName == null ? null : storeName.trim();
    }

    public String getStoreOwer() {
        return storeOwer;
    }

    public void setStoreOwer(String storeOwer) {
        this.storeOwer = storeOwer == null ? null : storeOwer.trim();
    }

    public String getStoreOwerCard() {
        return storeOwerCard;
    }

    public void setStoreOwerCard(String storeOwerCard) {
        this.storeOwerCard = storeOwerCard == null ? null : storeOwerCard.trim();
    }

    public String getStoreQq() {
        return storeQq;
    }

    public void setStoreQq(String storeQq) {
        this.storeQq = storeQq == null ? null : storeQq.trim();
    }

    public Boolean getStoreRecommend() {
        return storeRecommend;
    }

    public void setStoreRecommend(Boolean storeRecommend) {
        this.storeRecommend = storeRecommend;
    }

    public Date getStoreRecommendTime() {
        return storeRecommendTime;
    }

    public void setStoreRecommendTime(Date storeRecommendTime) {
        this.storeRecommendTime = storeRecommendTime;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getStoreTelephone() {
        return storeTelephone;
    }

    public void setStoreTelephone(String storeTelephone) {
        this.storeTelephone = storeTelephone == null ? null : storeTelephone.trim();
    }

    public String getStoreZip() {
        return storeZip;
    }

    public void setStoreZip(String storeZip) {
        this.storeZip = storeZip == null ? null : storeZip.trim();
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template == null ? null : template.trim();
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public Long getGradeId() {
        return gradeId;
    }

    public void setGradeId(Long gradeId) {
        this.gradeId = gradeId;
    }

    public Long getScId() {
        return scId;
    }

    public void setScId(Long scId) {
        this.scId = scId;
    }

    public Long getStoreBannerId() {
        return storeBannerId;
    }

    public void setStoreBannerId(Long storeBannerId) {
        this.storeBannerId = storeBannerId;
    }

    public Long getStoreLicenseId() {
        return storeLicenseId;
    }

    public void setStoreLicenseId(Long storeLicenseId) {
        this.storeLicenseId = storeLicenseId;
    }

    public Long getStoreLogoId() {
        return storeLogoId;
    }

    public void setStoreLogoId(Long storeLogoId) {
        this.storeLogoId = storeLogoId;
    }

    public Long getUpdateGradeId() {
        return updateGradeId;
    }

    public void setUpdateGradeId(Long updateGradeId) {
        this.updateGradeId = updateGradeId;
    }

    public Integer getDomainModifyCount() {
        return domainModifyCount;
    }

    public void setDomainModifyCount(Integer domainModifyCount) {
        this.domainModifyCount = domainModifyCount;
    }

    public String getStoreSecondDomain() {
        return storeSecondDomain;
    }

    public void setStoreSecondDomain(String storeSecondDomain) {
        this.storeSecondDomain = storeSecondDomain == null ? null : storeSecondDomain.trim();
    }

    public Integer getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(Integer favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public BigDecimal getStoreLat() {
        return storeLat;
    }

    public void setStoreLat(BigDecimal storeLat) {
        this.storeLat = storeLat;
    }

    public BigDecimal getStoreLng() {
        return storeLng;
    }

    public void setStoreLng(BigDecimal storeLng) {
        this.storeLng = storeLng;
    }

    public String getStoreWw() {
        return storeWw;
    }

    public void setStoreWw(String storeWw) {
        this.storeWw = storeWw == null ? null : storeWw.trim();
    }

    public String getMapType() {
        return mapType;
    }

    public void setMapType(String mapType) {
        this.mapType = mapType == null ? null : mapType.trim();
    }

    public Date getDeliveryBeginTime() {
        return deliveryBeginTime;
    }

    public void setDeliveryBeginTime(Date deliveryBeginTime) {
        this.deliveryBeginTime = deliveryBeginTime;
    }

    public Date getDeliveryEndTime() {
        return deliveryEndTime;
    }

    public void setDeliveryEndTime(Date deliveryEndTime) {
        this.deliveryEndTime = deliveryEndTime;
    }

    public Date getCombinBeginTime() {
        return combinBeginTime;
    }

    public void setCombinBeginTime(Date combinBeginTime) {
        this.combinBeginTime = combinBeginTime;
    }

    public Date getCombinEndTime() {
        return combinEndTime;
    }

    public void setCombinEndTime(Date combinEndTime) {
        this.combinEndTime = combinEndTime;
    }

    public Date getWeixinBeginTime() {
        return weixinBeginTime;
    }

    public void setWeixinBeginTime(Date weixinBeginTime) {
        this.weixinBeginTime = weixinBeginTime;
    }

    public Date getWeixinEndTime() {
        return weixinEndTime;
    }

    public void setWeixinEndTime(Date weixinEndTime) {
        this.weixinEndTime = weixinEndTime;
    }

    public Integer getWeixinStatus() {
        return weixinStatus;
    }

    public void setWeixinStatus(Integer weixinStatus) {
        this.weixinStatus = weixinStatus;
    }

    public String getWeixinAppid() {
        return weixinAppid;
    }

    public void setWeixinAppid(String weixinAppid) {
        this.weixinAppid = weixinAppid == null ? null : weixinAppid.trim();
    }

    public String getWeixinAppsecret() {
        return weixinAppsecret;
    }

    public void setWeixinAppsecret(String weixinAppsecret) {
        this.weixinAppsecret = weixinAppsecret == null ? null : weixinAppsecret.trim();
    }

    public String getWeixinToken() {
        return weixinToken;
    }

    public void setWeixinToken(String weixinToken) {
        this.weixinToken = weixinToken == null ? null : weixinToken.trim();
    }

    public Long getWeixinQrImgId() {
        return weixinQrImgId;
    }

    public void setWeixinQrImgId(Long weixinQrImgId) {
        this.weixinQrImgId = weixinQrImgId;
    }

    public String getWeixinAccount() {
        return weixinAccount;
    }

    public void setWeixinAccount(String weixinAccount) {
        this.weixinAccount = weixinAccount == null ? null : weixinAccount.trim();
    }

    public Long getStoreWeixinLogoId() {
        return storeWeixinLogoId;
    }

    public void setStoreWeixinLogoId(Long storeWeixinLogoId) {
        this.storeWeixinLogoId = storeWeixinLogoId;
    }

    public String getWeixinStoreName() {
        return weixinStoreName;
    }

    public void setWeixinStoreName(String weixinStoreName) {
        this.weixinStoreName = weixinStoreName == null ? null : weixinStoreName.trim();
    }

}
