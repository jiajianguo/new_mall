package com.xdj.www.entity;

import java.util.Date;

/**
 * @author Administrator
 */
public class ShoppingStoregrade extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String addFunciton;

    private Boolean audit;

    private Integer goodscount;

    private Integer gradelevel;

    private String gradename;

    private String price;

    private Integer sequence;

    private Float spacesize;

    private Boolean sysgrade;

    private String templates;

    private Integer acountNum;

    private String content;

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

    public String getAddFunciton() {
        return addFunciton;
    }

    public void setAddFunciton(String addFunciton) {
        this.addFunciton = addFunciton == null ? null : addFunciton.trim();
    }

    public Boolean getAudit() {
        return audit;
    }

    public void setAudit(Boolean audit) {
        this.audit = audit;
    }

    public Integer getGoodscount() {
        return goodscount;
    }

    public void setGoodscount(Integer goodscount) {
        this.goodscount = goodscount;
    }

    public Integer getGradelevel() {
        return gradelevel;
    }

    public void setGradelevel(Integer gradelevel) {
        this.gradelevel = gradelevel;
    }

    public String getGradename() {
        return gradename;
    }

    public void setGradename(String gradename) {
        this.gradename = gradename == null ? null : gradename.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Float getSpacesize() {
        return spacesize;
    }

    public void setSpacesize(Float spacesize) {
        this.spacesize = spacesize;
    }

    public Boolean getSysgrade() {
        return sysgrade;
    }

    public void setSysgrade(Boolean sysgrade) {
        this.sysgrade = sysgrade;
    }

    public String getTemplates() {
        return templates;
    }

    public void setTemplates(String templates) {
        this.templates = templates == null ? null : templates.trim();
    }

    public Integer getAcountNum() {
        return acountNum;
    }

    public void setAcountNum(Integer acountNum) {
        this.acountNum = acountNum;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
