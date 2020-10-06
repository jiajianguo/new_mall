 package com.xdj.interfaces.mallinterface.service.impl;



 import com.xdj.interfaces.mallinterface.mapper.ShoppingAreaMapper;
 import com.xdj.interfaces.mallinterface.service.IAreaService;
 import com.xdj.www.entity.ShoppingArea;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 /**
  * 地域信息
  * @author Administrator
  */
 @Service
 public class AreaServiceImpl implements IAreaService {

   @Resource
   private ShoppingAreaMapper areaDao;

   @Override
   @CachePut(cacheNames = "insertarea",condition = "#area != null")
   public boolean save(ShoppingArea area)
   {
     try
     {
       this.areaDao.insertSelective(area);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "area",condition = "#id >0")
   public ShoppingArea getObjById(Long id)
   {
       ShoppingArea area = this.areaDao.selectByPrimaryKey(id);
     if (area != null) {
       return area;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delArea",condition="#id != null",allEntries = true,beforeInvocation = true)
   public int delete(Long id) {
     try {
       this.areaDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delsArea",condition="#id != null",allEntries = true,beforeInvocation = true)
   public int batchDelete(List<Long> areaIds)
   {
     for (Long id : areaIds) {
       delete(id);
     }
     return 1;
   }



   @Override
   @CachePut(cacheNames = "updateArea",condition = "#area != null")
   public int update(ShoppingArea area) {
     try {
       this.areaDao.updateByPrimaryKeySelective(area);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

     @Override
     @Cacheable(cacheNames = "conditionArea")
     public List<ShoppingArea> queryByCondition(Map params) {
         return areaDao.queryByCondition(params);
     }

 }




