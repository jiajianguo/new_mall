package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

public class ShoppingSpareGoodsclass extends BaseEntity{
    /**
     * 新加变量
     */
    //余下商品子类型
    private List<ShoppingSpareGoodsclass> childs;

    public List<ShoppingSpareGoodsclass> getChilds() {
        return childs;
    }

    public void setChilds(List<ShoppingSpareGoodsclass> childs) {
        this.childs = childs;
    }
    //余下商品父类
    private ShoppingSpareGoodsclass parent;

    public ShoppingSpareGoodsclass getParent() {
        return parent;
    }

    public void setParent(ShoppingSpareGoodsclass parent) {
        this.parent = parent;
    }

    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String classname;

    private Integer level;

    private Integer sequence;

    private Long parentId;

    private Boolean viewinfloor;

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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Boolean getViewinfloor() {
        return viewinfloor;
    }

    public void setViewinfloor(Boolean viewinfloor) {
        this.viewinfloor = viewinfloor;
    }
}
