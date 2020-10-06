package com.xdj.interfaces.mallinterface.controller.buyer;

import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.pay.tools.PayTools;
import com.xdj.interfaces.mallinterface.query.IPageList;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.domain.virtual.SysMap;
import com.xdj.www.core.tools.StringUtils;
import com.xdj.www.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PredepositController {
    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @Autowired
    private IPaymentService paymentService;

    @Autowired
    private IPredepositService predepositService;

    @Autowired
    private IPredepositLogService predepositLogService;

    @Autowired
    private IUserService userService;

    @Autowired
    private PayTools payTools;

    @SecurityMapping(display = false, rsequence = 0, title="会员充值", value="/buyer/predeposit.htm*", rtype="buyer", rname="预存款管理", rcode="predeposit_set", rgroup="用户中心")
    @RequestMapping({"/buyer/predeposit.htm"})
    public ModelAndView predeposit(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView(
                "buyer/buyer_predeposit.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        if (this.configService.getSysConfig().getDeposit()) {
            Map params = new HashMap();
            params.put("type", "admin");
            params.put("install", Boolean.valueOf(true));
            params.put("mark1", "alipay_wap");
            params.put("mark2", "balance");
            List payments = this.paymentService.queryByCondition(params);
            mv.addObject("payments", payments);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启预存款");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
        }
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="会员充值保存", value="/buyer/predeposit_save.htm*", rtype="buyer", rname="预存款管理", rcode="predeposit_set", rgroup="用户中心")
    @RequestMapping({"/buyer/predeposit_save.htm"})
    public ModelAndView predeposit_save(HttpServletRequest request, HttpServletResponse response, String id, String pd_payment, String pd_amount, String pd_remittance_user, String pd_remittance_bank, String pd_remittance_time, String pd_remittance_info)
    {
        ModelAndView mv = new JModelAndView("line_pay.html", this.configService
                .getSysConfig(), this.userConfigService.getUserConfig(), 1,
                request, response);
        if (this.configService.getSysConfig().getDeposit()) {
            ShoppingPredepositWithBLOBs obj = null;
            if (CommUtil.null2String(id).equals("")){
                obj=new ShoppingPredepositWithBLOBs();
               // obj = (Predeposit)wf.toPo(request, Predeposit.class);
                obj.setAddtime(new Date());
                obj.setDeletestatus(false);
                BigDecimal amount = new BigDecimal(CommUtil.null2String(pd_amount));
                obj.setPdAmount(amount);
                if(pd_remittance_info!=null&&!"".equals(pd_remittance_info)){
                    obj.setPdRemittanceInfo(pd_remittance_info);
                }
                if (pd_payment.equals("outline"))
                    obj.setPdPayStatus(1);
                else {
                    obj.setPdPayStatus(0);
                }
                obj.setPdSn("pd" + CommUtil.formatTime("yyyyMMddHHmmss", new Date()) + SecurityUserHolder.getCurrentUser().getId());
                obj.setPdUserId(SecurityUserHolder.getCurrentUser().getId());
                obj.setPdStatus(Integer.valueOf(0));
                obj.setPdPayment(pd_payment);
                this.predepositService.save(obj);
                ShoppingPredepositLog log = new ShoppingPredepositLog();
                log.setAddtime(new Date());
                log.setPdLogAmount(obj.getPdAmount());
                String pay_text = "";
                if (pd_payment.equals("outline")) {
                    pay_text = "线下账户";
                }
                if (pd_payment.equals("alipay")) {
                    pay_text = "支付宝";
                }
                if (pd_payment.equals("bill")) {
                    pay_text = "快钱";
                }
                if (pd_payment.equals("tenpay")) {
                    pay_text = "财付通";
                }
                if (pd_payment.equals("chinabank")) {
                    pay_text = "网银在线";
                }
                log.setPdLogInfo(pay_text + "充值");
                log.setPdLogUserId(obj.getPdUserId());
                log.setPdOpType("充值");
                log.setPdType("可用预存款");
                log.setPredepositId(obj.getId());
                log.setDeletestatus(false);
                this.predepositLogService.save(log);
            } else {
                ShoppingPredepositWithBLOBs pre = this.predepositService.getObjById(CommUtil.null2Long(id));
                //obj = (Predeposit)wf.toPo(request, pre);
                obj=pre;
                this.predepositService.update(obj);
            }
            if (pd_payment.equals("outline")) {
                mv = new JModelAndView("success.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
                mv.addObject("op_title", "线下支付提交成功，等待审核");
                mv.addObject("url", CommUtil.getURL(request) +
                        "/buyer/predeposit_list.htm");
            } else {
                mv.addObject("payType", pd_payment);
                mv.addObject("type", "cash");
                mv.addObject("url", CommUtil.getURL(request));
                mv.addObject("payTools", this.payTools);
                mv.addObject("cash_id", obj.getId());
                Map params = new HashMap();
                params.put("install", Boolean.valueOf(true));
                params.put("mark", obj.getPdPayment());
                params.put("type", "admin");
                List<ShoppingPaymentWithBLOBs> payments = this.paymentService.queryByCondition(params);
                mv.addObject("payment_id", payments.size() > 0 ?
                        (payments.get(0)).getId() : new ShoppingPaymentWithBLOBs());
            }
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启预存款");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
        }
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="会员充值列表", value="/buyer/predeposit_list.htm*", rtype="buyer", rname="预存款管理", rcode="predeposit_set", rgroup="用户中心")
    @RequestMapping({"/buyer/predeposit_list.htm"})
    public ModelAndView predeposit_list(HttpServletRequest request, HttpServletResponse response, String currentPage) {
        ModelAndView mv = new JModelAndView(
                "buyer/predeposit_list.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        if (this.configService.getSysConfig().getDeposit()) {
            int pageNow= 1;
            if(StringUtils.isBlank(currentPage)){
                pageNow=Integer.valueOf(currentPage);
            }
            Map<String,Object> map=new HashMap<>();
            map.put("orderBy","addTime");
            map.put("sort","desc");
            map.put("pd_user_id",SecurityUserHolder.getCurrentUser().getId());
            map.put("start",(pageNow-1)*10);
            map.put("pageSize",10);
            List<ShoppingPredepositWithBLOBs> pList = predepositService.queryByCondition(map);
            if(pList != null && pList.size() >0){
                int count =  this.predepositService.count(map);
                PageModel page = new PageModel();
                page.setResult(pList);
                page.setRowCount(count);
                page.setPageSize(10);
                page.setCurrentPage(pageNow);
                CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
            }
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启预存款");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
        }
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="会员充值详情", value="/buyer/predeposit_view.htm*", rtype="buyer", rname="预存款管理", rcode="predeposit_set", rgroup="用户中心")
    @RequestMapping({"/buyer/predeposit_view.htm"})
    public ModelAndView predeposit_view(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView(
                "buyer/predeposit_view.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        if (this.configService.getSysConfig().getDeposit()) {
            ShoppingPredepositWithBLOBs obj = this.predepositService.getObjById(
                    CommUtil.null2Long(id));

            if (obj.getPdUserId().equals(
                    SecurityUserHolder.getCurrentUser().getId())) {
                mv.addObject("obj", obj);
            } else {
                mv = new JModelAndView("error.html", this.configService
                        .getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request,
                        response);
                mv.addObject("op_title", "参数错误，您没有该充值信息！");
                mv.addObject("url", CommUtil.getURL(request) +
                        "/buyer/predeposit_list.htm");
            }
        }
        else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启预存款");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
        }
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="会员充值支付", value="/buyer/predeposit_pay.htm*", rtype="buyer", rname="预存款管理", rcode="predeposit_set", rgroup="用户中心")
    @RequestMapping({"/buyer/predeposit_pay.htm"})
    public ModelAndView predeposit_pay(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView(
                "buyer/predeposit_pay.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        if (this.configService.getSysConfig().getDeposit()) {
            ShoppingPredepositWithBLOBs obj = this.predepositService.getObjById(
                    CommUtil.null2Long(id));

            if (obj.getPdUserId().equals(
                    SecurityUserHolder.getCurrentUser().getId())) {
                mv.addObject("obj", obj);
            } else {
                mv = new JModelAndView("error.html", this.configService
                        .getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request,
                        response);
                mv.addObject("op_title", "参数错误，您没有该充值信息！");
                mv.addObject("url", CommUtil.getURL(request) +
                        "/buyer/predeposit_list.htm");
            }
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "系统未开启预存款");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/index.htm");
        }
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="会员收入明细", value="/buyer/predeposit_log.htm*", rtype="buyer", rname="预存款管理", rcode="predeposit_set", rgroup="用户中心")
    @RequestMapping({"/buyer/predeposit_log.htm"})
    public ModelAndView predeposit_log(HttpServletRequest request, HttpServletResponse response, String currentPage) {
        ModelAndView mv = new JModelAndView(
                "buyer/buyer_predeposit_log.html",
                this.configService.getSysConfig(), this.userConfigService
                .getUserConfig(), 0, request, response);
        if (this.configService.getSysConfig().getDeposit()) {
            int pageNow= 1;
            if(StringUtils.isBlank(currentPage)){
                pageNow=Integer.valueOf(currentPage);
            }
            Map<String,Object> map=new HashMap<>();
            map.put("orderBy","addTime");
            map.put("sort","desc");
            map.put("pd_log_user_id",SecurityUserHolder.getCurrentUser().getId());
            map.put("start",(pageNow-1)*10);
            map.put("pageSize",10);
            List<ShoppingPredepositLog> pList = predepositLogService.queryByCondition(map);
            if(pList != null && pList.size() >0){
                int count =  this.predepositLogService.count(map);
                PageModel page = new PageModel();
                if(count%2==0){
                    page.setPages(count/10);
                }else{
                    page.setPages(count/10 +1);
                }
                page.setResult(pList);
                page.setRowCount(count);
                page.setPageSize(10);
                page.setCurrentPage(pageNow);
                CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
            }
            mv.addObject("user", this.userService.getObjById(
                    SecurityUserHolder.getCurrentUser().getId()));
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
