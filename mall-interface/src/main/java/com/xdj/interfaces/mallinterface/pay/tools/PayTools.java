 package com.xdj.interfaces.mallinterface.pay.tools;

 import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

 import com.xdj.interfaces.mallinterface.pay.alipay.config.AlipayConfig;
 import com.xdj.interfaces.mallinterface.pay.alipay.services.AlipayService;
 import com.xdj.interfaces.mallinterface.pay.alipay.util.AlipaySubmit;
 import com.xdj.interfaces.mallinterface.pay.alipay.util.UtilDate;
 import com.xdj.interfaces.mallinterface.pay.bill.config.BillConfig;
 import com.xdj.interfaces.mallinterface.pay.bill.services.BillService;
 import com.xdj.interfaces.mallinterface.pay.bill.util.BillCore;
 import com.xdj.interfaces.mallinterface.pay.bill.util.MD5Util;
 import com.xdj.interfaces.mallinterface.pay.paypal.PaypalTools;
 import com.xdj.interfaces.mallinterface.pay.util.ChinaBankSubmit;
 import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
 import com.xdj.interfaces.mallinterface.service.*;
 import com.xdj.interfaces.mallinterface.util.CommUtil;
 import com.xdj.www.core.domain.virtual.SysMap;
 import com.xdj.www.core.tools.Md5Encrypt;
 import com.xdj.www.entity.*;
 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


 @Component
 public class PayTools{
   @Autowired
   private IPaymentService paymentService;
   @Autowired
   private IOrderFormService orderFormService;
   @Autowired
   private IPredepositService predepositService;
   @Autowired
   private IGoldRecordService goldRecordService;
   @Autowired
   private IIntegralGoodsOrderService integralGoodsOrderService;
   @Autowired
   private ISysConfigService configService;

   public String genericAlipay(String url, String payment_id, String type, String id){
     String result = "";
     ShoppingOrderformWithBLOBs of = null;
     ShoppingPredepositWithBLOBs obj = null;
     ShoppingGoldRecordWithBLOBs gold = null;
     ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
     if (type.equals("goods")) {
       of = this.orderFormService.getObjById(CommUtil.null2Long(id));
     }
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

     int interfaceType = payment.getInterfacetype();

     AlipayConfig config = new AlipayConfig();
     Map params = new HashMap();
     params.put("type", "admin");
     params.put("mark", "alipay");

     List payments = this.paymentService.queryByCondition(params);
             //.query("select obj from Payment obj where obj.type=:type and obj.mark=:mark", params, -1, -1);

     ShoppingPaymentWithBLOBs shop_payment = new ShoppingPaymentWithBLOBs();

     if (payments.size() > 0) {
       shop_payment = (ShoppingPaymentWithBLOBs)payments.get(0);
     }
     if ((!CommUtil.null2String(payment.getSafekey()).equals("")) &&
       (!CommUtil.null2String(payment.getPartner()).equals(""))) {
       config.setKey(payment.getSafekey());
       config.setPartner(payment.getPartner());
     } else {
       config.setKey(shop_payment.getSafekey());
       config.setPartner(shop_payment.getPartner());
     }
     config.setSeller_email(payment.getSellerEmail());
     config.setNotify_url(url + "/alipay_notify.htm");
     config.setReturn_url(url + "/aplipay_return.htm");

     ShoppingSysconfigWithBLOBs sys_config = this.configService.getSysConfig();
     if (sys_config.getAlipayFenrun() == 1) {
       interfaceType = 0;
     }
     if (interfaceType == 0) {
       if (sys_config.getAlipayFenrun() == 1) {
         config.setKey(shop_payment.getSafekey());
         config.setPartner(shop_payment.getPartner());
         config.setSeller_email(shop_payment.getSellerEmail());
       }
       String out_trade_no = "";
       if (type.equals("goods")) {
         out_trade_no = of.getId().toString();
       }
       if (type.equals("cash")) {
         out_trade_no = obj.getId().toString();
       }
       if (type.equals("gold")) {
         out_trade_no = gold.getId().toString();
       }
       if (type.equals("integral")) {
         out_trade_no = ig_order.getId().toString();
       }

       String subject = "";
       if (type.equals("goods")) {
         subject = of.getOrderId();
       }
       if (type.equals("cash")) {
         subject = obj.getPdSn();
       }
       if (type.equals("gold")) {
         subject = gold.getGoldSn();
       }
       if (type.equals("integral")) {
         subject = ig_order.getIgoOrderSn();
       }

       String body = type;

       String total_fee = "";
       if (type.equals("goods")) {
         total_fee = CommUtil.null2String(of.getTotalprice());
       }
       if (type.equals("cash")) {
         total_fee = CommUtil.null2String(obj.getPdAmount());
       }
       if (type.equals("gold")) {
         total_fee = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
       }
       if (type.equals("integral")) {
         total_fee = CommUtil.null2String(ig_order.getIgoTransFee());
       }

       String paymethod = "";

       String defaultbank = "";

       String anti_phishing_key = "";

       String exter_invoke_ip = "";

       String extra_common_param = type;

       String buyer_email = "";

       String show_url = "";

       String royalty_type = "10";

       String royalty_parameters = "";
       if ((type.equals("goods")) && (sys_config.getAlipayFenrun() == 1))
       {
         double fenrun_rate = CommUtil.null2Double(shop_payment.getAlipayDivideRate());
         double apliay_rate = CommUtil.null2Double(shop_payment.getAlipayRate()) / 100.0D;
         double shop_fee = CommUtil.null2Double(total_fee) * (1.0D - apliay_rate);
         shop_fee *= fenrun_rate;
         double seller_fee = CommUtil.null2Double(total_fee) * (1.0D - apliay_rate) - shop_fee;
         royalty_parameters = payment.getSellerEmail() + "^" + String.format("%.2f", new Object[] { Double.valueOf(seller_fee) }) + "^商家";
       }

       Map sParaTemp = new HashMap();
       sParaTemp.put("payment_type", "1");
       sParaTemp.put("out_trade_no", out_trade_no);
       sParaTemp.put("subject", subject);
       sParaTemp.put("body", body);
       sParaTemp.put("total_fee", total_fee);
       sParaTemp.put("show_url", show_url);
       sParaTemp.put("paymethod", paymethod);
       sParaTemp.put("defaultbank", defaultbank);
       sParaTemp.put("anti_phishing_key", anti_phishing_key);
       sParaTemp.put("exter_invoke_ip", exter_invoke_ip);
       sParaTemp.put("extra_common_param", extra_common_param);
       sParaTemp.put("buyer_email", buyer_email);
       if ((type.equals("goods")) && (sys_config.getAlipayFenrun() == 1)) {
         sParaTemp.put("royalty_type", royalty_type);
         sParaTemp.put("royalty_parameters", royalty_parameters);
       }

       result = AlipayService.create_direct_pay_by_user(config, sParaTemp);
     }
     if (interfaceType == 1)
     {
       String out_trade_no = "";
       if (type.equals("goods")) {
         out_trade_no = of.getId().toString();
       }
       if (type.equals("cash")) {
         out_trade_no = obj.getId().toString();
       }
       if (type.equals("gold")) {
         out_trade_no = gold.getId().toString();
       }
       if (type.equals("integral")) {
         out_trade_no = ig_order.getId().toString();
       }

       String subject = "";
       if (type.equals("goods")) {
         subject = of.getOrderId();
       }
       if (type.equals("cash")) {
         subject = obj.getPdSn();
       }
       if (type.equals("gold")) {
         subject = gold.getGoldSn();
       }
       if (type.equals("integral")) {
         subject = ig_order.getIgoOrderSn();
       }

       String body = type;

       String total_fee = "";
       if (type.equals("goods")) {
         total_fee = CommUtil.null2String(of.getTotalprice());
       }
       if (type.equals("cash")) {
         total_fee = CommUtil.null2String(obj.getPdAmount());
       }
       if (type.equals("gold")) {
         total_fee = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
       }
       if (type.equals("integral")) {
         total_fee = CommUtil.null2String(ig_order.getIgoTransFee());
       }

       String price = String.valueOf(total_fee);

       String logistics_fee = "0.00";

       String logistics_type = "EXPRESS";

       String logistics_payment = "SELLER_PAY";

       String quantity = "1";

       String extra_common_param = "";

       String receive_name = "";
       String receive_address = "";
       String receive_zip = "";
       String receive_phone = "";
       String receive_mobile = "";

       String show_url = "";

       Map sParaTemp = new HashMap();
       sParaTemp.put("payment_type", "1");
       sParaTemp.put("show_url", show_url);
       sParaTemp.put("out_trade_no", out_trade_no);
       sParaTemp.put("subject", subject);
       sParaTemp.put("body", body);
       sParaTemp.put("price", price);
       sParaTemp.put("logistics_fee", logistics_fee);
       sParaTemp.put("logistics_type", logistics_type);
       sParaTemp.put("logistics_payment", logistics_payment);
       sParaTemp.put("quantity", quantity);
       sParaTemp.put("extra_common_param", extra_common_param);
       sParaTemp.put("receive_name", receive_name);
       sParaTemp.put("receive_address", receive_address);
       sParaTemp.put("receive_zip", receive_zip);
       sParaTemp.put("receive_phone", receive_phone);
       sParaTemp.put("receive_mobile", receive_mobile);

       result = AlipayService.create_partner_trade_by_buyer(config,
         sParaTemp);
     }
     if (interfaceType == 2)
     {
       String out_trade_no = "";
       if (type.equals("goods")) {
         out_trade_no = of.getId().toString();
       }
       if (type.equals("cash")) {
         out_trade_no = obj.getId().toString();
       }
       if (type.equals("gold")) {
         out_trade_no = gold.getId().toString();
       }
       if (type.equals("integral")) {
         out_trade_no = ig_order.getId().toString();
       }

       String subject = "";
       if (type.equals("goods")) {
         subject = of.getOrderId();
       }
       if (type.equals("cash")) {
         subject = obj.getPdSn();
       }
       if (type.equals("gold")) {
         subject = gold.getGoldSn();
       }
       if (type.equals("integral")) {
         subject = ig_order.getIgoOrderSn();
       }

       String body = type;

       String total_fee = "";
       if (type.equals("goods")) {
         total_fee = CommUtil.null2String(of.getTotalprice());
       }
       if (type.equals("cash")) {
         total_fee = CommUtil.null2String(obj.getPdAmount());
       }
       if (type.equals("gold")) {
         total_fee = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
       }
       if (type.equals("integral")) {
         total_fee = CommUtil.null2String(ig_order.getIgoTransFee());
       }

       String price = String.valueOf(total_fee);

       String logistics_fee = "0.00";

       String logistics_type = "EXPRESS";

       String logistics_payment = "SELLER_PAY";

       String quantity = "1";

       String extra_common_param = "";

       String receive_name = "";
       String receive_address = "";
       String receive_zip = "";
       String receive_phone = "";
       String receive_mobile = "";

       String show_url = "";

       Map sParaTemp = new HashMap();
       sParaTemp.put("payment_type", "1");
       sParaTemp.put("show_url", show_url);
       sParaTemp.put("out_trade_no", out_trade_no);
       sParaTemp.put("subject", subject);
       sParaTemp.put("body", body);
       sParaTemp.put("price", price);
       sParaTemp.put("logistics_fee", logistics_fee);
       sParaTemp.put("logistics_type", logistics_type);
       sParaTemp.put("logistics_payment", logistics_payment);
       sParaTemp.put("quantity", quantity);
       sParaTemp.put("extra_common_param", extra_common_param);
       sParaTemp.put("receive_name", receive_name);
       sParaTemp.put("receive_address", receive_address);
       sParaTemp.put("receive_zip", receive_zip);
       sParaTemp.put("receive_phone", receive_phone);
       sParaTemp.put("receive_mobile", receive_mobile);

       result = AlipayService.trade_create_by_buyer(config, sParaTemp);
     }
     return result;
   }

   public String generic99Bill(String url, String payment_id, String type, String id)throws UnsupportedEncodingException {
     String result = "";
     ShoppingOrderformWithBLOBs of = null;
     ShoppingPredepositWithBLOBs obj = null;
     ShoppingGoldRecordWithBLOBs gold = null;
     ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
     if (type.equals("goods")) {
       of = this.orderFormService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("cash")) {
       obj = this.predepositService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("gold")) {
       gold = this.goldRecordService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("integral")) {
       ig_order = this.integralGoodsOrderService.getObjById(
         CommUtil.null2Long(id));
     }
     ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
       CommUtil.null2Long(payment_id));
     if (payment == null) {
       payment = new ShoppingPaymentWithBLOBs();
     }
     BillConfig config = new BillConfig(payment.getMerchantacctid(),
       payment.getRmbkey(), payment.getPid());

     String merchantAcctId = config.getMerchantAcctId();
     String key = config.getKey();
     String inputCharset = "1";
     String bgUrl = url + "/bill_return.htm";
     String version = "v2.0";
     String language = "1";
     String signType = "1";

     String payerName = SecurityUserHolder.getCurrentUser().getUsername();

     String payerContactType = "1";

     String payerContact = "";

     String orderId = "";
     if (type.equals("goods")) {
       orderId = of.getOrderId();
     }
     if (type.equals("cash")) {
       orderId = obj.getPdSn();
     }
     if (type.equals("gold")) {
       orderId = gold.getGoldSn();
     }
     if (type.equals("integral")) {
       orderId = ig_order.getIgoOrderSn();
     }

     String orderAmount = "";
     if (type.equals("goods")) {
       orderAmount = String.valueOf((int)Math.floor(
         CommUtil.null2Double(of.getTotalprice()) * 100.0D));
     }
     if (type.equals("cash")) {
       orderAmount = String.valueOf((int)Math.floor(
         CommUtil.null2Double(obj.getPdAmount()) * 100.0D));
     }
     if (type.equals("gold")) {
       orderAmount = String.valueOf((int)Math.floor(
         CommUtil.null2Double(Integer.valueOf(gold.getGoldMoney())) * 100.0D));
     }
     if (type.equals("integral")) {
       orderAmount = String.valueOf((int)Math.floor(
         CommUtil.null2Double(ig_order.getIgoTransFee()) * 100.0D));
     }

     String orderTime = new SimpleDateFormat("yyyyMMddHHmmss")
       .format(new Date());

     String productName = "";
     if (type.equals("goods")) {
       productName = of.getOrderId();
     }
     if (type.equals("cash")) {
       productName = obj.getPdSn();
     }
     if (type.equals("gold")) {
       productName = gold.getGoldSn();
     }
     if (type.equals("integral")) {
       productName = ig_order.getIgoOrderSn();
     }

     String productNum = "1";

     String productId = "";

     String productDesc = "";

     String ext1 = "";
     if (type.equals("goods")) {
       ext1 = of.getId().toString();
     }
     if (type.equals("cash")) {
       ext1 = obj.getId().toString();
     }
     if (type.equals("gold")) {
       ext1 = gold.getId().toString();
     }
     if (type.equals("integral")) {
       ext1 = ig_order.getId().toString();
     }

     String ext2 = type;

     String payType = "00";

     String redoFlag = "0";

     String pid = "";
     if (config.getPid() != null) {
       pid = config.getPid();
     }

     String signMsgVal = "";
     signMsgVal = BillCore.appendParam(signMsgVal, "inputCharset",
       inputCharset);
     signMsgVal = BillCore.appendParam(signMsgVal, "bgUrl", bgUrl);
     signMsgVal = BillCore.appendParam(signMsgVal, "version", version);
     signMsgVal = BillCore.appendParam(signMsgVal, "language", language);
     signMsgVal = BillCore.appendParam(signMsgVal, "signType", signType);
     signMsgVal = BillCore.appendParam(signMsgVal, "merchantAcctId", merchantAcctId);
     signMsgVal = BillCore.appendParam(signMsgVal, "payerName", payerName);
     signMsgVal = BillCore.appendParam(signMsgVal, "payerContactType",
       payerContactType);
     signMsgVal = BillCore.appendParam(signMsgVal, "payerContact",
       payerContact);
     signMsgVal = BillCore.appendParam(signMsgVal, "orderId", orderId);
     signMsgVal = BillCore.appendParam(signMsgVal, "orderAmount",
       orderAmount);
     signMsgVal = BillCore.appendParam(signMsgVal, "orderTime", orderTime);
     signMsgVal = BillCore.appendParam(signMsgVal, "productName",
       productName);
     signMsgVal = BillCore.appendParam(signMsgVal, "productNum", productNum);
     signMsgVal = BillCore.appendParam(signMsgVal, "productId", productId);
     signMsgVal = BillCore.appendParam(signMsgVal, "productDesc",
       productDesc);
     signMsgVal = BillCore.appendParam(signMsgVal, "ext1", ext1);
     signMsgVal = BillCore.appendParam(signMsgVal, "ext2", ext2);
     signMsgVal = BillCore.appendParam(signMsgVal, "payType", payType);
     signMsgVal = BillCore.appendParam(signMsgVal, "redoFlag", redoFlag);
     signMsgVal = BillCore.appendParam(signMsgVal, "pid", pid);
     signMsgVal = BillCore.appendParam(signMsgVal, "key", key);

     String signMsg = MD5Util.md5Hex(signMsgVal.getBytes("UTF-8"))
       .toUpperCase();

     Map sParaTemp = new HashMap();
     sParaTemp.put("inputCharset", inputCharset);
     sParaTemp.put("bgUrl", bgUrl);
     sParaTemp.put("version", version);
     sParaTemp.put("language", language);
     sParaTemp.put("signType", signType);
     sParaTemp.put("signMsg", signMsg);
     sParaTemp.put("merchantAcctId", merchantAcctId);
     sParaTemp.put("payerName", payerName);
     sParaTemp.put("payerContactType", payerContactType);
     sParaTemp.put("payerContact", payerContact);
     sParaTemp.put("orderId", orderId);
     sParaTemp.put("orderAmount", orderAmount);
     sParaTemp.put("orderTime", orderTime);
     sParaTemp.put("productName", productName);
     sParaTemp.put("productNum", productNum);
     sParaTemp.put("productId", productId);
     sParaTemp.put("productDesc", productDesc);
     sParaTemp.put("ext1", ext1);
     sParaTemp.put("ext2", ext2);
     sParaTemp.put("payType", payType);
     sParaTemp.put("redoFlag", redoFlag);
     sParaTemp.put("pid", pid);
     result = BillService.buildForm(config, sParaTemp, "post", "确定");
     return result;
   }

   public String genericChinaBank(String url, String payment_id, String type, String id){
     ShoppingOrderformWithBLOBs of = null;
     ShoppingPredepositWithBLOBs obj = null;
     ShoppingGoldRecordWithBLOBs gold = null;
     ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
     if (type.equals("goods")) {
       of = this.orderFormService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("cash")) {
       obj = this.predepositService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("gold")) {
       gold = this.goldRecordService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("integral")) {
       ig_order = this.integralGoodsOrderService.getObjById(
         CommUtil.null2Long(id));
     }
     ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
       CommUtil.null2Long(payment_id));
     if (payment == null) {
       payment = new ShoppingPaymentWithBLOBs();
     }
     List list = new ArrayList();
     String v_mid = payment.getChinabankAccount();
     list.add(new SysMap("v_mid", v_mid));
     String key = payment.getChinabankKey();
     list.add(new SysMap("key", key));
     String v_url = url + "/chinabank_return.htm";
     list.add(new SysMap("v_url", v_url));
     String v_oid = "";
     if (type.equals("goods")) {
       v_oid = of.getOrderId();
     }
     if (type.equals("cash")) {
       v_oid = obj.getPdSn();
     }
     if (type.equals("gold")) {
       v_oid = gold.getGoldSn();
     }
     if (type.equals("integral")) {
       v_oid = ig_order.getIgoOrderSn();
     }
     list.add(new SysMap("v_oid", v_oid));
     String v_amount = "";
     if (type.equals("goods")) {
       v_amount = CommUtil.null2String(of.getTotalprice());
     }
     if (type.equals("cash")) {
       v_amount = CommUtil.null2String(obj.getPdAmount());
     }
     if (type.equals("gold")) {
       v_amount = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
     }
     if (type.equals("integral")) {
       v_amount = CommUtil.null2String(ig_order.getIgoTransFee());
     }
     list.add(new SysMap("v_amount", v_amount));
     String v_moneytype = "CNY";
     list.add(new SysMap("v_moneytype", v_moneytype));
     String temp = v_amount + v_moneytype + v_oid + v_mid + v_url + key;
     String v_md5info = Md5Encrypt.md5(temp).toUpperCase();
     list.add(new SysMap("v_md5info", v_md5info));

     String v_rcvname = "";
     String v_rcvaddr = "";
     String v_rcvtel = "";
     String v_rcvpost = "";
     String v_rcvemail = "";
     String v_rcvmobile = "";
     String remark1 = "";
     if (type.equals("goods")) {
       remark1 = of.getId().toString();
     }
     if (type.equals("cash")) {
       remark1 = obj.getId().toString();
     }
     if (type.equals("gold")) {
       remark1 = gold.getId().toString();
     }
     if (type.equals("integral")) {
       remark1 = ig_order.getId().toString();
     }
     list.add(new SysMap("remark1", remark1));
     String remark2 = type;
     list.add(new SysMap("remark2", remark2));
     String ret = ChinaBankSubmit.buildForm(list);
     return ret;
   }

   public String genericPaypal(String url, String payment_id, String type, String id){
     ShoppingOrderformWithBLOBs of = null;
     ShoppingPredepositWithBLOBs obj = null;
     ShoppingGoldRecordWithBLOBs gold = null;
     ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
     if (type.equals("goods")) {
       of = this.orderFormService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("cash")) {
       obj = this.predepositService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("gold")) {
       gold = this.goldRecordService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("integral")) {
       ig_order = this.integralGoodsOrderService.getObjById(
         CommUtil.null2Long(id));
     }
     ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
       CommUtil.null2Long(payment_id));
     if (payment == null) {
       payment = new ShoppingPaymentWithBLOBs();
     }
     List sms = new ArrayList();
     String business = payment.getPaypalUserid();
     sms.add(new SysMap("business", business));
     String return_url = url + "/paypal_return.htm";
     String notify_url = url + "/paypal_return.htm";
     sms.add(new SysMap("return", return_url));
     String item_name = "";
     if (type.equals("goods")) {
       item_name = of.getOrderId();
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
     sms.add(new SysMap("item_name", item_name));
     String amount = "";
     String item_number = "";
     if (type.equals("goods")) {
       amount = CommUtil.null2String(of.getTotalprice());
       item_number = of.getOrderId();
     }
     if (type.equals("cash")) {
       amount = CommUtil.null2String(obj.getPdAmount());
       item_number = obj.getPdSn();
     }
     if (type.equals("gold")) {
       amount = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
       item_number = gold.getGoldSn();
     }
     if (type.equals("integral")) {
       amount = CommUtil.null2String(ig_order.getIgoTransFee());
       item_number = ig_order.getIgoOrderSn();
     }
     sms.add(new SysMap("amount", amount));
     sms.add(new SysMap("notify_url", notify_url));
     sms.add(new SysMap("cmd", "_xclick"));
     sms.add(new SysMap("currency_code", payment.getCurrencyCode()));
     sms.add(new SysMap("item_number", item_number));

     String custom = "";
     if (type.equals("goods")) {
       custom = of.getId().toString();
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

   public String genericAlipayWap(String url, String payment_id, String type, String id)throws Exception{
     String result = "";
     ShoppingOrderformWithBLOBs of = null;
     ShoppingPredepositWithBLOBs obj = null;
     ShoppingGoldRecordWithBLOBs gold = null;
     ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
     if (type.equals("goods")) {
       of = this.orderFormService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("cash")) {
       obj = this.predepositService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("gold")) {
       gold = this.goldRecordService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("integral")) {
       ig_order = this.integralGoodsOrderService.getObjById(
         CommUtil.null2Long(id));
     }
     ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
       CommUtil.null2Long(payment_id));
     if (payment == null) {
       payment = new ShoppingPaymentWithBLOBs();
     }
     int interfaceType = payment.getInterfacetype();
     AlipayConfig config = new AlipayConfig();
     Map params = new HashMap();
     params.put("type", "admin");
     params.put("mark", "alipay_wap");
     List payments = this.paymentService.queryByCondition(params);
       //.query("select obj from Payment obj where obj.type=:type and obj.mark=:mark",params, -1, -1);
     ShoppingPaymentWithBLOBs shop_payment = new ShoppingPaymentWithBLOBs();
     if (payments.size() > 0) {
       shop_payment = (ShoppingPaymentWithBLOBs) payments.get(0);
     }
     if ((!CommUtil.null2String(payment.getSafekey()).equals("")) &&
       (!CommUtil.null2String(payment.getPartner()).equals(""))) {
       config.setKey(payment.getSafekey());
       config.setPartner(payment.getPartner());
     } else {
       config.setKey(shop_payment.getSafekey());
       config.setPartner(shop_payment.getPartner());
     }
     config.setSeller_email(payment.getSellerEmail());

     String format = "xml";

     String v = "2.0";

     String req_id = UtilDate.getOrderNum();

     String notify_url = url + "/weixin/alipay_notify.htm";

     String call_back_url = url + "/weixin/alipay_return.htm";

     String merchant_url = url + "/weixin/index.htm";

     String seller_email = payment.getSellerEmail();

     String out_trade_no = "";

     if (type.equals("goods")) {
       out_trade_no = of.getId().toString();
     }
     if (type.equals("cash")) {
       out_trade_no = obj.getId().toString();
     }
     if (type.equals("gold")) {
       out_trade_no = gold.getId().toString();
     }
     if (type.equals("integral")) {
       out_trade_no = ig_order.getId().toString();
     }

     String subject = "goods";
     if (type.equals("goods")) {
       subject = of.getOrderId();
     }
     if (type.equals("cash")) {
       subject = obj.getPdSn();
     }
     if (type.equals("gold")) {
       subject = gold.getGoldSn();
     }
     if (type.equals("integral")) {
       subject = ig_order.getIgoOrderSn();
     }

     String total_fee = "";
     if (type.equals("goods")) {
       total_fee = CommUtil.null2String(of.getTotalprice());
     }
     if (type.equals("cash")) {
       total_fee = CommUtil.null2String(obj.getPdAmount());
     }
     if (type.equals("gold")) {
       total_fee = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
     }
     if (type.equals("integral")) {
       total_fee = CommUtil.null2String(ig_order.getIgoTransFee());
     }

     String req_dataToken = "<direct_trade_create_req><notify_url>" +
       notify_url + "</notify_url><call_back_url>" + call_back_url +
       "</call_back_url><seller_account_name>" + seller_email +
       "</seller_account_name><out_trade_no>" + out_trade_no +
       "</out_trade_no><subject>" + subject +
       "</subject><total_fee>" + total_fee +
       "</total_fee><merchant_url>" + merchant_url +
       "</merchant_url><pay_body>" + type +
       "</pay_body></direct_trade_create_req>";

     Map sParaTempToken = new HashMap();
     sParaTempToken.put("service", "alipay.wap.trade.create.direct");
     sParaTempToken.put("partner", config.getPartner());
     sParaTempToken.put("_input_charset", config.getInput_charset());
     sParaTempToken.put("sec_id", config.getSign_type());
     sParaTempToken.put("format", format);
     sParaTempToken.put("v", v);
     sParaTempToken.put("req_id", req_id);
     sParaTempToken.put("req_data", req_dataToken);

     String sHtmlTextToken = AlipaySubmit.buildRequest(config, "wap", sParaTempToken, "", "");

     sHtmlTextToken = URLDecoder.decode(sHtmlTextToken, config.getInput_charset());

     String request_token = AlipaySubmit.getRequestToken(config, sHtmlTextToken);

     String req_data = "<auth_and_execute_req><request_token>" +
       request_token + "</request_token></auth_and_execute_req>";

     Map sParaTemp = new HashMap();
     sParaTemp.put("service", "alipay.wap.auth.authAndExecute");
     sParaTemp.put("partner", config.getPartner());
     sParaTemp.put("_input_charset", config.getInput_charset());
     sParaTemp.put("sec_id", config.getSign_type());
     sParaTemp.put("format", format);
     sParaTemp.put("v", v);
     sParaTemp.put("req_data", req_data);

     String WAP_ALIPAY_GATEWAY_NEW = "http://wappaygw.alipay.com/service/rest.htm?";
     result = AlipaySubmit.buildForm(config, sParaTemp, WAP_ALIPAY_GATEWAY_NEW, "get", "确认");

     return result;
   }

   public String generic99BillWap(String url, String payment_id, String type, String id)throws UnsupportedEncodingException{
     String result = "";
     ShoppingOrderformWithBLOBs of = null;
     ShoppingPredepositWithBLOBs obj = null;
     ShoppingGoldRecordWithBLOBs gold = null;
     ShoppingIntegralGoodsorderWithBLOBs ig_order = null;

     if (type.equals("goods")) {
       of = this.orderFormService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("cash")) {
       obj = this.predepositService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("gold")) {
       gold = this.goldRecordService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("integral")) {
       ig_order = this.integralGoodsOrderService.getObjById(
         CommUtil.null2Long(id));
     }
     ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
       CommUtil.null2Long(payment_id));
     if (payment == null) {
       payment = new ShoppingPaymentWithBLOBs();
     }
     BillConfig config = new BillConfig(payment.getMerchantacctid(),
       payment.getRmbkey(), payment.getPid());

     String merchantAcctId = config.getMerchantAcctId();
     String key = config.getKey();
     String inputCharset = "1";
     String bgUrl = url + "/weixin/bill_return.htm";
     String version = "v2.0";
     String language = "1";
     String signType = "1";

     String payerName = SecurityUserHolder.getCurrentUser().getUsername();

     String payerContactType = "1";

     String payerContact = "";

     String orderId = "";
     if (type.equals("goods")) {
       orderId = of.getOrderId();
     }
     if (type.equals("cash")) {
       orderId = obj.getPdSn();
     }
     if (type.equals("gold")) {
       orderId = gold.getGoldSn();
     }
     if (type.equals("integral")) {
       orderId = ig_order.getIgoOrderSn();
     }

     String orderAmount = "";
     if (type.equals("goods")) {
       orderAmount = String.valueOf((int)Math.floor(
         CommUtil.null2Double(of.getTotalprice()) * 100.0D));
     }
     if (type.equals("cash")) {
       orderAmount = String.valueOf((int)Math.floor(
         CommUtil.null2Double(obj.getPdAmount()) * 100.0D));
     }
     if (type.equals("gold")) {
       orderAmount = String.valueOf((int)Math.floor(
         CommUtil.null2Double(Integer.valueOf(gold.getGoldMoney())) * 100.0D));
     }
     if (type.equals("integral")) {
       orderAmount = String.valueOf((int)Math.floor(
         CommUtil.null2Double(ig_order.getIgoTransFee()) * 100.0D));
     }

     String orderTime = new SimpleDateFormat("yyyyMMddHHmmss")
       .format(new Date());

     String productName = "";
     if (type.equals("goods")) {
       productName = of.getOrderId();
     }
     if (type.equals("cash")) {
       productName = obj.getPdSn();
     }
     if (type.equals("gold")) {
       productName = gold.getGoldSn();
     }
     if (type.equals("integral")) {
       productName = ig_order.getIgoOrderSn();
     }

     String productNum = "1";

     String productId = "";

     String productDesc = "";

     String ext1 = "";
     if (type.equals("goods")) {
       ext1 = of.getId().toString();
     }
     if (type.equals("cash")) {
       ext1 = obj.getId().toString();
     }
     if (type.equals("gold")) {
       ext1 = gold.getId().toString();
     }
     if (type.equals("integral")) {
       ext1 = ig_order.getId().toString();
     }

     String ext2 = type;

     String payType = "00";

     String redoFlag = "0";

     String pid = "";
     if (config.getPid() != null) {
       pid = config.getPid();
     }

     String signMsgVal = "";
     signMsgVal = BillCore.appendParam(signMsgVal, "inputCharset",
       inputCharset);
     signMsgVal = BillCore.appendParam(signMsgVal, "bgUrl", bgUrl);
     signMsgVal = BillCore.appendParam(signMsgVal, "version", version);
     signMsgVal = BillCore.appendParam(signMsgVal, "language", language);
     signMsgVal = BillCore.appendParam(signMsgVal, "signType", signType);
     signMsgVal = BillCore.appendParam(signMsgVal, "merchantAcctId",
       merchantAcctId);
     signMsgVal = BillCore.appendParam(signMsgVal, "payerName", payerName);
     signMsgVal = BillCore.appendParam(signMsgVal, "payerContactType",
       payerContactType);
     signMsgVal = BillCore.appendParam(signMsgVal, "payerContact",
       payerContact);
     signMsgVal = BillCore.appendParam(signMsgVal, "orderId", orderId);
     signMsgVal = BillCore.appendParam(signMsgVal, "orderAmount",
       orderAmount);
     signMsgVal = BillCore.appendParam(signMsgVal, "orderTime", orderTime);
     signMsgVal = BillCore.appendParam(signMsgVal, "productName",
       productName);
     signMsgVal = BillCore.appendParam(signMsgVal, "productNum", productNum);
     signMsgVal = BillCore.appendParam(signMsgVal, "productId", productId);
     signMsgVal = BillCore.appendParam(signMsgVal, "productDesc",
       productDesc);
     signMsgVal = BillCore.appendParam(signMsgVal, "ext1", ext1);
     signMsgVal = BillCore.appendParam(signMsgVal, "ext2", ext2);
     signMsgVal = BillCore.appendParam(signMsgVal, "payType", payType);
     signMsgVal = BillCore.appendParam(signMsgVal, "redoFlag", redoFlag);
     signMsgVal = BillCore.appendParam(signMsgVal, "pid", pid);
     signMsgVal = BillCore.appendParam(signMsgVal, "key", key);

     String signMsg = MD5Util.md5Hex(signMsgVal.getBytes("UTF-8"))
       .toUpperCase();

     Map sParaTemp = new HashMap();
     sParaTemp.put("inputCharset", inputCharset);
     sParaTemp.put("bgUrl", bgUrl);
     sParaTemp.put("version", version);
     sParaTemp.put("language", language);
     sParaTemp.put("signType", signType);
     sParaTemp.put("signMsg", signMsg);
     sParaTemp.put("merchantAcctId", merchantAcctId);
     sParaTemp.put("payerName", payerName);
     sParaTemp.put("payerContactType", payerContactType);
     sParaTemp.put("payerContact", payerContact);
     sParaTemp.put("orderId", orderId);
     sParaTemp.put("orderAmount", orderAmount);
     sParaTemp.put("orderTime", orderTime);
     sParaTemp.put("productName", productName);
     sParaTemp.put("productNum", productNum);
     sParaTemp.put("productId", productId);
     sParaTemp.put("productDesc", productDesc);
     sParaTemp.put("ext1", ext1);
     sParaTemp.put("ext2", ext2);
     sParaTemp.put("payType", payType);
     sParaTemp.put("redoFlag", redoFlag);
     sParaTemp.put("pid", pid);
     result = BillService.buildForm(config, sParaTemp, "post", "确定");
     return result;
   }

   public String genericChinaBankWap(String url, String payment_id, String type, String id){
     ShoppingOrderformWithBLOBs of = null;
     ShoppingPredepositWithBLOBs obj = null;
     ShoppingGoldRecordWithBLOBs gold = null;
     ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
     if (type.equals("goods")) {
       of = this.orderFormService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("cash")) {
       obj = this.predepositService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("gold")) {
       gold = this.goldRecordService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("integral")) {
       ig_order = this.integralGoodsOrderService.getObjById(
         CommUtil.null2Long(id));
     }
     ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
       CommUtil.null2Long(payment_id));
     if (payment == null) {
       payment = new ShoppingPaymentWithBLOBs();
     }
     List list = new ArrayList();
     String v_mid = payment.getChinabankAccount();
     list.add(new SysMap("v_mid", v_mid));
     String key = payment.getChinabankKey();
     list.add(new SysMap("key", key));
     String v_url = url + "/weixin/chinabank_return.htm";
     list.add(new SysMap("v_url", v_url));
     String v_oid = "";
     if (type.equals("goods")) {
       v_oid = of.getOrderId();
     }
     if (type.equals("cash")) {
       v_oid = obj.getPdSn();
     }
     if (type.equals("gold")) {
       v_oid = gold.getGoldSn();
     }
     if (type.equals("integral")) {
       v_oid = ig_order.getIgoOrderSn();
     }
     list.add(new SysMap("v_oid", v_oid));
     String v_amount = "";
     if (type.equals("goods")) {
       v_amount = CommUtil.null2String(of.getTotalprice());
     }
     if (type.equals("cash")) {
       v_amount = CommUtil.null2String(obj.getPdAmount());
     }
     if (type.equals("gold")) {
       v_amount = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
     }
     if (type.equals("integral")) {
       v_amount = CommUtil.null2String(ig_order.getIgoTransFee());
     }
     list.add(new SysMap("v_amount", v_amount));
     String v_moneytype = "CNY";
     list.add(new SysMap("v_moneytype", v_moneytype));
     String temp = v_amount + v_moneytype + v_oid + v_mid + v_url + key;
     String v_md5info = Md5Encrypt.md5(temp).toUpperCase();
     list.add(new SysMap("v_md5info", v_md5info));

     String v_rcvname = "";
     String v_rcvaddr = "";
     String v_rcvtel = "";
     String v_rcvpost = "";
     String v_rcvemail = "";
     String v_rcvmobile = "";
     String remark1 = "";
     if (type.equals("goods")) {
       remark1 = of.getId().toString();
     }
     if (type.equals("cash")) {
       remark1 = obj.getId().toString();
     }
     if (type.equals("gold")) {
       remark1 = gold.getId().toString();
     }
     if (type.equals("integral")) {
       remark1 = ig_order.getId().toString();
     }
     list.add(new SysMap("remark1", remark1));
     String remark2 = type;
     list.add(new SysMap("remark2", remark2));
     String ret = ChinaBankSubmit.buildForm(list);
     return ret;
   }

   public String genericPaypalWap(String url, String payment_id, String type, String id){
     ShoppingOrderformWithBLOBs of = null;
     ShoppingPredepositWithBLOBs obj = null;
     ShoppingGoldRecordWithBLOBs gold = null;
     ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
     if (type.equals("goods")) {
       of = this.orderFormService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("cash")) {
       obj = this.predepositService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("gold")) {
       gold = this.goldRecordService.getObjById(CommUtil.null2Long(id));
     }
     if (type.equals("integral")) {
       ig_order = this.integralGoodsOrderService.getObjById(
         CommUtil.null2Long(id));
     }
     ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
       CommUtil.null2Long(payment_id));
     if (payment == null) {
       payment = new ShoppingPaymentWithBLOBs();
     }
     List sms = new ArrayList();
     String business = payment.getPaypalUserid();
     sms.add(new SysMap("business", business));
     String return_url = url + "/weixin/paypal_return.htm";
     String notify_url = url + "/weixin/paypal_return.htm";
     sms.add(new SysMap("return", return_url));
     String item_name = "";
     if (type.equals("goods")) {
       item_name = of.getOrderId();
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
     sms.add(new SysMap("item_name", item_name));
     String amount = "";
     String item_number = "";
     if (type.equals("goods")) {
       amount = CommUtil.null2String(of.getTotalprice());
       item_number = of.getOrderId();
     }
     if (type.equals("cash")) {
       amount = CommUtil.null2String(obj.getPdAmount());
       item_number = obj.getPdSn();
     }
     if (type.equals("gold")) {
       amount = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
       item_number = gold.getGoldSn();
     }
     if (type.equals("integral")) {
       amount = CommUtil.null2String(ig_order.getIgoTransFee());
       item_number = ig_order.getIgoOrderSn();
     }
     sms.add(new SysMap("amount", amount));
     sms.add(new SysMap("notify_url", notify_url));
     sms.add(new SysMap("cmd", "_xclick"));
     sms.add(new SysMap("currency_code", payment.getCurrencyCode()));
     sms.add(new SysMap("item_number", item_number));

     String custom = "";
     if (type.equals("goods")) {
       custom = of.getId().toString();
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




