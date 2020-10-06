package com.xdj.www.entity;

import java.util.Date;

public class ShoppingArticle extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Boolean display;

    private String mark;

    private Integer sequence;

    private String title;

    private String url;

    private Long articleclassId;

    private String content;

    private ShoppingArticleclass articleClass;

    public ShoppingArticleclass getArticleClass() {
        return articleClass;
    }

    public void setArticleClass(ShoppingArticleclass articleClass) {
        this.articleClass = articleClass;
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

    public Boolean getDisplay() {
        return display;
    }

    public void setDisplay(Boolean display) {
        this.display = display;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getArticleclassId() {
        return articleclassId;
    }

    public void setArticleclassId(Long articleclassId) {
        this.articleclassId = articleclassId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
