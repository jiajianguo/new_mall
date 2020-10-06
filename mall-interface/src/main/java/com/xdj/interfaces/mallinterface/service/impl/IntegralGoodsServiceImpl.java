 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingIntegralGoodsMapper;
 import com.xdj.interfaces.mallinterface.service.IIntegralGoodsService;
 import com.xdj.www.entity.ShoppingIntegralGoods;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class IntegralGoodsServiceImpl implements IIntegralGoodsService
 {

   @Resource
   private ShoppingIntegralGoodsMapper integralGoodsDao;

   @Override
   @CachePut(cacheNames = "insertintergralgc",condition = "#integralGoodsCart != null")
   public boolean save(ShoppingIntegralGoods integralGoods)
   {
     try
     {
       this.integralGoodsDao.insertSelective(integralGoods);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "integralgoods" ,condition = "#id != null",unless = "#result==null")
   public ShoppingIntegralGoods getObjById(Long id)
   {
       ShoppingIntegralGoods integralGoods = this.integralGoodsDao.selectByPrimaryKey(id);
     if (integralGoods != null) {
       return integralGoods;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delintegralgoods",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.integralGoodsDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsintegralgoods",allEntries = true,beforeInvocation = true,condition = "#integralGoodsIds != null")
   public boolean batchDelete(List<Long> integralGoodsIds)
   {
     for (Long id : integralGoodsIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateintegralgoods")
   public boolean update(ShoppingIntegralGoods integralGoods) {
     try {
       this.integralGoodsDao.updateByPrimaryKeySelective(integralGoods);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionintegralgoods",unless = "#result==null")
     public List<ShoppingIntegralGoods> queryByCondition(Map params) {
         return integralGoodsDao.queryByCondition(params);
     }


 }




