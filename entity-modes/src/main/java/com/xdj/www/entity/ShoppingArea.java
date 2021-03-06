package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingArea extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String areaname;

    private Integer level;

    private Integer sequence;

    private Long parentId;

    private Boolean common;

    private ShoppingArea parent;

    private List<ShoppingArea> childs;

    public List<ShoppingArea> getChilds() {
        return childs;
    }

    public void setChilds(List<ShoppingArea> childs) {
        this.childs = childs;
    }

    public ShoppingArea getParent() {
        return parent;
    }

    public void setParent(ShoppingArea parent) {
        this.parent = parent;
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

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname == null ? null : areaname.trim();
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

    public Boolean getCommon() {
        return common;
    }

    public void setCommon(Boolean common) {
        this.common = common;
    }
}
