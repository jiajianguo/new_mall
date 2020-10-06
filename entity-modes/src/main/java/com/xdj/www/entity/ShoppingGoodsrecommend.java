package com.xdj.www.entity;

import java.util.Date;

public class ShoppingGoodsrecommend extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer browsenum;

    private Integer goodsnum;

    private Integer imageheight;

    private Integer imagewidth;

    private String remarkinfo;

    private Integer sequence;

    private Integer shownum;

    private String stylename;

    private String typename;

    private String code;

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

    public Integer getBrowsenum() {
        return browsenum;
    }

    public void setBrowsenum(Integer browsenum) {
        this.browsenum = browsenum;
    }

    public Integer getGoodsnum() {
        return goodsnum;
    }

    public void setGoodsnum(Integer goodsnum) {
        this.goodsnum = goodsnum;
    }

    public Integer getImageheight() {
        return imageheight;
    }

    public void setImageheight(Integer imageheight) {
        this.imageheight = imageheight;
    }

    public Integer getImagewidth() {
        return imagewidth;
    }

    public void setImagewidth(Integer imagewidth) {
        this.imagewidth = imagewidth;
    }

    public String getRemarkinfo() {
        return remarkinfo;
    }

    public void setRemarkinfo(String remarkinfo) {
        this.remarkinfo = remarkinfo == null ? null : remarkinfo.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getShownum() {
        return shownum;
    }

    public void setShownum(Integer shownum) {
        this.shownum = shownum;
    }

    public String getStylename() {
        return stylename;
    }

    public void setStylename(String stylename) {
        this.stylename = stylename == null ? null : stylename.trim();
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename == null ? null : typename.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }
}