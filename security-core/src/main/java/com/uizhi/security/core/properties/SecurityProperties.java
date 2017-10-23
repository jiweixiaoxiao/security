/**
 * 
 */
package com.uizhi.security.core.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 读取系统配置文件的封装类
 *
 */
@ConfigurationProperties(prefix = "uizhi.security")
public class SecurityProperties {
	
	private BrowserProperties browser = new BrowserProperties();

	public BrowserProperties getBrowser() {
		return browser;
	}

	public void setBrowser(BrowserProperties browser) {
		this.browser = browser;
	}

}
