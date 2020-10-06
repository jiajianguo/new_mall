package com.xdj.interfaces.mallinterface.util;

import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.QuerySendDetailsResponse;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class SMSUtils {
	// 日志
	private static Logger logger = LoggerFactory.getLogger(SMSUtils.class);

	// 产品名称:云通信短信API产品,开发者无需替换
	static final String product = "Dysmsapi";
	// 产品域名,开发者无需替换
	static final String domain = "dysmsapi.aliyuncs.com";
	static final String pwd="pwd=2437e67b20d7b5b7e696c06535f9efcc&";
	static final String sms_uri="http://api.sms.cn/sms/?ac=send&uid=queensmakings&";
	static final String template="template=518001&";

	/**
	 * 发送短信接口
	 *
	 * @param phone 手机号码
	 * @param message 转json后的信息
	 * @param emplateCode   模板编号
	 * @return
	 * @throws ClientException
	 */
	@SuppressWarnings("deprecation")
	public static Map<String,Object>  sendSms(String phone, String message, String emplateCode,String accessKeyId ,String accessKeySecret,String signName){

		// 可自助调整超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
		System.setProperty("sun.net.client.defaultReadTimeout", "10000");

		 Map<String,Object> map =new HashMap<String,Object>();
		// 初始化acsClient,暂不支持region化
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			logger.error("短信发送客户端异常",e1);
		}
		IAcsClient acsClient = new DefaultAcsClient(profile);

		// 组装请求对象-具体描述见控制台-文档部分内容
		SendSmsRequest request = new SendSmsRequest();
		// 必填:待发送手机号
		request.setPhoneNumbers(phone);
		// 必填:短信签名-可在短信控制台中找到
		request.setSignName(signName);
		// 必填:短信模板-可在短信控制台中找到
		request.setTemplateCode(emplateCode);

		// 可选:模板中的变量替换JSON串,如模板内容为"亲爱的${name},您的验证码为${code}"时,此处的值为
		request.setTemplateParam(message);

		// 选填-上行短信扩展码(无特殊需求用户请忽略此字段)
//		 request.setSmsUpExtendCode(smsUpExtendCode);

		// 可选:outId为提供给业务方扩展字段,最终在短信回执消息中将此值带回给调用者
		request.setOutId("yourOutId");

		// hint 此处可能会抛出异常，注意catch
		SendSmsResponse sendSmsResponse = null;

		try {
			sendSmsResponse = acsClient.getAcsResponse(request);
			map.put("message",sendSmsResponse.getMessage());
			map.put("bizId", sendSmsResponse.getBizId());
			map.put("code", sendSmsResponse.getCode());

		} catch (Exception e) {
			logger.error("发送短信异常:", e);
			logger.error("手机号码为:" + phone);
		}
		return map;
	}

	/**
	 * 短信发送记录查询接口
	 *
	 * @param bizId
	 *            流水号
	 * @param phone
	 *            手机号码
	 * @return
	 * @throws ClientException
	 */
	@SuppressWarnings("deprecation")
	public static Map<String,Object> querySendDetails(String bizId, String phone, String accessKeyId,
			String accessKeySecret) {
		Map<String,Object> map =new HashMap<String,Object>();
		// 可自助调整超时时间
		System.setProperty("sun.net.client.defaultConnectTimeout", "60000");
		System.setProperty("sun.net.client.defaultReadTimeout", "60000");

		// 初始化acsClient,暂不支持region化
		IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
		try {
			DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);
		} catch (ClientException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		IAcsClient acsClient = new DefaultAcsClient(profile);
		// 组装请求对象
		QuerySendDetailsRequest request = new QuerySendDetailsRequest();
		// 必填-号码
		request.setPhoneNumber(phone);
		// 可选-流水号
		request.setBizId(bizId);
		// 必填-发送日期 支持30天内记录查询，格式yyyyMMdd
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
		request.setSendDate(ft.format(new Date()));
		// 必填-页大小
		request.setPageSize(10L);
		// 必填-当前页码从1开始计数
		request.setCurrentPage(1L);

		// hint 此处可能会抛出异常，注意catch
		QuerySendDetailsResponse querySendDetailsResponse = null;
		try {
			querySendDetailsResponse = acsClient.getAcsResponse(request);
			map.put("message",querySendDetailsResponse.getMessage());
			map.put("code", querySendDetailsResponse.getCode());
		} catch (Exception e) {
			logger.error("短信记录查询异常:", e);
			logger.error("手机号码为:" + phone);
		}
		return map;
	}

	public static JSONObject sendSMS(String phone,JSONObject content) throws IOException {
		String requestUrl= sms_uri+pwd+template+"mobile="+phone+"&content="+content;
		String result=MyHttpRequest.request(requestUrl, "POST");
		return JSONObject.parseObject(result);
	}

	public static void main(String[] args) throws IOException {

		JSONObject obj= new JSONObject();
		obj.put("code",getCode(6));
		System.out.println(sendSMS("18983787785", obj));
	}

	public static String getCode (int index) {
		String[] str =new String[]{"0","1","2","3","4","5","6","7","8","9"};
		String data="";
		for(int i=0;i<index;i++) {
			int s= (int) Math.floor(Math.random()*10);
			data =data.concat(str[s]);
		}
		return data;
	}
}
