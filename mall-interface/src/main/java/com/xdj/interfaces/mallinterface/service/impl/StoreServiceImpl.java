 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingStoreMapper;
 import com.xdj.interfaces.mallinterface.service.IStoreService;
 import com.xdj.www.entity.ShoppingStore;
 import com.xdj.www.entity.ShoppingStoreExample;
 import com.xdj.www.entity.ShoppingStoreWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 public class StoreServiceImpl implements IStoreService {

   @Resource
   private ShoppingStoreMapper storeDao;

   @Override
   @CachePut(cacheNames = "insertstore",condition = "#store != null")
   public boolean save(ShoppingStoreWithBLOBs store)
   {
     try
     {
       this.storeDao.insertSelective(store);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "store",unless = "#result== null")
   public ShoppingStoreWithBLOBs getObjById(Long id)
   {
     ShoppingStoreWithBLOBs store =this.storeDao.selectByPrimaryKey(id);
     if (store != null) {
       return store;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delstore",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.storeDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsstore",allEntries = true,beforeInvocation = true,condition = "#storeIds != null")
   public boolean batchDelete(List<Long> storeIds)
   {
     for (Serializable id : storeIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatestore",condition = "#store != null")
   public boolean update(ShoppingStoreWithBLOBs store) {
     try {
       this.storeDao.updateByPrimaryKeySelective(store);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "querystore",unless = "#result == null")
   public ShoppingStoreWithBLOBs queryOne(Map<String, Object> map) {
     return storeDao.queryOne(map);
   }

   @Override
   @Cacheable(cacheNames = "getstore",unless = "#result == null")
   public ShoppingStoreWithBLOBs getOne(Map params) {
     return storeDao.queryOne(params);
   }

   @Override
   @Cacheable(cacheNames = "conditionstore",unless = "#result= null")
   public List queryByCondition(Map params) {
     return storeDao.queryByCondition(params);
   }

   @Override
   @Cacheable(cacheNames = "selectstore",unless = "#result == null")
   public List<ShoppingStoreWithBLOBs> selectByExample(ShoppingStoreExample example) {
     return storeDao.selectByExample(example);
   }

   @Override
   @Cacheable(cacheNames = "pagelstore",unless = "#result == null")
   public List<ShoppingStoreWithBLOBs> pageList(Map<String, Object> params) {
     return storeDao.pageList(params);
   }

   @Override
   @Cacheable(cacheNames = "countstore",unless = "#result == null")
   public int count(Map<String, Object> params) {
     return storeDao.count(params);
   }


 }




