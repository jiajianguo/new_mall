 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingStoreclassMapper;
 import com.xdj.interfaces.mallinterface.service.IStoreClassService;
 import com.xdj.www.entity.ShoppingStoreclass;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 public class StoreClassServiceImpl implements IStoreClassService {

   @Resource
   private ShoppingStoreclassMapper storeClassDao;

   @Override
   @CachePut(cacheNames = "insertstoreclass",condition = "#storeClass != null")
   public boolean save(ShoppingStoreclass storeClass)
   {
     try
     {
       this.storeClassDao.insertSelective(storeClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "storeclass",condition = "#id!=null",unless = "#result==null")
   public ShoppingStoreclass getObjById(Long id)
   {
     ShoppingStoreclass storeClass =this.storeClassDao.selectByPrimaryKey(id);
     if (storeClass != null) {
       return storeClass;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delstoreclass",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.storeClassDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsstoreclass",allEntries = true,beforeInvocation = true,condition = "#storeClassIds != null")
   public boolean batchDelete(List<Long> storeClassIds)
   {
     for (Serializable id : storeClassIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatestoreclass",condition = "#storeClass != null")
   public boolean update(ShoppingStoreclass storeClass) {
     try {
       this.storeClassDao.updateByPrimaryKeySelective(storeClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionstoreclass",unless = "#result== null")
   public List<ShoppingStoreclass> queryByCondition(Map<String, Object> params) {
     return storeClassDao.queryByCondition(params);
   }

 }




