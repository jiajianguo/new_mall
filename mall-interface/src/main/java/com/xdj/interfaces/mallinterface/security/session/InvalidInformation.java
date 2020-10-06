package com.xdj.interfaces.mallinterface.security.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.session.InvalidSessionStrategy;

/**
 * @author Administrator
 */
public class InvalidInformation implements InvalidSessionStrategy {

	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("session失效,请重新登录");
	}

}
