package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

public class ShoppingArticleclass extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String classname;

    private Integer level;

    private String mark;

    private Integer sequence;

    private Boolean sysclass;

    private Long parentId;
    private List<ShoppingArticle> articles;

    public List<ShoppingArticle> getArticles() {
        return articles;
    }

    public void setArticles(List<ShoppingArticle> articles) {
        this.articles = articles;
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

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Boolean getSysclass() {
        return sysclass;
    }

    public void setSysclass(Boolean sysclass) {
        this.sysclass = sysclass;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }
}
