 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingUsergoodsclassMapper;
 import com.xdj.interfaces.mallinterface.service.IUserGoodsClassService;
 import com.xdj.www.entity.ShoppingUsergoodsclass;
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
 @Service("iUserGoodsClassService")
 public class UserGoodsClassServiceImpl implements IUserGoodsClassService
 {

   @Resource
   private ShoppingUsergoodsclassMapper userGoodsClassDao;

   @Override
   @CachePut(cacheNames = "saveugc",condition = "#userGoodsClass != null")
   public boolean save(ShoppingUsergoodsclass userGoodsClass)
   {
     try
     {
       this.userGoodsClassDao.insertSelective(userGoodsClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "ugc",unless = "#result== null")
   public ShoppingUsergoodsclass getObjById(Long id)
   {
     ShoppingUsergoodsclass userGoodsClass = this.userGoodsClassDao.selectByPrimaryKey(id);
     if (userGoodsClass != null) {
       return userGoodsClass;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delugc",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.userGoodsClassDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsugc",allEntries = true,beforeInvocation = true,condition = "#userGoodsClassIds != null")
   public boolean batchDelete(List<Long> userGoodsClassIds)
   {
     for (Long id : userGoodsClassIds) {
       delete(id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updateugc",condition = "#userGoodsClass != null")
   public boolean update(ShoppingUsergoodsclass userGoodsClass) {
     try {
       this.userGoodsClassDao.updateByPrimaryKeySelective(userGoodsClass);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionugc",unless = "#result == null")
   public List queryByCondition(Map map) {
     return userGoodsClassDao.queryByCondition(map);
   }


 }




