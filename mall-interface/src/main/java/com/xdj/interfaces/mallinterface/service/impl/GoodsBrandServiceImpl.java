 package com.xdj.interfaces.mallinterface.service.impl;



 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsbrandMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsBrandService;
 import com.xdj.www.entity.ShoppingGoodsbrand;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */
 @Service
 @Transactional
 public class GoodsBrandServiceImpl implements IGoodsBrandService
 {

   @Resource
   private ShoppingGoodsbrandMapper goodsBrandDao;

   @Override
   @CachePut(cacheNames = "insertgoodsBrand",condition = "#goodsBrand != null")
   public boolean save(ShoppingGoodsbrand goodsBrand)
   {
     try{
       this.goodsBrandDao.insertSelective(goodsBrand);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsBrand",condition = "#id != null",unless = "#result == null")
   public ShoppingGoodsbrand getObjById(Long id) {
       ShoppingGoodsbrand goodsBrand = this.goodsBrandDao.selectByPrimaryKey(id);
       if (goodsBrand != null) {
        return goodsBrand;
      }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsBrand",allEntries = true,beforeInvocation = true,condition = "#id !=  null ")
   public boolean delete(Long id) {
     try {
       this.goodsBrandDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames ="delsgoodsBrand" ,allEntries = true, beforeInvocation = true,condition = "#goodsBrandIds !=  null")
   public boolean batchDelete(List<Serializable> goodsBrandIds)
   {
     for (Serializable id : goodsBrandIds) {
       delete((Long)id);
     }
     return true;
   }

     @Override
     @CachePut(cacheNames = "paramGoodsBrand",condition = "#paramGoodsBrand != null")
     public int update(ShoppingGoodsbrand paramGoodsBrand) {

       return goodsBrandDao.updateByPrimaryKey(paramGoodsBrand);
     }

     @Override
     @Cacheable(cacheNames = "queryparamGoodsBrand",unless = "#result==null")
     public List<ShoppingGoodsbrand> queryByCondition(Map<String, Object> para) {
         return goodsBrandDao.queryByCondition(para);
     }


 }




