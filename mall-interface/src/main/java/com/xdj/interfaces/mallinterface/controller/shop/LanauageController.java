package com.xdj.interfaces.mallinterface.controller.shop;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Locale;

/**
 * @author Administrator
 */


@RestController
public class LanauageController {
    private Logger log =LoggerFactory.getLogger("language");

    @RequestMapping("/language")
    public final void changeSessionLanauage(HttpServletRequest request, HttpServletResponse response, String lang) throws IOException {
        if(!StringUtils.isNotBlank(lang)){
           lang="zh";
        }
        if("zh".equals(lang)){
            //代码中即可通过以下方法进行语言设置
            request.getSession().setAttribute("LOCALE_SESSION_ATTRIBUTE_NAME",new Locale("zh","CN"));
        }else if("en".equals(lang)){
            //代码中即可通过以下方法进行语言设置
            request.getSession().setAttribute("LOCALE_SESSION_ATTRIBUTE_NAME",new Locale("en","US"));
        }else if("fr".equals(lang)){
            request.getSession().setAttribute("LOCALE_SESSION_ATTRIBUTE_NAME",new Locale("fr","FR"));
        }
        response.sendRedirect("/index.htm");
    }
}
