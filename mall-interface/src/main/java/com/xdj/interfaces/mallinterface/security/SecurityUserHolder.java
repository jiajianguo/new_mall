package com.xdj.interfaces.mallinterface.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import com.xdj.interfaces.mallinterface.util.CommUtil;
import com.xdj.www.entity.ShoppingUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author Administrator
 */
public class SecurityUserHolder {

    public static Logger log = LoggerFactory.getLogger("SecurityUserHolder");

    public static ShoppingUser getCurrentUser() {
        if (SecurityContextHolder.getContext().getAuthentication() != null) {
            if ((SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof ShoppingUser)) {
                return (ShoppingUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            }
        }
        ShoppingUser user = null;
        if (RequestContextHolder.getRequestAttributes() != null) {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            HttpSession session = request.getSession(false);
            if (session != null) {
                user = session.getAttribute("user") != null ? (ShoppingUser) session.getAttribute("user") : null;
            }
            Cookie[] cookies = request.getCookies();
            String id = "";
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("shopping_user_session")) {
                        id = CommUtil.null2String(cookie.getValue());
                    }
                }
            }
            if (id.equals("")) {
                user = null;
            }
        }
        return user;
    }
}

