package com.xdj.www.entity;

import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingAdvPos extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String apAccUrl;

    private Integer apHeight;

    private Integer apPrice;

    private Integer apSaleType;

    private Integer apShowType;

    private Integer apStatus;

    private Integer apSysType;

    private String apText;

    private String apTitle;

    private String apType;

    private Integer apUseStatus;

    private Integer apWidth;

    private Long apAccId;

    private Long advId;


    /**
     * 广告图片
     */
    private ShoppingAccessory apAcc;
    /**
     * 广告
     */
    private List<ShoppingAdvert> advs ;


    public Long getAdvId() {
        return advId;
    }

    public void setAdvId(Long advId) {
        this.advId = advId;
    }

    public ShoppingAccessory getApAcc() {
        return apAcc;
    }

    public void setApAcc(ShoppingAccessory apAcc) {
        this.apAcc = apAcc;
    }

    public List<ShoppingAdvert> getAdvs() {
        return advs;
    }

    public void setAdvs(List<ShoppingAdvert> advs) {
        this.advs = advs;
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

    public String getApAccUrl() {
        return apAccUrl;
    }

    public void setApAccUrl(String apAccUrl) {
        this.apAccUrl = apAccUrl == null ? null : apAccUrl.trim();
    }

    public Integer getApHeight() {
        return apHeight;
    }

    public void setApHeight(Integer apHeight) {
        this.apHeight = apHeight;
    }

    public Integer getApPrice() {
        return apPrice;
    }

    public void setApPrice(Integer apPrice) {
        this.apPrice = apPrice;
    }

    public Integer getApSaleType() {
        return apSaleType;
    }

    public void setApSaleType(Integer apSaleType) {
        this.apSaleType = apSaleType;
    }

    public Integer getApShowType() {
        return apShowType;
    }

    public void setApShowType(Integer apShowType) {
        this.apShowType = apShowType;
    }

    public Integer getApStatus() {
        return apStatus;
    }

    public void setApStatus(Integer apStatus) {
        this.apStatus = apStatus;
    }

    public Integer getApSysType() {
        return apSysType;
    }

    public void setApSysType(Integer apSysType) {
        this.apSysType = apSysType;
    }

    public String getApText() {
        return apText;
    }

    public void setApText(String apText) {
        this.apText = apText == null ? null : apText.trim();
    }

    public String getApTitle() {
        return apTitle;
    }

    public void setApTitle(String apTitle) {
        this.apTitle = apTitle == null ? null : apTitle.trim();
    }

    public String getApType() {
        return apType;
    }

    public void setApType(String apType) {
        this.apType = apType == null ? null : apType.trim();
    }

    public Integer getApUseStatus() {
        return apUseStatus;
    }

    public void setApUseStatus(Integer apUseStatus) {
        this.apUseStatus = apUseStatus;
    }

    public Integer getApWidth() {
        return apWidth;
    }

    public void setApWidth(Integer apWidth) {
        this.apWidth = apWidth;
    }

    public Long getApAccId() {
        return apAccId;
    }

    public void setApAccId(Long apAccId) {
        this.apAccId = apAccId;
    }
}
