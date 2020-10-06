 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsclassMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsClassService;
 import com.xdj.www.entity.ShoppingGoodsclassWithBLOBs;
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
 public class GoodsClassServiceImpl  implements IGoodsClassService
 {

   @Resource
   private ShoppingGoodsclassMapper goodsClassDao;

   @Override
   @CachePut(cacheNames = "insertgoodsClass",condition = "#goodsClass != null")
   public boolean save(ShoppingGoodsclassWithBLOBs goodsClass)
   {
     try
     {
       this.goodsClassDao.insertSelective(goodsClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsClass",condition = "#id != null")
   public ShoppingGoodsclassWithBLOBs getObjById(Long id)
   {
       ShoppingGoodsclassWithBLOBs goodsClass = this.goodsClassDao.selectByPrimaryKey(id);
     if (goodsClass != null) {
       return goodsClass;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsClass",allEntries = true,beforeInvocation = true,condition = "#id != null ")
   public boolean delete(Long id) {
     try {
       this.goodsClassDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsClass",allEntries = true,beforeInvocation = true,condition = "#goodsClassIds != null")
   public boolean batchDelete(List<Long> goodsClassIds)
   {
     for (Long id : goodsClassIds) {
       delete(id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updategoodsClass",condition = "#goodsClass != null")
   public boolean update(ShoppingGoodsclassWithBLOBs goodsClass) {
     try {
       this.goodsClassDao.updateByPrimaryKeySelective(goodsClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "pagelistgoodsClass")
   public List<ShoppingGoodsclassWithBLOBs> queryByCondition(Map<String, Object> params) {
     return goodsClassDao.queryByCondition(params);
   }


 }




