 package com.xdj.interfaces.mallinterface.service.impl;

 import com.xdj.interfaces.mallinterface.mapper.ShoppingStorePointMapper;
 import com.xdj.interfaces.mallinterface.service.IStorePointService;
 import com.xdj.www.entity.ShoppingStorePoint;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;

 @Service
 public class StorePointServiceImpl implements IStorePointService {

   @Resource
   private ShoppingStorePointMapper storePointDao;

   @Override
   @CachePut(cacheNames = "insertspoint",condition = "#storePoint != null")
   public boolean save(ShoppingStorePoint storePoint)
   {
     try
     {
       this.storePointDao.insertSelective(storePoint);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "spoint",unless = "#result== null")
   public ShoppingStorePoint getObjById(Long id)
   {
       ShoppingStorePoint storePoint =this.storePointDao.selectByPrimaryKey(id);
     if (storePoint != null) {
       return storePoint;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delspoint",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.storePointDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsspoint",allEntries = true,beforeInvocation = true,condition = "#storePointIds!= null")
   public boolean batchDelete(List<Long> storePointIds)
   {
     for (Serializable id : storePointIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatespoint",condition = "#storePoint != null")
   public boolean update(ShoppingStorePoint storePoint) {
     try {
       this.storePointDao.updateByPrimaryKeySelective(storePoint);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "queryspoint",unless = "#result == null")
   public ShoppingStorePoint queryOne(Long storeId) {
     return storePointDao.queryOne(storeId);
   }


 }




