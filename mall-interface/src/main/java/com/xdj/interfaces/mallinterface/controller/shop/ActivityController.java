package com.xdj.interfaces.mallinterface.controller.shop;

import com.xdj.interfaces.mallinterface.controller.view.AccessoryViewTools;
import com.xdj.interfaces.mallinterface.controller.view.GoodsViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.service.IActivityGoodsService;
import com.xdj.interfaces.mallinterface.service.IActivityService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.IUserConfigService;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.entity.ShoppingActivity;
import com.xdj.www.entity.ShoppingActivityGoods;
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

/**
 * @author Administrator
 */
@RestController
public class ActivityController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IActivityService activityService;
    @Resource
    private IActivityGoodsService activityGoodsService;
    @Resource
    private GoodsViewTools goodsViewTools;
    @Resource
    private AccessoryViewTools accessViewTools;
    @Resource
    private ViewTools viewTools;

    /**
     *
     *
     *
     */

    @RequestMapping({"/activity.htm"})
    public ModelAndView activity(HttpServletRequest request, HttpServletResponse response, String id, String currentPage){
        ModelAndView mv = new JModelAndView("activity.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingActivity act = this.activityService.getObjById(CommUtil.null2Long(id));
        Map<String,Object> params = new HashMap<String,Object>();
        params.put("orderBy","addTime");
        params.put("sort","desc");
        params.put("pageSize",24);
        params.put("ag_status",1);
        params.put("act_id",act.getId());
        params.put("ac_status",1);
        int pageNow = 1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow= Integer.parseInt(currentPage);
        }
        params.put("start",(pageNow-1)* 24);
        params.put("ac_begin_time", new Date());
        params.put("ac_end_time", new Date());
        params.put("goods_status",0);
        List<ShoppingActivityGoods> pList = this.activityGoodsService.pageList(params);
        if(pList != null){
            PageModel  page = new PageModel();
            goodsViewTools.addActvityGoods(pList);
            page.setResult(pList);
            int count = activityGoodsService.count(params);
            page.setRowCount(count);
            page.setPages(count/24);
            page.setCurrentPage(pageNow);
            page.setPageSize(24);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        accessViewTools.addAccImg(act);
        mv.addObject("act", act);
        viewTools.topHandle(mv,request);
        viewTools.headHandle(mv,request);
        viewTools.nav1Handle(mv);
        viewTools.footerHandle(mv);
        return mv;
    }

}
