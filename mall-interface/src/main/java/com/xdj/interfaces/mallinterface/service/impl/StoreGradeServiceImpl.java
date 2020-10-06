 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingStoregradeMapper;
 import com.xdj.interfaces.mallinterface.service.IStoreGradeService;
 import com.xdj.www.entity.ShoppingStoregrade;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class StoreGradeServiceImpl  implements IStoreGradeService
 {

   @Resource
   private ShoppingStoregradeMapper storeGradeDao;

   @Override
   @CachePut(cacheNames = "insertsgrade",condition = "#storeGrade != null")
   public boolean save(ShoppingStoregrade storeGrade)
   {
     try
     {
       this.storeGradeDao.insertSelective(storeGrade);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "sgrade",condition = "#id!=null",unless = "#result==null")
   public ShoppingStoregrade getObjById(Long id)
   {
       ShoppingStoregrade storeGrade = this.storeGradeDao.selectByPrimaryKey(id);
     if (storeGrade != null) {
       return storeGrade;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsgrade",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.storeGradeDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delssgrade",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean batchDelete(List<Long> storeGradeIds)
   {
     for (Long id : storeGradeIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatesgrade",condition = "#storeGrade != null")
   public boolean update(ShoppingStoregrade storeGrade) {
     try {
       this.storeGradeDao.updateByPrimaryKeySelective(storeGrade);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionsgrade",unless = "#result== null")
   public List<ShoppingStoregrade> queryByCondition(Map<String, Object> params) {
     return storeGradeDao.queryByCondition(params);
   }

 }




