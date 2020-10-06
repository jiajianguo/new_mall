package com.xdj.interfaces.mallinterface.controller.buyer;

import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.query.IPageList;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.domain.virtual.SysMap;
import com.xdj.www.core.tools.StringUtils;
import com.xdj.www.entity.ShoppingPredepositCashWithBLOBs;
import com.xdj.www.entity.ShoppingPredepositLog;
import com.xdj.www.entity.ShoppingUser;
import com.xdj.www.entity.ShoppingUserFriend;
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
public class PredepositCashController {
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserService userService;
    @Resource
    private IPredepositCashService predepositCashService;
    @Resource
    private IPredepositLogService predepositLogService;

    @SecurityMapping(display = false, rsequence = 0, title="提现管理", value="/buyer/buyer_cash.htm*", rtype="buyer", rname="预存款管理", rcode="predeposit_set", rgroup="用户中心")
    @RequestMapping({"/buyer/buyer_cash.htm"})
    public ModelAndView buyer_cash(HttpServletRequest request, HttpServletResponse response, String id)
    {
        ModelAndView mv = new JModelAndView(
                "buyer/buyer_cash.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        if (!this.configService.getSysConfig().getDeposit()) {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启预存款");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
        } else {
            mv.addObject("availableBalance",
                    Double.valueOf(CommUtil.null2Double(this.userService.getObjById(
                            SecurityUserHolder.getCurrentUser().getId()).getAvailablebalance())));
        }

        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="提现管理保存", value="/buyer/buyer_cash_save.htm*", rtype="buyer", rname="预存款管理", rcode="predeposit_set", rgroup="用户中心")
    @RequestMapping({"/buyer/buyer_cash_save.htm"})
    public ModelAndView buyer_cash_save(HttpServletRequest request, HttpServletResponse response, String id, String currentPage) {
        ModelAndView mv = new JModelAndView("l", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1,
                request, response);
        ShoppingPredepositCashWithBLOBs obj = new ShoppingPredepositCashWithBLOBs();
        obj.setCashSn("cash" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + SecurityUserHolder.getCurrentUser().getId());
        obj.setAddtime(new Date());
        obj.setDeletestatus(false);
        obj.setCashUserId(SecurityUserHolder.getCurrentUser().getId());
        ShoppingUser user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
        if (CommUtil.null2Double(obj.getCashAmount()) <=
                CommUtil.null2Double(user.getAvailablebalance())) {
            this.predepositCashService.save(obj);

            ShoppingPredepositLog log = new ShoppingPredepositLog();
            log.setDeletestatus(false);
            log.setAddtime(new Date());
            log.setPdLogAmount(obj.getCashAmount());
            log.setPdLogInfo("申请提现");
            log.setPdLogUserId(obj.getCashUserId());
            log.setPdOpType("提现");
            log.setPdType("可用预存款");
            this.predepositLogService.save(log);
            mv.addObject("op_title", "提现申请成功");
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "提现金额大于用户余额，提现失败");
        }

        mv.addObject("url", CommUtil.getURL(request) + "/buyer/buyer_cash.htm");

        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="提现管理", value="/buyer/buyer_cash_list.htm*", rtype="buyer", rname="预存款管理", rcode="predeposit_set", rgroup="用户中心")
    @RequestMapping({"/buyer/buyer_cash_list.htm"})
    public ModelAndView buyer_cash_list(HttpServletRequest request, HttpServletResponse response, String currentPage) {
        ModelAndView mv = new JModelAndView(
                "buyer/buyer_cash_list.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        if (!this.configService.getSysConfig().getDeposit()) {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启预存款");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
        } else {
            int pageNow= 1;
            if(StringUtils.isBlank(currentPage)){
                pageNow=Integer.valueOf(currentPage);
            }
            Map<String,Object> map=new HashMap<>();
            map.put("orderBy","addTime");
            map.put("sort","desc");
            map.put("cash_user_id",SecurityUserHolder.getCurrentUser().getId());
            map.put("start",(pageNow-1)*10);
            map.put("pageSize",10);
            List<ShoppingPredepositCashWithBLOBs> pList = predepositCashService.queryByCondition(map);
            if(pList != null && pList.size() >0){
                int count =  this.predepositCashService.count(map);
                PageModel page = new PageModel();
                page.setResult(pList);
                page.setRowCount(count);
                if(count%10==0){
                    page.setPages(count/10);
                }else{
                    page.setPages(count/10+1);
                }
                page.setPageSize(10);
                page.setCurrentPage(pageNow);
                CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
            }

        }
        return mv;
    }
    @SecurityMapping(display = false, rsequence = 0, title="会员提现详情", value="/buyer/buyer_cash_view.htm*", rtype="buyer", rname="预存款管理", rcode="predeposit_set", rgroup="用户中心")
    @RequestMapping({"/buyer/buyer_cash_view.htm"})
    public ModelAndView buyer_cash_view(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView(
                "buyer/buyer_cash_view.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        if (this.configService.getSysConfig().getDeposit()) {
            ShoppingPredepositCashWithBLOBs obj = this.predepositCashService.getObjById(CommUtil.null2Long(id));
            mv.addObject("obj", obj);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启预存款");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
        }
        return mv;
    }

}
