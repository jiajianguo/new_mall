 package com.xdj.interfaces.mallinterface.util;

 import com.xdj.interfaces.mallinterface.controller.view.AccessoryViewTools;
 import com.xdj.interfaces.mallinterface.service.ISysConfigService;
 import com.xdj.www.entity.ShoppingAccessory;
 import com.xdj.www.entity.ShoppingSysconfigWithBLOBs;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 import javax.annotation.Resource;
 import java.util.Random;

 @Component
 public class ImageViewTools {
   @Autowired
   private ISysConfigService configService;
   @Resource
   private AccessoryViewTools accessViewTools;

   public String random_login_img() {
     String img = "";
     ShoppingSysconfigWithBLOBs config = this.configService.getSysConfig();
     accessViewTools.addLoginImgs(config);
     if (config.getLogin_imgs() != null && config.getLogin_imgs().size() > 0) {
       Random random = new Random();
       ShoppingAccessory acc = (ShoppingAccessory) config.getLogin_imgs().get(
         random.nextInt(config.getLogin_imgs().size()));
       img = acc.getPath() + "/" + acc.getName();
     } else {
       img = "/style/common/images/login_img.jpg";
     }
     return img;
   }
 }




