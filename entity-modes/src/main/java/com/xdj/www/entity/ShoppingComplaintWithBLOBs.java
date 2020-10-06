package com.xdj.www.entity;

import java.util.ArrayList;
import java.util.List;

//投诉
public class ShoppingComplaintWithBLOBs extends ShoppingComplaint {
    private String fromUserContent;

    private String handleContent;

    private String talkContent;

    private String toUserContent;

    //举报人
    private ShoppingUser from_user;

    //被举报人
    private ShoppingUser to_user;

    //举报商品
    private List<ShoppingComplaintGoods> cgs = new ArrayList<ShoppingComplaintGoods>();

    //举报主题
    private ShoppingComplaintSubject cs;

    //证据1
    private ShoppingAccessory from_acc1;

    //证据2
    private ShoppingAccessory from_acc2;

    //证据3
    private ShoppingAccessory from_acc3;

    //举证1
    private ShoppingAccessory to_acc1;

    //举证2
    private ShoppingAccessory to_acc2;

    //举证3
    private ShoppingAccessory to_acc3;

    //被举报订单
    private ShoppingOrderform of;

    public ShoppingUser getFrom_user() {
        return from_user;
    }

    public void setFrom_user(ShoppingUser from_user) {
        this.from_user = from_user;
    }

    public ShoppingUser getTo_user() {
        return to_user;
    }

    public void setTo_user(ShoppingUser to_user) {
        this.to_user = to_user;
    }

    public List<ShoppingComplaintGoods> getCgs() {
        return cgs;
    }

    public void setCgs(List<ShoppingComplaintGoods> cgs) {
        this.cgs = cgs;
    }

    public ShoppingComplaintSubject getCs() {
        return cs;
    }

    public void setCs(ShoppingComplaintSubject cs) {
        this.cs = cs;
    }

    public ShoppingAccessory getFrom_acc1() {
        return from_acc1;
    }

    public void setFrom_acc1(ShoppingAccessory from_acc1) {
        this.from_acc1 = from_acc1;
    }

    public ShoppingAccessory getFrom_acc2() {
        return from_acc2;
    }

    public void setFrom_acc2(ShoppingAccessory from_acc2) {
        this.from_acc2 = from_acc2;
    }

    public ShoppingAccessory getFrom_acc3() {
        return from_acc3;
    }

    public void setFrom_acc3(ShoppingAccessory from_acc3) {
        this.from_acc3 = from_acc3;
    }

    public ShoppingAccessory getTo_acc1() {
        return to_acc1;
    }

    public void setTo_acc1(ShoppingAccessory to_acc1) {
        this.to_acc1 = to_acc1;
    }

    public ShoppingAccessory getTo_acc2() {
        return to_acc2;
    }

    public void setTo_acc2(ShoppingAccessory to_acc2) {
        this.to_acc2 = to_acc2;
    }

    public ShoppingAccessory getTo_acc3() {
        return to_acc3;
    }

    public void setTo_acc3(ShoppingAccessory to_acc3) {
        this.to_acc3 = to_acc3;
    }

    public ShoppingOrderform getOf() {
        return of;
    }

    public void setOf(ShoppingOrderform of) {
        this.of = of;
    }

    public String getFromUserContent() {
        return fromUserContent;
    }

    public void setFromUserContent(String fromUserContent) {
        this.fromUserContent = fromUserContent == null ? null : fromUserContent.trim();
    }

    public String getHandleContent() {
        return handleContent;
    }

    public void setHandleContent(String handleContent) {
        this.handleContent = handleContent == null ? null : handleContent.trim();
    }

    public String getTalkContent() {
        return talkContent;
    }

    public void setTalkContent(String talkContent) {
        this.talkContent = talkContent == null ? null : talkContent.trim();
    }

    public String getToUserContent() {
        return toUserContent;
    }

    public void setToUserContent(String toUserContent) {
        this.toUserContent = toUserContent == null ? null : toUserContent.trim();
    }
}