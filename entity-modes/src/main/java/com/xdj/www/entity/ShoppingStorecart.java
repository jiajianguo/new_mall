package com.xdj.www.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingStorecart extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private String cartSessionId;

    private BigDecimal totalPrice;

    private Long storeId;

    private Long userId;

    private Integer scStatus;

    /**
     * 购物车商品
     */
    private List<ShoppingGoodscart> gcs;

    private ShoppingStoreWithBLOBs store;

    private ShoppingUser user;

    public ShoppingUser getUser() {
        return user;
    }

    public void setUser(ShoppingUser user) {
        this.user = user;
    }

    public ShoppingStoreWithBLOBs getStore() {
        return store;
    }

    public void setStore(ShoppingStoreWithBLOBs store) {
        this.store = store;
    }

    public List<ShoppingGoodscart> getGcs() {
        return gcs;
    }

    public void setGcs(List<ShoppingGoodscart> gcs) {
        this.gcs = gcs;
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

    public String getCartSessionId() {
        return cartSessionId;
    }

    public void setCartSessionId(String cartSessionId) {
        this.cartSessionId = cartSessionId == null ? null : cartSessionId.trim();
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Long getStoreId() {
        return storeId;
    }

    public void setStoreId(Long storeId) {
        this.storeId = storeId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Integer getScStatus() {
        return scStatus;
    }

    public void setScStatus(Integer scStatus) {
        this.scStatus = scStatus;
    }

    @Override
    public String toString() {
        return "ShoppingStorecart{" +
                "id=" + id +
                ", addtime=" + addtime +
                ", deletestatus=" + deletestatus +
                ", cartSessionId='" + cartSessionId + '\'' +
                ", totalPrice=" + totalPrice +
                ", storeId=" + storeId +
                ", userId=" + userId +
                ", scStatus=" + scStatus +
                ", gcs=" + gcs +
                ", store=" + store +
                ", user=" + user +
                '}';
    }
}
