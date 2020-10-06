 package com.xdj.interfaces.mallinterface.service.impl;

 import com.xdj.interfaces.mallinterface.mapper.ShoppingAccessoryMapper;
 import com.xdj.interfaces.mallinterface.mapper.ShoppingSysconfigMapper;
 import com.xdj.interfaces.mallinterface.service.ISysConfigService;

 import com.xdj.www.entity.ShoppingAccessory;
 import com.xdj.www.entity.ShoppingSysconfigWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 /**
  * @author Administrator
  */
 @Service("configService")
 public class SysConfigServiceImpl implements ISysConfigService
 {
   @Resource
   private ShoppingSysconfigMapper shoppingSysconfigMapper;
   @Resource
   private ShoppingAccessoryMapper shoppingAccessoryMapper;

   @Override
   @CacheEvict(cacheNames = "delsysconfig",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id)
   {
     try{
       shoppingSysconfigMapper.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e){
       e.printStackTrace();
     }
     return false;
   }

   @Override
   @Cacheable(cacheNames = "getsysconfig",unless = "#result== null")
   public ShoppingSysconfigWithBLOBs getSysConfig(){
     List<ShoppingSysconfigWithBLOBs> configs = this.shoppingSysconfigMapper.findAll();
     ShoppingSysconfigWithBLOBs sc = null;
     if ((configs != null) && (configs.size() > 0)) {
       sc = configs.get(0);
       if (sc.getUploadfilepath() == null) {
           sc.setUploadfilepath("static/upload");
       }
       if (sc.getSyslanguage() == null) {
         sc.setSyslanguage("zh_cn");
       }
       if ((sc.getWebsitename() == null) || (sc.getWebsitename().equals(""))) {
         sc.setWebsitename("shopping");
       }
       if ((sc.getCloseReason()  == null) || (sc.getCloseReason().equals(""))) {
         sc.setCloseReason("系统维护中...");
       }
       if ((sc.getTitle() == null) || (sc.getTitle().equals(""))) {
         sc.setTitle("shopping多用户商城系统V2.0版");
       }
       if ((sc.getImagesavetype() == null) || (sc.getImagesavetype().equals(""))) {
         sc.setImagesavetype("sidImg");
       }
       if (sc.getImagefilesize() == 0) {
         sc.setImagefilesize(1024);
       }
       if( sc.getWebsitelogoId() != null){
         sc.setWebsiteLogo(shoppingAccessoryMapper.selectByPrimaryKey(sc.getWebsitelogoId()));
       }
       if (sc.getSmallwidth() == 0) {
         sc.setSmallwidth(160);
       }
       if (sc.getSmallheight() == 0) {
         sc.setSmallheight(160);
       }
       if (sc.getMiddlewidth() == 0) {
         sc.setMiddlewidth(300);
       }
       if (sc.getMiddleheight() == 0) {
         sc.setMiddleheight(300);
       }
       if (sc.getBigheight() == 0) {
         sc.setBigheight(1024);
       }
       if (sc.getBigwidth() == 0) {
         sc.setBigwidth(1024);
       }
       if ((sc.getImagesuffix() == null) || (sc.getImagesuffix().equals(""))) {
         sc.setImagesuffix("gif|jpg|jpeg|bmp|png|tbi");
       }
       if (sc.getStoreimageId() == null) {
         ShoppingAccessory storeImage = new ShoppingAccessory();
         storeImage.setPath("static/style/common/images");
         storeImage.setName("store.jpg");
         sc.setStoreImage(storeImage);
       }else{
         sc.setStoreImage(shoppingAccessoryMapper.selectByPrimaryKey(sc.getStoreimageId()));
       }
       if (sc.getGoodsimageId() == null) {
         ShoppingAccessory goodsImage = new ShoppingAccessory();
         goodsImage.setPath("static/style/common/images");
         goodsImage.setName("good.jpg");
         sc.setGoodsImage(goodsImage);
       }else{
         sc.setGoodsImage(shoppingAccessoryMapper.selectByPrimaryKey(sc.getGoodsimageId()));
       }
       if (sc.getMembericonId() == null) {
         ShoppingAccessory memberIcon = new ShoppingAccessory();
         memberIcon.setPath("static/style/common/images");
         memberIcon.setName("member.jpg");
         sc.setMemberIcon(memberIcon);
       }else{
         sc.setMemberIcon(shoppingAccessoryMapper.selectByPrimaryKey(sc.getMembericonId()));
       }

       if ((sc.getSecuritycodetype() == null) || (sc.getSecuritycodetype().equals(""))) {
          sc.setSecuritycodetype("normal");
       }
       if ((sc.getWebsitecss() == null) || (sc.getWebsitecss().equals(""))) {
         sc.setWebsitecss("default");
       }
       return sc;
     }
     sc = new ShoppingSysconfigWithBLOBs();
     sc.setUploadfilepath("static/upload");
     sc.setWebsitename("shopping");
     sc.setSyslanguage("zh_cn");
     sc.setTitle("shopping多用户商城系统V2.0版");
     sc.setSecuritycodetype("normal");
     sc.setEmailenable(true);
     sc.setCloseReason("系统维护中...");
     sc.setImagesavetype("sidImg");
     sc.setImagefilesize(1024);
     sc.setSmallwidth(160);
     sc.setSmallheight(160);
     sc.setMiddleheight(300);
     sc.setMiddlewidth(300);
     sc.setBigheight(1024);
     sc.setBigwidth(1024);
     sc.setImagesuffix("gif|jpg|jpeg|bmp|png|tbi");
     sc.setComplaintTime(30);
     sc.setWebsitecss("default");
     ShoppingAccessory goodsImage = new ShoppingAccessory();
     goodsImage.setPath("static/style/common/images");
     goodsImage.setName("good.jpg");
     sc.setGoodsImage(goodsImage);
     ShoppingAccessory storeImage = new ShoppingAccessory();
     storeImage.setPath("static/style/common/images");
     storeImage.setName("store.jpg");
     sc.setStoreImage(storeImage);
     ShoppingAccessory memberIcon = new ShoppingAccessory();
     memberIcon.setPath("static/style/common/images");
     memberIcon.setName("member.jpg");
     sc.setMemberIcon(memberIcon);
     return sc;
   }

   @Override
   @CachePut(cacheNames = "savesyssonfig",condition = "#shopConfig != null")
   public boolean save(ShoppingSysconfigWithBLOBs shopConfig)
   {
     try
     {

       this.shoppingSysconfigMapper.insertSelective(shopConfig);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CachePut(cacheNames = "updatesysconfig",condition = "#shopConfig != null")
   public boolean update(ShoppingSysconfigWithBLOBs shopConfig)
   {
     try
     {
       this.shoppingSysconfigMapper.updateByPrimaryKey(shopConfig);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }
 }




