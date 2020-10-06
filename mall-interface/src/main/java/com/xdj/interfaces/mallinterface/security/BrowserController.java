package com.xdj.interfaces.mallinterface.security;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xdj.interfaces.mallinterface.security.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 *
 * 自定义登录页，如果在properties中配置有则使用配置的登录页(bopay.security.browser.loginPage)，没有则默认登录页
 *
 * @author kws on 2019年9月11日 下午3:03:33
 *
 */
@Controller
public class BrowserController {

	private RequestCache requestCache = new HttpSessionRequestCache();

	@Autowired
	private SecurityProperties securityProperties;

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@RequestMapping("/authentication/login")
	public void requireAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());
	}
}
