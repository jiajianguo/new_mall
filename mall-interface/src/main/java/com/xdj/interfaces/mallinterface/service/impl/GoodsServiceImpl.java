 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsService;
 import com.xdj.www.entity.ShoppingGoods;
 import com.xdj.www.entity.ShoppingGoodsExample;
 import com.xdj.www.entity.ShoppingGoodsWithBLOBs;
 import org.springframework.beans.factory.annotation.Autowired;
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
 @Service("iGoodsService")
 public class GoodsServiceImpl   implements IGoodsService {

   @Resource
   private ShoppingGoodsMapper goodsDao;

   @Override
   @CachePut(cacheNames = "insertgoods",condition = "#goods != null")
   public boolean save(ShoppingGoodsWithBLOBs goods)
   {
     try
     {
       this.goodsDao.insertSelective(goods);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "goods",condition = "#id != null" ,unless = "#result == null")
   public ShoppingGoodsWithBLOBs getObjById(Long id)
   {
       ShoppingGoodsWithBLOBs goods = this.goodsDao.getObjById(id);
     if (goods != null) {
       return goods;
     }
     return null;
   }

   @Override
   @CacheEvict (cacheNames = "delgoods",allEntries = true,beforeInvocation = true,condition = "#id != null ")
   public boolean delete(Long id) {
     try {
       this.goodsDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgoods",allEntries = true,beforeInvocation = true,condition = "#goodsIds != null")
   public boolean batchDelete(List<Long> goodsIds)
   {
     for (Serializable id : goodsIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @Cacheable(cacheNames = "updategoods",condition = "#goods != null")
   public int update(ShoppingGoodsWithBLOBs goods) {
     try {
       return this.goodsDao.updateByPrimaryKeyWithBLOBs(goods);
     } catch (Exception e) {
       e.printStackTrace();
     }
     return 0;
   }


     @Override
     @Cacheable(cacheNames = "countgoods",unless = "#result==null")
     public int count(Map<String,Object> para) {
       return goodsDao.count(para);
     }

     @Override
     @Cacheable(cacheNames = "listgoods",unless = "#result==null")
     public List<ShoppingGoods> list(Map<String, Object> goods) {
         return goodsDao.pageList(goods);
     }

     @Override
     @Cacheable(cacheNames = "conditiongoods",unless = "#result== null")
     public List<ShoppingGoodsWithBLOBs> queryByCondition(Map params) {
         return goodsDao.queryByCondition(params);
     }

     @Override
     @Cacheable(cacheNames = "msggoods",unless = "#result== null")
     public List<ShoppingGoodsWithBLOBs> queryMsg(Map paras) {
         return goodsDao.queryMsg(paras);
     }

     @Override
     @Cacheable(cacheNames = "msgcountgoods",unless = "#result== null")
     public int queryMsgCount(Map paras) {
         return goodsDao.queryMsgCount(paras);
     }

     @Override
     @Cacheable(cacheNames = "combingoods" ,unless = "#result== null")
     public List<ShoppingGoodsWithBLOBs> getCombinGoods(Long id) {
         return goodsDao.getCombinGoods(id);
     }

     @Override
     @Cacheable(cacheNames = "examplegoods",unless = "#result== null")
     public List<ShoppingGoodsWithBLOBs> selectExample(ShoppingGoodsExample ex) {
         return goodsDao.selectByExampleWithBLOBs(ex);
     }

     @Override
     public List<ShoppingGoodsWithBLOBs> pageList(Map params) {
         return goodsDao.pageList(params);
     }


 }




