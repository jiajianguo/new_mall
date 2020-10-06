 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingDeliveryGoodsMapper;
 import com.xdj.interfaces.mallinterface.service.IDeliveryGoodsService;
 import com.xdj.www.entity.ShoppingDeliveryGoods;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class DeliveryGoodsServiceImpl  implements IDeliveryGoodsService
 {

   @Resource
   private ShoppingDeliveryGoodsMapper deliveryGoodsDao;

   @Override
   @CachePut(cacheNames = "insertdeliveryGoods",condition = "#deliveryGoods != null",unless = "#result== null")
   public int save(ShoppingDeliveryGoods deliveryGoods)
   {
     try
     {
       this.deliveryGoodsDao.insert(deliveryGoods);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @Cacheable(cacheNames = "deliveryGoods",condition = "#id != null ")
   public ShoppingDeliveryGoods getObjById(Long id)
   {
       ShoppingDeliveryGoods deliveryGoods = this.deliveryGoodsDao.selectByPrimaryKey(id);
     if (deliveryGoods != null) {
       return deliveryGoods;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deldeliveryGoods",allEntries = true,beforeInvocation = true,condition = "#id != null ")
   public int delete(Long id) {
     try {
       this.deliveryGoodsDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delsdeliveryGoods",allEntries = true,beforeInvocation = true,condition = "#deliveryGoodsIds != null")
   public int batchDelete(List<Long> deliveryGoodsIds)
   {
     for (Long id : deliveryGoodsIds) {
       delete(id);
     }
     return 1;
   }



   @Override
   @CachePut(cacheNames = "updatedeliveryGoods",condition = "#deliveryGoods != null")
   public int update(ShoppingDeliveryGoods deliveryGoods) {
     try {
       this.deliveryGoodsDao.updateByPrimaryKeySelective(deliveryGoods);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

     @Override
     @Cacheable(cacheNames = "querydeliveryGoods",unless = "#result== null")
     public List<ShoppingDeliveryGoods> queryByCondition(Map params) {
         return deliveryGoodsDao.queryByCondition(params);
     }

     @Override
     @Cacheable(cacheNames = "querydeliveryGoodsid",unless = "#result== null")
     public ShoppingDeliveryGoods queryByGoodsId(Long goodsId) {
         return deliveryGoodsDao.queryByGoodsId(goodsId);
     }

     @Override
     @Cacheable(cacheNames = "pagelistdeliveryGoods",unless = "#result== null")
     public List<ShoppingDeliveryGoods> pageList(Map<String, Object> params) {
         return deliveryGoodsDao.pageList(params);
     }

     @Override
     @Cacheable(cacheNames = "countdeliveryGoods",unless = "#result== null")
     public int count(Map<String, Object> params) {
         return deliveryGoodsDao.count(params);
     }


 }




