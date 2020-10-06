 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsReturnMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsReturnService;
 import com.xdj.www.entity.ShoppingGoodsReturn;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 /**
  * @author Administrator
  */
 @Service
 public class GoodsReturnServiceImpl  implements IGoodsReturnService
 {

   @Resource
   private ShoppingGoodsReturnMapper goodsReturnDao;

   @Override
   @CachePut(cacheNames = "insertgoodsReturn",condition = "#goodsReturn != null")
   public boolean save(ShoppingGoodsReturn goodsReturn)
   {
     try
     {
       this.goodsReturnDao.insertSelective(goodsReturn);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsReturn",condition = "#id != null",unless = "#result==null")
   public ShoppingGoodsReturn getObjById(Long id)
   {
       ShoppingGoodsReturn goodsReturn = this.goodsReturnDao.selectByPrimaryKey(id);
     if (goodsReturn != null) {
       return goodsReturn;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsReturn",allEntries = true,beforeInvocation = true,condition = "id != null")
   public boolean delete(Long id) {
     try {
       this.goodsReturnDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsReturn",allEntries = true,beforeInvocation = true,condition = "#goodsReturnIds !=  null")
   public boolean batchDelete(List<Long> goodsReturnIds)
   {
     for (Long id : goodsReturnIds) {
       delete((Long)id);
     }
     return true;
   }


   @Override
   @Cacheable(cacheNames = "updategoodsReturn")
   public boolean update(ShoppingGoodsReturn goodsReturn) {
     try {
       this.goodsReturnDao.updateByPrimaryKeySelective(goodsReturn);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




