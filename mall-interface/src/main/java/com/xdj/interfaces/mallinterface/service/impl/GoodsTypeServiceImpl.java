 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodstypeMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsTypeService;
 import com.xdj.www.entity.ShoppingGoodstype;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;

 /**
  *
  * @author Administrator
  */
 @Service
 public class GoodsTypeServiceImpl implements IGoodsTypeService {

   @Resource
   private ShoppingGoodstypeMapper goodsTypeDao;

   @Override
   @CachePut(cacheNames = "insertgoodsType",condition = "#goodsType != null")
   public boolean save(ShoppingGoodstype goodsType)
   {
     try
     {
       this.goodsTypeDao.insertSelective(goodsType);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsType",condition = "#id != null",unless = "#result==null")
   public ShoppingGoodstype getObjById(Long id)
   {
       ShoppingGoodstype goodsType =this.goodsTypeDao.selectByPrimaryKey(id);
     if (goodsType != null) {
       return goodsType;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsType",allEntries = true,beforeInvocation = true,condition = "#id != null ")
   public boolean delete(Long id) {
     try {
       this.goodsTypeDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsType",allEntries = true,beforeInvocation = true,condition = "#goodsTypeIds != null ")
   public boolean batchDelete(List<Long> goodsTypeIds){
     for (Long id : goodsTypeIds) {
       delete(id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updategoodsType",condition = "#goodsType != null")
   public boolean update(ShoppingGoodstype goodsType) {
     try {
       this.goodsTypeDao.updateByPrimaryKeySelective(goodsType);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




