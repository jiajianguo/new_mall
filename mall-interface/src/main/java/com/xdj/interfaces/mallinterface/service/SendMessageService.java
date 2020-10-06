package com.xdj.interfaces.mallinterface.service;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author Administrator
 */
public interface SendMessageService {

    /**
     * 短信发送
     * @param mobile
     * @param content
     * @return
     * @throws UnsupportedEncodingException
     */
    public boolean sendSMS(String mobile, String content) throws UnsupportedEncodingException;

    /**
     * 发送email
     * @param to
     * @param subject
     * @param content
     * @return
     */
    public boolean sendEmail(String to, String subject, String content);

    /**
     * 发送简单文本邮件
     * @param subject 邮件主题
     * @param content 邮件内容
     * @param to 收件人
     */
    void sendTextMail(String subject, String content, String... to);

    /**
     * 发送包含html标签内容的邮件
     * @param  filePath 附件路径
     * @param subject 邮件主题
     * @param htmlContent 邮件内容
     * @param to 收件人
     */
    void sendHtmlTextMail(String filePath, String subject, String htmlContent, String to);

    /**
     * 发送带附件邮件
     * @param subject 主题
     * @param content 邮件内容
     * @param to 收件人
     * @param filePath 附件路径
     * @param fileName 附件名
     */
    void sendAttachmentMail(String subject, String content, String to, String filePath, String fileName);

    /**
     * 发送简单文本邮件 并抄送
     * @param subject
     * @param content
     * @param ccList 抄送人
     * @param tos 收件人，多个时用逗号隔开
     */
    void sendTextMail(String subject, String content, List<String> ccList, String... tos);

    /**
     *  获取验证码
     * @param length 验证码长度
     * @return 返回指定长度的验证码
     */
    String getCode(int length);
}
