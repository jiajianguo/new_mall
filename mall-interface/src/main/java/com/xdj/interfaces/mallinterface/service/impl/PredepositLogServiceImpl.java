 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingPredepositLogMapper;
 import com.xdj.interfaces.mallinterface.service.IPredepositLogService;
 import com.xdj.www.entity.ShoppingPredepositLog;
 import com.xdj.www.entity.ShoppingPredepositWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class PredepositLogServiceImpl
   implements IPredepositLogService
 {

   @Resource
   private ShoppingPredepositLogMapper predepositLogDao;

   @Override
   @CachePut(cacheNames = "insertpplog",condition = "#predepositLog != null")
   public boolean save(ShoppingPredepositLog predepositLog)
   {
     try
     {
       this.predepositLogDao.insertSelective(predepositLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "pplog",condition = "#id!=null",unless = "#result==null")
   public ShoppingPredepositLog getObjById(Long id)
   {
       ShoppingPredepositLog predepositLog = this.predepositLogDao.selectByPrimaryKey(id);
     if (predepositLog != null) {
       return predepositLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delpplog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.predepositLogDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delspplog",allEntries = true,beforeInvocation = true,condition = "#predepositLogIds != null")
   public boolean batchDelete(List<Long> predepositLogIds)
   {
     for (Long id : predepositLogIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatepplog",condition = "#predepositLog != null")
   public boolean update(ShoppingPredepositLog predepositLog) {
     try {
       this.predepositLogDao.updateByPrimaryKeySelective(predepositLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionpplog",unless = "#result == null")
   public List<ShoppingPredepositLog> queryByCondition(Map<String, Object> map) {
     return predepositLogDao.queryByCondition(map);
   }

   @Override
   @Cacheable(cacheNames = "countpplog",unless = "#result == null")
   public int count(Map<String, Object> map) {
     return predepositLogDao.count(map);
   }


 }




