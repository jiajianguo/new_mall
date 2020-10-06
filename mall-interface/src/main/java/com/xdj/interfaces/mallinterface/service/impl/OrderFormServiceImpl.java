 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingOrderformMapper;
 import com.xdj.interfaces.mallinterface.service.IOrderFormService;
 import com.xdj.www.entity.ShoppingOrderformWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class OrderFormServiceImpl  implements IOrderFormService
 {

   @Resource
   private ShoppingOrderformMapper orderFormDao;

   @Override
   @CachePut(cacheNames = "insertof",condition = "#integralGoodsCart != null")
   public int save(ShoppingOrderformWithBLOBs orderForm)
   {
      return this.orderFormDao.insertSelective(orderForm);
   }

   @Override
   @Cacheable(cacheNames = "of",condition = "#id!=null",unless = "#result==null")
   public ShoppingOrderformWithBLOBs getObjById(Long id)
   {
       ShoppingOrderformWithBLOBs orderForm = this.orderFormDao.selectByPrimaryKey(id);
     if (orderForm != null) {
       return orderForm;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delof",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.orderFormDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsof",allEntries = true,beforeInvocation = true,condition = "#orderFormIds != null")
   public boolean batchDelete(List<Long> orderFormIds)
   {
     for (Long id : orderFormIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateof")
   public boolean update(ShoppingOrderformWithBLOBs orderForm) {
     try {
       this.orderFormDao.updateByPrimaryKeyWithBLOBs(orderForm);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   public List<ShoppingOrderformWithBLOBs> pageList(Map<String, Object> params) {
     return orderFormDao.pageList(params);
   }

   @Override
   public int count(Map<String, Object> params) {
     return orderFormDao.count(params);
   }

     @Override
     public List<ShoppingOrderformWithBLOBs> selectByOrderNo(String s) {
         return orderFormDao.selectByOrderNo(s);
     }


 }




