package com.xdj.interfaces.mallinterface.controller.view;

import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.tools.CommUtil;
import com.xdj.www.entity.*;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Component
public class ViewTools {
    @Resource
    private NavViewTools navTools;
    @Resource
    private GoodsFloorTools gf_tools;
    @Resource
    private IGoodsFloorService goodsFloorService;
    @Resource
    private IMessageService messageService;
    @Resource
    private IStoreService storeService;
    @Resource
    private IUserService userService;
    @Resource
    private IStoreCartService storeCartService;
    @Resource
    private IGoodsCartService goodsCartService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private IGoodsClassService goodsClassService;
    @Resource
    private IAdvertService advertService;
    @Resource
    private IAdvertPositionService advertPositionService;
    @Resource
    private IVisitService visitService;
    @Resource
    private INavigationService navigationService;
    @Resource
    private IStoreNavigationService storeNavigationService;
    @Resource
    private IGroupAreaService groupAreaService;
    @Resource
    private GoodsCartTools goodsCartTools;
    @Resource
    private AccessoryViewTools accessViewTools;
    @Resource
    private ISpareGoodsService spareGoodsService;
    @Resource
    private IStoreClassService  storeClassService;
    @Resource
    private UserViewTools userViewTools;
    @Resource
    private StoreViewTools storeViewTools;


    public void store_left2(HttpServletRequest request, HttpServletResponse response) {
        //add_store_common_info(mv, store);

    }

