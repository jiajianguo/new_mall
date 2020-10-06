 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingChattingMapper;
 import com.xdj.interfaces.mallinterface.service.IChattingService;
 import com.xdj.www.entity.ShoppingChatting;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;


 import javax.annotation.Resource;
 import java.util.List;

 /**
  * @author Administrator
  */

 @Service
 public class ChattingServiceImpl implements IChattingService {

   @Resource
   private ShoppingChattingMapper chattingDao;

   @Override
   @CachePut(cacheNames = "insertchatting",condition = "#chatting != null")
   public boolean save(ShoppingChatting chatting)
   {
     try
     {
       this.chattingDao.insertSelective(chatting);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "chatting",condition = "#id != null")
   public ShoppingChatting getObjById(Long id)
   {

       return this.chattingDao.selectByPrimaryKey(id);

   }

   @Override
   @CacheEvict(cacheNames = "delchatting",allEntries = true,beforeInvocation = true,condition = "#id != null ")
   public boolean delete(Long id) {
     try {
       this.chattingDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delschatting",allEntries =  true,beforeInvocation = true,condition = "#chattingIds != null")
   public boolean batchDelete(List<Long> chattingIds)
   {
     for (Long id : chattingIds) {
       delete(id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatechatting",condition = "#chatting != null")
   public boolean update(ShoppingChatting chatting) {
     try {
       this.chattingDao.updateByPrimaryKeySelective(chatting);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




