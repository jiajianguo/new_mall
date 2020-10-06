package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author Administrator
 */
public class ShoppingSecondsKill extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Long sgGoodsId;

    private BigDecimal secondsPrice;

    private String beginTime;

    private String endTime;

    private String description;

    private Long count;

    private Long sellCount;

    private Long sort;

    private Long version;

    private Date finishTime;

    private Date startTime;

    private Integer sgStatus;

    private Integer sgMaxCount;

    private Long sgImgId;

    private String sgName;

    public Long getSellCount() {
        return sellCount;
    }

    public void setSellCount(Long sellCount) {
        this.sellCount = sellCount;
    }

    private ShoppingAccessory sg_img;

    private ShoppingGoodsWithBLOBs goods;

    public ShoppingGoodsWithBLOBs getGoods() {
        return goods;
    }

    public void setGoods(ShoppingGoodsWithBLOBs goods) {
        this.goods = goods;
    }

    public ShoppingAccessory getSg_img() {
        return sg_img;
    }

    public void setSg_img(ShoppingAccessory sg_img) {
        this.sg_img = sg_img;
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

    public Long getSgGoodsId() {
        return sgGoodsId;
    }

    public void setSgGoodsId(Long sgGoodsId) {
        this.sgGoodsId = sgGoodsId;
    }

    public BigDecimal getSecondsPrice() {
        return secondsPrice;
    }

    public void setSecondsPrice(BigDecimal secondsPrice) {
        this.secondsPrice = secondsPrice;
    }

    public String getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(String beginTime) {
        this.beginTime = beginTime == null ? null : beginTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Long getSort() {
        return sort;
    }

    public void setSort(Long sort) {
        this.sort = sort;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(Date finishTime) {
        this.finishTime = finishTime;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Integer getSgStatus() {
        return sgStatus;
    }

    public void setSgStatus(Integer sgStatus) {
        this.sgStatus = sgStatus;
    }

    public Integer getSgMaxCount() {
        return sgMaxCount;
    }

    public void setSgMaxCount(Integer sgMaxCount) {
        this.sgMaxCount = sgMaxCount;
    }

    public Long getSgImgId() {
        return sgImgId;
    }

    public void setSgImgId(Long sgImgId) {
        this.sgImgId = sgImgId;
    }

    public String getSgName() {
        return sgName;
    }

    public void setSgName(String sgName) {
        this.sgName = sgName == null ? null : sgName.trim();
    }

    @Override
    public String toString() {
        return "ShoppingSecondsKill{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", deletestatus=" + deletestatus +
                ", sgGoodsId=" + sgGoodsId +
                ", secondsPrice=" + secondsPrice +
                ", beginTime='" + beginTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", description='" + description + '\'' +
                ", count=" + count +
                ", sort=" + sort +
                ", version=" + version +
                ", finishTime=" + finishTime +
                ", startTime=" + startTime +
                ", sgStatus=" + sgStatus +
                ", sgMaxCount=" + sgMaxCount +
                ", sgImgId=" + sgImgId +
                ", sgName='" + sgName + '\'' +
                ", sg_img=" + sg_img +
                ", goods=" + goods +
                '}';
    }
}
