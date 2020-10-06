 package com.xdj.interfaces.mallinterface.controller.shop;

 import com.xdj.interfaces.mallinterface.cache.RequestMsgCache;
 import com.xdj.interfaces.mallinterface.mv.JModelAndView;
 import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
 import com.xdj.interfaces.mallinterface.service.*;
 import com.xdj.interfaces.mallinterface.util.ImageViewTools;
 import com.xdj.interfaces.mallinterface.util.UCTools;
 import com.xdj.www.core.tools.CommUtil;
 import com.xdj.www.core.uc.UCClient;
 import com.xdj.www.core.uc.XMLHelper;
 import com.xdj.www.entity.*;
 import org.apache.commons.lang3.StringUtils;
 import org.slf4j.Logger;
 import org.slf4j.LoggerFactory;
 import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
 import org.springframework.security.core.context.SecurityContextHolder;
 import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.servlet.ModelAndView;

 import javax.annotation.Resource;
 import javax.servlet.http.Cookie;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import java.io.IOException;
 import java.util.*;


 /**
  * @author Administrator
  */
 @Controller
 public class LoginViewAction {
   @Resource
   private ISysConfigService configService;
   @Resource
   private IUserConfigService userConfigService;
   @Resource
   private IRoleService roleService;
   @Resource
   private IUserService userService;

   @Resource
   private IIntegralLogService integralLogService;

   @Resource
   private IAlbumService albumService;

   @Resource
   private ImageViewTools imageViewTools;

   @Resource
   private UCTools ucTools;
   private Logger log =LoggerFactory.getLogger("login");

   @RequestMapping("/oauth.htm")
   public final ModelAndView oauth(HttpServletRequest request,String name,String id){
       ModelAndView mv = new ModelAndView();
       if(StringUtils.isNotBlank(id)){
           Map<String,Object> para = new HashMap<>();
          ShoppingUser user= userService.getOne(para);
          if(user == null ){

          }

       }
       return mv;
   }


   @RequestMapping("/shopping_logout.htm")
   public final void shopping_logout(HttpServletRequest request,HttpServletResponse response) throws IOException {
      request.getSession().removeAttribute("login-success");
      response.sendRedirect("/user/login.htm");
   }

   @RequestMapping({"/success.htm"})
   public final ModelAndView loginSuccess(HttpServletRequest request){
     ModelAndView mv = new ModelAndView();
     mv.setViewName("/shop/success.html");
     String reqest_sesion_id ="";
       Cookie[] cookies = request.getCookies();
       if (cookies != null) {
           for (Cookie cookie : cookies) {
               if (cookie.getName().equals("reqest_sesion_id")) {
                   reqest_sesion_id = CommUtil.null2String(cookie.getValue());
                   break;
               }
           }
       }
       String shopping_view_type = CommUtil.null2String( request.getSession().getAttribute( "shopping_view_type" ) );

     if(!"".equals(reqest_sesion_id)){
         mv.addObject("url", RequestMsgCache.urlSave.get(reqest_sesion_id));
     }else{
         if( (shopping_view_type != null) && (!shopping_view_type.equals( "" )) && (shopping_view_type.equals( "wap" ))) {
             mv.addObject("url", "/wap/index.htm");
         }else{
             mv.addObject("url", "/index.htm");
         }

     }
       mv.addObject("op_title", "登录成功");
     request.getSession().setAttribute("login-success", UUID.randomUUID());
     return mv;
   }

   /**
	 * 用户登录跳转页面
	 * @param request
	 * @param response
	 * @param url
	 * @return
	 */
   @RequestMapping({"/user/login.htm"})
   public ModelAndView login(HttpServletRequest request, HttpServletResponse response, String url) {
     ModelAndView mv = new JModelAndView("login.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
     String shopping_view_type = CommUtil.null2String(request.getSession(false).getAttribute("shopping_view_type"));
     if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
    	 mv = new JModelAndView("/wap/login.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
     }

     boolean domain_error = CommUtil.null2Boolean(request.getSession(false).getAttribute("domain_error"));
     if ((url != null) && (!url.equals(""))) {
       request.getSession(false).setAttribute("refererUrl", url);
     }
     if (domain_error) {
       mv = new JModelAndView("error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
       if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
    	   mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
       }
     }else {
       mv.addObject("randomImg", this.imageViewTools.random_login_img());
     }
     mv.addObject("uc_logout_js", request.getSession(false).getAttribute("uc_logout_js"));

     return mv;
   }

   /**
	 * 注册跳转页面
	 * @param request
	 * @param response
	 * @return
	 */
   @RequestMapping({"/register.htm"})
   public ModelAndView register(HttpServletRequest request, HttpServletResponse response)
   {
     ModelAndView mv = new JModelAndView("register.html", this.configService.getSysConfig(),
       this.userConfigService.getUserConfig(), 1, request, response);

     String shopping_view_type = CommUtil.null2String(request.getSession(false).getAttribute("shopping_view_type"));

	 if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
		 mv = new JModelAndView("wap/register.html", this.configService.getSysConfig(),
			       this.userConfigService.getUserConfig(), 1, request, response);
	 }
     request.getSession(false).removeAttribute("verify_code");
     return mv;
   }

   /**
	 * 注册保存
	 * @param request
	 * @param response
	 * @param userName
	 * @param password
	 * @param email
	 * @param code
	 * @return
	 * @throws IOException
	 */
   @RequestMapping("/register_finish.htm")
   public void register_finish(HttpServletRequest request, HttpServletResponse response, String userName, String password, String email, String code)
           throws  IOException{
       boolean reg = true;
       if ((code != null) && (!code.equals(""))) {
           code = CommUtil.filterHTML(code);

       }
       System.err.println("request.getSession(false).getAttribute(\"verify_code\")==="+request.getSession(false).getAttribute("verify_code"));
       Map params = new HashMap();
       params.put("username", userName);
       ShoppingUserExample example = new ShoppingUserExample();
       ShoppingUserExample.Criteria criteria = example.createCriteria();
       criteria.andUsernameEqualTo(userName);
       List<ShoppingUser> users=userService.selectByExample(example);
       if ((users != null) && (users.size() > 0)) {
           reg = false;
       }
       if (reg) {
           ShoppingUser user = new ShoppingUser();
           user.setUserrole("BUYER");
           user.setAddtime(new Date());
           user.setEmail(email);
           user.setDeletestatus(false);
           user.setGold(Integer.valueOf(0));
           user.setSex(Integer.valueOf(0));
           user.setStatus(Integer.valueOf(0));
           user.setLogincount(Integer.valueOf(1));
           user.setReport(Integer.valueOf(0));
           user.setUserCredit(Integer.valueOf(0));
           user.setYears(Integer.valueOf(0));
           user.setUsername(userName);
           user.setPassword(new BCryptPasswordEncoder().encode(password));
           params.clear();
           params.put("type", "BUYER");
           List<ShoppingRole> roles =roleService.queryByCondition(params);
           if (user.getRoles()==null){
               user.setRoles(new ArrayList<ShoppingRole>());
           }else{
               user.setRoles(roles);
               /*for (ShoppingRole role : roles) {
                   user.getRoles().add(role);
               }*/
           }
           if (this.configService.getSysConfig().getIntegral()) {
               user.setIntegral(this.configService.getSysConfig().getMemberregister());
               this.userService.save(user);
               System.err.println("user--save后====="+user.toString());
               ShoppingIntegrallog log = new ShoppingIntegrallog();
               log.setAddtime(new Date());
               log.setContent("用户注册增加" + this.configService.getSysConfig().getMemberregister() + "分");
               log.setIntegral(this.configService.getSysConfig().getMemberregister());
               log.setOperateUserId(user.getId());
               log.setType("reg");
               log.setDeletestatus(false);
               this.integralLogService.save(log);
           } else {
               this.userService.save(user);
           }

           ShoppingAlbum album = new ShoppingAlbum();
           album.setAddtime(new Date());
           album.setAlbumDefault(true);
           album.setAlbumName("默认相册");
           album.setAlbumSequence(-10000);
           album.setUserId(user.getId());
           album.setDeletestatus(false);
           this.albumService.save(album);
           request.getSession(false).removeAttribute("verify_code");
           if (this.configService.getSysConfig().getUcBbs()) {
               UCClient client = new UCClient();
               String ret = client.uc_user_register(userName, password, email);
               int uid = Integer.parseInt(ret);
               if (uid <= 0) {
                   if (uid == -1) {
                       System.out.print("用户名不合法");
                   }else if (uid == -2) {
                       System.out.print("包含要允许注册的词语");
                   }else if (uid == -3) {
                       System.out.print("用户名已经存在");
                   }else if (uid == -4) {
                       System.out.print("Email 格式有误");
                   }else if (uid == -5) {
                       System.out.print("Email 不允许注册");
                   }else if (uid == -6) {
                       System.out.print("该 Email 已经被注册");
                   }else {
                       System.out.print("未定义");
                   }
               }
               else {
                   this.ucTools.active_user(userName, user.getPassword(), email);
               }
           }
           response.sendRedirect("user/login.htm");
       }else{
           response.sendRedirect("register.htm");
       }
   }



     /**
      * 登录表单提交
      */
    @RequestMapping("/shopping_login.htm")
    public final void login( HttpServletRequest request, HttpServletResponse response) throws IOException {
        String reqest_sesion_id ="";
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("reqest_sesion_id")) {
                    reqest_sesion_id = CommUtil.null2String(cookie.getValue());
                    break;
                }
            }
        }
        if(!"".equals(reqest_sesion_id) && RequestMsgCache.urlSave.get(reqest_sesion_id) != null){
            response.sendRedirect(RequestMsgCache.urlSave.get(reqest_sesion_id).toString());
        }else{
           response.sendRedirect("/index.htm");
        }
    }

   /**
	 * 登录操作成功之后跳转判断
	 * @param request
	 * @param response
	 * @return
	 */
   @RequestMapping({"/user_login_success.htm"})
   public ModelAndView user_login_success(HttpServletRequest request, HttpServletResponse response)
   {
     ModelAndView mv = new JModelAndView("success.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
     String url = CommUtil.getURL(request) + "/index.htm";
     String shopping_view_type = CommUtil.null2String(request.getSession(false).getAttribute("shopping_view_type"));
     //跳转到微信端
     if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
       String store_id = CommUtil.null2String(request.getSession(false).getAttribute("store_id"));
       mv = new JModelAndView("wap/success.html",
         this.configService.getSysConfig(),
         this.userConfigService.getUserConfig(), 1, request, response);
       url = CommUtil.getURL(request) + "/wap/index.htm?store_id=" + store_id;
     }
     HttpSession session = request.getSession(false);
     if ((session.getAttribute("refererUrl") != null) &&
       (!session.getAttribute("refererUrl").equals(""))) {
       url = (String)session.getAttribute("refererUrl");
       session.removeAttribute("refererUrl");
     }
     if (this.configService.getSysConfig().getUcBbs()) {
       String uc_login_js = CommUtil.null2String(request.getSession(false).getAttribute("uc_login_js"));
       mv.addObject("uc_login_js", uc_login_js);
     }
     //第三方登录：QQ、新浪等
     String bind = CommUtil.null2String(request.getSession(false).getAttribute("bind"));
     if (!bind.equals("")) {
    	 mv = new JModelAndView(bind + "_login_bind.html",
         this.configService.getSysConfig(),
         this.userConfigService.getUserConfig(), 1, request, response);
       ShoppingUser user = SecurityUserHolder.getCurrentUser();
       mv.addObject("user", user);
       request.getSession(false).removeAttribute("bind");
     }
     mv.addObject("op_title", "登录成功");
     mv.addObject("url", url);
     return mv;
   }


   /**
	 * 登录模态窗口
	 * @param request
	 * @param response
	 * @return
	 */
   @RequestMapping({"/user_dialog_login.htm"})
   public ModelAndView user_dialog_login(HttpServletRequest request, HttpServletResponse response) {
     ModelAndView mv = new JModelAndView("user_dialog_login.html", this.configService.getSysConfig(),
       this.userConfigService.getUserConfig(), 1, request, response);
     return mv;
   }


   /** wap登录业务逻辑begin */

    @RequestMapping({ "/user/wap/login.htm" })
	public ModelAndView waplogin(HttpServletRequest request, HttpServletResponse response, String url) {

		ModelAndView mv = new JModelAndView("wap/login.html", this.configService.getSysConfig(),
				this.userConfigService.getUserConfig(), 1, request, response);
		request.getSession(false).removeAttribute("verify_code");

		boolean domain_error = CommUtil.null2Boolean(request.getSession(false).getAttribute("domain_error"));
		if ((url != null) && (!url.equals(""))) {
			request.getSession(false).setAttribute("refererUrl", url);
		}
		if (domain_error) {
            mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(), this.userConfigService.getUserConfig(), 1, request, response);
        }else {
			mv.addObject("imageViewTools", this.imageViewTools);
		}
		mv.addObject("uc_logout_js", request.getSession(false).getAttribute("uc_logout_js"));

		/*String shopping_view_type = CommUtil.null2String(request.getSession(false).getAttribute("shopping_view_type"));

		if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
			//String store_id = CommUtil.null2String(request.getSession(false).getAttribute("store_id"));
			mv = new JModelAndView("wap/success.html", this.configService.getSysConfig(),
					this.userConfigService.getUserConfig(), 1, request, response);
			mv.addObject("op_title", "成功！");
			mv.addObject("url", CommUtil.getURL(request) + "/wap/index.htm");
		}*/

		return mv;
	}


     private static String uc_Login(String username, String pws) {
         String ucsynlogin = "";
         UCClient e = new UCClient();
         String result = e.uc_user_login(username, pws);
         LinkedList rs = XMLHelper.uc_unserialize(result);
         if (rs.size() > 0) {
             int uid = Integer.parseInt((String) rs.get(0));
             String uname = (String) rs.get(1);
             String password = (String) rs.get(2);
             String email = (String) rs.get(3);
             if (uid > 0) {
                 ucsynlogin = e.uc_user_synlogin(uid);
             } else if (uid == -1) {
                 System.out.println("用户不存在,或者被删除");
             }

         }

         return ucsynlogin;
     }

     @RequestMapping({"/login_error.htm"})
     public ModelAndView login_error(HttpServletRequest request, HttpServletResponse response) {
         String login_role = (String)request.getSession(false).getAttribute("login_role");
         ModelAndView mv = null;
         String shopping_view_type = com.xdj.interfaces.mallinterface.util.CommUtil.null2String(request.getSession(false).getAttribute("shopping_view_type"));
         if (login_role == null) {
             login_role = "user";
         }
         if (login_role.equals("admin")) {
             mv = new JModelAndView("admin/blue/login_error.html", this.configService.getSysConfig(),
                     this.userConfigService.getUserConfig(), 0, request, response);
         } else {
             if ((shopping_view_type != null) && (!shopping_view_type.equals("")) && (shopping_view_type.equals("wap"))) {
                 mv = new JModelAndView("wap/error.html", this.configService.getSysConfig(),
                         this.userConfigService.getUserConfig(), 1, request, response);
                 mv.addObject("url", com.xdj.interfaces.mallinterface.util.CommUtil.getURL(request) + "/wap/index.htm");
             }
             mv = new JModelAndView("error.html", this.configService.getSysConfig(),
                     this.userConfigService.getUserConfig(), 1, request, response);
             mv.addObject("url", com.xdj.interfaces.mallinterface.util.CommUtil.getURL(request) + "/user/login.htm");
         }
         mv.addObject("op_title", "登录失败");
         return mv;
     }


     @RequestMapping("/")
     public final void index(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.sendRedirect("/index.htm");
     }

 }




