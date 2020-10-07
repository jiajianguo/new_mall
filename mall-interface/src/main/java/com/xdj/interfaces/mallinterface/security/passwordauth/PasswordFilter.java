package com.xdj.interfaces.mallinterface.security.passwordauth;

import com.xdj.interfaces.mallinterface.cache.RequestMsgCache;
import com.xdj.interfaces.mallinterface.util.CommUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;



/**
 * @author Administrator
 */
public class PasswordFilter extends OncePerRequestFilter {
	private final Logger log = LoggerFactory.getLogger("pwdFilter");
	private final static List<String> passUrl= new ArrayList<>();

	static {
		passUrl.add("login.htm");
		passUrl.add("register.htm");
		passUrl.add("verify");
		passUrl.add("logout");
		passUrl.add("register_finish.htm");
		passUrl.add("invoke.htm");
	}


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		StringBuffer url = request.getRequestURL();
		if(url.indexOf(".htm")> -1){
			boolean flag= ifPassUrl(url.toString()) ;
			if(flag){
				log.info(url.toString());
				String reqest_sesion_id = "";
				Cookie[] cookies = request.getCookies();
				if (cookies != null) {
					for (Cookie cookie : cookies) {
						if (cookie.getName().equals("cart_session_id")) {
							reqest_sesion_id = CommUtil.null2String(cookie.getValue());
							break;
						}
					}
				}
				if (reqest_sesion_id.equals("")) {
					reqest_sesion_id = UUID.randomUUID().toString();
					Cookie cookie = new Cookie("reqest_sesion_id", reqest_sesion_id);
					cookie.setDomain(CommUtil.generic_domain(request));
					response.addCookie(cookie);
				}
				if(request.getQueryString() != null){
					RequestMsgCache.urlSave.put(reqest_sesion_id,url+"?"+request.getQueryString());
				}else{
					RequestMsgCache.urlSave.put(reqest_sesion_id,url);
				}
			}
		}
		WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(request.getSession().getServletContext());
		String email = request.getParameter("email");
		if (StringUtils.isNotBlank(email)) {
			try {
				log.info("------登录信息------{}",email);
				String password = request.getParameter("password");
				/*ShoppingUserMapper userDAO = webApplicationContext.getBean(ShoppingUserMapper.class);
				ShoppingUser user = userDAO.findByEmail(email);*/
				Map paramter = new HashMap();
				//paramter.put("username", user.getUsername());
				paramter.put("username", email);
				paramter.put("password", password);
				filterChain.doFilter(new ParameterRequestWrapper(request, paramter), response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			filterChain.doFilter(request, response);
		}
	}

	public static final  boolean ifPassUrl(String url){
		boolean flag= true;
		for(String s: passUrl ){
			if(url.indexOf(s) >-1){
				return false;
			}
		}
		return flag;
	}
}
