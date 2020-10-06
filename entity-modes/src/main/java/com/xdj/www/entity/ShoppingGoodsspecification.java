package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingGoodsspecification extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String name;

    private Integer sequence;

    private String type;

    private List<ShoppingGoodstypeproperty> properties;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    @Override
    public String toString() {
        return "ShoppingGoodsspecification{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", deletestatus=" + deletestatus +
                ", name='" + name + '\'' +
                ", sequence=" + sequence +
                ", type='" + type + '\'' +
                '}';
    }
}
