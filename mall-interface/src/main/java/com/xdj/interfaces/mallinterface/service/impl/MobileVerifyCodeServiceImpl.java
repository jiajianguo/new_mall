 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingMobileverifycodeMapper;
 import com.xdj.interfaces.mallinterface.service.IMobileVerifyCodeService;
 import com.xdj.www.entity.ShoppingMobileverifycode;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class MobileVerifyCodeServiceImpl implements IMobileVerifyCodeService {

   @Resource
   private ShoppingMobileverifycodeMapper mobileVerifyCodeDao;

   @Override
   @CachePut(cacheNames = "insertmobilevc",condition = "#mobileVerifyCode != null")
   public boolean save(ShoppingMobileverifycode mobileVerifyCode)
   {
     try
     {
       this.mobileVerifyCodeDao.insertSelective(mobileVerifyCode);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "mobilevc",condition = "#id!=null",unless = "#result==null")
   public ShoppingMobileverifycode getObjById(Long id)
   {
       ShoppingMobileverifycode mobileVerifyCode = this.mobileVerifyCodeDao.selectByPrimaryKey(id);
     if (mobileVerifyCode != null) {
       return mobileVerifyCode;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delmobilevc",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.mobileVerifyCodeDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delsmobilevc",allEntries = true,beforeInvocation = true,condition = "#mobileVerifyCodeIds != null")
   public boolean batchDelete(List<Long> mobileVerifyCodeIds)
   {
     for (Long id : mobileVerifyCodeIds) {
       delete((Long)id);
     }
     return true;
   }


   @Override
   @CachePut(cacheNames = "updatemobilevc")
   public boolean update(ShoppingMobileverifycode mobileVerifyCode) {
     try {
       this.mobileVerifyCodeDao.updateByPrimaryKeySelective(mobileVerifyCode);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionmobilevc",unless = "#result==null")
   public ShoppingMobileverifycode queryByCondition(Map<String, Object> params) {
     return mobileVerifyCodeDao.queryByCondition(params);
   }


 }