    public ModelAndView homepage_visit(ModelAndView mv, Long uid) {
        ShoppingUser user = new ShoppingUser();
        if ((uid != null) && (!uid.equals(""))) {
            user = this.userService.getObjById(uid);
        }else {
            user = SecurityUserHolder.getCurrentUser();
        }
        mv.addObject("owner", user);
        Map map = new HashMap();
        map.put("uid", user.getId());
        map.put("orderBy","addTime");
        map.put("sort","desc");
        map.put("home_owner_id",user.getId());
        map.put("start",0);
        map.put("pageSize",10);
        List<ShoppingVisit> visits = this.visitService.queryByCondition(map);
        userViewTools.addVisitsUsers(visits,true);
        mv.addObject("visits", visits);
        return mv;
    }
    /**
     * 团购头部信息
     * @param mv
     * @param ga_id
     */
    public final void groupHead(ModelAndView mv, String ga_id) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parent_id", "is null");
        params.put("orderBy", "ga_sequence");
        params.put("sort", "asc");
        List<ShoppingGroupArea> gas = this.groupAreaService.queryByCondition(params);
        String[] str = CommUtil.splitByChar(((ShoppingSysconfig) mv.getModel().get("config")).getHotsearch(), ",");
        mv.addObject("searchs", str);
        mv.addObject("gas", gas);
        if ((ga_id != null) && (!ga_id.equals(""))) {
            mv.addObject("ga", this.groupAreaService.getObjById(CommUtil.null2Long(ga_id)).getGaName());
        } else {
            mv.addObject("ga", "全国");
        }
    }

    /**
     * 店铺的Nav信息
     * @param mv
     * @param request
     * @param store
     * @return
     */
    public ModelAndView store_nav(ModelAndView mv, HttpServletRequest request,ShoppingStoreWithBLOBs store) {
        if (store.getStoreStatus() == 2) {
            Map params = new HashMap();
            params.put("store_id", store.getId());
            params.put("display", 1);
            params.put("orderBy", "sequence");
            params.put("sort", "asc");
            List<ShoppingStoreNav> navs = this.storeNavigationService.queryByCondition(params);
            //query("select obj from StoreNavigation obj where obj.store.id=:store_id and obj.display=:display order by obj.sequence asc", params, -1, -1);
            mv.addObject("navs", navs);
            mv.addObject("storeNav", store);
            String goods_view = CommUtil.null2String(request.getAttribute("goods_view"));
            mv.addObject("goods_view", Boolean.valueOf(CommUtil.null2Boolean(goods_view)));
            mv.addObject("goods_id", CommUtil.null2String(request.getAttribute("goods_id")));
            mv.addObject("goods_list", Boolean.valueOf(CommUtil.null2Boolean(request.getAttribute("goods_list"))));
        } else {
            mv.addObject("op_title", "店铺信息错误");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }

    /**
     * 通用底部信息
     * @param mv
     */
    public void footerHandle(ModelAndView mv) {
        List<ShoppingNavigation> navs = navTools.queryNav(1, -1);
        mv.addObject("footer", navs);
    }

    /**
     * 处理商品楼层
     *
     * @param mv
     * @param request
     */
    public void handleFoor(ModelAndView mv, HttpServletRequest request) {
        Map params = new HashMap();
        params.put("gf_display", 1);
        params.put("parent_id", "is null");
        params.put("orderBy", "gf_sequence");
        params.put("sort", "asc");
        List<ShoppingGoodsFloorWithBLOBs> floors = this.goodsFloorService.queryByCondition(params);
        handleFloorChild(floors, request);
        mv.addObject("floors", floors);
    }

    /**
     * 处理商品楼层
     *
     * @param floors  集合
     * @param
     * @param request
     */
    public void handleFloorChild(List<ShoppingGoodsFloorWithBLOBs> floors, HttpServletRequest request) {
        if (floors != null) {
            for (ShoppingGoodsFloorWithBLOBs s : floors) {
                //获取楼层子目录
                Map params = new HashMap();
                params.put("gf_display", 1);
                params.put("parent_id", "= ".concat(s.getId().toString()));
                List<ShoppingGoodsFloorWithBLOBs> child = goodsFloorService.queryByCondition(params);
                if (child != null) {
                    s.setChilds(child);
                    for (ShoppingGoodsFloorWithBLOBs f : child) {
                        List<ShoppingGoodsWithBLOBs> goods = gf_tools.generic_goods(f.getGfGcGoods());
                        storeViewTools.addStoreGoodss(goods);
                        f.setGs(goods);
                    }
                }
                // 商品分类 以及商品子分类
                List<ShoppingGoodsclassWithBLOBs> gcs = this.gf_tools.generic_gf_gc(s.getGfGcList());
                s.setGcs(gcs);
                //左侧广告
                String url = CommUtil.getURL(request);
                ShoppingAccessory leftAdv = gf_tools.genericAdvert(url, s.getGfLeftAdv());
                s.setLeftAdv(leftAdv);
                //右侧广告
                ShoppingAccessory rightAdv = gf_tools.genericAdvert(url, s.getGfRightAdv());
                s.setRightAdv(rightAdv);
                //中间部分商品广告
                Map<String, Object> mmap = gf_tools.generic_goods_list(s.getGfListGoods());
                s.setGoodsMsg(mmap);
                //品牌
                List<ShoppingGoodsbrand> goodsbrands = this.gf_tools.generic_brand(s.getGfBrandList());
                s.setBrands(goodsbrands);
            }
        }
    }

    /**
     * 头部处理
     *
     * @param mv
     * @param request
     */
    public final void topHandle(ModelAndView mv, HttpServletRequest request) {
        List<ShoppingMessage> msgs = new ArrayList();
        if (SecurityUserHolder.getCurrentUser() != null) {
            Map params = new HashMap();
            params.put("status", Integer.valueOf(0));
            params.put("reply_status", Integer.valueOf(1));
            params.put("from_user_id", SecurityUserHolder.getCurrentUser().getId());
            params.put("to_user_id", SecurityUserHolder.getCurrentUser().getId());
            msgs = this.messageService.queryByCondition(params);
            //( "select obj from Message obj where obj.parent.id is null and (obj.status=:status and obj.toUser.id=:to_user_id) or (obj.reply_status=:reply_status and obj.fromUser.id=:from_user_id) ", params, -1, -1 );
        }
        ShoppingStore store = null;
        if (SecurityUserHolder.getCurrentUser() != null) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("user_id", SecurityUserHolder.getCurrentUser().getId());
            store = this.storeService.queryOne(map);
        }
        mv.addObject("store", store);
        mv.addObject("msgs", msgs);
        List<ShoppingGoodscart> list = new ArrayList<ShoppingGoodscart>();
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
                if (user.getStore() != null) {
                    params.clear();
                    params.put("cart_session_id", cart_session_id);
                    params.put("user_id", user.getId());
                    params.put("sc_status", Integer.valueOf(0));
                    params.put("store_id", user.getStore().getId());
                    List<ShoppingStorecart> store_cookie_cart = this.storeCartService.queryByCondition(params);
                    for (ShoppingStorecart sc : store_cookie_cart) {
                        for (ShoppingGoodscart gc : sc.getGcs()) {
                            gc.getGsps().clear();
                            this.goodsCartService.delete(gc.getId());
                        }
                        this.storeCartService.delete(sc.getId());
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
                //query( "select obj from StoreCart obj where obj.user.id=:user_id and obj.sc_status=:sc_status", params, -1, -1 );
            } else {
                params.clear();
                params.put("user_id", user.getId());
                params.put("sc_status", Integer.valueOf(0));
                user_cart = this.storeCartService.queryByCondition(params);
                //query( "select obj from StoreCart obj where obj.user.id=:user_id and obj.sc_status=:sc_status", params, -1, -1 );
            }

        } else if (!cart_session_id.equals("")) {
            params.clear();
            params.put("cart_session_id", cart_session_id);
            params.put("sc_status", Integer.valueOf(0));
            cookie_cart = this.storeCartService.queryByCondition(params);
            //query( "select obj from StoreCart obj where obj.cart_session_id=:cart_session_id and obj.sc_status=:sc_status", params, -1, -1 );
        }

        for (ShoppingStorecart sc : user_cart) {
            boolean sc_add = true;
            for (ShoppingStorecart sc1 : cart) {
                if (sc1.getStoreId().equals(sc.getStoreId())) {
                    sc_add = false;
                }
            }
            if (sc_add) {
                cart.add(sc);
            }
        }
        boolean sc_add;
        for (ShoppingStorecart sc : cookie_cart) {
            sc_add = true;
            for (ShoppingStorecart sc1 : cart) {
                if (sc1.getStoreId() != null) {
                    if (sc1.getStoreId().equals(sc.getStoreId())) {
                        sc_add = false;
                        sc1.setStore(storeService.getObjById(sc.getStoreId()));
                        goodsCartTools.addGcs(sc1);
                        if(sc1.getGcs() != null){
                            for (ShoppingGoodscart gc : sc1.getGcs()) {
                                gc.setSc(sc1);
                                this.goodsCartService.update(gc);
                            }
                        }

                        //this.storeCartService.delete(sc.getId());
                    }
                }
            }
            if (sc_add) {
                cart.add(sc);
            }
        }
        if (cart != null) {
            for (ShoppingStorecart sc : cart) {
                if (sc != null) {
                    Map<String, Object> parms = new HashMap<String, Object>();
                    parms.put("sc_id", sc.getId());
                    List<ShoppingGoodscart> carts = goodsCartService.queryByCondition(parms);
                    list.addAll(carts);
                }
            }
        }
        float total_price = 0.0F;
        for (ShoppingGoodscart gc : list) {
            ShoppingGoods goods = this.goodsService.getObjById(gc.getGoodsId());
            if (CommUtil.null2String(gc.getCartType()).equals("combin")) {
                total_price = CommUtil.null2Float(goods.getCombinPrice());
            } else {
                total_price = CommUtil.null2Float(Double.valueOf(CommUtil.mul(Integer.valueOf(gc.getCount()), goods.getGoodsCurrentPrice()))) + total_price;
            }
        }
        mv.addObject("total_price", Float.valueOf(total_price));
        mv.addObject("cart", list);
    }

    /**
     * 导航栏处理
     *
     * @param mv
     */
    public void navHandle(ModelAndView mv) {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("display", Boolean.valueOf(true));
        params.put("parent_id", "is null");
        params.put("orderBy", "sequence");
        params.put("sort", "asc");
        List<ShoppingGoodsclassWithBLOBs> gcs = this.goodsClassService.queryByCondition(params);
        if (gcs != null) {
            addGoodsclassChilds(gcs,true);
        }
        mv.addObject("gcs", gcs);
        navshandle(mv);
    }

    public void navshandle(ModelAndView mv) {
        List<ShoppingNavigation> navs = navTools.queryNav(0, 10);
        mv.addObject("navs", navs);
    }


    public final void addGoodsclassChilds(List<ShoppingGoodsclassWithBLOBs> gcs, boolean confirm) {
        if (gcs != null) {
            for (ShoppingGoodsclassWithBLOBs gc : gcs) {
                addGoodsClassChild(gc, confirm);
            }
        }
    }


    public final void addGoodsClassChild(ShoppingGoodsclassWithBLOBs gc, boolean confirm) {
        if (gc != null) {
            Map<String, Object> para = new HashMap<String, Object>();
            para.put("parent_id", "= ".concat(gc.getId().toString()));
            List<ShoppingGoodsclassWithBLOBs> child = goodsClassService.queryByCondition(para);
            if (confirm) {
                if (child != null) {
                    for (ShoppingGoodsclassWithBLOBs s : child) {
                        addGoodsClassChild(s);
                    }
                }
            }
            gc.setChilds(child);
        }
    }

    public final void addGoodsClassChild(ShoppingGoodsclassWithBLOBs gc) {
        if (gc != null) {
            Map<String, Object> para = new HashMap<String, Object>();
            para.put("parent_id", "= ".concat(gc.getId().toString()));
            List<ShoppingGoodsclassWithBLOBs> child = goodsClassService.queryByCondition(para);
            gc.setChilds(child);
        }
    }

    /**
     * 闲置商品首页处理
     *
     * @param mv
     */
    public final void sparegoodsNav2(ModelAndView mv) {
        if ((SecurityUserHolder.getCurrentUser() != null) && (!SecurityUserHolder.getCurrentUser().equals(""))) {
            Map params = new HashMap();
            params.put("status", Integer.valueOf(0));
            params.put("down", Integer.valueOf(0));
            params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
            List<ShoppingSpareGoodsWithBLOBs> sps = this.spareGoodsService.queryByCondition(params);
            params.clear();
            params.put("status", Integer.valueOf(-1));
            params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
            List<ShoppingSpareGoodsWithBLOBs> drops = this.spareGoodsService.queryByCondition(params);
            params.clear();
            params.put("down", Integer.valueOf(-1));
            params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
            List<ShoppingSpareGoodsWithBLOBs> down = this.spareGoodsService.queryByCondition(params);
            mv.addObject("selling", Integer.valueOf(sps.size()));
            mv.addObject("drops", Integer.valueOf(drops.size()));
            mv.addObject("down", Integer.valueOf(down.size()));
        }
        Map map = new HashMap();
        map.put("type", "sparegoods");
        map.put("display", Boolean.valueOf(true));
        map.put("orderBy", "sequence");
        map.put("sort", "asc");
        List navs = this.navigationService.queryByConditin(map);
        mv.addObject("navs", navs);

    }

    /**
     * 轮播处理
     *
     * @param mv
     * @param id
     * @param name
     */
    public void advertInvoke(ModelAndView mv, String id, String name) {
        if ((id != null) && (!id.equals(""))) {
            ShoppingAdvPosWithBLOBs ap = this.advertPositionService.getObjById(CommUtil.null2Long(id));
            if (ap != null) {
                if (ap.getApAccId() != null) {
                    accessViewTools.addPosImg(ap);
                }
                ap.getAdvId();
                Map para = new HashMap<String, Object>();
                para.put("ad_ap_id", ap.getId());
                para.put("startTime", new Date());
                para.put("endTime", new Date());
                para.put("start", 0);
                para.put("pageSize", 4);
                List<ShoppingAdvert> advs = advertService.queryByCondition(para);
                if (advs != null && advs.size() > 0) {
                    for (ShoppingAdvert s : advs) {
                        accessViewTools.addAdvertImg(s);
                    }
                    ap.setAdvs(advs);
                    if (ap.getApType().equals("text")) {
                        if (ap.getApShowType() == 0) {
                            ap.setApText(advs.get(0).getAdText());
                            ap.setApAccUrl(advs.get(0).getAdUrl());
                            ap.setAdvId(advs.get(0).getId());
                        }
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            int i = random.nextInt(advs.size());
                            ap.setApText(advs.get(i).getAdText());
                            ap.setApAccUrl(advs.get(i).getAdUrl());
                            ap.setAdvId(advs.get(i).getId());
                        }
                    }
                    if (ap.getApType().equals("img")) {
                        if (ap.getApShowType() == 0) {
                            ap.setApAcc(advs.get(0).getAdAcc());
                            ap.setApAccUrl(advs.get(0).getAdUrl());
                            ap.setAdvId(advs.get(0).getId());
                        }
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            int i = random.nextInt(advs.size());
                            ap.setApAcc(advs.get(i).getAdAcc());
                            ap.setApAccUrl(advs.get(i).getAdUrl());
                            ap.setAdvId(advs.get(i).getId());
                        }
                    }
                    Iterator localIterator2;
                    if (ap.getApType().equals("slide")) {

                        if (ap.getApShowType() == 0) {
                            ap.setAdvs(advs);
                        }
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 8);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer) localIterator2.next()).intValue();
                                ap.getAdvs().add(advs.get(i));
                            }
                        }
                    }
                    if (ap.getApType().equals("wapslide")) {
                        if (ap.getApShowType() == 0) {
                            ap.setAdvs(advs);
                        }
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 8);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer) localIterator2.next()).intValue();
                                ap.getAdvs().add(advs.get(i));
                            }
                        }
                    }
                    if (ap.getApType().equals("indexslide")) {
                        if (ap.getApShowType() == 0) {
                            ap.setAdvs(advs);
                        }
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 8);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer) localIterator2.next()).intValue();
                                ap.getAdvs().add(advs.get(i));
                            }
                        }
                    }
                    if (ap.getApType().equals("scroll")) {
                        if (ap.getApShowType() == 0) {
                            ap.setAdvs(advs);
                        }
                        if (ap.getApShowType() == 1) {
                            Random random = new Random();
                            Set list = CommUtil.randomInt(advs.size(), 12);
                            for (localIterator2 = list.iterator(); localIterator2.hasNext(); ) {
                                int i = ((Integer) localIterator2.next()).intValue();
                                ap.getAdvs().add(advs.get(i));
                            }
                        }
                    }
                } else {
                    ShoppingAdvert adv = new ShoppingAdvert();
                    adv.setAdUrl(ap.getApAccUrl());
                    adv.setAdAcc(ap.getApAcc());
                    ap.getAdvs().add(adv);
                }
                if (ap.getApStatus() == 1) {
                    mv.addObject(name, ap);
                } else {
                    mv.addObject(name, new ShoppingAdvPos());
                }
            }
        }
    }

    /**
     * 商品添加主图
     *
     * @param list
     */
    public void mainPhotoHandle(List<ShoppingGoodsWithBLOBs> list) {
        if (list != null) {
            for (ShoppingGoodsWithBLOBs s : list) {
                if (s.getGoodsMainPhotoId() != null) {
                    accessViewTools.addMainPhoto(s);
                }
            }
        }
    }


    /**
     * 添加主图
     *
     * @param dgs
     */
    public void addDeliveryGoods(List<ShoppingDeliveryGoods> dgs) {
        if (dgs != null) {
            for (ShoppingDeliveryGoods s : dgs) {
                if (s.getdGoodsId() != null) {
                    ShoppingGoodsWithBLOBs goods = goodsService.getObjById(s.getdGoodsId());
                    if (goods.getGoodsMainPhotoId() != null) {
                        accessViewTools.addMainPhoto(goods);
                    }
                    storeViewTools.addGoodsStore(goods);
                    s.setD_goods(goods);
                }
            }
        }
    }

    /**
     * head信息
     * @param mv
     * @param request
     */
    public void headHandle(ModelAndView mv, HttpServletRequest request) {
        String type = CommUtil.null2String(request.getAttribute("type"));
        mv.addObject("type", type.equals("") ? "goods" : type);
    }

    public void nav1Handle(ModelAndView mv) {
        Map params = new HashMap();
        params.put("display", Boolean.valueOf(true));
        params.put("orderBy", "sequence");
        params.put("sort", "asc");
        params.put("parent_id", "is null");
        params.put("start", 0);
        params.put("pageSize", 14);
        List<ShoppingGoodsclassWithBLOBs> gcs = this.goodsClassService.queryByCondition(params);
        addGoodsclassChilds(gcs, true);
        //query( "select obj from GoodsClass obj where obj.parent.id is null and obj.display=:display order by obj.sequence asc", params, 0, 14 );
        mv.addObject("navgcs", gcs);
        navshandle(mv);
    }

    /**
     * 广告图片简易处理
     */
    public ShoppingAdvPosWithBLOBs advPos(String id) {
            ShoppingAdvPosWithBLOBs advertPosition = advertPositionService.getObjById(CommUtil.null2Long(id));
            if (advertPosition != null) {
                if (advertPosition.getApAccId() != null) {
                    accessViewTools.addPosImg(advertPosition);
                }
            }
            return advertPosition;

    }

    public void storeHead(ModelAndView mv,ShoppingStoreWithBLOBs store) {
        generic_evaluate(store, mv);
        mv.addObject("headStore",store);
    }


    public void generic_evaluate(ShoppingStoreWithBLOBs store, ModelAndView mv) {
        double description_result = 0.0D;
        double service_result = 0.0D;
        double ship_result = 0.0D;
        if ((store != null) && (store.getScId() != null) && (store.getPoint() != null)) {
            ShoppingStoreclass sc = this.storeClassService.getObjById(store.getScId());
            float description_evaluate = CommUtil.null2Float(sc.getDescriptionEvaluate());
            float service_evaluate = CommUtil.null2Float(sc .getServiceEvaluate());
            float ship_evaluate = CommUtil.null2Float(sc.getShipEvaluate());
            float store_description_evaluate = CommUtil.null2Float(store.getPoint().getDescriptionEvaluate());
            float store_service_evaluate = CommUtil.null2Float(store.getPoint().getServiceEvaluate());
            float store_ship_evaluate = CommUtil.null2Float(store.getPoint() .getShipEvaluate());

            description_result = CommUtil.div(Float.valueOf(store_description_evaluate -
                    description_evaluate), Float.valueOf(description_evaluate));
            service_result = CommUtil.div(Float.valueOf(store_service_evaluate -
                    service_evaluate), Float.valueOf(service_evaluate));
            ship_result = CommUtil.div(Float.valueOf(store_ship_evaluate - ship_evaluate),
                    Float.valueOf(ship_evaluate));
        }
        if (description_result > 0.0D) {
            mv.addObject("description_css", "better");
            mv.addObject("description_type", "高于");
            mv.addObject("description_result",
                    CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(description_result), Integer.valueOf(100)) > 100.0D ? 100.0D :
                            CommUtil.mul(Double.valueOf(description_result), Integer.valueOf(100)))) +
                            "%");
        }
        if (description_result == 0.0D) {
            mv.addObject("description_css", "better");
            mv.addObject("description_type", "持平");
            mv.addObject("description_result", "-----");
        }
        if (description_result < 0.0D) {
            mv.addObject("description_css", "lower");
            mv.addObject("description_type", "低于");
            mv.addObject(
                    "description_result",
                    CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(-description_result), Integer.valueOf(100)))) +
                            "%");
        }
        if (service_result > 0.0D) {
            mv.addObject("service_css", "better");
            mv.addObject("service_type", "高于");
            mv.addObject("service_result",
                    CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(service_result), Integer.valueOf(100)))) +
                            "%");
        }
        if (service_result == 0.0D) {
            mv.addObject("service_css", "better");
            mv.addObject("service_type", "持平");
            mv.addObject("service_result", "-----");
        }
        if (service_result < 0.0D) {
            mv.addObject("service_css", "lower");
            mv.addObject("service_type", "低于");
            mv.addObject("service_result",
                    CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(-service_result), Integer.valueOf(100)))) +
                            "%");
        }
        if (ship_result > 0.0D) {
            mv.addObject("ship_css", "better");
            mv.addObject("ship_type", "高于");
            mv.addObject("ship_result",
                    CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(ship_result), Integer.valueOf(100)))) + "%");
        }
        if (ship_result == 0.0D) {
            mv.addObject("ship_css", "better");
            mv.addObject("ship_type", "持平");
            mv.addObject("ship_result", "-----");
        }
        if (ship_result < 0.0D) {
            mv.addObject("ship_css", "lower");
            mv.addObject("ship_type", "低于");
            mv.addObject("ship_result",CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(-ship_result), Integer.valueOf(100)))) + "%");
        }
    }
}
