 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingRolegroupMapper;
 import com.xdj.interfaces.mallinterface.service.IRoleGroupService;
 import com.xdj.www.entity.ShoppingRolegroup;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.io.Serializable;
 import java.util.List;

 @Service

 public class RoleGroupServiceImpl   implements IRoleGroupService
 {

   @Resource
   private ShoppingRolegroupMapper roleGroupDao;

   @Override
   @CachePut(cacheNames = "insertrolegroup",condition = "#roleGroup != null")
   public boolean save(ShoppingRolegroup roleGroup)
   {
     try
     {
       this.roleGroupDao.insertSelective(roleGroup);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "rolegroup",condition = "#id!=null",unless = "#result==null")
   public ShoppingRolegroup getObjById(Long id)
   {
       ShoppingRolegroup roleGroup = this.roleGroupDao.selectByPrimaryKey(id);
     if (roleGroup != null) {
       return roleGroup;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delrolegroup",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.roleGroupDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsrolegroup",allEntries = true,beforeInvocation = true,condition = "#roleGroupIds != null")
   public boolean batchDelete(List<Long> roleGroupIds)
   {
     for (Serializable id : roleGroupIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updaterolegroup",condition = "#roleGroup != null")
   public boolean update(ShoppingRolegroup roleGroup) {
     try {
       this.roleGroupDao.updateByPrimaryKeySelective(roleGroup);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




