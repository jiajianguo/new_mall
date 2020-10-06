package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
public class ShoppingGoods extends BaseEntity{
    private Long id;
    private Date addtime;
    private Boolean deletestatus;
    /**
     * 商品点击量
     */
    private Integer goodsClick;

    private String goodsFee;
    /**
     * 库存数量
     */
    private Integer goodsInventory;
    /**
     * 商品名字
     */
    private String goodsName;
    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;
    /**
     * 是否为店铺推荐
     */
    private Boolean goodsRecommend;

    private Integer goodsSalenum;

    private Date goodsSellerTime;

    private String goodsSerial;

    /**
     * 商品状态
     */
    private Integer goodsStatus;

    private Integer goodsTransfee;

    private BigDecimal goodsWeight;
    /**
     * 库存类型
     */
    private String inventoryType;
    /**
     * seo 关键字
     */
    private String seoKeywords;

    /**
     * 商店价格
     */
    private BigDecimal storePrice;

    /**
     * 店铺推荐
     */
    private Boolean storeRecommend;

    private Date storeRecommendTime;

    private Date ztcApplyTime;

    private Date ztcBeginTime;

    private Integer ztcClickNum;

    private Integer ztcDredgePrice;

    private Integer ztcGold;

    private Integer ztcPayStatus;

    private Integer ztcPrice;

    private Integer ztcStatus;

    /**
     * 商品分类id
     */
    private Long gcId;
    /**
     *
     */
    private Long goodsBrandId;
    /**
     * 商品主图id
     */
    private Long goodsMainPhotoId;
    /**
     * 商品店铺id
     */
    private Long goodsStoreId;

    private Long ztcAdminId;

    private Integer goodsCollect;

    /**
     * 团购
     */
    private Integer groupBuy;
    /**
     *
     */
    private Integer goodsChoiceType;

    /**
     * 团购id
     */
    private Long groupId;

    /**
     * 活动状态
     */
    private Integer activityStatus;

    private Integer bargainStatus;
    /**
     * 交货状态
     */
    private Integer deliveryStatus;

    private BigDecimal goodsCurrentPrice;

    private BigDecimal goodsVolume;

    private BigDecimal emsTransFee;

    private BigDecimal expressTransFee;

    private BigDecimal mailTransFee;

    private Long transportId;

    private Integer combinStatus;

    private Date combinBeginTime;

    private Date combinEndTime;

    private BigDecimal combinPrice;

    private Long descriptionEvaluate;

    private Boolean weixinShopHot;

    private Date weixinShopHottime;

    private Boolean weixinShopRecommend;

    private Date weixinShopRecommendtime;

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

    public Integer getGoodsClick() {
        return goodsClick;
    }

    public void setGoodsClick(Integer goodsClick) {
        this.goodsClick = goodsClick;
    }

    public String getGoodsFee() {
        return goodsFee;
    }

    public void setGoodsFee(String goodsFee) {
        this.goodsFee = goodsFee == null ? null : goodsFee.trim();
    }

    public Integer getGoodsInventory() {
        return goodsInventory;
    }

    public void setGoodsInventory(Integer goodsInventory) {
        this.goodsInventory = goodsInventory;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName == null ? null : goodsName.trim();
    }

