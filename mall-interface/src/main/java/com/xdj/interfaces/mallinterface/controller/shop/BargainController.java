package com.xdj.interfaces.mallinterface.controller.shop;

import com.xdj.interfaces.mallinterface.controller.view.GoodsViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.query.IPageList;
import com.xdj.interfaces.mallinterface.service.IBargainGoodsService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.IUserConfigService;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.domain.virtual.SysMap;
import com.xdj.www.entity.ShoppingBargainGoods;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@RestController
public class BargainController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IBargainGoodsService bargainGoodsService;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private ViewTools viewTools;

    @RequestMapping({"/bargain.htm"})
    public ModelAndView bargain(HttpServletRequest request, HttpServletResponse response, String bg_time, String currentPage, String orderBy, String orderType)
    {
        ModelAndView mv = new JModelAndView("bargain.html",
                this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("orderBy",orderBy);
        params.put("sort",orderType);

        if (CommUtil.null2String(bg_time).equals("")){
            params.put("bg_time",CommUtil.formatShortDate(new Date()));

        }else {
            params.put("bg_time",CommUtil.formatDate(bg_time));
        }
        params.put("bg_status",1);
        params.put("pageSize",20);
        int pageNow = 1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow = Integer.parseInt(currentPage);
        }
        params.put("start",(pageNow-1)*20);

        List<ShoppingBargainGoods> pList = this.bargainGoodsService.pageList(params);
        if(pList != null){
            PageModel page = new PageModel();
            goodsViewTools.addBargainGoods(pList);
            int count = bargainGoodsService.count(params);
            page.setPageSize(20);
            page.setRowCount(count);
            page.setResult(pList);
            page.setPages(count/20);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }

        Calendar cal = Calendar.getInstance();
        if (CommUtil.null2String(bg_time).equals("")) {
            bg_time = CommUtil.formatShortDate(new Date());
        }
        cal.setTime(CommUtil.formatDate(bg_time));
        cal.add(6, 1);
        params.clear();
        params.put("bg_time",CommUtil.formatDate(CommUtil.formatShortDate(cal.getTime())));
        params.put("bg_status", Integer.valueOf(1));
        params.put("pageSize",5);
        params.put("start",0);
        params.put("orderBy","audit_time");
        params.put("sort","desc");
        List<ShoppingBargainGoods> bgs = this.bargainGoodsService.queryByCondition(params);
                //query("select obj from BargainGoods obj where obj.bg_time=:bg_time and obj.bg_status=:bg_status order by audit_time desc",params, 0, 5);
        goodsViewTools.addBargainGoods(bgs);
        mv.addObject("bgs", bgs);
        int day_count = this.configService.getSysConfig().getBargainValidity();
        List dates = new ArrayList();
        for (int i = 0; i < day_count; i++) {
            cal = Calendar.getInstance();
            cal.add(6, i);
            dates.add(cal.getTime());
        }
        mv.addObject("dates", dates);
        mv.addObject("bg_time", bg_time);
        viewTools.topHandle(mv,request);
        viewTools.headHandle(mv,request);
        viewTools.nav1Handle(mv);
        viewTools.footerHandle(mv);
        return mv;
    }
}
