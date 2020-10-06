 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingSpareGoodsMapper;
 import com.xdj.interfaces.mallinterface.service.ISpareGoodsService;
 import com.xdj.www.entity.ShoppingSpareGoods;
 import com.xdj.www.entity.ShoppingSpareGoodsWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class SpareGoodsServiceImpl implements ISpareGoodsService
 {

   @Resource
   private ShoppingSpareGoodsMapper spareGoodsDao;

   @Override
   @CachePut(cacheNames = "insertsparegoods",condition = "#spareGoods != null")
   public boolean save(ShoppingSpareGoodsWithBLOBs spareGoods)
   {
     try
     {
       this.spareGoodsDao.insertSelective(spareGoods);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "sparegoods",condition = "#id!=null",unless = "#result==null")
   public ShoppingSpareGoodsWithBLOBs getObjById(Long id)
   {
       ShoppingSpareGoodsWithBLOBs spareGoods = this.spareGoodsDao.getObjById(id);
     if (spareGoods != null) {
       return spareGoods;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsparegoods",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.spareGoodsDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delssparegoods",allEntries = true,beforeInvocation = true,condition = "#spareGoodsIds != null")
   public boolean batchDelete(List<Long> spareGoodsIds)
   {
     for (Long id : spareGoodsIds) {
       delete((Long)id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatesparegoods",condition = "#spareGoods != null")
   public boolean update(ShoppingSpareGoodsWithBLOBs spareGoods) {
     try {
       this.spareGoodsDao.updateByPrimaryKeySelective(spareGoods);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionsparegoods",unless = "#result== null")
   public List<ShoppingSpareGoodsWithBLOBs> queryByCondition(Map params) {
     return spareGoodsDao.queryByCondition(params);
   }

     @Override
     @Cacheable(cacheNames = "countsparegodos",unless = "#result== null")
     public int count(Map params) {
         return spareGoodsDao.count(params);
     }

     @Override
     @Cacheable(cacheNames = "pagelistsparegoods",unless = "#result== null")
     public List<ShoppingSpareGoodsWithBLOBs> pageList(Map params) {
         return spareGoodsDao.pageList(params);
     }


 }




