package com.xdj.interfaces.mallinterface.controller.buyer;

import com.xdj.interfaces.mallinterface.controller.view.AreaViewTools;
import com.xdj.interfaces.mallinterface.controller.view.IntegralOrderTools;
import com.xdj.interfaces.mallinterface.controller.view.UserViewTools;
import com.xdj.interfaces.mallinterface.controller.view.ViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.entity.ShoppingAddress;
import com.xdj.www.entity.ShoppingIntegralGoodsorderWithBLOBs;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@RestController
public class IntegralOrderController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IIntegralGoodsService integralGoodsService;
    @Resource
    private IIntegralGoodsOrderService integralGoodsOrderService;
    @Resource
    private IIntegralLogService integralLogService;
    @Resource
    private IntegralOrderTools integralOrderTools;
    @Resource
    private UserViewTools userViewTools;
    @Resource
    private IAddressService addressService;
    @Resource
    private AreaViewTools areaViewTools;
    @Resource
    private ViewTools viewTools;

    @SecurityMapping(display = false, rsequence = 0, title="积分订单详情", value="/buyer/integral_order_view.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/integral_order_view.htm"})
    public ModelAndView integral_order_view(HttpServletRequest request, HttpServletResponse response, String id, String currentPage) {
        ModelAndView mv = new JModelAndView("buyer/integral_order_view.html",this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingIntegralGoodsorderWithBLOBs obj = this.integralGoodsOrderService.getObjById(CommUtil.null2Long(id));
        if (obj != null) {
            if (obj.getIgoUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
                userViewTools.addIntegralOrdUser(obj);
                ShoppingAddress addr= addressService.getObjById(obj.getIgoAddrId());
                areaViewTools.addAddrArea(addr,true);
                obj.setIgo_addr(addr);

                mv.addObject("obj", obj);
                mv.addObject("currentPage", currentPage);

            }
        }else{
            mv = new JModelAndView("error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "参数错误，无该订单");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/integral_order_list.htm");
        }

        return mv;
    }



    @SecurityMapping(display = false, rsequence = 0, title="买家订单列表", value="/buyer/integral_order_list.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/integral_order_list.htm"})
    public ModelAndView integral_order_list(HttpServletRequest request, HttpServletResponse response, String currentPage){
        ModelAndView mv = new JModelAndView("buyer/integral_order_list.html", this.configService.getSysConfig(),
                this.userConfigService .getUserConfig(), 0, request, response);
        if (this.configService.getSysConfig().getIntegralstore()) {
            Map<String,Object> params = new HashMap<>();
            params.put("orderBy","addTime");
            params.put("sort","desc");
            params.put("igo_user_id",SecurityUserHolder.getCurrentUser().getId());
            int pageNow =1;
            if(StringUtils.isNotBlank(currentPage)){
                pageNow = Integer.parseInt(currentPage);
            }
            params.put("start",(pageNow-1)*10);
            params.put("oageSize",10);
            List<ShoppingIntegralGoodsorderWithBLOBs> pList = this.integralGoodsOrderService.queryByCondition(params);
            if(pList != null){
                PageModel page = new PageModel();
                integralOrderTools.addGoodsorderGcs(pList,true);
                page.setResult(pList);
                int count = integralGoodsOrderService.pageCount(params);
                page.setRowCount(count);
                page.setPageSize(10);
                page.setCurrentPage(pageNow);
                page.setPages(count%10 == 0?count/10:count/10 + 1 );
                CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
            }
            viewTools.topHandle(mv,request);
            viewTools.footerHandle(mv);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启积分商城");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
        }
        return mv;
    }
}
