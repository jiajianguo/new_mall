 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingStoregradeLogMapper;
 import com.xdj.interfaces.mallinterface.service.IStoreGradeLogService;
 import com.xdj.www.entity.ShoppingStoregradeLog;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 @Service
 public class StoreGradeLogServiceImpl implements IStoreGradeLogService
 {

   @Resource
   private ShoppingStoregradeLogMapper storeGradeLogDao;

   @Override
   @CachePut(cacheNames = "insertsglog",condition = "#storeGradeLog != null")
   public boolean save(ShoppingStoregradeLog storeGradeLog)
   {
     try
     {
       this.storeGradeLogDao.insertSelective(storeGradeLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "sglog",condition = "#id!=null",unless = "#result==null")
   public ShoppingStoregradeLog getObjById(Long id)
   {
       ShoppingStoregradeLog storeGradeLog = this.storeGradeLogDao.selectByPrimaryKey(id);
     if (storeGradeLog != null) {
       return storeGradeLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsglog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.storeGradeLogDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delssglog",allEntries = true,beforeInvocation = true,condition = "#storeGradeLogIds != null")
   public boolean batchDelete(List<Long> storeGradeLogIds)
   {
     for (Long id : storeGradeLogIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatesglog",condition = "#storeGradeLog != null")
   public boolean update(ShoppingStoregradeLog storeGradeLog) {
     try {
       this.storeGradeLogDao.updateByPrimaryKeySelective(storeGradeLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




