package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingGoodsbrand extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Boolean audit;

    private String name;

    private Boolean recommend;

    private Integer sequence;

    private Long brandlogoId;

    private Long categoryId;

    private Integer userstatus;

    private Long userId;

    private Boolean weixinShopRecommend;

    private Date weixinShopRecommendtime;

    private String firstWord;

    private String remark;

    private ShoppingAccessory brandLogo;

    private List<ShoppingGoods> goodsList ;

    public ShoppingAccessory getBrandLogo() {
        return brandLogo;
    }

    public void setBrandLogo(ShoppingAccessory brandLogo) {
        this.brandLogo = brandLogo;
    }

    public List<ShoppingGoods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<ShoppingGoods> goodsList) {
        this.goodsList = goodsList;
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

    public Boolean getAudit() {
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getBrandlogoId() {
        return brandlogoId;
    }

    public void setBrandlogoId(Long brandlogoId) {
        this.brandlogoId = brandlogoId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(Integer userstatus) {
        this.userstatus = userstatus;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public String getFirstWord() {
        return firstWord;
    }

    public void setFirstWord(String firstWord) {
        this.firstWord = firstWord == null ? null : firstWord.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    @Override
    public String toString() {
        return "ShoppingGoodsbrand{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", deletestatus=" + deletestatus +
                ", audit=" + audit +
                ", name='" + name + '\'' +
                ", recommend=" + recommend +
                ", sequence=" + sequence +
                ", brandlogoId=" + brandlogoId +
                ", categoryId=" + categoryId +
                ", userstatus=" + userstatus +
                ", userId=" + userId +
                ", weixinShopRecommend=" + weixinShopRecommend +
                ", weixinShopRecommendtime=" + weixinShopRecommendtime +
                ", firstWord='" + firstWord + '\'' +
                ", remark='" + remark + '\'' +
                ", brandLogo=" + brandLogo +
                ", goodsList=" + goodsList +
                '}';
    }
}
