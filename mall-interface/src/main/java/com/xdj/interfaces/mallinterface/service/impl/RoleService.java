 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingRoleMapper;
 import com.xdj.interfaces.mallinterface.service.IRoleService;
 import com.xdj.www.entity.ShoppingRole;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class RoleService implements IRoleService
 {

   @Resource
   private ShoppingRoleMapper roleDAO;

   @Override
   @CacheEvict(cacheNames = "delrole",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id)
   {
     try
     {
       this.roleDAO.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "role",condition = "#id!=null",unless = "#result==null")
   public ShoppingRole getObjById(Long id)
   {
     return roleDAO.selectByPrimaryKey(id);
   }

   @Override
   @Cacheable(cacheNames = "conditionrole",unless = "#result== null")
   public List<ShoppingRole> queryByCondition(Map params) {
     return roleDAO.queryByCondition(params);
   }

   @Override
   @Cacheable(cacheNames = "queryrole",unless = "#result== null")
   public List<ShoppingRole> queryRoleByUserId(Long user_id) {
     return roleDAO.queryRoleByUserId(user_id);
   }


   @Override
   @CachePut(cacheNames = "insertrole")
   public boolean save(ShoppingRole role)
   {
     try {
       this.roleDAO.insertSelective(role);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CachePut(cacheNames = "updaterole")
   public boolean update(ShoppingRole role)
   {
     try
     {
       this.roleDAO.updateByPrimaryKeySelective(role);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }


 }




