 package com.xdj.interfaces.mallinterface.service.impl;



 import com.xdj.interfaces.mallinterface.mapper.ShoppingAddressMapper;
 import com.xdj.interfaces.mallinterface.service.IAddressService;
 import com.xdj.www.entity.ShoppingAddress;
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
  * 收货地址
  * @author Administrator
  */

 @Service
 public class AddressServiceImpl implements IAddressService
 {

   @Resource
   private ShoppingAddressMapper addressDao;

   @Override
   @CachePut(cacheNames = "insertAddress",condition = "#address != null" )
   public boolean save(ShoppingAddress address){
     try{
       this.addressDao.insertSelective(address);
       return true;
     }catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "address",condition = "#id !=  null")
   public ShoppingAddress getObjById(Long id)
   {
       ShoppingAddress address = this.addressDao.selectByPrimaryKey(id);
     if (address != null) {
       return address;
     }
     return null;
   }

   @Override
   @CacheEvict(cacheNames = "delAddress", allEntries = true, beforeInvocation = true, condition = "#id >0" )
   public int delete(Long id) {
     try {
       this.addressDao.deleteByPrimaryKey(id);
       return 1;
     } catch (Exception e) {
       e.printStackTrace();
     }return 0;
   }

   @Override
   @CacheEvict(cacheNames = "delsAddress", allEntries = true, beforeInvocation = true, condition = "#addressIds != null" )
   public int batchDelete(List<Long> addressIds)
   {
     for (Serializable id : addressIds) {
       delete((Long)id);
     }
     return 1;
   }



   @Override
   @CachePut(cacheNames = "updAddress",condition = "#address != null", unless = "#result>0")
   public boolean update(ShoppingAddress address) {
     try {
       this.addressDao.updateByPrimaryKeySelective(address);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionAddress")
     public List<ShoppingAddress> queryByCondition(Map params) {
         return addressDao.queryByCondition(params);
     }

     @Override
     @Cacheable(cacheNames = "countAddress")
     public int count(Map params) {
         return addressDao.count(params);
     }

     @Override
     public int updateByPrimaryKeySelective(ShoppingAddress addr) {
         return addressDao.updateByPrimaryKeySelective(addr);
     }


 }




