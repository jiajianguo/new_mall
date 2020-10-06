 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsFloorMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsFloorService;
 import com.xdj.www.entity.ShoppingGoodsFloorWithBLOBs;
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
 public class GoodsFloorServiceImpl  implements IGoodsFloorService
 {

   @Resource
   private ShoppingGoodsFloorMapper goodsFloorDao;

   @Override
   @CachePut(cacheNames = "insertgoodsFloor" ,condition = "#goodsFloor != null ")
   public boolean save(ShoppingGoodsFloorWithBLOBs goodsFloor)
   {
     try
     {
       this.goodsFloorDao.insertSelective(goodsFloor);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsFloor",condition = "#id != null")
   public ShoppingGoodsFloorWithBLOBs getObjById(Long id)
   {
       ShoppingGoodsFloorWithBLOBs goodsFloor = this.goodsFloorDao.selectByPrimaryKey(id);
     if (goodsFloor != null) {
       return goodsFloor;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsFloor",allEntries = true,beforeInvocation = true,condition = "#id != null ")
   public boolean delete(Long id) {
     try {
       this.goodsFloorDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsFloor",allEntries = true,beforeInvocation = true,condition = "#goodsFloorIds != null")
   public boolean batchDelete(List<Long> goodsFloorIds)
   {
     for (Long id : goodsFloorIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategoodsFloor",condition = "#goodsFloor != null")
   public boolean update(ShoppingGoodsFloorWithBLOBs goodsFloor) {
     try {
       this.goodsFloorDao.updateByPrimaryKeySelective(goodsFloor);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditiongoodsFloor")
   public List queryByCondition(Map params) {
     return goodsFloorDao.queryByCondition(params);
   }


 }




