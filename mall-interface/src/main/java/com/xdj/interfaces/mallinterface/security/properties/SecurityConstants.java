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
     * 当请求需要身份验证时跳转URL
     */
    String DEFAULT_UNAUTHENTICATION_URL = "/user/login.htm";

    String DEFAULT_SIGN_IN_PROCESSING_URL="/shopping_login.htm";

    /**
     * 默认的用户名密码登录请求处理url
     */
    //String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/authentication/form";
    String DEFAULT_SIGN_IN_PROCESSING_URL_FORM = "/shopping_login.htm";

    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE = "/authentication/mobile";

    /**
     * 默认的手机验证码登录请求处理url
     */
    String DEFAULT_SIGN_IN_URL_MOBILE_PAGE = "/shopping_login.htm";

    /**
     * 默认的用户注册请求处理url
     */
    String DEFAULT_REGISTER_URL = "/authentication/register";

    /**
     * 默认的注册页
     */
    String DEFAULT_SIGNUP_URL = "/register";
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
     * 验证图片验证码时，http请求中默认的携带图片验证码信息的参数的名称
     */
  //  String DEFAULT_PARAMETER_NAME_CODE_IMAGE = "imageCode";

    /**
     * 验证短信验证码时，http请求中默认的携带短信验证码信息的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_CODE_SMS = "smsCode";
    /**
     * 发送短信验证码 或 验证短信验证码时，传递手机号的参数的名称
     */
    String DEFAULT_PARAMETER_NAME_MOBILE = "mobile";

    /**
     * session失效默认的跳转地址
     */
    String DEFAULT_SESSION_INVALID_URL = "/user/login.htm";


}
