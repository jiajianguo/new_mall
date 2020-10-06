 package com.xdj.interfaces.mallinterface.service.impl;

 import com.xdj.interfaces.mallinterface.mapper.ShoppingComplaintMapper;
 import com.xdj.interfaces.mallinterface.service.IComplaintService;
 import com.xdj.www.entity.ShoppingComplaintWithBLOBs;
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
 public class ComplaintServiceImpl implements IComplaintService {

   @Resource
   private ShoppingComplaintMapper complaintDao;

   @Override
   @CachePut(cacheNames = "insertcomplaint",condition = "#complaint != null")
   public boolean save(ShoppingComplaintWithBLOBs complaint)
   {
     try
     {
       this.complaintDao.insertSelective(complaint);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "complaint",condition = "#id != null")
   public ShoppingComplaintWithBLOBs getObjById(Long id)
   {
       ShoppingComplaintWithBLOBs complaint = this.complaintDao.selectByPrimaryKey(id);
     if (complaint != null) {
       return complaint;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delcomplaint",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.complaintDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delscomplaint",allEntries = true,beforeInvocation = true,condition = "#complaintIds != null")
   public boolean batchDelete(List<Long> complaintIds)
   {
     for (Long id : complaintIds) {
       delete(id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatecomplaint",condition = "#complaint != null")
   public boolean update(ShoppingComplaintWithBLOBs complaint) {
     try {
       this.complaintDao.updateByPrimaryKeySelective(complaint);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditioncomplaint")
   public List<ShoppingComplaintWithBLOBs> queryByCondition(Map<String, Object> map) {
     return complaintDao.queryByCondition(map);
   }

   @Override
   @Cacheable(cacheNames = "conuntcomplaint")
   public int count(Map<String, Object> map) {
     return complaintDao.count(map);
   }


 }




