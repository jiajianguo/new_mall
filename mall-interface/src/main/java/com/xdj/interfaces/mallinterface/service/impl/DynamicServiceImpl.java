 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingDynamicMapper;
 import com.xdj.interfaces.mallinterface.service.IDynamicService;
 import com.xdj.www.entity.ShoppingDynamic;
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
 public class DynamicServiceImpl implements IDynamicService {

   @Resource
   private ShoppingDynamicMapper dynamicDao;

   @Override
   @CachePut(cacheNames = "insertdynamic",condition = "#dynamic != null")
   public boolean save(ShoppingDynamic dynamic)
   {
     try
     {
       this.dynamicDao.insertSelective(dynamic);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable (cacheNames = "dynamic",condition = "#id != null",unless = "#result==null")
   public ShoppingDynamic getObjById(Long id)
   {
       ShoppingDynamic dynamic = this.dynamicDao.selectByPrimaryKey(id);
     if (dynamic != null) {
       return dynamic;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deldynamic",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.dynamicDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsdynamic",allEntries = true,beforeInvocation = true,condition = "#dynamicIds != null")
   public boolean batchDelete(List<Long> dynamicIds)
   {
     for (Long id : dynamicIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatedynamic",condition = "#dynamic != null")
   public boolean update(ShoppingDynamic dynamic) {
     try {
       this.dynamicDao.updateByPrimaryKey(dynamic);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "pagelistdynamic",unless = "#result==null")
   public List<ShoppingDynamic> pageList(Map<String, Object> params) {
     return dynamicDao.pageList(params);
   }

   @Override
   @Cacheable(cacheNames = "countdynamic",unless = "#result==null")
   public int count(Map<String, Object> params) {
     return dynamicDao.count(params);
   }


 }




