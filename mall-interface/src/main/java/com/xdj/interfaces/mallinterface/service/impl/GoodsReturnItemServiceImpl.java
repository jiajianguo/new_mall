 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsReturnitemMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsReturnItemService;
 import com.xdj.www.entity.ShoppingGoodsReturnitem;
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
 public class GoodsReturnItemServiceImpl implements IGoodsReturnItemService
 {

   @Resource
   private ShoppingGoodsReturnitemMapper goodsReturnItemDao;

   @Override
   @CachePut(cacheNames = "insertgoodsReturnItem",condition = "#goodsReturnItem != null")
   public boolean save(ShoppingGoodsReturnitem goodsReturnItem)
   {
     try
     {
       this.goodsReturnItemDao.insertSelective(goodsReturnItem);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsReturnItem",condition = "#id != null",unless = "#result== null")
   public ShoppingGoodsReturnitem getObjById(Long id)
   {
       ShoppingGoodsReturnitem goodsReturnItem =this.goodsReturnItemDao.selectByPrimaryKey(id);
     if (goodsReturnItem != null) {
       return goodsReturnItem;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsReturnItem",condition = "#id != null",allEntries = true,beforeInvocation = true)
   public boolean delete(Long id) {
     try {
       this.goodsReturnItemDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsReturnItem",condition = "#goodsReturnItemIds != null ",allEntries = true,beforeInvocation = true)
   public boolean batchDelete(List<Long> goodsReturnItemIds)
   {
     for (Long id : goodsReturnItemIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategoodsReturnItemIds",condition = "#goodsReturnItem != null ")
   public boolean update(ShoppingGoodsReturnitem goodsReturnItem) {
     try {
       this.goodsReturnItemDao.updateByPrimaryKeySelective(goodsReturnItem);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsReturnItems",unless = "#result== null")
   public List<ShoppingGoodsReturnitem> queryByCondition(Map<String, Object> para) {
     return goodsReturnItemDao.queryByCondition(para);
   }


 }




