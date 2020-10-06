 package com.xdj.interfaces.mallinterface.service.impl;

 import com.xdj.interfaces.mallinterface.mapper.ShoppingStoreNavMapper;
 import com.xdj.interfaces.mallinterface.service.IStoreNavigationService;
 import com.xdj.www.entity.ShoppingStoreNav;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 @Transactional
 public class StoreNavigationServiceImpl implements IStoreNavigationService
 {

   @Resource
   private ShoppingStoreNavMapper storeNavigationDao;

   @Override
   @CachePut(cacheNames = "insertstorenav",condition = "#storeNavigation != null")
   public boolean save(ShoppingStoreNav storeNavigation)
   {
     try
     {
       this.storeNavigationDao.insertSelective(storeNavigation);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "storenav",condition = "#id!=null",unless = "#result==null")
   public ShoppingStoreNav getObjById(Long id)
   {
       ShoppingStoreNav storeNavigation = this.storeNavigationDao.selectByPrimaryKey(id);
     if (storeNavigation != null) {
       return storeNavigation;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delstorenav",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.storeNavigationDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsstorenav",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean batchDelete(List<Long> storeNavigationIds)
   {
     for (Serializable id : storeNavigationIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatestorenav",condition = "#storeNavigation != null")
   public boolean update(ShoppingStoreNav storeNavigation) {
     try {
       this.storeNavigationDao.updateByPrimaryKeySelective(storeNavigation);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionstorenav",unless = "#result== null")
     public List<ShoppingStoreNav> queryByCondition(Map params) {
         return storeNavigationDao.queryByCondition(params);
     }

 }




