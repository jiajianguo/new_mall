package com.xdj.interfaces.mallinterface.controller.shop;

import com.xdj.interfaces.mallinterface.controller.view.GoodsViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.query.IPageList;
import com.xdj.interfaces.mallinterface.service.IDeliveryGoodsService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.IUserConfigService;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.domain.virtual.SysMap;
import com.xdj.www.entity.ShoppingDeliveryGoods;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class DeliveryController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IDeliveryGoodsService deliveryGoodsService;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private ViewTools viewTools;

    @RequestMapping({"/delivery.htm"})
    public ModelAndView delivery(HttpServletRequest request, HttpServletResponse response, String id, String currentPage, String orderBy, String orderType)
    {
        ModelAndView mv = new JModelAndView("delivery.html",this.configService.getSysConfig(),this.userConfigService.getUserConfig(), 1, request, response);
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("orderBy",orderBy);
        params.put("sort",orderType);
        params.put("d_status",1);
        params.put("d_begin_time",new Date());
        params.put("d_end_time",new Date());
        int pageNow = 1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow = Integer.parseInt(currentPage);
        }
        params.put("start",(pageNow-1)*20);
        params.put("pageSize",20);
        List<ShoppingDeliveryGoods> pList = this.deliveryGoodsService.pageList(params);
        if(pList != null){
            PageModel page = new PageModel();
            goodsViewTools.addDeliveryGoodsMsg(pList);
            goodsViewTools.addDeliveryGoods1(pList);
            int count = this.deliveryGoodsService.count(params);
            page.setPages(count/20);
            page.setResult(pList);
            page.setRowCount(count);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        viewTools.topHandle(mv,request);
        viewTools.headHandle(mv,request);
        viewTools.nav1Handle(mv);
        viewTools.footerHandle(mv);
        return mv;
    }

}
