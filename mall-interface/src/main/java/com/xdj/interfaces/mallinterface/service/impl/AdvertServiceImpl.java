 package com.xdj.interfaces.mallinterface.service.impl;




 import com.xdj.interfaces.mallinterface.mapper.ShoppingAdvertMapper;
 import com.xdj.interfaces.mallinterface.service.IAdvertService;

 import com.xdj.www.entity.ShoppingAdvert;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;


 /**
  * 广告信息
  * @author Administrator
  */
 @Service
 public class AdvertServiceImpl implements IAdvertService
 {

   @Resource
   private ShoppingAdvertMapper shoppingAdvertMapper;

   @Override
   @CachePut(cacheNames = "insertAdv",condition = "#advert != null")
   public boolean save(ShoppingAdvert advert){
       this.shoppingAdvertMapper.insert(advert);
       return true;
   }

   @Override
   @Cacheable(cacheNames = "adv",condition = "#id != null")
   public ShoppingAdvert getObjById(Long id)
   {
       ShoppingAdvert advert = shoppingAdvertMapper.selectByPrimaryKey(id);
     if (advert != null) {
       return advert;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deladv",allEntries = true,beforeInvocation = true,condition = "#id >0")
   public boolean delete(Long id) {
     try {
       this.shoppingAdvertMapper.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsadv",allEntries = true,beforeInvocation = true,condition = "#id >0")
   public boolean batchDelete(List<Long> advertIds)
   {
     for (Serializable id : advertIds) {
       delete((Long)id);
     }
     return true;
   }

     @Override
     @CachePut(cacheNames = "updateadv",condition = "#paramAdvert != null")
     public int update(ShoppingAdvert paramAdvert) {
         return shoppingAdvertMapper.updateByPrimaryKey(paramAdvert);
     }

     @Override
     @Cacheable(cacheNames = "conditionAdvs")
     public List<ShoppingAdvert> queryByCondition(Map<String, Object> params) {
         return shoppingAdvertMapper.queryByCondition(params);
     }


 }




