package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.pay.paypal.PaypalTools;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.www.core.domain.virtual.SysMap;
import com.xdj.www.core.tools.CommUtil;
import com.xdj.www.entity.*;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Component
public class PayViewTools {
    @Resource
    private IOrderFormService orderFormService;
    @Resource
    private IPredepositService  predepositService;
    @Resource
    private IGoldRecordService goldRecordService;
    @Resource
    private IIntegralGoodsOrderService integralGoodsOrderService;
    @Resource
    private IPaymentService paymentService;


    public String genericPaypal(String url, String payment_id, String type, String id, BigDecimal amount){
       // ShoppingOrderformWithBLOBs of = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;

        if (type.equals("cash")) {
            obj = this.predepositService.getObjById(CommUtil.null2Long(id));
        }
        if (type.equals("gold")) {
            gold = this.goldRecordService.getObjById(CommUtil.null2Long(id));
        }
        if (type.equals("integral")) {
            ig_order = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
        }
        ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(CommUtil.null2Long(payment_id));
        if (payment == null) {
            payment = new ShoppingPaymentWithBLOBs();
        }
        List sms = new ArrayList();
        String business = payment.getPaypalUserid();

        String return_url = url + "/paypal_return.htm";
        String notify_url = url + "/paypal_notify.htm";
        String item_name = "";
        if (type.equals("goods")) {
            item_name = id;
        }
        if (type.equals("cash")) {
            item_name = obj.getPdSn();
        }
        if (type.equals("gold")) {
            item_name = gold.getGoldSn();
        }
        if (type.equals("integral")) {
            item_name = ig_order.getIgoOrderSn();
        }

        String amounts = "";
        String item_number = "";
        if (type.equals("goods")) {
            amounts =amount.toString();
            item_number = id;
        }
        if (type.equals("cash")) {
            amounts =CommUtil.null2String(obj.getPdAmount());
            item_number = obj.getPdSn();
        }
        if (type.equals("gold")) {
            amounts = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
            item_number = gold.getGoldSn();
        }
        if (type.equals("integral")) {
            amounts =CommUtil.null2String(ig_order.getIgoTransFee());
            item_number = ig_order.getIgoOrderSn();
        }
        sms.add(new SysMap("business", business));
        sms.add(new SysMap("return", return_url));
        sms.add(new SysMap("item_name", item_name));
        sms.add(new SysMap("amount", amounts));
        sms.add(new SysMap("notify_url", notify_url));
        sms.add(new SysMap("cmd", "_xclick"));
        sms.add(new SysMap("currency_code", payment.getCurrencyCode()));
        sms.add(new SysMap("item_number", item_number));

        String custom = "";
        if (type.equals("goods")) {
            custom = id;
        }
        if (type.equals("cash")) {
            custom = obj.getId().toString();
        }
        if (type.equals("gold")) {
            custom = gold.getId().toString();
        }
        if (type.equals("integral")) {
            custom = ig_order.getId().toString();
        }
        custom = custom + "," + type;
        sms.add(new SysMap("custom", custom));
        String ret = PaypalTools.buildForm(sms);
        return ret;
    }
}
