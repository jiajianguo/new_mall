 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGroupGoodsMapper;
 import com.xdj.interfaces.mallinterface.service.IGroupGoodsService;
 import com.xdj.www.entity.ShoppingGroupGoods;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */

 @Service
 public class GroupGoodsServiceImpl implements IGroupGoodsService
 {

   @Resource
   private ShoppingGroupGoodsMapper groupGoodsDao;

   @Override
   @CachePut(cacheNames = "insertgroupGoods",condition = "#groupGoods != null ")
   public boolean save(ShoppingGroupGoods groupGoods){
     try
     {
       this.groupGoodsDao.insertSelective(groupGoods);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "groupGoods",condition = "#id != null " ,unless = "#result==null")
   public ShoppingGroupGoods getObjById(Long id)
   {
       ShoppingGroupGoods groupGoods =this.groupGoodsDao.selectByPrimaryKey(id);
     if (groupGoods != null) {
       return groupGoods;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgroupGoods",condition = "#id != null" ,allEntries = true,beforeInvocation = true)
   public boolean delete(Long id) {
     try {
       this.groupGoodsDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgroupGoods",condition = "#groupGoodsIds != null ",allEntries = true,beforeInvocation = true)
   public boolean batchDelete(List<Long> groupGoodsIds)
   {
     for (Long id : groupGoodsIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategroupGoods",condition = "#groupGoods !=  null ")
   public boolean update(ShoppingGroupGoods groupGoods) {
     try {
       this.groupGoodsDao.updateByPrimaryKeySelective(groupGoods);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditiongroupGoods",unless = "#result==null")
     public List<ShoppingGroupGoods> queryByCondition(Map params) {
         return groupGoodsDao.queryByCondition(params);
     }

     @Override
     @Cacheable(cacheNames = "coountgroupGoods",unless = "#result==null")
     public int count(Map params) {
         return  groupGoodsDao.count(params);
     }


 }




