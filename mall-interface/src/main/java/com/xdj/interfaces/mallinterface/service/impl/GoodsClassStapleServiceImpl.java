 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsclassstapleMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsClassStapleService;
 import com.xdj.www.entity.ShoppingGoodsclassstaple;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;

 /**
  * @author Administrator
  */
 @Service

 public class GoodsClassStapleServiceImpl implements IGoodsClassStapleService
 {

   @Resource
   private ShoppingGoodsclassstapleMapper goodsClassStapleDao;

   @Override
   @Transactional(rollbackFor = Exception.class)
   @CachePut(cacheNames = "insertgoodsClassStaple",condition = "#goodsClassStaple != null")
   public boolean save(ShoppingGoodsclassstaple goodsClassStaple)
   {
     try
     {
       this.goodsClassStapleDao.insertSelective(goodsClassStaple);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsClassStaple",condition = "#id != null")
   public ShoppingGoodsclassstaple getObjById(Long id)
   {
       ShoppingGoodsclassstaple goodsClassStaple =this.goodsClassStapleDao.selectByPrimaryKey(id);
     if (goodsClassStaple != null) {
       return goodsClassStaple;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsClassStaple",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.goodsClassStapleDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsClassStaple",allEntries = true,beforeInvocation = true,condition = "#goodsClassStapleIds !=  null")
   public boolean batchDelete(List<Long> goodsClassStapleIds)
   {
     for (Long id : goodsClassStapleIds) {
       delete(id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updategoodsClassStaple",condition = "#goodsClassStaple != null")
   public boolean update(ShoppingGoodsclassstaple goodsClassStaple) {
     try {
       this.goodsClassStapleDao.updateByPrimaryKeySelective(goodsClassStaple);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "goodsClassStaples",condition = "#storeId != null  ")
     public List<ShoppingGoodsclassstaple> queryByStoreId(Long storeId) {
         return this.goodsClassStapleDao.queryByStoreId(storeId);
     }


 }




