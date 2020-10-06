 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingPartnerMapper;
 import com.xdj.interfaces.mallinterface.service.IPartnerService;
 import com.xdj.www.entity.ShoppingPartner;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 public class PartnerServiceImpl implements IPartnerService
 {

   @Resource
   private ShoppingPartnerMapper partnerDao;

   @Override
   @CachePut(cacheNames = "insertpatner",condition = "#integralGoodsCart != null")
   public boolean save(ShoppingPartner partner)
   {
     try
     {
       this.partnerDao.insertSelective(partner);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "partner",condition = "#id!=null",unless = "#result==null")
   public ShoppingPartner getObjById(Long id)
   {
       ShoppingPartner partner = this.partnerDao.selectByPrimaryKey(id);
     if (partner != null) {
       return partner;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delpartner",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.partnerDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @CacheEvict(cacheNames = "delspartner",allEntries = true,beforeInvocation = true,condition = "#partnerIds != null")
   public boolean batchDelete(List<Long> partnerIds)
   {
     for (Long id : partnerIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   @CachePut(cacheNames = "updatepartner")
   public boolean update(ShoppingPartner partner) {
     try {
       this.partnerDao.updateByPrimaryKeySelective(partner);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "conditionpoartner",unless = "#result==null")
   public List<ShoppingPartner> queryByCondition(Map params) {
     return partnerDao.queryByCondition(params);
   }


 }




