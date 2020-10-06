package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingIntegralGoodsorder extends BaseEntity{
    //新加入的变量
    //地址
    private ShoppingAddress igo_addr;
    //用户
    private ShoppingUser igo_user;
    //商品运输集合
    private List<ShoppingIntegralGoodscart> igo_gcs = new ArrayList();

    public ShoppingAddress getIgo_addr() {
        return igo_addr;
    }

    public void setIgo_addr(ShoppingAddress igo_addr) {
        this.igo_addr = igo_addr;
    }

    public ShoppingUser getIgo_user() {
        return igo_user;
    }

    public void setIgo_user(ShoppingUser igo_user) {
        this.igo_user = igo_user;
    }

    public List<ShoppingIntegralGoodscart> getIgo_gcs() {
        return igo_gcs;
    }

    public void setIgo_gcs(List<ShoppingIntegralGoodscart> igo_gcs) {
        this.igo_gcs = igo_gcs;
    }

    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String igoOrderSn;

    private Date igoPayTime;

    private String igoPayment;

    private String igoShipCode;

    private Date igoShipTime;

    private Integer igoStatus;

    private Integer igoTotalIntegral;

    private BigDecimal igoTransFee;

    private Long igoAddrId;

    private Long igoUserId;

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

    public String getIgoOrderSn() {
        return igoOrderSn;
    }

    public void setIgoOrderSn(String igoOrderSn) {
        this.igoOrderSn = igoOrderSn == null ? null : igoOrderSn.trim();
    }

    public Date getIgoPayTime() {
        return igoPayTime;
    }

    public void setIgoPayTime(Date igoPayTime) {
        this.igoPayTime = igoPayTime;
    }

    public String getIgoPayment() {
        return igoPayment;
    }

    public void setIgoPayment(String igoPayment) {
        this.igoPayment = igoPayment == null ? null : igoPayment.trim();
    }

    public String getIgoShipCode() {
        return igoShipCode;
    }

    public void setIgoShipCode(String igoShipCode) {
        this.igoShipCode = igoShipCode == null ? null : igoShipCode.trim();
    }

    public Date getIgoShipTime() {
        return igoShipTime;
    }

    public void setIgoShipTime(Date igoShipTime) {
        this.igoShipTime = igoShipTime;
    }

    public Integer getIgoStatus() {
        return igoStatus;
    }

    public void setIgoStatus(Integer igoStatus) {
        this.igoStatus = igoStatus;
    }

    public Integer getIgoTotalIntegral() {
        return igoTotalIntegral;
    }

    public void setIgoTotalIntegral(Integer igoTotalIntegral) {
        this.igoTotalIntegral = igoTotalIntegral;
    }

    public BigDecimal getIgoTransFee() {
        return igoTransFee;
    }

    public void setIgoTransFee(BigDecimal igoTransFee) {
        this.igoTransFee = igoTransFee;
    }

    public Long getIgoAddrId() {
        return igoAddrId;
    }

    public void setIgoAddrId(Long igoAddrId) {
        this.igoAddrId = igoAddrId;
    }

    public Long getIgoUserId() {
        return igoUserId;
    }

    public void setIgoUserId(Long igoUserId) {
        this.igoUserId = igoUserId;
    }
}
