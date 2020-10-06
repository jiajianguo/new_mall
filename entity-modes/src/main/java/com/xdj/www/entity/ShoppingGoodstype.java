package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

public class ShoppingGoodstype extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String name;

    private Integer sequence;

    private List<ShoppingGoodsspecification> gss ;

    private List<ShoppingGoodstypeproperty> properties;

    private List<ShoppingGoodsbrand> gbs;

    public List<ShoppingGoodsbrand> getGbs() {
        return gbs;
    }

    public void setGbs(List<ShoppingGoodsbrand> gbs) {
        this.gbs = gbs;
    }

    public List<ShoppingGoodsspecification> getGss() {
        return gss;
    }

    public void setGss(List<ShoppingGoodsspecification> gss) {
        this.gss = gss;
    }

    public List<ShoppingGoodstypeproperty> getProperties() {
        return properties;
    }

    public void setProperties(List<ShoppingGoodstypeproperty> properties) {
        this.properties = properties;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }
}
