package com.xdj.interfaces.mallinterface.controller.shop;

import com.xdj.interfaces.mallinterface.controller.view.AreaViewTools;
import com.xdj.interfaces.mallinterface.controller.view.SpareGoodsViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.entity.ShoppingArea;
import com.xdj.www.entity.ShoppingSpareGoodsWithBLOBs;
import com.xdj.www.entity.ShoppingSpareGoodsclass;
import com.xdj.www.entity.ShoppingSpareGoodsfloor;
import org.apache.commons.lang3.StringUtils;
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
public class SpareGoodsController {
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private ISysConfigService configService;
    @Resource
    private ISpareGoodsFloorService sparegoodsfloorService;
    @Resource
    private ISpareGoodsClassService sparegoodsclassService;
    @Resource
    private IAreaService areaService;
    @Resource
    private ISpareGoodsService spareGoodsService;
    @Resource
    private SpareGoodsViewTools spareGoodsViewTools;
    @Resource
    private ViewTools viewTools;
    @Resource
    private AreaViewTools areaViewTools;
    @RequestMapping({"/sparegoods.htm"})
    public ModelAndView sparegoods(HttpServletRequest request, HttpServletResponse response, String currentPage) {
        ModelAndView mv = new JModelAndView("sparegoods.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1,
                request, response);
        Map params = new HashMap();
        params.put("display", Boolean.valueOf(true));
        params.put("orderBy","sequence");
        params.put("sort","asc");
        List<ShoppingSpareGoodsfloor> floors = this.sparegoodsfloorService.queryByCondition(params);
        /*("select obj from SpareGoodsFloor obj where obj.display=:display order By sequence asc",map, -1, -1);*/
        params.clear();
        params.put("parent_id","is null");
        params.put("orderBy","sequence");
        params.put("sort","asc");
        List<ShoppingSpareGoodsclass> sgcs = this.sparegoodsclassService.queryByCondition(params);
                //.query("select obj from SpareGoodsClass obj where obj.parent.id is null order by sequence asc", null, -1, -1);
        mv.addObject("sgcs", sgcs);
        viewTools.topHandle(mv,request);
        viewTools.sparegoodsNav2(mv);
        viewTools.advertInvoke(mv,"262146","spareInvoke");
        viewTools.footerHandle(mv);

        if (floors!=null&&floors.size()>0){
            for (ShoppingSpareGoodsfloor floor : floors) {
                floor.setSgs(spareGoodsViewTools.querySgs(floor));
                floor.setF_class(this.spareGoodsViewTools.query_floorClass(floor));

            }
        }
        if (sgcs!=null&&sgcs.size()>0){
            for (ShoppingSpareGoodsclass childs : sgcs) {
                childs.setChilds(this.spareGoodsViewTools.queryChilds(childs));
            }
        }

        mv.addObject("floors", floors);
        mv.addObject("advPos1", viewTools.advPos("262154"));
        mv.addObject("advPos2", viewTools.advPos("262147"));
        return mv;
    }

    @RequestMapping({"/sparegoods_search.htm"})
    public ModelAndView sparegoods_search(HttpServletRequest request, HttpServletResponse response, String cid, String orderBy, String orderType, String currentPage, String price_begin, String price_end, String keyword, String area_id)
    {
        ModelAndView mv = new JModelAndView("sparegoods_search.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        if ((orderType != null) && (!orderType.equals(""))) {
            if (orderType.equals("asc")) {
                orderType = "desc";
            }else {
                orderType = "asc";
            }
        }
        else {
            orderType = "desc";
        }
        if ((orderBy != null) && (!orderBy.equals(""))) {
            if (orderBy.equals("addTime")) {
                orderType = "desc";
            }
        }
        else {
            orderBy = "addTime";
        }
        Map params=new HashMap();
        params.put("orderBy",orderBy);
        params.put("sort",orderType);
        params.put("status",Integer.valueOf(0));
        params.put("down",Integer.valueOf(0));
        if ((cid != null) && (!cid.equals(""))) {
            ShoppingSpareGoodsclass sgc = this.sparegoodsclassService.getObjById(CommUtil.null2Long(cid));
            Set ids = genericIds(sgc);
            params.put("sgc_ids", ids);
            mv.addObject("cid", cid);
            if(sgc.getParentId()!=null){
                sgc.setParent(sparegoodsclassService.getObjById(sgc.getParentId()));
            }
            sgc.setChilds(spareGoodsViewTools.queryChilds(sgc));

            mv.addObject("sgc", sgc);
        }
        if ((orderBy != null) && (!orderBy.equals(""))) {
            if (orderBy.equals("recommend")) {
                params.put("recommend",Boolean.valueOf(true));
            }
            if ((price_begin != null) && (!price_begin.equals(""))) {
                params.put("price_begin", Integer.valueOf(CommUtil.null2Int(price_begin)));
            }
            if ((price_end != null) && (!price_end.equals(""))) {
                params.put("goods_end", Integer.valueOf(CommUtil.null2Int(price_end)));
            }
        }
        if ((keyword != null) && (!keyword.equals(""))) {
            params.put("title","%" + keyword.trim() + "%");
        }
        if ((area_id != null) && (!area_id.equals(""))) {
            params.put("area_id",CommUtil.null2Long(area_id));
            //qo.addQuery("obj.area.parent.id", new SysMap("obj_area_id", CommUtil.null2Long(area_id)), "=");
            ShoppingArea area = this.areaService.getObjById(CommUtil.null2Long(area_id));
            mv.addObject("area", area);
        }
        int pageNow =1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow= Integer.parseInt(currentPage);
        }
        List<ShoppingSpareGoodsWithBLOBs> pList = spareGoodsService.pageList(params);
        if(pList != null){
            int count = spareGoodsService.count(params);
            for (ShoppingSpareGoodsWithBLOBs spareGoods : pList) {
                if(spareGoods.getMainImgId()!=null) {
                    spareGoods.setMain_img(spareGoodsViewTools.queryMainImg(spareGoods));
                }
                if(spareGoods.getAreaId() != null){
                    ShoppingArea area = areaService.getObjById(spareGoods.getAreaId());
                    areaViewTools.addGrandpa(area);
                    spareGoods.setArea(area);
                }
            }
            PageModel page = new PageModel();
            page.setResult(pList);
            page.setCurrentPage(pageNow);
            page.setPages(count/20);
            page.setRowCount(count);
            mv.addObject("allCount", count);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        params.clear();
        params.put("parent_id","is null");
        List citys = this.areaService.queryByCondition(params);
                //.query("select obj from Area obj where obj.parent.id is null", null, -1, -1);
        mv.addObject("citys", citys);
        mv.addObject("area_id", area_id);
        mv.addObject("keyword", keyword);
        mv.addObject("price_begin", price_begin);
        mv.addObject("price_end", price_end);
        return mv;
    }
    private Set<Long> genericIds(ShoppingSpareGoodsclass gc) {
        Set ids = new HashSet();
        ids.add(gc.getId());
        List<ShoppingSpareGoodsclass> spareGoodsclasses = spareGoodsViewTools.queryChilds(gc);
        for (ShoppingSpareGoodsclass child : spareGoodsclasses) {
            Set<Long> cids = genericIds(child);
            for (Long cid : cids) {
                ids.add(cid);
            }
            ids.add(child.getId());
        }
        return ids;
    }
}
