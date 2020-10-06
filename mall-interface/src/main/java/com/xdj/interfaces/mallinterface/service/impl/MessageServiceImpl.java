 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingMessageMapper;
 import com.xdj.interfaces.mallinterface.service.IMessageService;
 import com.xdj.www.entity.ShoppingMessage;
 import com.xdj.www.entity.ShoppingVmessage;
 import com.xdj.www.entity.ShoppingVmessageWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class MessageServiceImpl implements IMessageService {

   @Resource
   private ShoppingMessageMapper messageDao;

   @Override
   @CachePut(cacheNames = "insertmessage",condition = "#message != null")
   public boolean save(ShoppingMessage message)
   {
     try
     {
       this.messageDao.insertSelective(message);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }
     @Override
     @Cacheable(cacheNames = "message",condition = "#id!=null",unless = "#result==null")
   public ShoppingMessage getObjById(Long id)
   {
       ShoppingMessage message = this.messageDao.selectByPrimaryKey(id);
     if (message != null) {
       return message;
     }
     return null;
   }
     @Override
     @CacheEvict(cacheNames = "delmessage",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.messageDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @CacheEvict(cacheNames = "delsmessage",allEntries = true,beforeInvocation = true,condition = "#messageIds != null")
   public boolean batchDelete(List<Long> messageIds)
   {
     for (Long id : messageIds) {
       delete((Long)id);
     }
     return true;
   }


     @Override
     @CachePut(cacheNames = "updatemessage")
   public boolean update(ShoppingMessage message) {
     try {
       this.messageDao.updateByPrimaryKeyWithBLOBs(message);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionmessage")
   public List<ShoppingMessage> queryByCondition(Map<String, Object> params) {
     return messageDao.queryByCondition(params);
   }

     @Override
     @Cacheable(cacheNames = "countmessage")
     public int count(Map<String, Object> map) {
         return messageDao.count(map);
     }


 }




