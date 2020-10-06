 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingPredepositCashMapper;
 import com.xdj.interfaces.mallinterface.service.IPredepositCashService;
 import com.xdj.www.entity.ShoppingPredepositCashWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */
 @Service
 public class PredepositCashServiceImpl implements IPredepositCashService
 {

   @Resource
   private ShoppingPredepositCashMapper predepositCashDao;

   @Override
   @CachePut(cacheNames = "insertppcash",condition = "#predepositCash != null")
   public boolean save(ShoppingPredepositCashWithBLOBs predepositCash)
   {
     try
     {
       this.predepositCashDao.insertSelective(predepositCash);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "ppcash",condition = "#id!=null",unless = "#result==null")
   public ShoppingPredepositCashWithBLOBs getObjById(Long id)
   {
       ShoppingPredepositCashWithBLOBs predepositCash = this.predepositCashDao.selectByPrimaryKey(id);
     if (predepositCash != null) {
       return predepositCash;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delppcash",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.predepositCashDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsppcash",allEntries = true,beforeInvocation = true,condition = "#predepositCashIds != null")
   public boolean batchDelete(List<Long> predepositCashIds)
   {
     for (Serializable id : predepositCashIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateppcsh",condition = "#predepositCash != null")
   public boolean update(ShoppingPredepositCashWithBLOBs predepositCash) {
     try {
       this.predepositCashDao.updateByPrimaryKeySelective(predepositCash);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionppcash",unless = "#result==null")
     public List<ShoppingPredepositCashWithBLOBs> queryByCondition(Map<String, Object> map) {
         return predepositCashDao.queryByCondition(map);
     }

     @Override
     @Cacheable(cacheNames = "countppcash",unless = "result==null")
     public int count(Map<String, Object> map) {
         return predepositCashDao.count(map);
     }

 }




