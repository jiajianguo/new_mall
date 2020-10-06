 package com.xdj.interfaces.mallinterface.service.impl;

 import com.xdj.interfaces.mallinterface.mapper.ShoppingCombinLogMapper;
 import com.xdj.interfaces.mallinterface.pay.tenpay.util.TenpayUtil;
 import com.xdj.interfaces.mallinterface.service.ICombinLogService;
 import com.xdj.www.entity.ShoppingCombinLog;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;

 @Service
 @Transactional
 public class CombinLogServiceImpl  implements ICombinLogService
 {

   @Resource
   private ShoppingCombinLogMapper combinLogDao;

   @Override
   @CachePut(cacheNames = "insertcombinLog",condition = "#combinLog != null")
   public int save(ShoppingCombinLog combinLog)
   {
     try{
       this.combinLogDao.insertSelective(combinLog);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @Cacheable(cacheNames = "combinLog" ,condition = "#id != null",unless = "#result==null")
   public ShoppingCombinLog getObjById(Long id)
   {
       ShoppingCombinLog combinLog =this.combinLogDao.selectByPrimaryKey(id);
     if (combinLog != null) {
       return combinLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delcombinLog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public int delete(Long id) {
     try {
       this.combinLogDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delscombinLog",allEntries = true,beforeInvocation =true,condition = "#combinLogIds != null")
   public int batchDelete(List<Long> combinLogIds)
   {
     for (Serializable id : combinLogIds) {
       delete((Long)id);
     }
     return 1;
   }



   @Override
   @CachePut(cacheNames = "updatecombinLog",condition = "#combinLog != null")
   public int update(ShoppingCombinLog combinLog) {
     try {
       this.combinLogDao.updateByPrimaryKeySelective(combinLog);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }


 }




