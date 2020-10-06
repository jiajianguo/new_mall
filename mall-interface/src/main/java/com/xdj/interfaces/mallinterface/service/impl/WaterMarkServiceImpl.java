 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingWatermarkMapper;
 import com.xdj.interfaces.mallinterface.service.IWaterMarkService;
 import com.xdj.www.entity.ShoppingWatermark;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 @Service
 public class WaterMarkServiceImpl  implements IWaterMarkService
 {

   @Resource
   private ShoppingWatermarkMapper waterMarkDao;

   @Override
   @CachePut(cacheNames = "savewmark",condition = "#waterMark != null")
   public boolean save(ShoppingWatermark waterMark)
   {
     try
     {
       this.waterMarkDao.insertSelective(waterMark);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "wmark",unless = "#result== null")
   public ShoppingWatermark getObjById(Long id)
   {
       ShoppingWatermark waterMark =this.waterMarkDao.selectByPrimaryKey(id);
     if (waterMark != null) {
       return waterMark;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delwmark",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.waterMarkDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delswmark",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean batchDelete(List<Long> waterMarkIds)
   {
     for (Long id : waterMarkIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatewmark",condition = "#waterMark != null")
   public boolean update(ShoppingWatermark waterMark) {
     try {
       this.waterMarkDao.updateByPrimaryKeySelective(waterMark);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




