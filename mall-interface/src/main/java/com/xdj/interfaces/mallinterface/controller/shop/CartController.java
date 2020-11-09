package com.xdj.interfaces.mallinterface.controller.shop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xdj.interfaces.mallinterface.controller.view.*;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.pay.tools.PaymentTools;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.constant.ResponseModel;
import com.xdj.www.core.tools.CommUtil;
import com.xdj.www.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @author Administrator
 */

@RestController
public class CartController {
    @Resource
    private IStoreCartService storeCartService;
    @Resource
    private IGoodsCartService goodsCartService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private IGoodsSpecPropertyService goodsSpecPropertyService;
    @Resource
    private IGoodsSpecificationService goodsSpecificationService;
    @Resource
    private IStoreService storeService;
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private ICouponInfoService couponInfoService;
    @Resource
    private IAddressService addressService;
    @Resource
    private IAreaService areaService;
    @Resource
    private GoodsCartTools goodsCartTools;
    @Resource
    private StoreViewTools storeViewTools;
    @Resource
    private TransportTools transportTools;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private IOrderFormService orderFormService;
    @Resource
    private IOrderFormLogService orderFormLogService;
    @Resource
    private ICouponService couponService;
    @Resource
    private PaymentTools paymentTools;
    @Resource
    private ViewTools viewTools;
    @Resource
    private IPaymentService paymentService;
    @Resource
    private GoodsSpecPropertyTools goodsSpecPropertyTools;
    @Resource
    private ISeckillService seckillService;
    @Resource
    private AccessoryViewTools accessoryViewTools;
    @Resource
    private PayViewTools payViewTools;
    @Resource
    private SendMessageService sendMessageService;

    private Logger log = LoggerFactory.getLogger("cart");

