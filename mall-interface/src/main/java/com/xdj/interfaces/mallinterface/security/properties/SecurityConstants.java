package com.xdj.interfaces.mallinterface.security.properties;

/**
 * @author Administrator
 */
public interface SecurityConstants {

    /**
     * 默认的处理验证码的url前缀
     */
    String DEFAULT_VALIDATE_CODE_URL_PREFIX = "/code";

    /**
     * 登录成功处理
     */
    String DEFAULT_SUCCESS_URL="/success.htm";

    /**
     * 当请求需要身份验证时跳转URL
     */
    String DEFAULT_LOGIN_URL = "/user/login.htm";

    String DEFAULT_SIGN_IN_PROCESSING_URL="/shopping_login.htm";

    /**
     * 默认的用户名密码登录请求处理url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/shopping_login.htm";



    /**
     * 默认的忘记密码页面
     */
    String DEFAULT_FORGOT_PASSWORD_URL = "/forgotPassword.html";
    /**
     * 默认的忘记密码短信请求
     */
    String DEFAULT_FORGOT_PASSWORD_SMS_URL = "/business/sendText";
    /**
     * 默认的忘记密码请求url
     */
    String DEFAULT_MODIFY_PASSWORD_URL = "/list/modifyPassword";



    /**
     * session失效默认的跳转地址
     */
    String DEFAULT_SESSION_INVALID_URL = "/user/login.htm";


}
