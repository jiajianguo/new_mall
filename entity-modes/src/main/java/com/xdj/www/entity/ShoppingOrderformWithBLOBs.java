package com.xdj.www.entity;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */

public class ShoppingOrderformWithBLOBs extends ShoppingOrderform {
    private String msg;

    private String payMsg;

    private String orderSellerIntro;

    private String returnContent;

    private ShoppingCouponInfo ci;

    private ShoppingPaymentWithBLOBs payment;

    private ShoppingStoreWithBLOBs store;

    private ShoppingExpressCompany ec;

    private ShoppingAddress addr;

    private ShoppingShipping ship;

    private List<ShoppingOrderLog> ofls = new ArrayList<ShoppingOrderLog>();

    private List<ShoppingGoodsReturnlog> grls = new ArrayList<ShoppingGoodsReturnlog>();

    private List<ShoppingRefundLog> rls = new ArrayList<>();

    public List<ShoppingGoodsReturnlog> getGrls() {
        return grls;
    }

    public void setGrls(List<ShoppingGoodsReturnlog> grls) {
        this.grls = grls;
    }

    public List<ShoppingRefundLog> getRls() {
        return rls;
    }

    public void setRls(List<ShoppingRefundLog> rls) {
        this.rls = rls;
    }

    public List<ShoppingOrderLog> getOfls() {
        return ofls;
    }

    public void setOfls(List<ShoppingOrderLog> ofls) {
        this.ofls = ofls;
    }

    public ShoppingShipping getShip() {
        return ship;
    }

    public void setShip(ShoppingShipping ship) {
        this.ship = ship;
    }

    public ShoppingAddress getAddr() {
        return addr;
    }

    public void setAddr(ShoppingAddress addr) {
        this.addr = addr;
    }

    public ShoppingExpressCompany getEc() {
        return ec;
    }

    public void setEc(ShoppingExpressCompany ec) {
        this.ec = ec;
    }

    public ShoppingStoreWithBLOBs getStore() {
        return store;
    }

    public void setStore(ShoppingStoreWithBLOBs store) {
        this.store = store;
    }

    public ShoppingPaymentWithBLOBs getPayment() {
        return payment;
    }

    public void setPayment(ShoppingPaymentWithBLOBs payment) {
        this.payment = payment;
    }

    public ShoppingCouponInfo getCi() {
        return ci;
    }

    public void setCi(ShoppingCouponInfo ci) {
        this.ci = ci;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public String getPayMsg() {
        return payMsg;
    }

    public void setPayMsg(String payMsg) {
        this.payMsg = payMsg == null ? null : payMsg.trim();
    }

    public String getOrderSellerIntro() {
        return orderSellerIntro;
    }

    public void setOrderSellerIntro(String orderSellerIntro) {
        this.orderSellerIntro = orderSellerIntro == null ? null : orderSellerIntro.trim();
    }

    public String getReturnContent() {
        return returnContent;
    }

    public void setReturnContent(String returnContent) {
        this.returnContent = returnContent == null ? null : returnContent.trim();
    }
}
