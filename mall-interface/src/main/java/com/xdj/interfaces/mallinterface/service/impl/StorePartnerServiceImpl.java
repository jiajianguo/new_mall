 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingStorePartnerMapper;
 import com.xdj.interfaces.mallinterface.service.IStorePartnerService;
 import com.xdj.www.entity.ShoppingStorePartner;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 public class StorePartnerServiceImpl  implements IStorePartnerService
 {

   @Resource
   private ShoppingStorePartnerMapper storePartnerDao;

   @Override
   @CachePut(cacheNames = "insertspartner",condition = "#storePartner != null")
   public boolean save(ShoppingStorePartner storePartner)
   {
     try
     {
       this.storePartnerDao.insertSelective(storePartner);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "spartner",condition = "#id!=null",unless = "#result==null")
   public ShoppingStorePartner getObjById(Long id){
       ShoppingStorePartner storePartner = this.storePartnerDao.selectByPrimaryKey(id);
     if (storePartner != null) {
       return storePartner;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delspartner",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.storePartnerDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsspartner",allEntries = true,beforeInvocation = true,condition = "#storePartnerIds != null")
   public boolean batchDelete(List<Long> storePartnerIds)
   {
     for (Serializable id : storePartnerIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatespartner",condition = "#storePartner != null")
   public boolean update(ShoppingStorePartner storePartner) {
     try {
       this.storePartnerDao.updateByPrimaryKeySelective(storePartner);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionspartner",unless = "#result== null")
     public List<ShoppingStorePartner> queryByCondition(Map params) {
         return storePartnerDao.queryByCondition(params);
     }


 }




