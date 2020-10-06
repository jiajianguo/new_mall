 package com.xdj.interfaces.mallinterface.service.impl;

 import com.xdj.interfaces.mallinterface.mapper.ShoppingIntegrallogMapper;
 import com.xdj.interfaces.mallinterface.service.IIntegralLogService;
 import com.xdj.www.entity.ShoppingIntegrallog;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;

 @Service
 public class IntegralLogServiceImpl implements IIntegralLogService
 {

   @Resource
   private ShoppingIntegrallogMapper integralLogDao;

   @Override
   @CachePut(cacheNames = "insertintergrallog",condition = "#integralLog != null")
   public boolean save(ShoppingIntegrallog integralLog)
   {
     try
     {
       this.integralLogDao.insertSelective(integralLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "integrallog",condition = "#id!=null",unless = "#result==null")
   public ShoppingIntegrallog getObjById(Long id)
   {
       ShoppingIntegrallog integralLog = this.integralLogDao.selectByPrimaryKey(id);
     if (integralLog != null) {
       return integralLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delintegrallog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.integralLogDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsintergrallog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean batchDelete(List<Long> integralLogIds)
   {
     for (Serializable id : integralLogIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateintegrallog")
   public boolean update(ShoppingIntegrallog integralLog) {
     try {
       this.integralLogDao.updateByPrimaryKeyWithBLOBs(integralLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




