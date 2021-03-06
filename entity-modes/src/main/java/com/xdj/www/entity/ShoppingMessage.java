package com.xdj.www.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@JsonIgnoreProperties(value = {"hibernateLazyInitializer","handler","fieldHandler"})
public class ShoppingMessage extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer status;

    private String title;

    private Integer type;

    private Long fromuserId;

    private Long parentId;

    private Long touserId;

    private Integer replyStatus;

    private String content;

    private ShoppingUser fromUser;

    private ShoppingUser toUser;

    //父信息
    private ShoppingMessage parent;
    //回复信息
    List<ShoppingMessage> replys = new ArrayList();

    public ShoppingMessage getParent() {
        return parent;
    }

    public void setParent(ShoppingMessage parent) {
        this.parent = parent;
    }

    public List<ShoppingMessage> getReplys() {
        return replys;
    }

    public void setReplys(List<ShoppingMessage> replys) {
        this.replys = replys;
    }

    public ShoppingUser getFromUser() {
        return fromUser;
    }

    public void setFromUser(ShoppingUser fromUser) {
        this.fromUser = fromUser;
    }

    public ShoppingUser getToUser() {
        return toUser;
    }

    public void setToUser(ShoppingUser toUser) {
        this.toUser = toUser;
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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getFromuserId() {
        return fromuserId;
    }

    public void setFromuserId(Long fromuserId) {
        this.fromuserId = fromuserId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long getTouserId() {
        return touserId;
    }

    public void setTouserId(Long touserId) {
        this.touserId = touserId;
    }

    public Integer getReplyStatus() {
        return replyStatus;
    }

    public void setReplyStatus(Integer replyStatus) {
        this.replyStatus = replyStatus;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}