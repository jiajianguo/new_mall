package com.xdj.www.entity;

import java.util.Date;

public class ShoppingSpareGoods extends BaseEntity{
    private ShoppingAccessory main_img;
    private  ShoppingUser user;

    private ShoppingArea area;

    public ShoppingArea getArea() {
        return area;
    }

    public void setArea(ShoppingArea area) {
        this.area = area;
    }

    public ShoppingUser getUser() {
        return user;
    }

    public void setUser(ShoppingUser user) {
        this.user = user;
    }

    public ShoppingAccessory getMain_img() {
        return main_img;
    }

    public void setMain_img(ShoppingAccessory main_img) {
        this.main_img = main_img;
    }

    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String contact;

    private String errormessage;

    private Integer goodsOldPrice;

    private Integer goodsPrice;

    private String name;

    private Integer oldandnew;

    private Integer sellmethod;

    private Integer status;

    private String title;

    private Long areaId;

    private Long imgId;

    private Long sparegoodsclassId;

    private Long userId;

    private String phone;

    private Long img1Id;

    private Long img2Id;

    private Long img3Id;

    private Long img4Id;

    private Long mainImgId;

    private Long img5Id;

    private Boolean viewinfloor;

    private Long sgfId;

    private String qq;

    private Boolean recommend;

    private Integer down;

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

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact == null ? null : contact.trim();
    }

    public String getErrormessage() {
        return errormessage;
    }

    public void setErrormessage(String errormessage) {
        this.errormessage = errormessage == null ? null : errormessage.trim();
    }

    public Integer getGoodsOldPrice() {
        return goodsOldPrice;
    }

    public void setGoodsOldPrice(Integer goodsOldPrice) {
        this.goodsOldPrice = goodsOldPrice;
    }

    public Integer getGoodsPrice() {
        return goodsPrice;
    }

    public void setGoodsPrice(Integer goodsPrice) {
        this.goodsPrice = goodsPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getOldandnew() {
        return oldandnew;
    }

    public void setOldandnew(Integer oldandnew) {
        this.oldandnew = oldandnew;
    }

    public Integer getSellmethod() {
        return sellmethod;
    }

    public void setSellmethod(Integer sellmethod) {
        this.sellmethod = sellmethod;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Long getAreaId() {
        return areaId;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getImgId() {
        return imgId;
    }

    public void setImgId(Long imgId) {
        this.imgId = imgId;
    }

    public Long getSparegoodsclassId() {
        return sparegoodsclassId;
    }

    public void setSparegoodsclassId(Long sparegoodsclassId) {
        this.sparegoodsclassId = sparegoodsclassId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getImg1Id() {
        return img1Id;
    }

    public void setImg1Id(Long img1Id) {
        this.img1Id = img1Id;
    }

    public Long getImg2Id() {
        return img2Id;
    }

    public void setImg2Id(Long img2Id) {
        this.img2Id = img2Id;
    }

    public Long getImg3Id() {
        return img3Id;
    }

    public void setImg3Id(Long img3Id) {
        this.img3Id = img3Id;
    }

    public Long getImg4Id() {
        return img4Id;
    }

    public void setImg4Id(Long img4Id) {
        this.img4Id = img4Id;
    }

    public Long getMainImgId() {
        return mainImgId;
    }

    public void setMainImgId(Long mainImgId) {
        this.mainImgId = mainImgId;
    }

    public Long getImg5Id() {
        return img5Id;
    }

    public void setImg5Id(Long img5Id) {
        this.img5Id = img5Id;
    }

    public Boolean getViewinfloor() {
        return viewinfloor;
    }

    public void setViewinfloor(Boolean viewinfloor) {
        this.viewinfloor = viewinfloor;
    }

    public Long getSgfId() {
        return sgfId;
    }

    public void setSgfId(Long sgfId) {
        this.sgfId = sgfId;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public Boolean getRecommend() {
        return recommend;
    }

    public void setRecommend(Boolean recommend) {
        this.recommend = recommend;
    }

    public Integer getDown() {
        return down;
    }

    public void setDown(Integer down) {
        this.down = down;
    }
}
