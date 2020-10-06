package com.xdj.www.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingStoreWithBLOBs extends ShoppingStore {
    private String storeInfo;

    private String storeSeoDescription;

    private String storeSeoKeywords;

    private String violationReseaon;

    private String weixinWelecomeContent;

    /**
     * store_point关联store_id
     */
    private ShoppingStorePoint point;

    /**
     * 关联位置信息
     */
    private ShoppingArea area;

    private ShoppingUser user;

    private ShoppingAccessory store_banner;

    private List<ShoppingGoodsWithBLOBs> goods_list;

    private ShoppingAccessory storeLogo;

    private ShoppingStoregrade grade;

    private ShoppingStorePoint sp;

    private ShoppingStoreclass sc;

    private List<ShoppingGoodsWithBLOBs> recommend_goods;

    public List<ShoppingGoodsWithBLOBs> getRecommend_goods() {
        return recommend_goods;
    }

    public void setRecommend_goods(List<ShoppingGoodsWithBLOBs> recommend_goods) {
        this.recommend_goods = recommend_goods;
    }

    private List<ShoppingStoreSlide> slides = new ArrayList();

    public ShoppingStoreclass getSc() {
        return sc;
    }

    public void setSc(ShoppingStoreclass sc) {
        this.sc = sc;
    }

    public List<ShoppingStoreSlide> getSlides() {
        return slides;
    }

    public void setSlides(List<ShoppingStoreSlide> slides) {
        this.slides = slides;
    }

    public ShoppingStorePoint getSp() {
        return sp;
    }

    public void setSp(ShoppingStorePoint sp) {
        this.sp = sp;
    }

    public ShoppingStoregrade getGrade() {
        return grade;
    }

    public void setGrade(ShoppingStoregrade grade) {
        this.grade = grade;
    }

    public ShoppingAccessory getStore_banner() {
        return store_banner;
    }

    public ShoppingAccessory getStoreLogo() {
        return storeLogo;
    }

    public void setStoreLogo(ShoppingAccessory storeLogo) {
        this.storeLogo = storeLogo;
    }

    public void setStore_banner(ShoppingAccessory store_banner) {
        this.store_banner = store_banner;
    }

    public ShoppingUser getUser() {
        return user;
    }

    public void setUser(ShoppingUser user) {
        this.user = user;
    }

    public List<ShoppingGoodsWithBLOBs> getGoods_list() {
        return goods_list;
    }

    public void setGoods_list(List<ShoppingGoodsWithBLOBs> goods_list) {
        this.goods_list = goods_list;
    }

    public ShoppingArea getArea() {
        return area;
    }

    public void setArea(ShoppingArea area) {
        this.area = area;
    }

    public ShoppingStorePoint getPoint() {
        return point;
    }

    public void setPoint(ShoppingStorePoint point) {
        this.point = point;
    }

    public String getStoreInfo() {
        return storeInfo;
    }

    public void setStoreInfo(String storeInfo) {
        this.storeInfo = storeInfo == null ? null : storeInfo.trim();
    }

    public String getStoreSeoDescription() {
        return storeSeoDescription;
    }

    public void setStoreSeoDescription(String storeSeoDescription) {
        this.storeSeoDescription = storeSeoDescription == null ? null : storeSeoDescription.trim();
    }

    public String getStoreSeoKeywords() {
        return storeSeoKeywords;
    }

    public void setStoreSeoKeywords(String storeSeoKeywords) {
        this.storeSeoKeywords = storeSeoKeywords == null ? null : storeSeoKeywords.trim();
    }

    public String getViolationReseaon() {
        return violationReseaon;
    }

    public void setViolationReseaon(String violationReseaon) {
        this.violationReseaon = violationReseaon == null ? null : violationReseaon.trim();
    }

    public String getWeixinWelecomeContent() {
        return weixinWelecomeContent;
    }

    public void setWeixinWelecomeContent(String weixinWelecomeContent) {
        this.weixinWelecomeContent = weixinWelecomeContent == null ? null : weixinWelecomeContent.trim();
    }

    @Override
    public String toString() {
        return "ShoppingStoreWithBLOBs{" +
                "storeInfo='" + storeInfo + '\'' +
                ", storeSeoDescription='" + storeSeoDescription + '\'' +
                ", storeSeoKeywords='" + storeSeoKeywords + '\'' +
                ", violationReseaon='" + violationReseaon + '\'' +
                ", weixinWelecomeContent='" + weixinWelecomeContent + '\'' +
                ", point=" + point +
                ", area=" + area +
                ", user=" + user +
                ", store_banner=" + store_banner +
                ", goods_list=" + goods_list +
                ", storeLogo=" + storeLogo +
                ", grade=" + grade +
                '}';
    }
}
