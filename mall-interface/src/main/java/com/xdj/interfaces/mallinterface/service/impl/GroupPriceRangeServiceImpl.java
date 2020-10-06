 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGroupPriceRangeMapper;
 import com.xdj.interfaces.mallinterface.service.IGroupPriceRangeService;
 import com.xdj.www.entity.ShoppingGroupPriceRange;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */
 @Service
 @Transactional
 public class GroupPriceRangeServiceImpl implements IGroupPriceRangeService
 {

   @Resource
   private ShoppingGroupPriceRangeMapper groupPriceRangeDao;

   @Override
   @CachePut(cacheNames = "insertgroupPriceRange",condition = "#groupPriceRange != null ")
   public boolean save(ShoppingGroupPriceRange groupPriceRange)
   {
     try
     {
       this.groupPriceRangeDao.insertSelective(groupPriceRange);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "groupPriceRange",condition = "#id != null")
   public ShoppingGroupPriceRange getObjById(Long id){
       ShoppingGroupPriceRange groupPriceRange = this.groupPriceRangeDao.selectByPrimaryKey(id);
     if (groupPriceRange != null) {
       return groupPriceRange;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgroupPriceRange",condition = "#id !=  null",allEntries = true,beforeInvocation = true)
   public boolean delete(Long id) {
     try {
       this.groupPriceRangeDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgroupPriceRange",condition = "#groupPriceRangeIds != null",allEntries = true,beforeInvocation = true)
   public boolean batchDelete(List<Long> groupPriceRangeIds)
   {
     for (Long id : groupPriceRangeIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategroupPriceRange",condition = "#groupPriceRange != null ")
   public boolean update(ShoppingGroupPriceRange groupPriceRange) {
     try {
       this.groupPriceRangeDao.updateByPrimaryKeySelective(groupPriceRange);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "groupPriceRanges" )
     public List<ShoppingGroupPriceRange> queryByCondition(Map params) {
         return groupPriceRangeDao.queryByCondition(params);
     }


 }




