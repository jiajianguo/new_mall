package com.xdj.interfaces.mallinterface.controller.shop;

import com.xdj.interfaces.mallinterface.controller.view.AccessoryViewTools;
import com.xdj.interfaces.mallinterface.controller.view.GoodsCartTools;
import com.xdj.interfaces.mallinterface.controller.view.GoodsViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;

@RestController
public class GroupController {
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private ISysConfigService configService;
    @Resource
    private IGroupService groupService;
    @Resource
    private IGroupGoodsService groupGoodsService;
    @Resource
    private  IGoodsService goodsService;
    @Resource
    private  IGoodsCartService goodsCartService;
    @Resource
    private IAccessoryService accessoryService;
    @Resource
    private IGroupClassService groupClassService;
    @Resource
    private IGroupAreaService groupAreaService;
    @Resource
    private IGroupPriceRangeService groupPriceRangeService;
    @Resource
    private ViewTools viewTools;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private GoodsCartTools goodsCartTools;
    @Resource
    private AccessoryViewTools accessoryViewTools;



    @RequestMapping({"/group.htm"})
    public ModelAndView group(HttpServletRequest request, HttpServletResponse response, String currentPage, String orderBy, String orderType,String gc_id, String gpr_id, String ga_id){
        ModelAndView mv = new JModelAndView("group.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1,request, response);
        Map params = new HashMap();
        params.put("beginTime", new Date());
        params.put("endTime", new Date());
        List<ShoppingGroup> groups = this.groupService.queryByCondition(params);
        if (groups.size() > 0) {
            params.clear();
            params.put("group_id",groups.get(0).getId());
            if (StringUtils.isNotBlank(gc_id)) {
               params.put("gg_gc_id",CommUtil.null2Long(gc_id));
                mv.addObject("gc_id", gc_id);
            }
            if (StringUtils.isNotBlank(ga_id)) {
                params.put("gg_ga_id",CommUtil.null2Long(ga_id));
                mv.addObject("ga_id", ga_id);
            }
            if(StringUtils.isNotBlank(gpr_id)){
                ShoppingGroupPriceRange gpr = this.groupPriceRangeService.getObjById(CommUtil.null2Long(gpr_id));
                if (gpr != null) {
                    params.put("begin_price", BigDecimal.valueOf(gpr.getGprBegin()));
                    params.put("end_price",BigDecimal.valueOf(gpr.getGprEnd()));
                }
                mv.addObject("gpr_id", gpr_id);
            }

            params.put("gg_status",1);
            params.put("orderBy",orderBy != null && orderBy.length()> 0?orderBy: null);
            params.put("sort",orderType != null && orderType.length() >0 ?orderType:null);
            int pageNow = 1;
            if(StringUtils.isNotBlank(currentPage)){
                pageNow= Integer.parseInt(currentPage);
            }
            params.put("start",(pageNow -1)*15);
            params.put("pageSize",15);
            List<ShoppingGroupGoods> pList =groupGoodsService.queryByCondition(params);
            if(pList != null){
                goodsViewTools.addggGoods(pList);
                List<ShoppingGroupGoods> list=goodsViewTools.addGgImg(pList);
                int count = groupGoodsService.count(params);
                PageModel page = new PageModel();
                page.setCurrentPage(pageNow);
                page.setResult(list);
                page.setRowCount(count);
                page.setPageSize(15);
                page.setPages(count/15);
                CommUtil.saveIPageList2ModelAndView("","","",page,mv);
            }
            params.clear();
            params.put("parent_id","is null");
            params.put("orderBy","gc_sequence");
            params.put("sort","asc");
            //CommUtil.saveIPageList2ModelAndView("", "", "", pList, mv);
            List<ShoppingGroupClass> gcs = this.groupClassService.queryByCondition(params);
            params.clear();
            params.put("orderBy","gpr_begin");
            params.put("sort","asc");
            List<ShoppingGroupPriceRange> gprs = this.groupPriceRangeService.queryByCondition(params);
            mv.addObject("gprs", gprs);
            mv.addObject("groupGcs", gcs);
            mv.addObject("group", groups.get(0));
            if ((orderBy == null) || (orderBy.equals(""))) {
                orderBy = "addTime";
            }
            if ((orderType == null) || (orderType.equals(""))) {
                orderType = "desc";
            }
            mv.addObject("order_type", CommUtil.null2String(orderBy) + "_" + CommUtil.null2String(orderType));
            viewTools.topHandle(mv,request);
            viewTools.groupHead(mv,ga_id);
            viewTools.footerHandle(mv);
            viewTools.nav1Handle(mv);
        }
        return mv;
    }

    @RequestMapping({"/group_head.htm"})
    public ModelAndView group_head(HttpServletRequest request, HttpServletResponse response, String ga_id) {
        ModelAndView mv = new JModelAndView("group_head.html", this.configService
                .getSysConfig(), this.userConfigService.getUserConfig(), 1,
                request, response);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("parent_id", "is null");
        params.put("orderBy", "ga_sequence");
        params.put("sort", "asc");
        List<ShoppingGroupArea> gas = this.groupAreaService.queryByCondition(params);
                //.query("select obj from GroupArea obj where obj.parent.id is null order by obj.ga_sequence asc", null, -1, -1);
        mv.addObject("gas", gas);
        if ((ga_id != null) && (!ga_id.equals("")))
            mv.addObject("ga", this.groupAreaService.getObjById(
                    CommUtil.null2Long(ga_id)).getGaName());
        else {
            mv.addObject("ga", "全国");
        }
        return mv;
    }



    @RequestMapping({"/group_view.htm"})
    public ModelAndView group_view(HttpServletRequest request, HttpServletResponse response, String id,String ga_id) {
        ModelAndView mv = new JModelAndView("group_view.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingGroupGoods obj = this.groupGoodsService.getObjById(CommUtil.null2Long(id));
        ShoppingGroup group=groupService.getObjById(obj.getGroupId());
        obj.setGroup(group);
        ShoppingGoodsWithBLOBs goods = goodsService.getObjById(obj.getGgGoodsId());
        goodsViewTools.setStore(goods);
        obj.setGg_goods(goods);
        accessoryViewTools.addGroupImg(obj);
        ShoppingUser user = SecurityUserHolder.getCurrentUser();
        boolean view = false;
        if(group!=null){
            if ((group.getBegintime().before(new Date())) &&
                    (group.getEndtime().after(new Date()))) {
                view = true;
            }
        }

        if ((user != null) && (user.getUserrole().indexOf("ADMIN") >= 0)) {
            view = true;
        }
        if (view) {
            mv.addObject("obj", obj);
            Map params = new HashMap();
            params.put("beginTime", new Date());
            params.put("endTime", new Date());
            params.put("status", Integer.valueOf(0));
            List groups = this.groupService.queryByCondition(params);
                    //.query("select obj from Group obj where obj.beginTime<=:beginTime and obj.endTime>=:endTime and obj.status=:status", params, -1, -1);
            if (groups.size() > 0) {
               params.clear();
               params.put("gg_status",Integer.valueOf(1));
               params.put("group_id",group.getId());
               params.put("goods_id",obj.getGgGoodsId());
               params.put("orderBy","gg_recommend");
               params.put("sort","desc");
               List<ShoppingGroupGoods> pList =groupGoodsService.queryByCondition(params);
               goodsViewTools.addggGoods(pList);
                mv.addObject("hot_ggs", pList);
                mv.addObject("group", groups.get(0));
            }

            //gqo.setPageSize(Integer.valueOf(2));
            params.clear();
            params.put("orderBy","addTime");
            params.put("sort","desc");
            params.put("goods_store_id",goods.getGoodsStoreId());
            params.put("goods_recommend",Boolean.valueOf(true));
            params.put("goods_status",Integer.valueOf(0));
            params.put("start",Integer.valueOf(0));
            params.put("pageSize",Integer.valueOf(2));
            List<ShoppingGoodsWithBLOBs> goodslist = this.goodsService.queryByCondition(params);
            List<ShoppingGoodsWithBLOBs> goodsWithBLOBs=goodsViewTools.addRecommendImg(goodslist);
            mv.addObject("recommend_goods",goodsWithBLOBs );
            params.clear();
            params.put("goods_id", obj.getGgGoodsId());
            List<ShoppingGoodscart> gc_list = this.goodsCartService.queryByCondition(params);
                   // .query("select obj from GoodsCart obj where :gg member of obj.goods.group_goods_list", params, 0, 4);
            List gcs = new ArrayList();
            for (ShoppingGoodscart gc : gc_list) {
                if (!gcs.contains(gc))
                    goodsCartTools.addOfUser(gc);
                    gcs.add(gc);
            }
            mv.addObject("gcs", gcs);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "团购商品参数错误");
            mv.addObject("url", CommUtil.getURL(request) + "/index.htm");
        }
        viewTools.topHandle(mv,request);
        viewTools.groupHead(mv,ga_id);
        viewTools.footerHandle(mv);
        viewTools.nav1Handle(mv);
        return mv;
    }

    @RequestMapping({"/group_list.htm"})
    public ModelAndView group_list(HttpServletRequest request, HttpServletResponse response, String currentPage, String time,String ga_id) {
        ModelAndView mv = new JModelAndView("group_list.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        Map params =new HashMap();
        if (time.equals("soon")){
            params.put("beginTime",new Date());
        }
        if (time.equals("history")){
            params.put("endTime",new Date());
        }
        params.put("orderBy","addTime");
        params.put("sort","desc");
        int pageNow = 1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow= Integer.parseInt(currentPage);
        }
        params.put("start",(pageNow -1)*6);
        params.put("pageSize",6);
        List<ShoppingGroup> pList =groupService.queryBytime(params);
        if(pList != null){
            for (ShoppingGroup group : pList) {
                goodsViewTools.query_goods(group.getId()+"");
            }
            int count = groupService.count(params);
            PageModel page = new PageModel();
            page.setCurrentPage(pageNow);
            page.setResult(pList);
            page.setRowCount(count);
            page.setPageSize(10);
            page.setPages(count/10);
            CommUtil.saveIPageList2ModelAndView("","","",page,mv);
        }
        mv.addObject("time", time);
        viewTools.topHandle(mv,request);
        viewTools.groupHead(mv,ga_id);
        viewTools.footerHandle(mv);
        viewTools.nav1Handle(mv);
        return mv;
    }

}
