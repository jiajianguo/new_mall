package com.xdj.interfaces.mallinterface.security.session;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @author Administrator
 */
public class ExpiredInformation implements SessionInformationExpiredStrategy{

	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		HttpServletResponse response = event.getResponse();
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write("账号已经在别的地方登录,如非本人操作请及时修改密码!");
	}

}
