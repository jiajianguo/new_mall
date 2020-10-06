 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGroupMapper;
 import com.xdj.interfaces.mallinterface.service.IGroupService;
 import com.xdj.www.entity.ShoppingGroup;
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
 public class GroupServiceImpl implements IGroupService
 {

   @Resource
   private ShoppingGroupMapper groupDao;

   @Override
   @CachePut(cacheNames = "insertgroup",condition = "#group != null")
   public boolean save(ShoppingGroup group)
   {
     try
     {
       this.groupDao.insertSelective(group);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "group",condition = "#id != null ")
   public ShoppingGroup getObjById(Long id)
   {
       ShoppingGroup group =groupDao.selectByPrimaryKey(id);
     if (group != null) {
       return group;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delgroup",allEntries = true,beforeInvocation = true,condition = "#id != null ")
   public boolean delete(Long id) {
     try {
       this.groupDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsgroup",allEntries = true,beforeInvocation = true,condition = "#groupIds != null")
   public boolean batchDelete(List<Long> groupIds)
   {
     for (long id : groupIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updategroup",condition = "#group != null ")
   public boolean update(ShoppingGroup group) {
     try {
       this.groupDao.updateByPrimaryKeySelective(group);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditiongroup")
   public List<ShoppingGroup> queryByCondition(Map params) {
     return groupDao.queryByCondition(params);
   }

   @Override
   @Cacheable(cacheNames = "timegroup")
   public List<ShoppingGroup> queryBytime(Map params) {
     return groupDao.queryBytime(params);
   }

   @Override
   @Cacheable(cacheNames = "countgroup")
   public int count(Map params) {
     return groupDao.count(params);
   }


 }