    @SecurityMapping(display = false, rsequence = 0, title = "订单支付结果", value = "/order_finish.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
    @RequestMapping({"/order_finish.htm"})
    public ModelAndView order_finish(HttpServletRequest request, HttpServletResponse response, String order_id) {
        ModelAndView mv = new JModelAndView("order_finish.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingOrderformWithBLOBs obj = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
        mv.addObject("obj", obj);
        viewTools.topHandle(mv, request);
        viewTools.headHandle(mv, request);
        viewTools.nav1Handle(mv);
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title = "订单支付详情", value = "/order_pay_view.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
    @RequestMapping({"/order_pay_view.htm"})
    public ModelAndView order_pay_view(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView("/order_pay.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingOrderform of = this.orderFormService.getObjById(CommUtil.null2Long(id));
        if (of.getOrderStatus() == 10) {
            mv.addObject("of", of);
            //mv.addObject("paymentTools", this.paymentTools);
            mv.addObject("url", CommUtil.getURL(request));
        } else if (of.getOrderStatus() < 10) {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
            mv.addObject("op_title", "该订单已经取消！");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
            mv.addObject("op_title", "该订单已经付款！");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        paymentTools.returnData("alipay", mv);
        paymentTools.returnData("paypal", mv);
        paymentTools.returnData("tenpay", mv);
        paymentTools.returnData("wxcodepay", mv);
        paymentTools.returnData("chinabank", mv);
        paymentTools.returnData("bill", mv);
        paymentTools.returnData("outline", mv);
        paymentTools.returnData("payafter", mv);
        paymentTools.returnData("balance", mv);
        paymentTools.returnStoreData("alipay", of.getStoreId(), mv);
        paymentTools.returnStoreData("paypal", of.getStoreId(), mv);
        paymentTools.returnStoreData("tenpay", of.getStoreId(), mv);
        paymentTools.returnStoreData("wxcodepay", of.getStoreId(), mv);
        paymentTools.returnStoreData("chinabank", of.getStoreId(), mv);
        paymentTools.returnStoreData("outline", of.getStoreId(), mv);
        paymentTools.returnStoreData("payafter", of.getStoreId(), mv);
        paymentTools.returnStoreData("balance", of.getStoreId(), mv);
        viewTools.topHandle(mv, request);
        viewTools.headHandle(mv, request);
        viewTools.footerHandle(mv);
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title = "订单支付", value = "/order_pay.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
    @RequestMapping({"/order_pay.htm"})
    public ModelAndView order_pay(HttpServletRequest request, HttpServletResponse response, String payType, String order_id) throws UnsupportedEncodingException {
        ModelAndView mv = null;
        List<ShoppingOrderformWithBLOBs> ofs= orderFormService.selectByOrderNo(order_id);
        if(ofs != null){
            if (ofs.get(0).getOrderStatus() == 10) {
                if (CommUtil.null2String(payType).equals("")) {
                    mv = new JModelAndView("error.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
                    mv.addObject("op_title", "支付方式错误！");
                    mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
                } else {
                    List<ShoppingPaymentWithBLOBs> payments = new ArrayList();
                    Map<String,Object> params = new HashMap();
                    //判断是否平台支付
                    if (this.configService.getSysConfig().getConfigPaymentType() == 1) {
                        params.put("mark", payType);
                        params.put("type", "admin");
                        payments = this.paymentService.queryByCondition(params);
                    } else {
                        params.put("mark", payType);
                        params.put("store_id", ofs.get(0).getStoreId());
                        payments = this.paymentService.queryByCondition(params);
                    }
                   for(ShoppingOrderformWithBLOBs o: ofs){
                       o.setPaymentId(payments.get(0).getId());
                       this.orderFormService.update(o);
                   }

                    if (payType.equals("balance")) {
                        mv = new JModelAndView("balance_pay.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
                    } else if (payType.equals("outline")) {
                        mv = new JModelAndView("outline_pay.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
                        String pay_session = CommUtil.randomString(32);
                        request.getSession(false).setAttribute("pay_session", pay_session);
                        //mv.addObject("paymentTools", this.paymentTools);
                        mv.addObject("store_id", this.orderFormService.getObjById(CommUtil.null2Long(order_id)).getStoreId());
                        mv.addObject("pay_session", pay_session);
                    } else if (payType.equals("payafter")) {
                        mv = new JModelAndView("payafter_pay.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
                        String pay_session = CommUtil.randomString(32);
                        request.getSession(false).setAttribute("pay_session", pay_session);
                        mv.addObject("store_id", this.orderFormService.getObjById(CommUtil.null2Long(order_id)).getStoreId());
                        mv.addObject("pay_session", pay_session);
                    } else {
                        mv = new JModelAndView("line_pay.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
                        mv.addObject("payType", payType);
                        mv.addObject("url", CommUtil.getURL(request));
                        mv.addObject("type", "goods");
                        mv.addObject("payment_id", ofs.get(0).getPaymentId());
                    }
                    mv.addObject("order_id", order_id);
                }
            } else {
                mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request, response);
                mv.addObject("op_title", "该订单不能进行付款！");
                mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
            }
        }else{
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
            mv.addObject("op_title", "该订单不能进行付款！");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
       /* ShoppingOrderformWithBLOBs of = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
        */

        return mv;
    }


    @RequestMapping({"/addSeckillCart.htm"})
    public final void addSeckillCart(HttpServletRequest request, HttpServletResponse response, String id, String count, String price, String gsp, String buy_type) {
        String cart_session_id = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart_session_id")) {
                    cart_session_id = CommUtil.null2String(cookie.getValue());
                }
            }
        }

        if (cart_session_id.equals("")) {
            cart_session_id = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("cart_session_id", cart_session_id);
            cookie.setDomain(CommUtil.generic_domain(request));
            response.addCookie(cookie);
        }
        List<ShoppingStorecart> user_cart = new ArrayList<ShoppingStorecart>();
        List<ShoppingStorecart> cookie_cart = new ArrayList<ShoppingStorecart>();
        ShoppingUser user = SecurityUserHolder.getCurrentUser();
        Map params = new HashMap();
        ShoppingStorecart sc;
        //用户不为null
        if (user != null) {
            //通过cartsession 和 storeid获取信息
            if (!cart_session_id.equals("")) {
                if (user.getStoreId() != null) {
                    params.clear();
                    //params.put("cart_session_id", cart_session_id);
                    params.put("user_id", user.getId());
                    params.put("sc_status", Integer.valueOf(0));
                    params.put("store_id", user.getStoreId());
                    List<ShoppingStorecart> store_cookie_cart = this.storeCartService.queryByCondition(params);
                    for (ShoppingStorecart s : store_cookie_cart) {
                        goodsCartTools.addGcs(s);
                        if (s.getGcs() != null) {
                            for (ShoppingGoodscart gc : s.getGcs()) {
                                this.goodsCartService.delete(gc.getId());
                            }
                        }
                        this.storeCartService.delete(s.getId());
                    }
                }
                params.clear();
                params.put("cart_session_id", cart_session_id);
                params.put("sc_status", Integer.valueOf(0));
                cookie_cart = this.storeCartService.queryByCondition(params);
                params.clear();
                params.put("user_id", user.getId());
                params.put("sc_status", Integer.valueOf(0));
                user_cart = this.storeCartService.queryByCondition(params);
            } else {
                params.clear();
                params.put("user_id", user.getId());
                params.put("sc_status", Integer.valueOf(0));
                user_cart = this.storeCartService.queryByCondition(params);
            }

        } else {
            if (!cart_session_id.equals("")) {
                params.clear();
                params.put("cart_session_id", cart_session_id);
                params.put("sc_status", Integer.valueOf(0));
                cookie_cart = this.storeCartService.queryByCondition(params);
            }
        }
        Map<Long, ShoppingStorecart> datas = new HashMap<>();
        for (ShoppingStorecart sc12 : user_cart) {
            if (datas.containsKey(sc12.getId())) {
                datas.put(sc12.getId(), sc12);
            }

        }
        for (ShoppingStorecart sc11 : cookie_cart) {
            if (!datas.containsKey(sc11.getId())) {
                datas.put(sc11.getId(), sc11);
            }
        }
        String[] gsp_ids = gsp.split(",");
        Arrays.sort(gsp_ids);
        boolean add = true;
        BigDecimal total_price = new BigDecimal("0.00");
        int total_count = 0;
        if (StringUtils.isNotBlank(count)) {
            total_count = Integer.parseInt(count);
        }
        String[] gsp_ids1;
        for (Map.Entry<Long, ShoppingStorecart> entry : datas.entrySet()) {
            params.clear();
            params.put("sc_id", entry.getKey());
            List<ShoppingGoodscart> carts = goodsCartService.queryByCondition(params);
            for (ShoppingGoodscart gc : carts) {
                goodsSpecPropertyTools.addGsps(gc);
                if (gsp_ids != null && gsp_ids.length > 0 && gc.getGsps() != null && gc.getGsps().size() > 0) {
                    gsp_ids1 = new String[gc.getGsps().size()];
                    for (int i = 0; i < gc.getGsps().size(); i++) {
                        gsp_ids1[i] = gc.getGsps().get(i) != null ? gc.getGsps().get(i).getId().toString() : "";
                    }
                    Arrays.sort(gsp_ids1);
                    if ((!gc.getGoodsId().toString().equals(id)) || (!Arrays.equals(gsp_ids, gsp_ids1))) {
                        continue;
                    }
                    add = false;
                } else if (gc.getGoodsId().toString().equals(id)) {
                    add = false;
                }
            }
        }
        ShoppingGoodscart obj;
        ShoppingSecondsKill sec = seckillService.getObjById(CommUtil.null2Long(id));
        if (add) {
            ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(sec.getSgGoodsId());
            String type = "save";
            ShoppingStorecart sc33 = new ShoppingStorecart();
            for (Map.Entry<Long, ShoppingStorecart> entry : datas.entrySet()) {
                if (goods.getGoodsStoreId().equals(entry.getValue().getStoreId())) {
                    sc33 = entry.getValue();
                    type = "update";
                    break;
                }
            }
            if (type.equals("save")) {
                sc33.setStoreId(goods.getGoodsStoreId());
                sc33.setUserId(user.getId());
                sc33.setTotalPrice(sec.getSecondsPrice());
                sc33.setAddtime(new Date());
                sc33.setDeletestatus(false);
                this.storeCartService.save(sc33);
                // 修改秒杀数量--->
                if (sec.getCount() == 1) {
                    sec.setSgStatus(2);
                }
                sec.setCount(sec.getCount() - 1);
                sec.setSellCount(sec.getSellCount() + 1);
                seckillService.update(sec);
            } else {
                this.storeCartService.update(sc33);
            }
            obj = new ShoppingGoodscart();
            obj.setAddtime(new Date());
            obj.setCount(CommUtil.null2Int(count));
            obj.setPrice(sec.getSecondsPrice());
            obj.setCartType("secKill");
            String spec_info = "";
            ShoppingGoodsspecproperty spec_property;
            if (obj.getGsps() == null) {
                obj.setGsps(new ArrayList<>());
            }
            if (gsp_ids != null && !"".equals(gsp_ids)) {
                for (String gsp_id : gsp_ids) {
                    spec_property = this.goodsSpecPropertyService.getObjById(CommUtil.null2Long(gsp_id));
                    obj.getGsps().add(spec_property);
                    if (spec_property != null) {
                        spec_property.setSpec(goodsSpecificationService.getObjById(spec_property.getSpecId()));
                        spec_info = spec_property.getSpec().getName() + ":" + spec_property.getValue() + " " + spec_info;
                    }
                }
            }
            obj.setSpecInfo(spec_info);
            obj.setDeletestatus(false);
            obj.setCount(Integer.parseInt(count));
            obj.setGoodsId(goods.getId());
            obj.setScId(sc33.getId());
            this.goodsCartService.save(obj);
            params.clear();
            params.put("sc_id", sc33.getId());
            List<ShoppingGoodscart> carts = goodsCartService.queryByCondition(params);
            if (carts != null) {
                sc33.setGcs(carts);
            } else {
                sc33.getGcs().add(obj);
            }
            for (ShoppingGoodscart gc1 : sc33.getGcs()) {
                if (CommUtil.null2String(gc1.getCartType()).equals("")) {
                    total_price = (gc1.getPrice().multiply(new BigDecimal(gc1.getCount() + ""))).add(total_price);
                }
                if (!CommUtil.null2String(gc1.getCartType()).equals("combin")) {
                    ShoppingGoodsWithBLOBs good = goodsService.getObjById(gc1.getGoodsId());
                    if (good != null && good.getCombinPrice() != null) {
                        total_price = good.getCombinPrice().multiply(new BigDecimal(gc1.getCount() + "")).add(total_price);
                    }
                }
            }
            sc33.setTotalPrice(total_price);
            if (user == null) {
                sc33.setCartSessionId(cart_session_id);
            } else {
                sc33.setUserId(user.getId());
            }
            if (!type.equals("save")) {
                this.storeCartService.update(sc33);
            }
        }
        JSONObject map = new JSONObject();
        map.put("count", Integer.valueOf(total_count));
        map.put("total_price", total_price);
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(map.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param id 商品id
     * @param count 数量
     * @param price 价格
     * @param gsp 商品属性id数组
     * @param buy_type 购买类型
     * @return  返回你添加成功或失败
     */
    @RequestMapping({"/addGoodsCart"})
    @ResponseBody
    public  ResponseModel  addGoodsCart(String id, String count, String price, String gsp, String buy_type){
        ResponseModel res = new ResponseModel();
        res.setCode("400");
        ShoppingUser user = SecurityUserHolder.getCurrentUser();
        if(user != null){
            BigDecimal addPrice =new BigDecimal(price);
            BigDecimal amount = addPrice.multiply(new BigDecimal(count));
            ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(CommUtil.null2Long(id));
            if( goods != null){
                if( !goods.getGoodsStoreId().equals(user.getStoreId())){
                    ShoppingStorecart sc = new ShoppingStorecart();
                    sc.setAddtime(new Date());
                    sc.setUserId(user.getId());
                    sc.setStoreId(goods.getGoodsStoreId());
                    sc.setScStatus(0);
                    sc.setTotalPrice(amount);
                    sc.setDeletestatus(false);
                    //添加店铺购物车
                    this.storeCartService.save(sc);
                    //获取商品属性
                    String[] gsp_ids = gsp.split(",");
                    Arrays.sort(gsp_ids);
                    ShoppingGoodsspecproperty spec_property;
                    String spec_info ="";
                    if (gsp_ids != null && gsp_ids.length>0) {
                        for (String gsp_id : gsp_ids) {
                            spec_property = this.goodsSpecPropertyService.getObjById(CommUtil.null2Long(gsp_id));
                            if (spec_property != null) {
                                spec_property.setSpec(goodsSpecificationService.getObjById(spec_property.getSpecId()));
                                spec_info = spec_property.getSpec().getName() + ":" + spec_property.getValue() + " " + spec_info;
                            }
                        }
                    }

                    ShoppingGoodscart cart = new ShoppingGoodscart();
                    cart.setDeletestatus(false);
                    cart.setScId(sc.getId());
                    cart.setPrice(addPrice);
                    cart.setAddtime(new Date());
                    if (CommUtil.null2String(buy_type).equals("")) {
                        cart.setCount(CommUtil.null2Int(count));
                        cart.setPrice(addPrice);
                    }
                    if (CommUtil.null2String(buy_type).equals("combin")) {
                        cart.setCount(1);
                        cart.setCartType("combin");
                        cart.setPrice(goods.getCombinPrice());
                    }
                    cart.setCartType(buy_type);
                    cart.setSpecInfo(spec_info);
                    cart.setCount(Integer.parseInt(count));
                    cart.setGoodsId(goods.getId());
                    goodsCartService.save(cart);
                    res.setCode("200");
                    res.setMsg("successs");
                    res.setData(count);
                    return res;
                }else{
                    res.setMsg("不能购买自己的商品");
                }
            }else{
                res.setMsg("参数id有误");
            }
        }else{
            res.setMsg("用户没有登录");
        }
        return res;
    }

    /**
     *
     * @param id 购物车id
     * @param ids 购物车中的商品属性id
     * @return 返回更改后的购物车信息
     *
     */
    @RequestMapping({"/eidtGoodscart"})
    @ResponseBody
    public ResponseModel eidtGoodscart(String id,String ids){
        ResponseModel res =new  ResponseModel();
        res.setCode("400");
        if(StringUtils.isNotBlank(id) && StringUtils.isNotBlank(ids)){
            //获取
            ShoppingGoodscart cart = goodsCartService.getObjById(CommUtil.null2Long(id));
            if(cart == null){
                res.setMsg("参数id无效，购物车不存在");
                return  res;
            }
            ShoppingGoodsWithBLOBs goods=goodsService.getObjById(cart.getGoodsId());
            BigDecimal price=cart.getPrice();
            if(goods.getGroupBuy() ==2 ){
                goodsViewTools.addgroupGoodsList(goods);
                for (ShoppingGroupGoods gg : goods.getGroup_goods_list()){
                    if (gg.getGroupId().equals(goods.getGroup().getId())) {
                        price = gg.getGgPrice();
                    }
                }
            }else {
               // if (goods.getInventoryType().equals("spec")) {
                String[] gsp_ids = ids.split(",");
                String spec_info = "";
                ShoppingGoodsspecproperty spec_property;
                if (gsp_ids != null && gsp_ids.length > 0) {
                    for (String gsp_id : gsp_ids) {
                        spec_property = this.goodsSpecPropertyService.getObjById(CommUtil.null2Long(gsp_id));
                        if (spec_property != null) {
                            spec_property.setSpec(goodsSpecificationService.getObjById(spec_property.getSpecId()));
                            spec_info = spec_property.getSpec().getName() + ":" + spec_property.getValue() + " " + spec_info;
                        }
                    }
                }
                JSONArray list = JSON.parseArray(goods.getGoodsInventoryDetail());
                if (list != null) {
                    for (int i = 0; i < list.size(); i++) {
                        JSONObject temp = list.getJSONObject(i);
                        String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
                        Arrays.sort(gsp_ids);
                        Arrays.sort(temp_ids);
                        if (Arrays.equals(gsp_ids, temp_ids)) {
                            price = CommUtil.null2BigDecimal(temp.get("price"));
                        }
                    }
                }
                cart.setSpecInfo(spec_info);
                if (cart.getPrice().compareTo(price) != 0) {
                    cart.setPrice(new BigDecimal(cart.getCount()).multiply(price));
                    ShoppingStorecart sc = storeCartService.getObjById(cart.getScId());
                    sc.setTotalPrice(cart.getPrice());
                }
                System.out.println("------"+spec_info);
                goodsCartService.update(cart);
                res.setCode("200");
                res.setMsg("success");
                res.setData(cart);
                return res;
            }
        }else{
            res.setMsg("部分参数有误");
        }
        return res;
    }

    /**
     * 添加购物车
     * @param request
     * @param response
     * @param id  商品id，
     * @param count 数量
     * @param price 价格
     * @param gsp   属性
     * @param buy_type  购买类型（团购 ->组合->秒杀->正常下单）
     */
    @ResponseBody
    @RequestMapping({"/add_goods_cart.htm"})
    public void add_goods_cart(HttpServletRequest request, HttpServletResponse response, String id, String count, String price, String gsp, String buy_type) {
        BigDecimal addPrice = BigDecimal.valueOf(CommUtil.null2Double(price.substring(1)));
        String cart_session_id = "";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart_session_id")) {
                    cart_session_id = CommUtil.null2String(cookie.getValue());
                }
            }
        }
        if (cart_session_id.equals("")) {
            cart_session_id = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("cart_session_id", cart_session_id);
            cookie.setDomain(CommUtil.generic_domain(request));
            response.addCookie(cookie);
        }
        List<ShoppingStorecart> user_cart = new ArrayList<ShoppingStorecart>();
        List<ShoppingStorecart> cookie_cart = new ArrayList<ShoppingStorecart>();
        ShoppingUser user = SecurityUserHolder.getCurrentUser();
        Map params = new HashMap();
        ShoppingStorecart sc;
        if (user != null) {
            if (!cart_session_id.equals("")) {
                if (user.getStoreId() != null) {
                    params.clear();
                    //params.put("cart_session_id", cart_session_id);
                    params.put("user_id", user.getId());
                    params.put("sc_status", Integer.valueOf(0));
                    params.put("store_id", user.getStoreId());
                    List<ShoppingStorecart> store_cookie_cart = this.storeCartService.queryByCondition(params);
                    for (ShoppingStorecart s : store_cookie_cart) {
                        goodsCartTools.addGcs(s);
                        if (s.getGcs() != null) {
                            for (ShoppingGoodscart gc : s.getGcs()) {
                                this.goodsCartService.delete(gc.getId());
                            }
                        }
                        this.storeCartService.delete(s.getId());
                    }
                }
                params.clear();
                params.put("cart_session_id", cart_session_id);
                params.put("sc_status", Integer.valueOf(0));
                cookie_cart = this.storeCartService.queryByCondition(params);
                params.clear();
                params.put("user_id", user.getId());
                params.put("sc_status", Integer.valueOf(0));
                user_cart = this.storeCartService.queryByCondition(params);
            } else {
                params.clear();
                params.put("user_id", user.getId());
                params.put("sc_status", Integer.valueOf(0));
                user_cart = this.storeCartService.queryByCondition(params);
            }

        } else {
            if (!cart_session_id.equals("")) {
                params.clear();
                params.put("cart_session_id", cart_session_id);
                params.put("sc_status", Integer.valueOf(0));
                cookie_cart = this.storeCartService.queryByCondition(params);
            }
        }
        Map<Long, ShoppingStorecart> datas = new HashMap<>();
        for (ShoppingStorecart sc12 : user_cart) {
            if (datas.containsKey(sc12.getId())) {
                datas.put(sc12.getId(), sc12);
            }
        }
        for (ShoppingStorecart sc11 : cookie_cart) {
            if (!datas.containsKey(sc11.getId())) {
                datas.put(sc11.getId(), sc11);
            }
        }
        String[] gsp_ids = gsp.split(",");
        Arrays.sort(gsp_ids);
        boolean add = true;
        BigDecimal total_price = new BigDecimal("0.00");
        int total_count = 0;
        if (StringUtils.isNotBlank(count)) {
            total_count = Integer.parseInt(count);
        }
        String[] gsp_ids1;
        //Map<Long,Boolean> flag= new HashMap<>();
        for (Map.Entry<Long, ShoppingStorecart> entry : datas.entrySet()) {
            params.clear();
            params.put("sc_id", entry.getKey());
            List<ShoppingGoodscart> carts = goodsCartService.queryByCondition(params);
            for (ShoppingGoodscart gc : carts) {
                goodsSpecPropertyTools.addGsps(gc);
                if (gsp_ids != null && gsp_ids.length > 0 && gc.getGsps() != null && gc.getGsps().size() > 0) {
                    gsp_ids1 = new String[gc.getGsps().size()];
                    for (int i = 0; i < gc.getGsps().size(); i++) {
                        gsp_ids1[i] = gc.getGsps().get(i) != null ? gc.getGsps().get(i).getId().toString() : "";
                    }
                    Arrays.sort(gsp_ids1);
                    if ((!gc.getGoodsId().toString().equals(id)) || (!Arrays.equals(gsp_ids, gsp_ids1))) {
                        continue;
                    }
                    add = false;
                } else if (gc.getGoodsId().toString().equals(id)) {
                    add = false;
                }
            }
        }
        ShoppingGoodscart obj;
        if (add) {
            ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(CommUtil.null2Long(id));
            String type = "save";
            ShoppingStorecart sc33 = new ShoppingStorecart();
            if (type.equals("save")) {
                sc33.setStoreId(goods.getGoodsStoreId());
                sc33.setUserId(user.getId());
                BigDecimal amount = addPrice.multiply(new BigDecimal(count));
                sc33.setTotalPrice(amount);
                sc33.setAddtime(new Date());
                sc33.setDeletestatus(false);
                this.storeCartService.save(sc33);
            }
            obj = new ShoppingGoodscart();
            obj.setAddtime(new Date());
            obj.setPrice(addPrice);
            if (CommUtil.null2String(buy_type).equals("")) {
                obj.setCount(CommUtil.null2Int(count));
                obj.setPrice(addPrice);
            }
            if (CommUtil.null2String(buy_type).equals("combin")) {
                obj.setCount(1);
                obj.setCartType("combin");
                obj.setPrice(goods.getCombinPrice());
            }
            String spec_info = "";
            ShoppingGoodsspecproperty spec_property;
            if (obj.getGsps() == null) {
                obj.setGsps(new ArrayList<>());
            }
            if (gsp_ids != null && !"".equals(gsp_ids)) {
                for (String gsp_id : gsp_ids) {
                    spec_property = this.goodsSpecPropertyService.getObjById(CommUtil.null2Long(gsp_id));
                    obj.getGsps().add(spec_property);
                    if (spec_property != null) {
                        spec_property.setSpec(goodsSpecificationService.getObjById(spec_property.getSpecId()));
                        spec_info = spec_property.getSpec().getName() + ":" + spec_property.getValue() + " " + spec_info;
                    }
                }
            }
            obj.setSpecInfo(spec_info);
            obj.setDeletestatus(false);
            obj.setCount(Integer.parseInt(count));
            obj.setGoodsId(goods.getId());
            obj.setScId(sc33.getId());
            this.goodsCartService.save(obj);
            params.clear();
            params.put("sc_id", sc33.getId());
            List<ShoppingGoodscart> carts = goodsCartService.queryByCondition(params);
            if (carts != null) {
                sc33.setGcs(carts);
            } else {
                sc33.getGcs().add(obj);
            }

            if (user == null) {
                sc33.setCartSessionId(cart_session_id);
            } else {
                sc33.setUserId(user.getId());
            }
            total_price =sc33.getTotalPrice();
            if (!type.equals("save")) {
                addPrice =addPrice.multiply(new BigDecimal(count));
                sc33.setTotalPrice(sc33.getTotalPrice().add(addPrice));
                total_price =sc33.getTotalPrice();
                this.storeCartService.update(sc33);
            }
        }
        JSONObject map = new JSONObject();
        map.put("count", Integer.valueOf(total_count));
        map.put("total_price", total_price);
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(map.toJSONString());
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param request
     * @param response
     * @param id
     * @param ids
     * @param store_id
     * @throws IOException
     */
    @SecurityMapping(display = false, rsequence = 0, title = "购物车中收货地址保存", value = "/cart_address_save.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
    @RequestMapping({"/cart_address_save.htm"})
    public void cart_address_save(HttpServletRequest request, HttpServletResponse response, String id, String ids, String store_id) throws IOException {
        ShoppingAddress address = null;
        if (id == null || "".equals(id)) {
            address = new ShoppingAddress();
            address.setAddtime(new Date());
            address.setDeletestatus(false);
            address.setIsdefault(false);
            address.setUserId(SecurityUserHolder.getCurrentUser().getId());
            address.setTruename(request.getParameter("trueName"));
            address.setAreaInfo(request.getParameter("area_info"));
            address.setZip(request.getParameter("zip"));
            address.setMobile(request.getParameter("mobile"));
            address.setTelephone(request.getParameter("telephone"));
            address.setCity(request.getParameter("city"));
            address.setCompany(request.getParameter("company"));
            address.setCountries(request.getParameter("countries"));
        } else {
            address = this.addressService.getObjById(Long.valueOf(Long.parseLong(id)));
        }

        // ShoppingArea area = this.areaService.getObjById(CommUtil.null2Long(area_id));
        //address.setAreaId(CommUtil.null2Long(area_id));
        if (id == null || "".equals(id)) {
            this.addressService.save(address);
        } else {
            this.addressService.update(address);
        }
        response.sendRedirect("/goods_cart2.htm?ids="+ids+"&store_id=" + store_id); //"redirect: +;
    }


    @RequestMapping({"/goods_cart1.htm"})
    public ModelAndView goods_cart1(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView("goods_cart1.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        String shopping_view_type = CommUtil.null2String(request.getSession().getAttribute("shopping_view_type"));
        if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
            mv = new JModelAndView("wap/goods_cart1.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        ShoppingUser user = SecurityUserHolder.getCurrentUser();
        Map<String,Object> params =new HashMap<>();
        params.put("user_id",user.getId());
        params.put("isdefault",true);
        List<ShoppingAddress> address = addressService.queryByCondition(params);
        mv.addObject("address",address);
        List<ShoppingStorecart> carts = getCart(user.getId());
        Map<Long,BigDecimal> priceMsg= new HashMap<>();
        if (carts != null) {
            carts = storeViewTools.addStores(carts);
            goodsCartTools.insertGcs(carts);
            request.getSession(false).setAttribute("carts", carts);
            Map<Long,List<ShoppingGoodscart>>  cartMsg = new HashMap<>();
            for(ShoppingStorecart c: carts){
                if(cartMsg.containsKey(c.getStoreId())){
                    List<ShoppingGoodscart> cart =cartMsg.get(c.getStoreId());
                    cart.addAll(c.getGcs());
                    cartMsg.put(c.getStoreId(),cart);
                    priceMsg.put(c.getStoreId(),c.getTotalPrice().add(priceMsg.get(c.getStoreId())));
                }else{
                    List<ShoppingGoodscart> cart= new ArrayList<>();
                    cart.addAll(c.getGcs());
                    cartMsg.put(c.getStoreId(),cart);
                    priceMsg.put(c.getStoreId(),c.getTotalPrice());
                }
            }
            //组装数据  -》一店铺分类的 返回的店铺购物车数据信息
            JSONArray data = new JSONArray();
            Set<Map.Entry<Long,List<ShoppingGoodscart>>> entrySet = cartMsg.entrySet();
            Iterator<Map.Entry<Long,List<ShoppingGoodscart>>> iter = entrySet.iterator();
            while (iter.hasNext()){
                Map.Entry<Long,List<ShoppingGoodscart>> entry = iter.next();
                ShoppingStoreWithBLOBs store = storeService.getObjById(entry.getKey());
                JSONObject obj = new JSONObject();
                obj.put("store",store);
                List<ShoppingGoodscart> cart = entry.getValue();
                //obj.put("orderId",of.getId());
                mv.addObject("carts",cart);
                obj.put("carts", cart);
                data.add(obj);
            }
            mv.addObject("data",data);
            mv.addObject("carts", carts);
            mv.addObject("user", user);
            viewTools.topHandle(mv, request);
            viewTools.headHandle(mv, request);
            viewTools.footerHandle(mv);
            if (this.configService.getSysConfig().getZtcStatus()) {
                List ztc_goods = null;
                Map ztc_map = new HashMap();
                ztc_map.put("ztc_status", Integer.valueOf(3));
                ztc_map.put("ztc_begin_time", new Date());
                ztc_map.put("ztc_gold", Integer.valueOf(0));
                ztc_map.put("orderBy", "ztc_dredge_price");
                ztc_map.put("sort", "desc");
                List goods = this.goodsService.queryByCondition(ztc_map);
                ztc_goods = randomZtcGoods(goods);
                accessoryViewTools.addMainPhotos(ztc_goods);
                mv.addObject("ztc_goods", ztc_goods);
            }
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
            if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
                mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request, response);
            }
            mv.addObject("op_title", "购物车信息为空");
            if("pc".equals(shopping_view_type)){
                mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
            }else{
                mv.addObject("url", CommUtil.getURL(request) + "/wap/index.htm");
            }

        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title = "地址切换", value = "/order_address.htm*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
    @RequestMapping({"/order_address.htm"})
    public void order_address(HttpServletRequest request, HttpServletResponse response, String addr_id, String store_id) {
        List<ShoppingStorecart> cart = (List) request.getSession(false).getAttribute("cart");
        ShoppingStorecart sc = null;
        if (cart != null) {
            for (ShoppingStorecart sc1 : cart) {
                if (sc1.getStoreId().equals(CommUtil.null2Long(store_id))) {
                    sc = sc1;
                    break;
                }
            }
        }
        ShoppingAddress addr = this.addressService.getObjById(CommUtil.null2Long(addr_id));
        List sms = this.transportTools.query_cart_trans(sc, addr.getAreaId());
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(sms);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @RequestMapping({"/goods_cart2"})
    public  ModelAndView goodsCartTwo(HttpServletRequest request, HttpServletResponse response, String ids){
        ModelAndView mv = new JModelAndView("wap/goods_cart2.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        if(StringUtils.isNotBlank(ids)){
            //获取goodscart
            String[]  primarys= ids.split(",");
            List<ShoppingGoodscart> gcs =new ArrayList<>();
            for(String s: primarys){
                if(StringUtils.isNotBlank(s)){
                    gcs.add(goodsCartService.getObjById(Long.valueOf(s)));
                }
            }
            if(!gcs.isEmpty()){
                Map<Long,List<ShoppingGoodscart>>  cartMsg = new HashMap<>();
                Map<Long,BigDecimal> priceMsg= new HashMap<>();
                for(ShoppingGoodscart s: gcs){
                    ShoppingStorecart sc = storeCartService.getObjById(s.getScId());
                    if(!cartMsg.containsKey(sc.getStoreId())){
                        //priceMsg.put(sc.getStoreId(),s.getPrice());
                        priceMsg.put(sc.getStoreId(),sc.getTotalPrice());
                        List<ShoppingGoodscart> cart= new ArrayList<>();
                        cart.add(s);
                        cartMsg.put(sc.getStoreId(),cart);
                    }else{
                        BigDecimal price = priceMsg.get(sc.getStoreId());
                        priceMsg.put(sc.getStoreId(),price.add(sc.getTotalPrice()));
                        List<ShoppingGoodscart> cart= cartMsg.get(sc.getStoreId());
                        cart.add(s);
                        cartMsg.put(sc.getStoreId(), cart);
                    }
                }
                ShoppingUser user =SecurityUserHolder.getCurrentUser();
                mv.addObject("user",user);
                Map params = new HashMap();
                params.put("user_id", user.getId());
                params.put("orderBy", "addTime");
                params.put("sort", "desc");
                List<ShoppingAddress> addressList =this.addressService.queryByCondition(params);
                mv.addObject("addressList",addressList);

                params.clear();
                params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
                params.put("orderBy", "addTime");
                params.put("sort", "desc");
                params.put("isdefault",1);
                List<ShoppingAddress> addrs = this.addressService.queryByCondition(params);
                if(addrs.size()>0){
                    mv.addObject("addr", addrs.get(0));
                }else if (addressList.size() > 0) {
                        mv.addObject("addr", addressList.get(0));
                    }

                //组装数据  -》一店铺分类的 返回的店铺购物车数据信息
                JSONArray data = new JSONArray();
                Set<Map.Entry<Long,List<ShoppingGoodscart>>> entrySet = cartMsg.entrySet();
                Iterator<Map.Entry<Long,List<ShoppingGoodscart>>> iter = entrySet.iterator();
                while (iter.hasNext()){
                    Map.Entry<Long,List<ShoppingGoodscart>> entry = iter.next();
                    ShoppingStoreWithBLOBs store = storeService.getObjById(entry.getKey());
                    JSONObject obj = new JSONObject();
                    obj.put("store",store);
                    List<ShoppingGoodscart> cart = entry.getValue();
                    for(ShoppingGoodscart c: cart){
                        //发票商品信息
                        goodsViewTools.addGoodsCartGood(c);
                    }
                    //obj.put("orderId",of.getId());
                    mv.addObject("carts",cart);
                    obj.put("carts", cart);
                    obj.put("totalPrice",priceMsg.get(entry.getKey()));
                    params.clear();
                    params.put("coupon_order_amount", priceMsg.get(entry.getKey()));
                    params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
                    params.put("coupon_begin_time", new Date());
                    params.put("coupon_end_time", new Date());
                    params.put("status", Integer.valueOf(0));
                    List<ShoppingCoupon> couponinfos = this.couponService.queryByCondition(params);
                    obj.put("couponin",couponinfos);
                    data.add(obj);
                }
                params.clear();
                params.put("type", "admin");
                List<ShoppingPaymentWithBLOBs> pays = paymentService.queryByCondition(params);
                mv.addObject("pays",pays);
                String cart_session = CommUtil.randomString(32);
                request.getSession(false).setAttribute("cart_session", cart_session);
                mv.addObject("cart_session", cart_session);
                mv.addObject("cartData",data);
                mv.addObject("ids",ids);

            }

        } else {
            mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
            mv.addObject("op_title", "请选择正确的商品结算");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }

        return mv;
    }


    @RequestMapping({"/goods_cart2.htm"})
    public ModelAndView goods_cart2(HttpServletRequest request, HttpServletResponse response, String ids) {
        ModelAndView mv = new JModelAndView("goods_cart2.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        String shopping_view_type = CommUtil.null2String(request.getSession().getAttribute("shopping_view_type"));
        if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
            mv = new JModelAndView("wap/goods_cart2.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        String[]  primarys= ids.split(",");
        List<ShoppingGoodscart> gcs =new ArrayList<>();
        for(String s: primarys){
            if(StringUtils.isNotBlank(s)){
                gcs.add(goodsCartService.getObjById(Long.valueOf(s)));
            }
        }
        if (gcs != null) {
            Map params = new HashMap();
            params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
            params.put("orderBy", "addTime");
            params.put("sort", "desc");
            List<ShoppingAddress> addressList = this.addressService.queryByCondition(params);
            mv.addObject("addressList",addressList);
            params.clear();
            params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
            params.put("orderBy", "addTime");
            params.put("sort", "desc");
            params.put("isdefault",1);
            List<ShoppingAddress> addrs =this.addressService.queryByCondition(params);
            if(addrs.size()>0){
                mv.addObject("addr", addrs.get(0));
            }else if(addressList.size() > 0) {
                mv.addObject("addr", addressList.get(0));
            }

            Map<Long,List<ShoppingGoodscart>>  cartMsg = new HashMap<>();
            Map<Long,BigDecimal> priceMsg= new HashMap<>();
            for(ShoppingGoodscart s: gcs){
                ShoppingStorecart sc = storeCartService.getObjById(s.getScId());
                if(!cartMsg.containsKey(sc.getStoreId())){
                    priceMsg.put(sc.getStoreId(),sc.getTotalPrice());
                    List<ShoppingGoodscart> cart= new ArrayList<>();
                    cart.add(s);
                    cartMsg.put(sc.getStoreId(),cart);
                }else{
                    BigDecimal price = priceMsg.get(sc.getStoreId());
                    priceMsg.put(sc.getStoreId(),price.add(sc.getTotalPrice()));
                    List<ShoppingGoodscart> cart= cartMsg.get(sc.getStoreId());
                    cart.add(s);
                    cartMsg.put(sc.getStoreId(), cart);
                }
            }
            JSONArray data = new JSONArray();
            Set<Map.Entry<Long,List<ShoppingGoodscart>>> entrySet = cartMsg.entrySet();
            Iterator<Map.Entry<Long,List<ShoppingGoodscart>>> iter = entrySet.iterator();
            BigDecimal totalPrice = new BigDecimal("0.00");
            while (iter.hasNext()){
                Map.Entry<Long,List<ShoppingGoodscart>> entry = iter.next();
                ShoppingStoreWithBLOBs store = storeService.getObjById(entry.getKey());
                JSONObject obj = new JSONObject();
                obj.put("store",store);
                //添加订单信息
                List<ShoppingGoodscart> cart = entry.getValue();
                for(ShoppingGoodscart c: cart){
                    goodsViewTools.addGoodsCartGood(c);
                }
                obj.put("carts", cart);
                obj.put("totalPrice",priceMsg.get(entry.getKey()));
                totalPrice= totalPrice.add(priceMsg.get(entry.getKey()));
                data.add(obj);
            }
            params.put("coupon_order_amount", totalPrice);
            params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
            params.put("coupon_begin_time", new Date());
            params.put("coupon_end_time", new Date());
            params.put("status", Integer.valueOf(0));
            List<ShoppingCouponInfo> couponinfos = this.couponInfoService.queryByCondition(params);
            //优惠券
            mv.addObject("couponinfos", couponinfos);
            mv.addObject("totalPrice", totalPrice);
            mv.addObject("data", data);
            mv.addObject("ids",ids);
            viewTools.topHandle(mv, request);
            viewTools.headHandle(mv, request);
            viewTools.footerHandle(mv);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
            if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
                mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request, response);
            }
            mv.addObject("op_title", "购物车信息为空");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }



    @RequestMapping({"/goodsGsp"})
    @ResponseBody
    public ResponseModel goodsGsp( String id){
        ResponseModel  res = new ResponseModel();
        res.setCode("400");
        if(StringUtils.isNotBlank(id)){
            ShoppingGoodsWithBLOBs obj = this.goodsService.getObjById(Long.valueOf(Long.parseLong(id)));
            if(obj  != null){
                goodsViewTools.setGroup(obj);
                goodsViewTools.addTransport(obj);
                goodsViewTools.addDeliveryGoods(obj);
                goodsViewTools.addSpec(obj);
                accessoryViewTools.addGoodsPhotos(obj);
                goodsViewTools.addGoodsSpecis(obj);
                accessoryViewTools.addMainPhoto(obj);
                res.setCode("200");
                res.setMsg("success");
                res.setData(obj);
                return res;
            }else{
                res.setMsg("shu");
            }
        }else{
            res.setMsg("无效参数id");
        }
        return res;
    }


    @RequestMapping({"/goods_cart3"})
    public ModelAndView before_pay( HttpServletRequest request, HttpServletResponse response,String ids,String addr_id, String coupon_id,String payId,String invoice){
        ModelAndView mv = new JModelAndView("wap/pay.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        BigDecimal amount = new BigDecimal("0.00");
        String orderNo = SecurityUserHolder.getCurrentUser().getId() + CommUtil.formatTime("yyyyMMddHHmmss", new Date());
        String[] primarys = ids.split(",");
        List<ShoppingGoodscart> gcs = new ArrayList<>();
        for (String s : primarys) {
            if (StringUtils.isNotBlank(s)) {
                gcs.add(goodsCartService.getObjById(Long.valueOf(s)));
            }
        }
        if (!gcs.isEmpty()) {
        if(StringUtils.isNotBlank(payId) && StringUtils.isNotBlank(addr_id)) {
            for (ShoppingGoodscart c : gcs) {
                ShoppingStorecart sc = storeCartService.getObjById(c.getScId());
                sc.setScStatus(1);
                storeCartService.update(sc);
                //订单信息
                ShoppingOrderformWithBLOBs order = new ShoppingOrderformWithBLOBs();
                order.setOrderId(orderNo);
                order.setAddtime(new Date());
                //运费
                BigDecimal ship = new BigDecimal("0.00");
                order.setShipPrice(ship);
                order.setOrderStatus(10);
                order.setUserId(SecurityUserHolder.getCurrentUser().getId());
                order.setDeletestatus(false);
                order.setInvoicetype(0);
                order.setAddrId(Long.valueOf(addr_id));
                order.setPaymentId(Long.valueOf(payId));
                order.setStoreId(sc.getStoreId());
                order.setGoodsAmount(sc.getTotalPrice());
                order.setTotalprice(BigDecimal.valueOf(CommUtil.add(sc.getTotalPrice(), ship)));

                //修改订单信息 totalprice addr_id  等信息
                if (!CommUtil.null2String(coupon_id).equals("")) {
                    ShoppingCouponInfo ci = this.couponInfoService.getObjById(CommUtil.null2Long(coupon_id));
                    ci.setStatus(1);
                    this.couponInfoService.update(ci);
                    order.setCiId(ci.getId());
                    ShoppingCoupon cou = couponService.getObjById(ci.getCouponId());
                    order.setTotalprice(BigDecimal.valueOf(CommUtil.subtract(order.getTotalprice(), cou == null ? new BigDecimal("0.00") : cou.getCouponAmount())));
                }
                order.setOrderType("web");
                amount = amount.add(order.getTotalprice());
                order.setInvoice(invoice);
                orderFormService.save(order);
                c.setOfId(order.getId());
                goodsCartService.update(c);
                //修改coupon 信息
                ShoppingOrderLog ofl = new ShoppingOrderLog();
                ofl.setDeletestatus(false);
                ofl.setAddtime(new Date());
                ofl.setOfId(order.getId());
                ofl.setLogInfo("提交订单");
                ofl.setLogUserId(SecurityUserHolder.getCurrentUser().getId());
                this.orderFormLogService.save(ofl);

            }
                String s = payViewTools.genericPaypal(request.getScheme() + "://" + request.getServerName(), payId, "goods", orderNo, amount);
                mv.addObject("content", s);
                return mv;
        }
        }else{
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(),1, request, response);
            mv.addObject("op_title", "参数orderIds无效");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }

        return mv;
    }


    @RequestMapping({"/goods_cart3.htm"})
    public ModelAndView goods_cart3(HttpServletRequest request, HttpServletResponse response,String ids,/* String cart_session, String store_id,*/ String addr_id, String coupon_id) throws Exception {
        ModelAndView mv = new JModelAndView("goods_cart3.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        String shopping_view_type = CommUtil.null2String(request.getSession().getAttribute("shopping_view_type"));
        if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
            mv = new JModelAndView("wap/goods_cart3.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        }
        if(StringUtils.isNotBlank(ids)){
            String[] is= ids.split(",");
            List<ShoppingGoodscart> gcs =new ArrayList<>();
            for(String s: is){
                if(StringUtils.isNotBlank(s)){
                    gcs.add(goodsCartService.getObjById(Long.valueOf(s)));
                }
            }
            if(!gcs.isEmpty()){
                String orderNo = SecurityUserHolder.getCurrentUser().getId() + CommUtil.formatTime("yyyyMMddHHmmss", new Date());
                BigDecimal totalPrice =new BigDecimal("0.00");
                for(ShoppingGoodscart s: gcs){
                    ShoppingStorecart sc = storeCartService.getObjById(s.getScId());
                    totalPrice=totalPrice.add(sc.getTotalPrice());
                    ShoppingOrderformWithBLOBs of = new ShoppingOrderformWithBLOBs();
                    of.setAddtime(new Date());
                    of.setOrderId(SecurityUserHolder.getCurrentUser().getId() + CommUtil.formatTime("yyyyMMddHHmmss", new Date()));
                    of.setAddrId(CommUtil.null2Long(addr_id));
                    //运费
                    BigDecimal ship = new BigDecimal("0.00");
                    of.setGoodsAmount(sc.getTotalPrice());
                    of.setShipPrice(ship);
                    of.setAddrId(CommUtil.null2Long(addr_id));
                    of.setOrderStatus(10);
                    of.setUserId(SecurityUserHolder.getCurrentUser().getId());
                    of.setStoreId(sc.getStoreId());
                    of.setTotalprice(BigDecimal.valueOf(CommUtil.add(of.getGoodsAmount(), of.getShipPrice())));
                    if (!CommUtil.null2String(coupon_id).equals("")) {
                        ShoppingCouponInfo ci = this.couponInfoService.getObjById(CommUtil.null2Long(coupon_id));
                        ci.setStatus(1);
                        this.couponInfoService.update(ci);
                        of.setCiId(ci.getId());
                        ShoppingCoupon cou = couponService.getObjById(ci.getCouponId());
                        of.setTotalprice(BigDecimal.valueOf(CommUtil.subtract(of.getTotalprice(), cou == null ? new BigDecimal("0.00") : cou.getCouponAmount())));
                    }
                    of.setOrderType("web");
                    of.setDeletestatus(false);
                    of.setAddtime(new Date());
                    of.setInvoicetype(0);
                    this.orderFormService.save(of);
                    s.setOfId(of.getId());
                    goodsCartService.update(s);
                    ShoppingOrderLog ofl = new ShoppingOrderLog();
                    ofl.setDeletestatus(false);
                    ofl.setAddtime(new Date());
                    ofl.setOfId(of.getId());
                    ofl.setLogInfo("提交订单");
                    ofl.setLogUserId(SecurityUserHolder.getCurrentUser().getId());
                    this.orderFormLogService.save(ofl);
                    if (this.configService.getSysConfig().getEmailenable()) {
                        sendMessageService.sendEmail("","下单提醒","尊敬的卖家，客户已下单请,订单号为："+of.getId()+"尽快处理");
                    }
                    if (this.configService.getSysConfig().getSmsenbale()) {
                        sendMessageService.sendSMS("","尊敬的卖家，客户已下单请,订单号为："+of.getId()+"尽快处理");
                    }
                    sc.setScStatus(1);
                    storeCartService.update(sc);
                }
                mv.addObject("orderNo",orderNo);
                mv.addObject("totalPrice",totalPrice);
                Map<String,Object> params = new HashMap<>();
                params.put("type", "admin");
                List<ShoppingPaymentWithBLOBs> pays = paymentService.queryByCondition(params);
                mv.addObject("pays",pays);
                viewTools.topHandle(mv, request);
                viewTools.headHandle(mv, request);
                viewTools.footerHandle(mv);
                paymentTools.returnData("wxcodepay", mv);
            }else{
                mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request, response);
                if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
                    mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1, request, response);
                }
                mv.addObject("op_title", "订单信息错误");
                mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
            }
        }else{
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
            if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
                mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request, response);
            }
            mv.addObject("op_title", "参数为null");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }

      /*  List<ShoppingStorecart> cart = cart_calc(request);
        if (cart != null) {
            request.getSession(false).removeAttribute("cart_session");
            ShoppingOrderformWithBLOBs of = new ShoppingOrderformWithBLOBs();
            of.setAddtime(new Date());
            of.setOrderId(SecurityUserHolder.getCurrentUser().getId() + CommUtil.formatTime("yyyyMMddHHmmss", new Date()));
            // ShoppingAddress addr = this.addressService.getObjById(CommUtil.null2Long(addr_id));
            BigDecimal amount = new BigDecimal("0.00");
            //运费
            BigDecimal ship = new BigDecimal("0.00");
            for (ShoppingStorecart c : cart) {
                amount = amount.add(c.getTotalPrice());
            }
            of.setGoodsAmount(amount);
            of.setShipPrice(ship);
            of.setAddrId(CommUtil.null2Long(addr_id));
            of.setOrderStatus(10);
            of.setUserId(SecurityUserHolder.getCurrentUser().getId());
            of.setStoreId(CommUtil.null2Long(store_id));
            of.setTotalprice(BigDecimal.valueOf(CommUtil.add(of.getGoodsAmount(), of.getShipPrice())));
            if (!CommUtil.null2String(coupon_id).equals("")) {
                ShoppingCouponInfo ci = this.couponInfoService.getObjById(CommUtil.null2Long(coupon_id));
                ci.setStatus(1);
                this.couponInfoService.update(ci);
                of.setCiId(ci.getId());
                ShoppingCoupon cou = couponService.getObjById(ci.getCouponId());
                of.setTotalprice(BigDecimal.valueOf(CommUtil.subtract(of.getTotalprice(), cou == null ? new BigDecimal("0.00") : cou.getCouponAmount())));
            }
            of.setOrderType("web");
            of.setDeletestatus(false);
            of.setAddtime(new Date());
            of.setInvoicetype(0);
            this.orderFormService.save(of);

            ShoppingGoodscart gc;
            for (ShoppingStorecart sc : cart) {
                *//*if (sc.getStoreId().toString().equals(store_id)) {
                    goodsCartTools.addGcs(sc);
                    if (sc.getGcs() != null) {
                        for (ShoppingGoodscart s : sc.getGcs()) {
                            gc = s;
                            s.setOfId(of.getId());
                            this.goodsCartService.update(s);
                        }
                    }
                    sc.setCartSessionId(null);
                    sc.setUser(SecurityUserHolder.getCurrentUser());
                    sc.setScStatus(1);
                    this.storeCartService.update(sc);
                    break;
                }*//*
            }
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    Cookie cookie = cookies[i];
                    if (cookie.getName().equals("cart_session_id")) {
                        cookie.setDomain(CommUtil.generic_domain(request));
                        cookie.setValue("");
                        cookie.setMaxAge(0);
                        response.addCookie(cookie);
                    }
                }
            }
            ShoppingOrderLog ofl = new ShoppingOrderLog();
            ofl.setDeletestatus(false);
            ofl.setAddtime(new Date());
            ofl.setOfId(of.getId());
            ofl.setLogInfo("提交订单");
            ofl.setLogUserId(SecurityUserHolder.getCurrentUser().getId());
            this.orderFormLogService.save(ofl);
            mv.addObject("of", of);
            if (this.configService.getSysConfig().getEmailenable()) {
                //send_email(request, of, of.getUser().getEmail(), "email_tobuyer_order_submit_ok_notify");
            }
            if (this.configService.getSysConfig().getSmsenbale()) {
                //send_sms(request, of, of.getUser().getMobile(), "sms_tobuyer_order_submit_ok_notify");
            }
            paymentTools.returnData("alipay", mv);
            paymentTools.returnData("paypal", mv);
            paymentTools.returnData("tenpay", mv);

            paymentTools.returnData("chinabank", mv);
            paymentTools.returnData("bill", mv);
            paymentTools.returnData("outline", mv);
            paymentTools.returnData("payafter", mv);
            paymentTools.returnData("balance", mv);
            paymentTools.returnStoreData("alipay", of.getStoreId(), mv);
            paymentTools.returnStoreData("paypal", of.getStoreId(), mv);
            paymentTools.returnStoreData("tenpay", of.getStoreId(), mv);
            paymentTools.returnStoreData("wxcodepay", of.getStoreId(), mv);
            paymentTools.returnStoreData("chinabank", of.getStoreId(), mv);
            paymentTools.returnStoreData("outline", of.getStoreId(), mv);
            paymentTools.returnStoreData("payafter", of.getStoreId(), mv);
            paymentTools.returnStoreData("balance", of.getStoreId(), mv);
            viewTools.topHandle(mv, request);
            viewTools.headHandle(mv, request);
            viewTools.footerHandle(mv);
        } else {

        }*/
        return mv;
    }


    @RequestMapping({"/cart_menu_detail.htm"})
    public ModelAndView cart_menu_detail(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView("cart_menu_detail.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        List<ShoppingStorecart> cart = cart_calc(request);
        goodsCartTools.insertGcs(cart);
        List<ShoppingGoodscart> list = new ArrayList<ShoppingGoodscart>();
        if (cart != null) {
            for (ShoppingStorecart sc : cart) {
                if (sc != null) {
                    list.addAll(sc.getGcs());
                }
            }
        }
        float total_price = 0.0F;
        for (ShoppingGoodscart gc : list) {
            ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(gc.getGoodsId());
            if (CommUtil.null2String(gc.getCartType()).equals("combin")) {
                total_price = CommUtil.null2Float(goods.getCombinPrice());
            } else {
                total_price = CommUtil.null2Float(Double.valueOf(CommUtil.mul(Integer.valueOf(gc.getCount()), gc.getPrice()))) + total_price;
            }
        }
        mv.addObject("total_price", Float.valueOf(total_price));
        mv.addObject("cart", list);
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title = "地址新增", value = "/*", rtype = "buyer", rname = "购物流程3", rcode = "goods_cart", rgroup = "在线购物")
    @RequestMapping({"/cart_address.htm"})
    public ModelAndView cart_address(HttpServletRequest request, HttpServletResponse response, String ids, String store_id) {
        ModelAndView mv = new JModelAndView("cart_address.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        String shopping_view_type = CommUtil.null2String(request.getSession().getAttribute("shopping_view_type"));
        if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
            mv = new JModelAndView("wap/cart_address.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        /*Map<String, Object> params = new HashMap<>();
        params.put("parent_id", "is null");
        List<ShoppingArea> areas = this.areaService.queryByCondition(params);
        areaViewTools.addGrandson(areas);
        mv.addObject("areas", areas);*/
        mv.addObject("store_id", store_id);
        mv.addObject("ids", ids);
        return mv;
    }

    private List<ShoppingStorecart> getCart(Long userId){
        Map params = new HashMap();
        params.put("user_id", userId);
        params.put("sc_status", Integer.valueOf(0));
        return this.storeCartService.queryByCondition(params);
    }


    private List<ShoppingStorecart> cart_calc(HttpServletRequest request) {
        List<ShoppingStorecart> cart = new ArrayList<ShoppingStorecart>();
        List<ShoppingStorecart> user_cart = new ArrayList<ShoppingStorecart>();
        List<ShoppingStorecart> cookie_cart = new ArrayList<ShoppingStorecart>();
        ShoppingUser user = null;
        if (SecurityUserHolder.getCurrentUser() != null) {
            user = SecurityUserHolder.getCurrentUser();
        }
        String cart_session_id = "";
        Map params = new HashMap();
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cart_session_id")) {
                    cart_session_id = CommUtil.null2String(cookie.getValue());
                }
            }
        }
        if (user != null) {
            if (!cart_session_id.equals("")) {
                ShoppingStoreWithBLOBs store = storeService.getObjById(user.getStoreId());
                if (store != null) {
                    params.clear();
                    params.put("cart_session_id", cart_session_id);
                    params.put("user_id", user.getId());
                    params.put("sc_status", Integer.valueOf(0));
                    params.put("store_id", user.getStoreId());
                    params.put("deleteStatus",false);
                    List<ShoppingStorecart> store_cookie_cart = this.storeCartService.queryCookiecart(params);
                    //删除购买自己店铺的商品
                    for (ShoppingStorecart sc : store_cookie_cart) {
                        goodsCartTools.addGcs(sc);
                        for (ShoppingGoodscart gc : sc.getGcs()) {
                            this.goodsCartService.delete(gc.getId());
                        }
                        this.storeCartService.delete(sc.getId());
                    }
                }
                //获取cookie购物
                params.clear();
                params.put("cart_session_id", cart_session_id);
                params.put("sc_status", Integer.valueOf(0));
                params.put("deleteStatus",false);
                cookie_cart = this.storeCartService.queryByCondition(params);
                params.clear();
                params.put("user_id", user.getId());
                params.put("sc_status", Integer.valueOf(0));
                params.put("deleteStatus",false);
                user_cart = this.storeCartService.queryByCondition(params);
            } else {
                params.clear();
                params.put("user_id", user.getId());
                params.put("sc_status", Integer.valueOf(0));
                params.put("deleteStatus",false);
                user_cart = this.storeCartService.queryByCondition(params);
            }

        } else if (!cart_session_id.equals("")) {
            params.clear();
            params.put("cart_session_id", cart_session_id);
            params.put("sc_status", Integer.valueOf(0));
            params.put("deleteStatus",false);
            cookie_cart = this.storeCartService.queryByCondition(params);

        }
        //遍历用户店铺购物车
        for (ShoppingStorecart sc : user_cart) {
            boolean sc_add = true;
            //遍历cart;判断店铺购物车是否存在
            for (ShoppingStorecart sc1 : cart) {
                if (sc1.getStoreId().equals(sc.getStoreId())) {
                    sc_add = false;
                }
            }
            //不存在就添加
            if (sc_add) {
                cart.add(sc);
            }
        }

        for (ShoppingStorecart sc : cookie_cart) {
            boolean sc_add = true;
            for (ShoppingStorecart sc1 : cart) {
                if (sc1.getStoreId().equals(sc.getStoreId())) {
                    sc_add = false;
                    if( !sc.getId().equals(sc1.getId())){
                        goodsCartTools.addGcs(sc);
                        if (sc.getGcs() != null) {
                            for (ShoppingGoodscart gc : sc.getGcs()) {
                                gc.setScId(sc1.getId());
                                this.goodsCartService.update(gc);
                            }
                        }
                        this.storeCartService.delete(sc.getId());
                    }
                }
            }
            if (sc_add) {
                cart.add(sc);
            }
        }
        return cart;
    }


    /**
     * 从购物车删除商品
     *
     * @param request
     * @param response
     * @param id
     */
    @RequestMapping({"/remove_goods_cart.htm"})
    public void remove_goods_cart(HttpServletRequest request, HttpServletResponse response, String id) {
        ShoppingGoodscart gc = this.goodsCartService.getObjById(CommUtil.null2Long(id));
        ShoppingStorecart the_sc = storeCartService.getObjById(gc.getScId());
        this.goodsCartService.delete(CommUtil.null2Long(id));
        this.storeCartService.delete(the_sc.getId());
        goodsCartTools.addGcs(the_sc);
        ShoppingUser user =SecurityUserHolder.getCurrentUser();
        List<ShoppingStorecart> cart = getCart(user.getId());
        double total_price = 0.0D;
        double sc_total_price = 0.0D;
        int count = 0;
        for (ShoppingStorecart sc2 : cart) {
            goodsCartTools.addGcs(sc2);
            for (ShoppingGoodscart gc1 : sc2.getGcs()) {
                total_price = CommUtil.null2Double(gc1.getPrice()) * gc1.getCount() + total_price;
                count = count+gc1.getCount();
                sc_total_price = sc_total_price + CommUtil.null2Double(gc1.getPrice()) * gc1.getCount();
                sc2.setTotalPrice(BigDecimal.valueOf(sc_total_price));
            }
            //sc2.setDeletestatus(true);
            //this.storeCartService.update(sc2);
        }
        request.getSession(false).setAttribute("cart", cart);
        JSONObject map = new JSONObject();
        map.put("count", Integer.valueOf(count));
        map.put("total_price", Double.valueOf(total_price));
        map.put("sc_total_price", Double.valueOf(sc_total_price));
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(map.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping({"/goods_count_adjust"})
    @ResponseBody
    @Transactional
    public  JSONObject  goods(HttpServletRequest request, HttpServletResponse response, String cart_id,String count){
        JSONObject map = new JSONObject();
        String err="400";
        String errmsg="";
        if(!StringUtils.isNotBlank(cart_id)){
           errmsg="参数cart_id为null";
           map.put("err",err);
           map.put("errmsg",errmsg);
           return map;
        }
        if(!StringUtils.isNotBlank(count)){
           errmsg="参数count为null";
            map.put("err",err);
            map.put("errmsg",errmsg);
            return map;
        }
        ShoppingGoodscart cart = goodsCartService.getObjById(Long.valueOf(cart_id));
        if(cart == null){
           errmsg="参数cart_id无效";
            map.put("err",err);
            map.put("errmsg",errmsg);
            return map;
        }
        if(count.equals("0")){
            goodsCartService.delete(cart.getId());
            storeCartService.delete(cart.getScId());
            errmsg="数量等于0删除数据成功";
            map.put("err",err);
            map.put("errmsg",errmsg);
            return map;
        }
        ShoppingStorecart sc = storeCartService.getObjById(cart.getScId());
        if(sc== null){
           goodsCartService.delete(cart.getId());
           errmsg="goodscart关联storecart出错";
           map.put("err",err);
           map.put("errmsg",errmsg);
           return map;
        }
        cart.setCount(Integer.parseInt(count));
        goodsCartService.update(cart);
        sc.setTotalPrice(new BigDecimal(count).multiply(cart.getPrice()));
        storeCartService.update(sc);
        err="200";
        errmsg="success";
        map.put("err",err);
        map.put("errmsg",errmsg);
        //map.put("goods_total_price",)
        map.put("sc_total_price",sc.getTotalPrice());
        return map;
    }


    @RequestMapping({"/goods_count_adjust.htm"})
    public void goods_count_adjust(HttpServletRequest request, HttpServletResponse response, String cart_id, String store_id, String count) {
        //更改数量
        ShoppingUser user  = SecurityUserHolder.getCurrentUser();
        List<ShoppingStorecart> cart = getCart(user.getId());
        goodsCartTools.insertGcs(cart);
        double goods_total_price = 0.0D;
        String error = "100";
        ShoppingGoodsWithBLOBs goods = null;
        String cart_type = "";
        ShoppingGoodscart gc;
        for (ShoppingStorecart sc : cart) {
            for (Iterator localIterator2 = sc.getGcs().iterator(); localIterator2.hasNext(); ) {
                gc = (ShoppingGoodscart) localIterator2.next();
                if (gc.getId().toString().equals(cart_id)) {
                    goods = gc.getGoods();
                    goodsViewTools.addgroupGoodsList(goods);
                    cart_type = CommUtil.null2String(gc.getCartType());
                }
            }
        }
        Object sc;
        if (cart_type.equals("")) {
            if (goods.getGroupBuy() == 2) {
                ShoppingGroupGoods gg = new ShoppingGroupGoods();
                for (ShoppingGroupGoods gg1 : goods.getGroup_goods_list()) {
                    if (gg1.getGgGoodsId().equals(goods.getId())) {
                        gg = gg1;
                    }
                }
                if (gg.getGgCount() >= CommUtil.null2Int(count)) {
                    for (ShoppingStorecart sc1 : cart) { // sc = (StoreCart)gc.next();
                        for (int i = 0; i < sc1.getGcs().size(); i++) {
                            ShoppingGoodscart art = sc1.getGcs().get(i);
                            ShoppingGoodscart gc1 = art;
                            if (art.getId().toString().equals(cart_id)) {
                                sc1.setTotalPrice(BigDecimal.valueOf(CommUtil.add(sc1.getTotalPrice(),
                                        Double.valueOf((CommUtil.null2Int(count) - art.getCount()) * CommUtil.null2Double(art.getPrice())))));
                                art.setCount(CommUtil.null2Int(count));
                                goodsCartService.update(art);
                                gc1 = art;
                                sc1.getGcs().remove(art);
                                sc1.getGcs().add(gc1);
                                goods_total_price = CommUtil.null2Double(gc1.getPrice()) * gc1.getCount();
                                this.storeCartService.update(sc1);
                            }
                        }
                    }
                } else {
                    error = "300";
                }
            } else if (goods.getGoodsInventory() >= CommUtil.null2Int(count)) {
                for (ShoppingStorecart scart : cart) {
                    for (int i = 0; i < scart.getGcs().size(); i++) {
                        ShoppingGoodscart gcart = scart.getGcs().get(i);
                        ShoppingGoodscart gc1 = gcart;
                        if (gcart.getId().toString().equals(cart_id)) {
                            scart.setTotalPrice(BigDecimal.valueOf(CommUtil.add(scart.getTotalPrice(),
                                    Double.valueOf((CommUtil.null2Int(count) - gcart.getCount())
                                            * Double.parseDouble(gcart.getPrice().toString())))));
                            gcart.setCount(CommUtil.null2Int(count));
                            goodsCartService.update(gcart);
                            gc1 = gcart;
                            scart.getGcs().remove(gcart);
                            scart.getGcs().add(gc1);
                            goods_total_price = Double.parseDouble(gc1.getPrice().toString()) * gc1.getCount();
                            this.storeCartService.update(scart);
                        }
                    }
                }
            } else {
                error = "200";
            }
        }

        if (cart_type.equals("combin")) {
            if (goods.getGoodsInventory() >= CommUtil.null2Int(count)) {
                for (ShoppingStorecart sscart : cart) {
                    for (int i = 0; i < sscart.getGcs().size(); i++) {
                        gc = sscart.getGcs().get(i);
                        ShoppingGoodscart gc1 = gc;
                        if (gc.getId().toString().equals(cart_id)) {
                            sscart.setTotalPrice(BigDecimal.valueOf(CommUtil.add(sscart.getTotalPrice(),
                                    Float.valueOf((CommUtil.null2Int(count) - gc.getCount())
                                            * CommUtil.null2Float(gc.getGoods().getCombinPrice())))));
                            gc.setCount(CommUtil.null2Int(count));
                            goodsCartService.update(gc);
                            gc1 = gc;
                            sscart.getGcs().remove(gc);
                            sscart.getGcs().add(gc1);
                            goods_total_price = Double.parseDouble(gc1.getPrice().toString()) * gc1.getCount();
                            this.storeCartService.update(sscart);
                        }
                    }
                }
            } else {
                error = "200";
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");
        JSONObject map = new JSONObject();
        map.put("count", count);
        for (ShoppingStorecart ssscart : cart) {
            if (ssscart.getStoreId().equals(CommUtil.null2Long(store_id))) {
                map.put("sc_total_price", Float.valueOf(CommUtil.null2Float(ssscart.getTotalPrice())));
            }
        }
        map.put("goods_total_price", Double.valueOf(df.format(goods_total_price)));
        map.put("error", error);
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();

            writer.print(map.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private List<ShoppingGoodsWithBLOBs> randomZtcGoods(List<ShoppingGoods> goods) {
        Random random = new Random();
        int random_num = 0;
        int num = 0;
        if (goods.size() - 8 > 0) {
            num = goods.size() - 8;
            random_num = random.nextInt(num);
        }
        Map ztc_map = new HashMap();
        ztc_map.put("ztc_status", Integer.valueOf(3));
        ztc_map.put("now_date", new Date());
        ztc_map.put("ztc_gold", Integer.valueOf(0));
        ztc_map.put("start", random_num);
        ztc_map.put("pageSize", 8);
        List<ShoppingGoodsWithBLOBs> ztc_goods = this.goodsService.queryByCondition(ztc_map);
        // accessoryViewTools.addZtcGoodsImg(ztc_goods);
        Collections.shuffle(ztc_goods);
        return ztc_goods;
    }
}
