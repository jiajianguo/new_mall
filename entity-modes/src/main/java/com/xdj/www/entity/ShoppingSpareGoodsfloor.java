package com.xdj.www.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingSpareGoodsfloor extends BaseEntity{
    //余下商品的类型
    private ShoppingSpareGoodsclass sgc;
    //余下商品
    private List<ShoppingSpareGoodsWithBLOBs> sgs;

    public List<ShoppingSpareGoodsWithBLOBs> getSgs() {
        return sgs;
    }

    public void setSgs(List<ShoppingSpareGoodsWithBLOBs> sgs) {
        this.sgs = sgs;
    }

    List<ShoppingSpareGoodsclass>  f_class;

    public List<ShoppingSpareGoodsclass> getF_class() {
        return f_class;
    }

    public void setF_class(List<ShoppingSpareGoodsclass> f_class) {
        this.f_class = f_class;
    }

    public ShoppingSpareGoodsclass getSgc() {
        return sgc;
    }
    public void setSgc(ShoppingSpareGoodsclass sgc) {
        this.sgc = sgc;
    }

    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String adverId;

    private Integer sequence;

    private String title;

    private Integer visable;

    private Long sgcId;

    private Integer adverType;

    private String advertUrl;

    private Long advertId;

    private Long advertImgId;

    private Boolean display;

    private Long adpId;

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

    public String getAdverId() {
        return adverId;
    }

    public void setAdverId(String adverId) {
        this.adverId = adverId == null ? null : adverId.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getVisable() {
        return visable;
    }

    public void setVisable(Integer visable) {
        this.visable = visable;
    }

    public Long getSgcId() {
        return sgcId;
    }

    public void setSgcId(Long sgcId) {
        this.sgcId = sgcId;
    }

    public Integer getAdverType() {
        return adverType;
    }

    public void setAdverType(Integer adverType) {
        this.adverType = adverType;
    }

    public String getAdvertUrl() {
        return advertUrl;
    }

    public void setAdvertUrl(String advertUrl) {
        this.advertUrl = advertUrl == null ? null : advertUrl.trim();
    }

    public Long getAdvertId() {
        return advertId;
    }

    public void setAdvertId(Long advertId) {
        this.advertId = advertId;
    }

    public Long getAdvertImgId() {
        return advertImgId;
    }

    public void setAdvertImgId(Long advertImgId) {
        this.advertImgId = advertImgId;
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Long getAdpId() {
        return adpId;
    }

    public void setAdpId(Long adpId) {
        this.adpId = adpId;
    }
}
