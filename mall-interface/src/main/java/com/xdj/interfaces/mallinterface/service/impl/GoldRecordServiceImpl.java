 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoldRecordMapper;
 import com.xdj.interfaces.mallinterface.service.IGoldRecordService;
 import com.xdj.www.entity.ShoppingGoldRecordWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;

 /**
  * @author Administrator
  */
 @Service
 public class GoldRecordServiceImpl implements IGoldRecordService {

   @Resource
   private ShoppingGoldRecordMapper goldRecordDao;

   @Override
   @CachePut(cacheNames = "insertgoldRecord",condition = "#goldRecord !=  null")
   public boolean save(ShoppingGoldRecordWithBLOBs goldRecord)
   {
     try
     {
       this.goldRecordDao.insertSelective(goldRecord);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goldRecord",condition = "#id != null",unless = "#result==null")
   public ShoppingGoldRecordWithBLOBs getObjById(Long id)
   {
       ShoppingGoldRecordWithBLOBs goldRecord = this.goldRecordDao.selectByPrimaryKey(id);
     if (goldRecord != null) {
       return goldRecord;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoldRecord",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.goldRecordDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoldRecord",allEntries = true,beforeInvocation = true,condition = "#goldRecordIds != null")
   public boolean batchDelete(List<Long> goldRecordIds)
   {
     for (Long id : goldRecordIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategoldRecordIds",condition = "#goldRecordIds != null")
   public boolean update(ShoppingGoldRecordWithBLOBs goldRecord) {
     try {
       this.goldRecordDao.updateByPrimaryKeySelective(goldRecord);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




