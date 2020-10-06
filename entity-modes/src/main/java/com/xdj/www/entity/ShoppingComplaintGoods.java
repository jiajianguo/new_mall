package com.xdj.www.entity;

import java.util.Date;

public class ShoppingComplaintGoods extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long complaintId;

    private Long goodsId;

    private String content;

    //商品
    private ShoppingGoodsWithBLOBs goods;

    //举报
    private ShoppingComplaintWithBLOBs complaint;

    public ShoppingComplaintWithBLOBs getComplaint() {
        return complaint;
    }

    public void setComplaint(ShoppingComplaintWithBLOBs complaint) {
        this.complaint = complaint;
    }

    public ShoppingGoodsWithBLOBs getGoods() {
        return goods;
    }

    public void setGoods(ShoppingGoodsWithBLOBs goods) {
        this.goods = goods;
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

    public Long getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Long complaintId) {
        this.complaintId = complaintId;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}