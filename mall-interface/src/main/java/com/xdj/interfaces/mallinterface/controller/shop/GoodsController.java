package com.xdj.interfaces.mallinterface.controller.shop;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xdj.interfaces.mallinterface.controller.view.*;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.query.IPageList;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.domain.virtual.SysMap;
import com.xdj.www.core.tools.IpAddress;
import com.xdj.www.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Administrator
 */
@RestController
public class GoodsController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private IUserGoodsClassService userGoodsClassService;
    @Resource
    private IAreaService areaService;
    @Resource
    private IEvaluateService evaluateService;
    @Resource
    private IStoreClassService storeClassService;
    @Resource
    private IStoreService storeService;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private IUserService userService;
    @Resource
    private StoreViewTools storeViewTools;
    @Resource
    private AreaViewTools areaViewTools;
    @Resource
    private ViewTools viewTools;
    @Resource
    private AccessoryViewTools accessViewTools;
    @Resource
    private TransportTools transportTools;
    @Resource
    private IGoodsClassService goodsClassService;
    @Resource
    private IGoodsBrandService brandService;
    @Resource
    private IGroupService groupService;
    @Resource
    private IGroupGoodsService groupGoodsService;
    @Resource
    private IGoodsSpecPropertyService goodsSpecPropertyService;
    @Resource
    private  IGoodsTypePropertyService  goodsTypePropertyService;
    @Resource
    private ITransportService transportService;
    @Resource
    private IGoodsCartService goodsCartService;
    @Resource
    private UserViewTools userViewTools;
    @Resource
    private IConsultService consultService;
    @Resource
    private OrderViewTools orderViewTools;
    @Resource
    private UserGoodsClassTools userGoodsClassTools;

    private Logger log = LoggerFactory.getLogger("goodsController");

    @RequestMapping({"/goods_share.htm"})
    public ModelAndView goods_share(HttpServletRequest request, HttpServletResponse response, String goods_id) {
        ModelAndView mv = new JModelAndView("goods_share.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingGoodsWithBLOBs goods = this.goodsService .getObjById(CommUtil.null2Long(goods_id));
        mv.addObject("obj", goods);
        return mv;
    }


    @RequestMapping({"/goods_consult_save.htm"})
    public ModelAndView goods_consult_save(HttpServletRequest request, HttpServletResponse response, String goods_id, String consult_content, String consult_email, String Anonymous, String consult_code) {
        ModelAndView mv = new JModelAndView(
                "buyer/success.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        String verify_code = CommUtil.null2String(request.getSession(false)
                .getAttribute("consult_code"));
        boolean visit_consult = true;
        if (!this.configService.getSysConfig().getVisitorconsult()) {
            if (SecurityUserHolder.getCurrentUser() == null) {
                visit_consult = false;
            }
            if (CommUtil.null2Boolean(Anonymous)) {
                visit_consult = false;
            }
        }
        if (visit_consult) {
            if (CommUtil.null2String(consult_code).equals(verify_code)) {
                ShoppingConsultWithBLOBs obj = new ShoppingConsultWithBLOBs();
                obj.setAddtime(new Date());
                obj.setConsultContent(consult_content);
                obj.setConsultEmail(consult_email);
                if (!CommUtil.null2Boolean(Anonymous)) {
                    obj.setConsultUserId(SecurityUserHolder.getCurrentUser().getId());
                    mv.addObject("op_title", "咨询发布成功");
                }
                obj.setGoodsId(CommUtil.null2Long(goods_id));
                obj.setDeletestatus(false);
                obj.setReply(false);
                obj.setReplyTime(new Date());
                this.consultService.save(obj);
                request.getSession(false).removeAttribute("consult_code");
            } else {
                mv = new JModelAndView("error.html",
                        this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request,
                        response);
                mv.addObject("op_title", "验证码错误，咨询发布失败");
            }
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "不允许游客咨询");
        }
        mv.addObject("url", CommUtil.getURL(request) + "/?id=" + goods_id);
        return mv;
    }

    @RequestMapping({"/goods_onsult.htm"})
    public ModelAndView goods_consult(HttpServletRequest request, HttpServletResponse response, String id, String goods_id, String currentPage){
        String template = "default";
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(CommUtil.null2Long(id));
        if (store != null) {
            template = store.getTemplate();
        }
        ModelAndView mv = new JModelAndView(template + "/goods_consult.html",this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        Map<String,Object> params = new HashMap<>();
        params.put("orderBy","addTime");
        params.put("sort","desc");
        params.put("goods_id",goods_id);
        params.put("order_status",20);
        int pageNow =1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow =Integer.parseInt(currentPage);
        }
        params.put("start",(pageNow-1)*5);
        params.put("pageSize",5);
        List<ShoppingConsultWithBLOBs> pList = this.consultService.queryByCondition(params);
        if(pList != null){
            PageModel page = new PageModel();
            userViewTools.addConsultUsers(pList);
            int count = consultService.count(params);
            page.setResult(pList);
            page.setRowCount(count);
            page.setCurrentPage(pageNow);
            page.setPages(count%5==0?count/5:count/5+1);
            CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request) +"/goods_consult.htm", "", "", page, mv);
        }
        mv.addObject("goods_id", goods_id);
        return mv;
    }

    @RequestMapping({"/goods_detail.htm"})
    public ModelAndView goods_detail(HttpServletRequest request, HttpServletResponse response, String id, String goods_id) {
        String template = "default";
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(CommUtil.null2Long(id));
        if (store != null) {
            template = store.getTemplate();
        }
        ModelAndView mv = new JModelAndView(template + "/goods_detail.html",
                this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingGoodsWithBLOBs goods = this.goodsService .getObjById(CommUtil.null2Long(goods_id));
        storeViewTools.addGoodsStore(goods);
        mv.addObject("obj", goods);
        generic_evaluate(goods.getGoods_store(), mv);
         //mv.addObject("users",userViewTools.query_user()) ;
        return mv;
    }

    @RequestMapping({"/goods_order.htm"})
    public ModelAndView goods_order(HttpServletRequest request, HttpServletResponse response, String id, String goods_id, String currentPage)
    {
        String template = "default";
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(CommUtil.null2Long(id));
        if (store != null) {
            template = store.getTemplate();
        }
        ModelAndView mv = new JModelAndView(template + "/goods_order.html",this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
        Map<String,Object> params = new HashMap<>();
        params.put("orderBy","c.addTime");
        params.put("sort","desc");
        params.put("goods_id",goods_id);
        params.put("order_status",20);
        int pageNow =1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow =Integer.parseInt(currentPage);
        }
        params.put("start",(pageNow-1)*8);
        params.put("pageSize",8);
        List<ShoppingGoodscart> pList = this.goodsCartService.pageList(params);
        if(pList != null){
           PageModel page  = new PageModel();
           orderViewTools.addOfs(pList,true);
           goodsViewTools.addGoodsCartGoods(pList);
           int count = goodsCartService.pageCount(params);
           page.setResult(pList);
           page.setPages(count%8==0 ?count /8: count/8+1);
           page.setRowCount(count);
           page.setPageSize(8);
           page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request) +"/goods_order.htm", "", "", page, mv);
        }
        return mv;
    }

    @RequestMapping({"/goods_evaluation.htm"})
    public ModelAndView goods_evaluation(HttpServletRequest request, HttpServletResponse response, String id, String goods_id, String currentPage) {
        String template = "default";
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(CommUtil.null2Long(id));
        if (store != null) {
            template = store.getTemplate();
        }
        ModelAndView mv = new JModelAndView(template + "/goods_evaluation.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        Map<String,Object> map = new HashMap<>();
        map.put("orderBy","addTime");
        map.put("sort","desc");
        map.put("evaluate_goods_id",goods_id);
        map.put("evaluate_type","goods");
        map.put("evaluate_status",0);
        int pageNow =1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow =Integer.parseInt(currentPage);
        }
        map.put("start",(pageNow-1)*8);
        map.put("pageSize",8);
        List<ShoppingEvaluateWithBLOBs> pList = this.evaluateService.queryByCondition(map);
        if(pList != null){
            PageModel page = new PageModel();
            userViewTools.addEvalUsers(pList);
            page.setCurrentPage(pageNow);
            page.setResult(pList);
            int count =this.evaluateService.count(map);
            page.setRowCount(count);
            page.setPages(count%8==0?count/8: count/8+1);
            CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request) +"/goods_evaluation.htm", "", "", page, mv);
        }

        mv.addObject("store", store);
        ShoppingGoodsWithBLOBs goods = this.goodsService .getObjById(CommUtil.null2Long(goods_id));
        mv.addObject("goods", goods);
        return mv;
    }

    @RequestMapping({"/trans_fee.htm"})
    @ResponseBody
    public void trans_fee(HttpServletRequest request, HttpServletResponse response, String city_name, String goods_id) {
        Map map = new HashMap();
        ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(CommUtil.null2Long(goods_id));
        float mail_fee = 0.0F;
        float express_fee = 0.0F;
        float ems_fee = 0.0F;
        ShoppingTransportWithBLOBs transport = transportService.getObjById(goods.getTransportId());
        if (transport != null) {
            if(transport.getTransMailInfo() !=null) {
                mail_fee = this.transportTools.cal_goods_trans_fee(
                        transport.getId(), "mail",
                        goods.getGoodsWeight(),
                        CommUtil.null2String(goods.getGoodsVolume()), city_name);
            }
            if(transport.getTransExpressInfo()!=null) {
                express_fee = this.transportTools.cal_goods_trans_fee(
                        transport.getId(), "express",
                       goods.getGoodsWeight(),
                        CommUtil.null2String(goods.getGoodsVolume()), city_name);
            }
            if(transport.getTransEmsInfo()!=null) {
                ems_fee = this.transportTools.cal_goods_trans_fee(
                        transport.getId(), "ems",
                        goods.getGoodsWeight(),
                        CommUtil.null2String(goods.getGoodsVolume()), city_name);
            }
        }
        map.put("mail_fee", Float.valueOf(mail_fee));
        map.put("express_fee", Float.valueOf(express_fee));
        map.put("ems_fee", Float.valueOf(ems_fee));
        map.put("current_city_info", CommUtil.substring(city_name, 5));
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(map);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping({"/goods_list.htm"})
    public ModelAndView goods_list(HttpServletRequest request, HttpServletResponse response, String gc_id, String store_id, String recommend, String currentPage, String orderBy, String orderType, String begin_price, String end_price)
    {
        ShoppingUsergoodsclass ugc = this.userGoodsClassService.getObjById(CommUtil.null2Long(gc_id));
        String template = "default";
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(CommUtil.null2Long(store_id));
        if (store != null) {
            if(store.getAreaId() != null){
                storeViewTools.addArea(store);
            }
            storeViewTools.addGoods(store);
            storeViewTools.addUser(store);
            storeViewTools.addBanner(store);
            storeViewTools.addStoreLogo(store);
            storeViewTools.addPoint(store);
            if ((store.getTemplate() != null) && (!store.getTemplate().equals(""))) {
                template = store.getTemplate();
            }
            ModelAndView mv = new JModelAndView(template + "/goods_list.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
            Map<String,Object> params = new HashMap<>();
            params.put("goods_store_id",store.getId());
            params.put("orderBy",orderBy);
            params.put("sort",orderType);
            params.put("goods_status",0);
            int pageNow = 1;
            if(StringUtils.isNotBlank(currentPage)){
                pageNow = Integer.parseInt(currentPage);
            }
            params.put("start",(pageNow-1)*20);
            params.put("pageSize",20);

            if (ugc != null) {
                Set<Long> ids = genericUserGcIds(ugc);
                List ugc_list = new ArrayList();
                for (Long g_id : ids) {
                    ShoppingUsergoodsclass temp_ugc = this.userGoodsClassService.getObjById(g_id);
                    ugc_list.add(temp_ugc);
                }

                params.put("ugc_ids",ids);
                System.err.println("ugc_ids====="+ids);

               // gqo.addQuery("ugc", ugc, "obj.goods_ugcs", "member of");
               /* for (int i = 0; i < ugc_list.size(); i++){
                    //gqo.addQuery("ugc" + i, ugc_list.get(i), "obj.goods_ugcs","member of", "or");
                }*/

            }else {
                ugc = new ShoppingUsergoodsclass();
                ugc.setClassname("全部商品");
                mv.addObject("ugc", ugc);
            }
            if ((recommend != null) && (!recommend.equals(""))) {
                params.put("goods_recommend",Boolean.valueOf(CommUtil.null2Boolean(recommend)));

            }

            if ((begin_price != null) && (!begin_price.equals(""))) {
                params.put("store_price_begin", BigDecimal.valueOf(CommUtil.null2Double(begin_price)));

            }
            if ((end_price != null) && (!end_price.equals(""))) {
                params.put("store_price_end",BigDecimal.valueOf(CommUtil.null2Double(end_price)));

            }
            List<ShoppingGoodsWithBLOBs> pList = this.goodsService.queryByCondition(params);
            if(pList != null){
                PageModel page = new PageModel();
                accessViewTools.addMainPhotos(pList);
                page.setResult(pList);
                int count = goodsService.count(params);
                page.setPageSize(20);
                page.setCurrentPage(pageNow);
                page.setRowCount(count);
                page.setPages(count/20);
                com.xdj.interfaces.mallinterface.util.CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
            }
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))) {
                url = CommUtil.getURL(request);
            }

            ShoppingUser  user = userService.queryOneByStoreId(CommUtil.null2Long(store_id));
            params.clear();
            params.put("user_id", user.getId());
            params.put("display", 1);
            params.put("parent_id","is null");
            params.put("orderBy","sequence");
            params.put("sort","asc");
            List<ShoppingUsergoodsclass> ugcs = this.userGoodsClassService.queryByCondition(params);
            userGoodsClassTools.addChilds(ugcs);
            mv.addObject("ugc", ugc);
            mv.addObject("ugcs", ugcs);
            mv.addObject("store", store);
            mv.addObject("recommend", recommend);
            mv.addObject("begin_price", begin_price);
            mv.addObject("end_price", end_price);
            mv.addObject("goodsViewTools", this.goodsViewTools);
            mv.addObject("storeViewTools", this.storeViewTools);
            mv.addObject("areaViewTools", this.areaViewTools);
            ShoppingGoodsExample ex = new ShoppingGoodsExample();
            ex.createCriteria()
                    .andGoodsStoreIdEqualTo(store.getId())
                    .andGoodsStatusEqualTo(0);
            List<ShoppingGoodsWithBLOBs>  list= goodsService.selectExample(ex);
            if(list != null){
                mv.addObject("goods_counts",list.size());
            }
            return mv;
        }
        ModelAndView mv = new JModelAndView("error.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request,
                response);
        mv.addObject("op_title", "请求参数错误");
        mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        return mv;
    }



    private Set<Long> genericUserGcIds(ShoppingUsergoodsclass ugc)
    {
        Set ids = new HashSet();
        ids.add(ugc.getId());
        userGoodsClassTools.addChild(ugc);
        for (ShoppingUsergoodsclass child : ugc.getChilds()) {
            Set<Long> cids = genericUserGcIds(child);
            for (Long cid : cids) {
                ids.add(cid);
            }
            ids.add(child.getId());
        }
        return ids;
    }

    /**
     * 根据商品规格查询商品规格价格
     * @param request
     * @param response
     * @param gsp 规格
     * @param id
     */
    @RequestMapping({"/load_goods_gsp.htm"})
    @ResponseBody
    public void load_goods_gsp(HttpServletRequest request, HttpServletResponse response, String gsp, String id) {
        ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(CommUtil.null2Long(id));
        JSONObject map = new JSONObject();
        int count = 0;
        double price = 0.0D;
        goodsViewTools.addGroup(goods);
        goodsViewTools.addgroupGoodsList(goods);
        if ((goods.getGroup() != null) && (goods.getGroupBuy() == 2)) {
            for (ShoppingGroupGoods gg : goods.getGroup_goods_list()){
                if (gg.getGroupId().equals(goods.getGroup().getId())) {
                    count = gg.getGgGroupCount() - gg.getGgDefCount();
                    price = CommUtil.null2Double(gg.getGgPrice());
                }
            }
        }else {
            count = goods.getGoodsInventory();
            price = CommUtil.null2Double(goods.getStorePrice());
            if (goods.getInventoryType().equals("spec")) {
                JSONArray  list = JSON.parseArray(goods.getGoodsInventoryDetail());
                String[] gsp_ids = gsp.split(",");
                if(list != null){
                    for (int i=0;i<list.size();i++) {
                        JSONObject   temp= list.getJSONObject(i);
                        String[] temp_ids = CommUtil.null2String(temp.get("id")).split("_");
                        Arrays.sort(gsp_ids);
                        Arrays.sort(temp_ids);
                        if (Arrays.equals(gsp_ids, temp_ids)) {
                            count = CommUtil.null2Int(temp.get("count"));
                            price = CommUtil.null2Double(temp.get("price"));
                        }
                    }
                }

            }
        }
        map.put("count", Integer.valueOf(count));
        map.put("price", Double.valueOf(price));
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(map.toJSONString());
            writer.flush();
            writer.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }



    @RequestMapping({"/store_goods_list.htm"})
    public ModelAndView store_goods_list(HttpServletRequest request, HttpServletResponse response, String gc_id,
                                         String currentPage, String orderBy, String orderType, String store_price_begin,
                                         String store_price_end, String brand_ids, String gs_ids, String properties,
                                         String op, String goods_name, String area_name, String area_id, String goods_view,
                                         String all_property_status, String detail_property_status) {
        ModelAndView mv = new JModelAndView("store_goods_list.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingGoodsclassWithBLOBs gc = this.goodsClassService.getObjById(CommUtil.null2Long(gc_id));
        goodsViewTools.addAllChilds(gc);
        goodsViewTools.addParent(gc);
        goodsViewTools.addGoodsClassType(gc);
        if ((orderBy == null) || (orderBy.equals(""))) {
            orderBy = "addTime";
        }
        if ((op != null) && (!op.equals(""))) {
            mv.addObject("op", op);
        }
        String orderBy1 = orderBy;
        if (this.configService.getSysConfig().getZtcStatus()) {
            orderBy = "ztc_dredge_price desc,obj." + orderBy;
        }
        Set ids = genericIds(gc);
        Map paras = new HashMap();
        paras.put("gcIds", ids);
        paras.put("orderBy",orderBy);
        paras.put("sort",orderType);
        if ((store_price_begin != null) && (!store_price_begin.equals(""))) {
            paras.put("store_price_begin",CommUtil.null2Double(store_price_begin));
            mv.addObject("store_price_begin", paras.get("start_price"));
        }
        if ((store_price_end != null) && (!store_price_end.equals(""))) {
            paras.put("store_price_end",CommUtil.null2Double(store_price_end));
            mv.addObject("store_price_end", store_price_end);
        }
        if ((goods_name != null) && (!goods_name.equals(""))) {
            paras.put("goods_name", "%".concat(goods_name.trim()).concat("%"));
            mv.addObject("goods_name", goods_name);
        }

        if ((area_id != null) && (!area_id.equals(""))) {
            ShoppingArea area = this.areaService.getObjById(CommUtil.null2Long(area_id));
            areaViewTools.addChilds(area);
            mv.addObject("area", area);
            Set area_ids = getAreaChildIds(area);
          /*Map p_area = new HashMap();
            p_area.put("area_ids", area_ids);*/
            paras.put("area_ids",area_ids);
            //gqo.addQuery("obj.goods_store.area.id in (:area_ids)", p_area);
        }

        if ((area_name != null) && (!area_name.equals(""))) {
            mv.addObject("area_name", area_name);
            Map like_area = new HashMap();
            like_area.put("area_name", area_name + "%");
            List<ShoppingArea> likes_areas = this.areaService.queryByCondition(like_area);
            Set<Long> like_area_ids = getArrayAreaChildIds(likes_areas);
            like_area.clear();
            paras.put("like_area_ids", like_area_ids);
           // gqo.addQuery("obj.goods_store.area.id in (:like_area_ids)", like_area);
        }
        int pageNow =1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow = Integer.parseInt(currentPage);
        }
        paras.put("store_status",2);
        paras.put("start",(pageNow-1)* 20);
        paras.put("pageSize",20);
        paras.put("goods_status", 0);
        List goods_property = new ArrayList();
        if (!CommUtil.null2String(brand_ids).equals("")) {
            String[] brand_id_list = brand_ids.substring(1).split("\\|");
            if (brand_id_list.length == 1) {
                String brand_id = brand_id_list[0];
                String[] brand_info_list = brand_id.split(",");
                paras.put("goods_brand_id", CommUtil.null2Long(brand_info_list[0]));
                Map map = new HashMap();
                ShoppingGoodsbrand brand = this.brandService.getObjById(CommUtil.null2Long(brand_info_list[0]));
                map.put("name", "品牌");
                map.put("value", brand.getName());
                map.put("type", "brand");
                map.put("id", brand.getId());
                goods_property.add(map);
            } else {
                for (int i = 0; i < brand_id_list.length; i++) {
                    String brand_id = brand_id_list[i];
                    if (i == 0) {
                        String[] brand_info_list = brand_id.split(",");
                        paras.put("goods_brand_id",CommUtil.null2Long(brand_info_list[0]));
                        Map map = new HashMap();
                        ShoppingGoodsbrand brand = this.brandService.getObjById(CommUtil.null2Long(brand_info_list[0]));
                        map.put("name", "品牌");
                        map.put("value", brand.getName());
                        map.put("type", "brand");
                        map.put("id", brand.getId());
                        goods_property.add(map);
                    } else if (i == brand_id_list.length - 1) {
                        String[] brand_info_list = brand_id.split(",");
                        paras.put("or_goods_brand_id",CommUtil.null2Long(brand_info_list[0]));
                        Map map = new HashMap();
                        ShoppingGoodsbrand brand = this.brandService.getObjById(CommUtil.null2Long(brand_info_list[0]));
                        map.put("name", "品牌");
                        map.put("value", brand.getName());
                        map.put("type", "brand");
                        map.put("id", brand.getId());
                        goods_property.add(map);
                    } else {
                        String[] brand_info_list = brand_id.split(",");
                        paras.put("or_goods_brand_id",CommUtil.null2Long(brand_info_list[0]));
                        Map map = new HashMap();
                        ShoppingGoodsbrand brand = this.brandService.getObjById(CommUtil.null2Long(brand_info_list[0]));
                        map.put("name", "品牌");
                        map.put("value", brand.getName());
                        map.put("type", "brand");
                        map.put("id", brand.getId());
                        goods_property.add(map);
                    }
                }
            }
            mv.addObject("brand_ids", brand_ids);
        }
        if (!CommUtil.null2String(gs_ids).equals("")) {
            List<List<ShoppingGoodsspecproperty>> gsp_lists = generic_gsp(gs_ids);
            for (int j = 0; j < gsp_lists.size(); j++) {
                List<ShoppingGoodsspecproperty> gsp_list = (List<ShoppingGoodsspecproperty>)gsp_lists.get(j);
                if (gsp_list.size() == 1) {
                    ShoppingGoodsspecproperty gsp = gsp_list.get(0);
                   // gqo.addQuery("gsp" + j, gsp, "obj.goods_specs", "member of", "and");
                    Map map = new HashMap();
                    map.put("name", gsp.getSpec().getName());
                    map.put("value", gsp.getValue());
                    map.put("type", "gs");
                    map.put("id", gsp.getId());
                    goods_property.add(map);
                } else {
                    for (int i = 0; i < gsp_list.size(); i++) {
                        if (i == 0) {
                            ShoppingGoodsspecproperty gsp =gsp_list.get(i);
                           // gqo.addQuery("gsp" + j + i, gsp, "obj.goods_specs", "member of", "and(");
                            Map map = new HashMap();
                            map.put("name", gsp.getSpec().getName());
                            map.put("value", gsp.getValue());
                            map.put("type", "gs");
                            map.put("id", gsp.getId());
                            goods_property.add(map);
                        } else if (i == gsp_list.size() - 1) {
                            ShoppingGoodsspecproperty gsp = gsp_list.get(i);
                           // gqo.addQuery("gsp" + j + i, gsp, "obj.goods_specs)", "member of", "or");
                            Map map = new HashMap();
                            map.put("name", gsp.getSpec().getName());
                            map.put("value", gsp.getValue());
                            map.put("type", "gs");
                            map.put("id", gsp.getId());
                            goods_property.add(map);
                        } else {
                            ShoppingGoodsspecproperty gsp = gsp_list.get(i);
                            //gqo.addQuery("gsp" + j + i, gsp, "obj.goods_specs", "member of", "or");
                            Map map = new HashMap();
                            map.put("name", gsp.getSpec().getName());
                            map.put("value", gsp.getValue());
                            map.put("type", "gs");
                            map.put("id", gsp.getId());
                            goods_property.add(map);
                        }
                    }
                }
            }
            mv.addObject("gs_ids", gs_ids);
        }
        List<Map> ps = new ArrayList<Map>();
        if (!CommUtil.null2String(properties).equals("")) {
            String[] properties_list = properties.substring(1).split("\\|");
            for (int i = 0; i < properties_list.length; i++) {
                String property_info = properties_list[i];
                String[] property_info_list = property_info.split(",");
                ShoppingGoodstypeproperty gtp = this.goodsTypePropertyService.getObjById(com.xdj.interfaces.mallinterface.util.CommUtil.null2Long(property_info_list[0]));

                Map p_map = new HashMap();
                p_map.put("gtp_name" + i, "%" + gtp.getName().trim() + "%");
                p_map.put("gtp_value" + i, "%" + property_info_list[1].trim() + "%");
                ps.add(p_map);
                //gqo.addQuery("and (obj.goods_property like :gtp_name" + i + " and obj.goods_property like :gtp_value" + i + ")", p_map);
                Map map = new HashMap();
                map.put("name", gtp.getName());
                map.put("value", property_info_list[1]);
                map.put("type", "properties");
                map.put("id", gtp.getId());
                goods_property.add(map);
            }
            mv.addObject("properties", properties);
        }
        Map params = new HashMap();
        params.put("common", 1);
        params.put("orderBy","sequence");
        params.put("sort","asc");
        List<ShoppingArea> areas = this.areaService.queryByCondition(params);
                //"select obj from Area obj where obj.common=:common order by sequence asc", params, -1, -1);
        mv.addObject("areas", areas);

        List<ShoppingGoodsWithBLOBs> pList = this.goodsService.queryMsg(paras);
        if(pList != null){
            int count=this.goodsService.queryMsgCount(paras);
            viewTools.mainPhotoHandle(pList);
            goodsViewTools.addStoreGrade(pList);
            PageModel  page = new PageModel();
            page.setPageSize(20);
            page.setPages(count/20);
            page.setRowCount(count);
            page.setResult(pList);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        mv.addObject("gc", gc);
        mv.addObject("orderBy", orderBy1);
        mv.addObject("user_viewed_goods", request.getSession(false).getAttribute("user_viewed_goods"));
        mv.addObject("goods_property", goods_property);
        if (CommUtil.null2String(goods_view).equals("list")) {
            goods_view = "list";
        }else {
            goods_view = "thumb";
        }
        if (this.configService.getSysConfig().getZtcStatus()) {
            List<ShoppingGoodsWithBLOBs> ztc_goods = null;
            Map ztc_map = new HashMap();
            ztc_map.put("ztc_status", Integer.valueOf(3));
            ztc_map.put("ztc_begin_time", new Date());
            ztc_map.put("ztc_gold", Integer.valueOf(0));
            ztc_map.put("orderBy","ztc_dredge_price");
            ztc_map.put("sort","desc");
            ztc_map.put("start",0);
            ztc_map.put("pageSize",5);
            if (this.configService.getSysConfig().getZtcGoodsView() == 0) {
                ztc_goods = this.goodsService.queryByCondition(ztc_map);
                 //query("select obj from Goods obj where obj.ztc_status =:ztc_status and obj.ztc_begin_time <=:now_date and obj.ztc_gold>:ztc_gold order by obj.ztc_dredge_price desc", ztc_map, 0, 5);
            }
            if (this.configService.getSysConfig().getZtcGoodsView() == 1) {
                ztc_map.put("gc_ids", ids);
                ztc_goods = this.goodsService.queryByCondition(ztc_map);
                        //"select obj from Goods obj where obj.ztc_status =:ztc_status and obj.ztc_begin_time <=:now_date and obj.ztc_gold>:ztc_gold and obj.gc.id in (:gc_ids) order by obj.ztc_dredge_price desc", ztc_map, 0, 5);
            }
            viewTools.mainPhotoHandle(ztc_goods);
            goodsViewTools.addStoreGrade(ztc_goods);
            mv.addObject("ztc_goods", ztc_goods);
        }
        if ((detail_property_status != null) &&
                (!detail_property_status.equals(""))) {
            mv.addObject("detail_property_status", detail_property_status);
            String[] temp_str = detail_property_status.split(",");
            Map pro_map = new HashMap();
            List pro_list = new ArrayList();
            for (String property_status : temp_str) {
                if ((property_status != null) && (!property_status.equals(""))) {
                    String[] mark = property_status.split("_");
                    pro_map.put(mark[0], mark[1]);
                    pro_list.add(mark[0]);
                }
            }
            mv.addObject("pro_list", pro_list);
            mv.addObject("pro_map", pro_map);
        }
        mv.addObject("goods_view", goods_view);
        mv.addObject("all_property_status", all_property_status);
        viewTools.footerHandle(mv);
        viewTools.headHandle(mv,request);
        viewTools.topHandle(mv,request);
        return mv;
    }


    @RequestMapping({"/goods.htm"})
    public ModelAndView goods(HttpServletRequest request, HttpServletResponse response, String id){
        ModelAndView mv = null;
        String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );
        ShoppingGoodsWithBLOBs obj = this.goodsService.getObjById(Long.valueOf(Long.parseLong(id)));
        ShoppingStoreWithBLOBs store =null;
        if(obj != null ){
            store = storeService.getObjById(obj.getGoodsStoreId());
            String template = "default";
            if(store.getAreaId() != null){
                storeViewTools.addArea(store);
            }
            storeViewTools.addGoods(store);
            storeViewTools.addUser(store);
            storeViewTools.addBanner(store);
            storeViewTools.addStoreLogo(store);
            storeViewTools.addPoint(store);
            goodsViewTools.setGroup(obj);
            goodsViewTools.addTransport(obj);
            goodsViewTools.addDeliveryGoods(obj);
            goodsViewTools.addSpec(obj);
            accessViewTools.addGoodsPhotos(obj);
            goodsViewTools.addGoodsSpecis(obj);
            accessViewTools.addMainPhoto(obj);
            obj.setGoods_store(store);
            if (obj.getGoodsStoreId() != null && obj.getGoods_store().getTemplate() != null &&(!obj.getGoods_store().getTemplate().equals(""))) {
                template = obj.getGoods_store().getTemplate();
            }
            mv = new JModelAndView(template + "/store_goods.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);

            if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
                mv = new JModelAndView("wap/goods_detail.html", this.configService.getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request, response);
            }
            if (obj.getGoodsStatus() == 0) {
                obj.setGoodsClick(obj.getGoodsClick() + 1);
                if ((this.configService.getSysConfig().getZtcStatus()) && (obj.getZtcStatus() == 2)) {
                    obj.setZtcClickNum(obj.getZtcClickNum() + 1);
                }
                if (obj.getGroupBuy() == 2){
                    ShoppingGroup group = groupService.getObjById(obj.getGroupId());
                    if (group.getEndtime().before(new Date())) {
                        obj.setGroup(null);
                        obj.setGroupBuy(0);
                        obj.setGoodsCurrentPrice(obj.getStorePrice());
                    }
                    Map params=new HashMap();
                    params.put("goods_id",obj.getId());
                    List<ShoppingGroupGoods> groupGoods = groupGoodsService.queryByCondition(params);
                    mv.addObject("groupGoods",groupGoods);
                }
                this.goodsService.update(obj);
                if (obj.getGoods_store().getStoreStatus() == 2) {
                    mv.addObject("obj", obj);
                    mv.addObject("goodsStore",store);
                    ShoppingUser  user = userService.queryOneByStoreId(obj.getGoodsStoreId());
                    Map params = new HashMap();
                    params.put("user_id", user.getId());
                    params.put("display", 1);
                    params.put("parent_id","is null");
                    params.put("orderBy","sequence");
                    params.put("sort","asc");
                    List<ShoppingUsergoodsclass> ugcs = this.userGoodsClassService.queryByCondition(params);
                    mv.addObject("ugcs", ugcs);
                    List<ShoppingUsergoodsclass> ugcaccsorry= new ArrayList<>();
                    for(ShoppingUsergoodsclass s: ugcs){
                        params.clear();
                        params.put("parent_id","=".concat(s.getId().toString()));
                        params.put("user_id", store.getUser().getId());
                        List<ShoppingUsergoodsclass> gcs = userGoodsClassService.queryByCondition(params);
                        if(gcs != null){
                            for(ShoppingUsergoodsclass gc: gcs){
                                accessViewTools.addUserGcImgs(gc);
                            }
                        }
                        s.setChilds(gcs);
                        ugcaccsorry.addAll(gcs);
                    }
                    mv.addObject("ugcaccsorry",ugcaccsorry);
                    params.clear();
                    params.put("goods_store_id",obj.getGoodsStoreId());
                    params.put("goods_recommend",1);
                    params.put("id","!= ".concat(obj.getId().toString()));
                    params.put("orderBy","addTime");
                    params.put("sort","desc");
                    params.put("goods_status",0);
                    params.put("start",0);
                    params.put("pageSize",4);
                    List<ShoppingGoodsWithBLOBs> goodsList =this.goodsService.queryByCondition(params);
                    viewTools.mainPhotoHandle(goodsList);
                    mv.addObject("goods_recommend_list",goodsList );
                    params.clear();
                    params.put("evaluate_goods_id", obj.getId());
                    params.put("evaluate_type", "buyer");
                    List<ShoppingEvaluateWithBLOBs> evas = this.evaluateService.queryByCondition(params);
                    mv.addObject("eva_count", Integer.valueOf(evas.size()));
                    int credit =storeViewTools.generic_store_credit(obj.getGoods_store().getId().toString());
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
                    List<ShoppingGoodsWithBLOBs> user_viewed_goods = (List) request.getSession(false).getAttribute("user_viewed_goods");
                    if (user_viewed_goods == null) {
                        user_viewed_goods = new ArrayList();
                    }
                    boolean add = true;
                    for (ShoppingGoodsWithBLOBs goods : user_viewed_goods) {
                        if (goods.getId().equals(obj.getId())) {
                            add = false;
                            break;
                        }
                    }
                    if (add) {
                        if (user_viewed_goods.size() >= 4) {
                            user_viewed_goods.set(1, obj);
                        } else {
                            user_viewed_goods.add(obj);
                        }
                    }
                    request.getSession(false).setAttribute("user_viewed_goods", user_viewed_goods);
                    IpAddress ipAddr = IpAddress.getInstance();
                    String current_ip = CommUtil.getIpAddr(request);
                    String current_city = ipAddr.IpStringToAddress(current_ip);
                    if ((current_city == null) || (current_city.equals(""))) {
                        current_city = "全国";
                    }
                    mv.addObject("current_city", current_city);
                    params.clear();
                    params.put("parent_id","is null");
                    params.put("orderBy","sequence");
                    params.put("sort","asc");
                    List<ShoppingArea> areas = this.areaService.queryByCondition(params);
                    areaViewTools.addManyChilds(areas,false);
                    mv.addObject("areas", areas);
                    generic_evaluate(obj.getGoods_store(), mv);
                    goodsEvalutioin(id,"1",request,mv);
                    viewTools.topHandle(mv,request);
                    viewTools.store_nav(mv,request,store);
                    String area=areaViewTools.generic_area_info(obj.getGoods_store().getArea().getId().toString());
                    mv.addObject("area",area);
                    if(obj.getTransport() != null){
                        if( obj.getTransport().getTransMail()){
                            float c =  transportTools.cal_goods_trans_fee(
                                    obj.getTransport().getId(),
                                    "mail",obj.getGoodsWeight(),
                                    obj.getGoodsVolume() == null?"0.00": obj.getGoodsVolume().toString(),
                                    store.getArea().getAreaname());
                            mv.addObject("mailFee",c);
                        }
                    }
                    if(obj.getTransport() != null){
                        if( obj.getTransport().getTransExpress()){
                            float c =  transportTools.cal_goods_trans_fee(
                                    obj.getTransport().getId(),
                                    "express",
                                    obj.getGoodsWeight(),
                                    obj.getGoodsVolume() == null?"0.00": obj.getGoodsVolume().toString(),
                                    store.getArea().getAreaname());
                            mv.addObject("expressFee",c);
                        }
                    }

                    if(obj.getTransport() != null){
                        if( obj.getTransport().getTransEms()){
                            float c =  transportTools.cal_goods_trans_fee(
                                    obj.getTransport().getId(),"ems",
                                    obj.getGoodsWeight(),
                                    obj.getGoodsVolume() == null?"0.00": obj.getGoodsVolume().toString(),
                                    store.getArea().getAreaname() );
                            mv.addObject("emsFee",c);
                        }
                    }
                    storeViewTools.store_left1(mv,store);
                    storeViewTools.generic_evaluate(store,mv);
                } else {
                    mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                            this.userConfigService.getUserConfig(), 1, request, response);
                    mv.addObject("op_title", "店铺够开通，拒绝访问");
                    mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
                }
            } else {
                mv = new JModelAndView("error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
                mv.addObject("op_title", "该商品未上架，不允许查看");
                mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
            }
        }else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
            mv.addObject("op_title", "该商品未上架，不允许查看");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        return mv;
    }

    public void goodsEvalutioin(String id,String currentPage,HttpServletRequest request,ModelAndView mv){
        ShoppingStoreWithBLOBs store = this.storeService.getObjById(CommUtil.null2Long(id));
        Map<String,Object> map = new HashMap<>();
        map.put("orderBy","addTime");
        map.put("sort","desc");
        map.put("evaluate_goods_id",id);
        map.put("evaluate_type","goods");
        map.put("evaluate_status",0);
        int pageNow =1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow =Integer.parseInt(currentPage);
        }
        map.put("start",(pageNow-1)*8);
        map.put("pageSize",8);
        List<ShoppingEvaluateWithBLOBs> pList = this.evaluateService.queryByCondition(map);
        if(pList != null){
            PageModel page = new PageModel();
            userViewTools.addEvalUsers(pList);
            page.setCurrentPage(pageNow);
            page.setResult(pList);
            int count =this.evaluateService.count(map);
            page.setRowCount(count);
            page.setPages(count%8==0?count/8: count/8+1);
            CommUtil.saveIPageList2ModelAndView(CommUtil.getURL(request) +"/goods_evaluation.htm", "", "", page, mv);
        }
        ShoppingGoodsWithBLOBs goods = this.goodsService .getObjById(CommUtil.null2Long(id));
        mv.addObject("goods", goods);
    }

    @RequestMapping({"/ztc_goods_list.htm"})
    public ModelAndView ztc_goods_list(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType, String goods_view)
    {
        ModelAndView mv = new JModelAndView("ztc_goods_list.html",
                this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        int pageNow =1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow = Integer.parseInt(currentPage);
        }
        Map ztc_map = new HashMap();
        ztc_map.put("ztc_status", Integer.valueOf(3));
        ztc_map.put("goods_status", Integer.valueOf(0));
        ztc_map.put("ztc_begin_time", new Date());
        ztc_map.put("ztc_gold", Integer.valueOf(0));
        ztc_map.put("orderBy","ztc_dredge_price");
        ztc_map.put("sort","desc");
        ztc_map.put("start",(pageNow-1)*10);
        ztc_map.put("pageSize",10);
        List<ShoppingGoodsWithBLOBs> pList= goodsService.queryByCondition(ztc_map);
        viewTools.mainPhotoHandle(pList);
        storeViewTools.addStoreGoodss(pList);
        if(pList != null){
            int count=this.goodsService.count(ztc_map);
            PageModel  page = new PageModel();
            page.setPageSize(10);
           if(count%10==0){
               page.setPages(count/10);
           }else{
               page.setPages(count/10 +1);
           }
            page.setRowCount(count);
            page.setResult(pList);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        viewTools.topHandle(mv, request);
        viewTools.headHandle(mv, request);
        viewTools.nav1Handle(mv);
        viewTools.footerHandle(mv);
        mv.addObject("goods_view", goods_view);
        mv.addObject("user_viewed_goods", request.getSession(false)
                .getAttribute("user_viewed_goods"));
        return mv;
    }



    private Set<Long> getArrayAreaChildIds(List<ShoppingArea> areas) {
        Set ids = new HashSet();
        for (ShoppingArea area : areas) {
            ids.add(area.getId());
            for (ShoppingArea are : area.getChilds()) {
                Set<Long> cids = getAreaChildIds(are);
                for (Long cid : cids) {
                    ids.add(cid);
                }
            }
        }
        return ids;
    }

    private Set<Long> getAreaChildIds(ShoppingArea area) {
        Set<Long> ids = new HashSet();
        ids.add(area.getId());
        for (ShoppingArea are : area.getChilds()) {
            Set<Long> cids = getAreaChildIds(are);
            for (Long cid : cids) {
                ids.add(cid);
            }
        }
        return ids;
    }

    private void   generic_evaluate(ShoppingStoreWithBLOBs store, ModelAndView mv) {
        double description_result = 0.0D;
        double service_result = 0.0D;
        double ship_result = 0.0D;
        if (store.getScId() != null) {
            ShoppingStoreclass sc = this.storeClassService.getObjById(store.getScId());
            float description_evaluate = CommUtil.null2Float(sc.getDescriptionEvaluate());
            float service_evaluate = CommUtil.null2Float(sc.getServiceEvaluate());
            float ship_evaluate = CommUtil.null2Float(sc.getShipEvaluate());
            if (store.getPoint() != null) {
                float store_description_evaluate = CommUtil.null2Float(store
                        .getPoint().getDescriptionEvaluate());
                float store_service_evaluate = CommUtil.null2Float(store
                        .getPoint().getServiceEvaluate());
                float store_ship_evaluate = CommUtil.null2Float(store
                        .getPoint().getShipEvaluate());

                description_result = CommUtil.div(Float.valueOf(store_description_evaluate -
                        description_evaluate), Float.valueOf(description_evaluate));
                service_result = CommUtil.div(Float.valueOf(store_service_evaluate -
                        service_evaluate), Float.valueOf(service_evaluate));
                ship_result = CommUtil.div(Float.valueOf(store_ship_evaluate - ship_evaluate),
                        Float.valueOf(ship_evaluate));
            }
        }
        if (description_result > 0.0D) {
            mv.addObject("description_css", "better");
            mv.addObject("description_type", "高于");
            mv.addObject("description_result",
                    CommUtil.null2String(Double.valueOf(CommUtil.mul(Double.valueOf(description_result), Integer.valueOf(100)))) + "%");
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

    private Set<Long> genericIds(ShoppingGoodsclassWithBLOBs gc) {
        Set ids = new HashSet();
        ids.add(gc.getId());
        if(gc.getChilds() != null){
            for (ShoppingGoodsclassWithBLOBs child : gc.getChilds()) {
                Set<Long> cids = genericIds(child);
                for (Long cid : cids) {
                    ids.add(cid);
                }
                ids.add(child.getId());
            }
        }
        return ids;
    }

    private List<List<ShoppingGoodsspecproperty>> generic_gsp(String gs_ids) {
        List<List<ShoppingGoodsspecproperty>> list = new ArrayList<List<ShoppingGoodsspecproperty>>();
        String[] gs_id_list = gs_ids.substring(1).split("\\|");
        for (String gd_id_info : gs_id_list) {
            String[] gs_info_list = gd_id_info.split(",");
            ShoppingGoodsspecproperty gsp = this.goodsSpecPropertyService .getObjById(CommUtil.null2Long(gs_info_list[0]));
            boolean create = true;
            for (List<ShoppingGoodsspecproperty> gsp_list : list) {
                for (ShoppingGoodsspecproperty gsp_temp : gsp_list)
                {
                    if (gsp_temp.getSpec().getId().equals(gsp.getSpec().getId())) {
                        gsp_list.add(gsp);
                        create = false;
                        break;
                    }
                }
            }
            if (create) {
                List gsps = new ArrayList();
                gsps.add(gsp);
                list.add(gsps);
            }
        }
        return list;
    }


}
