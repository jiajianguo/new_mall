package com.xdj.interfaces.mallinterface.controller.shop;

import com.xdj.interfaces.mallinterface.controller.view.*;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 */
@RestController
public class StoreController {
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private ISysConfigService configService;
    @Resource
    private AreaViewTools areaViewTools;
    @Resource
    private IEvaluateService evaluateService;
    @Resource
    private  IStoreService storeService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private IGoodsClassService goodsClassService;
    @Resource
    private IUserGoodsClassService userGoodsClassService;
    @Resource
    private StoreViewTools storeViewTools;
    @Resource
    private ViewTools viewTools;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private AccessoryViewTools accessoryViewTools;
    @Resource
    private IStoreClassService storeClassService;
    @Resource
    private IGoodsClassStapleService goodsClassStapleService;
    @Resource
    private  UserViewTools userViewTools;
    @Resource
    private OrderViewTools orderViewTools;
    @Resource
    private IStoreNavigationService storenavigationService;
    private  final static Logger log = LoggerFactory.getLogger("store");



    @RequestMapping("/app_store.htm")
    public ModelAndView app_store(HttpServletRequest request, HttpServletResponse response, String id){
        String serverName = request.getServerName().toLowerCase();
        ShoppingStoreWithBLOBs store = null;
        if ((id == null) && (serverName.indexOf(".") >= 0) && (serverName.indexOf(".") != serverName.lastIndexOf(".")) &&  (this.configService.getSysConfig().getSecondDomainOpen())) {
            String secondDomain = serverName.substring(0, serverName.indexOf("."));
            Map<String,Object> params = new HashMap<>();
            params.put("store_second_domain",secondDomain);
            store = this.storeService.queryOne(params);
        } else {
            store = this.storeService.getObjById(CommUtil.null2Long(id));
        }
        if (store == null) {
            ModelAndView mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
            mv.addObject("op_title", "不存在该店铺信息");
            mv.addObject("url", CommUtil.getURL(request) + "/wap/index.htm");
            return mv;
        }
        ModelAndView mv = new JModelAndView( "wap/store_index.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        if (store.getStoreStatus() == 2) {
            storeViewTools.addUser(store);
            storeViewTools.addStoreLogo(store);
            storeViewTools.addPoint(store);
            storeViewTools.addGrade(store);
            storeViewTools.addArea(store);
            viewTools.generic_evaluate(store, mv);
            add_store_common_info(mv, store);
            mv.addObject("goodsStore", store);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,response);
            mv.addObject("op_title", "店铺已经关闭或者未开通店铺");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }

    @RequestMapping({"/store_url.htm"})
    public ModelAndView store_url(HttpServletRequest request, HttpServletResponse response, String id) {
        ShoppingStoreNav nav = this.storenavigationService.getObjById( CommUtil.null2Long(id));
        String template = "default";
        ShoppingStoreWithBLOBs store =null;
        if (nav.getStoreId() != null) {
            store = storeService.getObjById(nav.getStoreId());
            if(store != null && store.getTemplate() != null){
                template = store.getTemplate();
            }

        }
        ModelAndView mv = new JModelAndView(template + "/store_url.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        mv.addObject("store", store);
        mv.addObject("nav", nav);
        mv.addObject("nav_id", nav.getId());
        viewTools.topHandle(mv,request);
        viewTools.footerHandle(mv);
        viewTools.store_nav(mv,request,store);
        return mv;
    }

    @RequestMapping({"/store.htm"})
    public  ModelAndView store(HttpServletRequest request, HttpServletResponse response, String id){
        String serverName = request.getServerName().toLowerCase();
        ShoppingStoreWithBLOBs store = null;
        if ((id == null) && (serverName.indexOf(".") >= 0) && (serverName.indexOf(".") != serverName.lastIndexOf(".")) &&  (this.configService.getSysConfig().getSecondDomainOpen())) {
            String secondDomain = serverName.substring(0, serverName.indexOf("."));
            Map<String,Object> params = new HashMap<>();
            params.put("store_second_domain",secondDomain);
            store = this.storeService.queryOne(params);
        } else {
            store = this.storeService.getObjById(CommUtil.null2Long(id));
        }

        if (store == null) {
            ModelAndView mv = new JModelAndView("error.html",
                    this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "不存在该店铺信息");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
            return mv;
        }
        String template = "default";
        if ((store.getTemplate() != null) && (!store.getTemplate().equals(""))) {
            template = store.getTemplate();
        }
        ModelAndView mv = new JModelAndView(template + "/store_index.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        if (store.getStoreStatus() == 2) {
            storeViewTools.addUser(store);
            storeViewTools.addStoreLogo(store);
            storeViewTools.addPoint(store);
            storeViewTools.addGrade(store);
            storeViewTools.addArea(store);
            storeViewTools.addSlider(store);
            storeViewTools.store_left1(mv,store);
            viewTools.generic_evaluate(store, mv);
            add_store_common_info(mv, store);
            if(template.indexOf("mode") == -1){
                storeViewTools.addBanner(store);
                mv.addObject("nav_idnav_id", "store_index");
                viewTools.store_nav(mv,request,store);
                viewTools.topHandle(mv,request);
                viewTools.storeHead(mv,store);
            }
            storeViewTools.store_credits(store.getId(),mv);
            mv.addObject("goodsStore", store);
        } else {
            log.info("----store-err-msg----");
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,response);
            mv.addObject("op_title", "店铺已经关闭或者未开通店铺");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }

        return mv;
    }

