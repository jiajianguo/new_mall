package com.xdj.interfaces.mallinterface.controller.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.IOrderFormLogService;
import com.xdj.interfaces.mallinterface.service.IOrderFormService;
import com.xdj.interfaces.mallinterface.service.IStoreService;
import com.xdj.www.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class OrderViewTools {
    @Resource
    private IOrderFormService orderFormService;
    @Resource
    private IStoreService storeService;
    @Resource
    private IOrderFormLogService orderFormLogService;
    @Resource
    private UserViewTools userViewTools;
    @Resource
    private GoodsCartTools goodsCartTools;

    public int query_user_order(String order_status) {
        Map params = new HashMap();
        int status = -1;
        if (order_status.equals("order_submit")) {
            status = 10;
        }
        if (order_status.equals("order_pay")) {
            status = 20;
        }
        if (order_status.equals("order_shipping")) {
            status = 30;
        }
        if (order_status.equals("order_receive")) {
            status = 40;
        }
        if (order_status.equals("order_finish")) {
            status = 60;
        }
        if (order_status.equals("order_cancel")) {
            status = 0;
        }
        params.put("status", Integer.valueOf(status));
        params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
        List ofs = this.orderFormService .pageList(params);
                //.query("select obj from OrderForm obj where obj.order_status=:status and obj.user.id=:user_id",params, -1, -1);
        return ofs.size();
    }

    public int query_store_order(String order_status) {
        if (SecurityUserHolder.getCurrentUser().getStore() != null) {
            Map params = new HashMap();
            int status = -1;
            if (order_status.equals("order_submit")) {
                status = 10;
            }
            if (order_status.equals("order_pay")) {
                status = 20;
            }
            if (order_status.equals("order_shipping")) {
                status = 30;
            }
            if (order_status.equals("order_receive")) {
                status = 40;
            }
            if (order_status.equals("order_finish")) {
                status = 60;
            }
            if (order_status.equals("order_cancel")) {
                status = 0;
            }
            params.put("status", Integer.valueOf(status));
            params.put("store_id", SecurityUserHolder.getCurrentUser().getStore().getId());
            List<ShoppingOrderformWithBLOBs> ofs = this.orderFormService.pageList(params);
                    //query("select obj from OrderForm obj where obj.order_status=:status and obj.store.id=:store_id", params, -1, -1);
            return ofs.size();
        }
        return 0;
    }

    public void addOf(ShoppingComplaintWithBLOBs obj) {
        if(obj!=null){
            ShoppingOrderformWithBLOBs orderform = orderFormService.getObjById(obj.getOfId());
            if(orderform.getStoreId()!=null){
                orderform.setStore(storeService.getObjById(orderform.getStoreId()));
            }
            obj.setOf(orderform);
        }
    }

    public void addOrderLogs(ShoppingOrderformWithBLOBs order, boolean isUser) {
        if(order != null){
            Map<String,Object> params = new HashMap<>();
            params.put("of_id",order.getId());
            List<ShoppingOrderLog> logs = orderFormLogService.queryByCondition(params);
            if(isUser && logs != null){
                for(ShoppingOrderLog log: logs){
                    userViewTools.addOrderLogUser(log);
                }
            }
            order.setOfls(logs);
        }
    }


    public final  void addOfs(List<ShoppingGoodscart> pList, boolean isUser) {
        if(pList != null){
            for(ShoppingGoodscart s: pList){
                addOrderMsg(s,isUser);
            }
        }
    }

    public final void addOrderMsg(ShoppingGoodscart s,boolean isUser){
        if(s != null){
            ShoppingOrderformWithBLOBs of = orderFormService.getObjById(s.getOfId());
            if(of != null && isUser){
               userViewTools.addOrderUser(of);
            }
            s.setOf(of);
        }
    }

    public void addEvaOfs(List<ShoppingEvaluateWithBLOBs> evas) {
        if(evas.size()>0){
            for (ShoppingEvaluateWithBLOBs eva : evas) {
                addEvaOf(eva);
            }
        }
    }

    private void addEvaOf(ShoppingEvaluateWithBLOBs eva) {
        if(eva!=null&&eva.getOfId()!=null){
            eva.setOf(orderFormService.getObjById(eva.getOfId()));
        }
    }

    public void addGCs(ShoppingOrderformWithBLOBs obj) {
        if(obj != null){
            goodsCartTools.addOrderGcs(obj);
        }
    }

}





