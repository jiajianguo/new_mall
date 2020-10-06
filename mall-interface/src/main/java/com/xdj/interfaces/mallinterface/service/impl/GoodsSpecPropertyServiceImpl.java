 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsspecpropertyMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsSpecPropertyService;
 import com.xdj.www.entity.ShoppingGoodsspecproperty;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */
 @Service
 public class GoodsSpecPropertyServiceImpl implements IGoodsSpecPropertyService {

   @Resource
   private ShoppingGoodsspecpropertyMapper goodsSpecPropertyDao;

   @Override
   @CachePut(cacheNames = "insertgoodsSpecProperty",condition = "#goodsSpecProperty != null")
   public boolean save(ShoppingGoodsspecproperty goodsSpecProperty){
     try
     {
       this.goodsSpecPropertyDao.insertSelective(goodsSpecProperty);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsSpecProperty",condition = "#id != null",unless = "#result == null")
   public ShoppingGoodsspecproperty getObjById(Long id)
   {
       ShoppingGoodsspecproperty goodsSpecProperty = this.goodsSpecPropertyDao.selectByPrimaryKey(id);
     if (goodsSpecProperty != null) {
       return goodsSpecProperty;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsSpecProperty",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.goodsSpecPropertyDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsSpecProperty",allEntries = true,beforeInvocation = true,condition = "#goodsSpecPropertyIds != null" )
   public boolean batchDelete(List<Serializable> goodsSpecPropertyIds)
   {
     for (Serializable id : goodsSpecPropertyIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategoodsSpecProperty",condition = "#goodsSpecProperty != null")
   public boolean update(ShoppingGoodsspecproperty goodsSpecProperty) {
     try {
       this.goodsSpecPropertyDao.updateByPrimaryKeySelective(goodsSpecProperty);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditiongoodsSpecProperty",unless = "#result == null")
     public List<ShoppingGoodsspecproperty> queryByConditoin(Map<String, Object> para) {
         return goodsSpecPropertyDao.queryByConditoin(para);
     }

 }




