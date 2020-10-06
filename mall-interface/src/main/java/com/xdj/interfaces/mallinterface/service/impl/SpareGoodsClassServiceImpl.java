 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingSpareGoodsclassMapper;
 import com.xdj.interfaces.mallinterface.service.ISpareGoodsClassService;
 import com.xdj.www.entity.ShoppingSpareGoodsclass;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class SpareGoodsClassServiceImpl  implements ISpareGoodsClassService
 {
   @Resource
   private ShoppingSpareGoodsclassMapper spareGoodsClassDao;
   @Override
   @CachePut(cacheNames = "insertsparegc",condition = "#spareGoodsClass != null")
   public boolean save(ShoppingSpareGoodsclass spareGoodsClass)
   {
     try
     {
       this.spareGoodsClassDao.insertSelective(spareGoodsClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "sparegc",condition = "#id!=null",unless = "#result==null")
   public ShoppingSpareGoodsclass getObjById(Long id)
   {
       ShoppingSpareGoodsclass spareGoodsClass = this.spareGoodsClassDao.selectByPrimaryKey(id);
     if (spareGoodsClass != null) {
       return spareGoodsClass;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsparegc",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.spareGoodsClassDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delssparegc",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean batchDelete(List<Long> spareGoodsClassIds)
   {
     for (Long id : spareGoodsClassIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatesparegc",condition = "#spareGoodsClass != null")
   public boolean update(ShoppingSpareGoodsclass spareGoodsClass) {
     try {
       this.spareGoodsClassDao.updateByPrimaryKeySelective(spareGoodsClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionsparegc",unless = "#result == null")
     public List<ShoppingSpareGoodsclass> queryByCondition(Map params) {
         return spareGoodsClassDao.queryByCondition(params);
     }


 }




