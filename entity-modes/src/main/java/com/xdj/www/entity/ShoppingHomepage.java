package com.xdj.www.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingHomepage extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long ownerId;

    private List<ShoppingVisit> customers = new ArrayList();

    public List<ShoppingVisit> getCustomers() {
        return customers;
    }

    public void setCustomers(List<ShoppingVisit> customers) {
        this.customers = customers;
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

    public Long getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Long ownerId) {
        this.ownerId = ownerId;
    }
}
