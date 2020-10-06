 package com.xdj.interfaces.mallinterface.service.impl;


import com.xdj.interfaces.mallinterface.mapper.ShoppingUserMapper;
import com.xdj.interfaces.mallinterface.service.IUserService;
import com.xdj.www.entity.ShoppingUser;
import com.xdj.www.entity.ShoppingUserExample;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

import java.util.List;
import java.util.Map;

 /**
  * @author Administrator
  */
 @Service
 public class UserServiceImpl implements IUserService {

   @Resource
   private ShoppingUserMapper userDAO;

   @Override
   @CacheEvict(cacheNames = "deluser",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public int delete(Long id){
     try{
       return this.userDAO.deleteByPrimaryKey(id);
     } catch (Exception e) {
       e.printStackTrace();
     }
     return 0;
   }

   @Override
   @Cacheable(cacheNames = "user",unless = "#result== null")
   public ShoppingUser getObjById(Long id)
   {
       return this.userDAO.selectByPrimaryKey(id);
   }

   @Override
   @Cacheable(cacheNames = "getoneuser",unless = "#result == null")
   public ShoppingUser getOne(Map<String, Object> map) {
     return userDAO.getOne(map);
   }

   @Override
   @Cacheable(cacheNames = "storeuser",unless = "#result == null")
   public ShoppingUser queryOneByStoreId(Long storeId) {
     return userDAO.queryOneByStoreId(storeId);
   }

   @Override
   @Cacheable(cacheNames = "selectuser",unless = "#result == null")
   public List<ShoppingUser> selectByExample(ShoppingUserExample example) {
     return userDAO.selectByExample(example);
   }

   @Override
   @Cacheable(cacheNames = "conditionuser",unless = "#result == null")
   public List<ShoppingUser> queryByCondition(Map<String, Object> map) {
     return userDAO.queryByCondition(map);
   }

   @Override
   @Cacheable(cacheNames = "finduser",unless = "#result == null")
   public ShoppingUser findByUsername(String username) {
     return userDAO.findByUsername(username);
   }

   @Override
   @Cacheable(cacheNames = "countuser",unless = "#result == null")
   public int count(Map<String, Object> map) {
     return userDAO.count(map);
   }

   @Override
   public ShoppingUser getUserByOpenId(String openId) {
     return userDAO.getUserByOpenId(openId);
   }

   @Override
   @CachePut(cacheNames = "saveuser",condition = "#user != null")
   public int save(ShoppingUser user)
   {
     try {
       this.userDAO.insert(user);
       return 1;
     } catch (Exception e) {
         e.printStackTrace();
     }
     return 0;
   }

   @Override
   @CachePut(cacheNames = "updateuser",condition = "#user != null")
   public int update(ShoppingUser user)
   {
     try{
       this.userDAO.updateByPrimaryKey(user);
       return 1;
     } catch (Exception e) {
        e.printStackTrace();
     }
     return 0;
   }

 }




