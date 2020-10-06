package com.xdj.www.entity;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public class ShoppingGoodsFloorWithBLOBs extends ShoppingGoodsFloor {
    private String gfGcGoods;

    private String gfGcList;

    private String gfLeftAdv;

    private String gfListGoods;

    private String gfRightAdv;

    private String gfBrandList;

    private List<ShoppingGoodsFloorWithBLOBs> childs;

    private ShoppingAccessory  leftAdv;

    private ShoppingAccessory  rightAdv;

    private List<ShoppingGoodsclassWithBLOBs> gcs;

    private Map<String,Object> goodsMsg;

    private List<ShoppingGoodsWithBLOBs> gs ;

    private List<ShoppingGoodsbrand> brands;

    public List<ShoppingGoodsbrand> getBrands() {
        return brands;
    }

    public void setBrands(List<ShoppingGoodsbrand> brands) {
        this.brands = brands;
    }

    public List<ShoppingGoodsWithBLOBs> getGs() {
        return gs;
    }

    public void setGs(List<ShoppingGoodsWithBLOBs> gs) {
        this.gs = gs;
    }

    public Map<String, Object> getGoodsMsg() {
        return goodsMsg;
    }

    public void setGoodsMsg(Map<String, Object> goodsMsg) {
        this.goodsMsg = goodsMsg;
    }

    public List<ShoppingGoodsclassWithBLOBs> getGcs() {
        return gcs;
    }

    public void setGcs(List<ShoppingGoodsclassWithBLOBs> gcs) {
        this.gcs = gcs;
    }

    public ShoppingAccessory getLeftAdv() {
        return leftAdv;
    }

    public void setLeftAdv(ShoppingAccessory leftAdv) {
        this.leftAdv = leftAdv;
    }

    public ShoppingAccessory getRightAdv() {
        return rightAdv;
    }

    public void setRightAdv(ShoppingAccessory rightAdv) {
        this.rightAdv = rightAdv;
    }

    public List<ShoppingGoodsFloorWithBLOBs> getChilds() {
        return childs;
    }

    public void setChilds(List<ShoppingGoodsFloorWithBLOBs> childs) {
        this.childs = childs;
    }

    public String getGfGcGoods() {
        return gfGcGoods;
    }

    public void setGfGcGoods(String gfGcGoods) {
        this.gfGcGoods = gfGcGoods == null ? null : gfGcGoods.trim();
    }

    public String getGfGcList() {
        return gfGcList;
    }

    public void setGfGcList(String gfGcList) {
        this.gfGcList = gfGcList == null ? null : gfGcList.trim();
    }

    public String getGfLeftAdv() {
        return gfLeftAdv;
    }

    public void setGfLeftAdv(String gfLeftAdv) {
        this.gfLeftAdv = gfLeftAdv == null ? null : gfLeftAdv.trim();
    }

    public String getGfListGoods() {
        return gfListGoods;
    }

    public void setGfListGoods(String gfListGoods) {
        this.gfListGoods = gfListGoods == null ? null : gfListGoods.trim();
    }

    public String getGfRightAdv() {
        return gfRightAdv;
    }

    public void setGfRightAdv(String gfRightAdv) {
        this.gfRightAdv = gfRightAdv == null ? null : gfRightAdv.trim();
    }

    public String getGfBrandList() {
        return gfBrandList;
    }

    public void setGfBrandList(String gfBrandList) {
        this.gfBrandList = gfBrandList == null ? null : gfBrandList.trim();
    }
}