    private void add_store_common_info(ModelAndView mv, ShoppingStoreWithBLOBs store) {
        Map params = new HashMap();
        params.put("user_id", store.getUser().getId());
        params.put("parent_id","is null");
        params.put("display", Boolean.valueOf(true));
        params.put("orderBy","sequence");
        params.put("sort","asc");
        List<ShoppingUsergoodsclass> ugcs = this.userGoodsClassService.queryByCondition(params);
        List<ShoppingUsergoodsclass> ugcaccsorry= new ArrayList<>();
        for(ShoppingUsergoodsclass s: ugcs){
            params.clear();
            params.put("parent_id","=".concat(s.getId().toString()));
            params.put("user_id", store.getUser().getId());
            List<ShoppingUsergoodsclass> gcs = userGoodsClassService.queryByCondition(params);
            if(gcs != null){
                for(ShoppingUsergoodsclass gc: gcs){
                    accessoryViewTools.addUserGcImgs(gc);
                }
            }
            s.setChilds(gcs);
            ugcaccsorry.addAll(gcs);
        }
        mv.addObject("ugcaccsorry",ugcaccsorry);
        mv.addObject("ugcs", ugcs);
        params.clear();
        params.put("goods_recommend", Boolean.valueOf(true));
        params.put("goods_store_id", store.getId());
        params.put("goods_status", Integer.valueOf(0));
        params.put("start",0);
        params.put("pageSize",8);
        params.put("orderBy","addTime");
        params.put("sort","desc");
        List<ShoppingGoodsWithBLOBs> goods_recommend = this.goodsService.queryByCondition(params);
        accessoryViewTools.addMainPhotos(goods_recommend);
        params.clear();
        params.put("goods_store_id", store.getId());
        params.put("goods_status", Integer.valueOf(0));
        params.put("orderBy","addTime");
        params.put("sort","desc");
        params.put("start",0);
        params.put("pageSize",12);
        List<ShoppingGoodsWithBLOBs> goods_new = this.goodsService.queryByCondition(params);
        accessoryViewTools.addMainPhotos(goods_new);
        mv.addObject("goods_recommend", goods_recommend);
        mv.addObject("goods_new", goods_new);
        ShoppingGoodsExample ex = new ShoppingGoodsExample();
        ex.createCriteria()
                .andGoodsStoreIdEqualTo(store.getId())
                .andGoodsStatusEqualTo(0);
        List<ShoppingGoodsWithBLOBs>  list= goodsService.selectExample(ex);
        if(list != null){
            mv.addObject("goods_counts",list.size());
        }

    }

