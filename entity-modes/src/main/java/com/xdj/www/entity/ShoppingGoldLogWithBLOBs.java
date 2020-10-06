package com.xdj.www.entity;

public class ShoppingGoldLogWithBLOBs extends ShoppingGoldLog {
    private String glAdminContent;

    private String glContent;

    public String getGlAdminContent() {
        return glAdminContent;
    }

    public void setGlAdminContent(String glAdminContent) {
        this.glAdminContent = glAdminContent == null ? null : glAdminContent.trim();
    }

    public String getGlContent() {
        return glContent;
    }

    public void setGlContent(String glContent) {
        this.glContent = glContent == null ? null : glContent.trim();
    }
}