package com.xdj.www.entity;

import java.util.Date;

public class ShoppingVmessage extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long storeId;

    private String fromusername;

    private String msgtype;

    private String jsonMap;

    private Integer status;

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

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getFromusername() {
        return fromusername;
    }

    public void setFromusername(String fromusername) {
        this.fromusername = fromusername == null ? null : fromusername.trim();
    }

    public String getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(String msgtype) {
        this.msgtype = msgtype == null ? null : msgtype.trim();
    }

    public String getJsonMap() {
        return jsonMap;
    }

    public void setJsonMap(String jsonMap) {
        this.jsonMap = jsonMap == null ? null : jsonMap.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}