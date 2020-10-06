package com.xdj.interfaces.mallinterface.service.impl;


import com.xdj.interfaces.mallinterface.service.ISysConfigService;
import com.xdj.interfaces.mallinterface.service.SendMessageService;
import com.xdj.www.core.tools.SmsBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

/**
 * @author Administrator
 */
@Service("sendMessageService")
public class SendMessageServiceImpl implements SendMessageService {
    @Resource
    private ISysConfigService configService;
    @Resource
    private JavaMailSenderImpl javaMailSenderImpl;

    @Value("${spring.mail.username}")
    private String from;

    @Override
    public boolean sendSMS(String mobile, String content) throws UnsupportedEncodingException {
        boolean result = true;
        String url = this.configService.getSysConfig().getSmsurl();
        String userName = this.configService.getSysConfig().getSmsusername();
        String password = this.configService.getSysConfig().getSmspassword();
        SmsBase sb = new SmsBase("http://service.winic.org/sys_port/gateway/", userName, password);
        String ret = sb.SendSms(mobile, content);
        if (!ret.substring(0, 3).equals("000")) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean sendEmail(String to, String subject, String content) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailMessage.setSentDate(new Date());
        javaMailSenderImpl.send(mailMessage);
        return false;
    }

    @Override
    public void sendTextMail(String subject, String content, String... to) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(from);
        mailMessage.setTo(to);
        mailMessage.setSubject(subject);
        mailMessage.setText(content);
        mailMessage.setSentDate(new Date());
        javaMailSenderImpl.send(mailMessage);
    }

    @Override
    public void sendHtmlTextMail(String filePath,String subject, String htmlContent, String to) {
        MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlContent, true);
            helper.setSentDate(new Date());
            FileSystemResource fsr = new FileSystemResource(new File(filePath));
            helper.addInline("imgSrcContentId", fsr);//此处的contentId需要和html中的对应
            javaMailSenderImpl.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendAttachmentMail(String subject, String content, String to, String filePath, String fileName) {
        MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content);
            //附件
            FileSystemResource file = new FileSystemResource(new File(filePath));
            helper.addAttachment(fileName, file);

            javaMailSenderImpl.send(mimeMessage);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sendTextMail(String subject, String content, List<String> ccList, String... tos) {
        //收件人
        InternetAddress[] addressesTo = new InternetAddress[tos.length];
        if(tos != null && tos.length>0){
            for(int i=0;i<tos.length;i++){
                InternetAddress addressTo = null;
                try {
                    addressTo = new InternetAddress(tos[i]);
                    addressesTo[i] = addressTo;
                } catch (AddressException e) {
                    e.printStackTrace();
                }
            }
        }
        //抄送人
        InternetAddress[] addressesCc = new InternetAddress[ccList.size()];
        if(ccList != null && ccList.size() > 0){
            for(int i=0;i<ccList.size();i++){
                String ccAdd = ccList.get(i);
                InternetAddress address = null;
                try {
                    address = new InternetAddress(ccAdd);
                    addressesCc[i] = address;
                } catch (AddressException e) {
                    e.printStackTrace();
                }
            }
        }

        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            @Override
            public void prepare(MimeMessage mimeMessage) throws Exception {
                mimeMessage.setFrom(from);
                mimeMessage.setSubject(subject);
                mimeMessage.setText(content);
                mimeMessage.setRecipients(Message.RecipientType.TO, addressesTo);
                mimeMessage.setRecipients(Message.RecipientType.CC, addressesCc);
            }
        };
        javaMailSenderImpl.send(preparator);
    }

    @Override
    public String getCode(int length) {
        return null;
    }
}
