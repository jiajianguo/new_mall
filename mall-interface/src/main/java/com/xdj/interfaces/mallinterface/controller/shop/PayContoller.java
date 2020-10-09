package com.xdj.interfaces.mallinterface.controller.shop;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.google.gson.Gson;
import com.xdj.interfaces.mallinterface.controller.view.*;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.pay.alipay.config.AlipayConfig;
import com.xdj.interfaces.mallinterface.pay.alipay.services.AlipayService;
import com.xdj.interfaces.mallinterface.pay.alipay.util.AlipayNotify;
import com.xdj.interfaces.mallinterface.pay.alipay.util.AlipaySubmit;
import com.xdj.interfaces.mallinterface.pay.alipay.util.UtilDate;
import com.xdj.interfaces.mallinterface.pay.bill.config.BillConfig;
import com.xdj.interfaces.mallinterface.pay.bill.services.BillService;
import com.xdj.interfaces.mallinterface.pay.bill.util.BillCore;
import com.xdj.interfaces.mallinterface.pay.bill.util.MD5Util;
import com.xdj.interfaces.mallinterface.pay.paypal.PaypalTools;
import com.xdj.interfaces.mallinterface.pay.tenpay.RequestHandler;
import com.xdj.interfaces.mallinterface.pay.tenpay.util.TenpayUtil;
import com.xdj.interfaces.mallinterface.pay.util.ChinaBankSubmit;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.service.impl.TemplateServiceImpl;
import com.xdj.interfaces.mallinterface.util.QrCodeUtils;
import com.xdj.www.core.domain.virtual.SysMap;
import com.xdj.www.core.tools.CommUtil;
import com.xdj.www.core.tools.Md5Encrypt;
import com.xdj.www.core.tools.WxCommonUtil;
import com.xdj.www.entity.*;
import org.jdom2.JDOMException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.math.BigDecimal;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Administrator
 */

@RestController
public class PayContoller {
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
    @Resource
    private IOrderFormLogService orderFormLogService;
    @Resource
    private IUserService userService;
    @Resource
    private IPredepositLogService predepositLogService;
    @Resource
    private IGoldLogService goldLogService;
    @Resource
    private IGroupGoodsService groupGoodsService;
    @Resource
    private ISysConfigService configService;
    @Resource
    private IIntegralGoodsService integralGoodsService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private GoodsCartTools goodsCartTools;
    @Resource
    private PaymentViewTools paymentViewTools;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IIntegralGoodsCartService integralGoodsCartServiceService;
    @Resource
    private GoodsSpecPropertyTools goodsSpecPropertyTools;
    @Resource
    private ViewTools viewTools;
    @Resource
    private SendMessageService sendMessageService;
    @Resource
    private ITemplateService templateService;


    private Logger log = LoggerFactory.getLogger("paytools");


