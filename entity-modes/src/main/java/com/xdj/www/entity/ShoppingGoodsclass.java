package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingGoodsclass extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String classname;

    private Boolean display;

    private Integer level;

    private Boolean recommend;

    private Integer sequence;

    private Long goodstypeId;

    private Long parentId;

    private String iconSys;

    private Integer iconType;

    private Long iconAccId;




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

    public String getClassname() {
        return classname;
    }

    public void setClassname(String classname) {
        this.classname = classname == null ? null : classname.trim();
    }

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
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

    public Long getGoodstypeId() {
        return goodstypeId;
    }

    public void setGoodstypeId(Long goodstypeId) {
        this.goodstypeId = goodstypeId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getIconSys() {
        return iconSys;
    }

    public void setIconSys(String iconSys) {
        this.iconSys = iconSys == null ? null : iconSys.trim();
    }

    public Integer getIconType() {
        return iconType;
    }

    public void setIconType(Integer iconType) {
        this.iconType = iconType;
    }

    public Long getIconAccId() {
        return iconAccId;
    }

    public void setIconAccId(Long iconAccId) {
        this.iconAccId = iconAccId;
    }

    @Override
    public String toString() {
        return "ShoppingGoodsclass{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", deletestatus=" + deletestatus +
                ", classname='" + classname + '\'' +
                ", display=" + display +
                ", level=" + level +
                ", recommend=" + recommend +
                ", sequence=" + sequence +
                ", goodstypeId=" + goodstypeId +
                ", parentId=" + parentId +
                ", iconSys='" + iconSys + '\'' +
                ", iconType=" + iconType +
                ", iconAccId=" + iconAccId +
                '}';
    }
}
