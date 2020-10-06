 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingTransAreaMapper;
 import com.xdj.interfaces.mallinterface.service.ITransAreaService;
 import com.xdj.www.entity.ShoppingTransArea;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;

 /**
  * @author Administrator
  */
 @Service
 public class TransAreaServiceImpl implements ITransAreaService
 {

   @Resource
   private ShoppingTransAreaMapper transAreaDao;

   @Override
   @CachePut(cacheNames = "savetransarea",condition = "#transArea != null")
   public boolean save(ShoppingTransArea transArea)
   {
     try
     {
       this.transAreaDao.insertSelective(transArea);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "transarea",unless = "#result== null")
   public ShoppingTransArea getObjById(Long id)
   {
       ShoppingTransArea transArea = this.transAreaDao.selectByPrimaryKey(id);
     if (transArea != null) {
       return transArea;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deltransarea",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.transAreaDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delstransarea",allEntries = true,beforeInvocation = true,condition = "#transAreaIds != null")
   public boolean batchDelete(List<Long> transAreaIds)
   {
     for (Serializable id : transAreaIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatetransarea",condition = "#transArea != null")
   public boolean update(ShoppingTransArea transArea) {
     try {
       this.transAreaDao.updateByPrimaryKeySelective(transArea);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




