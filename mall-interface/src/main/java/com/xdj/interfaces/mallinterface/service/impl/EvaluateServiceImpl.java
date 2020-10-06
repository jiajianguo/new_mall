 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingEvaluateMapper;
 import com.xdj.interfaces.mallinterface.service.IEvaluateService;
 import com.xdj.www.entity.ShoppingEvaluateWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Component;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */
 @Service
 public class EvaluateServiceImpl  implements IEvaluateService
 {

   @Resource
   private ShoppingEvaluateMapper evaluateDao;

   @Override
   @CachePut(cacheNames = "insertevaluate",condition = "#evaluate != null")
   public boolean save(ShoppingEvaluateWithBLOBs evaluate)
   {
     try
     {
       this.evaluateDao.insertSelective(evaluate);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable (cacheNames = "evaluate",condition = "#id != null")
   public ShoppingEvaluateWithBLOBs getObjById(Long id)
   {
       ShoppingEvaluateWithBLOBs evaluate = this.evaluateDao.selectByPrimaryKey(id);
     if (evaluate != null) {
       return evaluate;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delevaluate",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.evaluateDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsevaluate",allEntries = true,beforeInvocation = true,condition = "#evaluateIds != null")
   public boolean batchDelete(List<Long> evaluateIds){
     for (Long id : evaluateIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateevaluate",condition = "#evaluate != null")
   public boolean update(ShoppingEvaluateWithBLOBs evaluate) {
     try {
       this.evaluateDao.updateByPrimaryKeyWithBLOBs(evaluate);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "queryevaluate")
   public List<ShoppingEvaluateWithBLOBs> queryByCondition(Map params) {
     return evaluateDao.queryByCondition(params);
   }



   @Override
   @Cacheable(cacheNames = "countevaluate")
   public int count(Map<String, Object> params) {
     return evaluateDao.count(params);
   }

   @Override
   @Cacheable(cacheNames = "msgevaluate")
   public List<ShoppingEvaluateWithBLOBs> queryBySg(Map<String, Object> params) {
     return evaluateDao.queryBySg(params);
   }

   @Override
   @Cacheable(cacheNames = "sgevaluate")
   public int countSg(Map<String, Object> params) {
     return evaluateDao.countSg(params);
   }

   @Override
   @Cacheable(cacheNames = "countsevaluate")
   public int queryCount(Map params) {
     return evaluateDao.queryCount(params);
   }


 }




