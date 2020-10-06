 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingStoreStatMapper;
 import com.xdj.interfaces.mallinterface.service.IStoreStatService;
 import com.xdj.www.entity.ShoppingStoreStat;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 @Service
 public class StoreStatServiceImpl  implements IStoreStatService
 {

   @Resource
   private ShoppingStoreStatMapper storeStatDao;

   @Override
   @CachePut(cacheNames = "savesstat",condition = "#storeStat != null")
   public boolean save(ShoppingStoreStat storeStat)
   {
     try
     {
       this.storeStatDao.insertSelective(storeStat);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "sstat",unless = "#result== null")
   public ShoppingStoreStat getObjById(Long id)
   {
       ShoppingStoreStat storeStat = this.storeStatDao.selectByPrimaryKey(id);
     if (storeStat != null) {
       return storeStat;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsstat",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.storeStatDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delssstat",allEntries = true,beforeInvocation = true,condition = "#storeStatIds != null")
   public boolean batchDelete(List<Long> storeStatIds)
   {
     for (Long id : storeStatIds) {
       delete((Long)id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatesstat",condition = "#storeStat != null")
   public boolean update(ShoppingStoreStat storeStat) {
     try {
       this.storeStatDao.updateByPrimaryKeySelective(storeStat);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




