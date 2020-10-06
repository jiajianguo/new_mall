package com.xdj.www.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingIntegralGoodsorderWithBLOBs extends ShoppingIntegralGoodsorder {
    private String igoMsg;

    private String igoPayMsg;

    private String igoShipContent;

    private  ShoppingAddress   igo_addr;

    private ShoppingUser igo_user;


    @Override
    public ShoppingUser getIgo_user() {
        return igo_user;
    }

    @Override
    public void setIgo_user(ShoppingUser igo_user) {
        this.igo_user = igo_user;
    }

    @Override
    public ShoppingAddress getIgo_addr() {
        return igo_addr;
    }

    @Override
    public void setIgo_addr(ShoppingAddress igo_addr) {
        this.igo_addr = igo_addr;
    }

    @Override
    public List<ShoppingIntegralGoodscart> getIgo_gcs() {
        return igo_gcs;
    }

    @Override
    public void setIgo_gcs(List<ShoppingIntegralGoodscart> igo_gcs) {
        this.igo_gcs = igo_gcs;
    }

    private List<ShoppingIntegralGoodscart> igo_gcs = new ArrayList();

    public String getIgoMsg() {
        return igoMsg;
    }

    public void setIgoMsg(String igoMsg) {
        this.igoMsg = igoMsg == null ? null : igoMsg.trim();
    }

    public String getIgoPayMsg() {
        return igoPayMsg;
    }

    public void setIgoPayMsg(String igoPayMsg) {
        this.igoPayMsg = igoPayMsg == null ? null : igoPayMsg.trim();
    }

    public String getIgoShipContent() {
        return igoShipContent;
    }

    public void setIgoShipContent(String igoShipContent) {
        this.igoShipContent = igoShipContent == null ? null : igoShipContent.trim();
    }
}
