package com.xdj.www.entity;

public class UserRoles extends BaseEntity{
    private Integer userId;

    private Integer rolesId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }
}