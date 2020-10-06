 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingUserAttentionMapper;
 import com.xdj.interfaces.mallinterface.service.ISnsAttentionService;
 import com.xdj.www.entity.ShoppingUserAttention;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class SnsAttentionServiceImpl implements ISnsAttentionService
 {

   @Resource
   private ShoppingUserAttentionMapper homeAttentionDao;

   @Override
   @CachePut(cacheNames = "inserthomeatt",condition = "#homeAttention != null")
   public boolean save(ShoppingUserAttention homeAttention)
   {
     try
     {
       this.homeAttentionDao.insertSelective(homeAttention);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "homeatt",condition = "#id!=null",unless = "#result==null")
   public ShoppingUserAttention getObjById(Long id)
   {
       ShoppingUserAttention homeAttention = this.homeAttentionDao.selectByPrimaryKey(id);
     if (homeAttention != null) {
       return homeAttention;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delhomeatt",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.homeAttentionDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delshomeatt",allEntries = true,beforeInvocation = true,condition = "#homeAttentionIds != null")
   public boolean batchDelete(List<Long> homeAttentionIds)
   {
     for (Long id : homeAttentionIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateatt",condition = "#homeAttention != null")
   public boolean update(ShoppingUserAttention homeAttention) {
     try {
       this.homeAttentionDao.updateByPrimaryKeySelective(homeAttention);

       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionhomeatt",unless = "#result== null")
   public List<ShoppingUserAttention> queryByCondition(Map map) {
     return homeAttentionDao.queryByCondition(map);
   }
 }




