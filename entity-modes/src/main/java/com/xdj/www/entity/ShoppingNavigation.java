package com.xdj.www.entity;

import java.util.Date;

public class ShoppingNavigation extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Boolean display;

    private Integer location;

    private Integer newWin;

    private Integer sequence;

    private Boolean sysnav;

    private String title;

    private String type;

    private Long typeId;

    private String url;

    private String originalUrl;

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

    public Integer getLocation() {
        return location;
    }

    public void setLocation(Integer location) {
        this.location = location;
    }

    public Integer getNewWin() {
        return newWin;
    }

    public void setNewWin(Integer newWin) {
        this.newWin = newWin;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Boolean getSysnav() {
        return sysnav;
    }

    public void setSysnav(Boolean sysnav) {
        this.sysnav = sysnav;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getOriginalUrl() {
        return originalUrl;
    }

    public void setOriginalUrl(String originalUrl) {
        this.originalUrl = originalUrl == null ? null : originalUrl.trim();
    }

    @Override
    public String toString() {
        return "ShoppingNavigation{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", deletestatus=" + deletestatus +
                ", display=" + display +
                ", location=" + location +
                ", newWin=" + newWin +
                ", sequence=" + sequence +
                ", sysnav=" + sysnav +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", typeId=" + typeId +
                ", url='" + url + '\'' +
                ", originalUrl='" + originalUrl + '\'' +
                '}';
    }
}
