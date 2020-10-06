 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingUserconfigMapper;
 import com.xdj.interfaces.mallinterface.service.IUserConfigService;
 import com.xdj.www.entity.ShoppingUserconfig;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;

 /**
  * @author Administrator
  */
 @Service
 public class UserConfigServiceImpl  implements IUserConfigService
 {

   @Resource
   private ShoppingUserconfigMapper userConfigDao;

   @Override
   @CachePut(cacheNames = "saveuconfig",condition = "#userConfig != null")
   public boolean save(ShoppingUserconfig userConfig)
   {
     try
     {
       this.userConfigDao.insertSelective(userConfig);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "uconfig",unless = "#result== null")
   public ShoppingUserconfig getObjById(Long id)
   {
       ShoppingUserconfig userConfig = userConfigDao.selectByPrimaryKey(id);
     if (userConfig != null) {
       return userConfig;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deluconfig",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.userConfigDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsuconfig",allEntries = true,beforeInvocation = true,condition = "#userConfigIds != null")
   public boolean batchDelete(List<Long> userConfigIds)
   {
     for (Serializable id : userConfigIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateuconfig",condition = "#userConfig != null")
   public boolean update(ShoppingUserconfig userConfig) {
     try {
       this.userConfigDao.updateByPrimaryKeySelective(userConfig);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "getuconfig",unless = "#result == null")
     public ShoppingUserconfig getUserConfig() {
         return userConfigDao.getUserConfig();
     }


 }




