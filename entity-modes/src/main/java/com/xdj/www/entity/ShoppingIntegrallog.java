package com.xdj.www.entity;

import java.util.Date;

public class ShoppingIntegrallog extends BaseEntity{
    //用户
    private ShoppingUser integral_user;
    //操作者
    private ShoppingUser operate_user;

    public ShoppingUser getIntegral_user() {
        return integral_user;
    }

    public void setIntegral_user(ShoppingUser integral_user) {
        this.integral_user = integral_user;
    }

    public ShoppingUser getOperate_user() {
        return operate_user;
    }

    public void setOperate_user(ShoppingUser operate_user) {
        this.operate_user = operate_user;
    }

    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer integral;

    private String type;

    private Long integralUserId;

    private Long operateUserId;

    private String content;

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

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Long getIntegralUserId() {
        return integralUserId;
    }

    public void setIntegralUserId(Long integralUserId) {
        this.integralUserId = integralUserId;
    }

    public Long getOperateUserId() {
        return operateUserId;
    }

    public void setOperateUserId(Long operateUserId) {
        this.operateUserId = operateUserId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
