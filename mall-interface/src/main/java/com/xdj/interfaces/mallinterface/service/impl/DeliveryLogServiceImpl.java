 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingDeliveryLogMapper;
 import com.xdj.interfaces.mallinterface.service.IDeliveryLogService;
 import com.xdj.www.entity.ShoppingDeliveryLog;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;

 /**
  * @author Administrator
  */
 @Service
 public class DeliveryLogServiceImpl implements IDeliveryLogService {

   @Resource
   private ShoppingDeliveryLogMapper deliveryLogDao;

   @Override
   @CachePut(cacheNames = "insertdeliveryLog",condition = "#deliveryLog != null")
   public boolean save(ShoppingDeliveryLog deliveryLog)
   {
     try
     {
       this.deliveryLogDao.insertSelective(deliveryLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "deliveryLog",condition = "#id != null",unless = "#result==null")
   public ShoppingDeliveryLog getObjById(Long id)
   {
       ShoppingDeliveryLog deliveryLog = this.deliveryLogDao.selectByPrimaryKey(id);
     if (deliveryLog != null) {
       return deliveryLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deldeliveryLog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.deliveryLogDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsdeliveryLog",allEntries = true,beforeInvocation = true,condition = "#deliveryLogIds != null")
   public boolean batchDelete(List<Long> deliveryLogIds)
   {
     for (Long id : deliveryLogIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatedeliveryLog",condition = "#deliveryLog != null ")
   public boolean update(ShoppingDeliveryLog deliveryLog) {
     try {
       this.deliveryLogDao.updateByPrimaryKeySelective(deliveryLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




