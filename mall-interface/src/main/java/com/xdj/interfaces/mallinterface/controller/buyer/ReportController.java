package com.xdj.interfaces.mallinterface.controller.buyer;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.tools.StringUtils;
import com.xdj.www.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@RestController
public class ReportController {
    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @Autowired
    private IGoodsService goodsService;

    @Autowired
    private IReportTypeService reportTypeService;

    @Autowired
    private IReportSubjectService reportSubjectService;

    @Autowired
    private IReportService reportService;

    @Autowired
    private IAccessoryService accessoryService;

    @Autowired
    private IUserService userService;

    @SecurityMapping(display = false, rsequence = 0, title="买家举报列表", value="/buyer/report.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/report.htm"})
    public ModelAndView report(HttpServletRequest request, HttpServletResponse response, String currentPage)
    {
        ModelAndView mv = new JModelAndView(
                "buyer/report.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        int pageNow= 1;
        if(StringUtils.isBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("orderBy","addTime");
        map.put("sort","desc");
        map.put("user_id",SecurityUserHolder.getCurrentUser().getId());
        map.put("start",(pageNow-1)*10);
        map.put("pageSize",10);
        List<ShoppingReportWithBLOBs> pList = reportService.queryByCondition(map);

        if(pList != null && pList.size() >0){
            int count =  reportService.count(map);
            PageModel page = new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            page.setPageSize(10);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);

        }

        return mv;
    }
    @SecurityMapping(display = false, rsequence = 0, title="买家举报商品", value="/buyer/report_add.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/report_add.htm"})
    public ModelAndView report_add(HttpServletRequest request, HttpServletResponse response, String goods_id) {
        ModelAndView mv = new JModelAndView(
                "buyer/report_add.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingUser user = this.userService.getObjById(
                SecurityUserHolder.getCurrentUser().getId());
        if (user.getReport() == -1) {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "您因为恶意举报已被禁止举报，请与商城管理员联系");
            mv.addObject("url", CommUtil.getURL(request) + "/goods.htm?id=" + goods_id );
        } else {
            Map<String, Object> params = new HashMap();
            params.put("goods_id", CommUtil.null2Long(goods_id));
            params.put("user_id", SecurityUserHolder.getCurrentUser().getId());
            params.put("status", Integer.valueOf(0));
            List<ShoppingReportWithBLOBs> reports = this.reportService.queryByCondition(params);
                    //.query("select obj from Report obj where obj.goods.id=:goods_id and obj.user.id=:user_id and obj.status=:status", params, -1, -1);
            if (reports.size() == 0) {
                ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(
                        CommUtil.null2Long(goods_id));
                mv.addObject("goods", goods);
                params.clear();
                params.put("orderBy","addTime");
                params.put("sort","desc");
                List<ShoppingReportType> types = this.reportTypeService.queryByCondition(params);
                        //.query("select obj from ReportType obj order by obj.addTime desc", null, -1, -1);
                mv.addObject("types", types);
            } else {
                mv = new JModelAndView("error.html", this.configService
                        .getSysConfig(),
                        this.userConfigService.getUserConfig(), 1, request,
                        response);
                mv.addObject("op_title", "您已经举报该商品，且尚未得到商城处理");
                mv.addObject("url", CommUtil.getURL(request) + "/goods.htm?id=" + goods_id);
            }
        }
        return mv;
    }
    @SecurityMapping(display = false, rsequence = 0, title="保存买家举报商品", value="/buyer/report_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/report_save.htm"})
    public ModelAndView report_save(HttpServletRequest request, HttpServletResponse response, String goods_id, String subject_id) {
        ModelAndView mv = new JModelAndView(
                "buyer/success.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingReportWithBLOBs report = new ShoppingReportWithBLOBs();
        report.setAddtime(new Date());
        report.setUser(SecurityUserHolder.getCurrentUser());
       // ShoppingGoodsWithBLOBs goods = this.goodsService.getObjById(CommUtil.null2Long(goods_id));
        report.setGoodsId(CommUtil.null2Long(goods_id));
        //ShoppingReportSubject subject = this.reportSubjectService.getObjById(CommUtil.null2Long(subject_id));
        report.setSubjectId(CommUtil.null2Long(subject_id));

        String uploadFilePath = this.configService.getSysConfig().getUploadfilepath();
        String saveFilePathName = request.getSession().getServletContext().getRealPath("/") + uploadFilePath + File.separator + "report";
        Map map = new HashMap();
        try {
            map = CommUtil.saveFileToServer(request, "img1", saveFilePathName,
                    null, null);
            if (map.get("fileName") != "") {
                ShoppingAccessory acc1 = new ShoppingAccessory();
                acc1.setName(CommUtil.null2String(map.get("fileName")));
                acc1.setExt(CommUtil.null2String(map.get("mime")));
                acc1.setSize(CommUtil.null2Float(map.get("fileSize")));
                acc1.setPath(uploadFilePath + "/report");
                acc1.setWidth(CommUtil.null2Int(map.get("width")));
                acc1.setHeight(CommUtil.null2Int(map.get("height")));
                acc1.setAddtime(new Date());
                this.accessoryService.save(acc1);
                report.setAcc1Id(acc1.getId());
            }
            map.clear();
            map = CommUtil.saveFileToServer(request, "img2", saveFilePathName,
                    null, null);
            if (map.get("fileName") != "") {
                ShoppingAccessory acc2 = new ShoppingAccessory();
                acc2.setName(CommUtil.null2String(map.get("fileName")));
                acc2.setExt(CommUtil.null2String(map.get("mime")));
                acc2.setSize(CommUtil.null2Float(map.get("fileSize")));
                acc2.setPath(uploadFilePath + "/report");
                acc2.setWidth(CommUtil.null2Int(map.get("width")));
                acc2.setHeight(CommUtil.null2Int(map.get("height")));
                acc2.setAddtime(new Date());
                this.accessoryService.save(acc2);
                report.setAcc2Id(acc2.getId());
            }
            map.clear();
            map = CommUtil.saveFileToServer(request, "img3", saveFilePathName,
                    null, null);
            if (map.get("fileName") != "") {
                ShoppingAccessory acc3 = new ShoppingAccessory();
                acc3.setName(CommUtil.null2String(map.get("fileName")));
                acc3.setExt(CommUtil.null2String(map.get("mime")));
                acc3.setSize(CommUtil.null2Float(map.get("fileSize")));
                acc3.setPath(uploadFilePath + "/report");
                acc3.setWidth(CommUtil.null2Int(map.get("width")));
                acc3.setHeight(CommUtil.null2Int(map.get("height")));
                acc3.setAddtime(new Date());
                this.accessoryService.save(acc3);
                report.setAcc3Id(acc3.getId());
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.reportService.save(report);
        mv.addObject("op_title", "举报商品成功");
        mv.addObject("url", CommUtil.getURL(request) + "/buyer/report.htm");
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="买家举报详情", value="/buyer/report_view.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/report_view.htm"})
    public ModelAndView report_view(HttpServletRequest request, HttpServletResponse response, String id) {
        ModelAndView mv = new JModelAndView(
                "buyer/report_view.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingReportWithBLOBs obj = this.reportService.getObjById(CommUtil.null2Long(id));
        mv.addObject("obj", obj);
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="买家取消举报", value="/buyer/report_cancel.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/report_cancel.htm"})
    public void report_cancel(HttpServletRequest request, HttpServletResponse response, String id, String currentPage) throws IOException {
        ShoppingReportWithBLOBs obj = this.reportService.getObjById(CommUtil.null2Long(id));
        obj.setStatus(-1);
        this.reportService.update(obj);
        response.sendRedirect("report.htm?currentPage=" + currentPage);
    }

    @RequestMapping({"/buyer/report_subject_load.htm"})
    public void report_subject_load(HttpServletRequest request, HttpServletResponse response, String type_id) {
       Map<String,Object> params = new HashMap();
        params.put("type_id", CommUtil.null2Long(type_id));
        List<ShoppingReportSubject> rss = this.reportSubjectService.queryByCondition(params);
        JSONArray jsonArray=new JSONArray();
        for (ShoppingReportSubject rs : rss) {
            Map map=new HashMap();
            map.put("id",rs.getId());
            map.put("title",rs.getTitle());
            jsonArray.add(map);

        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(jsonArray);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
       /* JSONArray map = new JSONArray();
        for (ShoppingReportSubject rs : rss) {
            JSONObject obj = new JSONObject();
            obj.put("id", rs.getId());
            obj.put("title", rs.getTitle());
            map.add(obj);
        }

        return map;*/
    }
}
