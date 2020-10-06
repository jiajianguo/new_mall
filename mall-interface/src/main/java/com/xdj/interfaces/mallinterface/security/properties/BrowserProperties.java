package com.xdj.interfaces.mallinterface.security.properties;

/**
 * @author Administrator
 */
public class BrowserProperties {

	private String loginPage = "/user/login.htm";//密码登录页面

	private int rememberMeSec = 3600 * 24 * 7 * 2;//记住我功能的时间

	private String registerPage = "/shop/l";//注册页

	private String registerUrl = "/";//注册请求url

	public String getRegisterUrl() {
		return registerUrl;
	}

	public void setRegisterUrl(String registerUrl) {
		this.registerUrl = registerUrl;
	}

	public String getRegisterPage() {
		return registerPage;
	}

	public void setRegisterPage(String registerPage) {
		this.registerPage = registerPage;
	}

	private LoginType loginType = LoginType.JSON;//登录类型

	public LoginType getLoginType() {
		return loginType;
	}

	public void setLoginType(LoginType loginType) {
		this.loginType = loginType;
	}

	public int getRememberMeSec() {
		return rememberMeSec;
	}

	public void setRememberMeSec(int rememberMeSec) {
		this.rememberMeSec = rememberMeSec;
	}

	public String getLoginPage() {
		return loginPage;
	}

	public void setLoginPage(String loginPage) {
		this.loginPage = loginPage;
	}


}
