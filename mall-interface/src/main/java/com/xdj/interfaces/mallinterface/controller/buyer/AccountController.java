package com.xdj.interfaces.mallinterface.controller.buyer;

import com.alibaba.fastjson.JSONArray;
import com.xdj.interfaces.mallinterface.controller.view.AccessoryViewTools;
import com.xdj.interfaces.mallinterface.controller.view.AreaViewTools;
import com.xdj.interfaces.mallinterface.mv.JModelAndView;
import com.xdj.interfaces.mallinterface.mv.PageModel;
import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.*;
import com.xdj.interfaces.mallinterface.util.BCryptUtil;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.interfaces.mallinterface.util.MsgTools;
import com.xdj.www.core.annotation.SecurityMapping;
import com.xdj.www.core.tools.StringUtils;
import com.xdj.www.core.uc.UCClient;
import com.xdj.www.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author Administrator
 */
@RestController
public class AccountController {
    @Resource
    private ISysConfigService configService;
    @Resource
    private IUserConfigService userConfigService;
    @Resource
    private IUserService userService;
    @Resource
    private IAreaService areaService;
    @Resource
    private IAccessoryService accessoryService;
    @Resource
    private IMobileVerifyCodeService mobileverifycodeService;
    @Resource
    private ITemplateService templateService;
    @Resource
    private ISnsFriendService snsFriendService;
    @Resource
    private MsgTools msgTools;
    @Resource
    private AccessoryViewTools accessoryViewTools;
    @Resource
    private AreaViewTools areaViewTools;
    private final static Logger log = LoggerFactory.getLogger("account");

