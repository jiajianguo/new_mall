package com.xdj.www.entity;

import java.util.Date;

public class ShoppingVmenu extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String menuKey;

    private String menuName;

    private String menuType;

    private String menuUrl;

    private Long parentId;

    private Long storeId;

    private Integer menuSequence;

    private String menuCat;

    private String menuKeyContent;

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

    public String getMenuKey() {
        return menuKey;
    }

    public void setMenuKey(String menuKey) {
        this.menuKey = menuKey == null ? null : menuKey.trim();
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName == null ? null : menuName.trim();
    }

    public String getMenuType() {
        return menuType;
    }

    public void setMenuType(String menuType) {
        this.menuType = menuType == null ? null : menuType.trim();
    }

    public String getMenuUrl() {
        return menuUrl;
    }

    public void setMenuUrl(String menuUrl) {
        this.menuUrl = menuUrl == null ? null : menuUrl.trim();
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Integer getMenuSequence() {
        return menuSequence;
    }

    public void setMenuSequence(Integer menuSequence) {
        this.menuSequence = menuSequence;
    }

    public String getMenuCat() {
        return menuCat;
    }

    public void setMenuCat(String menuCat) {
        this.menuCat = menuCat == null ? null : menuCat.trim();
    }

    public String getMenuKeyContent() {
        return menuKeyContent;
    }

    public void setMenuKeyContent(String menuKeyContent) {
        this.menuKeyContent = menuKeyContent == null ? null : menuKeyContent.trim();
    }
}