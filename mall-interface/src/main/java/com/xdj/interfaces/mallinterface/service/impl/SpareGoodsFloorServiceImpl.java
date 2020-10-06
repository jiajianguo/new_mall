 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingSpareGoodsfloorMapper;
 import com.xdj.interfaces.mallinterface.service.ISpareGoodsFloorService;
 import com.xdj.www.entity.ShoppingSpareGoodsfloor;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 @Transactional
 public class SpareGoodsFloorServiceImpl implements ISpareGoodsFloorService
 {

   @Resource
   private ShoppingSpareGoodsfloorMapper spareGoodsFloorDao;

   @Override
   @CachePut(cacheNames = "insertsparegf",condition = "#spareGoodsFloor != null")
   public boolean save(ShoppingSpareGoodsfloor spareGoodsFloor)
   {
     try
     {
       this.spareGoodsFloorDao.insertSelective(spareGoodsFloor);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "sparegf",condition = "#id!=null",unless = "#result==null")
   public ShoppingSpareGoodsfloor getObjById(Long id)
   {
       ShoppingSpareGoodsfloor spareGoodsFloor = this.spareGoodsFloorDao.selectByPrimaryKey(id);
     if (spareGoodsFloor != null) {
       return spareGoodsFloor;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsparegf",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.spareGoodsFloorDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delssparegf",allEntries = true,beforeInvocation = true,condition = "#spareGoodsFloorIds != null")
   public boolean batchDelete(List<Long> spareGoodsFloorIds)
   {
     for (Serializable id : spareGoodsFloorIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatesparegf",condition = "#spareGoodsFloor != null")
   public boolean update(ShoppingSpareGoodsfloor spareGoodsFloor) {
     try {
       this.spareGoodsFloorDao.updateByPrimaryKeySelective(spareGoodsFloor);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionsparegf",unless = "#result== null")
     public List<ShoppingSpareGoodsfloor> queryByCondition(Map params) {
         return spareGoodsFloorDao.queryByCondition(params);
     }

 }




