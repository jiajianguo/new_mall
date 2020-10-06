 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingVisitMapper;
 import com.xdj.interfaces.mallinterface.service.IVisitService;
 import com.xdj.www.entity.ShoppingVisit;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 public class VisitServiceImpl  implements IVisitService
 {

   @Resource
   private ShoppingVisitMapper visitDao;

   @Override
   @CachePut(cacheNames = "savevisit",condition = "#visit != null")
   public boolean save(ShoppingVisit visit)
   {
     try
     {
       this.visitDao.insertSelective(visit);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "visit",unless = "#result== null")
   public ShoppingVisit getObjById(Long id)
   {
       ShoppingVisit visit = this.visitDao.selectByPrimaryKey(id);
     if (visit != null) {
       return visit;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delvisit",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.visitDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsivsit",allEntries = true,beforeInvocation = true,condition = "#visitIds != null")
   public boolean batchDelete(List<Long> visitIds)
   {
     for (Serializable id : visitIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatevisit",condition = "#visit != null")
   public boolean update(ShoppingVisit visit) {
     try {
       this.visitDao.updateByPrimaryKeySelective(visit);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionvisit",unless = "#result == null")
     public List<ShoppingVisit> queryByCondition(Map map) {
         return visitDao.queryByCondition(map);
     }

 }




