 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingZtcGoldLogMapper;
 import com.xdj.interfaces.mallinterface.service.IZTCGoldLogService;
 import com.xdj.www.entity.ShoppingZtcGoldLog;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;

 @Service
 public class ZTCGoldLogServiceImpl  implements IZTCGoldLogService
 {

   @Resource
   private ShoppingZtcGoldLogMapper zTCGlodLogDao;

   @Override
   @CachePut(cacheNames = "saveztcglog",condition = "#zTCGlodLog != null")
   public boolean save(ShoppingZtcGoldLog zTCGlodLog)
   {
     try
     {
       this.zTCGlodLogDao.insertSelective(zTCGlodLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "ztcglog",unless = "#result== null")
   public ShoppingZtcGoldLog getObjById(Long id)
   {
       ShoppingZtcGoldLog zTCGlodLog =this.zTCGlodLogDao.selectByPrimaryKey(id);
     if (zTCGlodLog != null) {
       return zTCGlodLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delztcglog",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.zTCGlodLogDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsztcglog",allEntries = true,beforeInvocation = true,condition = "#zTCGlodLogIds != null")
   public boolean batchDelete(List<Long> zTCGlodLogIds)
   {
     for (Serializable id : zTCGlodLogIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updateztcglog",condition = "#zTCGlodLog != null")
   public boolean update(ShoppingZtcGoldLog zTCGlodLog) {
     try {
       this.zTCGlodLogDao.updateByPrimaryKeySelective(zTCGlodLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




