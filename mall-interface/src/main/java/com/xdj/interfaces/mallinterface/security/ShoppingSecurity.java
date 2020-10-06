package com.xdj.interfaces.mallinterface.security;

import com.xdj.interfaces.mallinterface.security.passwordauth.MyUserInfoTokenServices;
import com.xdj.interfaces.mallinterface.security.passwordauth.PasswordFilter;
import com.xdj.interfaces.mallinterface.security.passwordauth.UserDetailsServiceImpl;
import com.xdj.interfaces.mallinterface.security.properties.SecurityConstants;
import com.xdj.interfaces.mallinterface.security.properties.SecurityProperties;
import com.xdj.interfaces.mallinterface.security.session.ExpiredInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.filter.OAuth2ClientAuthenticationProcessingFilter;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableOAuth2Client;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.filter.CompositeFilter;

import javax.annotation.Resource;
import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author   ...
 *
 *		2019年9月11日 下午3:15:53
 *
 */
@Configuration
@EnableWebSecurity
@EnableOAuth2Client
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class ShoppingSecurity extends WebSecurityConfigurerAdapter {
	@Autowired
	private DataSource dataSource;
	@Autowired
	private SecurityProperties securityProperties;
	@Autowired
	@Qualifier("userDetailsService")
	private UserDetailsServiceImpl userDetailsServiceImpl;
	@Autowired
	FacebookPrincipalExtractor facebookPrincipalExtractor;
	@Autowired
	SuccessHandler successHandler;
	@Resource
	OAuth2ClientContext oauth2ClientContext;

	/**
	 * remeber-me 功能数据库配置
	 *
	 * @author
	 *		aaa on 2019年9月17日
	 */
	@Bean
	public PersistentTokenRepository persistentTokenRepository() {
		JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
		tokenRepository.setDataSource(dataSource);
		//tokenRepository.setCreateTableOnStartup(true);
 		return tokenRepository;
	}
/*
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
	}*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		// return PasswordEncoderFactories.createDelegatingPasswordEncoder();
		return new BCryptPasswordEncoder();
	}

	@Bean
	@ConfigurationProperties("facebook")
	public ClientResources facebook() {
		return new ClientResources("facebook");
	}

/*
	@Bean
	@ConfigurationProperties("google")
	public ClientResources google() {
		return new ClientResources("google");
	}
*/

	@Bean
	public FilterRegistrationBean<OAuth2ClientContextFilter> oauth2ClientFilterRegistration(OAuth2ClientContextFilter filter) {
		FilterRegistrationBean<OAuth2ClientContextFilter> registration = new FilterRegistrationBean<OAuth2ClientContextFilter>();
		registration.setFilter(filter);
		registration.setOrder(-100);
		return registration;
	}

	private Filter ssoFilter() {
		CompositeFilter filter = new CompositeFilter();
		List<Filter> filters = new ArrayList<>();
		filters.add(ssoFilter(facebook(), "/login/facebook", facebookPrincipalExtractor));
		//filters.add(ssoFilter(google(), "/login/google", facebookPrincipalExtractor));
		filter.setFilters(filters);
		return filter;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		PasswordFilter passwordFilter = new PasswordFilter();
		//关闭csrf
		http.csrf().disable();
		//密码登录.校验前密码修改
		http.addFilterBefore(passwordFilter, UsernamePasswordAuthenticationFilter.class)
		//验证码登录配置(短信验证码、图片验证码)
		//.apply(validateCodeSecurityConfig).and()
		//短信登录配置
		//.apply(smsCodeAuthenticationSecurityConfig).and()
		//记住登录状态配置
		//.rememberMe()
			//.tokenRepository(persistentTokenRepository())
			//.tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSec())
		.userDetailsService(userDetailsServiceImpl)
		//请求过滤配置
		.authorizeRequests()
			.antMatchers(
					SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM,//用户密码登录请求url
					SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
					SecurityConstants.DEFAULT_FORGOT_PASSWORD_URL,//忘记密码页面
					SecurityConstants.DEFAULT_MODIFY_PASSWORD_URL,//修改密码请求url
					SecurityConstants.DEFAULT_FORGOT_PASSWORD_SMS_URL,//手机找回密码 短信请求url
					securityProperties.getBrowser().getLoginPage(),//用户密码登录页面
					securityProperties.getBrowser().getRegisterPage(),//注册页
					securityProperties.getBrowser().getRegisterUrl(),//这册请求url
					"/goods.htm",
					"/integral.htm",
					"/integral.htm",
					"/register*.htm",
					"/verify*.htm",
					"/goods_evaluation.htm",
					"/goods_order.htm",
					"/goods_consult.htm",
					"/goods_detail.htm",
					"/shopping_logout.htm",
					"/index.htm",
					"/wap/index.htm",
					"/search.htm",
					"/language",
					"/",
					"/newIndex.htm",
					"/*/index.htm",
					"/login/**",
					"/shopping_login.htm/*",
					"/static/**","/upload/**","/login*","/**/*.js","/**/*.jpg","/**/*.png","/**/*.css")
					//以上请求所有人都可以访问
					.permitAll()
					//其他请求，认证后才可访问
					.anyRequest().authenticated()
			.and()
				//.addFilterBefore(ssoFilter(), BasicAuthenticationFilter.class)
		//登录配置
			.formLogin()
			.loginPage(SecurityConstants.DEFAULT_LOGIN_URL)
			.loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL)
			.successForwardUrl(SecurityConstants.DEFAULT_SUCCESS_URL)
			.failureForwardUrl("/login_error.htm")
			.and()
		//登出配置
		.logout().logoutSuccessUrl("/login/out.htm")
			.and()
		//session配置
		.sessionManagement()
			//session失效后跳转页面
			.invalidSessionUrl(securityProperties.getBrowser().getLoginPage())
			//.invalidSessionStrategy(new invalidInformation())
			//最大session数量
			.maximumSessions(1)
			//优先当前登陆（后登陆不会覆盖以前登陆）
			.maxSessionsPreventsLogin(false)
			.expiredSessionStrategy(new ExpiredInformation())
			.and();
	}



	private Filter ssoFilter(ClientResources client, String path, AbstractPrincipalExtractor principalExtractor) {
		OAuth2ClientAuthenticationProcessingFilter filter = new OAuth2ClientAuthenticationProcessingFilter(
				path);
		filter.setAuthenticationSuccessHandler(successHandler);
		OAuth2RestTemplate template = new OAuth2RestTemplate(client.getClient(), oauth2ClientContext);
		filter.setRestTemplate(template);
		UserInfoTokenServices tokenServices = new MyUserInfoTokenServices(client.getResource().getUserInfoUri(), client.getClient().getClientId(), principalExtractor);
		tokenServices.setRestTemplate(template);
		filter.setTokenServices(tokenServices);
		return filter;
	}

}
