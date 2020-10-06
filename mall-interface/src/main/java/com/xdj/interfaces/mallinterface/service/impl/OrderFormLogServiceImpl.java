 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingOrderLogMapper;
 import com.xdj.interfaces.mallinterface.service.IOrderFormLogService;
 import com.xdj.www.entity.ShoppingOrderLog;
 import com.xdj.www.entity.ShoppingOrderLogExample;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class OrderFormLogServiceImpl  implements IOrderFormLogService {

   @Resource
   private ShoppingOrderLogMapper orderFormLogDao;

   @Override
   @CachePut(cacheNames = "insertoflog",condition = "#orderFormLog != null")
   public boolean save(ShoppingOrderLog orderFormLog)
   {
     try
     {
       this.orderFormLogDao.insertSelective(orderFormLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }
     @Override
     @Cacheable(cacheNames = "oflog",condition = "#id!=null",unless = "#result==null")
   public ShoppingOrderLog getObjById(Long id)
   {
       ShoppingOrderLog orderFormLog = this.orderFormLogDao.selectByPrimaryKey(id);
     if (orderFormLog != null) {
       return orderFormLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deloflog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.orderFormLogDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }
     @Override
     @CacheEvict(cacheNames = "delsoflogs",allEntries = true,beforeInvocation = true,condition = "#orderFormLogIds != null")
   public boolean batchDelete(List<Long> orderFormLogIds)
   {
     for (Long id : orderFormLogIds) {
       delete((Long)id);
     }
     return true;
   }

     @Override
     @CachePut(cacheNames = "updateoflog")
   public boolean update(ShoppingOrderLog orderFormLog) {
     try {
       this.orderFormLogDao.updateByPrimaryKeySelective(orderFormLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionoflog",unless = "#result==null")
   public List<ShoppingOrderLog> queryByCondition(Map<String, Object> params) {
     return orderFormLogDao.queryByCondition(params);
   }

   @Override
   public int deleteByOfid(Long id) {
     ShoppingOrderLogExample ex = new ShoppingOrderLogExample();
     ex.createCriteria()
             .andOfIdEqualTo(id);
     return orderFormLogDao.deleteByExample(ex);
   }

 }