    /***
     * 付款成功回调处理，你必须要返回SUCCESS信息给微信服务器，告诉微信服务器我已经收到支付成功的后台通知了。
     * 不然的话，微信会一直调用该回调地址，当达到8次的时候还是没有收到SUCCESS的返回，微信服务器则认为此订单支付失败。
     *
     * 该回调地址是异步的。 这里可以处理数据库中的订单状态。
     *
     * 作者: YUKE 日期：2016年1月14日 上午9:25:29
     *
     * @param response
     * @throws IOException
     * @throws JDOMException
     */
    @RequestMapping({"/wechat/paynotify.htm"})
    public void notify_success(HttpServletRequest request, HttpServletResponse response) throws IOException, JDOMException {
        InputStream inStream = request.getInputStream();
        ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer)) != -1) {
            outSteam.write(buffer, 0, len);
        }
        log.info("~~~~~~~~~~~~~~~~付款成功，收到微信回调~~~~~~~~~");
        outSteam.close();
        inStream.close();

        /** 支付成功后，微信回调返回的信息 */
        String result = new String(outSteam.toByteArray(), "utf-8");
        Map<String, String> map = WxCommonUtil.doXMLParse(result);

        for (Object keyValue : map.keySet()) {
            /** 输出返回的订单支付信息 */
            log.info(keyValue + "=" + map.get(keyValue));
        }
        //支付签名验证
       /*if (verifyNotify(notifyMethod, request)) {

		}*/
        String order_no = map.get("out_trade_no");
        ShoppingOrderformWithBLOBs order = null;
        order = this.orderFormService.getObjById(CommUtil.null2Long(order_no));

        if (map.get("result_code").toString().equalsIgnoreCase("SUCCESS") && (order.getOrderStatus() < 20)) {
            order.setOrderStatus(20);
            order.setOutOrderId(map.get("transaction_id"));
            order.setPaytime(new Date());
            this.orderFormService.update(order);

            update_goods_inventory(order);
            ShoppingOrderLog ofl = new ShoppingOrderLog();
            ofl.setAddtime(new Date());
            ofl.setLogInfo("微信公众号在线支付");
            ofl.setLogUserId(order.getUserId());
            ofl.setOfId(order.getId());
            this.orderFormLogService.save(ofl);

            // 邮件和短信通知,根据情况使用
               /*if (this.configService.getSysConfig().isEmailEnable()) {
                 send_order_email(request, order, order.getUser().getEmail(),
                   "email_tobuyer_online_pay_ok_notify");
                 send_order_email(request, order, order
                   .getStore().getUser().getEmail(),
                   "email_toseller_online_pay_ok_notify");
               }
               if (this.configService.getSysConfig().isSmsEnbale()) {
                 send_order_sms(request, order, order.getUser().getMobile(),
                   "sms_tobuyer_online_pay_ok_notify");
                 send_order_sms(request, order, order
                   .getStore().getUser().getMobile(),
                   "sms_toseller_online_pay_ok_notify");
               }*/

            // 告诉微信服务器，我收到信息了，不要在调用回调方法(/pay)了
            log.info("-------------" + WxCommonUtil.setXML("SUCCESS", "OK"));
            response.getWriter().write(WxCommonUtil.setXML("SUCCESS", "OK"));
        } else {
            log.info("------微信异步回调失败-------");
        }
    }



    /**
     * 微信扫码支付
     * @param request
     * @param response
     * @param order_id
     * @return
     */
    @ResponseBody
    @RequestMapping({"/wechat/wxcodepay.htm"})
    public void wxcodepay(HttpServletRequest request, HttpServletResponse response, String order_id) throws Exception {
        JSONObject data = new JSONObject();
        data.put("code","400");
        String UNI_URL = "https://api.mch.weixin.qq.com/pay/unifiedorder";
        ShoppingOrderformWithBLOBs of = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
        String returnhtml = null;
        if (of.getOrderStatus() == 10) {
            List<ShoppingPaymentWithBLOBs> payments = new ArrayList();
            Map params = new HashMap();
            //判断是否平台支付
            if (this.configService.getSysConfig().getConfigPaymentType() == 1) {
                params.put("mark", "wxcodepay");
                params.put("type", "admin");
                payments = this.paymentService.queryByCondition(params);
            } else {
                params.put("mark", "wxcodepay");
                params.put("store_id", of.getStore().getId());
                payments = this.paymentService.queryByCondition(params);
            }
            ShoppingPaymentWithBLOBs payment =  payments.get(0);
            of.setPayment(payment);
            this.orderFormService.update(of);
            //微信返回的二维码地址信息
            SortedMap<Object, Object> parameters = new TreeMap<Object, Object>();
            // 公众账号id
            parameters.put("appid", payment.getWeixinAppid());
            // 商户号
            parameters.put("mch_id", payment.getWeixinPartnerid());
            // 随机字符串
            parameters.put("nonce_str", WxCommonUtil.createNoncestr());
            // 商品描述
            parameters.put("body", "在线购物");
            // 商户订单号
            parameters.put("out_trade_no", order_id);
            //// 总金额
            parameters.put("total_fee", new BigDecimal("0.01").multiply(new BigDecimal(100)).setScale(0).toString());
            // 终端IP.Native支付填调用微信支付API的机器IP。
            parameters.put("spbill_create_ip", WxCommonUtil.localIp());
            // 支付成功后回调的action，与JSAPI相同
            //parameters.put("notify_url", basePath + NOTIFY_URL);// 支付成功后回调的action
            //支付成功后回调的action，与JSAPI相同
            parameters.put("notify_url", CommUtil.getURL(request)+"/wechat/paynotify.htm");
            // 交易类型
            parameters.put("trade_type", "NATIVE");
            // 商品ID。商品号要唯一,trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义
            parameters.put("product_id", order_id);
            //String sign = WxPayUtil.createSign2("UTF-8", parameters, API_KEY);
            String sign = WxCommonUtil.createSignMD5("UTF-8", parameters, payment.getWeixinPaysignkey());
            parameters.put("sign", sign);// 签名
            String requestXML = WxCommonUtil.getRequestXml(parameters);
            //WxCommonUtil.httpsRequest(WxConstants.UNIFIED_ORDER_URL, "POST", requestXML);
            String result = WxCommonUtil.httpsRequestString(UNI_URL, "POST", requestXML);
            // System.out.println(" 微信支付二维码生成" + result);
            Map<String, String> map = new HashMap<String, String>();
            try {
                map = WxCommonUtil.doXMLParse(result);
            } catch (Exception e) {
               e.printStackTrace();
            }
            log.info("-----wxpay----{}",result);
            String returnCode = map.get("return_code");
            String resultCode = map.get("result_code");
            if (returnCode.equalsIgnoreCase("SUCCESS") && resultCode.equalsIgnoreCase("SUCCESS")) {
                data.put("code","200");
                data.put("data",map.get("code_url"));
            } else {
                data.put("msg","生成支付二维码失败");
            }
        }else{
            data.put("msg","订单不在未支付状态");
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(data);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //return returnhtml;
    }


     @RequestMapping({"/aplipay_return.htm"})
    public ModelAndView aplipay_return(HttpServletRequest request, HttpServletResponse response)throws Exception {
        ModelAndView mv = new JModelAndView("order_finish.html",this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
        String trade_no = request.getParameter("trade_no");
        String order_no = request.getParameter("out_trade_no");
        String total_fee = request.getParameter("price");
        String subject = request.getParameter("subject");
        String type = CommUtil.null2String(request.getParameter("body")).trim();
        String trade_status = request.getParameter("trade_status");
        List<ShoppingOrderformWithBLOBs> order = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
        if (type.equals("goods")) {
            order = this.orderFormService.selectByOrderNo(order_no);
            paymentViewTools.addOrderPays(order);
        }
        if (type.equals("cash")) {
            obj = this.predepositService.getObjById(CommUtil.null2Long(order_no));
        }
        if (type.equals("gold")) {
            gold = this.goldRecordService.getObjById(CommUtil.null2Long(order_no));
        }
        if (type.equals("integral")) {
            ig_order = this.integralGoodsOrderService.getObjById(
                    CommUtil.null2Long(order_no));
        }

        Map params = new HashMap();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String)iter.next();
            String[] values = (String[])requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                //valueStr = valueStr + values[i] + ",";
                valueStr = valueStr + values[i];
            }

            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        AlipayConfig config = new AlipayConfig();
        if (type.equals("goods")) {
            config.setKey(order.get(0).getPayment().getSafekey());
            config.setPartner(order.get(0).getPayment().getPartner());
            config.setSeller_email(order.get(0).getPayment().getSellerEmail());
        }
        if ((type.equals("cash")) || (type.equals("gold")) ||
                (type.equals("integral"))) {
            Map q_params = new HashMap();
            q_params.put("install", Boolean.valueOf(true));
            if (type.equals("cash")) {
                q_params.put("mark", obj.getPdPayment());
            }
            if (type.equals("gold")) {
                q_params.put("mark", gold.getGoldPayment());
            }
            if (type.equals("integral")) {
                q_params.put("mark", ig_order.getIgoPayment());
            }
            q_params.put("type", "admin");

            List<ShoppingPaymentWithBLOBs> payments = this.paymentService.queryByCondition(q_params);
            config.setKey(payments.get(0).getSafekey());
            config.setPartner(payments.get(0).getPartner());
            config.setSeller_email(payments.get(0).getSellerEmail());
        }
        config.setNotify_url(CommUtil.getURL(request) + "/alipay_notify.htm");
        config.setReturn_url(CommUtil.getURL(request) + "/aplipay_return.htm");
        boolean verify_result = AlipayNotify.verify(config, params);
        if (verify_result) {
            if ((type.equals("goods")) && ( (trade_status.equals("WAIT_SELLER_SEND_GOODS")) ||
                (trade_status.equals("TRADE_FINISHED")) || (trade_status.equals("TRADE_SUCCESS")))) {
                for(ShoppingOrderformWithBLOBs o: order){
                    if (o.getOrderStatus() != 20) {
                        o.setOrderStatus(20);
                        o.setOutOrderId(trade_no);
                        o.setPaytime(new Date());
                        this.orderFormService.update(o);
                        update_goods_inventory(o);
                        ShoppingOrderLog ofl = new ShoppingOrderLog();
                        ofl.setAddtime(new Date());
                        ofl.setLogInfo("支付宝在线支付");
                        ofl.setLogUserId(o.getUserId());
                        ofl.setOfId(o.getId());
                        ofl.setDeletestatus(false);
                        this.orderFormLogService.save(ofl);
                        if (this.configService.getSysConfig().getEmailenable()) {
                            //通过店铺id 获取店主手机或者email
                            ShoppingUser user= userService.queryOneByStoreId(o.getStoreId());
                            sendMessageService.sendEmail(user.getEmail(),"会员下单","尊敬的卖家用户，你的客户已下单支付成功，请尽快处理订单");
                        }

                        if (this.configService.getSysConfig().getSmsenbale()) {
                            ShoppingUser user= userService.queryOneByStoreId(o.getStoreId());
                            sendMessageService.sendSMS(user.getMobile(),"尊敬的卖家用户，你的客户已下单支付成功，请尽快处理订单");
                        }
                    }
                }
                mv.addObject("obj", order.get(0));
            }

            if ((type.equals("cash")) && (
                    (trade_status.equals("WAIT_SELLER_SEND_GOODS")) ||
                            (trade_status.equals("TRADE_FINISHED")) ||
                            (trade_status.equals("TRADE_SUCCESS")))) {
                if (obj.getPdPayStatus() != 2) {
                    obj.setPdStatus(1);
                    obj.setPdPayStatus(2);
                    this.predepositService.update(obj);
                    ShoppingUser user = this.userService.getObjById(obj.getPdUserId());
                    user.setAvailablebalance(BigDecimal.valueOf( CommUtil.add(user.getAvailablebalance(), obj.getPdAmount())));
                    this.userService.update(user);
                    ShoppingPredepositLog log = new ShoppingPredepositLog();
                    log.setAddtime(new Date());
                    log.setPdLogAmount(obj.getPdAmount());
                    log.setPdLogUserId(obj.getPdUserId());
                    log.setPdOpType("充值");
                    log.setPdType("可用预存款");
                    log.setPdLogInfo("支付宝在线支付");
                    this.predepositLogService.save(log);
                }
                mv = new JModelAndView("success.html",
                        this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request,
                        response);
                mv.addObject("op_title", "充值" + obj.getPdAmount() + "成功");
                mv.addObject("url", CommUtil.getURL(request) +
                        "/buyer/predeposit_list.htm");
            }
            ShoppingGoldLogWithBLOBs log;
            if ((type.equals("gold")) && (
                    (trade_status.equals("WAIT_SELLER_SEND_GOODS")) ||
                            (trade_status.equals("TRADE_FINISHED")) ||
                            (trade_status.equals("TRADE_SUCCESS")))) {
                if (gold.getGoldPayStatus() != 2) {
                    gold.setGoldStatus(1);
                    gold.setGoldPayStatus(2);
                    this.goldRecordService.update(gold);
                    ShoppingUser user = this.userService.getObjById(gold
                            .getGoldUserId());
                    user.setGold(user.getGold() + gold.getGoldCount());
                    this.userService.update(user);
                    log = new ShoppingGoldLogWithBLOBs();
                    log.setAddtime(new Date());
                    log.setGlPayment(gold.getGoldPayment());
                    log.setGlContent("支付宝在线支付");
                    log.setGlMoney(gold.getGoldMoney());
                    log.setGlCount(gold.getGoldCount());
                    log.setGlType(0);
                    log.setGlUserId(gold.getGoldUserId());
                    log.setGrId(gold.getId());
                    this.goldLogService.save(log);
                }
                mv = new JModelAndView("success.html", this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request, response);
                mv.addObject("op_title", "兑换" + gold.getGoldCount() + "金币成功");
                mv.addObject("url", CommUtil.getURL(request) +
                        "/seller/gold_record_list.htm");
            }

            if ((type.equals("integral")) && ((trade_status.equals("WAIT_SELLER_SEND_GOODS")) ||
                            (trade_status.equals("TRADE_FINISHED")) || (trade_status.equals("TRADE_SUCCESS")))) {
                if (ig_order.getIgoStatus() < 20) {
                    ig_order.setIgoStatus(20);
                    ig_order.setIgoPayTime(new Date());
                    ig_order.setIgoPayment("alipay");
                    this.integralGoodsOrderService.update(ig_order);
                     params.clear();
                     params.put("order_id",ig_order.getId());
                    List<ShoppingIntegralGoodscart> igcs = integralGoodsCartServiceService.queryByCondition(params);
                    for (ShoppingIntegralGoodscart igc : ig_order.getIgo_gcs()) {
                        ShoppingIntegralGoods goods = igc.getGoods();
                        goods.setIgGoodsCount(goods.getIgGoodsCount() -
                                igc.getCount());
                        goods.setIgExchangeCount(goods.getIgExchangeCount() + igc.getCount());
                        this.integralGoodsService.update(goods);
                    }
                }
                mv = new JModelAndView("integral_order_finish.html",this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request,response);
                viewTools.headHandle(mv,request);
                viewTools.topHandle(mv,request);
                viewTools.navshandle(mv);
                mv.addObject("obj", ig_order);
            }
        }else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "支付回调失败！");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }

    /**
     * 支付宝支付通知接口
     * @param request
     * @param response
     * @throws Exception
     */
    @RequestMapping({"/alipay_notify.htm"})
    public void alipay_notify(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String trade_no = request.getParameter("trade_no");
        String order_no = request.getParameter("out_trade_no");
        String total_fee = request.getParameter("price");
        String subject = request.getParameter("subject");
        String type = CommUtil.null2String(request.getParameter("body")).trim();
        String trade_status = request.getParameter("trade_status");
        ShoppingOrderformWithBLOBs order = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
        if (type.equals("goods")) {
            order = this.orderFormService.getObjById(
                    CommUtil.null2Long(order_no));
        }
        if (type.equals("cash")) {
            obj = this.predepositService.getObjById(
                    CommUtil.null2Long(order_no));
        }
        if (type.equals("gold")) {
            gold = this.goldRecordService.getObjById(
                    CommUtil.null2Long(order_no));
        }
        if (type.equals("integral")) {
            ig_order = this.integralGoodsOrderService.getObjById(
                    CommUtil.null2Long(order_no));
        }
        Map params = new HashMap();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext(); ) {
            String name = (String)iter.next();
            String[] values = (String[])requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                //valueStr =  valueStr + values[i] + ",";
                valueStr = valueStr + values[i];
            }

            valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
        AlipayConfig config = new AlipayConfig();
        if (type.equals("goods")) {
            if(order.getPaymentId() != null){
                ShoppingPaymentWithBLOBs payment = paymentService.getObjById(order.getPaymentId());
                config.setKey(payment.getSafekey());
                config.setPartner(payment.getPartner());
                config.setSeller_email(payment.getSellerEmail());
            }

        }
        if ((type.equals("cash")) || (type.equals("gold")) ||
                (type.equals("integral"))) {
            Map q_params = new HashMap();
            q_params.put("install", Boolean.valueOf(true));
            if (type.equals("cash")) {
                q_params.put("mark", obj.getPdPayment());
            }
            if (type.equals("gold")) {
                q_params.put("mark", gold.getGoldPayment());
            }
            if (type.equals("integral")) {
                q_params.put("mark", ig_order.getIgoPayment());
            }
            q_params.put("type", "admin");
            List<ShoppingPaymentWithBLOBs> payments = this.paymentService.queryByCondition(q_params);
                   /* .query("select obj from Payment obj where obj.install=:install and obj.mark=:mark and obj.type=:type",
                            q_params, -1, -1);*/
            config.setKey(payments.get(0).getSafekey());
            config.setPartner(payments.get(0).getPartner());
            config.setSeller_email(payments.get(0).getSellerEmail());
        }
        config.setNotify_url(CommUtil.getURL(request) + "/alipay_notify.htm");
        config.setReturn_url(CommUtil.getURL(request) + "/aplipay_return.htm");
        boolean verify_result = AlipayNotify.verify(config, params);
        if (verify_result) {
            if ((type.equals("goods")) && ((trade_status.equals("WAIT_SELLER_SEND_GOODS")) || (trade_status.equals("TRADE_FINISHED"))
                    || (trade_status.equals("TRADE_SUCCESS"))) && (order.getOrderStatus() < 20)) {
                order.setOrderStatus(20);
                order.setOutOrderId(trade_no);
                order.setPaytime(new Date());
                this.orderFormService.update(order);
                update_goods_inventory(order);
                ShoppingOrderLog ofl = new ShoppingOrderLog();
                ofl.setAddtime(new Date());
                ofl.setLogInfo("支付宝在线支付");
                ofl.setLogUserId(order.getUserId());
                ofl.setOfId(order.getId());
                this.orderFormLogService.save(ofl);

                if (this.configService.getSysConfig().getEmailenable()) {
                    //send_order_email(request, order, order.getUser().getEmail(),"email_tobuyer_online_pay_ok_notify");
                    //send_order_email(request, order, order.getStore().getUser().getEmail(),"email_toseller_online_pay_ok_notify");
                }

                if (this.configService.getSysConfig().getSmsenbale()) {
                    //send_order_sms(request, order, order.getUser().getMobile(),"sms_tobuyer_online_pay_ok_notify");
                   // send_order_sms(request, order, order.getStore().getUser().getMobile(),"sms_toseller_online_pay_ok_notify");
                }

            }

            if ((type.equals("cash")) && ((trade_status.equals("WAIT_SELLER_SEND_GOODS")) ||(trade_status.equals("TRADE_FINISHED")) || (trade_status.equals("TRADE_SUCCESS"))) &&
                    (obj.getPdPayStatus() < 2)) {
                obj.setPdStatus(1);
                obj.setPdPayStatus(2);
                this.predepositService.update(obj);
                ShoppingUser user = this.userService.getObjById(obj.getPdUserId());
                user.setAvailablebalance(BigDecimal.valueOf(CommUtil.add(user.getAvailablebalance(),obj.getPdAmount())));
                this.userService.update(user);
                ShoppingPredepositLog log = new ShoppingPredepositLog();
                log.setAddtime(new Date());
                log.setPdLogAmount(obj.getPdAmount());
                log.setPdLogUserId(obj.getPdUserId());
                log.setPdOpType("充值");
                log.setPdType("可用预存款");
                log.setPdLogInfo("支付宝在线支付");
                log.setDeletestatus(false);
                this.predepositLogService.save(log);
            }
            ShoppingGoldLogWithBLOBs log;
            if ((type.equals("gold")) &&
                    ((trade_status.equals("WAIT_SELLER_SEND_GOODS")) ||
                            (trade_status.equals("TRADE_FINISHED")) ||
                            (trade_status.equals("TRADE_SUCCESS"))) &&
                    (gold.getGoldPayStatus() < 2)) {
                gold.setGoldStatus(1);
                gold.setGoldPayStatus(2);
                this.goldRecordService.update(gold);
                ShoppingUser user = this.userService.getObjById(gold.getGoldUserId());
                user.setGold(user.getGold() + gold.getGoldCount());
                this.userService.update(user);
                log = new ShoppingGoldLogWithBLOBs();
                log.setAddtime(new Date());
                log.setGlPayment(gold.getGoldPayment());
                log.setGlContent("支付宝在线支付");
                log.setGlMoney(gold.getGoldMoney());
                log.setGlCount(gold.getGoldCount());
                log.setGlType(0);
                log.setGlUserId(gold.getGoldUserId());
                log.setGrId(gold.getId());
                log.setDeletestatus(false);
                this.goldLogService.save(log);
            }

            if ((type.equals("integral")) &&((trade_status.equals("WAIT_SELLER_SEND_GOODS")) ||
                            (trade_status.equals("TRADE_FINISHED")) ||
                            (trade_status.equals("TRADE_SUCCESS"))) &&
                    (ig_order.getIgoStatus() < 20)) {
                ig_order.setIgoStatus(20);
                ig_order.setIgoPayTime(new Date());
                ig_order.setIgoPayment("alipay");
                this.integralGoodsOrderService.update(ig_order);
                for (ShoppingIntegralGoodscart igc : ig_order.getIgo_gcs()) {
                    ShoppingIntegralGoods goods = igc.getGoods();
                    goods.setIgGoodsCount(goods.getIgGoodsCount() -
                            igc.getCount());
                    goods.setIgExchangeCount(goods.getIgExchangeCount() + igc.getCount());
                    this.integralGoodsService.update(goods);
                }

            }

            response.setContentType("text/plain");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            try
            {
                PrintWriter writer = response.getWriter();
                writer.print("success");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            response.setContentType("text/plain");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            try
            {
                PrintWriter writer = response.getWriter();
                writer.print("fail");
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 更新库存
     * @param order
     */
    private void update_goods_inventory(ShoppingOrderformWithBLOBs order){
        if(order != null){
            goodsCartTools.addOrderGcs(order);
            for (ShoppingGoodscart gc : order.getGcs()) {
                ShoppingGoodsWithBLOBs goods =goodsService.getObjById(gc.getGoodsId());
                if ((goods.getGroupId() != null) && (goods.getGroupBuy() == 2)) {
                    new GoodsViewTools().addgroupGoodsList(goods);
                    for (ShoppingGroupGoods gg : goods.getGroup_goods_list()) {
                        if (gg.getGroup().getId().equals(goods.getGroupId())) {
                            gg.setGgDefCount(gg.getGgDefCount() + gc.getCount());
                            gg.setGgCount(gg.getGgCount() - gc.getCount());
                            this.groupGoodsService.update(gg);
                        }
                    }
                }
                List gsps = new ArrayList();
                //获取信息
                goodsSpecPropertyTools.addGsps(gc);
                if(gc.getGsps() != null){
                    for (ShoppingGoodsspecproperty gsp : gc.getGsps()) {
                        gsps.add(gsp.getId().toString());
                    }
                }

                String[] gsp_list = new String[gsps.size()];
                gsps.toArray(gsp_list);
                goods.setGoodsSalenum(goods.getGoodsSalenum() + gc.getCount());
                String inventory_type = goods.getInventoryType() == null ? "all" : goods.getInventoryType();
                Map temp;
                if (inventory_type.equals("all")) {
                    goods.setGoodsInventory(goods.getGoodsInventory() - gc.getCount());
                } else {
                    List list = new Gson().fromJson(CommUtil.null2String(goods.getGoodsInventoryDetail()),ArrayList.class);
                    for (Iterator localIterator4 = list.iterator(); localIterator4.hasNext(); ) { temp = (Map)localIterator4.next();
                        String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
                        Arrays.sort(temp_ids);
                        Arrays.sort(gsp_list);
                        if (Arrays.equals(temp_ids, gsp_list)) {
                            temp.put("count", Integer.valueOf(CommUtil.null2Int(temp.get("count")) - gc.getCount()));
                        }
                    }
                    goods.setGoodsInventoryDetail(new Gson().toJson(list));
                }
                for (ShoppingGroupGoods gg : goods.getGroup_goods_list()) {
                    if ((!gg.getGroup().getId().equals(goods.getGroupId())) || (gg.getGgCount() != 0)) {
                        continue;
                    }
                    goods.setGroupBuy(3);
                }

                this.goodsService.update(goods);
            }
        }
    }

    @RequestMapping("/genericAlipay")
    @ResponseBody
    public String genericAlipay(String url, String payment_id, String type, String id){
        log.info("----alipaymsg--url---{}----payment--{}---type----{}---id----{}",url,payment_id,type,id);
        String result = "";
        List<ShoppingOrderformWithBLOBs> of = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
        if (type.equals("goods")) {
            of = this.orderFormService.selectByOrderNo(id);
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
        List<ShoppingPaymentWithBLOBs> payments = this.paymentService.queryByCondition(params);
        //.query("select obj from Payment obj where obj.type=:type and obj.mark=:mark", params, -1, -1);
        ShoppingPaymentWithBLOBs shop_payment = new ShoppingPaymentWithBLOBs();
        if (payments.size() > 0) {
            shop_payment = payments.get(0);
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
                out_trade_no = id;
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
                subject =id;
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
                BigDecimal price = new BigDecimal("0.00");
                for(ShoppingOrderformWithBLOBs s: of){
                    price=price.add(s.getTotalprice());
                }
                total_fee = price.toString();
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
                double apliay_rate =CommUtil.null2Double(shop_payment.getAlipayRate()) / 100.0D;
                double shop_fee = CommUtil.null2Double(total_fee) * (1.0D - apliay_rate);
                shop_fee *= fenrun_rate;
                double seller_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2Double(total_fee) * (1.0D - apliay_rate) - shop_fee;
                royalty_parameters = payment.getSellerEmail() + "^" + String.format("%.2f", new Object[] { Double.valueOf(seller_fee) }) + "^商家";
            }

            Map sParaTemp = new HashMap();
            sParaTemp.put("payment_type", "1");
            sParaTemp.put("out_trade_no", out_trade_no);
            sParaTemp.put("subject", subject);
            sParaTemp.put("body", body);
            total_fee ="0.01";
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
        if (interfaceType == 1) {
            String out_trade_no = "";
            if (type.equals("goods")) {
                out_trade_no = id;
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
                subject =id;
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
                BigDecimal price = new BigDecimal("0.00");
                for(ShoppingOrderformWithBLOBs s: of){
                    price=price.add(s.getTotalprice());
                }
                total_fee = price.toString();
            }
            if (type.equals("cash")) {
                total_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(obj.getPdAmount());
            }
            if (type.equals("gold")) {
                total_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
            }
            if (type.equals("integral")) {
                total_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(ig_order.getIgoTransFee());
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
        if (interfaceType == 2){
            String out_trade_no = "";
            if (type.equals("goods")) {
                out_trade_no = id;
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
                subject =id;
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
                BigDecimal price = new BigDecimal("0.00");
                for(ShoppingOrderformWithBLOBs s: of){
                    price=price.add(s.getTotalprice());
                }
                total_fee = price.toString();
            }
            if (type.equals("cash")) {
                total_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(obj.getPdAmount());
            }
            if (type.equals("gold")) {
                total_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
            }
            if (type.equals("integral")) {
                total_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(ig_order.getIgoTransFee());
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

    @RequestMapping("/generic99Bill")
    @ResponseBody
    public String generic99Bill(String url, String payment_id, String type, String id)throws UnsupportedEncodingException {
        String result = "";
        ShoppingOrderformWithBLOBs of = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
        if (type.equals("goods")) {
            of = this.orderFormService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("cash")) {
            obj = this.predepositService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("gold")) {
            gold = this.goldRecordService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("integral")) {
            ig_order = this.integralGoodsOrderService.getObjById(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
                com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(payment_id));
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
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Double(of.getTotalprice()) * 100.0D));
        }
        if (type.equals("cash")) {
            orderAmount = String.valueOf((int)Math.floor(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Double(obj.getPdAmount()) * 100.0D));
        }
        if (type.equals("gold")) {
            orderAmount = String.valueOf((int)Math.floor(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Double(Integer.valueOf(gold.getGoldMoney())) * 100.0D));
        }
        if (type.equals("integral")) {
            orderAmount = String.valueOf((int)Math.floor(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Double(ig_order.getIgoTransFee()) * 100.0D));
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

    @RequestMapping("/genericChinaBank")
    @ResponseBody
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
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
                com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(payment_id));
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

    @RequestMapping("/genericPaypal")
    @ResponseBody
    public String genericPaypal(String url, String payment_id, String type, String id){
        List<ShoppingOrderformWithBLOBs> of = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
        if (type.equals("goods")) {
            of = this.orderFormService.selectByOrderNo(id);
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
        List sms = new ArrayList();
        String business = payment.getPaypalUserid();
        sms.add(new SysMap("business", business));
        String return_url = url + "/paypal_return.htm";
        String notify_url = url + "/paypal_notify.htm";
        sms.add(new SysMap("return", return_url));
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
        sms.add(new SysMap("item_name", item_name));
        String amount = "";
        String item_number = "";
        if (type.equals("goods")) {
            BigDecimal price = new BigDecimal("0.00");
            for(ShoppingOrderformWithBLOBs o: of){
                price=price.add(o.getTotalprice());
            }
            amount =price.toString();
            item_number = id;
        }
        if (type.equals("cash")) {
            amount =CommUtil.null2String(obj.getPdAmount());
            item_number = obj.getPdSn();
        }
        if (type.equals("gold")) {
            amount = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
            item_number = gold.getGoldSn();
        }
        if (type.equals("integral")) {
            amount =CommUtil.null2String(ig_order.getIgoTransFee());
            item_number = ig_order.getIgoOrderSn();
        }
        sms.add(new SysMap("amount", amount));
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

    @RequestMapping({"/paypal_notify.htm"})
    public void paypal_notify(HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        /*-----------回调处理-------------------*/
        //HttpServletRequest request;
        System.out.println(request.getParameterMap()+"----notify"+request.getInputStream());
        /*-----------回调处理-------------------*/
    }

    @RequestMapping({"/paypal_return.htm"})
    public ModelAndView paypal_return(HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ModelAndView mv = new JModelAndView("order_finish.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        Enumeration en = request.getParameterNames();
        String str = "cmd=_notify-validate";
        while (en.hasMoreElements()) {
            String paramName = (String) en.nextElement();
            String paramValue = request.getParameter(paramName);
            str = str + "&" + paramName + "=" + URLEncoder.encode(paramValue);
        }
        String[] customs = CommUtil.null2String(request.getParameter("custom"))
                .split(",");
        String remark1 = customs[0];
        String remark2 = customs[1];
        String item_name = request.getParameter("item_name");
        String txnId = request.getParameter("txn_id");
        ShoppingOrderformWithBLOBs order = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
        if (remark2.equals("goods")) {
            order = this.orderFormService.getObjById(CommUtil.null2Long(remark1
                    .trim()));
        }
        if (remark2.equals("cash")) {
            obj = this.predepositService
                    .getObjById(CommUtil.null2Long(remark1));
        }
        if (remark2.equals("gold")) {
            gold = this.goldRecordService.getObjById(
                    CommUtil.null2Long(remark1));
        }
        if (remark2.equals("integral")) {
            ig_order = this.integralGoodsOrderService.getObjById(
                    CommUtil.null2Long(remark1));
        }
        String txn_id = request.getParameter("txn_id");
        String itemName = request.getParameter("item_name");
        String paymentStatus = request.getParameter("payment_status");
        String paymentAmount = request.getParameter("mc_gross");
        String paymentCurrency = request.getParameter("mc_currency");
        String receiverEmail = request.getParameter("receiver_email");
        String payerEmail = request.getParameter("payer_email");

        if ((paymentStatus.equals("Completed")) ||
                (paymentStatus.equals("Pending"))) {
            if (remark2.equals("goods")) {
                order.setOrderStatus(20);
                order.setPaytime(new Date());
                this.orderFormService.update(order);
                update_goods_inventory(order);
                ShoppingOrderLog ofl = new ShoppingOrderLog();
                ofl.setAddtime(new Date());
                ofl.setLogInfo("Paypal在线支付");
                ofl.setLog_user(SecurityUserHolder.getCurrentUser());
                ofl.setOfId(order.getId());
                this.orderFormLogService.save(ofl);
                mv.addObject("obj", order);
                ShoppingUser buyer = userService.getObjById(order.getUserId());
                ShoppingUser seller = userService.queryOneByStoreId(order.getStoreId());
                if (this.configService.getSysConfig().getEmailenable()) {
                        send_order_email( order, buyer.getEmail(),"email_tobuyer_online_pay_ok_notify");
                        send_order_email( order, seller.getEmail(),"email_toseller_online_pay_ok_notify");
                    }

                    if (this.configService.getSysConfig().getSmsenbale()) {
                        send_order_sms( order, buyer.getMobile(),"sms_tobuyer_online_pay_ok_notify");
                        send_order_sms( order, seller.getMobile(),"sms_toseller_online_pay_ok_notify");
                    }
                }
                if (remark2.endsWith("cash")) {
                    obj.setPdStatus(1);
                    obj.setPdPayStatus(2);
                    this.predepositService.update(obj);
                    ShoppingUser user = this.userService.getObjById(obj.getPdUserId());
                    user.setAvailablebalance(BigDecimal.valueOf(CommUtil.add(
                            user.getAvailablebalance(), obj.getPdAmount())));
                    this.userService.update(user);
                    ShoppingPredepositLog log = new ShoppingPredepositLog();
                    log.setAddtime(new Date());
                    log.setPdLogAmount(obj.getPdAmount());
                    log.setPdLogUserId(obj.getPdUserId());
                    log.setPdOpType("充值");
                    log.setPdType("可用预存款");
                    log.setPdLogInfo("Paypal在线支付");
                    this.predepositLogService.save(log);
                    mv = new JModelAndView("success.html",
                            this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1, request,
                            response);
                    mv.addObject("op_title", "成功充值：" + obj.getPdAmount());
                    mv.addObject("url", CommUtil.getURL(request) +
                            "/buyer/predeposit_list.htm");
                }
                ShoppingGoldLogWithBLOBs log;
                if (remark2.equals("gold")) {
                    gold.setGoldStatus(1);
                    gold.setGoldPayStatus(2);
                    this.goldRecordService.update(gold);
                    ShoppingUser user = this.userService.getObjById(gold.getGoldUserId());
                    user.setGold(user.getGold() + gold.getGoldCount());
                    this.userService.update(user);
                    log = new ShoppingGoldLogWithBLOBs();
                    log.setAddtime(new Date());
                    log.setGlPayment(gold.getGoldPayment());
                    log.setGlContent("Paypal");
                    log.setGlMoney(gold.getGoldMoney());
                    log.setGlCount(gold.getGoldCount());
                    log.setGlType(0);
                    log.setGlUserId(gold.getGoldUserId());
                    log.setGrId(gold.getId());
                    this.goldLogService.save(log);
                    mv = new JModelAndView("success.html",
                            this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1, request,
                            response);
                    mv.addObject("op_title", "成功充值金币:" + gold.getGoldCount());
                    mv.addObject("url", CommUtil.getURL(request) +
                            "/seller/gold_record_list.htm");
                }
                if (remark2.equals("gold")) {
                    ig_order.setIgoStatus(20);
                    ig_order.setIgoPayTime(new Date());
                    ig_order.setIgoPayment("paypal");
                    this.integralGoodsOrderService.update(ig_order);
                    for (ShoppingIntegralGoodscart igc : ig_order.getIgo_gcs()) {
                        ShoppingIntegralGoods goods = igc.getGoods();
                        goods.setIgGoodsCount(goods.getIgGoodsCount() -
                                igc.getCount());
                        goods.setIgExchangeCount(goods.getIgExchangeCount() +
                                igc.getCount());
                        this.integralGoodsService.update(goods);
                    }
                    mv = new JModelAndView("integral_order_finish.html",
                            this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1, request,
                            response);
                    mv.addObject("obj", ig_order);
                }
            } else {
                mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request,
                        response);
                mv.addObject("op_title", "Paypal支付失败");
                mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
            }
            return mv;
        }

    private void send_order_sms(ShoppingOrderformWithBLOBs order, String mobile, String mark) throws UnsupportedEncodingException {
        Map<String, Object> param = new HashMap();
        param.put("mark", mark);
        ShoppingTemplate template = templateService.queryByCondition(param);
        if ((template != null) && (template.getOpen())) {
            String content =template.getContent();
            sendMessageService.sendSMS(mobile,content);
        }
    }

    private void send_order_email(ShoppingOrderformWithBLOBs order, String email, String mark) {
        Map<String, Object> param = new HashMap();
        param.put("mark", mark);
        ShoppingTemplate template = templateService.queryByCondition(param);
        if ((template != null) && (template.getOpen())) {
            String subject=template.getTitle();
            String content =template.getContent();
            sendMessageService.sendEmail(email,subject,content);
        }
    }


    @RequestMapping("/genericAlipayWap")
    @ResponseBody
    public String genericAlipayWap(String url, String payment_id, String type, String id)throws Exception{
        String result = "";
        ShoppingOrderformWithBLOBs of = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
        if (type.equals("goods")) {
            of = this.orderFormService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("cash")) {
            obj = this.predepositService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("gold")) {
            gold = this.goldRecordService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("integral")) {
            ig_order = this.integralGoodsOrderService.getObjById(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
                com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(payment_id));
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
        if ((!com.xdj.interfaces.mallinterface.util.CommUtil.null2String(payment.getSafekey()).equals("")) &&
                (!com.xdj.interfaces.mallinterface.util.CommUtil.null2String(payment.getPartner()).equals(""))) {
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
            total_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(of.getTotalprice());
        }
        if (type.equals("cash")) {
            total_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(obj.getPdAmount());
        }
        if (type.equals("gold")) {
            total_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
        }
        if (type.equals("integral")) {
            total_fee = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(ig_order.getIgoTransFee());
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

    @RequestMapping("/generic99BillWap")
    @ResponseBody
    public String generic99BillWap(String url, String payment_id, String type, String id)throws UnsupportedEncodingException{
        String result = "";
        ShoppingOrderformWithBLOBs of = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;

        if (type.equals("goods")) {
            of = this.orderFormService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("cash")) {
            obj = this.predepositService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("gold")) {
            gold = this.goldRecordService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("integral")) {
            ig_order = this.integralGoodsOrderService.getObjById(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
                com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(payment_id));
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
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Double(of.getTotalprice()) * 100.0D));
        }
        if (type.equals("cash")) {
            orderAmount = String.valueOf((int)Math.floor(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Double(obj.getPdAmount()) * 100.0D));
        }
        if (type.equals("gold")) {
            orderAmount = String.valueOf((int)Math.floor(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Double(Integer.valueOf(gold.getGoldMoney())) * 100.0D));
        }
        if (type.equals("integral")) {
            orderAmount = String.valueOf((int)Math.floor(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Double(ig_order.getIgoTransFee()) * 100.0D));
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

    @RequestMapping("/genericChinaBankWap")
    @ResponseBody
    public String genericChinaBankWap(String url, String payment_id, String type, String id){
        ShoppingOrderformWithBLOBs of = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
        if (type.equals("goods")) {
            of = this.orderFormService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("cash")) {
            obj = this.predepositService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("gold")) {
            gold = this.goldRecordService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("integral")) {
            ig_order = this.integralGoodsOrderService.getObjById(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
                com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(payment_id));
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
            v_amount = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(of.getTotalprice());
        }
        if (type.equals("cash")) {
            v_amount = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(obj.getPdAmount());
        }
        if (type.equals("gold")) {
            v_amount = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
        }
        if (type.equals("integral")) {
            v_amount = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(ig_order.getIgoTransFee());
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

    @RequestMapping("/genericPaypalWap")
    @ResponseBody
    public String genericPaypalWap(String url, String payment_id, String type, String id){
        ShoppingOrderformWithBLOBs of = null;
        ShoppingPredepositWithBLOBs obj = null;
        ShoppingGoldRecordWithBLOBs gold = null;
        ShoppingIntegralGoodsorderWithBLOBs ig_order = null;
        if (type.equals("goods")) {
            of = this.orderFormService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("cash")) {
            obj = this.predepositService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("gold")) {
            gold = this.goldRecordService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        if (type.equals("integral")) {
            ig_order = this.integralGoodsOrderService.getObjById(
                    com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(id));
        }
        ShoppingPaymentWithBLOBs payment = this.paymentService.getObjById(
                com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(payment_id));
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
            amount = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(of.getTotalprice());
            item_number = of.getOrderId();
        }
        if (type.equals("cash")) {
            amount = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(obj.getPdAmount());
            item_number = obj.getPdSn();
        }
        if (type.equals("gold")) {
            amount = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
            item_number = gold.getGoldSn();
        }
        if (type.equals("integral")) {
            amount = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(ig_order.getIgoTransFee());
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

    @RequestMapping({"/tenpay.htm"})
    public void tenpay(HttpServletRequest request, HttpServletResponse response, String id, String type, String payment_id)throws IOException{
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

        String order_price = "";
        if (type.equals("goods")) {
            order_price = CommUtil.null2String(of.getTotalprice());
        }
        if (type.equals("cash")) {
            order_price = CommUtil.null2String(obj.getPdAmount());
        }
        if (type.equals("gold")) {
            order_price = CommUtil.null2String(Integer.valueOf(gold.getGoldMoney()));
        }
        if (type.equals("integral")) {
            order_price = CommUtil.null2String(ig_order.getIgoTransFee());
        }

        double total_fee = CommUtil.null2Double(order_price) * 100.0D;
        int fee = (int)total_fee;

        String product_name = "";
        if (type.equals("goods")) {
            product_name = of.getOrderId();
        }
        if (type.equals("cash")) {
            product_name = obj.getPdSn();
        }
        if (type.equals("gold")) {
            product_name = gold.getGoldSn();
        }
        if (type.equals("integral")) {
            product_name = ig_order.getIgoOrderSn();
        }

        String remarkexplain = "";
        if (type.equals("goods")) {
            remarkexplain = of.getMsg();
        }
        if (type.equals("cash")) {
            remarkexplain = obj.getPdRemittanceInfo();
        }
        if (type.equals("gold")) {
            remarkexplain = gold.getGoldExchangeInfo();
        }
        if (type.equals("integral")) {
            remarkexplain = ig_order.getIgoMsg();
        }
        String attach = "";
        if (type.equals("goods")) {
            attach = type + "," + of.getId().toString();
        }
        if (type.equals("cash")) {
            attach = type + "," + obj.getId().toString();
        }
        if (type.equals("gold")) {
            attach = type + "," + gold.getId().toString();
        }
        if (type.equals("integral")) {
            attach = type + "," + ig_order.getId().toString();
        }
        String desc = "商品：" + product_name;

        String out_trade_no = "";
        if (type.equals("goods")) {
            out_trade_no = of.getOrderId();
        }
        if (type.endsWith("cash")) {
            out_trade_no = obj.getPdSn();
        }
        if (type.endsWith("gold")) {
            out_trade_no = gold.getGoldSn();
        }
        if (type.equals("integral")) {
            out_trade_no = ig_order.getIgoOrderSn();
        }

        ShoppingPayment payment = this.paymentService.getObjById(
                CommUtil.null2Long(payment_id));
        if (payment == null) {
            payment = new ShoppingPayment();
        }
        String trade_mode = CommUtil.null2String(Integer.valueOf(payment.getTradeMode()));
        String currTime = TenpayUtil.getCurrTime();

        RequestHandler reqHandler = new RequestHandler(request, response);
        reqHandler.init();
        reqHandler.setKey(payment.getTenpayKey());
        reqHandler.setGateUrl("https://gw.tenpay.com/gateway/pay.htm");
        reqHandler.setParameter("partner", payment.getTenpayPartner());
        reqHandler.setParameter("out_trade_no", out_trade_no);
        reqHandler.setParameter("total_fee", String.valueOf(fee));
        reqHandler.setParameter("return_url", CommUtil.getURL(request) +"/tenpay_return.htm");
        reqHandler.setParameter("notify_url", CommUtil.getURL(request) + "/tenpay_notify.htm");
        reqHandler.setParameter("body", desc);
        reqHandler.setParameter("bank_type", "DEFAULT");
        reqHandler.setParameter("spbill_create_ip", request.getRemoteAddr());
        reqHandler.setParameter("fee_type", "1");
        reqHandler.setParameter("subject", desc);
        reqHandler.setParameter("sign_type", "MD5");
        reqHandler.setParameter("service_version", "1.0");
        reqHandler.setParameter("input_charset", "UTF-8");
        reqHandler.setParameter("sign_key_index", "1");
        reqHandler.setParameter("attach", attach);
        reqHandler.setParameter("product_fee", "");
        reqHandler.setParameter("transport_fee", "0");
        reqHandler.setParameter("time_start", currTime);
        reqHandler.setParameter("time_expire", "");
        reqHandler.setParameter("buyer_id", "");
        reqHandler.setParameter("goods_tag", "");
        reqHandler.setParameter("trade_mode", trade_mode);
        reqHandler.setParameter("transport_desc", "");
        reqHandler.setParameter("trans_type", "1");
        reqHandler.setParameter("agentid", "");
        reqHandler.setParameter("agent_type", "");
        reqHandler.setParameter("seller_id", "");
        String requestUrl = reqHandler.getRequestURL();
        response.sendRedirect(requestUrl);
    }
}
