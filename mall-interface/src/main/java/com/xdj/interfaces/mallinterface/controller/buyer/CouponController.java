package com.xdj.interfaces.mallinterface.controller.buyer;

import com.xdj.interfaces.mallinterface.controller.view.CouponViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.query.IPageList;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.ICouponInfoService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.IUserConfigService;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.entity.ShoppingCouponInfo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CouponController {

    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @Autowired
    private ICouponInfoService couponInfoService;
    @Resource
    private CouponViewTools couponViewTools;

    @SecurityMapping(display = false, rsequence = 0, title="买家优惠券列表", value="/buyer/coupon.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/coupon.htm"})
    public ModelAndView coupon(HttpServletRequest request, HttpServletResponse response, String reply, String currentPage)
    {
        ModelAndView mv = new JModelAndView("buyer/buyer_coupon.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> params = new HashMap<>();
        params.put("orderBy","addTime");
        params.put("sort","desc");
        params.put("user_id",SecurityUserHolder.getCurrentUser().getId());
        int pageNow = 1;
        if(StringUtils.isNotBlank(currentPage)){
            pageNow = Integer.parseInt(currentPage);
        }
        params.put("start",(pageNow-1)*10);
        params.put("pageSize",10);
        List<ShoppingCouponInfo> pList = this.couponInfoService.queryByCondition(params);
        if(pList != null){
            PageModel page = new PageModel();
            int count = couponInfoService.pageCount(params);
            couponViewTools.addInfoCoupons(pList);
            page.setResult(pList);
            page.setCurrentPage(pageNow);
            page.setRowCount(count);
            page.setPages(count%10== 0? count/10:count/10+1);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }

        return mv;
    }
}
