package com.xdj.www.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
/**
 * @author Administrator
 */
@JsonIgnoreProperties(value = {"accountNonExpired","credentialsNonExpired","accountNonLocked","handler"})
public class ShoppingFavorite extends BaseEntity{
    private Long id;

    private Date addtime;

    private Boolean deletestatus;

    private Integer type;

    private Long goodsId;

    private Long storeId;

    private Long userId;

    private ShoppingGoodsWithBLOBs goods;

    //店铺
    private ShoppingStoreWithBLOBs store;

    //用户
    private ShoppingUser user;

    public ShoppingStoreWithBLOBs getStore() {
        return store;
    }

    public void setStore(ShoppingStoreWithBLOBs store) {
        this.store = store;
    }

    public ShoppingUser getUser() {
        return user;
    }

    public void setUser(ShoppingUser user) {
        this.user = user;
    }

    public ShoppingGoodsWithBLOBs getGoods() {
        return goods;
    }

    public void setGoods(ShoppingGoodsWithBLOBs goods) {
        this.goods = goods;
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

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
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
}
