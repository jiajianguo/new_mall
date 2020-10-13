package com.xdj.interfaces.mallinterface.controller.buyer;

import com.google.gson.Gson;
import com.xdj.interfaces.mallinterface.controller.view.*;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 *
 */

@RestController
public class OrderController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IOrderFormService orderFormService;
    @Resource
    private IOrderFormLogService orderFormLogService;
    @Resource
    private IUserService userService;
    @Resource
    private IPaymentService paymentService;
    @Resource
    private IPredepositLogService predepositLogService;
    @Resource
    private StoreViewTools storeViewTools;
    @Resource
    private PaymentViewTools paymentViewTools;
    @Resource
    private IExpressCompanyService expressCompanyService;
    @Resource
    private GoodsCartTools goodsCartTools;
    @Resource
    private AreaViewTools areaViewTools;
    @Resource
    private IAddressService addressService;
    @Resource
    private OrderViewTools orderViewTools;
    @Resource
    private RefundViewTools refundViewTools;
    @Resource
    private IGoodsCartService goodsCartService;

    @SecurityMapping(display = false, rsequence = 0, title="删除订单信息", value="/buyer/order_delete.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/order_delete.htm"})
    public void order_delete(HttpServletRequest request, HttpServletResponse response, String id, String currentPage) throws Exception {
        ShoppingOrderformWithBLOBs obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
        if ((obj.getUserId().equals(SecurityUserHolder.getCurrentUser().getId())) && (obj.getOrderStatus() == 0)) {
            orderViewTools.addGCs(obj);
            for (ShoppingGoodscart gc : obj.getGcs()) {
                gc.setDeletestatus(true);
                this.goodsCartService.delete(gc.getId());
            }
            obj.setDeletestatus(true);
            this.orderFormLogService.deleteByOfid(obj.getId());
            this.orderFormService.delete(obj.getId());
        }
        response.sendRedirect("redirect:/order.htm?currentPage=" + currentPage);
    }


    @SecurityMapping(display = false, rsequence = 0, title="买家订单详情", value="/buyer/order_view.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/order_view.htm"})
    public ModelAndView order_view(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView("buyer/order_view.html",
                this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 0, request, response);
        String shopping_view_type = CommUtil.null2String( request.getSession( false ).getAttribute( "shopping_view_type" ) );
        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/my_order_detail.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        }
        ShoppingOrderformWithBLOBs obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
        if (obj.getUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
            storeViewTools.addOrderStore(obj,true);
            goodsCartTools.addOrderGcs(obj);
            ShoppingAddress addr = addressService.getObjById(obj.getAddrId());
            areaViewTools.addAddrArea(addr,true);
            obj.setAddr(addr);
            orderViewTools.addOrderLogs(obj,true);
            refundViewTools.addOrderRefund(obj);
            refundViewTools.addOrderGrls(obj);
            mv.addObject("obj", obj);
            TransInfo transInfo = query_ship_getData(CommUtil.null2String(obj.getId()));
            mv.addObject("transInfo", transInfo);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "您没有编号为" + id + "的订单！");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
        }
        return mv;
    }

    private TransInfo query_ship_getData(String id) {
        TransInfo info = new TransInfo();
        ShoppingOrderformWithBLOBs obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
        try {
            ShoppingExpressCompany company = expressCompanyService.getObjById(obj.getEcId());
            String query_url = "http://api.kuaidi100.com/api?id=" +this.configService.getSysConfig().getKuaidiId() +
                    "&com=" + ( company != null ? company.getCompanyMark() : "") + "&nu=" + obj.getShipcode() + "&show=0&muti=1&order=asc";
            URL url = new URL(query_url);
            URLConnection con = url.openConnection();
            con.setAllowUserInteraction(false);
            InputStream urlStream = url.openStream();
            String type = URLConnection.guessContentTypeFromStream(urlStream);
            String charSet = null;
            if( type == null ){
                type = con.getContentType();
            }
            if ((type == null) || (type.trim().length() == 0) || (type.trim().indexOf("text/html") < 0)){
                return info;
            }
            if (type.indexOf("charset=") > 0){
                charSet = type.substring(type.indexOf("charset=") + 8);
            }
            byte[] b = new byte[10000];
            int numRead = urlStream.read(b);
            String content = new String(b, 0, numRead, charSet);
            while (numRead != -1) {
                numRead = urlStream.read(b);
                if (numRead == -1){
                    continue;
                }
                String newContent = new String(b, 0, numRead, charSet);
                content = content + newContent;
            }

            info = new Gson().fromJson( content,TransInfo.class);
            urlStream.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    /**
     * 买家订单页面
     * @param request
     * @param response
     * @param currentPage
     * @param order_id
     * @param beginTime
     * @param endTime
     * @param order_status
     * @return
     */
    @SecurityMapping(display = false, rsequence = 0, title="买家订单列表", value="/buyer/order.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/order.htm"})
    public final  ModelAndView order(HttpServletRequest request, HttpServletResponse response, String currentPage, String order_id, String beginTime, String endTime, String order_status) {
        ModelAndView mv = new JModelAndView("buyer/buyer_order.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 0, request, response);
        String shopping_view_type = CommUtil.null2String( request.getSession( false ).getAttribute( "shopping_view_type" ) );
        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
                    mv = new JModelAndView("wap/my_order.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        }
        Map<String,Object> params = new HashMap<>();
        params.put("orderBy","addTime");
        params.put("sort","desc");
        params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
        int pageNow =1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow =Integer.parseInt(currentPage);
        }
        params.put("start",(pageNow -1)*8);
        params.put("pageSize",8);
        params.put("deleteStatus",0);
        if (!CommUtil.null2String(order_id).equals("")) {
            params.put("order_id","%" + order_id + "%");
            mv.addObject("order_id", order_id);
        }
        if (!CommUtil.null2String(beginTime).equals("")) {
            params.put("beginTime", CommUtil.formatDate(beginTime));
            mv.addObject("beginTime", beginTime);
        }
        if (!CommUtil.null2String(beginTime).equals("")) {
            params.put("endTime", CommUtil.formatDate(endTime));
            /*ofqo.addQuery("obj.addTime",
                    new SysMap("endTime", CommUtil.formatDate(endTime)), "<=");*/
            mv.addObject("endTime", endTime);
        }
        if (!CommUtil.null2String(order_status).equals("")) {
            if (order_status.equals("order_submit")) {
                params.put("order_status",10);//待付款
            }
            if (order_status.equals("order_pay")) {
                params.put("order_status",20);//待发货
            }
            if (order_status.equals("order_shipping")) {
                params.put("order_status",30);//待收货
            }
            if (order_status.equals("order_receive")) {
                params.put("order_status",40);//已收货
            }
            if (order_status.equals("order_finish")) {
                params.put("order_status",60);//已结束
            }
            if (order_status.equals("order_cancel")) {
                params.put("order_status",0);//已取消
            }
        }
        mv.addObject("order_status", order_status);
        List<ShoppingOrderformWithBLOBs> pList = this.orderFormService.pageList(params);

        if(pList != null){
            for (ShoppingOrderformWithBLOBs orderform : pList) {
                goodsCartTools.addOrderGcs(orderform);
            }
            int count  = this.orderFormService.count(params);
            PageModel page = new PageModel();
            paymentViewTools.addOrderPays(pList,true);
            storeViewTools.addOrderStores(pList,true);
            page.setResult(pList);
            page.setRowCount(count);
            if(count%10==0){
                page.setPages(count/10);
            }else{
                page.setPages(count/10+1);
            }
            page.setCurrentPage(pageNow);
            page.setPageSize(8);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        return mv;
    }

    /**
     * 取消订单
     * @param request
     * @param response
     * @param id
     * @param currentPage
     * @return
     */
    @SecurityMapping(display = false, rsequence = 0, title="订单取消", value="/buyer/order_cancel.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/order_cancel.htm"})
    public final ModelAndView order_cancel(HttpServletRequest request, HttpServletResponse response, String id, String currentPage) {
        ModelAndView mv = new JModelAndView("buyer/buyer_order_cancel.html",
                this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);

        String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );

        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/buyer_order_cancel.html",
                    this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        }
        ShoppingOrderformWithBLOBs obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
        if (obj.getUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
            mv.addObject("obj", obj);
            mv.addObject("currentPage", currentPage);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
            mv.addObject("op_title", "您没有编号为" + id + "的订单！");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
        }
        return mv;
    }


    /**
     * 订单取消确认
     * @param request
     * @param response
     * @param id
     * @param currentPage
     * @param state_info
     * @param other_state_info
     * @return
     * @throws Exception
     */
    @SecurityMapping(display = false, rsequence = 0, title="订单取消确认", value="/buyer/order_cancel_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/order_cancel_save.htm"})
    public final  void order_cancel_save(HttpServletRequest request, HttpServletResponse response, String id, String currentPage, String state_info, String other_state_info) throws Exception {
        ShoppingOrderformWithBLOBs obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
        if (obj.getUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
            obj.setOrderStatus(0);
            this.orderFormService.update(obj);
            ShoppingOrderLog ofl = new ShoppingOrderLog();
            ofl.setAddtime(new Date());
            ofl.setLogInfo("取消订单");
            ofl.setLogUserId(SecurityUserHolder.getCurrentUser().getId());
            ofl.setOfId(obj.getId());
            ofl.setDeletestatus(false);
            if (state_info.equals("other")) {
                ofl.setStateInfo(other_state_info);
            }else {
                ofl.setStateInfo(state_info);
            }
            this.orderFormLogService.save(ofl);
            if (this.configService.getSysConfig().getEmailenable()) {
                //send_email(request, obj, "email_toseller_order_cancel_notify");
            }
            if (this.configService.getSysConfig().getSmsenbale()) {
                //send_sms(request, obj, obj.getStore().getUser().getMobile(), "sms_toseller_order_cancel_notify");
            }
        }
        response.sendRedirect("/buyer/order.htm?currentPage="+currentPage);
        //return "redirect:order.htm?currentPage=" + currentPage;
    }


    @SecurityMapping(display = false, rsequence = 0, title="收货确认", value="/buyer/order_cofirm.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/order_cofirm.htm"})
    public ModelAndView order_cofirm(HttpServletRequest request, HttpServletResponse response, String id, String currentPage){
        ModelAndView mv = new JModelAndView("buyer/buyer_order_cofirm.html",
                this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingOrderformWithBLOBs obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
        if (obj.getUser().getId().equals(SecurityUserHolder.getCurrentUser().getId())) {
            mv.addObject("obj", obj);
            mv.addObject("currentPage", currentPage);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
            mv.addObject("op_title", "您没有编号为" + id + "的订单！");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
        }
        return mv;
    }


    /**
     * 买家确认收货
     * @param request
     * @param response
     * @param id
     * @param currentPage
     * @return
     * @throws Exception
     */
    @SecurityMapping(display = false, rsequence = 0, title="收货确认保存", value="/buyer/order_cofirm_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/order_cofirm_save.htm"})
    public void order_cofirm_save(HttpServletRequest request, HttpServletResponse response, String id, String currentPage) throws Exception {
        ShoppingOrderformWithBLOBs obj = this.orderFormService.getObjById(CommUtil.null2Long(id));
        if (obj.getUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
            obj.setOrderStatus(40);
            boolean ret = this.orderFormService.update(obj);
            if (ret) {
                ShoppingOrderLog ofl = new ShoppingOrderLog();
                ofl.setAddtime(new Date());
                ofl.setLogInfo("确认收货");
                ofl.setLogUserId(SecurityUserHolder.getCurrentUser().getId());
                ofl.setOfId(obj.getId());
                this.orderFormLogService.save(ofl);
                if (this.configService.getSysConfig().getEmailenable()) {
                    //send_email(request, obj, "email_toseller_order_receive_ok_notify");
                }
                if (this.configService.getSysConfig().getSmsenbale()) {
                    //send_sms(request, obj, obj.getStore().getUser().getMobile(), "sms_toseller_order_receive_ok_notify");
                }
                if (obj.getPayment().getMark().equals("balance")) {
                    ShoppingUser seller = this.userService.getObjById(obj.getStore().getUser().getId());
                    if (this.configService.getSysConfig().getBalanceFenrun() == 1)
                    {
                        Map params = new HashMap();
                        params.put("type", "admin");
                        params.put("mark", "balance");
                        List<ShoppingPayment> payments = this.paymentService.queryByCondition(params);

                                //.query("select obj from Payment obj where obj.type=:type and obj.mark=:mark", params, -1, -1);
                        ShoppingPayment shop_payment = new ShoppingPayment();
                        if (payments.size() > 0) {
                            shop_payment = payments.get(0);
                        }

                        double shop_availableBalance = CommUtil.null2Double(obj.getTotalprice()) * CommUtil.null2Double(shop_payment.getBalanceDivideRate());
                        Map<String,Object> maps = new HashMap<>();
                        maps.put("userName","admin");
                        ShoppingUser admin = this.userService.getOne(maps);
                        admin.setAvailablebalance(BigDecimal.valueOf(CommUtil.add(admin.getAvailablebalance(), Double.valueOf(shop_availableBalance))));
                        this.userService.update(admin);
                        ShoppingPredepositLog log = new ShoppingPredepositLog();
                        log.setAddtime(new Date());
                        log.setPdLogUserId(seller.getId());
                        log.setPdOpType("分润");
                        log.setPdLogAmount(BigDecimal.valueOf(shop_availableBalance));
                        log.setPdLogInfo("订单" + obj.getOrderId() + "确认收货平台分润获得预存款");
                        log.setPdType("可用预存款");
                        this.predepositLogService.save(log);

                        double seller_availableBalance = CommUtil.null2Double(obj.getTotalprice()) - shop_availableBalance;
                        seller.setAvailablebalance(BigDecimal.valueOf(CommUtil.add(seller.getAvailablebalance(), Double.valueOf(seller_availableBalance))));
                        this.userService.update(seller);
                        ShoppingPredepositLog log1 = new ShoppingPredepositLog();
                        log1.setAddtime(new Date());
                        log1.setPdLogUserId(seller.getId());
                        log1.setPdOpType("增加");
                        log1.setPdLogAmount(BigDecimal.valueOf(seller_availableBalance));
                        log1.setPdLogInfo("订单" + obj.getOrderId() + "确认收货增加预存款");
                        log1.setPdType("可用预存款");
                        this.predepositLogService.save(log1);
                        ShoppingUser buyer = obj.getUser();
                        buyer.setFreezeblance(BigDecimal.valueOf(CommUtil.subtract(buyer.getFreezeblance(), obj.getTotalprice())));
                        this.userService.update(buyer);
                    }
                    else {
                        seller.setAvailablebalance(BigDecimal.valueOf(CommUtil.add(seller.getAvailablebalance(), obj.getTotalprice())));
                        this.userService.update(seller);
                        ShoppingPredepositLog log = new ShoppingPredepositLog();
                        log.setAddtime(new Date());
                        log.setPdLogUserId(seller.getId());
                        log.setPdOpType("增加");
                        log.setPdLogAmount(obj.getTotalprice());
                        log.setPdLogInfo("订单" + obj.getOrderId() + "确认收货增加预存款");
                        log.setPdType("可用预存款");
                        this.predepositLogService.save(log);

                        ShoppingUser buyer = obj.getUser();
                        buyer.setFreezeblance(BigDecimal.valueOf(CommUtil.subtract(buyer.getFreezeblance(), obj.getTotalprice())));
                        this.userService.update(buyer);
                    }
                }
            }
        }
        response.sendRedirect("order.htm?currentPage=" + currentPage);
    }
}
