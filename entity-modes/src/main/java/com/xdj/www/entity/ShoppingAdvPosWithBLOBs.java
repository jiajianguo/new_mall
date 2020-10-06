package com.xdj.www.entity;

import java.util.List;

/**
 * @author Administrator
 */
public class ShoppingAdvPosWithBLOBs extends ShoppingAdvPos {
    private String apCode;

    private String apContent;

    private List<ShoppingAdvert> advs ;

    @Override
    public List<ShoppingAdvert> getAdvs() {
        return advs;
    }

    @Override
    public void setAdvs(List<ShoppingAdvert> advs) {
        this.advs = advs;
    }

    public String getApCode() {
        return apCode;
    }

    public void setApCode(String apCode) {
        this.apCode = apCode == null ? null : apCode.trim();
    }

    public String getApContent() {
        return apContent;
    }

    public void setApContent(String apContent) {
        this.apContent = apContent == null ? null : apContent.trim();
    }
}
