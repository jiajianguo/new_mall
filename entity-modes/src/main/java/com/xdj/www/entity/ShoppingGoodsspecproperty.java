package com.xdj.www.entity;

import java.util.Date;

/**
 * @author Administrator
 */
public class ShoppingGoodsspecproperty extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer sequence;

    private String value;

    private Long specId;

    private Long specimageId;

    /**
     * 规格属性图片
     */
    private ShoppingAccessory accessory;


    private ShoppingGoodsspecification spec;


    public ShoppingAccessory getAccessory() {
        return accessory;
    }

    public void setAccessory(ShoppingAccessory accessory) {
        this.accessory = accessory;
    }

    public ShoppingGoodsspecification getSpec() {
        return spec;
    }

    public void setSpec(ShoppingGoodsspecification spec) {
        this.spec = spec;
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

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }

    public Long getSpecId() {
        return specId;
    }

    public void setSpecId(Long specId) {
        this.specId = specId;
    }

    public Long getSpecimageId() {
        return specimageId;
    }

    public void setSpecimageId(Long specimageId) {
        this.specimageId = specimageId;
    }
}
