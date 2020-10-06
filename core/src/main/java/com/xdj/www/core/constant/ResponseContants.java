package com.xdj.www.core.constant;

/**
 *
 *
 */
public interface ResponseContants {

    String RESPONSE_SUCCESS_CODE = "200";      //成功状态码
    String RESPONSE_SUCCESS_MSG  = "success";  //成功消息

    String RESPONSE_FAILED_CODE  = "500";      //服务器异常状态码
    String RESPONSE_FAILED_MSG   = "服务器异常信息";    //服务器异常信息

    String RESPONSE_LOGIN_ERROR_CODE = "401";  //用户名或密码错误状态码
    String RESPONSE_LOGIN_ERROR_MSG = "用户名或密码信息";  //用户名或密码信息

    String RESPONSE_FORBIDDEN_CODE = "403";    //没有权限状态码
    String RESPONSE_FORBIDDEN_MSG = "没有权限信息"; //没有权限信息

    String RESPONSE_PARAM_ERROR_CODE = "400";  //参数错误状态码
    String RESPONSE_PARAM_ERROR_MSG  = "参数错误";  //参数错误信息

    String RESPONSE_NO_LOGIN_CODE = "300";  //参数错误状态码
    String RESPONSE_NO_LOGIN_MSG  = "未登录";  //参数错误信息

    String RESPONSE_NO_RESULT_CODE = "107";  //无返回结果
    String RESPONSE_NO_RESULT_MSG  = "无返回结果";  //无返回结果

    /**
	 * 一级认证失败
	 */
    public static final String USER_FIRST_AUTH_ERROR_CODE = "E24001";  //一级认证失败
    public static final String USER_FIRST_AUTH_ERROR_MSG  = "初级认证失败";  //一级认证失败

    public static final String USER_FIRST_AUTH_IDCARD_EXIST_ERROR_CODE= "E24008";  //一级认证失败
    public static final String USER_FIRST_AUTH_IDCARD_EXIST_ERROR_MSG  = "身份证已在本网站使用";  //一级认证失败
    /**
     * 一级认证用户姓名长度过长
     */
    public static final String USER_FIRST_AUTH_NAME_LENGTH_OUTOFRANGE_CODE = "E24009";  //一级认证用户姓名长度过长
    public static final String USER_FIRST_AUTH_NAME_LENGTH_OUTOFRANGE_MSG  = "fail first_ authentication";  //一级认证用户姓名长度过长
    /**
     * 一级认证用户身份证编号不为18位
     */
    public static final String USER_FIRST_AUTH_CARDNO_LENGTH_FALSE_CODE = "E24009";  //一级认证用户身份证长度不为18位
    public static final String USER_FIRST_AUTH_CARDNO_LENGTH_FALSE_MSG  = "fail first_ authentication";  //一级认证用户身份证长度不为18位
	/**
	 * 一级认证失败用户不存在
	 */
    public static final String USER_NULL_AUTH_ERROR_CODE = "E24002";  //一级认证失败
    public static final String USER_NULL_AUTH_ERROR_MSG  = "初级实名认证用户存在";  //一级认证失败用户不存在
    /**
     * 二级认证失败有效期过期
     */
    public static final String USER_SECOND_BACKAUTH_ERROR_CODE = "E24004";  //二级认证失败
    public static final  String USER_SECOND_BACKAUTH_ERROR_MSG  = "身份证有效期失效";  //二级认证失败有效期过期
    /**
     * 二级认证失败系统时间对比异常
     */
    public static final String SYSTEM_BACKAUTH_ERROR_CODE = "E24005";  //二级认证失败
    public static final String SYSTEM_BACKAUTH_ERROR_MSG  = "系统时间对比异常";  //系统时间对比异常
    /**
     * 二级认证失败背面照接口返回信息为空
     */
    public static final String USER_SECOND_BACK_NULL_ERROR_CODE = "E24006";  //二级认证失败
    public static final String USER_SECOND_BACK_NULL_ERROR_MSG  = "身份证背面信息无法获取";  //背面照接口返回信息为空
    /**
     * 二级认证失败正面照认证失败
     */
    public static final String USER_SECOND_FACEAUTH_ERROR_CODE = "E24007";  //二级认证失败
    public static final String USER_SECOND_FACEAUTH_ERROR_MSG  = "上传的身份证正面信息有误";  //二级认证正面照失败
    /**
     * 二级认证失败正面照认证失败
     */
    public static final String USER_SECOND_FACE_INFO_ERROR_CODE = "E24009";  //二级认证失败
    public static final String USER_SECOND_FACE_INFO_ERROR_MSG  = "您上传正面身份证非初级实名认证用户信息";  //二级认证正面照失败
    /**
     * 二级认证失败用户为空
     */
    public static final String USER_SECOND_NULL_AUTH_ERROR_CODE = "E24008";  //二级认证失败
    public static final String USER_SECOND_NULL_AUTH_ERROR_MSG  = "用户未进行初级实名认证";  //二级认证失败用户为空
    /**
     * 传入参数有误
     */
    public static final String AUTH_PARAMETERS_ERROR_CODE = "E24105";  //传入参数有误
    public static final String AUTH_PARAMETERS_ERROR_MSG  = "传入参数错误";  //传入参数有误
}
