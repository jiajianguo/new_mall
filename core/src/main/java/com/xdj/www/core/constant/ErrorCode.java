package com.xdj.www.core.constant;


/**
 *
 * @author hui.peng
 *
 * 2017年9月12日
 *
 */
public enum ErrorCode {
	SUCCESS("200", "success"),
//	SUCCESS("1", "操作成功"),
	EEROR_INVALID_PARAM("ERROR_CAC0", "参数值不完整!"),//全局ERROR，需要重新设置message
	ERROR_EXCEPTION("ERROR_CAC1", "服务器内部错误!"),//全局ERROR, 有异常Exception被抛出时
	ERROR_ARGS_EXCEPTION("ERROR_CAC2", "传的参数不合法!"),
	ERROR_OBJECT_EXIST("ERROR_CAC2", "操作对象已存在!"),
	ERROR_OBJECT_NOT_EXIST("ERROR_CAC2", "操作对象不存在!"),
	ERROR_OBJECT_HAS_FOLLOW_RELATION("ERROR_CAC3", "该MT4账号存在跟随关系!"),
	ERROR_OBJECT_IS_EXIST("ERROR_CAC2", "操作对象已存在!"),
	ERROR_UNKNOW("ERROR_UNKNOW", "未知内部错误!"),
	ERROR_USER_LOGIN_USER_NOT_EXISTS("ERROR_USER_LOGIN01", "账号不存在!"),
	ERROR_USER_LOGIN("ERROR_USER_LOGIN01", "账号或密码不正确!"),
	ERROR_USER_LOGIN_RIGHTS("101", "无权限访问!"),
	ERROR_USER_NOT_LOGIN("ERROR_USER_LOGIN02", "用户未登陆!"),
	ERROR_USER_CODE_OVERTIME("ERROR_USER_CODE_OVERTIME01","验证码超时!"),
	ERROR_USER_CODE_ERROR("ERROR_USER_CODE_ERROR01","验证码错误!"),
	ERROR__NULL("ERROR__ERROR01","验证码为空!"),
	ERROR_VERIFY_CODE_FALSE("ERROR_VERIFY_CODE_ERROR02","验证码错误!"),
	ERROR_MT4_NOT_SIGNAL("ERROR_MAC0", "该MT4账号不是信号,关注失败!"),
	ERROR_MT4_NOT_FOLLOW("ERROR_MAC3", "该MT4账号不是跟随MT4,关注失败!"),
	ERROR_MT4_SUBSCRIBED("ERROR_MAC1", "您已经关注了该信号!"),
	ERROR_MT4_UNSUBSCRIBED("ERROR_MAC2", "您还没关注该信号!"),
	ERROR_USER_DOMESTICATING_MT4("ERROR_USER_DOMESTICATING_MT41","该用户没有MT4账号!"),
	SUCCESS_UPLOAD("SUCCESS_UPLOAD","上传成功!"),
	ERROR_UPLOAD("ERROR_UPLOAD","上传失败!"),
	ERROR_PAY_REQUEST_EXCEPTION("ERROR_PAY001","支付请求异常！"),
	ERROR_NOTIFY_REQUEST_EXCEPTION("ERROR_PAY003","支付通知异常！"),
	ERROR_USER_CODE_NO_TIMEOUT("E1157", "短信发送过于频繁!"),
	ERROR_USER_EMAIL("ERROR_USER_EMAIL01"
			,"用户邮箱不能为空"),
	ERROR_USER_OLDPASSWORD("ERROR_USER_PASSWORD01","原密码不能为空"),
	ERROR_USER_NEWPASSWORD("ERROR_USER_PASSWORD02","新密码不能为空"),
	ERROR_UNKNOWN("0","未知错误"),
	ERROR_LOGIN_TIMEOUT("1","登录超时"),
	ERROR_UNAUTHORIZED_IP("102","请求来自未经授权的IP地址"),
	ERROR_BTCSING_FAIL("ERROR_BTCSING_FAIL","BTC签名出现错误!"),
	ERROR_LOGIN_FAIL("300","未登录"),
	ERROR_LOGIN_ADDRESS_EX("E0115","登录地址异常"),
	FALSE_DYNAMICASSWORD("E2204","谷歌验证码错误"),
	FALSE_DYNAMICASSWORD_NULL("E1006","动态验证码不能为空"),
	FALSE_DIFFERENT_SENDSMSPHONE_AND_FILLPHONE("E4915","获取验证码的手机与填写的手机不一致!"),
	FALSE_DIFFERENT_SENDVCODEEMAIL_AND_FILLEMAIL("E4916","获取验证码的邮箱与填写的邮箱不一致!"),
	USER_FIRST_AUTH_IDCARD_EXIST_ERROR("E24008","身份证已经在本网站实名使用"),
	ERROR_HAS_DO_FIRST_AUTH("E24009","您已经完成初级实名认证"),
	ACCOUNT_HAS_BINDING_EMAIL("E1011","该账号已经被绑定"),

