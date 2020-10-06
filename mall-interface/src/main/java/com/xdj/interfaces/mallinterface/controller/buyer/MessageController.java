package com.xdj.interfaces.mallinterface.controller.buyer;

import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.IMessageService;
import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.IUserConfigService;
import com.xdj.interfaces.mallinterface.service.IUserService;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.tools.StringUtils;
import com.xdj.www.entity.ShoppingMessage;
import com.xdj.www.entity.ShoppingUser;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MessageController {
    @Autowired
    private ISysConfigService configService;

    @Autowired
    private IUserConfigService userConfigService;

    @Autowired
    private IMessageService messageService;

    @Autowired
    private IUserService userService;

    @SecurityMapping(display = false, rsequence = 0, title="站内短信", value="/buyer/message.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/message.htm"})
    public ModelAndView message(HttpServletRequest request, HttpServletResponse response, String type, String from_user_id, String currentPage)
    {
        ModelAndView mv = new JModelAndView(
                "buyer/message.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> map=new HashMap<>();
        if ((from_user_id == null) || (from_user_id.equals(""))) {
            if ((type == null) || (type.equals(""))) {
                type = "1";
            }
            map.put("to_user_id",SecurityUserHolder.getCurrentUser().getId());
            map.put("type",Integer.valueOf(CommUtil.null2Int(type)));
        } else {
            map.put("from_user_id",SecurityUserHolder.getCurrentUser().getId());
            type = "2";
        }
        int pageNow= 1;
        if(StringUtils.isBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        map.put("orderBy","addTime");
        map.put("sort","desc");
        map.put("parent_id","is null");
        map.put("start",(pageNow-1)*10);
        map.put("pageSize",10);
        List<ShoppingMessage> pList = messageService.queryByCondition(map);

        if(pList != null && pList.size() >0){
            int count =  this.messageService.count(map);
            PageModel page = new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            page.setPageSize(10);
            page.setCurrentPage(pageNow);
            String url = this.configService.getSysConfig().getAddress();
            if ((url == null) || (url.equals(""))) {
                url = CommUtil.getURL(request);
            }
            CommUtil.saveIPageList2ModelAndView(url + "/buyer/message.htm", "", "", page, mv);
        }
        cal_msg_info(mv);
        mv.addObject("type", type);
        mv.addObject("from_user_id", from_user_id);
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="站内短信删除", value="/buyer/message_del.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/message_del.htm"})
    public void message_del(HttpServletRequest request, HttpServletResponse response, String type, String from_user_id, String mulitId) throws IOException {
        String[] ids = mulitId.split(",");
        for (String id : ids) {
            if (!id.equals("")) {
                this.messageService.delete(Long.valueOf(Long.parseLong(id)));
            }
        }
        if (CommUtil.null2String(from_user_id).equals("")) {
            response.sendRedirect("/buyer/message.htm?type=" + type);
        }else{
            response.sendRedirect("/buyer/message.htm?from_user_id=" + from_user_id);
        }

    }
    @SecurityMapping(display = false, rsequence = 0, title="站内短信查看", value="/buyer/message_info.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/message_info.htm"})
    public ModelAndView message_info(HttpServletRequest request, HttpServletResponse response, String id, String type) {
        ModelAndView mv = new JModelAndView(
                "buyer/message_info.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingMessage obj = this.messageService.getObjById(Long.valueOf(Long.parseLong(id)));

        if ((SecurityUserHolder.getCurrentUser().getId()).equals(obj.getTouserId())) {
            obj.setStatus(1);
            this.messageService.update(obj);
        }

        if ((SecurityUserHolder.getCurrentUser().getId()).equals(obj.getFromuserId())) {
            obj.setReplyStatus(0);
            this.messageService.update(obj);
        }
        mv.addObject("obj", obj);
        mv.addObject("type", type);
        cal_msg_info(mv);
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="站内短信发送", value="/buyer/message_send.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/message_send.htm"})
    public ModelAndView message_send(HttpServletRequest request, HttpServletResponse response, String id, String userName) {
        ModelAndView mv = new JModelAndView(
                "buyer/message_send.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        cal_msg_info(mv);
        if ((userName != null) && (!userName.equals(""))) {
            mv.addObject("userName", userName);
        }
        return mv;
    }
    @SecurityMapping(display = false, rsequence = 0, title="站内短信保存", value="/buyer/message_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/message_save.htm"})
    public void message_save(HttpServletRequest request, HttpServletResponse response, String users, String content) {
        String[] userNames = users.split(",");
        for (String userName : userNames) {
            ShoppingUser toUser = this.userService.findByUsername(userName);
            if (toUser != null) {
                ShoppingMessage msg = new ShoppingMessage();
                msg.setAddtime(new Date());
                Whitelist whiteList = new Whitelist();
                content = content.replaceAll("\n", "iskyhop_br");
                msg.setContent(Jsoup.clean(content, Whitelist.basic())
                        .replaceAll("iskyhop_br", "\n"));
                msg.setFromuserId(SecurityUserHolder.getCurrentUser().getId());
                msg.setTouserId(toUser.getId());
                msg.setType(1);
                msg.setDeletestatus(false);
                msg.setStatus(Integer.valueOf(0));
                this.messageService.save(msg);
            }
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(true);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping({"/buyer/message_success.htm"})
    public ModelAndView message_success(HttpServletRequest request, HttpServletResponse response, String users, String content) {
        ModelAndView mv = new JModelAndView(
                "buyer/success.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        mv.addObject("op_title", "短信保存成功");
        mv.addObject("url", CommUtil.getURL(request) + "/buyer/message.htm");
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="站内短信回复", value="/buyer/message_reply.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/message_reply.htm"})
    public ModelAndView message_reply(HttpServletRequest request, HttpServletResponse response, String pid, String type, String content) {
        ModelAndView mv = new JModelAndView(
                "buyer/success.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingMessage parent = this.messageService.getObjById(Long.valueOf(Long.parseLong(pid)));
        ShoppingMessage reply = new ShoppingMessage();
        reply.setAddtime(new Date());
        reply.setContent(content);
        reply.setFromuserId(SecurityUserHolder.getCurrentUser().getId());
        reply.setTouserId(parent.getFromuserId());
        reply.setType(1);
        reply.setParentId(parent.getId());
        reply.setDeletestatus(false);
        reply.setStatus(1);
        reply.setReplyStatus(1);
        this.messageService.save(reply);

        if (!parent.getFromuserId().equals(
                SecurityUserHolder.getCurrentUser().getId())) {
            parent.setReplyStatus(1);
        }
        this.messageService.update(parent);
        mv.addObject("op_title", "短信回复成功");
        mv.addObject("url", CommUtil.getURL(request) +
                "/buyer/message.htm?type=" + CommUtil.null2Int(type));
        return mv;
    }

    @RequestMapping({"/message_validate_user.htm"})
    public void message_validate_user(HttpServletRequest request, HttpServletResponse response, String users) {
        String[] userNames = users.trim().split(",");
        String ret = "";
        for (String userName : userNames) {
            if (!userName.trim().equals("")) {
                ShoppingUser user = this.userService.findByUsername(userName.trim());
                if (user == null) {
                    ret = userName.trim() + "," + ret;
                }
            }
        }
        if (ret.indexOf(",") >= 0) {
            ret = ret.substring(0, ret.length() - 1);
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(ret);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cal_msg_info(ModelAndView mv) {
        Map params = new HashMap();
        params.put("status", Integer.valueOf(0));
        params.put("status1", Integer.valueOf(3));
        params.put("type", Integer.valueOf(1));
        params.put("parent_id","is null");
        params.put("orderBy","addTime");
        params.put("sort","desc");
        params.put("to_user_id", SecurityUserHolder.getCurrentUser().getId());
        List user_msgs = this.messageService.queryByCondition(params);
                //.query("select obj from Message obj where (obj.status=:status or obj.status=:status1) and obj.type=:type and obj.toUser.id=:user_id and obj.parent.id is null order by obj.addTime desc", params, -1, -1);
        params.clear();
        params.put("status", Integer.valueOf(0));
        params.put("type", Integer.valueOf(0));
        params.put("parent_id","is null");
        params.put("orderBy","addTime");
        params.put("sort","desc");
        params.put("to_user_id", SecurityUserHolder.getCurrentUser().getId());
        List sys_msgs = this.messageService.queryByCondition(params);
                //.query("select obj from Message obj where obj.status=:status and obj.type=:type and obj.toUser.id=:user_id and obj.parent.id is null order by obj.addTime desc", params, -1, -1);
        params.clear();
        params.put("reply_status", Integer.valueOf(1));
        params.put("from_user_id", SecurityUserHolder.getCurrentUser().getId());
        List replys = this.messageService.queryByCondition(params);
                //.query("select obj from Message obj where obj.reply_status=:reply_status and obj.fromUser.id=:from_user_id", params, -1, -1);
        mv.addObject("user_msgs", user_msgs);
        mv.addObject("sys_msgs", sys_msgs);
        mv.addObject("reply_msgs", replys);
    }
}
