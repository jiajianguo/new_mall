package com.xdj.interfaces.mallinterface;

import com.xdj.interfaces.mallinterface.service.SendMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MallInterfaceApplicationTests {

   @Autowired
   private SendMessageService sendMessageService;

    //@Test
    void contextLoads() {
        sendMessageService.sendHtmlTextMail("C:\\Users\\Administrator\\Desktop\\email-client.html","order","123456789","1328171006@qq.com");
    }

}
