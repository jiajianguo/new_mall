 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingComplaintSubjectMapper;
 import com.xdj.interfaces.mallinterface.service.IComplaintSubjectService;
 import com.xdj.www.entity.ShoppingComplaintSubject;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */
 @Service
 @Transactional
 public class ComplaintSubjectServiceImpl implements IComplaintSubjectService {

   @Resource
   private ShoppingComplaintSubjectMapper complaintSubjectDao;

   @Override
   @CachePut(cacheNames = "insertcomplaintSubject",condition = "#complaintSubject != null")
   public int save(ShoppingComplaintSubject complaintSubject)
   {
     try
     {
       this.complaintSubjectDao.insertSelective(complaintSubject);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @Cacheable(cacheNames = "complaintSubject",condition = "#id != null",unless = "#result==null")
   public ShoppingComplaintSubject getObjById(Long id)
   {
       ShoppingComplaintSubject complaintSubject = this.complaintSubjectDao.selectByPrimaryKey(id);
     if (complaintSubject != null) {
       return complaintSubject;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delcomplaintSubject",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public int delete(Long id) {
     try {
       this.complaintSubjectDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delscomplaintSubject",allEntries =  true,beforeInvocation = true,condition = "#complaintSubjectIds")
   public int batchDelete(List<Long> complaintSubjectIds)
   {
     for (Long id : complaintSubjectIds) {
       delete(id);
     }
     return 1;
   }



   @Override
   @CachePut(cacheNames = "updatecomplaintSubject",condition = "#complaintSubject != null")
   public int update(ShoppingComplaintSubject complaintSubject) {
     try {
       this.complaintSubjectDao.updateByPrimaryKeySelective(complaintSubject);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

     @Override
     public List<ShoppingComplaintSubject> queryByCondition(Map<String, Object> params) {
         return complaintSubjectDao.queryByCondition(params);
     }


 }




