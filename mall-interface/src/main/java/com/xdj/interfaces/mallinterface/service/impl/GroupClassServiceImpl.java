 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGroupClassMapper;
 import com.xdj.interfaces.mallinterface.service.IGroupClassService;
 import com.xdj.www.entity.ShoppingGroupClass;
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
 public class GroupClassServiceImpl implements IGroupClassService {

   @Resource
   private ShoppingGroupClassMapper groupClassDao;

   @Override
   @CachePut(cacheNames = "insertgroupClass",condition = "#groupClass != null")
   public boolean save(ShoppingGroupClass groupClass)
   {
     try
     {
       this.groupClassDao.insertSelective(groupClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "groupClass",condition = "#id != null")
   public ShoppingGroupClass getObjById(Long id)
   {
       ShoppingGroupClass groupClass = this.groupClassDao.selectByPrimaryKey(id);
     if (groupClass != null) {
       return groupClass;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgroupClass",condition = "#id != null",allEntries = true,beforeInvocation = true)
   public boolean delete(Long id) {
     try {
       this.groupClassDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgroupClass",condition = "#groupClassIds != null ",allEntries = true,beforeInvocation = true)
   public boolean batchDelete(List<Long> groupClassIds)
   {
     for (Long id : groupClassIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategroupClass",condition = "#groupClass != null")
   public boolean update(ShoppingGroupClass groupClass) {
     try {
       this.groupClassDao.updateByPrimaryKeySelective(groupClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditiongroupClass",unless = "#result== null")
   public List<ShoppingGroupClass> queryByCondition(Map params) {
     return groupClassDao.queryByCondition(params);
   }


 }