	ERROR_LOST_PARAMETERS("105","请求参数缺失（必传参数为空）"),
	ERROR_LOST_BUSINESSRESOURCEID("106","未选中交易广告"),

    OK("ok", "success"),
    SystemBusy("BS-0000", "系统繁忙"),
//    UN_KNOWN_ERROR("BS-000", "未知错误"),
    NOT_FOUND("BS-0001", "查询没有结果"),
    PRECONDITION_FAILED("BS-0002", "缺少必要参数"),
    BAD_REQUEST("BS-0003", "请求参数不合法"),
    JSON_PARSE_ERROR("BS-0004", "JSON解析失败"),
    PARAMS_CONFLICT("BS-0005", "唯一标识冲突"),
    DATA_ACCESS("BS-0006", "操作失败"),
    NO_DATE("BS-0007", "没有找到数据"),
    USER_PWD_FAILED("BS-0008", "用户名或密码错误"),
    SAVE_FAILED("BS-0009", "保存关系失败"),
    SERVER_FAILED("BS-0010", "服务器异常"),

    REPEAT_SUBMIT("BS-1010", "重复提交"),
    SQL_EXCEPTION("BS-1020", "SQL异常"),
    JDBC_EXCEPTION("BS-1030", "JDBC异常"),
    UPLOAD_IMG_EXCEPTION("BS-1040", "图片上传失败"),
    NOT_PERMISSION("BS-1050", "没有操作权限"),
    SYS_NOT_PERMISSION("BS-1060", "系统管理员无法做此操作"),

    USER_NOT_FOUND("BS-2000", "查询用户信息失败"),
    USER_OLDPASSWORD_ERROR("BS-2010", "原密码错误"),
    USER_UPD_MOBILE("BS-2020", "修改用户手机失败"),
	USER_MT4_NAME_EXISTS("BS-2030", "MT4名称已存在"),
	MT4_EXISTS("BS-2031", "该MT4已存在"),
	USER_PASSWD_NOT_CONSISTENT("BS-2040", "两次输入的密码不一致！"),
	NAME_ILLEGAL("BS-2050","账号包含非法字符"),
	USER_EXISTS("BS-2032", "用户已存在或手机号已注册"),
	BE_COMPLAIN("BS_2033","订单处于投诉中"),
	BE_CANCEL("BS_2037","订单已取消"),
	BE_COMPLETE("BS_2037","订单已完成"),
	BE_ABNORMAL("BS_2038","订单存在异常"),
	BE_PUTCURRENCY("BS_2036","订单已放币，无法投诉以及取消"),
	BS_MORE_ONE("BS_2034","已经存在该币种的广告"),
	INVALID_URL("LOGIN-0001", "无效的域名"),
	ACCOUNT_TOO_LONG("BS-2034","账号长度过长"),
	ACCOUNT_NOT_EXISTS("BS-2035","手机号码未注册"),
	GEETEST_VAL_FALSE("E0101","极验证校验失败"),
	ERROR_ORIGINASSETPASSWORD_INCORRECT("E1711","原始的资金密码不正确"),
	ERROR_PASSWORD_BIGGER_5_TIMES("E0113","密码错误次数到达5次,账号将于次日解冻"),
	ERROR_PASSWORD_BIGGER_3_TIMES("E0112","密码错误次数超过3次,需进行极验证操作"),
	ASSETPASSWORD_THE_SAME_ERROR("E1713","新资金密码不能与原资金密码相同"),
	ORIGINPASSWORD_THE_SAME_ERROR("E1604","原登录密码错误"),
	NEWPASSWORD_THE_SAME_ERROR("E1605","新登录密码格式错误"),
	PASSWORD_THE_SAME_ERROR("E1609","新登录密码不能与原登录密码相同"),
	TELEHONE_NOT_REGISTER_ERROR("E0809","该手机号暂未注册"),
	CANCELMORETREE("403","当日取消订单已超限制，不可下单!"),
	PROCESSING_ORDER_NUMBER("E1111","正在处理中的订单超过限定值"),

