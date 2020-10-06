package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingUsergoodsclass extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String classname;

    private Boolean display;

    private Integer level;

    private Integer sequence;

    private Long parentId;

    private Long userId;

    private  Long  storeGcimgId;

    private ShoppingAccessory store_gc_img ;

    public Long getStoreGcimgId() {
        return storeGcimgId;
    }

    public void setStoreGcimgId(Long storeGcimgId) {
        this.storeGcimgId = storeGcimgId;
    }

    public ShoppingAccessory getStore_gc_img() {
        return store_gc_img;
    }

    public void setStore_gc_img(ShoppingAccessory store_gc_img) {
        this.store_gc_img = store_gc_img;
    }

    private List<ShoppingUsergoodsclass> childs;

    public List<ShoppingUsergoodsclass> getChilds() {
        return childs;
    }

    public void setChilds(List<ShoppingUsergoodsclass> childs) {
        this.childs = childs;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
