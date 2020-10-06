 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingPredepositMapper;
 import com.xdj.interfaces.mallinterface.service.IPredepositService;
 import com.xdj.www.entity.ShoppingPredepositWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class PredepositServiceImpl  implements IPredepositService
 {

   @Resource
   private ShoppingPredepositMapper predepositDao;

   @Override
   @CachePut(cacheNames = "insertpp",condition = "#predeposit != null")
   public int save(ShoppingPredepositWithBLOBs predeposit)
   {
     try
     {
       return this.predepositDao.insertSelective(predeposit);
     } catch (Exception e) {
       e.printStackTrace();
     }
     return 0;
   }

   @Override
   @Cacheable(cacheNames = "pp",condition = "#id!=null",unless = "#result==null")
   public ShoppingPredepositWithBLOBs getObjById(Long id)
   {
       ShoppingPredepositWithBLOBs predeposit = this.predepositDao.selectByPrimaryKey(id);
     if (predeposit != null) {
       return predeposit;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delpp",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.predepositDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delspp",allEntries = true,beforeInvocation = true,condition = "#predepositIds != null")
   public boolean batchDelete(List<Long> predepositIds)
   {
     for (Long id : predepositIds) {
       delete(id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatepp",condition = "#predeposit != null")
   public boolean update(ShoppingPredepositWithBLOBs predeposit) {
     try {
       this.predepositDao.updateByPrimaryKeySelective(predeposit);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "updatepp",unless = "#result== null")
   public List<ShoppingPredepositWithBLOBs> queryByCondition(Map<String, Object> map) {
     return predepositDao.queryByCondition(map);
   }

   @Override
   @Cacheable(cacheNames = "countpp",unless = "#result == null")
   public int count(Map<String, Object> map) {
     return predepositDao.count(map);
   }

 }




