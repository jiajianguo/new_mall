package com.xdj.www.entity;

import java.util.Date;

/**
 * @author Administrator
 */
public class ShoppingOrderLog extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String logInfo;

    private Long logUserId;

    private Long ofId;

    private String stateInfo;

    private ShoppingUser log_user;

    public ShoppingUser getLog_user() {
        return log_user;
    }

    public void setLog_user(ShoppingUser log_user) {
        this.log_user = log_user;
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

    public String getLogInfo() {
        return logInfo;
    }

    public void setLogInfo(String logInfo) {
        this.logInfo = logInfo == null ? null : logInfo.trim();
    }

    public Long getLogUserId() {
        return logUserId;
    }

    public void setLogUserId(Long logUserId) {
        this.logUserId = logUserId;
    }

    public Long getOfId() {
        return ofId;
    }

    public void setOfId(Long ofId) {
        this.ofId = ofId;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo == null ? null : stateInfo.trim();
    }
}
