 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsspecificationMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsSpecificationService;
 import com.xdj.www.entity.ShoppingGoodsspecification;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class GoodsSpecificationServiceImpl implements IGoodsSpecificationService
 {

   @Resource
   private ShoppingGoodsspecificationMapper goodsSpecificationDao;

   @Override
   @CachePut(cacheNames = "insertgoodsSpecification",condition = "#goodsSpecification != null")
   public boolean save(ShoppingGoodsspecification goodsSpecification)
   {
     try
     {
       this.goodsSpecificationDao.insertSelective(goodsSpecification);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsSpecification",condition = "#id != null")
   public ShoppingGoodsspecification getObjById(Long id)
   {
       ShoppingGoodsspecification goodsSpecification = this.goodsSpecificationDao.selectByPrimaryKey(id);
     if (goodsSpecification != null) {
       return goodsSpecification;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsSpecification",condition = "#id != null",allEntries = true,beforeInvocation = true)
   public boolean delete(Long id) {
     try {
       this.goodsSpecificationDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsSpecification",allEntries = true,beforeInvocation = true,condition = "#goodsSpecificationIds != null")
   public boolean batchDelete(List<Long> goodsSpecificationIds)
   {
     for (Long id : goodsSpecificationIds) {
       delete(id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updategoodsSpecification",condition = "#goodsSpecification != null")
   public boolean update(ShoppingGoodsspecification goodsSpecification) {
     try {
       this.goodsSpecificationDao.updateByPrimaryKeySelective(goodsSpecification);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditiongoodsSpecification")
     public List<ShoppingGoodsspecification> queryByConditoin(Map<String, Object> para) {
         return goodsSpecificationDao.queryByConditoin(para);
     }


 }




