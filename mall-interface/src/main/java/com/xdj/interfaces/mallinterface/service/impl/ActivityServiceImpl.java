 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingActivityMapper;
 import com.xdj.interfaces.mallinterface.service.IActivityService;
 import com.xdj.www.entity.ShoppingActivity;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 public class ActivityServiceImpl implements IActivityService {

   @Resource
   private ShoppingActivityMapper activityDao;

   @Override
   @CachePut(cacheNames = "activity" ,condition = "#activity != null" )
   public boolean save(ShoppingActivity activity)
   {
     try
     {
       this.activityDao.insertSelective(activity);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "qactivity" ,condition = "#id >0" ,unless = "#result==null")
   public ShoppingActivity getObjById(Long id)
   {
       ShoppingActivity activity = this.activityDao.selectByPrimaryKey(id);
     if (activity != null) {
       return activity;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "dactivity", allEntries = true, beforeInvocation = true, condition = "#id >0")
   public boolean delete(Long id) {
     try {
       this.activityDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "dactivity", allEntries = true, beforeInvocation = true)
   public boolean batchDelete(List<Long> activityIds)
   {
     for (Serializable id : activityIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateActivity", condition = "#activity != null", unless = "#result>0")
   public boolean update(ShoppingActivity activity) {
     try {
       this.activityDao.updateByPrimaryKey(activity);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




