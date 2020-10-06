package com.xdj.interfaces.mallinterface.controller.shop;

import com.xdj.interfaces.mallinterface.controller.view.AreaViewTools;
import com.xdj.interfaces.mallinterface.controller.view.IntegralViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.pay.tools.PayTools;
import com.xdj.interfaces.mallinterface.pay.tools.PaymentTools;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.tools.StringUtils;
import com.xdj.www.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

/**
 * shopping积分控制层
 * @author Administrator
 */
@RestController
public class IntegralController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IIntegralGoodsService integralGoodsService;
    @Resource
    private IntegralViewTools integralViewTools;
    @Resource
    private IIntegralGoodsCartService integralGoodsCartService;
    @Resource
    private IUserService userService;
    @Resource
    private IAddressService addressService;
    @Resource
    private IAreaService areaService;
    @Resource
    private ViewTools viewTools;
    @Resource
    private AreaViewTools areaViewTools;
    @Resource
    private PaymentTools paymentTools;
    @Resource
    private PayTools payTools;
    @Resource
    private IIntegralGoodsOrderService integralGoodsOrderService;
    @Resource
    private IIntegralLogService integralLogService;
    @Resource
    private IPaymentService paymentService;

    private Logger log = LoggerFactory.getLogger("integral");


    @RequestMapping({"/integral.htm"})
    public ModelAndView integral(HttpServletRequest request, HttpServletResponse response, String begin, String end){
        ModelAndView mv = new JModelAndView("integral.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        if (this.configService.getSysConfig().getIntegralstore()) {
            Map params = new HashMap();
            params.put("ig_recommend", Boolean.valueOf(true));
            params.put("ig_show", Boolean.valueOf(true));
            params.put("orderBy","ig_sequence");
            params.put("sort","asc");
            params.put("start",0);
            params.put("pageSize",10);
            List<ShoppingIntegralGoods> recommend_igs = new ArrayList();
            if ((begin != null) && (!begin.equals("")) && (end != null) && (!end.equals(""))) {
                if (end.equals("0")) {
                    params.put("begin", Integer.valueOf(CommUtil.null2Int(begin)));

                    recommend_igs = this.integralGoodsService.queryByCondition(params);
                            //.query("select obj from IntegralGoods obj where obj.ig_recommend=:recommend and obj.ig_show=:show and  obj.ig_goods_integral>=:begin order by obj.ig_sequence asc",
                              //      params, 0, 10);
                } else {
                    params.put("integral_start", Integer.valueOf(CommUtil.null2Int(begin)));
                    params.put("integral_end", Integer.valueOf(CommUtil.null2Int(end)));
                    recommend_igs = this.integralGoodsService.queryByCondition(params);
                            //.query("select obj from IntegralGoods obj where obj.ig_recommend=:recommend and obj.ig_show=:show and  obj.ig_goods_integral>=:begin and obj.ig_goods_integral<:end order by obj.ig_sequence asc",
                                   // params, 0, 10);
                }
            }else {
                recommend_igs = this.integralGoodsService.queryByCondition(params);
                       // .query("select obj from IntegralGoods obj where obj.ig_recommend=:recommend and obj.ig_show=:show order by obj.ig_sequence asc",
                        //        params, 0, 10);
            }
            integralViewTools.addGoodsImgs(recommend_igs);
            mv.addObject("recommend_igs", recommend_igs);
            params.clear();
            params.put("ig_show", Boolean.valueOf(true));
            params.put("start",0);
            params.put("pageSize",15);
            params.put("orderBy","ig_sequence");
            params.put("sort","asc");
            List<ShoppingIntegralGoods> new_igs = new ArrayList();
            if ((begin != null) && (!begin.equals("")) && (end != null) && (!end.equals(""))) {
                if (end.equals("0")) {
                    params.put("begin", Integer.valueOf(CommUtil.null2Int(begin)));
                    new_igs = this.integralGoodsService.queryByCondition(params);
                           // .query("select obj from IntegralGoods obj where obj.ig_show=:show and  obj.ig_goods_integral>=:begin order by obj.ig_sequence asc",
                              //      params, 0, 15);
                } else {
                    params.put("begin", Integer.valueOf(CommUtil.null2Int(begin)));
                    params.put("end", Integer.valueOf(CommUtil.null2Int(end)));
                    new_igs = this.integralGoodsService.queryByCondition(params);
                           // .query("select obj from IntegralGoods obj where obj.ig_show=:show and  obj.ig_goods_integral>=:begin and obj.ig_goods_integral<:end order by obj.ig_sequence asc",
                             //       params, 0, 15);
                }
            }
            else {
                new_igs = this.integralGoodsService.queryByCondition(params);
                        //.query("select obj from IntegralGoods obj where obj.ig_show=:show order by obj.ig_sequence asc",
                              //  params, 0, 15);
            }
            integralViewTools.addGoodsImgs(new_igs);
            mv.addObject("new_igs", new_igs);
            params.clear();
            params.put("orderBy","ig_exchange_count");
            params.put("sort","desc");
            params.put("start",0);
            params.put("pageSize",8);
            List<ShoppingIntegralGoods> exchange_igs = this.integralGoodsService.queryByCondition(params);
                    //.query("select obj from IntegralGoods obj order by obj.ig_exchange_count desc",
                      //      null, -1, -1);
            integralViewTools.addGoodsImgs(new_igs);
            mv.addObject("exchange_igs", exchange_igs);
            if (SecurityUserHolder.getCurrentUser() != null) {
                mv.addObject("user",SecurityUserHolder.getCurrentUser());
            }
            mv.addObject("integral_cart", request.getSession(false).getAttribute("integral_goods_cart"));
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启积分商城");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        viewTools.topHandle(mv,request);
        viewTools.nav1Handle(mv);
        viewTools.advertInvoke(mv,"229376","integralInvoke");
        return mv;
    }


    @RequestMapping({"/integral_view.htm"})
    public ModelAndView integral_view(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView("integral_view.html",this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
        if (this.configService.getSysConfig().getIntegralstore()) {
            ShoppingIntegralGoods obj = this.integralGoodsService.getObjById(CommUtil.null2Long(id));
            obj.setIgClickCount(obj.getIgClickCount() + 1);
            this.integralGoodsService.update(obj);
            Map<String, Object> params = new HashMap<String,Object>();
            params.put("orderBy","addTime");
            params.put("sort","desc");
            params.put("start",0);
            params.put("pageSize",20);
            List<ShoppingIntegralGoodscart> gcs = this.integralGoodsCartService.queryByCondition(params);
            integralViewTools.goodscartAddIntegralGoods(gcs);
            integralViewTools.addOrders(gcs);
                    /*.query("select obj from IntegralGoodsCart obj order by obj.addTime desc",
                            null, 0, 20);*/
            integralViewTools.addGoodsImg(obj);
            mv.addObject("integralGcs", gcs);
            mv.addObject("obj", obj);
            mv.addObject("view_url", CommUtil.getURL(request) +"/integral_view.htm？id=" + id);
            viewTools.topHandle(mv,request);
            viewTools.nav1Handle(mv);
            viewTools.headHandle(mv,request);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启积分商城");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }


    @RequestMapping({"/integral_exchange2.htm"})
    public ModelAndView integral_exchange2(HttpServletRequest request, HttpServletResponse response, String id, String exchange_count) {
        ModelAndView mv = new JModelAndView("integral_exchange2.html",this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        if (this.configService.getSysConfig().getIntegralstore()) {
            List<ShoppingIntegralGoodscart> igcs = (List<ShoppingIntegralGoodscart>)request.getSession(false).getAttribute("integral_goods_cart");
            if (igcs != null) {
                integralViewTools.goodscartAddIntegralGoods(igcs);
                Map params = new HashMap();
                params.put("user_id", 32768L);
                List<ShoppingAddress> addrs = this.addressService.queryByCondition(params);
                areaViewTools.addAddrAreas(addrs,true);
                mv.addObject("addrs", addrs);
                mv.addObject("igcs",igcs == null ? new ArrayList() :igcs);
                int total_integral = 0;
                double trans_fee = 0.0D;
                for (ShoppingIntegralGoodscart igc : igcs) {
                    total_integral += igc.getIntegral();
                    trans_fee = CommUtil.null2Double(igc.getTransFee()) +trans_fee;
                }
                mv.addObject("trans_fee", Double.valueOf(trans_fee));
                mv.addObject("total_integral", Integer.valueOf(total_integral));
                String integral_order_session = CommUtil.randomString(32);
                mv.addObject("integral_order_session", integral_order_session);
                request.getSession(false).setAttribute("integral_order_session", integral_order_session);
                params.clear();
                params.put("parent_id","is null");
                List<ShoppingArea> areas = this.areaService.queryByCondition(params);
                areaViewTools.addManyChilds(areas,true);
                mv.addObject("areas", areas);
            } else {
                mv = new JModelAndView("error.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(),
                        1, request,response);
                mv.addObject("op_title", "兑换购物车为空");
                mv.addObject("url", CommUtil.getURL(request) + "/integral.htm");
            }
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启积分商城");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }

    @RequestMapping({"/integral_exchange1.htm"})
    public ModelAndView integral_exchange1(HttpServletRequest request, HttpServletResponse response, String id, String exchange_count) {
        ModelAndView mv = new JModelAndView("integral_exchange1.html",this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        log.info("------id={}-------------exchange_count={} ",id,exchange_count);
        if (this.configService.getSysConfig().getIntegralstore()) {
            ShoppingIntegralGoods obj = this.integralGoodsService.getObjById( CommUtil.null2Long(id));
            int exchange_status = 0;
            if (obj != null) {
                integralViewTools.addGoodsImg(obj);
                if ((exchange_count == null) || (exchange_count.equals(""))) {
                    exchange_count = "1";
                }
                if (obj.getIgGoodsCount() < CommUtil.null2Int(exchange_count)) {
                    exchange_status = -1;
                    mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1, request, response);
                    mv.addObject("op_title", "库存数量不足，重新选择兑换数量");
                    mv.addObject("url", CommUtil.getURL(request) +"/integral_view.htm？id="+id);
                }
                if (obj.getIgLimitType()){
                    if (obj.getIgLimitCount() < CommUtil.null2Int(exchange_count)) {
                        exchange_status = -2;
                        mv = new JModelAndView("error.html",
                                this.configService.getSysConfig(),
                                this.userConfigService.getUserConfig(), 1, request,
                                response);
                        mv.addObject("op_title", "限制最多兑换" + obj.getIgLimitCount() +
                                "，重新选择兑换数量");
                        mv.addObject("url", CommUtil.getURL(request) + "/integral_view.htm?id="+id);
                    }
                }
                int cart_total_integral = obj.getIgGoodsIntegral() *CommUtil.null2Int(exchange_count);
                ShoppingUser user =userService.getObjById(32768L);
                if (user.getIntegral() < cart_total_integral) {
                    exchange_status = -3;
                    mv = new JModelAndView("error.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request,
                            response);
                    mv.addObject("op_title", "您的积分不足");
                    mv.addObject("url", CommUtil.getURL(request) +
                            "/integral_view.htm?id="+id);
                }
                if ((obj.getIgBeginTime() != null) &&
                        (obj.getIgEndTime() != null) && (
                        (obj.getIgBeginTime().after(new Date())) ||
                                (obj.getIgEndTime().before(new Date())))) {
                    exchange_status = -4;
                    mv = new JModelAndView("error.html",
                            this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1,
                            request, response);
                    mv.addObject("op_title", "兑换已经过期");
                    mv.addObject("url", CommUtil.getURL(request) +"/integral_view.htm?id=" + id);
                }

            }

            if (exchange_status == 0) {
                List<ShoppingIntegralGoodscart> integral_goods_cart = (List)request.getSession(false).getAttribute("integral_goods_cart");
                if (integral_goods_cart == null) {
                    integral_goods_cart = new ArrayList();
                }
                boolean add = obj != null;
                for (ShoppingIntegralGoodscart igc : integral_goods_cart) {
                    if (igc.getGoods().getId().toString().equals(id)) {
                        add = false;
                        break;
                    }
                }
                if (add) {
                    ShoppingIntegralGoodscart gc = new ShoppingIntegralGoodscart();
                    gc.setAddtime(new Date());
                    gc.setCount(CommUtil.null2Int(exchange_count));
                    gc.setGoods(obj);
                    gc.setTransFee(obj.getIgTransfee());
                    gc.setIntegral(CommUtil.null2Int(exchange_count) * obj.getIgGoodsIntegral());
                    gc.setGoodsId(obj.getId());
                    integral_goods_cart.add(gc);
                }
                request.getSession(false).setAttribute("integral_goods_cart", integral_goods_cart);
                int total_integral = 0;
                for (ShoppingIntegralGoodscart igc : integral_goods_cart) {
                    total_integral += igc.getIntegral();
                }
                mv.addObject("total_integral", Integer.valueOf(total_integral));
                mv.addObject("integral_cart", integral_goods_cart);
                mv.addObject("user",userService.getObjById(32768L));
            }
            viewTools.topHandle(mv,request);
            viewTools.headHandle(mv,request);
            viewTools.nav1Handle(mv);
            viewTools.footerHandle(mv);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启积分商城");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }

    @RequestMapping({"/integral_exchange3.htm"})
    public ModelAndView integral_exchange3(HttpServletRequest request, HttpServletResponse response, String addr_id, String igo_msg, String integral_order_session, String area_id, String trueName, String area_info, String zip, String telephone, String mobile)
    {
        ModelAndView mv = new JModelAndView("integral_exchange3.html",
                this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
        if (this.configService.getSysConfig().getIntegralstore()) {
            List<ShoppingIntegralGoodscart> igcs = (List)request.getSession(false).getAttribute("integral_goods_cart");
            String integral_order_session1 = CommUtil.null2String(request
                    .getSession(false).getAttribute("integral_order_session"));
            if (integral_order_session1.equals("")) {
                mv = new JModelAndView("error.html",
                        this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request,
                        response);
                mv.addObject("op_title", "表单已经过期");
                mv.addObject("url", CommUtil.getURL(request) + "/integral.htm");
            }else if (integral_order_session1.equals(integral_order_session.trim())) {
                if (igcs != null) {
                    int total_integral = 0;
                    double trans_fee = 0.0D;
                    for (ShoppingIntegralGoodscart igc : igcs) {
                        total_integral += igc.getIntegral();
                        trans_fee =CommUtil.null2Double(igc.getTransFee()) +trans_fee;
                    }
                    ShoppingIntegralGoodsorderWithBLOBs order = new ShoppingIntegralGoodsorderWithBLOBs();
                    ShoppingAddress addr = null;
                    if ("new".equals(addr_id)) {
                        addr = new ShoppingAddress();
                        addr.setAddtime(new Date());
                        ShoppingArea area = null;
                        if(StringUtils.isBlank(area_id)){
                            area = this.areaService.getObjById( CommUtil.null2Long(area_id));
                        }
                        addr.setAreaInfo(area_info);
                        addr.setMobile(mobile);
                        addr.setTelephone(telephone);
                        addr.setTruename(trueName);
                        addr.setZip(zip);
                        addr.setArea(area);
                        addr.setUserId(SecurityUserHolder.getCurrentUser().getId());
                        addr.setDeletestatus(false);
                        addr.setIsdefault(false);
                        this.addressService.save(addr);
                    } else {
                        addr = this.addressService.getObjById(CommUtil.null2Long(addr_id));
                    }
                    order.setAddtime(new Date());
                    order.setIgoAddrId(addr.getId());
                    order.setIgoMsg(igo_msg);

                    ShoppingUser user = SecurityUserHolder.getCurrentUser();
                    order.setIgoOrderSn("igo" + CommUtil.formatTime("yyyyMMddHHmmss",new Date()) + user.getId());
                    order.setIgoUserId(user.getId());
                    order.setIgoTransFee(BigDecimal.valueOf(trans_fee));
                    order.setIgoTotalIntegral(total_integral);
                    for (ShoppingIntegralGoodscart igc : igcs) {
                        igc.setOrder(order);
                    }
                    if (trans_fee == 0.0D) {
                        order.setIgoStatus(20);
                        order.setIgoPayTime(new Date());
                        order.setIgoPayment("no_fee");
                        order.setDeletestatus(false);
                        this.integralGoodsOrderService.save(order);
                        if(igcs != null){
                            for(ShoppingIntegralGoodscart s: igcs){
                                s.setDeletestatus(false);
                                s.setOrderId(order.getId());
                                integralGoodsCartService.save(s);
                            }
                        }
                        for (ShoppingIntegralGoodscart igc : order.getIgo_gcs()) {
                            ShoppingIntegralGoods goods = igc.getGoods();
                            goods.setIgGoodsCount(goods .getIgGoodsCount() - igc.getCount());
                            goods.setIgExchangeCount(goods.getIgExchangeCount() +igc.getCount());
                            this.integralGoodsService.update(goods);
                        }
                        request.getSession(false).removeAttribute("integral_goods_cart");
                        mv.addObject("url", CommUtil.getURL(request) + "/integral.htm");
                        mv.addObject("order", order);
                    } else {
                        order.setIgoStatus(0);
                        this.integralGoodsOrderService.save(order);
                        mv = new JModelAndView("integral_exchange4.html",this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1,
                                request, response);
                        mv.addObject("obj", order);
                        mv.addObject("paymentTools", this.paymentTools);
                    }

                    user.setIntegral(user.getIntegral() - order.getIgoTotalIntegral());
                    this.userService.update(user);
                    ShoppingIntegrallog log = new ShoppingIntegrallog();
                    log.setAddtime(new Date());
                    log.setContent("兑换商品消耗积分");
                    log.setIntegral(-order.getIgoTotalIntegral());
                    log.setIntegralUserId(user.getId());
                    log.setType("integral_order");
                    log.setDeletestatus(false);
                    this.integralLogService.save(log);
                    request.getSession(false).removeAttribute("integral_goods_cart");
                } else {
                    mv = new JModelAndView("error.html",
                            this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1,
                            request, response);
                    mv.addObject("op_title", "兑换购物车为空");
                    mv.addObject("url", CommUtil.getURL(request) +
                            "/integral.htm");
                }
            } else {
                mv = new JModelAndView("error.html",
                        this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request,
                        response);
                mv.addObject("op_title", "参数错误，订单提交失败");
                mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
            }
        }
        else
        {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启积分商城");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }

    @RequestMapping({"/integral_order_pay.htm"})
    public ModelAndView integral_order_pay(HttpServletRequest request, HttpServletResponse response, String payType, String integral_order_id) {
        ModelAndView mv = null;
        ShoppingIntegralGoodsorderWithBLOBs order = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(integral_order_id));
        if (order.getIgoStatus() == 0) {
            if (CommUtil.null2String(payType).equals("")) {
                mv = new JModelAndView("error.html",
                        this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request,
                        response);
                mv.addObject("op_title", "支付方式错误！");
                mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
            }
            else {
                order.setIgoPayment(payType);
                this.integralGoodsOrderService.update(order);
                if (payType.equals("balance")) {
                    mv = new JModelAndView("integral_balance_pay.html",
                            this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1, request,
                            response);
                } else if (payType.equals("outline")) {
                    mv = new JModelAndView("integral_outline_pay.html",
                            this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1, request, response);
                    String integral_pay_session = CommUtil.randomString(32);
                    request.getSession(false).setAttribute(
                            "integral_pay_session", integral_pay_session);
                    mv.addObject("paymentTools", this.paymentTools);
                    mv.addObject("integral_pay_session", integral_pay_session);
                } else {
                    mv = new JModelAndView("line_pay.html",
                            this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1, request,
                            response);
                    mv.addObject("payType", payType);
                    mv.addObject("url", CommUtil.getURL(request));
                    mv.addObject("payTools", this.payTools);
                    mv.addObject("type", "integral");
                    Map params = new HashMap();
                    params.put("install", Boolean.valueOf(true));
                    params.put("mark", payType);
                    params.put("type", "admin");
                    List payments = this.paymentService.queryByCondition(params);
                            //.query("select obj from Payment obj where obj.install=:install and obj.mark=:mark and obj.type=:type", params, -1, -1);
                    mv.addObject("payment_id", payments.size() > 0 ?
                            ((ShoppingPaymentWithBLOBs)payments
                                    .get(0)).getId() : new ShoppingPaymentWithBLOBs());
                }
                mv.addObject("integral_order_id", integral_order_id);
            }
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "该订单不能进行付款！");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }

    @RequestMapping({"/integral_order_pay_outline.htm"})
    public ModelAndView integral_order_pay_outline(HttpServletRequest request, HttpServletResponse response, String payType, String integral_order_id, String igo_pay_msg, String integral_pay_session)
    {
        ModelAndView mv = new JModelAndView("success.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        String integral_pay_session1 = CommUtil.null2String(request.getSession(
                false).getAttribute("integral_pay_session"));
        if (integral_pay_session1.equals(integral_pay_session)) {
            ShoppingIntegralGoodsorderWithBLOBs order = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(integral_order_id));
            order.setIgoPayMsg(igo_pay_msg);
            order.setIgoPayment("outline");
            order.setIgoPayTime(new Date());
            order.setIgoStatus(10);
            this.integralGoodsOrderService.update(order);
            request.getSession(false).removeAttribute("pay_session");
            mv.addObject("op_title", "线下支付提交成功，等待审核！");
            mv.addObject("url", CommUtil.getURL(request) +
                    "/buyer/integral_order.htm");
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "订单已经支付，禁止重复支付！");
            mv.addObject("url", CommUtil.getURL(request) +
                    "/buyer/integral_order.htm");
        }
        return mv;
    }

    @RequestMapping({"/integral_order_pay_balance.htm"})
    public ModelAndView integral_order_pay_balance(HttpServletRequest request, HttpServletResponse response, String payType, String integral_order_id, String igo_pay_msg) {
        ModelAndView mv = new JModelAndView("success.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingIntegralGoodsorderWithBLOBs order = this.integralGoodsOrderService
                .getObjById(CommUtil.null2Long(integral_order_id));
        ShoppingUser user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());

        if (CommUtil.null2Double(user.getAvailablebalance()) >
                CommUtil.null2Double(order.getIgoTransFee())) {
            order.setIgoPayMsg(igo_pay_msg);
            order.setIgoStatus(20);
            order.setIgoPayment("balance");
            order.setIgoPayTime(new Date());
            boolean ret = this.integralGoodsOrderService.update(order);
            if (ret) {
                user.setAvailablebalance(BigDecimal.valueOf(CommUtil.subtract(user.getAvailablebalance(), order.getIgoTransFee())));
                this.userService.update(user);

                for (ShoppingIntegralGoodscart igc : order.getIgo_gcs()) {
                    ShoppingIntegralGoods goods = igc.getGoods();
                    goods.setIgGoodsCount(goods.getIgGoodsCount() - igc.getCount());
                    goods.setIgExchangeCount(goods.getIgExchangeCount() +
                            igc.getCount());
                    this.integralGoodsService.update(goods);
                }
            }
            mv.addObject("op_title", "预付款支付成功！");
            mv.addObject("url", CommUtil.getURL(request) +
                    "/buyer/integral_order_list.htm");
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "可用余额不足，支付失败！");
            mv.addObject("url", CommUtil.getURL(request) +
                    "/buyer/integral_order.htm");
        }

        return mv;
    }

    @RequestMapping({"/integral_order_finish.htm"})
    public ModelAndView integral_order_finish(HttpServletRequest request, HttpServletResponse response, String order_id) {
        ModelAndView mv = new JModelAndView("integral_order_finish.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingIntegralGoodsorderWithBLOBs obj = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(order_id));
        mv.addObject("obj", obj);
        return mv;
    }

    @RequestMapping({"/integral_order_pay_view.htm"})
    public ModelAndView integral_order_pay_view(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView("integral_exchange4.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingIntegralGoodsorderWithBLOBs obj = this.integralGoodsOrderService
                .getObjById(CommUtil.null2Long(id));
        if (obj.getIgoStatus() == 0) {
            mv.addObject("obj", obj);
            mv.addObject("paymentTools", this.paymentTools);
            mv.addObject("url", CommUtil.getURL(request));
        } else if (obj.getIgoStatus() < 0) {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "该订单已经取消！");
            mv.addObject("url", CommUtil.getURL(request) +
                    "/buyer/integral_order_list.htm");
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "该订单已经付款！");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm");
        }
        return mv;
    }
}
