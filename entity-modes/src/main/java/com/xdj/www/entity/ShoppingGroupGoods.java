package com.xdj.www.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","fieldHandler"})
public class ShoppingGroupGoods implements Serializable {
    private static final long serialVersionUID = 8269971132565706L;
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Date ggAuditTime;

    private Integer ggCount;

    private Integer ggDefCount;

    private Integer ggGroupCount;

    private Integer ggMaxCount;

    private Integer ggMinCount;

    private String ggName;

    private BigDecimal ggPrice;

    private BigDecimal ggRebate;

    private Integer ggRecommend;

    private Date ggRecommendTime;

    private Integer ggStatus;

    private Integer ggVirCount;

    private Long ggGaId;

    private Long ggGcId;

    private Long ggGoodsId;

    private Long ggImgId;

    private Long groupId;

    private Boolean weixinShopRecommend;

    private Date weixinShopRecommendtime;

    private String ggContent;
    @JsonIgnoreProperties(value = { "handler" })
    private ShoppingGoodsWithBLOBs gg_goods;
    @JsonIgnoreProperties(value = { "handler" })
    private ShoppingAccessory gg_img;

    @JsonIgnoreProperties(value = { "handler" })
    private ShoppingGroup group;

    public ShoppingGroup getGroup() {
        return group;
    }

    public void setGroup(ShoppingGroup group) {
        this.group = group;
    }

    public ShoppingAccessory getGg_img() {
        return gg_img;
    }

    public void setGg_img(ShoppingAccessory gg_img) {
        this.gg_img = gg_img;
    }

    public ShoppingGoodsWithBLOBs getGg_goods() {
        return gg_goods;
    }

    public void setGg_goods(ShoppingGoodsWithBLOBs gg_goods) {
        this.gg_goods = gg_goods;
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

    public Date getGgAuditTime() {
        return ggAuditTime;
    }

    public void setGgAuditTime(Date ggAuditTime) {
        this.ggAuditTime = ggAuditTime;
    }

    public Integer getGgCount() {
        return ggCount;
    }

    public void setGgCount(Integer ggCount) {
        this.ggCount = ggCount;
    }

    public Integer getGgDefCount() {
        return ggDefCount;
    }

    public void setGgDefCount(Integer ggDefCount) {
        this.ggDefCount = ggDefCount;
    }

    public Integer getGgGroupCount() {
        return ggGroupCount;
    }

    public void setGgGroupCount(Integer ggGroupCount) {
        this.ggGroupCount = ggGroupCount;
    }

    public Integer getGgMaxCount() {
        return ggMaxCount;
    }

    public void setGgMaxCount(Integer ggMaxCount) {
        this.ggMaxCount = ggMaxCount;
    }

    public Integer getGgMinCount() {
        return ggMinCount;
    }

    public void setGgMinCount(Integer ggMinCount) {
        this.ggMinCount = ggMinCount;
    }

    public String getGgName() {
        return ggName;
    }

    public void setGgName(String ggName) {
        this.ggName = ggName == null ? null : ggName.trim();
    }

    public BigDecimal getGgPrice() {
        return ggPrice;
    }

    public void setGgPrice(BigDecimal ggPrice) {
        this.ggPrice = ggPrice;
    }

    public BigDecimal getGgRebate() {
        return ggRebate;
    }

    public void setGgRebate(BigDecimal ggRebate) {
        this.ggRebate = ggRebate;
    }

    public Integer getGgRecommend() {
        return ggRecommend;
    }

    public void setGgRecommend(Integer ggRecommend) {
        this.ggRecommend = ggRecommend;
    }

    public Date getGgRecommendTime() {
        return ggRecommendTime;
    }

    public void setGgRecommendTime(Date ggRecommendTime) {
        this.ggRecommendTime = ggRecommendTime;
    }

    public Integer getGgStatus() {
        return ggStatus;
    }

    public void setGgStatus(Integer ggStatus) {
        this.ggStatus = ggStatus;
    }

    public Integer getGgVirCount() {
        return ggVirCount;
    }

    public void setGgVirCount(Integer ggVirCount) {
        this.ggVirCount = ggVirCount;
    }

    public Long getGgGaId() {
        return ggGaId;
    }

    public void setGgGaId(Long ggGaId) {
        this.ggGaId = ggGaId;
    }

    public Long getGgGcId() {
        return ggGcId;
    }

    public void setGgGcId(Long ggGcId) {
        this.ggGcId = ggGcId;
    }

    public Long getGgGoodsId() {
        return ggGoodsId;
    }

    public void setGgGoodsId(Long ggGoodsId) {
        this.ggGoodsId = ggGoodsId;
    }

    public Long getGgImgId() {
        return ggImgId;
    }

    public void setGgImgId(Long ggImgId) {
        this.ggImgId = ggImgId;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
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

    public String getGgContent() {
        return ggContent;
    }

    public void setGgContent(String ggContent) {
        this.ggContent = ggContent == null ? null : ggContent.trim();
    }
}
