package com.xdj.interfaces.mallinterface.controller.buyer;

import com.xdj.interfaces.mallinterface.controller.view.*;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.query.IPageList;
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
import java.io.PrintWriter;
import java.util.*;

/**
 * @author Administrator
 */

@RestController
public class BuyerController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IMessageService messageService;
    @Resource
    private IDynamicService dynamicService;
    @Resource
    private ISnsFriendService snsFriendService;
    @Resource
    private ISnsAttentionService snsAttentionService;
    @Resource
    private IHomePageGoodsClassService homeGoodsClassService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private StoreViewTools storeViewTools;
    @Resource
    private OrderViewTools orderViewTools;
    @Resource
    private ViewTools viewTools;
    @Resource
    private UserViewTools userViewTools;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private DynamicViewTools dynamicViewTools;
    @Resource
    private IFavoriteService favoriteService;
    @Resource
    private  IUserService userService;
    @Resource
    private IStoreService storeService;

    @SecurityMapping(display = false, rsequence = 0, title="ajax回复保存方法", value="/buyer/dynamic_ajax_reply.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/dynamic_ajax_reply.htm"})
    public ModelAndView dynamic_ajax_reply(HttpServletRequest request, HttpServletResponse response, String parent_id, String fieldName, String reply_content)
            throws ClassNotFoundException{
        ModelAndView mv = new JModelAndView("buyer/dynamic_childs_list.html",
                this.configService.getSysConfig(), this.userConfigService
                .getUserConfig(), 0, request, response);

        ShoppingDynamic dynamic =new ShoppingDynamic();
        ShoppingDynamic parent = null;
        if ((parent_id != null) && (!parent_id.equals(""))) {
            parent = this.dynamicService.getObjById(Long.valueOf(Long.parseLong(parent_id)));
            dynamic.setDissparentId(CommUtil.null2Long(request.getParameter("parent_id")));
            this.dynamicService.update(parent);
            //dynamic.setDissParent(parent);
        }
        dynamic.setAddtime(new Date());
        dynamic.setUser(SecurityUserHolder.getCurrentUser());
        dynamic.setContent(reply_content);
        dynamic.setDeletestatus(false);
        this.dynamicService.save(dynamic);
        mv.addObject("obj", parent);
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="买家中心", value="/*", rtype="buyer", rname="买家中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"buyer/index.htm"})
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType, String type){
        ModelAndView mv = new JModelAndView("buyer/buyer_index.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        List msgs = new ArrayList();
        if (SecurityUserHolder.getCurrentUser() != null) {
            Map params = new HashMap();
            params.put("status", Integer.valueOf(0));
            params.put("to_user_id", SecurityUserHolder.getCurrentUser().getId());
            params.put("parent_id", "is null");
            msgs = this.messageService.queryByCondition(params);
        }
        mv.addObject("msgs", msgs);
        Map<String,Object> params = new HashMap<>();

        int pageNow =1;

        if(StringUtils.isNotBlank(currentPage)){
            pageNow = Integer.parseInt(currentPage);
        }

        params.put("start",(pageNow-1)*10);
        params.put("pageSize",10);
        params.put("display",true);
        if ((type == null) || (type.equals(""))) {
            type = "2";
        }

        if (type.equals("1")) {
            //qo.addQuery("obj.user.id",new SysMap("uid",SecurityUserHolder.getCurrentUser().getId()), "=");
            params.put("user_id",SecurityUserHolder.getCurrentUser().getId());
        }

        if (type.equals("2")) {
            Map<String,Object> map = new HashMap();
            map.put("fromUser_id", SecurityUserHolder.getCurrentUser().getId());
            List<ShoppingUserFriend> myFriends = this.snsFriendService.queryByCondition(map);
            List<Long> ids = getSnsFriendToUserIds(myFriends);
            Map paras = new HashMap();
            paras.put("ids", null);
            if (myFriends.size() > 0) {
                paras.put("ids", ids);
            }
            params.put("to_user_ids",ids);
        }

        if (type.equals("3")) {
            Map map = new HashMap();
            map.put("fromUser_id", SecurityUserHolder.getCurrentUser().getId());
            List<ShoppingUserAttention> SnsAttentions = this.snsAttentionService.queryByCondition(map);
            Set ids = getSnsAttentionToUserIds(SnsAttentions);
            if ((ids != null) && (ids.size() > 0)) {
                params.put("to_user_ids",ids);
            }
        }

        if (type.equals("4")) {
            params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
            params.put("store_id", "is not null");
        }

        params.put("locked", false);
        params.put("dissParent_id","is null");
        params.put("orderBy","addTime");
        params.put("sort","desc");
        List<ShoppingDynamic> pList = this.dynamicService.pageList(params);
        if(pList != null){
            userViewTools.addDynamicUsers(pList,true);
            storeViewTools.addDynamicStores(pList);
            goodsViewTools.addDynamicGoods(pList);
            dynamicViewTools.addChilds(pList,true);
            PageModel page = new PageModel();
            page.setResult(pList);
            int count = dynamicService.count(params);
            page.setCurrentPage(pageNow);
            page.setRowCount(count);
            page.setPages(count/10);
            page.setPageSize(10);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }

        List list = new ArrayList();
        for (int i = 1; i <= 120; i++) {
            list.add(Integer.valueOf(i));
        }
        mv.addObject("type", type);
        mv.addObject("emoticons", list);
        mv.addObject("order_submit",orderViewTools.query_user_order("order_submit"));
        mv.addObject("order_shipping",orderViewTools.query_user_order("order_shipping"));
        mv.addObject("order_receive",orderViewTools.query_user_order("order_receive"));
        handle(mv,SecurityUserHolder.getCurrentUser().getId());
        viewTools.topHandle(mv,request);
        viewTools.footerHandle(mv);
        return mv;
    }


    public final void handle(ModelAndView mv,Long userId){
        int credit =storeViewTools.generic_user_credit(userId);
        String creditsImg= "";
        if(0< credit && credit <10){
            credit = credit/2 +1;
            creditsImg="/style/common/images/level_0.gif";
        }
        if(credit >= 10 && credit < 20){
            credit = (credit-10)/2 +1;
            creditsImg="/style/common/images/level_1.gif";
        }
        if(credit >= 20){
            credit = (credit-20)/2 +1;
            creditsImg="/style/common/images/level_2.gif";
        }
        if(credit > 5 ){
            credit =5;
        }
        List<Integer> credits= new ArrayList();
        int counts =0;
        for(int i=0;i< credit;i++){
            credits.add(counts+1);
        }
        mv.addObject("creditsImg",creditsImg);
        mv.addObject("credit",credit);
        mv.addObject("credits",credits);
    }

    private List<Long> getSnsFriendToUserIds(List<ShoppingUserFriend> myfriends) {
        List ids = new ArrayList();
        if (myfriends.size() > 0) {
            for (ShoppingUserFriend friend : myfriends) {
                ids.add(friend.getTouserId());
            }
        }
        return ids;
    }

    private Set<Long> getSnsAttentionToUserIds(List<ShoppingUserAttention> SnsAttentions) {
        Set ids = new HashSet();
        for (ShoppingUserAttention attention : SnsAttentions) {
            ids.add(attention.getTouserId());
        }
        return ids;
    }

    @SecurityMapping(display = false, rsequence = 0, title="动态发布保存", value="/buyer/dynamic_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/dynamic_save.htm"})
    public ModelAndView dynamic_save(HttpServletRequest request, HttpServletResponse response, String content, String currentPage, String orderBy, String orderType, String store_id, String goods_id) {
        ModelAndView mv = new JModelAndView(
                "buyer/dynamic_list.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingDynamic dynamic = new ShoppingDynamic();
        dynamic.setAddtime(new Date());
        dynamic.setUserId(SecurityUserHolder.getCurrentUser().getId());
        dynamic.setContent(content);
        dynamic.setDisplay(true);
        dynamic.setDeletestatus(false);
        Map params = new HashMap();
        if ((store_id != null) && (!store_id.equals(""))) {
            ShoppingStoreWithBLOBs store = this.storeService.getObjById(
                    CommUtil.null2Long(store_id));
            dynamic.setStoreId(store.getId());
        }
        if ((goods_id != null) && (!goods_id.equals(""))) {
            ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(
                    CommUtil.null2Long(goods_id));
            dynamic.setGoodsId(goods.getId());


            params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
            params.put("gc_id", goods.getGcId());
            List hgcs = this.homeGoodsClassService.queryByCondition(params);
            //.query("select obj from HomePageGoodsClass obj where obj.user.id=:uid and obj.gc.id=:gc_id", params, -1, -1);
            if (hgcs.size() == 0) {
                Map map = new HashMap();
                map.put("uid", SecurityUserHolder.getCurrentUser().getId());
                ShoppingHomepageGoodsclass hpgc = new ShoppingHomepageGoodsclass();
                hpgc.setAddtime(new Date());
                hpgc.setUserId(SecurityUserHolder.getCurrentUser().getId());
                hpgc.setGcId(goods.getGcId());
                hpgc.setDeletestatus(false);
                this.homeGoodsClassService.save(hpgc);
            }
        }
        this.dynamicService.save(dynamic);
        int pageNow = 1;
        if (StringUtils.isNotBlank(currentPage)) {
            pageNow = Integer.parseInt(currentPage);
        }
        params.clear();
        params.put("start", (pageNow - 1) * 10);
        params.put("pageSize", 10);
        params.put("dissParent_id", "is null");
        params.put("orderBy", "addTime");
        params.put("sort", "desc");
        List<ShoppingDynamic> pList = this.dynamicService.pageList(params);
        if (pList != null) {
            userViewTools.addDynamicUsers(pList, true);
            storeViewTools.addDynamicStores(pList);
            goodsViewTools.addDynamicGoods(pList);
            dynamicViewTools.addChilds(pList, true);
            PageModel page = new PageModel();
            page.setResult(pList);
            int count = dynamicService.count(params);
            page.setCurrentPage(pageNow);
            page.setRowCount(count);
            page.setPages(count / 10);
            page.setPageSize(10);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        mv.addObject("user",SecurityUserHolder.getCurrentUser());
        handle(mv,SecurityUserHolder.getCurrentUser().getId());
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="删除动态", value="/buyer/dynamic_del.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/dynamic_del.htm"})
    public ModelAndView dynamic_ajax_del(HttpServletRequest request, HttpServletResponse response, String id, String currentPage, String orderBy, String orderType)
    {
        if (!id.equals("")) {
            ShoppingDynamic dynamic = this.dynamicService
                    .getObjById(Long.valueOf(Long.parseLong(id)));
            this.dynamicService.delete(Long.valueOf(Long.parseLong(id)));
        }

        ModelAndView mv = new JModelAndView(
                "buyer/dynamic_list.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> params=new HashMap<>();
        int pageNow = 1;
        if (StringUtils.isNotBlank(currentPage)) {
            pageNow = Integer.parseInt(currentPage);
        }
        params.clear();
        params.put("start", (pageNow - 1) * 10);
        params.put("pageSize", 10);
        params.put("dissParent_id", "is null");
        params.put("orderBy", "addTime");
        params.put("sort", "desc");
        List<ShoppingDynamic> pList = this.dynamicService.pageList(params);
        if (pList != null) {
            userViewTools.addDynamicUsers(pList, true);
            storeViewTools.addDynamicStores(pList);
            goodsViewTools.addDynamicGoods(pList);
            dynamicViewTools.addChilds(pList, true);
            PageModel page = new PageModel();
            page.setResult(pList);
            int count = dynamicService.count(params);
            page.setCurrentPage(pageNow);
            page.setRowCount(count);
            page.setPages(count / 10);
            page.setPageSize(10);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="ajax赞动态方法", value="/buyer/dynamic_ajax_praise.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/dynamic_ajax_praise.htm"})
    public void dynamic_ajax_praise(HttpServletRequest request, HttpServletResponse response, String dynamic_id)
            throws ClassNotFoundException {
        ShoppingDynamic dynamic = this.dynamicService.getObjById(
                Long.valueOf(Long.parseLong(dynamic_id)));
        dynamic.setPraisenum(dynamic.getPraisenum() + 1);
        this.dynamicService.update(dynamic);
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(dynamic.getPraisenum());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SecurityMapping(display = false, rsequence = 0, title="ajax转发动态保存方法", value="/buyer/dynamic_ajax_turn.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/dynamic_ajax_turn.htm"})
    public ModelAndView dynamic_ajax_turn(HttpServletRequest request, HttpServletResponse response, String dynamic_id, String content, String currentPage, String orderType, String orderBy)
            throws ClassNotFoundException
    {
        ModelAndView mv = new JModelAndView(
                "buyer/dynamic_list.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingDynamic dynamic = this.dynamicService.getObjById(
                Long.valueOf(Long.parseLong(dynamic_id)));
        ShoppingUser dynamicuser=userService.getObjById(dynamic.getUserId());
        dynamic.setTurnnum(dynamic.getTurnnum() + 1);
        this.dynamicService.update(dynamic);
        ShoppingDynamic turn = new ShoppingDynamic();
        turn.setAddtime(new Date());
        turn.setContent(content + "//转自" + dynamicuser.getUsername() +
                ":" + dynamic.getContent());
        turn.setUserId(SecurityUserHolder.getCurrentUser().getId());
        turn.setDeletestatus(false);
        this.dynamicService.save(turn);
        Map<String,Object> params=new HashMap<>();
        int pageNow = 1;
        if (StringUtils.isNotBlank(currentPage)) {
            pageNow = Integer.parseInt(currentPage);
        }
        params.clear();
        params.put("start", (pageNow - 1) * 10);
        params.put("pageSize", 10);
        params.put("dissParent_id", "is null");
        params.put("orderBy",orderBy!=null? orderBy:"addTime");
        params.put("sort", orderType!=null?orderType:"desc");
        List<ShoppingDynamic> pList = this.dynamicService.pageList(params);
        if (pList != null) {
            userViewTools.addDynamicUsers(pList, true);
            storeViewTools.addDynamicStores(pList);
            goodsViewTools.addDynamicGoods(pList);
            dynamicViewTools.addChilds(pList, true);
            PageModel page = new PageModel();
            page.setResult(pList);
            int count = dynamicService.count(params);
            page.setCurrentPage(pageNow);
            page.setRowCount(count);
            page.setPages(count / 10);
            page.setPageSize(10);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="删除动态下方自己发布的评论", value="/buyer/dynamic_reply_del.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/dynamic_reply_del.htm"})
    public ModelAndView dynamic_reply_del(HttpServletRequest request, HttpServletResponse response, String id, String parent_id)
    {
        if (!id.equals("")) {
            ShoppingDynamic dynamic = this.dynamicService
                    .getObjById(Long.valueOf(Long.parseLong(id)));
            this.dynamicService.delete(Long.valueOf(Long.parseLong(id)));
        }

        ModelAndView mv = new JModelAndView(
                "buyer/dynamic_childs_list.html",
                this.configService.getSysConfig(), this.userConfigService
                .getUserConfig(), 0, request, response);
        if ((parent_id != null) && (!parent_id.equals(""))) {
            ShoppingDynamic obj = this.dynamicService.getObjById(
                    CommUtil.null2Long(parent_id));
            mv.addObject("obj", obj);
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="用户分享列表", value="/buyer/fav_store_list.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/fav_store_list.htm"})
    public ModelAndView fav_store_list(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType)
    {
        ModelAndView mv = new JModelAndView(
                "buyer/fav_store_list.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> params=new HashMap<>();
        int pageNow = 1;
        if (StringUtils.isNotBlank(currentPage)) {
            pageNow = Integer.parseInt(currentPage);
        }
        params.clear();
        params.put("start", (pageNow - 1) * 4);
        params.put("pageSize", 4);
        params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
        params.put("type", Integer.valueOf(1));
        params.put("orderBy",orderBy!=null? orderBy:"addTime");
        params.put("sort", orderType!=null?orderType:"desc");
        List<ShoppingFavorite> pList = favoriteService.queryByCondition(params);
        if (pList != null) {
            PageModel page = new PageModel();
            page.setResult(pList);
            int count = dynamicService.count(params);
            page.setCurrentPage(pageNow);
            page.setRowCount(count);
            if(count%4==0){
                page.setPages(count / 4);
            }else{
                page.setPages(count / 4 +1);
            }
            page.setPageSize(4);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
            mv.addObject("objs", pList);
            String Ajax_url = CommUtil.getURL(request) +
                    "/buyer/fav_store_list_ajax.htm";
            mv.addObject("gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(Ajax_url,
                    "", page.getCurrentPage(), page.getPages()));
        }

        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="用户分享ajax列表", value="/buyer/fav_store_list_ajax.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/fav_store_list_ajax.htm"})
    public ModelAndView fav_store_list_ajax(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType)
    {
        ModelAndView mv = new JModelAndView(
                "buyer/fav_store_list_ajax.html",
                this.configService.getSysConfig(), this.userConfigService
                .getUserConfig(), 0, request, response);
        Map<String,Object> params=new HashMap<>();
        int pageNow = 1;
        if (StringUtils.isNotBlank(currentPage)) {
            pageNow = Integer.parseInt(currentPage);
        }
        params.clear();
        params.put("start", (pageNow - 1) * 4);
        params.put("pageSize", 4);
        params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
        params.put("type", Integer.valueOf(1));
        params.put("orderBy",orderBy!=null? orderBy:"addTime");
        params.put("sort", orderType!=null?orderType:"desc");
        List<ShoppingFavorite> pList = favoriteService.queryByCondition(params);
        if (pList != null) {
            PageModel page = new PageModel();
            page.setResult(pList);
            int count = dynamicService.count(params);
            page.setCurrentPage(pageNow);
            page.setRowCount(count);
            if (count % 4 == 0) {
                page.setPages(count / 4);
            } else {
                page.setPages(count / 4 + 1);
            }
            page.setPageSize(4);
            //CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
            mv.addObject("objs", pList);
            String Ajax_url = CommUtil.getURL(request) +
                    "/buyer/fav_store_list_ajax.htm";
            mv.addObject("gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(Ajax_url,
                    "", page.getCurrentPage(), page.getPages()));
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="用户分享收藏商品列表", value="/buyer/fav_*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/fav_"})
    public ModelAndView fav_goods_list(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType)
    {
        ModelAndView mv = new JModelAndView(
                "buyer/fav_l", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> params=new HashMap<>();
        int pageNow = 1;
        if (StringUtils.isNotBlank(currentPage)) {
            pageNow = Integer.parseInt(currentPage);
        }
        params.clear();
        params.put("start", (pageNow - 1) * 4);
        params.put("pageSize", 4);
        params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
        params.put("type", Integer.valueOf(0));
        params.put("orderBy",orderBy!=null? orderBy:"addTime");
        params.put("sort", orderType!=null?orderType:"desc");
        List<ShoppingFavorite> pList = favoriteService.queryByCondition(params);
        if (pList != null) {
            PageModel page = new PageModel();
            page.setResult(pList);
            int count = dynamicService.count(params);
            page.setCurrentPage(pageNow);
            page.setRowCount(count);
            if (count % 4 == 0) {
                page.setPages(count / 4);
            } else {
                page.setPages(count / 4 + 1);
            }
            page.setPageSize(4);
            //CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
            mv.addObject("objs", pList);
            String Ajax_url = CommUtil.getURL(request) +
                    "/buyer/fav_goods_list_ajax.htm";
            mv.addObject("gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(Ajax_url,
                    "", page.getCurrentPage(), page.getPages()));
        }

        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="用户分享收藏商品ajax列表", value="/buyer/fav_goods_list_ajax.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/fav_goods_list_ajax.htm"})
    public ModelAndView fav_goods_list_ajax(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType) {
        ModelAndView mv = new JModelAndView(
                "buyer/fav_goods_list_ajax.html",
                this.configService.getSysConfig(), this.userConfigService
                .getUserConfig(), 0, request, response);
        Map<String, Object> params = new HashMap<>();
        int pageNow = 1;
        if (StringUtils.isNotBlank(currentPage)) {
            pageNow = Integer.parseInt(currentPage);
        }
        params.clear();
        params.put("start", (pageNow - 1) * 4);
        params.put("pageSize", 4);
        params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
        params.put("type", Integer.valueOf(0));
        params.put("orderBy", orderBy != null ? orderBy : "addTime");
        params.put("sort", orderType != null ? orderType : "desc");
        List<ShoppingFavorite> pList = favoriteService.queryByCondition(params);
        if (pList != null) {
            PageModel page = new PageModel();
            page.setResult(pList);
            int count = dynamicService.count(params);
            page.setCurrentPage(pageNow);
            page.setRowCount(count);
            if (count % 4 == 0) {
                page.setPages(count / 4);
            } else {
                page.setPages(count / 4 + 1);
            }
            page.setPageSize(4);
            //CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
            mv.addObject("objs", pList);
            String Ajax_url = CommUtil.getURL(request) +
                    "/buyer/fav_goods_list_ajax.htm";
            mv.addObject("gotoPageAjaxHTML", CommUtil.showPageAjaxHtml(Ajax_url,
                    "", page.getCurrentPage(), page.getPages()));
        }
        return mv;
    }


}
