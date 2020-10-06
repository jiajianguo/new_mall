 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingStoreSlideMapper;
 import com.xdj.interfaces.mallinterface.service.IStoreSlideService;
 import com.xdj.www.entity.ShoppingStoreSlide;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 @Service
 public class StoreSlideServiceImpl implements IStoreSlideService
 {

   @Resource
   private ShoppingStoreSlideMapper storeSlideDao;

   @Override
   @CachePut(cacheNames = "savesslide",condition = "#storeSlide != null")
   public boolean save(ShoppingStoreSlide storeSlide)
   {
     try
     {
       this.storeSlideDao.insertSelective(storeSlide);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "sslide",unless = "#result== null")
   public ShoppingStoreSlide getObjById(Long id)
   {
       ShoppingStoreSlide storeSlide = this.storeSlideDao.selectByPrimaryKey(id);
     if (storeSlide != null) {
       return storeSlide;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delsslide",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.storeSlideDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delssslide",allEntries = true,beforeInvocation = true,condition = "#storeSlideIds != null")
   public boolean batchDelete(List<Serializable> storeSlideIds)
   {
     for (Serializable id : storeSlideIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatesslide",condition = "#storeSlide != null")
   public boolean update(ShoppingStoreSlide storeSlide) {
     try {
       this.storeSlideDao.updateByPrimaryKeySelective(storeSlide);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionsslide",unless = "#result == null")
     public List<ShoppingStoreSlide> queryByCondition(Map<String, Object> params) {
         return storeSlideDao.queryByCondition(params);
     }


 }




