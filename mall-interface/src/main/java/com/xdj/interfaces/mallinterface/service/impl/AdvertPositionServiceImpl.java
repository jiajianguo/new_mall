 package com.xdj.interfaces.mallinterface.service.impl;




 import com.xdj.interfaces.mallinterface.mapper.ShoppingAdvPosMapper;

 import com.xdj.interfaces.mallinterface.service.IAdvertPositionService;

 import com.xdj.www.entity.ShoppingAdvPosExample;
 import com.xdj.www.entity.ShoppingAdvPosWithBLOBs;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;


 import javax.annotation.Resource;
 import java.util.List;


 /**
  * 广告位置
  * @author Administrator
  */
 @Service
 public class AdvertPositionServiceImpl implements IAdvertPositionService {

   @Resource
   private ShoppingAdvPosMapper shoppingAdvPosMapper;

   @Override
   @CachePut(cacheNames = "insertAdvpos",condition = "#advertPosition != null", unless = "#result>0")
   public boolean save(ShoppingAdvPosWithBLOBs advertPosition)
   {
     try
     {
       this.shoppingAdvPosMapper.insert(advertPosition);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "advpos",condition = "#id != null",unless = "#result== null")
   public ShoppingAdvPosWithBLOBs getObjById(Long id)
   {
       ShoppingAdvPosWithBLOBs advertPosition =this.shoppingAdvPosMapper.selectByPrimaryKey(id);
     if (advertPosition != null) {
       return advertPosition;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "deladvpos",allEntries = true,beforeInvocation = true,condition ="#id >0")
   public boolean delete(Long id) {
     try {
       this.shoppingAdvPosMapper.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsadvpos",allEntries = true,beforeInvocation = true,condition ="#id >0")
   public boolean batchDelete(List<Long> advertPositionIds)
   {
     for (Long id : advertPositionIds) {
       delete(id);
     }
     return true;
   }

     @Override
     public List<ShoppingAdvPosWithBLOBs> selectExample(ShoppingAdvPosExample ex) {
         return shoppingAdvPosMapper.selectByExampleWithBLOBs(ex);
     }


 }