    //查询店铺分类
    @RequestMapping({"/goodsclass_store.htm"})
    public ModelAndView goodsclass_store(HttpServletRequest request, HttpServletResponse response,String store_id) {
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(Long.valueOf(Long.parseLong(store_id)));
        ModelAndView mv = new JModelAndView("wap/goodsclass_store.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        Map params = new HashMap();
        params.put("user_id", store.getUser().getId());
        params.put("parent_id","is null");
        params.put("display", Boolean.valueOf(true));
        params.put("orderBy","sequence");
        params.put("sort","asc");
        List<ShoppingUsergoodsclass> ugcs = this.userGoodsClassService.queryByCondition(params);
        List<ShoppingUsergoodsclass> ugcaccsorry= new ArrayList<>();
        for(ShoppingUsergoodsclass s: ugcs){
            params.clear();
            params.put("parent_id","=".concat(s.getId().toString()));
            params.put("user_id", store.getUser().getId());
            List<ShoppingUsergoodsclass> gcs = userGoodsClassService.queryByCondition(params);
            if(gcs != null){
                for(ShoppingUsergoodsclass gc: gcs){
                    accessoryViewTools.addUserGcImgs(gc);
                }
            }
            s.setChilds(gcs);
            ugcaccsorry.addAll(gcs);
        }
        mv.addObject("ugcaccsorry",ugcaccsorry);
        mv.addObject("ugcs", ugcs);
        return mv;
    }


    @RequestMapping({"/app_store_goods_search.htm"})
    public ModelAndView app_store_goods_search(HttpServletRequest request, HttpServletResponse response, String keyword, String store_id, String currentPage)
    {
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(Long.valueOf(Long.parseLong(store_id)));
        ModelAndView mv = new JModelAndView( "wap/search_goods_list.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        Map<String,Object> params = new HashMap<>();
        int pageNow = 1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow= Integer.parseInt(currentPage);
        }
        params.put("goods_store_id",store.getId());
        params.put("goods_name","%" + keyword + "%");
        params.put("goods_status",0);
        params.put("start",(pageNow-1)*20);
        params.put("pageSize",20);
        List<ShoppingGoodsWithBLOBs> pList = this.goodsService.queryByCondition(params);
        List<ShoppingGoodsWithBLOBs> sale_goods= goodsViewTools.sort_sale_goods(store.getId()+"",5);
        accessoryViewTools.addMainPhotos(sale_goods);
        mv.addObject("sale_goods",sale_goods);
        List<ShoppingGoodsWithBLOBs> collect_goods=goodsViewTools.sort_collect_goods(store.getId()+"",5);
        accessoryViewTools.addMainPhotos(collect_goods);
        mv.addObject("collect_goods",collect_goods);
        storeViewTools.addUser(store);
        storeViewTools.addStoreLogo(store);
        viewTools.footerHandle(mv);
        viewTools.storeHead(mv,store);
        if(pList != null){
            int count = goodsService.count(params);
            accessoryViewTools.addMainPhotos(pList);
            PageModel page =new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            page.setCurrentPage(pageNow);
            if(count%20==0){
                page.setPages(count/20);
            }else {
                page.setPages(count/20+1);
            }
            page.setPageSize(20);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }

        mv.addObject("keyword", keyword);
        mv.addObject("store", store);
        return mv;

    }


    @RequestMapping({"/store_goods_search.htm"})
    public ModelAndView store_goods_search(HttpServletRequest request, HttpServletResponse response, String keyword, String store_id, String currentPage)
    {
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(Long.valueOf(Long.parseLong(store_id)));
        String template = "default";
        if ((store.getTemplate() != null) && (!store.getTemplate().equals(""))) {
            template = store.getTemplate();
        }
        ModelAndView mv = new JModelAndView(template + "/goods_list.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        Map<String,Object> params = new HashMap<>();
        int pageNow = 1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow= Integer.parseInt(currentPage);
        }
        params.put("goods_store_id",store.getId());
        params.put("goods_name","%" + keyword + "%");
        params.put("goods_status",0);
        params.put("start",(pageNow-1)*20);
        params.put("pageSize",20);
        List<ShoppingGoodsWithBLOBs> pList = this.goodsService.queryByCondition(params);
        List<ShoppingGoodsWithBLOBs> sale_goods= goodsViewTools.sort_sale_goods(store.getId()+"",5);
        accessoryViewTools.addMainPhotos(sale_goods);
        mv.addObject("sale_goods",sale_goods);
        List<ShoppingGoodsWithBLOBs> collect_goods=goodsViewTools.sort_collect_goods(store.getId()+"",5);
        accessoryViewTools.addMainPhotos(collect_goods);
        mv.addObject("collect_goods",collect_goods);
        viewTools.store_nav(mv,request,store);
        storeViewTools.addGrade(store);
        storeViewTools.addUser(store);
        storeViewTools.addStoreLogo(store);
        storeViewTools.addPoint(store);
        storeViewTools.addBanner(store);
        storeViewTools.addArea(store);
        viewTools.footerHandle(mv);
        viewTools.storeHead(mv,store);
        int credit =storeViewTools.generic_store_credit(store.getId().toString());
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
        if(pList != null){
            int count = goodsService.count(params);
            accessoryViewTools.addMainPhotos(pList);
            PageModel page =new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            page.setCurrentPage(pageNow);
            page.setPages(count/20);
            page.setPageSize(20);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }

        mv.addObject("keyword", keyword);
        mv.addObject("store", store);
        return mv;
    }



    @RequestMapping({"/store_info.htm"})
    public ModelAndView store_info(HttpServletRequest request, HttpServletResponse response, String id) {
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(Long.valueOf(Long.parseLong(id)));
        String template = "default";
        if ((store.getTemplate() != null) && (!store.getTemplate().equals(""))) {
            template = store.getTemplate();
        }
        ModelAndView mv = new JModelAndView(template + "/store_info.html",this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        storeViewTools.addGrade(store);
        storeViewTools.addUser(store);
        storeViewTools.addStoreLogo(store);
        storeViewTools.addPoint(store);
        storeViewTools.addBanner(store);
        storeViewTools.addArea(store);
        viewTools.store_nav(mv,request,store);
        viewTools.footerHandle(mv);
        viewTools.storeHead(mv,store);
        int credit =storeViewTools.generic_store_credit(store.getId().toString());
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
        int count =0;
        for(int i=0;i< credit;i++){
            credits.add(count+1);
        }
        mv.addObject("creditsImg",creditsImg);
        mv.addObject("credit",credit);
        mv.addObject("credits",credits);
        ShoppingGoodsExample ex = new ShoppingGoodsExample();
        ex.createCriteria()
                .andGoodsStoreIdEqualTo(store.getId())
                .andGoodsStatusEqualTo(0);
        List<ShoppingGoodsWithBLOBs>  list= goodsService.selectExample(ex);
        if(list != null){
            mv.addObject("goods_counts",list.size());
        }
        if (store.getStoreStatus() == 2) {
            mv.addObject("store", store);
            mv.addObject("nav_id", "store_info");
            mv.addObject("areaViewTools", this.areaViewTools);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "店铺信息错误");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }

    @RequestMapping({"/store_credit.htm"})
    public ModelAndView store_credit(HttpServletRequest request, HttpServletResponse response, String currentPage,  String id) {
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(CommUtil.null2Long(id));
        String template = "default";
        if ((store.getTemplate() != null) && (!store.getTemplate().equals(""))) {
            template = store.getTemplate();
        }
        ModelAndView mv = new JModelAndView(template + "/store_credit.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        int pageNow=1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        Map<String,Object> params = new HashMap<>();
        if (store.getStoreStatus() == 2) {
            params.put("orderBy","se.addTime");
            params.put("sort","desc");
            params.put("start",(pageNow-1)*10);
            params.put("pageSize",10);
            params.put("store_id",store.getId());
            List<ShoppingEvaluateWithBLOBs> evas = evaluateService.queryByCondition(params);
            goodsViewTools.addEvaluteGoods(evas);
            userViewTools.addEvalUsers(evas);
            orderViewTools.addEvaOfs(evas);
            if(evas != null){
                int count=this.evaluateService.count(params);
                PageModel  page = new PageModel();
                page.setPageSize(10);
                if(count%10==0){
                    page.setPages(count/10);
                }else{
                    page.setPages(count/10+1);
                }
                page.setRowCount(count);
                page.setResult(evas);
                page.setCurrentPage(pageNow);
                CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request) + "/store_eva.htm", "", "", page, mv);
            }

            storeViewTools.addGrade(store);
            storeViewTools.addUser(store);
            storeViewTools.addStoreLogo(store);
            storeViewTools.addPoint(store);
            storeViewTools.addBanner(store);
            storeViewTools.addArea(store);
            storeViewTools.addGoods(store);
            viewTools.store_nav(mv,request,store);
            viewTools.footerHandle(mv);
            viewTools.storeHead(mv,store);
            store.setSc(storeClassService.getObjById(store.getScId()));
            if(store.getPoint() != null){
                int description_total= store.getPoint().getDescriptionEvaluateHalfyearCount1()+store.getPoint().getDescriptionEvaluateHalfyearCount2()+
                        store.getPoint().getDescriptionEvaluateHalfyearCount3()+store.getPoint().getDescriptionEvaluateHalfyearCount4()+
                        store.getPoint().getDescriptionEvaluateHalfyearCount5();
                int service_total= store.getPoint().getServiceEvaluateHalfyearCount1()+store.getPoint().getServiceEvaluateHalfyearCount2()+
                        store.getPoint().getServiceEvaluateHalfyearCount3()+store.getPoint().getServiceEvaluateHalfyearCount4()+
                        store.getPoint().getServiceEvaluateHalfyearCount5();
                int ship_total = store.getPoint().getShipEvaluateHalfyearCount1()+store.getPoint().getShipEvaluateHalfyearCount2()
                        +store.getPoint().getShipEvaluateHalfyearCount3()+store.getPoint().getShipEvaluateHalfyearCount4()+store.getPoint().getShipEvaluateHalfyearCount5();
                mv.addObject("description_total", description_total);
                mv.addObject("service_total", service_total);
                mv.addObject("ship_total", ship_total);
            }

            mv.addObject("store", store);
            mv.addObject("nav_id", "store_credit");
            mv.addObject("eva_week_0",storeViewTools.query_evaluates(store.getId(),1,"week","after",-1));
            mv.addObject("eva_month_0",storeViewTools.query_evaluates(store.getId(),1,"month","after",-1));
            mv.addObject("eva_month6_0",storeViewTools.query_evaluates(store.getId(),1,"month","after",-6));
            mv.addObject("eva_month6_before0",storeViewTools.query_evaluates(store.getId(),1,"month","before",-6));
            mv.addObject("eva_week_1",storeViewTools.query_evaluates(store.getId(),0,"week","after",-1));
            mv.addObject("eva_month_1",storeViewTools.query_evaluates(store.getId(),0,"month","after",-1));
            mv.addObject("eva_month6_1",storeViewTools.query_evaluates(store.getId(),0,"month","after",-6));
            mv.addObject("eva_month6_before1",storeViewTools.query_evaluates(store.getId(),0,"month","before",-6));
            mv.addObject("eva_week_2",storeViewTools.query_evaluates(store.getId(),-1,"week","after",-1));
            mv.addObject("eva_month_2",storeViewTools.query_evaluates(store.getId(),-1,"month","after",-1));
            mv.addObject("eva_month6_2",storeViewTools.query_evaluates(store.getId(),-1,"month","after",-6));
            mv.addObject("eva_month6_before2",storeViewTools.query_evaluates(store.getId(),-1,"month","before",-6));
            /*List<Double> credits= new ArrayList<>();
            for(int i=1;i<=25 ;i++){
                credits.add(CommUtil.formatDouble(i*0.2,1));
            }
            mv.addObject("credits",credits);*/

            int credit =storeViewTools.generic_store_credit(store.getId().toString());
            if(0< credit && credit <10){
                credit = credit/2 +1;
            }
            if(credit >= 10 && credit < 20){
                credit = (credit-10)/2 +1;
            }
            if(credit >= 20){
                credit = (credit-20)/2 +1;
            }
            if(credit > 5 ){
                credit =5;
            }
            List<Integer> credits= new ArrayList();
            int count =0;
            for(int i=0;i< credit;i++){
                credits.add(count+1);
            }
            mv.addObject("credit",credit);
            mv.addObject("credits",credits);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
            mv.addObject("op_title", "店铺信息错误");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }


    @RequestMapping({"/store_eva.htm"})
    public ModelAndView store_eva(HttpServletRequest request, HttpServletResponse response, String id, String currentPage, String eva_val) {
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(Long.valueOf(Long.parseLong(id)));
        String template = "default";
        if ((store.getTemplate() != null) && (!store.getTemplate().equals(""))) {
            template = store.getTemplate();
        }
        ModelAndView mv = new JModelAndView(template + "/store_eva.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        int pageNow=1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        Map<String,Object> params = new HashMap<>();
        if (store.getStoreStatus() == 2) {
            params.put("orderBy","se.addTime");
            params.put("sort","desc");
            params.put("start",(pageNow-1)*10);
            params.put("pageSize",10);
            params.put("store_id",store.getId());
            if (!CommUtil.null2String(eva_val).equals("")) {
                params.put("evaluate_buyer_val",Integer.valueOf(CommUtil.null2Int(eva_val)));
            }
            List<ShoppingEvaluateWithBLOBs> evas=evaluateService.queryBySg(params);
            goodsViewTools.addEvaluteGoods(evas);
            userViewTools.addEvalUsers(evas);
            orderViewTools.addEvaOfs(evas);
            if(evas != null){
                int count=this.evaluateService.countSg(params);
                PageModel  page = new PageModel();
                page.setPageSize(10);
                if(count%10==0){
                    page.setPages(count/10);
                }else{
                    page.setPages(count/10+1);
                }
                page.setRowCount(count);
                page.setResult(evas);
                page.setCurrentPage(pageNow);
                CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request) + "/store_eva.htm", "", "&eva_val=" + CommUtil.null2String(eva_val), page, mv);
            }
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "店铺信息错误");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        viewTools.footerHandle(mv);
        viewTools.storeHead(mv,store);
        return mv;
    }


}
