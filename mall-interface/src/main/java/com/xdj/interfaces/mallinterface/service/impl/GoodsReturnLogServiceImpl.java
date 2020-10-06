 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsReturnlogMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsReturnLogService;
 import com.xdj.www.entity.ShoppingGoodsReturnlog;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */
 @Service
 public class GoodsReturnLogServiceImpl implements IGoodsReturnLogService{

   @Resource
   private ShoppingGoodsReturnlogMapper goodsReturnLogDao;

   @Override
   @CachePut(cacheNames = "goodsReturnLog" ,condition = "#goodsReturnLog != null")
   public boolean save(ShoppingGoodsReturnlog goodsReturnLog)
   {
     try
     {
       this.goodsReturnLogDao.insertSelective(goodsReturnLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsReturnLog",condition = "#id != null",unless = "#result==null")
   public ShoppingGoodsReturnlog getObjById(Long id)
   {
       ShoppingGoodsReturnlog goodsReturnLog = this.goodsReturnLogDao.selectByPrimaryKey(id);
     if (goodsReturnLog != null) {
       return goodsReturnLog;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsReturnLog",condition = "#id != null",allEntries = true,beforeInvocation = true)
   public boolean delete(Long id) {
     try {
       this.goodsReturnLogDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsReturnLog",condition = "#goodsReturnLogIds != null",allEntries = true,beforeInvocation = true)
   public boolean batchDelete(List<Long> goodsReturnLogIds)
   {
     for (Long id : goodsReturnLogIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategoodsReturnLog",condition = "#goodsReturnLog != null")
   public boolean update(ShoppingGoodsReturnlog goodsReturnLog) {
     try {
       this.goodsReturnLogDao.updateByPrimaryKeySelective(goodsReturnLog);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "goodsReturnLogs",unless = "#result==null")
     public List<ShoppingGoodsReturnlog> queryByCondition(Map<String, Object> params) {
         return goodsReturnLogDao.queryByCondition(params);
     }


 }




