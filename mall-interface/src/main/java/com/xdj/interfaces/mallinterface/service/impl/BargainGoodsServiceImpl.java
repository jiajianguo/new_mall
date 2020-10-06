 package com.xdj.interfaces.mallinterface.service.impl;

 import com.xdj.interfaces.mallinterface.mapper.ShoppingBargainGoodsMapper;
 import com.xdj.interfaces.mallinterface.service.IBargainGoodsService;
 import com.xdj.www.entity.ShoppingBargainGoods;
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
 public class BargainGoodsServiceImpl implements IBargainGoodsService{
   @Resource
   private ShoppingBargainGoodsMapper bargainGoodsDao;

   @Override
   @CachePut(cacheNames = "insertBargoods",condition = "#bargainGoods != null")
   public boolean save(ShoppingBargainGoods bargainGoods){
     try
     {
       this.bargainGoodsDao.insert(bargainGoods);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "bargainGoods" ,condition = "#id != null")
   public ShoppingBargainGoods getObjById(Long id)
   {
     ShoppingBargainGoods bargainGoods = this.bargainGoodsDao.selectByPrimaryKey(id);
     if (bargainGoods != null) {
       return bargainGoods;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delbargainGoods",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.bargainGoodsDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsbargainGoods",allEntries = true,beforeInvocation = true,condition = "#bargainGoodsIds != null")
   public boolean batchDelete(List<Long> bargainGoodsIds)
   {
     for (Long id : bargainGoodsIds) {
       delete(id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatebargainGoods",condition = "#bargainGoods != null")
   public boolean update(ShoppingBargainGoods bargainGoods) {
     try {
       this.bargainGoodsDao.updateByPrimaryKey(bargainGoods);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


   @Override
   @Cacheable(cacheNames = "bargainGoodsList")
   public List<ShoppingBargainGoods> list(Map<String, Object> para) {
     return bargainGoodsDao.pageList(para);
   }

   @Override
   @Cacheable(cacheNames = "bargainGoodscount")
   public int count(Map<String, Object> para) {
     return bargainGoodsDao.count(para);
   }

   @Override
   @Cacheable(cacheNames = "bargainGoodscondition")
   public List<ShoppingBargainGoods> queryByCondition(Map<String, Object> para) {
     return bargainGoodsDao.queryByCondition(para);
   }

   @Override
   @Cacheable(cacheNames = "bargainGoodspagelist")
   public List<ShoppingBargainGoods> pageList(Map<String, Object> params) {
     return bargainGoodsDao.pageList(params);
   }


 }