	SMS_CODE_ERROR("108", "短信验证码校验失败"),
	TELEPHONE_PARAMS_ERROR("E0804", "手机参数错误"),
	TELEPHONE_HSA_REGIST_ERROR("E0805", "手机已经在本网站注册"),

	SMS_CODE_TIMEOUT("109", "短信验证码超时"),

	EMAIL_CODE_ERROR("110", "邮箱验证码校验失败"),
	EMAIL_CODE_TIMEOUT("111", "邮箱验证码超时"),
	EMAIL_SEND_FREQUENCE_TIMEOUT("113", "邮箱验证码发送过于频繁"),
	EMAIL_HAS_BINDING_TIMEOUT("E0907", "短信验证码发送频发"),
	REPEAD_ADD_ERROR("NO_009", "请勿重复添加"),
	CANT_MORE_500_AUTHENTICATION_FIRST("NO-005","初级用户交易不能大于500"),
	NO_IDENTITY_AUTHENTICATION_FIRST("NO-001","没有进行初级实名认证"),
	NO_IDENTITY_AUTHENTICATION_SECOND("NO-002","没有进行中级实名认证"),
	HAS_IDENTITY_AUTHENTICATION_SECOND("NO-003","已经进行中级实名认证"),
	DOING_IDENTITY_AUTHENTICATION_SECOND("NO-004","正在进行中级实名认证,请勿重复提交"),
	NO_IDENTITY_AUTHENTICATION_THREE("NO-0023","没有进行高级实名认证"),
	HAS_VELIDATE_THIRDAUTHENTICATION("NO-0028","用户已经进行并通过高级认证"),
	ERROR_FACEID_SUCCESS("200","用户成功通过视频认证"),
	ERROR_FACEID_PASS_LIVING_NOT_THE_SAME("NO-0032","上传视频资料与参考对比不是同一个人"),
	ERROR_FACEID_DATA_SOURCE_ERROR("NO-0033","照片出现错误"),
	ERROR_FACEID_NO_FACE_FOUND_IDCARD("NO-0034","视频认证人脸缺失或者有多个"),
	ERROR_FACEID_FAIL_LIVING_FACE_ATTACK("NO-0035","参数有误"),
	ERROR_FACEID_CHANGE_FACE_ATTACK("NO-0036","系统内部异常,请尽快联系管理员"),
	ERROR_FACEID_NO_FACE_FOUND("NO-0037","用户手机进行视频认证权限不够"),
	ERROR_FACEID_FACE_QUALITY_TOO_LOW("NO-0038","正在进行验证"),
	ERROR_FACEID_INVALID_VIDEO_DURATION("NO-0039","活体验证视频中长度不符合要求（2s～20s）"),
	ERROR_FACEID_VIDEO_TOO_LARGE("NO-0040","活体验证视频过大"),
	ERROR_FACEID_SR_ERROR("NO-0041","活体验证视频中，用户读数语音不符合要求"),
	ERROR_FACEID_NOT_SYNCHRONIZED("NO-0042","活体验证视频中，用户读数唇语不符合要求"),
	ERROR_FACEID_NO_AUDIO("NO-0043","活体验证视频无声音"),
	ERROR_FACEID_VIDEO_FORMAT_UNSUPPORTED("NO-0044","活体验证视频格式无法识别"),
	ERROR_FACEID_LIP_VOICE_NOT_SYNC("NO-0045","活体验证视频中语音唇语不同步"),
	ERROR_FACEID_VIDEO_MANY_TIMES("NO-0046","活体验证视频上传超过阈值"),
	ERROR_FACEID_VIDEO_INTERNAL_ERROR("NO-0047","验证内部错误"),
	NO_TRUST("NO-0024","不受信任的用户不能交易"),
	NO_SECOND("NO-0026","中级用户不能交易"),
	NO_THREE("NO-0027","高级用户不能交易"),
	NO_FIRST("NO-0025","初级用户不能交易"),
	NO_TRAN_FIVE_TIMES("NO-003","场外交易没有达到5次"),
	NO_TRAN_ONE_TIMES("NO-0031","场外交易没有达到1次"),
	INSUFFICIENT_BALANCE("NO_004","余额不足"),
	NO_BIND_BANK("NO_005","没有绑定银行卡"),
	NO_LOGIN("NO_006","未登录，请登录"),
	RESOURCE_EXPIRED("NO_007","广告已过期"),
	CAPITAL_PASSWORD_ERROR("NO_008","资金密码错误!"),
	INSUFFICIENT_BALANCE_ERROR("NO_009","可用余额不足!"),
	ORDER_LIMIT("NO-010","订单超过限定值"),
	LOWEST_LIMIT("NO-018","订单低于最低限额"),
	STOCK_LT_ZERO("NO-018","库存设置有误"),
	LOWEST_PRICE_LIMIT("NO-028","最低单价限制，无法进行交易！"),
	LACK_OF_STOCK("NO-011","库存不足"),
	NO_NEGATIVE("NO-012","手续费不能为负数"),
	NO_24_HOURS("NO-013","修改资金密码未满24小时，无法提币"),
	NO_TELEPHONE("NO-014","手机号码未认证，无法发布交易广告和下单"),
	MAX_AMOUNT_NEGATIVE("NO-015","交易限额必须大于0"),
	RESOURCE_AMOUNT_NOTNULL("NO-0100","交易限额为必填参数"),
	MAXAMOUNT_LESSTHAN_MINAMOUNT("NO-016","最大交易额不能小于最小交易额"),
	EXCEEDING_THE_LIMIT_500("NO-017","初级用户场外交易不能超过500人民币"),
	EXCEEDING_THE_LIMIT_100000("NO-018","中级用户场外交易不能超过10W人民币"),
	EXCEEDING_THE_LIMIT_1000000("NO-019","高级用户场外交易不能超过100W人民币"),
	FEE_COMARETO_MINIFEE_BIGGER_ZERO_ERROR("NO-013","手续费不能低于最低手续费!"),
	NO_CANCEL("NO-014","无法取消订单"),
	REPETITION_MENTIONCOINAPPLY("NO_15","已存在改币种提币申请"),
	LOTTERY_DEPLETED("NO_16","抽奖机会已用完!"),
	ORDER_STATU_CHANGE("NO_19","订单状态已修改，请刷新。"),
	NO_LOTTERY_COUNT("NO_17","暂无抽奖机会"),
	INVALID_ADDRESS("NO-023","无效地址"),
	NO_PRICATE_KEY("NO_18","没有私钥"),
	LOWEST_SMALLT_AMOUNT("NO-019","订单低于最低限额"),
	NO_ORDERS("NO-020","存在未处理订单，请先处理。"),
	CAN_NOT_MENTION("NO-021","币种不支持提币。"),
	INSUFFICIENT_BALANCE_IS("NO-022","请检查余额是否充足!"),
	ERROR_REQUEST("500","非法请求");

	private String value;

    protected String message;

    private ErrorCode(String value, String message) {
        this.setValue(value);
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String appendMessage(String message) {
        return this.getMessage() + ":" + message;
    }

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

