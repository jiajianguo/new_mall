package com.xdj.interfaces.mallinterface.controller.buyer;

import com.alibaba.fastjson.JSONObject;
import com.xdj.interfaces.mallinterface.controller.view.ComplaintViewTools;
import com.xdj.interfaces.mallinterface.controller.view.OrderViewTools;
import com.xdj.interfaces.mallinterface.controller.view.StoreViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.tools.StringUtils;
import com.xdj.www.entity.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
@RestController
public class ComplaintController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IComplaintService complaintService;
    @Resource
    private IComplaintSubjectService complaintSubjectService;
    @Resource
    private IOrderFormService orderFormService;
    @Resource
    private IGoodsService goodsService;
    @Resource
    private IAccessoryService accessoryService;
    @Resource
    private IUserService userService;
    @Resource
    private StoreViewTools storeViewTools;
    @Resource
    private ComplaintViewTools complaintViewTools;
    @Resource
    private OrderViewTools orderViewTools;

    @SecurityMapping(display = false, rsequence = 0, title="买家投诉列表", value="/buyer/complaint.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/complaint.htm"})
    public ModelAndView complaint(HttpServletRequest request, HttpServletResponse response, String currentPage, String status) {
        ModelAndView mv = new JModelAndView(
                "buyer/buyer_complaint.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        int pageNow= 1;
        if(StringUtils.isBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("orderBy","addTime");
        map.put("sort","desc");
        map.put("status",Integer.valueOf(CommUtil.null2Int(status)));
        map.put("from_user_id",SecurityUserHolder.getCurrentUser().getId());
        map.put("start",(pageNow-1)*10);
        map.put("pageSize",10);
        List<ShoppingComplaintWithBLOBs> pList = complaintService.queryByCondition(map);
        complaintViewTools.addCss(pList);
        if(pList != null && pList.size() >0){
            int count =  this.complaintService.count(map);
            PageModel page = new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            page.setPageSize(10);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        mv.addObject("status", status);
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="买家投诉发起", value="/buyer/complaint_handle.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/complaint_handle.htm"})
    public ModelAndView complaint_handle(HttpServletRequest request, HttpServletResponse response, String order_id) {
        ModelAndView mv = new JModelAndView(
                "buyer/complaint_handle.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingOrderformWithBLOBs of = this.orderFormService.getObjById(CommUtil.null2Long(order_id));
        Calendar calendar = Calendar.getInstance();
        calendar.add(6, -this.configService.getSysConfig().getComplaintTime());
        boolean result = true;
        if ((of.getOrderStatus() == 60) &&
                (of.getFinishtime().before(calendar.getTime()))) {
            result = false;
        }

        boolean result1 = true;
        Map<String,Object> params = new HashMap();
        params.put("of_id",of.getId());
        List<ShoppingComplaintWithBLOBs> complaints = complaintService.queryByCondition(params);
        if (complaints.size() > 0) {
            for (ShoppingComplaintWithBLOBs complaint : complaints)
            {
                if (complaint.getFromUserId().equals(SecurityUserHolder.getCurrentUser().getId())) {
                    result1 = false;
                }
            }
        }
        if (result) {
            if (result1) {
                ShoppingComplaintWithBLOBs obj = new ShoppingComplaintWithBLOBs();
                obj.setFrom_user(SecurityUserHolder.getCurrentUser());
                obj.setStatus(0);
                obj.setType("buyer");
                obj.setOf(of);
                storeViewTools.addOrderStore(of,true);
                obj.setTo_user(of.getStore().getUser());
                mv.addObject("obj", obj);
                params.clear();
                params.put("type", "buyer");
                List<ShoppingComplaintSubject> css = this.complaintSubjectService.queryByCondition(params);
                mv.addObject("css", css);
            } else {
                mv = new JModelAndView("error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
                mv.addObject("op_title", "该订单已经投诉，不允许重复投诉");
                mv.addObject("url", CommUtil.getURL(request) +
                        "/buyer/order.htm");
            }
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "该订单已经超过投诉有效期，不能投诉");
            mv.addObject("url", CommUtil.getURL(request) + "/buyer/order.htm");
        }
        return (ModelAndView)mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="买家投诉列表", value="/buyer/complaint_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/complaint_save.htm"})
    public ModelAndView complaint_save(HttpServletRequest request, HttpServletResponse response, String order_id, String cs_id, String from_user_content, String goods_ids, String to_user_id, String type)
    {
        ModelAndView mv = new JModelAndView(
                "buyer/success.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingComplaintWithBLOBs obj = new ShoppingComplaintWithBLOBs();
        obj.setAddtime(new Date());
        ShoppingComplaintSubject cs = this.complaintSubjectService.getObjById(
                CommUtil.null2Long(cs_id));
        ShoppingOrderformWithBLOBs of = this.orderFormService.getObjById(
                CommUtil.null2Long(order_id));
        obj.setCs(cs);
        obj.setFromUserContent(from_user_content);
        obj.setFrom_user(SecurityUserHolder.getCurrentUser());
        obj.setTo_user(this.userService.getObjById(
                CommUtil.null2Long(to_user_id)));
        obj.setType(type);
        obj.setOf(of);
        String[] goods_id_list = goods_ids.split(",");
        for (String goods_id : goods_id_list) {
            ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(CommUtil.null2Long(goods_id));
            ShoppingComplaintGoods cg = new ShoppingComplaintGoods();
            cg.setAddtime(new Date());
            cg.setComplaint(obj);
            cg.setGoods(goods);
            cg.setContent(CommUtil.null2String(request.getParameter("content_" +
                    goods_id)));
            obj.getCgs().add(cg);
        }
        String uploadFilePath = this.configService.getSysConfig().getUploadfilepath();
        String saveFilePathName = request.getSession().getServletContext()
                .getRealPath("/") +
                uploadFilePath + File.separator + "complaint";
        Object map = new HashMap();
        try {
            map = CommUtil.saveFileToServer(request, "img1", saveFilePathName, null, null);
            if (((Map)map).get("fileName") != "") {
                ShoppingAccessory from_acc1 = new ShoppingAccessory();
                from_acc1.setName(CommUtil.null2String(((Map)map).get("fileName")));
                from_acc1.setExt(CommUtil.null2String(((Map)map).get("mime")));
                from_acc1.setSize(CommUtil.null2Float(((Map)map).get("fileSize")));
                from_acc1.setPath(uploadFilePath + "/complaint");
                from_acc1.setWidth(CommUtil.null2Int(((Map)map).get("width")));
                from_acc1.setHeight(CommUtil.null2Int(((Map)map).get("height")));
                from_acc1.setAddtime(new Date());
                this.accessoryService.save(from_acc1);
                obj.setFrom_acc1(from_acc1);
            }
            ((Map)map).clear();
            map = CommUtil.saveFileToServer(request, "img2", saveFilePathName, null, null);
            if (((Map)map).get("fileName") != "") {
                ShoppingAccessory from_acc2 = new ShoppingAccessory();
                from_acc2.setName(CommUtil.null2String(((Map)map).get("fileName")));
                from_acc2.setExt(CommUtil.null2String(((Map)map).get("mime")));
                from_acc2.setSize(CommUtil.null2Float(((Map)map).get("fileSize")));
                from_acc2.setPath(uploadFilePath + "/complaint");
                from_acc2.setWidth(CommUtil.null2Int(((Map)map).get("width")));
                from_acc2.setHeight(CommUtil.null2Int(((Map)map).get("height")));
                from_acc2.setAddtime(new Date());
                this.accessoryService.save(from_acc2);
                obj.setFrom_acc2(from_acc2);
            }
            ((Map)map).clear();
            map = CommUtil.saveFileToServer(request, "img3", saveFilePathName,
                    null, null);
            if (((Map)map).get("fileName") != "") {
                ShoppingAccessory from_acc3 = new ShoppingAccessory();
                from_acc3.setName(CommUtil.null2String(((Map)map).get("fileName")));
                from_acc3.setExt(CommUtil.null2String(((Map)map).get("mime")));
                from_acc3.setSize(CommUtil.null2Float(((Map)map).get("fileSize")));
                from_acc3.setPath(uploadFilePath + "/complaint");
                from_acc3.setWidth(CommUtil.null2Int(((Map)map).get("width")));
                from_acc3.setHeight(CommUtil.null2Int(((Map)map).get("height")));
                from_acc3.setAddtime(new Date());
                this.accessoryService.save(from_acc3);
                obj.setFrom_acc3(from_acc3);
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.complaintService.save(obj);
        mv.addObject("op_title", "投诉提交成功");
        mv.addObject("url", CommUtil.getURL(request) + "/buyer/complaint.htm");
        return (ModelAndView)mv;
    }
    @SecurityMapping(display = false, rsequence = 0, title="买家查看投诉详情", value="/buyer/complaint_view.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/complaint_view.htm"})
    public ModelAndView complaint_view(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView(
                "buyer/complaint_view.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingComplaintWithBLOBs obj = this.complaintService.getObjById(CommUtil.null2Long(id));
        orderViewTools.addOf(obj);

        if ((obj.getFromUserId().equals(SecurityUserHolder.getCurrentUser().getId())) ||
                (obj.getToUserId().equals(SecurityUserHolder.getCurrentUser().getId()))) {
            mv.addObject("obj", obj);
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "参数错误，不存在该投诉");
            mv.addObject("url", CommUtil.getURL(request) +
                    "/buyer/complaint.htm");
        }
        return mv;
    }
    @SecurityMapping(display = false, rsequence = 0, title="买家取消投诉", value="/buyer/complaint_cancel.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/complaint_cancel.htm"})
    public void complaint_cancel(HttpServletRequest request, HttpServletResponse response, String id, String currentPage) throws IOException {
        ModelAndView mv = new JModelAndView(
                "buyer/success.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        this.complaintService.delete(CommUtil.null2Long(id));

        response.sendRedirect("complaint.htm?currentPage=" + currentPage);
    }
    @SecurityMapping(display = false, rsequence = 0, title="投诉图片", value="/buyer/complaint_img.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/complaint_img.htm"})
    public ModelAndView complaint_img(HttpServletRequest request, HttpServletResponse response, String id, String type) {
        ModelAndView mv = new JModelAndView(
                "buyer/complaint_img.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingComplaintWithBLOBs obj = this.complaintService
                .getObjById(CommUtil.null2Long(id));
        mv.addObject("type", type);
        mv.addObject("obj", obj);
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="发布投诉对话", value="/buyer/complaint_talk.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"buyer/complaint_talk.htm"})
    public void complaint_talk(HttpServletRequest request, HttpServletResponse response, String id, String talk_content) throws IOException {
        ShoppingComplaintWithBLOBs obj = this.complaintService
                .getObjById(CommUtil.null2Long(id));
        if (!CommUtil.null2String(talk_content).equals("")) {
            String user_role = "";

            if (SecurityUserHolder.getCurrentUser().getId().equals(
                    obj.getFromUserId())) {
                user_role = "投诉人";
            }

            if (SecurityUserHolder.getCurrentUser().getId().equals(
                    obj.getToUserId())) {
                user_role = "申诉人";
            }
            String temp = user_role + "[" +
                    SecurityUserHolder.getCurrentUser().getUsername() + "] " +
                    CommUtil.formatLongDate(new Date()) + "说: " +
                    talk_content;
            if(obj.getTalkContent() == null){
                obj.setTalkContent(temp);
            }else {
                obj.setTalkContent(temp + "\n\r" + obj.getTalkContent());
            }
            this.complaintService.update(obj);
        }
        JSONObject map = new JSONObject();
        for (String s : CommUtil.str2list(obj.getTalkContent())) {
            map.put("content", s);
            if (s.indexOf("管理员") == 0) {
                map.put("role", "admin");
            }
            if (s.indexOf("投诉") == 0) {
                map.put("role", "from_user");
            }
            if (s.indexOf("申诉") == 0) {
                map.put("role", "to_user");
            }
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(map.toJSONString());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SecurityMapping(display = false, rsequence = 0, title="申诉提交仲裁", value="/buyer/complaint_arbitrate.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/complaint_arbitrate.htm"})
    public ModelAndView complaint_arbitrate(HttpServletRequest request, HttpServletResponse response, String id, String to_user_content) {
        ModelAndView mv = new JModelAndView(
                "buyer/success.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingComplaintWithBLOBs obj = this.complaintService
                .getObjById(CommUtil.null2Long(id));
        obj.setStatus(3);
        this.complaintService.update(obj);
        mv.addObject("op_title", "申诉提交仲裁成功");
        mv.addObject("url", CommUtil.getURL(request) +
                "/buyer/complaint_seller.htm");
        return mv;
    }
}
