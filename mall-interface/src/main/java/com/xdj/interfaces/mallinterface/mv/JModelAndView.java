package com.xdj.interfaces.mallinterface.mv;

import com.xdj.interfaces.mallinterface.security.SecurityUserHolder;
import com.xdj.interfaces.mallinterface.service.IAccessoryService;
import com.xdj.interfaces.mallinterface.util.SpringUtils;
import com.xdj.www.core.tools.CommUtil;
import com.xdj.www.core.tools.HttpInclude;
import com.xdj.www.entity.ShoppingSysconfig;
import com.xdj.www.entity.ShoppingUser;
import com.xdj.www.entity.ShoppingUserconfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Administrator
 */

public class JModelAndView extends ModelAndView{
  private static final Logger log = LoggerFactory.getLogger("modelmsg");
  public JModelAndView(String viewName)
  {
    super.setViewName(viewName);
  }

  public JModelAndView(String viewName, ShoppingSysconfig config, ShoppingUserconfig uconfig, HttpServletRequest request, HttpServletResponse response)
  {
    String contextPath = request.getContextPath().equals("/") ? "" :
      request.getContextPath();
    String webPath = CommUtil.getURL(request);
    String port = ":" +
      CommUtil.null2Int(Integer.valueOf(request.getServerPort()));
    if ((config.getSecondDomainOpen()) && (!CommUtil.generic_domain(request).equals("localhost"))) {
      webPath = "http://www." + CommUtil.generic_domain(request) + port + contextPath;
    }
    ShoppingUser user = SecurityUserHolder.getCurrentUser();
    if(user != null){
      IAccessoryService accessoryService= SpringUtils.getBean("iAccessoryService",IAccessoryService.class);
      user.setPhoto(accessoryService.getObjById(user.getPhotoId()));
    }
    super.setViewName(viewName);
    super.addObject("domainPath", CommUtil.generic_domain(request));
    if ((config.getImagewebserver() != null) &&  (!config.getImagewebserver().equals(""))) {
      super.addObject("imageWebServer", config.getImagewebserver());
    }else {
      super.addObject("imageWebServer", webPath);
    }
    super.addObject("webPath", webPath);
    super.addObject("config", config);
    super.addObject("uconfig", uconfig);
    super.addObject("user", user);
    super.addObject("httpInclude", new HttpInclude(request, response));
    String query_url = "";
    if ((request.getQueryString() != null) &&
      (!request.getQueryString().equals(""))) {
      query_url = "?" + request.getQueryString();
    }
    super.addObject("current_url", request.getRequestURI() + query_url);
    boolean second_domain_view = false;
    String serverName = request.getServerName().toLowerCase();

    if ((serverName.indexOf("www.") < 0) && (serverName.indexOf(".") >= 0) &&
      //(serverName.indexOf("localhost") < 0) && !serverName.startsWith("1") &&
      (serverName.indexOf(".") != serverName.lastIndexOf(".")) &&
      (config.getSecondDomainOpen())) {
      String secondDomain = serverName.substring(0, serverName.indexOf("."));
      second_domain_view = true;
      super.addObject("secondDomain", secondDomain);
    }
    super.addObject("second_domain_view", Boolean.valueOf(second_domain_view));
  }


  public JModelAndView(String viewName, ShoppingSysconfig config, ShoppingUserconfig uconfig, int type, HttpServletRequest request, HttpServletResponse response){
    if (config.getSyslanguage() != null) {
      if (config.getSyslanguage().equals("zh_cn")) {
        if (type == 0) {
          super.setViewName("/system/" + viewName);
        }
        if (type == 1) {
          super.setViewName("/shop/" + viewName);
        }
        if (type > 1) {
          super.setViewName(viewName);
        }
      } else {
        if (type == 0) {
          super.setViewName("/templates/" +
            config.getSyslanguage() + "/system/" + viewName);
        }
        if (type == 1) {
          super.setViewName("/templates/" +
            config.getSyslanguage() + "/shop/" + viewName);
        }
        if (type > 1) {
          super.setViewName(viewName);
        }
      }
    }else {
      super.setViewName(viewName);
    }
    String contextPath = request.getContextPath().equals("/") ? "" :request.getContextPath();
    String webPath = CommUtil.getURL(request);
    String port = ":" +
      CommUtil.null2Int(Integer.valueOf(request.getServerPort()));
    if ((config.getSecondDomainOpen()) &&
      (!CommUtil.generic_domain(request).equals("localhost"))) {
      webPath = "http://www." + CommUtil.generic_domain(request) + port +
        contextPath;
    }
    super.addObject("domainPath", CommUtil.generic_domain(request));
    super.addObject("webPath", webPath);
    if ((config.getImagewebserver() != null) &&
      (!config.getImagewebserver().equals(""))) {
      super.addObject("imageWebServer", config.getImagewebserver());
    } else {
      super.addObject("imageWebServer", webPath);
    }
    ShoppingUser user = SecurityUserHolder.getCurrentUser();
    if(user != null){
      IAccessoryService accessoryService=SpringUtils.getBean("accessoryService",IAccessoryService.class);
      if(user.getPhotoId() != null){
        user.setPhoto(accessoryService.getObjById(user.getPhotoId()));
      }

    }
    super.addObject("config", config);
    super.addObject("uconfig", uconfig);
    super.addObject("user",user);
    super.addObject("httpInclude", new HttpInclude(request, response));
    String query_url = "";
    if ((request.getQueryString() != null) &&
      (!request.getQueryString().equals(""))) {
      query_url = "?" + request.getQueryString();
    }
    super.addObject("current_url", request.getRequestURI() + query_url);
    boolean second_domain_view = false;
    String serverName = request.getServerName().toLowerCase();

    if ((serverName.indexOf("www.") < 0) && (serverName.indexOf(".") >= 0) &&
      //(serverName.indexOf("localhost") < 0) && !serverName.startsWith("1") &&
      (serverName.indexOf(".") != serverName.lastIndexOf(".")) &&
      (config.getSecondDomainOpen())) {
      String secondDomain = serverName.substring(0, serverName.indexOf("."));
      second_domain_view = true;
      super.addObject("secondDomain", secondDomain);
    }
    super.addObject("second_domain_view", Boolean.valueOf(second_domain_view));
  }
}
