 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingUserFriendMapper;
 import com.xdj.interfaces.mallinterface.service.ISnsFriendService;
 import com.xdj.www.entity.ShoppingUserFriend;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class SnsFriendServiceImpl  implements ISnsFriendService
 {

   @Resource
   private ShoppingUserFriendMapper snsFriendDao;

   @Override
   @CachePut(cacheNames = "insertsnsf",condition = "#snsFriend != null")
   public boolean save(ShoppingUserFriend snsFriend)
   {
     try
     {
       this.snsFriendDao.insertSelective(snsFriend);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "snsf",condition = "#id!=null",unless = "#result==null")
   public ShoppingUserFriend getObjById(Long id)
   {
       ShoppingUserFriend snsFriend =this.snsFriendDao.selectByPrimaryKey(id);
     if (snsFriend != null) {
       return snsFriend;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsnsf",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.snsFriendDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delssnsf",allEntries = true,beforeInvocation = true,condition = "#snsFriendIds != null")
   public boolean batchDelete(List<Long> snsFriendIds)
   {
     for (Long id : snsFriendIds) {
       delete((Long)id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatesnsf",condition = "#snsFriend != null")
   public boolean update(ShoppingUserFriend snsFriend) {
     try {
       this.snsFriendDao.updateByPrimaryKeySelective(snsFriend);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionsnsf",unless = "#result== null")
   public List<ShoppingUserFriend> queryByCondition(Map<String, Object> map) {
     return snsFriendDao.queryByCondition(map);
   }

   @Override
   @Cacheable(cacheNames = "countsnsf",unless = "#result== null")
   public int count(Map<String, Object> map) {
     return 0;
   }


 }




