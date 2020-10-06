 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingRefundLogMapper;
 import com.xdj.interfaces.mallinterface.service.IRefundLogService;
 import com.xdj.www.entity.ShoppingRefundLog;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class RefundLogServiceImpl  implements IRefundLogService {

   @Resource
   private ShoppingRefundLogMapper refundLogDao;

   @Override
   @CachePut(cacheNames = "insertrflog",condition = "#refundLog != null")
   public boolean save(ShoppingRefundLog refundLog)
   {
     try
     {
       this.refundLogDao.insertSelective(refundLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "rflog",condition = "#id!=null",unless = "#result==null")
   public ShoppingRefundLog getObjById(Long id)
   {
       ShoppingRefundLog refundLog = this.refundLogDao.selectByPrimaryKey(id);
     if (refundLog != null) {
       return refundLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delrflog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.refundLogDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsoflog",allEntries = true,beforeInvocation = true,condition = "#refundLogIds != null")
   public boolean batchDelete(List<Long> refundLogIds)
   {
     for (Long id : refundLogIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updaterflog",condition = "#refundLog != null")
   public boolean update(ShoppingRefundLog refundLog) {
     try {
       this.refundLogDao.updateByPrimaryKeySelective(refundLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionrflog",unless = "#result== null")
   public List<ShoppingRefundLog> queryByCondition(Map<String, Object> params) {
     return refundLogDao.queryByCondition(params);
   }


 }




