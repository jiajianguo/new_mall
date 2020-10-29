 package com.xdj.interfaces.mallinterface.service.impl;

 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodscartMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsCartService;

 import com.xdj.www.entity.ShoppingGoodscart;
 import com.xdj.www.entity.ShoppingGoodscartExample;
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
 public class GoodsCartServiceImpl  implements IGoodsCartService
 {

   @Resource
   private ShoppingGoodscartMapper goodsCartDao;

   @Override
   @CachePut(cacheNames = "insertgoodsCart",condition = "#goodsCart != null")
   public boolean save(ShoppingGoodscart goodsCart){
     try{
       this.goodsCartDao.insertSelective(goodsCart);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goodsCart" ,condition = "#id != null " ,unless = "#result == null")
   public ShoppingGoodscart getObjById(Long id)
   {
       ShoppingGoodscart goodsCart =this.goodsCartDao.selectByPrimaryKey(id);
     if (goodsCart != null) {
       return goodsCart;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgoodsCart",allEntries = true,beforeInvocation = true,condition = "#id !=  null")
   public boolean delete(Long id) {
     try {
       this.goodsCartDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoodsCart",allEntries = true,beforeInvocation = true,condition = "#goodsCartIds != null")
   public boolean batchDelete(List<Long> goodsCartIds)
   {
     for (Serializable id : goodsCartIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategoodsCart",condition = "#goodsCart !=  null")
   public int update(ShoppingGoodscart goodsCart) {
     try {
       this.goodsCartDao.updateByPrimaryKeyWithBLOBs(goodsCart);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }


     @Override
     public List<ShoppingGoodscart> queryByCondition(Map params) {
         return goodsCartDao.queryByCondition(params);
     }

     @Override
     public int deleteByScid(Long sc_id) {
         ShoppingGoodscartExample example = new ShoppingGoodscartExample();
         example.createCriteria().andScIdEqualTo(sc_id);
         return goodsCartDao.deleteByExample(example);
     }

     @Override
     public int pageCount(Map<String, Object> params) {
         return goodsCartDao.pageCount(params);
     }

     @Override
     public List<ShoppingGoodscart> pageList(Map<String, Object> params) {
         return goodsCartDao.pageList(params);
     }

     @Override
     public List<ShoppingGoodscart> selectByExample(ShoppingGoodscartExample example) {
         return goodsCartDao.selectByExampleWithBLOBs(example);
     }


 }




