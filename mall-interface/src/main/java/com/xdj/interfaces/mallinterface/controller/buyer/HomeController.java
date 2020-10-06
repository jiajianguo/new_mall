package com.xdj.interfaces.mallinterface.controller.buyer;

import com.xdj.interfaces.mallinterface.controller.view.*;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;

import com.xdj.www.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * @author Administrator
 */
@RestController
public class HomeController{
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IUserService userService;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private IVisitService visitService;
    @Resource
    private IHomePageService homePageService;
    @Resource
    private IDynamicService dynamicService;
    @Resource
    private ISnsAttentionService attentionService;
    @Resource
    private ISnsFriendService snsFriendService;
    @Autowired
    private IFavoriteService favoriteService;
    @Resource
    private IOrderFormService orderFormService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private ICouponInfoService couponInfoService;
    @Resource
    private StoreViewTools storeViewTools;
    @Resource
    private DynamicViewTools dynamicViewTools;
    @Resource
    private ViewTools  viewTools;
    @Resource
    private UserViewTools userViewTools;
    @Resource
    private IHomePageGoodsClassService homeGoodsClassService;
    @Resource
    private AccessoryViewTools accessoryViewTools;

    @RequestMapping({"/member_center.htm"})
    public  ModelAndView app_member_center(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView("wap/member_center.html",this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        //获取未支付订单数量
        Map<String,Object> params = new HashMap<>();
        params.put("orderBy","addTime");
        params.put("sort","desc");
        params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
        params.put("order_status",10);
        int waitingPay  = this.orderFormService.count(params);
        params.put("order_status",20);
        int waitingSend  = this.orderFormService.count(params);
        params.put("order_status",30);
        int waitingDeli  = this.orderFormService.count(params);
        params.put("order_status",40);
        int waitingEval  = this.orderFormService.count(params);
        ShoppingUser user=SecurityUserHolder.getCurrentUser();
        ShoppingCouponInfoExample example= new ShoppingCouponInfoExample();
        example.createCriteria()
                .andUserIdEqualTo(user.getId())
                .andStatusEqualTo(1);
        //优惠券数量
        long coupons = couponInfoService.countByExample(example);
        mv.addObject("waitingPay",waitingPay);
        mv.addObject("waitingSend",waitingSend);
        mv.addObject("waitingEval",waitingEval);
        mv.addObject("waitingDeli",waitingDeli);
        mv.addObject("coupons",coupons);
        accessoryViewTools.addUserHeadImg(user);
        mv.addObject("user",user);
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="个人主页头部", value="/buyer/homepage_head.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_head.htm"})
    public ModelAndView homepage_head(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new JModelAndView(
                "buyer/homepage_head.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        String uid = request.getParameter("uid");
        ShoppingUser user = new ShoppingUser();
        if ((uid != null) && (!uid.equals(""))) {
            user = this.userService.getObjById(CommUtil.null2Long(uid));
        }else {
            user = SecurityUserHolder.getCurrentUser();
        }
        mv.addObject("owner", user);
        Map map = new HashMap();
        map.put("owner_id", user.getId());
        List HomePages = this.homePageService.queryByCondition(map);
                //.query("select obj from HomePage obj where obj.owner.id=:uid", map, -1, -1);
        if (HomePages.size() > 0) {
            mv.addObject("homePage", HomePages.get(0));
        }
        map.clear();
        map.put("toUser_id", user.getId());
        List fans = this.attentionService.queryByCondition(map);
                //.query("select obj from SnsAttention obj where obj.toUser.id=:uid", map, -1, -1);
        map.clear();
        map.put("fromUser_id", user.getId());
        List attentions = this.attentionService.queryByCondition(map);
                //.query("select obj from SnsAttention obj where obj.fromUser.id=:uid", map, -1, -1);
        mv.addObject("attentions_num", Integer.valueOf(attentions.size()));
        mv.addObject("fans_num", Integer.valueOf(fans.size()));
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="个人主页", value="/buyer/homepage.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage.htm"})
    public ModelAndView homepage(HttpServletRequest request, HttpServletResponse response, String type, String currentPage, String orderBy, String orderType, String uid, String goodclass_id) {
        ModelAndView mv = new JModelAndView("buyer/homepage.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingHomepage home = new ShoppingHomepage();
        ShoppingUser user = new ShoppingUser();
        if ((uid != null) && (!uid.equals(""))){
            user = this.userService.getObjById(CommUtil.null2Long(uid));
        }else {
            user = SecurityUserHolder.getCurrentUser();
        }
        mv.addObject("owner", user);
        Map map = new HashMap();
        map.put("owner_id", user.getId());
        List<ShoppingHomepage> homePages = this.homePageService.queryByCondition(map);
                //query("select obj from HomePage obj where obj.owner.id=:uid", map,1, -1);
        if (homePages.size() > 0) {
            home =homePages.get(0);
        } else {
            home.setOwnerId(SecurityUserHolder.getCurrentUser().getId());
            home.setAddtime(new Date());
            home.setDeletestatus(false);
            this.homePageService.save(home);
        }
        Map<String,Object> params = new HashMap<>();
        params.put("orderBy",orderBy);
        params.put("sort",orderType);
        params.put("display",true);
        if ((type != null) && (!type.equals(""))) {
            mv.addObject("type", type);
            if (type.equals("1")) {
                params.put("user_id",home.getOwnerId());
                params.put("store_id","is not null");
                Map maps = new HashMap();
                maps.put("user_id", home.getOwnerId());
                maps.put("store_id", "is not null");
                List<ShoppingDynamic> dynamics = this.dynamicService.pageList(maps);
                if (dynamics.size() > 0) {
                    mv.addObject("allNum", Integer.valueOf(CommUtil.null2Int(Integer.valueOf(dynamics.size()))));
                }
            }
            if (type.equals("2")) {
                params.put("user_id",home.getOwnerId());
                params.put("store_id","is not null");
                params.put("goods_id","is not null");
                params.put("dissParent_id","is not null");
                Map maps = new HashMap();
                maps.put("user_id", home.getOwnerId());
                List dynamics = this.dynamicService.pageList(maps);
                if (dynamics.size() > 0){
                    mv.addObject("allNum", dynamics.size());
                }
            }
        }else {
            params.put("user_id",home.getOwnerId());
            params.put("goods_id","is not null");
            Map maps = new HashMap();
            maps.put("user_id", home.getOwnerId());
            List<ShoppingDynamic> dynamics = this.dynamicService.pageList(maps);
            //("select obj from Dynamic obj where obj.goods.id is not null and obj.user.id=:uid", params, -1, -1);
            if (dynamics.size() > 0) {
                mv.addObject("allNum", dynamics.size());
            }
            if ((goodclass_id != null) && (!goodclass_id.equals(""))) {
                mv.addObject("goodclass_id", goodclass_id);
                params.put("goodClass_id",CommUtil.null2Long(goodclass_id));
                //qo.addQuery("obj.goods.gc.id",new SysMap("goodClass_id",CommUtil.null2Long(goodclass_id)), "=");
            }

            maps.clear();
            maps.put("user_id", home.getOwnerId());
            List<ShoppingHomepageGoodsclass> hgcs = this.homeGoodsClassService.queryByCondition(params);
                    //.query("select obj from HomePageGoodsClass obj where obj.user.id=:uid ",params, -1, -1);

            mv.addObject("hgcs", hgcs);
        }

        if ((uid != null) && (!uid.equals(""))) {
            //修改信息
            List<ShoppingVisit> custs = home.getCustomers();
            if (custs.size() == 0) {
                ShoppingVisit visit = new ShoppingVisit();
                visit.setAddtime(new Date());
                visit.setHomepageId(home.getId());
                visit.setUserId(SecurityUserHolder.getCurrentUser().getId());
                this.visitService.save(visit);
            } else {
                map.clear();
                map.put("home_owner_id", home.getOwnerId());
                map.put("user_id", SecurityUserHolder.getCurrentUser().getId());
                List<ShoppingVisit> visits = this.visitService.queryByCondition(map);
                        //.query( "select obj from Visit obj where obj.user.id=:uid and obj.homepage.owner.id=:home_owner_id", map, -1, -1);
                if (visits.size() > 0) {
                    visits.get(0).setAddtime(new Date());
                    this.visitService.update(visits.get(0));
                } else {
                    ShoppingVisit visit = new ShoppingVisit();
                    visit.setAddtime(new Date());
                    visit.setHomepageId(home.getId());
                    visit.setUserId(SecurityUserHolder.getCurrentUser().getId());
                    this.visitService.save(visit);
                }
            }
        }
        map.clear();
        map.put("user_id", home.getOwnerId());
        map.put("orderBy","addTime");
        map.put("sort","desc");
        int pageNow = 1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow = Integer.parseInt(currentPage);
        }
        map.put("start",(pageNow-1)*10);
        map.put("pageSize",10);
        List visits = this.visitService.queryByCondition(map);
                //query("select obj from Visit obj where obj.homepage.owner.id=:uid order by addTime desc",map, -1, 10);
        mv.addObject("visits", visits);
        List<ShoppingDynamic> pList = this.dynamicService.pageList(params);
        if(pList != null && pList.size() >0){
            int count =  this.dynamicService.count(params);
            storeViewTools.addDynamicStores(pList);
            goodsViewTools.addDynamicGoods(pList);
            dynamicViewTools.addChilds(pList,true);
            PageModel page = new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            page.setPageSize(10);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        viewTools.homepage_visit(mv,user.getId());
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="个人主页删除动态", value="/buyer/homepage_dynamic_del.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_dynamic_del.htm"})
    public void homepage_dynamic_del(HttpServletRequest request, HttpServletResponse response, String id, String currentPage, String orderBy, String orderType, String type) {
        boolean flag = false;
        if ((id != null) && (!id.equals(""))) {
            ShoppingDynamic dynamic = this.dynamicService.getObjById(Long.valueOf(Long.parseLong(id)));
            flag = this.dynamicService.delete(Long.valueOf(Long.parseLong(id)));
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try{
            PrintWriter writer = response.getWriter();
            writer.print(flag);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SecurityMapping(display = false, rsequence = 0, title="个人主页新鲜事加密", value="/buyer/homepage_dynamic_lock.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_dynamic_lock.htm"})
    public void homepage_dynamic_lock(HttpServletRequest request, HttpServletResponse response, String dynamic_id){
        ShoppingDynamic dynamic = this.dynamicService.getObjById(
                CommUtil.null2Long(dynamic_id));
        boolean locked = dynamic.getLocked();
        if (!locked){
            dynamic.setLocked(true);
        }else {
            dynamic.setLocked(false);
        }
        this.dynamicService.update(dynamic);
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(dynamic.getLocked());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SecurityMapping(display = false, rsequence = 0, title="个人主页添加关注", value="/buyer/homepage_add_attention.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_add_attention.htm"})
    public void homepage_add_attention(HttpServletRequest request, HttpServletResponse response, String user_id) {
        boolean flag = false;
        Map params = new HashMap();
        params.put("fromUser_id", SecurityUserHolder.getCurrentUser().getId());
        params.put("toUser_id", CommUtil.null2Long(user_id));
        List SnsAttentions = this.attentionService.queryByCondition(params);
                //query("select obj from SnsAttention obj where obj.fromUser.id=:uid and obj.toUser.id=:user_id ",params, -1, -1);
        if (SnsAttentions.size() == 0) {
            ShoppingUser atted = this.userService.getObjById(CommUtil.null2Long(user_id));
            ShoppingUserAttention attention = new ShoppingUserAttention();
            attention.setAddtime(new Date());
            attention.setFromuserId(SecurityUserHolder.getCurrentUser().getId());
            attention.setTouserId(atted.getId());
            flag = this.attentionService.save(attention);
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(flag);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }


    @SecurityMapping(display = false, rsequence = 0, title="个人主页添加关注", value="/buyer/homepage_remove_attention.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_remove_attention.htm"})
    public void homepage_remove_attention(HttpServletRequest request, HttpServletResponse response, String id) {
        boolean flag = false;
        flag = this.attentionService.delete(CommUtil.null2Long(id));
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(flag);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SecurityMapping(display = false, rsequence = 0, title="好友列表", value="/buyer/homepage/myfriends.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage/myfriends.htm"})
    public ModelAndView homepage_myfriends(HttpServletRequest request, HttpServletResponse response, String uid, String currentPage, String orderBy, String orderType) {
        ModelAndView mv = new JModelAndView("buyer/homepage_myfriends.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> params =new HashMap<>();
        params.put("orderBy",orderBy);
        params.put("sort",orderType);
        ShoppingUser user = new ShoppingUser();
        if ((uid != null) && (!uid.equals(""))) {
            user = this.userService.getObjById(CommUtil.null2Long(uid));
        }else {
            user = SecurityUserHolder.getCurrentUser();
        }
        mv.addObject("owner", user);
        params.put("fromUser_id",  user.getId());
        List<ShoppingUserFriend> pList = this.snsFriendService.queryByCondition(params);
        userViewTools.addFriendUsers(pList);
        if(pList != null){
            PageModel page = new PageModel();
            page.setResult(pList);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="关注列表", value="/buyer/homepage/myattention.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage/myattention.htm"})
    public ModelAndView homepage_myattention(HttpServletRequest request, HttpServletResponse response, String uid, String currentPage, String orderBy, String orderType){
        ModelAndView mv = new JModelAndView("buyer/homepage_myattention.html",
                this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> params =new HashMap<>();
        params.put("orderBy",orderBy);
        params.put("sort",orderType);
        ShoppingUser user = new ShoppingUser();
        if ((uid != null) && (!uid.equals(""))) {
            user = this.userService.getObjById(CommUtil.null2Long(uid));
        }else {
            user = SecurityUserHolder.getCurrentUser();
        }
        mv.addObject("owner", user);
        params.put("fromUser_id",  user.getId());
        List<ShoppingUserFriend> pList = this.snsFriendService.queryByCondition(params);
        userViewTools.addFriendUsers(pList);
        if(pList != null){
            PageModel page = new PageModel();
            page.setResult(pList);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="关注列表", value="/buyer/homepage/myfans.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage/myfans.htm"})
    public ModelAndView homepage_myfans(HttpServletRequest request, HttpServletResponse response, String uid, String currentPage, String orderBy, String orderType){
        ModelAndView mv = new JModelAndView("buyer/homepage_myfans.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> params =new HashMap<>();
        params.put("orderBy",orderBy);
        params.put("sort",orderType);
        ShoppingUser user = new ShoppingUser();
        if ((uid != null) && (!uid.equals(""))) {
            user = this.userService.getObjById(CommUtil.null2Long(uid));
        }else {
            user = SecurityUserHolder.getCurrentUser();
        }
        mv.addObject("owner", user);
        params.put("toUser_id", user.getId());
        List<ShoppingUserFriend> pList = this.snsFriendService.queryByCondition(params);
        userViewTools.addFriendUsers(pList);
        if(pList != null){
            PageModel page = new PageModel();
            page.setResult(pList);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="最近访客", value="/buyer/homepage_visit.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_visit.htm"})
    public ModelAndView homepage_visit(HttpServletRequest request, HttpServletResponse response, String orderBy, String orderType, String currentPage){
        ModelAndView mv = new JModelAndView(
                "buyer/homepage_visit.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        String uid = request.getParameter("uid");
        ShoppingUser user = new ShoppingUser();
        if ((uid != null) && (!uid.equals(""))) {
            user = this.userService.getObjById(CommUtil.null2Long(uid));
        }else {
            user = SecurityUserHolder.getCurrentUser();
        }
        mv.addObject("owner", user);
        Map map = new HashMap();
        map.put("uid", user.getId());
        List visits = this.visitService.queryByCondition(map);
                //query("select obj from Visit obj where obj.homepage.owner.id=:uid order by addTime desc",map, -1, 10);
        mv.addObject("visits", visits);
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="删除访客ajax", value="/buyer/homepage_visit_dele.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_visit_dele.htm"})
    public void homepage_visit_dele(HttpServletRequest request, HttpServletResponse response, String visit_id){
        boolean flag = false;
        Map params = new HashMap();
        params.put("custom_id", CommUtil.null2Long(visit_id));
        params.put("uid", SecurityUserHolder.getCurrentUser().getId());
        List<ShoppingVisit> customer = this.visitService.queryByCondition(params);
                //.query("select obj from Visit obj where obj.user.id=:custom_id and obj.homepage.owner.id=:uid",params, -1, -1);
        if (customer.size() > 0) {
            flag = this.visitService.delete(customer.get(0).getId());
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(flag);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SecurityMapping(display = false, rsequence = 0, title="查询已经购买宝贝和已经收藏宝贝", value="/buyer/homepage_query_*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_query_"})
    public ModelAndView homepage_query_goods(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView(
                "buyer/homepage_query_goods.html",
                this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        int fcount = 0;
        int ocount = 0;
        Map map = new HashMap();
        map.put("uid", SecurityUserHolder.getCurrentUser().getId());
        map.put("type", Integer.valueOf(0));
        List<ShoppingFavorite> favorites = this.favoriteService.queryByCondition(map);
                //.query("select obj from Favorite obj where obj.user.id=:uid and obj.type=:type order by addTime desc", map, fcount, 7);
        map.clear();
        map.put("uid", SecurityUserHolder.getCurrentUser().getId());
        map.put("type", Integer.valueOf(0));
        List<ShoppingFavorite> Allfavorites = this.favoriteService.queryByCondition(map);
                //.query( "select obj from Favorite obj where obj.user.id=:uid and obj.type=:type order by addTime desc", map, -1, -1);
        mv.addObject("favorites", favorites);
        map.clear();
        map.put("uid", SecurityUserHolder.getCurrentUser().getId());
        map.put("order_status", Integer.valueOf(50));
        List<ShoppingOrderform> orders = this.orderFormService.pageList(map);
                //.query("select obj from OrderForm obj where obj.user.id=:uid and obj.order_status=:order_status order by finishTime desc" map, ocount, 7);
        map.clear();
        map.put("uid", SecurityUserHolder.getCurrentUser().getId());
        map.put("order_status", Integer.valueOf(50));
        List Allorders = this.orderFormService.pageList(map);
                //.query( "select obj from OrderForm obj where obj.user.id=:uid and obj.order_status=:order_status order by finishTime desc",
                       // map, -1, -1);
        mv.addObject("favorite_Allsize", Integer.valueOf(Allfavorites.size()));
        mv.addObject("order_Allsize", Integer.valueOf(Allorders.size()));
        mv.addObject("orders", orders);
        mv.addObject("fcurrentCount", Integer.valueOf(fcount));
        mv.addObject("ocurrentCount", Integer.valueOf(ocount));
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="查询收藏宝贝ajax分页", value="/buyer/homepage_query_goods_favorite_ajax.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_query_goods_favorite_ajax.htm"})
    public ModelAndView homepage_query_goods_favorite_ajax(HttpServletRequest request, HttpServletResponse response, String fcurrentCount){
        ModelAndView mv = new JModelAndView(
                "buyer/homepage_query_goods_favorite_ajax.html",
                this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        int fcount = 0;
        if ((fcurrentCount != null) && (!fcurrentCount.equals(""))) {
            fcount = CommUtil.null2Int(fcurrentCount);
        }
        Map map = new HashMap();
        map.put("uid", SecurityUserHolder.getCurrentUser().getId());
        map.put("type", Integer.valueOf(0));
        List favorites = this.favoriteService.queryByCondition(map);
                //.query("select obj from Favorite obj where obj.user.id=:uid and obj.type=:type order by addTime desc",map, fcount, 7);
        mv.addObject("favorites", favorites);
        mv.addObject("fcurrentCount", Integer.valueOf(fcount));
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="查询已经购买宝贝ajax分页", value="/buyer/homepage_query_goods_order_ajax.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_query_goods_order_ajax.htm"})
    public ModelAndView homepage_query_goods_order_ajax(HttpServletRequest request, HttpServletResponse response, String ocurrentCount){
        ModelAndView mv = new JModelAndView(
                "buyer/homepage_query_goods_order_ajax.html",
                this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        int ocount = 0;
        if ((ocurrentCount != null) && (!ocurrentCount.equals(""))) {
            ocount = CommUtil.null2Int(ocurrentCount);
        }
        Map map = new HashMap();
        map.put("uid", SecurityUserHolder.getCurrentUser().getId());
        map.put("order_status", Integer.valueOf(50));
        List orders = this.orderFormService.pageList(map);
                //.query(  "select obj from OrderForm obj where obj.user.id=:uid and obj.order_status=:order_status order by finishTime desc",
                 //       map, ocount, 7);
        mv.addObject("orders", orders);
        mv.addObject("ocurrentCount", Integer.valueOf(ocount));
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="查询已经", value="/buyer/homepage_query_stores.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_query_stores.htm"})
    public ModelAndView homepage_query_stores(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new JModelAndView(
                "buyer/homepage_query_stores.html",
                this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        int currentCount = 0;
        Map map = new HashMap();
        map.put("uid", SecurityUserHolder.getCurrentUser().getId());
        map.put("type", Integer.valueOf(1));
        List favorites = this.favoriteService.queryByCondition(map);
               // .query( "select obj from Favorite obj where obj.user.id=:uid and obj.type=:type order by addTime desc",
                  //      map, currentCount, 7);
        map.clear();
        map.put("uid", SecurityUserHolder.getCurrentUser().getId());
        map.put("type", Integer.valueOf(1));
        List Allfavorites = this.favoriteService.queryByCondition(map);
               // .query( "select obj from Favorite obj where obj.user.id=:uid and obj.type=:type order by addTime desc",
                       // map, -1, -1);
        mv.addObject("favorites", favorites);
        mv.addObject("favorite_Allsize", Integer.valueOf(Allfavorites.size()));
        mv.addObject("currentCount", Integer.valueOf(currentCount));
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="查询已关注店铺ajax分页", value="/buyer/homepage_query_stores_ajax.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_query_stores_ajax.htm"})
    public ModelAndView homepage_query_stores_ajax(HttpServletRequest request, HttpServletResponse response, String currentCount){
        ModelAndView mv = new JModelAndView(
                "buyer/homepage_query_stores_ajax.html",
                this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        int count = 0;
        if ((currentCount != null) && (!currentCount.equals(""))) {
            count = CommUtil.null2Int(currentCount);
        }
        Map map = new HashMap();
        map.put("uid", SecurityUserHolder.getCurrentUser().getId());
        map.put("type", Integer.valueOf(1));
        List<ShoppingFavorite> favorites = this.favoriteService.queryByCondition(map);
                /*.query(
                        "select obj from Favorite obj where obj.user.id=:uid and obj.type=:type order by addTime desc",
                        map, count, 7);*/
        mv.addObject("favorites", favorites);
        mv.addObject("currentCount", Integer.valueOf(count));
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="个人主页添加关注", value="/buyer/homepage_goods_url_add.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/homepage_goods_url_add.htm"})
    public void homepage_goods_url_add(HttpServletRequest request, HttpServletResponse response, String url){
        boolean flag = true;
        ShoppingGoodsWithBLOBs goods = null;
        String str = null;
        String address = CommUtil.getURL(request) + "/goods";
        String[] urls = url.split("_");
        if (urls.length == 2) {
            if (!address.equals(urls[0])) {
                flag = false;
            }
            String[] ids = urls[1].split("\\.");
            if (ids.length == 2) {
                if (!ids[1].equals("htm")) {
                    flag = false;
                }
                if (flag) {
                    goods = this.goodsService.getObjById(
                            CommUtil.null2Long(ids[0]));
                }
            }
        }
        if (goods != null) {
            String img_url = CommUtil.getURL(request) + "/" +
                    goods.getGoods_main_photo().getPath() + "/" +
                    goods.getGoods_main_photo().getName() + "_small" + "." +
                    goods.getGoods_main_photo().getExt();
            str = img_url + "," + goods.getId();
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(str);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
