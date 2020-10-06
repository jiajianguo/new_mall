 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingChattingfriendMapper;
 import com.xdj.interfaces.mallinterface.service.IChattingFriendService;
 import com.xdj.www.entity.ShoppingChattingfriend;
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
 public class ChattingFriendServiceImpl implements IChattingFriendService
 {

   @Resource
   private ShoppingChattingfriendMapper chattingFriendDao;

   @Override
   @CachePut(cacheNames = "insertchattingfriend",condition = "#chattingFriend != null")
   public boolean save(ShoppingChattingfriend chattingFriend)
   {
     try{
       this.chattingFriendDao.insertSelective(chattingFriend);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "chattingfriend",condition = "#id !=  null",unless = "#result==null")
   public ShoppingChattingfriend getObjById(Long id)
   {
       ShoppingChattingfriend chattingFriend =this.chattingFriendDao.selectByPrimaryKey(id);
     if (chattingFriend != null) {
       return chattingFriend;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delchattingfriend",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.chattingFriendDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delschattingfriend",allEntries = true,beforeInvocation = true,condition = "#chattingFriendIds != null")
   public boolean batchDelete(List<Long> chattingFriendIds)
   {
     for (Long id : chattingFriendIds) {
       delete(id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatechattingFriendIds",condition = "#chattingFriend != null")
   public boolean update(ShoppingChattingfriend chattingFriend) {
     try {
       this.chattingFriendDao.updateByPrimaryKeySelective(chattingFriend);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




