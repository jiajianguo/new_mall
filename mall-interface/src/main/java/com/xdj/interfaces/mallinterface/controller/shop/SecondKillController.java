package com.xdj.interfaces.mallinterface.controller.shop;

import com.alibaba.fastjson.JSONArray;
import com.xdj.interfaces.mallinterface.controller.view.AccessoryViewTools;
import com.xdj.interfaces.mallinterface.controller.view.GoodsViewTools;
import com.xdj.interfaces.mallinterface.controller.view.StoreViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.mv.SeckillModel;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.tools.IpAddress;
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
import java.util.*;

/**
 * @author Administrator
 */
@RestController
public class SecondKillController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private ISeckillService seckillService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private IStoreService storeService;
    @Resource
    private IGroupPriceRangeService groupPriceRangeService;
    @Resource
    private ViewTools viewTools;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private StoreViewTools storeViewTools;
    @Resource
    private AccessoryViewTools accessoryViewTools;
    @Resource
    private IUserService userService;
    @Resource
    private IStoreClassService storeClassService;
    @Resource
    private IUserGoodsClassService userGoodsClassService;
    @Resource
    private IEvaluateService evaluateService;
    @Resource
    private IAreaService areaService;
    private final static Logger log = LoggerFactory.getLogger("seckill");

    @RequestMapping("/secKill.htm")
    public final ModelAndView secKill (HttpServletRequest request , HttpServletResponse response,String id){
        ModelAndView mv = new JModelAndView("skillDetail.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(),1, request, response);
        ShoppingSecondsKill obj = this.seckillService.getObjById(Long.valueOf(Long.parseLong(id)));
        if(obj != null){
            ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(obj.getSgGoodsId());
            if(goods != null){
               ShoppingStoreWithBLOBs store = storeService.getObjById(goods.getGoodsStoreId());
                if(store.getAreaId() != null){
                    storeViewTools.addArea(store);
                }
                storeViewTools.addGoods(store);
                storeViewTools.addUser(store);
                storeViewTools.addBanner(store);
                storeViewTools.addStoreLogo(store);
                storeViewTools.addPoint(store);
                goodsViewTools.setGroup(goods);
                goodsViewTools.addTransport(goods);
                goodsViewTools.addDeliveryGoods(goods);
                goodsViewTools.addSpec(goods);
                goodsViewTools.addGoodsSpecis(goods);
                accessoryViewTools.addMainPhoto(goods);
                goods.setGoods_store(store);
                viewTools.store_nav(mv,request,store);
                if (goods.getGoodsStatus() == 0) {
                    goods.setGoodsClick(goods.getGoodsClick() + 1);
                    if ((this.configService.getSysConfig().getZtcStatus()) && (goods.getZtcStatus() == 2)) {
                        goods.setZtcClickNum(goods.getZtcClickNum() + 1);
                    }
                    if ((goods.getGroup() != null) && (goods.getGroupBuy() == 2)) {
                        ShoppingGroup group = goods.getGroup();
                        if (group.getEndtime().before(new Date())) {
                            goods.setGroup(null);
                            goods.setGroupBuy(0);
                            goods.setGoodsCurrentPrice(goods.getStorePrice());
                        }
                    }
                    this.goodsService.update(goods);
                    if (goods.getGoods_store().getStoreStatus() == 2) {
                        obj.setGoods(goods);
                        mv.addObject("obj", obj);
                        mv.addObject("goodsStore", store);
                        ShoppingUser user = userService.queryOneByStoreId(goods.getGoodsStoreId());
                        Map params = new HashMap();
                        params.put("user_id", user.getId());
                        params.put("display", 1);
                        params.put("parent_id", "is null");
                        params.put("orderBy", "sequence");
                        params.put("sort", "asc");
                        List<ShoppingUsergoodsclass> ugcs = this.userGoodsClassService.queryByCondition(params);
                        mv.addObject("ugcs", ugcs);
                        params.clear();
                        params.put("goods_store_id", goods.getGoodsStoreId());
                        params.put("goods_recommend", 1);
                        params.put("id", "!= ".concat(goods.getId().toString()));
                        params.put("orderBy", "addTime");
                        params.put("sort", "desc");
                        params.put("goods_status", 0);
                        params.put("start", 0);
                        params.put("pageSize", 4);
                        List<ShoppingGoodsWithBLOBs> goodsList = this.goodsService.queryByCondition(params);
                        viewTools.mainPhotoHandle(goodsList);
                        mv.addObject("goods_recommend_list", goodsList);
                        params.clear();
                        params.put("evaluate_goods_id", obj.getId());
                        params.put("evaluate_type", "buyer");
                        List<ShoppingEvaluateWithBLOBs> evas = this.evaluateService.queryByCondition(params);
                        mv.addObject("eva_count", Integer.valueOf(evas.size()));
                        int credit = storeViewTools.generic_store_credit(goods.getGoods_store().getId().toString());
                        if (0 < credit && credit < 10) {
                            credit = credit / 2 + 1;
                        }
                        if (credit >= 10 && credit < 20) {
                            credit = (credit - 10) / 2 + 1;
                        }
                        if (credit >= 20) {
                            credit = (credit - 20) / 2 + 1;
                        }
                        if (credit > 5) {
                            credit = 5;
                        }
                        List<Integer> credits = new ArrayList();
                        int count = 0;
                        for (int i = 0; i < credit; i++) {
                            credits.add(count + 1);
                        }
                        mv.addObject("credit", credit);
                        mv.addObject("credits", credits);
                        List<ShoppingGoodsWithBLOBs> user_viewed_goods = (List) request.getSession(false).getAttribute("user_viewed_goods");
                        if (user_viewed_goods == null) {
                            user_viewed_goods = new ArrayList();
                        }
                        boolean add = true;
                        for (ShoppingGoodsWithBLOBs good : user_viewed_goods) {
                            if (good.getId().equals(obj.getId())) {
                                add = false;
                                break;
                            }
                        }
                        if (add) {
                            if (user_viewed_goods.size() >= 4) {
                                user_viewed_goods.set(1, goods);
                            } else {
                                user_viewed_goods.add(goods);
                            }
                        }
                        request.getSession(false).setAttribute("user_viewed_goods", user_viewed_goods);
                        IpAddress ipAddr = IpAddress.getInstance();
                        String current_ip = com.xdj.www.core.tools.CommUtil.getIpAddr(request);
                        String current_city = ipAddr.IpStringToAddress(current_ip);
                        if ((current_city == null) || (current_city.equals(""))) {
                            current_city = "全国";
                        }
                        mv.addObject("current_city", current_city);
                        params.clear();
                        params.put("parent_id", "is null");
                        params.put("orderBy", "sequence");
                        params.put("sort", "asc");
                        List<ShoppingArea> areas = this.areaService.queryByCondition(params);
                        mv.addObject("areas", areas);
                        generic_evaluate(goods.getGoods_store(), mv);
                    }

                }
            }
            viewTools.topHandle(mv,request);
            viewTools.headHandle(mv,request);
            viewTools.footerHandle(mv);
        }
        return mv;
    }

    @RequestMapping("secKillList.htm")
    public final ModelAndView secKillList (HttpServletRequest request , HttpServletResponse response,String currentPage,String orderBy,String orderType){
        ModelAndView mv = new JModelAndView("seckill.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(),1, request, response);
        viewTools.topHandle(mv,request);
        viewTools.headHandle(mv,request);
        viewTools.nav1Handle(mv);
        viewTools.footerHandle(mv);
        Map params = new HashMap();
        params.put("start_time", new Date());
        params.put("finish_time", new Date());
        int pageNow = 1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow= Integer.parseInt(currentPage);
        }
        params.put("sg_status",1);
        params.put("count",0);
        params.put("start",(pageNow -1)*12);
        params.put("pageSize",12);
        //分组查询开始时间
        List<ShoppingSecondsKill> list = seckillService.queryByCondition(params);
        JSONArray array = new JSONArray();
        Map<String,List<ShoppingSecondsKill>> data = new HashMap<>();
        if(list != null){
            ShoppingSecondsKillExample example = new ShoppingSecondsKillExample();
            example.createCriteria().andStartTimeGreaterThan(new Date()).andCountGreaterThan(0L).andSgStatusEqualTo(1);
            Long count =seckillService.selectExample(example);
            PageModel page = new PageModel();
            page.setRowCount(count.intValue());
            page.setPageSize(12);
            page.setCurrentPage(pageNow);
            for(ShoppingSecondsKill s: list){
                goodsViewTools.addGoods(s);
                if(data.containsKey(s.getBeginTime())){
                    List<ShoppingSecondsKill> k =data.get(s.getBeginTime());
                    k.add(s);
                    data.put(s.getBeginTime(),k);
                }else{
                    List<ShoppingSecondsKill> k =new ArrayList<>();
                    k.add(s);
                    data.put(s.getBeginTime(),k);
                }
            }
            data.forEach((k,v) ->{
                SeckillModel obj = new SeckillModel();
                obj.setTime(k);
                obj.setSecKills(v);
                array.add(obj);
            });
            page.setResult(array);
            CommUtil.saveIPageList2ModelAndView("","","",page,mv);
        }
        params.clear();
        params.put("orderBy","gpr_begin");
        params.put("sort","asc");
        List<ShoppingGroupPriceRange> gprs = this.groupPriceRangeService.queryByCondition(params);
        mv.addObject("gprs",gprs);
        return mv;
    }

    private void generic_evaluate(ShoppingStoreWithBLOBs store, ModelAndView mv) {
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
                float store_ship_evaluate = CommUtil.null2Float(store.getPoint().getShipEvaluate());
                description_result = CommUtil.div(Float.valueOf(store_description_evaluate - description_evaluate), Float.valueOf(description_evaluate));
                service_result = CommUtil.div(Float.valueOf(store_service_evaluate -service_evaluate), Float.valueOf(service_evaluate));
                ship_result =CommUtil.div(Float.valueOf(store_ship_evaluate - ship_evaluate), Float.valueOf(ship_evaluate));
            }
        }
        if (description_result > 0.0D) {
            mv.addObject("description_css", "better");
            mv.addObject("description_type", "高于");
            mv.addObject("description_result",
                    com.xdj.www.core.tools.CommUtil.null2String(Double.valueOf(com.xdj.www.core.tools.CommUtil.mul(Double.valueOf(description_result), Integer.valueOf(100)))) + "%");
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
                    com.xdj.www.core.tools.CommUtil.null2String(Double.valueOf(com.xdj.www.core.tools.CommUtil.mul(Double.valueOf(-description_result), Integer.valueOf(100)))) +
                            "%");
        }
        if (service_result > 0.0D) {
            mv.addObject("service_css", "better");
            mv.addObject("service_type", "高于");
            mv.addObject("service_result",
                    com.xdj.www.core.tools.CommUtil.null2String(Double.valueOf(com.xdj.www.core.tools.CommUtil.mul(Double.valueOf(service_result), Integer.valueOf(100)))) +
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
                    com.xdj.www.core.tools.CommUtil.null2String(Double.valueOf(com.xdj.www.core.tools.CommUtil.mul(Double.valueOf(-service_result), Integer.valueOf(100)))) +
                            "%");
        }
        if (ship_result > 0.0D) {
            mv.addObject("ship_css", "better");
            mv.addObject("ship_type", "高于");
            mv.addObject("ship_result",
                    com.xdj.www.core.tools.CommUtil.null2String(Double.valueOf(com.xdj.www.core.tools.CommUtil.mul(Double.valueOf(ship_result), Integer.valueOf(100)))) + "%");
        }
        if (ship_result == 0.0D) {
            mv.addObject("ship_css", "better");
            mv.addObject("ship_type", "持平");
            mv.addObject("ship_result", "-----");
        }
        if (ship_result < 0.0D) {
            mv.addObject("ship_css", "lower");
            mv.addObject("ship_type", "低于");
            mv.addObject("ship_result", com.xdj.www.core.tools.CommUtil.null2String(Double.valueOf(com.xdj.www.core.tools.CommUtil.mul(Double.valueOf(-ship_result), Integer.valueOf(100)))) + "%");
        }
    }


}
