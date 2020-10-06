package com.xdj.interfaces.mallinterface.controller.shop;

import com.xdj.interfaces.mallinterface.controller.view.*;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.mv.PageQuery;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.interfaces.mallinterface.util.LuceneResult;
import com.xdj.interfaces.mallinterface.util.LuceneVo;
import com.xdj.www.entity.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.lucene.search.Sort;
import org.apache.lucene.search.SortField;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.*;

/**
 * @author Administrator
 */
@RestController
public class SearchController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private LuceneService luceneService;
    @Resource
    private IStoreClassService storeClassService;
    @Resource
    private IAreaService areaService;
    @Resource
    private IStoreService storeService;
    @Resource
    private IStoreGradeService storeGradeService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private AccessoryViewTools accessoryViewTools;
    @Resource
    private ViewTools viewTools;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private StoreViewTools storeViewTools;
    @Resource
    private AreaViewTools areaViewTools;
    @Resource
    private StoreClassViewTools storeClassViewTools;
    @Resource
    private UserViewTools userViewTools;


    private final static Logger log = LoggerFactory.getLogger("search");

    @RequestMapping({"/search.htm"})
    public ModelAndView search(HttpServletRequest request, HttpServletResponse response, String type, String keyword, String currentPage,
                               String orderBy, String orderType, String store_price_begin,  String store_price_end, String view_type,
                               String sc_id, String storeGrade_id, String checkbox_id, String storepoint, String area_id, String area_name,
                               String goods_view) throws IOException, ParseException {
        ModelAndView mv = new JModelAndView("search_goods_list.html",this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        String shopping_view_type = com.xdj.www.core.tools.CommUtil.null2String(request.getSession().getAttribute("shopping_view_type"));
        if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
            mv = new JModelAndView("wap/search_goods_list.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        int pageNow =1;
        String data = new String("");
        if(StringUtils.isNotBlank(currentPage)){
            pageNow= Integer.parseInt(currentPage);
        }
        if ((type == null) || (type.equals(""))) {
            type = "goods";
        }
        keyword = CommUtil.decode(keyword);
        if ("store".equals(type)) {
            mv = new JModelAndView("store_list.html", this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
            Map<String,Object> params = new HashMap<String,Object>();
            params.put("orderBy","addTime");
            params.put("sort","desc");
            if (StringUtils.isNotBlank(keyword)) {
                params.put("store_name","%" + keyword + "%");
                mv.addObject("store_name", keyword);
            }
            if (StringUtils.isNotBlank(sc_id)) {
                ShoppingStoreclass storeclass = this.storeClassService.getObjById(CommUtil.null2Long(sc_id));
                Set ids = getStoreClassChildIds(storeclass);
                params.put("sc_ids",ids);
                mv.addObject("sc_id", sc_id);
            }
            if ((storeGrade_id != null) && (!storeGrade_id.equals(""))) {
                params.put("grade_id", CommUtil.null2Long(storeGrade_id));
                mv.addObject("storeGrade_id", storeGrade_id);
            }
            if ((orderBy != null) && (!orderBy.equals(""))) {
                //sqo.setOrderBy(orderBy);
                params.put("orderBy",orderBy);
                if (orderBy.equals("addTime")) {
                    orderType = "asc";
                }else {
                    orderType = "desc";
                }
                params.put("sort",orderType);
                mv.addObject("orderBy", orderBy);
                mv.addObject("orderType", orderType);
            }
            if ((checkbox_id != null) && (!checkbox_id.equals(""))) {
                params.put("obj_checkbox_id",Boolean.valueOf(true));
                mv.addObject("checkbox_id", checkbox_id);
            }
            if ((storepoint != null) && (!storepoint.equals(""))) {
                params.put("store_evaluate1",new BigDecimal(storepoint));
                //sqo.addQuery("obj.sp.store_evaluate1", new SysMap("sp_store_evaluate1", new BigDecimal(storepoint)), ">=");
                mv.addObject("storepoint", storepoint);
            }
            if ((area_id != null) && (!area_id.equals(""))) {
                mv.addObject("area_id", area_id);
                ShoppingArea area = this.areaService.getObjById(CommUtil.null2Long(area_id));
                Set area_ids = getAreaChildIds(area);
                params.put("area_ids", area_ids);
                data+="area_id="+area_ids+" ";
                //sqo.addQuery("obj.area.id in (:ids)", params);
            }
            if ((area_name != null) && (!area_name.equals(""))) {
                mv.addObject("area_name", area_name);
                data+="area_name="+area_name+" ";
            }
            params.put("store_status",2);
            params.put("pageSize",20);
            params.put("start",(pageNow-1)*20);
            log.info("--------------店铺查询开始------------");
            List<ShoppingStoreWithBLOBs> pList = this.storeService.pageList(params);
            log.info("--------------店铺查询结束------------");
            if(pList != null){
                userViewTools.addStoreUsers(pList);
                accessoryViewTools.addStoreLogos(pList);
                storeViewTools.addStoreGoodslist(pList);
                storeViewTools.addRecommendGoods(pList);
                areaViewTools.addStoreAreas(pList);
                storeViewTools.addPoints(pList);
                storeClassViewTools.addScs(pList,true,false);
                PageModel page = new PageModel();
                int count = storeService.count(params);
                page.setResult(pList);
                page.setCurrentPage(pageNow);
                if(count%20==0){
                    page.setPages(count/20);
                }else{
                    page.setPages(count/20+1);
                }
                page.setPageSize(20);
                page.setRowCount(count);
                CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
            }
            params.clear();
            params.put("parent_id","is null");
            params.put("orderBy","sequence");
            params.put("sort","asc");
            List<ShoppingStoreclass> scs = this.storeClassService.queryByCondition(params);
            storeViewTools.addStoreclassChilds(scs);
            params.clear();
            params.put("common",Boolean.valueOf(true));
            params.put("orderBy","sequence");
            params.put("sort","asc");
            List<ShoppingArea> areas = this.areaService.queryByCondition(params);
            mv.addObject("areas", areas);
            mv.addObject("scs", scs);
            params.clear();
            params.put("orderBy","sequence");
            params.put("sort","asc");
            List<ShoppingStoregrade> storeGrades = this.storeGradeService.queryByCondition(params);
            mv.addObject("storeGrades", storeGrades);
        }

        if (this.configService.getSysConfig().getZtcStatus()) {
            Map ztc_map = new HashMap();
            ztc_map.put("ztc_status", Integer.valueOf(3));
            ztc_map.put("now_date", new Date());
            ztc_map.put("ztc_gold", Integer.valueOf(0));
            ztc_map.put("start",0);
            ztc_map.put("pageSize",5);
            ztc_map.put("orderBy","ztc_dredge_price");
            ztc_map.put("sort","desc");
            List<ShoppingGoodsWithBLOBs> ztc_goods = this.goodsService.queryByCondition(ztc_map);
            accessoryViewTools.addMainPhotos(ztc_goods);
            mv.addObject("ztc_goods", ztc_goods);
        }

        if ((type.equals("goods")) && (!CommUtil.null2String(keyword).equals(""))) {
            viewTools.nav1Handle(mv);
            viewTools.topHandle(mv,request);
            viewTools.headHandle(mv,request);
            viewTools.footerHandle(mv);
            boolean order_type = true;
            String order_by = "";
            ShoppingGoodsWithBLOBs good = new ShoppingGoodsWithBLOBs();
            good.setGoodsName(keyword);
            if (CommUtil.null2String(orderType).equals("asc")) {
                order_type = false;
            }
            if (CommUtil.null2String(orderType).equals("")) {
                order_type = true;
            }
            if (CommUtil.null2String(orderBy).equals("store_price")) {
                order_by = "store_price";
            }
            if (CommUtil.null2String(orderBy).equals("goods_salenum")) {
                order_by = "goods_salenum";
            }
            if (CommUtil.null2String(orderBy).equals("goods_collect")) {
                order_by = "goods_collect";
            }
            if (CommUtil.null2String(orderBy).equals("goods_addTime")) {
                order_by = "addTime";
            }
            Sort sort = new Sort();
            if (!CommUtil.null2String(order_by).equals("")) {
                sort = new Sort(new SortField(order_by, SortField.Type.STRING,order_type));
            }else{
                sort.setSort(new SortField("addTime", SortField.Type.STRING,order_type));
            }
            PageQuery query = new PageQuery();
            query.setGoods(good);
            query.setPageNow(pageNow);
            query.setPageSize(16);
            query.setSort(sort);
            LuceneResult pList = luceneService.search(query,CommUtil.null2Float(store_price_begin),CommUtil.null2Float(store_price_end), null, sort);
            for (LuceneVo vo : pList.getVo_list()) {
                ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(vo.getVo_id());
                accessoryViewTools.addMainPhoto(goods);
                goodsViewTools.setStore(goods);
                goodsViewTools.addEvalute(goods);
                pList.getGoods_list().add(goods);
            }
            CommUtil.saveLucene2ModelAndView("goods", pList, mv);
            ShoppingGoodsclass gc = new ShoppingGoodsclass();
            gc.setClassname("商品搜索结果");
            mv.addObject("serachGc", gc);
            mv.addObject("store_price_end", store_price_end);
            mv.addObject("store_price_begin", store_price_begin);
            mv.addObject("keyword", keyword);
            mv.addObject("orderBy", orderBy);
            mv.addObject("orderType", orderType);
            if (CommUtil.null2String(goods_view).equals("list")) {
                goods_view = "list";
            }else {
                goods_view = "thumb";
            }
            mv.addObject("goods_view", goods_view);
        }
        if (CommUtil.null2String(view_type).equals("")) {
            view_type = "list";
        }
        mv.addObject("view_type", view_type);
        mv.addObject("type", type);
        return mv;
    }

    private Set<Long> getStoreClassChildIds(ShoppingStoreclass sc) {
        Set ids = new HashSet();
        ids.add(sc.getId());
        storeClassViewTools.addChild(sc);
        for (ShoppingStoreclass storeclass : sc.getChilds()) {
            Set<Long> cids = getStoreClassChildIds(storeclass);
            for (Long cid : cids) {
                ids.add(cid);
            }
        }
        return ids;
    }

    private Set<Long> getAreaChildIds(ShoppingArea area) {
        Set ids = new HashSet();
        ids.add(area.getId());
        for (ShoppingArea are : area.getChilds()) {
            Set<Long> cids = getAreaChildIds(are);
            for (Long cid : cids) {
                ids.add(cid);
            }
        }
        return ids;
    }
}
