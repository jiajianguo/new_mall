 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingChattinglogMapper;
 import com.xdj.interfaces.mallinterface.service.IChattingLogService;
 import com.xdj.www.entity.ShoppingChattinglog;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 @Service
 public class ChattingLogServiceImpl implements IChattingLogService
 {

   @Resource
   private ShoppingChattinglogMapper chattingLogDao;

   @Override
   @CachePut(cacheNames = "insertchattingLog",condition = "#chattingLog != null")
   public int save(ShoppingChattinglog chattingLog)
   {
     try
     {
       this.chattingLogDao.insertSelective(chattingLog);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @Cacheable(cacheNames = "chattingLog",condition = "#id != null",unless = "#result==null")
   public ShoppingChattinglog getObjById(Long id)
   {
       ShoppingChattinglog chattingLog = this.chattingLogDao.selectByPrimaryKey(id);
     if (chattingLog != null) {
       return chattingLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delchattingLog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public int delete(Long id) {
     try {
       this.chattingLogDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }
     return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delschattingLog",allEntries = true,beforeInvocation = true,condition = "#chattingLogIds != null ")
   public int batchDelete(List<Long> chattingLogIds)
   {
     for (Long id : chattingLogIds) {
       delete(id);
     }
     return 1;
   }



   @Override
   @CachePut(cacheNames = "updatechattingLog",condition = "#chattingLog != null")
   public int update(ShoppingChattinglog chattingLog) {
     try {
       this.chattingLogDao.updateByPrimaryKeySelective(chattingLog);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }
     return 0;
   }


 }




