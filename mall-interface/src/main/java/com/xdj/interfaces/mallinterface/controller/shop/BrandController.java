package com.xdj.interfaces.mallinterface.controller.shop;

import com.google.gson.Gson;
import com.xdj.interfaces.mallinterface.controller.view.BrandViewTools;
import com.xdj.interfaces.mallinterface.controller.view.GoodsViewTools;
import com.xdj.interfaces.mallinterface.controller.view.StoreViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.BrandBlos;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.entity.ShoppingBrandcategory;
import com.xdj.www.entity.ShoppingGoodsWithBLOBs;
import com.xdj.www.entity.ShoppingGoodsbrand;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.*;

@RestController
public class BrandController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private IGoodsBrandService goodsBrandService;
    @Resource
    private IGoodsBrandCategoryService goodsBrandCategorySerivce;
    @Resource
    private StoreViewTools storeViewTools;
    @Resource
    private ViewTools viewTools;
    @Resource
    private BrandViewTools brandViewTools;
    @Resource
    private GoodsViewTools goodsViewTools;
    private static Logger log = LoggerFactory.getLogger("brand");

    @RequestMapping({"/brand.htm"})
    public ModelAndView brand(HttpServletRequest request, HttpServletResponse response, String gbc_id)
    {
        ModelAndView mv = new JModelAndView("brand.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);

        String shopping_view_type = CommUtil.null2String( request.getSession( false ).getAttribute( "shopping_view_type" ) );

        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/brand.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        Map params = new HashMap();
        params.put("orderBy","addTime");
        params.put("sort","asc");
        List<ShoppingBrandcategory> gbcs = this.goodsBrandCategorySerivce.queryByCondition(params);
        params.clear();
        params.put("recommend", Boolean.valueOf(true));
        params.put("audit", Integer.valueOf(1));
        params.put("orderBy","sequence");
        params.put("sort","asc");
        params.put("start",0);
        params.put("apgeSize",10);
        List<ShoppingGoodsbrand> gbs = this.goodsBrandService.queryByCondition(params);
        brandViewTools.addLogos(gbs);
        mv.addObject("gbs", gbs);
        mv.addObject("gbcs", gbcs);
        List<ShoppingGoodsbrand> brands = new ArrayList();
        if ((gbc_id != null) && (!gbc_id.equals(""))) {
            mv.addObject("gbc_id", gbc_id);
            params.clear();
            params.put("gbc_id", CommUtil.null2Long(gbc_id));
            params.put("audit", Integer.valueOf(1));
            params.put("orderBy","sequence");
            params.put("sort","asc");

            brands = this.goodsBrandService.queryByCondition(params);
        } else {
            params.clear();
            params.put("audit", Integer.valueOf(1));
            params.put("orderBy","sequence");
            params.put("sort","asc");
            brands = this.goodsBrandService.queryByCondition(params);
        }
       List<BrandBlos> all_list = new ArrayList();
        String list_word = "A,B,C,D,E,F,G,H,I,J,K,L,M,N,O,P,Q,R,S,T,U,V,W,X,Y,Z";
        String[] words = list_word.split(",");
        List<String> w =Arrays.asList(list_word);
        for (ShoppingGoodsbrand gb : brands) {
            if(gb.getBrandlogoId() != null){
                brandViewTools.addLogo(gb);
            }
        }
       for (String word : words) {
            List<ShoppingGoodsbrand> brand_list = new ArrayList();
            for (ShoppingGoodsbrand gb : brands) {
                if(gb.getBrandlogoId() != null){
                    brandViewTools.addLogo(gb);
                }
                if ((CommUtil.null2String(gb.getFirstWord()).equals("")) ||(!word.equals(gb.getFirstWord().toUpperCase()))) {
                    continue;
                }
                brand_list.add(gb);
            }
            if(brand_list.size()>0){
                BrandBlos b = new BrandBlos();
                b.setBrands(brand_list);
                b.setWord(word);
                all_list.add(b);
            }
        }
        mv.addObject("words",words);
        mv.addObject("all_list", all_list);
        viewTools.topHandle(mv,request);
        viewTools.headHandle(mv,request);
        viewTools.nav1Handle(mv);
        viewTools.footerHandle(mv);
        return mv;
    }

    @RequestMapping({"/brand_goods.htm"})
    public ModelAndView brand_view(HttpServletRequest request, HttpServletResponse response, String id, String currentPage, String orderBy, String orderType, String store_price_begin, String store_price_end, String op, String goods_name)
    {
        ModelAndView mv = new JModelAndView("brand_goods.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        String shopping_view_type = CommUtil.null2String( request.getSession( false ).getAttribute( "shopping_view_type" ) );
        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/brand_goods.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        if ((op != null) && (!op.equals(""))) {
            mv.addObject("op", op);
        }
        ShoppingGoodsbrand gb = this.goodsBrandService.getObjById(CommUtil.null2Long(id));
        brandViewTools.addLogo(gb);
        viewTools.topHandle(mv,request);
        viewTools.headHandle(mv,request);
        viewTools.nav1Handle(mv);
        viewTools.footerHandle(mv);
        mv.addObject("gb", gb);
        Map params = new HashMap();
        params.put("recommend", Boolean.valueOf(true));
        params.put("audit", Integer.valueOf(1));
        params.put("orderBy","sequence");
        params.put("sort","asc");
        params.put("start",0);
        params.put("apgeSize",10);
        List<ShoppingGoodsbrand> gbs = this.goodsBrandService.queryByCondition(params);
        brandViewTools.addLogos(gbs);
        mv.addObject("gbs", gbs);
        mv.addObject("starStores", this.storeViewTools.query_recommend_store(2));
        params.clear();
        //GoodsQueryObject gqo = new GoodsQueryObject(currentPage, mv, orderBy, orderType);
        params.put("orderBy",orderBy);
        params.put("sort",orderType);
        if ((store_price_begin != null) && (!store_price_begin.equals(""))) {
            params.put("store_price_begin",CommUtil.null2Double(store_price_begin));

            mv.addObject("store_price_begin", store_price_begin);
        }
        if ((store_price_end != null) && (!store_price_end.equals(""))) {
            params.put("store_price_end",CommUtil.null2Double(store_price_end));
            mv.addObject("store_price_end", store_price_end);
        }
        if ((goods_name != null) && (!goods_name.equals(""))) {
            params.put("goods_name", "%".concat(goods_name.trim()).concat("%"));
            mv.addObject("goods_name", goods_name);
        }
        params.put("goods_brand_id", gb.getId());
        params.put("goods_status",0);
        int pageNow =1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow = Integer.parseInt(currentPage);
        }
        params.put("start",0);
        params.put("pageSize",20);
        List<ShoppingGoodsWithBLOBs> pList = this.goodsService.queryByCondition(params);
        if(pList != null){
            int count=this.goodsService.count(params);
            viewTools.mainPhotoHandle(pList);
            for(ShoppingGoodsWithBLOBs s: pList){
                goodsViewTools.setStore(s);
                storeViewTools.addStoreGoods(s.getGoods_store());
            }
            goodsViewTools.addEvalutes(pList);
            goodsViewTools.addStoreGrade(pList);
            //goodsViewTools.addStoreGrade(pList);
            PageModel page = new PageModel();
            page.setPageSize(20);
            page.setPages(count/20);
            page.setRowCount(count);
            page.setResult(pList);
            page.setCurrentPage(1);
            com.xdj.interfaces.mallinterface.util.CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        return mv;
    }

    /**
     * wap根据品牌查询商品
     * @param request
     * @param response
     * @param id
     * @param currentPage
     * @param orderBy
     * @param orderType
     * @param store_price_begin
     * @param store_price_end
     * @param op
     * @param goods_name
     * @return
     */
    @RequestMapping({"/brand_goods_ajax.htm"})
    public void brand_view_ajax(HttpServletRequest request, HttpServletResponse response, String id, String currentPage, String orderBy, String orderType, String store_price_begin, String store_price_end, String op, String goods_name)
    {
        Map<String, Object> map = new HashMap<String, Object>();
        if ((op != null) && (!op.equals(""))) {
            map.put("op", op);
        }
        ShoppingGoodsbrand gb = this.goodsBrandService.getObjById(CommUtil.null2Long(id));
        Map<String,Object> params = new HashMap<String,Object>();

        if ((store_price_begin != null) && (!store_price_begin.equals(""))) {
            //gqo.addQuery("obj.store_price", new SysMap("store_price_begin", BigDecimal.valueOf(CommUtil.null2Float(store_price_begin))), ">=");
            params.put("store_price_begin",BigDecimal.valueOf(CommUtil.null2Float(store_price_begin)));
            map.put("store_price_begin", store_price_begin);
        }

        if ((store_price_end != null) && (!store_price_end.equals(""))) {
            //gqo.addQuery("obj.store_price", new SysMap("store_price_end", BigDecimal.valueOf(CommUtil.null2Float(store_price_end))), "<=");
            params.put("store_price_end",BigDecimal.valueOf(CommUtil.null2Float(store_price_end)));
            map.put("store_price_end", store_price_end);
        }

        if ((goods_name != null) && (!goods_name.equals(""))) {
            //gqo.addQuery("obj.goods_name", new SysMap("goods_name", "%" + goods_name.trim() + "%"), "like");
            params.put("goods_name", "%".concat(goods_name).concat("%"));
            map.put("goods_name", goods_name);
        }
        params.put("goods_brand_id", gb.getId());
        params.put("goods_status",0);
        //gqo.addQuery("obj.goods_brand.id", new SysMap("goods_brand_id", gb.getId()), "=");
       // gqo.addQuery("obj.goods_status", new SysMap("goods_status", Integer.valueOf(0)), "=");
        //gqo.setPageSize(Integer.valueOf(12));
        List<ShoppingGoodsWithBLOBs> pList = this.goodsService.queryByCondition(params);
        map.put("show", "brand_goods");
        CommUtil.saveWebPaths(map, this.configService.getSysConfig(), request);
        if(pList != null){
            int count=this.goodsService.count(params);
            viewTools.mainPhotoHandle(pList);
            //goodsViewTools.addStoreGrade(pList);
            PageModel page = new PageModel();
            page.setPageSize(20);
            page.setPages(count/20);
            page.setRowCount(count);
            page.setResult(pList);
            page.setCurrentPage(1);
            com.xdj.interfaces.mallinterface.util.CommUtil.saveIPageList2Map("", "", "", page, map);
        }

        String ret =new Gson().toJson(map);
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.print(ret);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
