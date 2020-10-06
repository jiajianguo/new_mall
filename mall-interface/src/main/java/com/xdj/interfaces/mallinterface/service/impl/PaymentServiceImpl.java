 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingPaymentMapper;
 import com.xdj.interfaces.mallinterface.service.IPaymentService;
 import com.xdj.www.entity.ShoppingPaymentWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class PaymentServiceImpl implements IPaymentService
 {

   @Resource
   private ShoppingPaymentMapper paymentDao;

   @Override
   @CachePut(cacheNames = "insertpayment",condition = "#payment != null")
   public boolean save(ShoppingPaymentWithBLOBs payment)
   {
     try
     {
       this.paymentDao.insertSelective(payment);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "payment",condition = "#id!=null",unless = "#result==null")
   public ShoppingPaymentWithBLOBs getObjById(Long id)
   {
       ShoppingPaymentWithBLOBs payment = this.paymentDao.selectByPrimaryKey(id);
     if (payment != null) {
       return payment;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delpayment",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.paymentDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delspayment",allEntries = true,beforeInvocation = true,condition = "#paymentIds != null")
   public boolean batchDelete(List<Long> paymentIds)
   {
     for (Long id : paymentIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatepayment")
   public boolean update(ShoppingPaymentWithBLOBs payment) {
     try {
       this.paymentDao.updateByPrimaryKeyWithBLOBs(payment);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionpayment",unless = "#result==null")
   public List queryByCondition(Map params) {
     return paymentDao.queryByCondition(params);
   }


 }




