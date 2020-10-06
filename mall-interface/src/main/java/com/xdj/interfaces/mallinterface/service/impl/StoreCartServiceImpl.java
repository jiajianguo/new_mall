 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingStorecartMapper;
 import com.xdj.interfaces.mallinterface.service.IStoreCartService;
 import com.xdj.www.entity.ShoppingStorecart;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;


 @Service
 public class StoreCartServiceImpl implements IStoreCartService
 {

   @Resource
   private ShoppingStorecartMapper storeCartDao;

   @Override
   @CachePut(cacheNames = "inserstorecart",condition = "#storeCart != null")
   public int save(ShoppingStorecart storeCart)
   {
     try
     {
       this.storeCartDao.insertSelective(storeCart);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @Cacheable(cacheNames = "storecart",condition = "#id!=null",unless = "#result==null")
   public ShoppingStorecart getObjById(Long id)
   {
       ShoppingStorecart storeCart = this.storeCartDao.selectByPrimaryKey(id);
     if (storeCart != null) {
       return storeCart;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsc",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public int delete(Long id) {
     try {
       this.storeCartDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }
     return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delssc",allEntries = true,beforeInvocation = true,condition = "#storeCartIds != null")
   public int batchDelete(List<Long> storeCartIds)
   {
     for (Serializable id : storeCartIds) {
       delete((Long)id);
     }
     return 1;
   }



   @Override
   @CachePut(cacheNames = "updatestorecart",unless = "#result == null")
   public int update(ShoppingStorecart storeCart) {
     try {
       this.storeCartDao.updateByPrimaryKeySelective(storeCart);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

     @Override
     public List<ShoppingStorecart> queryByCondition(Map params) {
         return storeCartDao.queryByCondition(params);
     }

     @Override
     public List<ShoppingStorecart> queryCookiecart(Map params) {
         return storeCartDao.queryCookiecart(params);
     }


 }




