package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @content  订单配送信息
 * @author Administrator
 */
public class ShoppingShipping extends BaseEntity{
    private Long id;
    private Date addtime;
    private Boolean deletestatus;
    private Integer sequence;
    private BigDecimal shippingAddFee;
    private Integer shippingAddWeight;
    private BigDecimal shippingFee;
    private String shippingName;
    private Integer shippingWeight;
    private Integer status;
    private Long storeId;
    private String shippingInfo;

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

    public BigDecimal getShippingAddFee() {
        return shippingAddFee;
    }

    public void setShippingAddFee(BigDecimal shippingAddFee) {
        this.shippingAddFee = shippingAddFee;
    }

    public Integer getShippingAddWeight() {
        return shippingAddWeight;
    }

    public void setShippingAddWeight(Integer shippingAddWeight) {
        this.shippingAddWeight = shippingAddWeight;
    }

    public BigDecimal getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(BigDecimal shippingFee) {
        this.shippingFee = shippingFee;
    }

    public String getShippingName() {
        return shippingName;
    }

    public void setShippingName(String shippingName) {
        this.shippingName = shippingName == null ? null : shippingName.trim();
    }

    public Integer getShippingWeight() {
        return shippingWeight;
    }

    public void setShippingWeight(Integer shippingWeight) {
        this.shippingWeight = shippingWeight;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public String getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(String shippingInfo) {
        this.shippingInfo = shippingInfo == null ? null : shippingInfo.trim();
    }
}
