package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.service.IPaymentService;
import com.xdj.www.entity.ShoppingOrderformWithBLOBs;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 *
 * @author Administrator
 */

@Component
public class PaymentViewTools {
    @Resource
    private IPaymentService paymentService;
    @Resource
    private GoodsCartTools goodsCartTools;


    public void addOrderPays(List<ShoppingOrderformWithBLOBs> pList,boolean flag) {
        if(pList != null){
            for(ShoppingOrderformWithBLOBs order: pList){
                addOrderPay(order);
                if(flag){
                    goodsCartTools.addOrderGcs(order);
                }
            }
        }
    }

    public void addOrderPay(ShoppingOrderformWithBLOBs order){
        if(order != null && order.getPaymentId() != null){
          order.setPayment(paymentService.getObjById(order.getPaymentId()));
        }
    }
    public void addOrderPays(List<ShoppingOrderformWithBLOBs> orders){
        if(orders != null ){
            for(ShoppingOrderformWithBLOBs o: orders){
                addOrderPay(o);
            }
        }
    }
}
