 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingIntegralGoodsorderMapper;
 import com.xdj.interfaces.mallinterface.service.IIntegralGoodsOrderService;
 import com.xdj.www.entity.ShoppingIntegralGoodsorder;
 import com.xdj.www.entity.ShoppingIntegralGoodsorderWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 @Transactional
 public class IntegralGoodsOrderServiceImpl implements IIntegralGoodsOrderService
 {

   @Resource
   private ShoppingIntegralGoodsorderMapper integralGoodsOrderDao;

   @Override
   @CachePut(cacheNames = "insertintegralgo",condition = "#integralGoodsOrder != null")
   public boolean save(ShoppingIntegralGoodsorderWithBLOBs integralGoodsOrder)
   {
     try{
       this.integralGoodsOrderDao.insertSelective(integralGoodsOrder);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "integralgo" ,condition = "#id != null")
   public ShoppingIntegralGoodsorderWithBLOBs getObjById(Long id)
   {
       ShoppingIntegralGoodsorderWithBLOBs integralGoodsOrder =this.integralGoodsOrderDao.selectByPrimaryKey(id);
     if (integralGoodsOrder != null) {
       return integralGoodsOrder;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delintegralgo",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.integralGoodsOrderDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsintegralgo",allEntries = true,beforeInvocation = true,condition = "#integralGoodsOrderIds != null")
   public boolean batchDelete(List<Long> integralGoodsOrderIds)
   {
     for (Long id : integralGoodsOrderIds) {
       delete((Long)id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updateintegralgo")
   public boolean update(ShoppingIntegralGoodsorderWithBLOBs integralGoodsOrder) {
     try {
       this.integralGoodsOrderDao.updateByPrimaryKeyWithBLOBs(integralGoodsOrder);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionintegralgo")
     public List<ShoppingIntegralGoodsorderWithBLOBs> queryByCondition(Map<String, Object> params) {
         return integralGoodsOrderDao.queryByCondition(params);
     }

     @Override
     @Cacheable(cacheNames = "countintegralgo")
     public int pageCount(Map<String, Object> params) {
         return integralGoodsOrderDao.pageCount(params);
     }


 }




