 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoldLogMapper;
 import com.xdj.interfaces.mallinterface.service.IGoldLogService;
 import com.xdj.www.entity.ShoppingGoldLogWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 /**
  *
  * @author Administrator
  */
 @Service
 public class GoldLogServiceImpl  implements IGoldLogService {

   @Resource
   private ShoppingGoldLogMapper goldLogDao;

   @Override
   @CachePut(cacheNames = "insertgoldLog",condition = "#goldLog != null")
   public boolean save(ShoppingGoldLogWithBLOBs goldLog)
   {
     try
     {
       this.goldLogDao.insertSelective(goldLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goldLog",condition = "#id != null")
   public ShoppingGoldLogWithBLOBs getObjById(Long id){
     ShoppingGoldLogWithBLOBs goldLog = this.goldLogDao.selectByPrimaryKey(id);
     if (goldLog != null) {
       return goldLog;
     }
     return null;
   }


   @Override
   @CacheEvict(cacheNames = "delgoldLog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.goldLogDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoldLogIds",allEntries = true,beforeInvocation = true,condition = "#goldLogIds != null")
   public boolean batchDelete(List<Long> goldLogIds)
   {
     for (Long id : goldLogIds) {
       delete(id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updategoldLog",condition = "#goldLog != null")
   public boolean update(ShoppingGoldLogWithBLOBs goldLog) {
     try {
       this.goldLogDao.updateByPrimaryKeySelective(goldLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




