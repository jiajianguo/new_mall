package com.xdj.interfaces.mallinterface.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * <pre>
 *  自定义LocaleResolver类
 * </pre>
 *
 * @author nicky
 * <pre>
 * 修改记录
 *    修改后版本:     修改人：  修改日期: 2019年11月23日  修改内容:
 * </pre>
 */

public class CustomLocalResolver implements LocaleResolver {

    Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Nullable
    private Locale defaultLocale;

    public void setDefaultLocale(@Nullable Locale defaultLocale) {
        this.defaultLocale = defaultLocale;
    }

    @Nullable
    public Locale getDefaultLocale() {
        return this.defaultLocale;
    }

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        Locale defaultLocale = this.getDefaultLocale();
        if(request.getSession().getAttribute("LOCALE_SESSION_ATTRIBUTE_NAME") != null){
            Locale   locale =(Locale) request.getSession().getAttribute("LOCALE_SESSION_ATTRIBUTE_NAME");
            this.setDefaultLocale(locale);
            return locale;
        }else if(defaultLocale != null && request.getHeader("Accept-Language") == null) {
            return defaultLocale;
        } else {
            Locale requestLocale = request.getLocale();
            String localeFlag = request.getParameter("lang");
            if (!StringUtils.isEmpty(localeFlag)) {
                String[] split = localeFlag.split("_");
                requestLocale = new Locale(split[0], split[1]);
            }
            this.setDefaultLocale(requestLocale);
            return requestLocale;
        }
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