    @SecurityMapping(display = false, rsequence = 0, title="好友添加", value="/buyer/friend_add.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/friend_add.htm"})
    public ModelAndView friend_add(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView mv = new JModelAndView("buyer/account_friend_search.html",this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        Map<String,Object> params = new HashMap<>();
        params.put("parent_id","is null");
        List<ShoppingArea> areas = this.areaService.queryByCondition(params);
        //areaViewTools.addManyChilds(areas,true);
        mv.addObject("areas", areas);
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="个人信息导航", value="/buyer/account_nav.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_nav.htm"})
    public ModelAndView account_nav(HttpServletRequest request, HttpServletResponse response)
    {
        ModelAndView mv = new JModelAndView(
                "buyer/account_nav.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        String op = CommUtil.null2String(request.getAttribute("op"));
        mv.addObject("op", op);
        ShoppingUser user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
        accessoryViewTools.addUserHeadImg(user);
        mv.addObject("user", user);
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="个人信息", value="/buyer/account.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account.htm"})
    public ModelAndView account(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView("buyer/account.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        String shopping_view_type = CommUtil.null2String(request.getSession().getAttribute("shopping_view_type"));
        if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
            mv = new JModelAndView("wap/account.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        ShoppingUser user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
        accessoryViewTools.addUserHeadImg(user);
        if( user.getAreaId()!=null && !"".equals(user.getAreaId()) ) {
            ShoppingArea area = areaService.getObjById(user.getAreaId());
            user.setArea(area);
            areaViewTools.addGrandpa(area);
        }
        mv.addObject("user",user);
        Map<String,Object> params = new HashMap<>();
        params.put("parent_id","is null");
        List<ShoppingArea> areas = this.areaService.queryByCondition(params);
        mv.addObject("areas", areas);
        return mv;
    }

    //app个人资料
    @RequestMapping({"/buyer/app_account.htm"})
    public ModelAndView app_account(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView("wap/account.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        ShoppingUser user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
        accessoryViewTools.addUserHeadImg(user);
        if( user.getAreaId()!=null && !"".equals(user.getAreaId()) ) {
            ShoppingArea area = areaService.getObjById(user.getAreaId());
            user.setArea(area);
            areaViewTools.addGrandpa(area);
        }
        mv.addObject("user",user);
        Map<String,Object> params = new HashMap<>();
        params.put("parent_id","is null");
        List<ShoppingArea> areas = this.areaService.queryByCondition(params);
        mv.addObject("areas", areas);
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="个人信息获取下级地区ajax", value="/buyer/account_getAreaChilds.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_getAreaChilds.htm"})
    public ModelAndView account_getAreaChilds(HttpServletRequest request, HttpServletResponse response, String parent_id) {
        ModelAndView mv = new JModelAndView("buyer/account_area_chlids.html",
                this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        log.info("----parentId---{}",parent_id);
        Map map = new HashMap();
        map.put("parent_id", "=".concat(parent_id));
        List childs = this.areaService.queryByCondition(map);
        if (childs.size() > 0) {
            mv.addObject("childs", childs);
        }
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="个人信息保存", value="/buyer/account_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_save.htm"})
    public ModelAndView account_save(HttpServletRequest request, HttpServletResponse response, String area_id, String birthday) throws ParseException {
        ModelAndView mv = new JModelAndView("success.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        ShoppingUser user = SecurityUserHolder.getCurrentUser();
        if ((area_id != null) && (!area_id.equals(""))) {
            user.setAreaId( CommUtil.null2Long(area_id));
        }
        if ((birthday != null) && (!birthday.equals(""))) {
            String[] y = birthday.split("-");
            Calendar calendar = new GregorianCalendar();
            int years = calendar.get(1) - CommUtil.null2Int(y[0]);
            user.setYears(years);
            user.setBirthday(format.parse(birthday));
        }
        user.setQq(request.getParameter("qq"));
        user.setTruename(request.getParameter("truename"));
        user.setWw(request.getParameter("ww"));
        user.setMsn(request.getParameter("msn"));
        user.setSex(Integer.valueOf(request.getParameter("sex")));
        this.userService.update(user);
        mv.addObject("op_title", "个人信息修改成功");
        mv.addObject("url", CommUtil.getURL(request) + "/buyer/account.htm");
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="密码修改", value="/buyer/account_password.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_password.htm"})
    public ModelAndView account_password(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView("buyer/account_password.html", this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );
        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/account_password.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="密码修改保存", value="/buyer/account_password_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_password_save.htm"})
    public ModelAndView account_password_save(HttpServletRequest request, HttpServletResponse response, String old_password, String new_password) throws Exception {
        ModelAndView mv = new JModelAndView("success.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );
        if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
            mv = new JModelAndView("wap/success.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        }
        ShoppingUser user = this.userService.getObjById(
                SecurityUserHolder.getCurrentUser().getId());

        if (BCryptUtil.isMatch(old_password,user.getPassword())){
            user.setPassword(BCryptUtil.encode(new_password));
            int ret = this.userService.update(user);
            if ((ret>0) && (this.configService.getSysConfig().getUcBbs())) {
                UCClient uc = new UCClient();
                String str = uc.uc_user_edit(user.getUsername(),
                        CommUtil.null2String(old_password),
                        CommUtil.null2String(new_password),
                        CommUtil.null2String(user.getEmail()), 1, 0, 0);
            }

            mv.addObject("op_title", "密码修改成功");
            send_sms(request, "sms_tobuyer_pws_modify_notify");
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
            if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" )) ) {
                mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
            }
            mv.addObject("op_title", "原始密码输入错误，修改失败");
        }
        mv.addObject("url", CommUtil.getURL(request) + "/buyer/account_password.htm");
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="邮箱修改", value="/buyer/account_email.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_email.htm"})
    public ModelAndView account_email(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView(
                "buyer/account_email.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="邮箱修改保存", value="/buyer/account_email_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_email_save.htm"})
    public ModelAndView account_email_save(HttpServletRequest request, HttpServletResponse response, String password, String email) {
        ModelAndView mv = new JModelAndView("success.html", this.configService
                .getSysConfig(), this.userConfigService.getUserConfig(), 1,
                request, response);
        ShoppingUser user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
        if (BCryptUtil.isMatch(password,user.getPassword())) {
            user.setEmail(email);
            this.userService.update(user);
            mv.addObject("op_title", "邮箱修改成功");
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "密码输入错误，邮箱修改失败");
        }
        mv.addObject("url", CommUtil.getURL(request) +
                "/buyer/account_email.htm");
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="图像修改", value="/buyer/account_avatar.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_avatar.htm"})
    public ModelAndView account_avatar(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView("buyer/account_avatar.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 0, request, response);
        String shopping_view_type = CommUtil.null2String(request.getSession().getAttribute("shopping_view_type"));
        if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
            mv = new JModelAndView("wap/account_avatar.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request, response);
        }
        ShoppingUser user = SecurityUserHolder.getCurrentUser();
        accessoryViewTools.addUserHeadImg(user);
        mv.addObject("user",user);
        mv.addObject("url", CommUtil.getURL(request));
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="图像上传", value="/buyer/upload_avatar.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/upload_avatar.htm"})
    public void upload_avatar(String accessory, HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0L);
        System.err.println("accc===================="+accessory);
        ShoppingAccessory accessory1= JSONArray.parseObject(accessory, ShoppingAccessory.class);
        try{
            ShoppingUser user = SecurityUserHolder.getCurrentUser();
            //ShoppingAccessory accessory1= new Gson().fromJson(accessory,ShoppingAccessory.class);
            if(user.getPhotoId() == null){
                accessoryService.save(accessory1);
                user.setPhotoId(accessory1.getId());
                this.userService.update(user);
            }else{
                accessory1.setId(user.getPhotoId());
                accessoryService.update(accessory1);
            }
            response.setContentType("text/xml");
            response.getWriter().write("200");
        } catch (Exception e) {
            e.printStackTrace();
            response.setContentType("text/xml");
            response.getWriter().write("400");
        }
    }


    private void saveImage(String filePath, String imageType, String avatarContent, String avatarName) throws IOException {
        avatarContent = CommUtil.null2String(avatarContent);
        if (!"".equals(avatarContent)) {
            if ("".equals(avatarName)) {
                avatarName = UUID.randomUUID().toString() +".jpg";
            }else {
                avatarName = avatarName + imageType;
            }
            //byte[] data = _decoder.decodeBuffer(avatarContent);
            //byte[] data = Base64.decodeBase64(avatarContent);
            File f = new File(filePath + File.separator + avatarName);
            DataOutputStream dos = new DataOutputStream(new FileOutputStream(f));
            //dos.write(data);
            dos.flush();
            dos.close();
        }
    }

    @SecurityMapping(display = false, rsequence = 0, title="手机号码修改", value="/buyer/account_mobile.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_mobile.htm"})
    public ModelAndView account_mobile(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView(
                "buyer/account_mobile.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        mv.addObject("url", CommUtil.getURL(request));
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="手机号码保存", value="/buyer/account_mobile_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_mobile_save.htm"})
    public ModelAndView account_mobile_save(HttpServletRequest request, HttpServletResponse response, String mobile_verify_code, String mobile) throws Exception {
        ModelAndView mv = new JModelAndView("success.html", this.configService
                .getSysConfig(), this.userConfigService.getUserConfig(), 1,
                request, response);
        ShoppingUser user = this.userService.getObjById(SecurityUserHolder.getCurrentUser().getId());
        Map<String,Object> params=new HashMap<>();
        params.put("mobile", mobile);
        ShoppingMobileverifycode mvc = this.mobileverifycodeService.queryByCondition(params);
        if ((mvc != null) && (mvc.getCode().equalsIgnoreCase(mobile_verify_code))) {
            user.setMobile(mobile);
            this.userService.update(user);
            this.mobileverifycodeService.delete(mvc.getId());
            mv.addObject("op_title", "手机绑定成功");

            send_sms(request, "sms_tobuyer_mobilebind_notify");
            mv.addObject("url", CommUtil.getURL(request) +
                            "/buyer/account.htm");
        } else {
            mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                    this.userConfigService.getUserConfig(), 1, request,
                    response);
            mv.addObject("op_title", "验证码错误，手机绑定失败");
            mv.addObject("url", CommUtil.getURL(request) +
                    "/buyer/account_mobile.htm");
        }
        return mv;
    }

    @SecurityMapping(display = false, rsequence = 0, title="手机短信发送", value="/buyer/account_mobile_sms.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_mobile_sms.htm"})
    public void account_mobile_sms(HttpServletRequest request, HttpServletResponse response, String type, String mobile)
            throws UnsupportedEncodingException {
        String ret = "100";
        if (type.equals("mobile_vetify_code")) {
            String code = CommUtil.randomString(4).toUpperCase();
            String content = "尊敬的" +
                    SecurityUserHolder.getCurrentUser().getUsername() +
                    "您好，您在试图修改" +
                    this.configService.getSysConfig().getWebsitename() +
                    "用户绑定手机，手机验证码为：" + code + "。[" +
                    this.configService.getSysConfig().getTitle() + "]";
            if (this.configService.getSysConfig().getSmsenbale()) {
                boolean ret1 = this.msgTools.sendSMS(mobile, content);
                Map<String,Object> params=new HashMap<>();
                params.put("mobile", mobile);
                if (ret1) {
                    ShoppingMobileverifycode mvc = this.mobileverifycodeService.queryByCondition(params);
                    if (mvc == null) {
                        mvc = new ShoppingMobileverifycode();
                    }
                    mvc.setAddtime(new Date());
                    mvc.setCode(code);
                    mvc.setMobile(mobile);
                    this.mobileverifycodeService.update(mvc);
                } else {
                    ret = "200";
                }
            } else {
                ret = "300";
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
    }

    @SecurityMapping(display = false, rsequence = 0, title="好友管理", value="/buyer/friend.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/friend.htm"})
    public ModelAndView account_friend(HttpServletRequest request, HttpServletResponse response, String currentPage) {
        ModelAndView mv = new JModelAndView(
                "buyer/account_friend.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        int pageNow= 1;
        if(StringUtils.isBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("orderBy","addTime");
        map.put("sort","desc");
        map.put("fromUser_id",SecurityUserHolder.getCurrentUser().getId());
        map.put("start",(pageNow-1)*10);
        map.put("pageSize",10);
        List<ShoppingUserFriend> pList = snsFriendService.queryByCondition(map);
        if(pList != null && pList.size() >0){
            int count =  this.snsFriendService.count(map);
            PageModel page = new PageModel();
            page.setResult(pList);
            page.setRowCount(count);
            page.setPageSize(10);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="搜索用户", value="/buyer/account_friend_search.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_friend_search.htm"})
    public ModelAndView friend_search(HttpServletRequest request, HttpServletResponse response, String userName, String area_id, String sex, String years, String currentPage) {
        ModelAndView mv = new JModelAndView(
                "buyer/account_friend_search.html",this.configService.getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        int pageNow= 1;
        if(StringUtils.isBlank(currentPage)){
            pageNow=Integer.valueOf(currentPage);
        }
        Map<String,Object> map=new HashMap<>();
        map.put("orderBy","addTime");
        map.put("sort","desc");
        map.put("userRole","ADMIN");// !=
        map.put("start",(pageNow-1)*18);
        map.put("pageSize",Integer.valueOf(18));
        if ((userName != null) && (!userName.equals(""))) {
            mv.addObject("userName", userName);
            map.put("userName","%" + userName + "%");
        }
        if ((years != null) && (!years.equals(""))) {
            mv.addObject("years", years);
            if (years.equals("18")) {
                map.put("years1",Integer.valueOf(CommUtil.null2Int(years))); // <=
            }
            if (years.equals("50")) {
                map.put("years2",Integer.valueOf(CommUtil.null2Int(years)));// >=
            }
            if ((!years.equals("18")) && (!years.equals("50"))) {
                String[] y = years.split("~");
                map.put("years3",Integer.valueOf(CommUtil.null2Int(y[0])));// >=
                map.put("years4",Integer.valueOf(CommUtil.null2Int(y[1])));// <=
            }
        }
        if ((sex != null) && (!sex.equals(""))) {
            mv.addObject("sex", sex);
            map.put("sex",Integer.valueOf(CommUtil.null2Int(sex)));
        }
        if ((area_id != null) && (!area_id.equals(""))&& (!"undefined".equals(area_id))) {
            ShoppingArea area = this.areaService.getObjById(CommUtil.null2Long(area_id));
            mv.addObject("area", area);
            map.put("area_id",CommUtil.null2Long(area_id));

        }
        //qo.addQuery("obj.id", new SysMap("user_id", SecurityUserHolder.getCurrentUser().getId()), "!=");
        List<ShoppingUser> pList = userService.queryByCondition(map);
        if(pList != null && pList.size() >0){
            int count =  this.userService.count(map);
            PageModel page = new PageModel();
            areaViewTools.addUserAreas(pList);
            accessoryViewTools.addUserHeadImgs(pList);
            page.setCurrentPage(pageNow);
            page.setRowCount(count);
            page.setResult(pList);
            page.setPageSize(18);
            page.setCurrentPage(pageNow);
            CommUtil.saveIPageList2ModelAndView("", "", "", page, mv);
        }
        map.clear();
        map.put("parent_id","is null");
        List areas = this.areaService.queryByCondition(map);
        mv.addObject("areas", areas);
        return mv;
    }


     @SecurityMapping(display = false, rsequence = 0, title="好友添加", value="/buyer/friend_add_save.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/friend_add_save.htm"})
    public void friend_add_save(HttpServletRequest request, HttpServletResponse response, String user_id) {
        boolean flag = false;
        Map params = new HashMap();
        params.put("toUser_id", CommUtil.null2Long(user_id));
        params.put("fromUser_id", SecurityUserHolder.getCurrentUser().getId());
        List sfs = this.snsFriendService.queryByCondition(params);
                //.query("select obj from SnsFriend obj where obj.fromUser.id=:uid and obj.toUser.id=:user_id", params, -1, -1);
        if (sfs.size() == 0) {
            ShoppingUserFriend friend = new ShoppingUserFriend();
            friend.setAddtime(new Date());
            friend.setFromuserId(SecurityUserHolder.getCurrentUser().getId());
            friend.setTouserId(CommUtil.null2Long(user_id));
            flag = this.snsFriendService.save(friend);
        }
        response.setContentType("text/plain");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        try
        {
            PrintWriter writer = response.getWriter();
            writer.print(flag);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SecurityMapping(display = false, rsequence = 0, title="好友删除", value="/buyer/friend_del.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/friend_del.htm"})
    public void friend_del(HttpServletRequest request, HttpServletResponse response, String id) {
        this.snsFriendService.delete(CommUtil.null2Long(id));
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

    @SecurityMapping(display = false, rsequence = 0, title="账号绑定", value="/buyer/account_bind.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_bind.htm"})
    public ModelAndView account_bind(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mv = new JModelAndView(
                "buyer/account_bind.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingUser user = this.userService.getObjById(
                SecurityUserHolder.getCurrentUser().getId());
        mv.addObject("user", user);
        return mv;
    }


    @SecurityMapping(display = false, rsequence = 0, title="账号解除绑定", value="/buyer/account_bind_cancel.htm*", rtype="buyer", rname="用户中心", rcode="user_center", rgroup="用户中心")
    @RequestMapping({"/buyer/account_bind_cancel.htm"})
    public void account_bind_cancel(HttpServletRequest request, HttpServletResponse response, String account) throws IOException {
        ModelAndView mv = new JModelAndView(
                "/buyer/account_bind.html", this.configService
                .getSysConfig(),
                this.userConfigService.getUserConfig(), 0, request, response);
        ShoppingUser user = this.userService.getObjById(
                SecurityUserHolder.getCurrentUser().getId());
        if (CommUtil.null2String(account).equals("qq")) {
            user.setQqOpenid(null);
        }
        if (CommUtil.null2String(account).equals("sina")) {
            user.setSinaOpenid(null);
        }
        this.userService.update(user);
        response.sendRedirect("account_bind.htm");
    }

    private void send_sms(HttpServletRequest request, String mark) throws Exception{
       /* Map<String,Object> params=new HashMap<>();
        params.put("mark",mark);
         ShoppingTemplate template = this.templateService.queryByProperty(params);
        if ((template != null) && (template.getOpen())) {
            ShoppingUser user = this.userService.getObjById(
                    SecurityUserHolder.getCurrentUser().getId());
            String mobile = user.getMobile();
            if ((mobile != null) && (!mobile.equals(""))) {
                String path = request.getSession().getServletContext()
                        .getRealPath("/") +
                        "/vm/";
                PrintWriter pwrite = new PrintWriter(
                        new OutputStreamWriter(new FileOutputStream(path + "msg.vm", false), "UTF-8"));
                pwrite.print(template.getContent());
                pwrite.flush();
                pwrite.close();

                Properties p = new Properties();
                p.setProperty("file.resource.loader.path", request
                        .getRealPath("/") +
                        "vm" + File.separator);
                p.setProperty("input.encoding", "UTF-8");
                p.setProperty("output.encoding", "UTF-8");
              Velocity.init(p);
                org.apache.velocity.Template blank = Velocity.getTemplate(
                        "msg.vm", "UTF-8");
                VelocityContext context = new VelocityContext();
                context.put("user", user);
                context.put("config", this.configService.getSysConfig());
                context.put("send_time", CommUtil.formatLongDate(new Date()));
                context.put("webPath", CommUtil.getURL(request));
                StringWriter writer = new StringWriter();
                blank.merge(context, writer);

                String content = writer.toString();
                this.msgTools.sendSMS(mobile, content);
            }
        }*/
    }

}
