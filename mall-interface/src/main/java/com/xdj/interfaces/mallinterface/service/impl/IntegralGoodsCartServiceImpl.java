 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingIntegralGoodscartMapper;
 import com.xdj.interfaces.mallinterface.service.IIntegralGoodsCartService;
 import com.xdj.www.entity.ShoppingIntegralGoodscart;
 import org.springframework.cache.annotation.CacheEvict;
 import org.springframework.cache.annotation.CachePut;
 import org.springframework.cache.annotation.Cacheable;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 @Service
 @Transactional
 public class IntegralGoodsCartServiceImpl implements IIntegralGoodsCartService
 {

   @Resource
   private ShoppingIntegralGoodscartMapper integralGoodsCartDao;

   @Override
   @CachePut(cacheNames = "insertintegralgc",condition = "#integralGoodsCart != null")
   public boolean save(ShoppingIntegralGoodscart integralGoodsCart)
   {
     try
     {
       this.integralGoodsCartDao.insertSelective(integralGoodsCart);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   @Cacheable(cacheNames = "integralgc" ,condition = "#id != null",unless = "#result== null")
   public ShoppingIntegralGoodscart getObjById(Long id)
   {
       ShoppingIntegralGoodscart integralGoodsCart =this.integralGoodsCartDao.selectByPrimaryKey(id);
     if (integralGoodsCart != null) {
       return integralGoodsCart;
     }
     return null;
   }
     @Override
     @CacheEvict(cacheNames = "delontegralgc",allEntries = true,beforeInvocation = true,condition = "#id != null")
   public boolean delete(Long id) {
     try {
       this.integralGoodsCartDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }
     @Override
     @CacheEvict(cacheNames = "delsintegralgc",allEntries = true,beforeInvocation = true,condition = "#integralGoodsCartIds != null")
   public boolean batchDelete(List<Long> integralGoodsCartIds)
   {
     for (Long id : integralGoodsCartIds) {
       delete((Long)id);
     }
     return true;
   }

   @Override
   @CachePut(cacheNames = "updateintegralgc")
   public boolean update(ShoppingIntegralGoodscart integralGoodsCart) {
     try {
       this.integralGoodsCartDao.updateByPrimaryKeySelective(integralGoodsCart);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     @Cacheable(cacheNames = "conditionintegralgc",unless = "#result== null")
     public List<ShoppingIntegralGoodscart> queryByCondition(Map<String, Object> params) {
         return integralGoodsCartDao.queryByCondition(params);
     }

 }




