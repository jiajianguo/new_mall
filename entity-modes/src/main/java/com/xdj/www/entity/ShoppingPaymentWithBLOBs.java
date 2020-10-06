package com.xdj.www.entity;

public class ShoppingPaymentWithBLOBs extends ShoppingPayment {
    private String content;

    private String weixinAppid;

    private String weixinAppsecret;

    private String weixinPartnerid;

    private String weixinPartnerkey;

    private String weixinPaysignkey;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getWeixinAppid() {
        return weixinAppid;
    }

    public void setWeixinAppid(String weixinAppid) {
        this.weixinAppid = weixinAppid == null ? null : weixinAppid.trim();
    }

    public String getWeixinAppsecret() {
        return weixinAppsecret;
    }

    public void setWeixinAppsecret(String weixinAppsecret) {
        this.weixinAppsecret = weixinAppsecret == null ? null : weixinAppsecret.trim();
    }

    public String getWeixinPartnerid() {
        return weixinPartnerid;
    }

    public void setWeixinPartnerid(String weixinPartnerid) {
        this.weixinPartnerid = weixinPartnerid == null ? null : weixinPartnerid.trim();
    }

    public String getWeixinPartnerkey() {
        return weixinPartnerkey;
    }

    public void setWeixinPartnerkey(String weixinPartnerkey) {
        this.weixinPartnerkey = weixinPartnerkey == null ? null : weixinPartnerkey.trim();
    }

    public String getWeixinPaysignkey() {
        return weixinPaysignkey;
    }

    public void setWeixinPaysignkey(String weixinPaysignkey) {
        this.weixinPaysignkey = weixinPaysignkey == null ? null : weixinPaysignkey.trim();
    }
}