    public BigDecimal getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(BigDecimal goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public Boolean getGoodsRecommend() {
        return goodsRecommend;
    }

    public void setGoodsRecommend(Boolean goodsRecommend) {
        this.goodsRecommend = goodsRecommend;
    }

    public Integer getGoodsSalenum() {
        return goodsSalenum;
    }

    public void setGoodsSalenum(Integer goodsSalenum) {
        this.goodsSalenum = goodsSalenum;
    }

    public Date getGoodsSellerTime() {
        return goodsSellerTime;
    }

    public void setGoodsSellerTime(Date goodsSellerTime) {
        this.goodsSellerTime = goodsSellerTime;
    }

    public String getGoodsSerial() {
        return goodsSerial;
    }

    public void setGoodsSerial(String goodsSerial) {
        this.goodsSerial = goodsSerial == null ? null : goodsSerial.trim();
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    public Integer getGoodsTransfee() {
        return goodsTransfee;
    }

    public void setGoodsTransfee(Integer goodsTransfee) {
        this.goodsTransfee = goodsTransfee;
    }

    public BigDecimal getGoodsWeight() {
        return goodsWeight;
    }

    public void setGoodsWeight(BigDecimal goodsWeight) {
        this.goodsWeight = goodsWeight;
    }

    public String getInventoryType() {
        return inventoryType;
    }

    public void setInventoryType(String inventoryType) {
        this.inventoryType = inventoryType == null ? null : inventoryType.trim();
    }

    public String getSeoKeywords() {
        return seoKeywords;
    }

    public void setSeoKeywords(String seoKeywords) {
        this.seoKeywords = seoKeywords == null ? null : seoKeywords.trim();
    }

    public BigDecimal getStorePrice() {
        return storePrice;
    }

    public void setStorePrice(BigDecimal storePrice) {
        this.storePrice = storePrice;
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

    public Date getZtcApplyTime() {
        return ztcApplyTime;
    }

    public void setZtcApplyTime(Date ztcApplyTime) {
        this.ztcApplyTime = ztcApplyTime;
    }

    public Date getZtcBeginTime() {
        return ztcBeginTime;
    }

    public void setZtcBeginTime(Date ztcBeginTime) {
        this.ztcBeginTime = ztcBeginTime;
    }

    public Integer getZtcClickNum() {
        return ztcClickNum;
    }

    public void setZtcClickNum(Integer ztcClickNum) {
        this.ztcClickNum = ztcClickNum;
    }

    public Integer getZtcDredgePrice() {
        return ztcDredgePrice;
    }

    public void setZtcDredgePrice(Integer ztcDredgePrice) {
        this.ztcDredgePrice = ztcDredgePrice;
    }

    public Integer getZtcGold() {
        return ztcGold;
    }

    public void setZtcGold(Integer ztcGold) {
        this.ztcGold = ztcGold;
    }

    public Integer getZtcPayStatus() {
        return ztcPayStatus;
    }

    public void setZtcPayStatus(Integer ztcPayStatus) {
        this.ztcPayStatus = ztcPayStatus;
    }

    public Integer getZtcPrice() {
        return ztcPrice;
    }

    public void setZtcPrice(Integer ztcPrice) {
        this.ztcPrice = ztcPrice;
    }

    public Integer getZtcStatus() {
        return ztcStatus;
    }

    public void setZtcStatus(Integer ztcStatus) {
        this.ztcStatus = ztcStatus;
    }

    public Long getGcId() {
        return gcId;
    }

    public void setGcId(Long gcId) {
        this.gcId = gcId;
    }

    public Long getGoodsBrandId() {
        return goodsBrandId;
    }

    public void setGoodsBrandId(Long goodsBrandId) {
        this.goodsBrandId = goodsBrandId;
    }

    public Long getGoodsMainPhotoId() {
        return goodsMainPhotoId;
    }

    public void setGoodsMainPhotoId(Long goodsMainPhotoId) {
        this.goodsMainPhotoId = goodsMainPhotoId;
    }

    public Long getGoodsStoreId() {
        return goodsStoreId;
    }

    public void setGoodsStoreId(Long goodsStoreId) {
        this.goodsStoreId = goodsStoreId;
    }

    public Long getZtcAdminId() {
        return ztcAdminId;
    }

    public void setZtcAdminId(Long ztcAdminId) {
        this.ztcAdminId = ztcAdminId;
    }

    public Integer getGoodsCollect() {
        return goodsCollect;
    }

    public void setGoodsCollect(Integer goodsCollect) {
        this.goodsCollect = goodsCollect;
    }

    public Integer getGroupBuy() {
        return groupBuy;
    }

    public void setGroupBuy(Integer groupBuy) {
        this.groupBuy = groupBuy;
    }

    public Integer getGoodsChoiceType() {
        return goodsChoiceType;
    }

    public void setGoodsChoiceType(Integer goodsChoiceType) {
        this.goodsChoiceType = goodsChoiceType;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(Integer activityStatus) {
        this.activityStatus = activityStatus;
    }

    public Integer getBargainStatus() {
        return bargainStatus;
    }

    public void setBargainStatus(Integer bargainStatus) {
        this.bargainStatus = bargainStatus;
    }

    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public BigDecimal getGoodsCurrentPrice() {
        return goodsCurrentPrice;
    }

    public void setGoodsCurrentPrice(BigDecimal goodsCurrentPrice) {
        this.goodsCurrentPrice = goodsCurrentPrice;
    }

    public BigDecimal getGoodsVolume() {
        return goodsVolume;
    }

    public void setGoodsVolume(BigDecimal goodsVolume) {
        this.goodsVolume = goodsVolume;
    }

    public BigDecimal getEmsTransFee() {
        return emsTransFee;
    }

    public void setEmsTransFee(BigDecimal emsTransFee) {
        this.emsTransFee = emsTransFee;
    }

    public BigDecimal getExpressTransFee() {
        return expressTransFee;
    }

    public void setExpressTransFee(BigDecimal expressTransFee) {
        this.expressTransFee = expressTransFee;
    }

    public BigDecimal getMailTransFee() {
        return mailTransFee;
    }

    public void setMailTransFee(BigDecimal mailTransFee) {
        this.mailTransFee = mailTransFee;
    }

    public Long getTransportId() {
        return transportId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
    }

    public Integer getCombinStatus() {
        return combinStatus;
    }

    public void setCombinStatus(Integer combinStatus) {
        this.combinStatus = combinStatus;
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

    public BigDecimal getCombinPrice() {
        return combinPrice;
    }

    public void setCombinPrice(BigDecimal combinPrice) {
        this.combinPrice = combinPrice;
    }

    public Long getDescriptionEvaluate() {
        return descriptionEvaluate;
    }

    public void setDescriptionEvaluate(Long descriptionEvaluate) {
        this.descriptionEvaluate = descriptionEvaluate;
    }

    public Boolean getWeixinShopHot() {
        return weixinShopHot;
    }

    public void setWeixinShopHot(Boolean weixinShopHot) {
        this.weixinShopHot = weixinShopHot;
    }

    public Date getWeixinShopHottime() {
        return weixinShopHottime;
    }

    public void setWeixinShopHottime(Date weixinShopHottime) {
        this.weixinShopHottime = weixinShopHottime;
    }

    public Boolean getWeixinShopRecommend() {
        return weixinShopRecommend;
    }

    public void setWeixinShopRecommend(Boolean weixinShopRecommend) {
        this.weixinShopRecommend = weixinShopRecommend;
    }

    public Date getWeixinShopRecommendtime() {
        return weixinShopRecommendtime;
    }

    public void setWeixinShopRecommendtime(Date weixinShopRecommendtime) {
        this.weixinShopRecommendtime = weixinShopRecommendtime;
    }
}
