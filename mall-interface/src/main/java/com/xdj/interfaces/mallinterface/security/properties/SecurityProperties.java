package com.xdj.interfaces.mallinterface.security.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author Administrator
 */
@ConfigurationProperties(prefix = "shopping.security")
public class SecurityProperties {

	private BrowserProperties browser = new BrowserProperties();

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

}
