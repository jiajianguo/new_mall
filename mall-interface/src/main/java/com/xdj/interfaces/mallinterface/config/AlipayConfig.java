package com.xdj.interfaces.mallinterface.config;


import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Administrator
 */
public class AlipayConfig {
    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "";
    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
      */
    public static String merchant_private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAKwDevlt9Q9HwcjnNjXxvrd41KlKOy/HEWU/77O4wrFpwm4vxSk+HGSct3DIrAeNmgnd/UBjPro5KAGZOBnXtfgu3vxQKeJT6bqJkgT2Bg8uvRSUPVJCgqErOFlemkT67BazOMxjt0pgRSFvP1WXTVaP2qUiCZEQ6FVKAD4MISArAgMBAAECgYB5h8/3sJ9ml10rs2fSvyTu/djKbt7YR75bmcuiX9R2gnFTZj7Xf8GRuEPG1JDumTYO6J+IQVZNPhqs3nMLlyNBt8ofEPqDEnNu2soAiCrs5G2Rtd50b7OsGAa2ZzxshvkinWNPKnTKVpzn6YB/wmUgBU/ISRTJ/hl16EOCh6jmMQJBAN9XqU/+1bm8kEL9PL7sJbNrL+dQIvmwbWhzr16zTEwQTMOngKyixJ1VO+20/LaLcZWcN/DjjTCABd/xIPpLrDMCQQDFKm+HWYHoMMYU4jM5Zg9TC6pqhlNCbeCyouF2/lfMXhxEjoL/uSpvPaO7sKegD14BjGmX7xpKfGyHzTpdp0QpAkEArg7AahKdeCInf72iEN0zSI/ZhnkiuNsxePzniHNNm938JWMuWdyERGV/zfKGHLGx9LoJstd0Wn77lRpz6/z7lwJBAKEkdLC/k+/sZQhOc6U259Fs2GRl0oiZeysk+nchmyp5xEq32xMcCDWQwFA3KlkkFiXX17mIfwlftegr8Mb4XTkCQFEA4M5sddL3fSq81DFycvTE/Swwy1W4r4KHfnKBfAOPtu3gj3tRqukP0I+gJ1TgpKTp41jLI5UlQfAcTVVB5PU=";
    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCzkIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";
    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
    // 签名方式
    public static String sign_type = "RSA2";
    // 字符编码格式
    public static String charset = "utf-8";
    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
    // 支付宝网关
    public static String log_path = "C:\\";

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
