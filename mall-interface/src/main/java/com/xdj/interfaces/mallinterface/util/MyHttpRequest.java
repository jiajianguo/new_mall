package com.xdj.interfaces.mallinterface.util;


import com.alibaba.fastjson.JSONException;
import org.xml.sax.SAXException;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * http请求处理
 * @author  fanhongwei
 * @date	2017年5月10日上午10:23:18
 */
public class MyHttpRequest {
	/**
	 * 发起http请求
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式(大写)
	 * @return
	 * @throws IOException
	 */
	public static String request(String requestUrl, String requestMethod) throws IOException{
		URL url = new URL(requestUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(requestMethod);
		connection.setReadTimeout(5000);
		connection.setConnectTimeout(5000);
		connection.connect();
		InputStream in = connection.getInputStream();
		Reader reader = new InputStreamReader(in, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringBuffer sb = new StringBuffer();
		String string = null;
		while ((string = bufferedReader.readLine()) != null) {
			sb.append(string);
		}
		bufferedReader.close();
		reader.close();
		in.close();
		connection.disconnect();
		return sb.toString();
	}

	/**
	 * 发起内容为json格式的请求
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式(大写)
	 * @param requestData 请求数据，json格式
	 * @return 请求结果
	 * @throws IOException
	 */
	public static String request(String requestUrl, String requestMethod, String requestData) throws IOException{
		URL url = new URL(requestUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod(requestMethod);
		connection.setDoOutput(true);
		connection.setReadTimeout(5000);
		connection.setConnectTimeout(5000);
		connection.connect();

		OutputStream out = connection.getOutputStream();
		out.write(requestData.getBytes("UTF-8"));
		out.flush();
		out.close();

		InputStream in = connection.getInputStream();
		Reader reader = new InputStreamReader(in, "UTF-8");
		BufferedReader bufferedReader = new BufferedReader(reader);
		StringBuffer buffer = new StringBuffer();
		String temp = null;
		while ((temp = bufferedReader.readLine()) != null) {
			buffer.append(temp);
		}
		bufferedReader.close();
		reader.close();
		in.close();
		connection.disconnect();
		return buffer.toString();
	}

	/**
	 * 发起内容为xml格式的请求
	 * @param requestUrl 请求地址
	 * @param requestMethod 请求方式(大写)
	 * @param requestData 请求数据字符串
	 * @return 请求结果
	 * @throws IOException
	 * @throws JSONException
	 * @throws SAXException
	 */
	public static String requestXML(String requestUrl, String requestMethod, String requestData) throws IOException, JSONException {
		StringBuffer stringBuffer=new StringBuffer() ;
		URL url = new URL(requestUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setRequestMethod(requestMethod);
		connection.setRequestProperty("Pragma", "no-cache");
        connection.setRequestProperty("Cache-Control", "no-cache");
        connection.setRequestProperty("Content-Type", "text/xml");
		connection.setReadTimeout(5000);
		connection.setConnectTimeout(5000);
		connection.connect();
        OutputStream out = connection.getOutputStream();
        out.write(requestData.getBytes("UTF-8"));
        out.flush();
        out.close();
        String tmp = null;
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        while ((tmp = reader.readLine()) != null) {
        	stringBuffer.append(tmp);
		}
        reader.close();
        in.close();
        connection.disconnect();
        return stringBuffer.toString();
	}

	/**
	 * 获取请求数据
	 * @param request
	 * @return 数据字符串
	 * @throws IOException
	 */
	public static String getRequestInputstream(HttpServletRequest request) throws IOException {
		InputStream in = request.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        StringBuffer stringBuffer = new StringBuffer();
        String tmp = null;
        while ((tmp = reader.readLine()) != null) {
        	stringBuffer.append(tmp);
		}
        reader.close();
        in.close();
		return stringBuffer.toString();
	}
}
