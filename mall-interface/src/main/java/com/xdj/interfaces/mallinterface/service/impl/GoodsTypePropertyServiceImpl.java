 package com.xdj.interfaces.mallinterface.service.impl;


 import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodstypepropertyMapper;
 import com.xdj.interfaces.mallinterface.service.IGoodsTypePropertyService;
 import com.xdj.www.entity.ShoppingGoodstypeproperty;
 import org.springframework.stereotype.Service;
 import org.springframework.transaction.annotation.Transactional;

 import javax.annotation.Resource;
 import java.util.List;
 import java.util.Map;

 /**
  * @author Administrator
  */

 @Service
 public class GoodsTypePropertyServiceImpl implements IGoodsTypePropertyService
 {

   @Resource
   private ShoppingGoodstypepropertyMapper goodsTypePropertyDao;

   @Override

   public boolean save(ShoppingGoodstypeproperty goodsTypeProperty){
     try{
       this.goodsTypePropertyDao.insertSelective(goodsTypeProperty);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   public ShoppingGoodstypeproperty getObjById(Long id){
       ShoppingGoodstypeproperty goodsTypeProperty = this.goodsTypePropertyDao.selectByPrimaryKey(id);
     if (goodsTypeProperty != null) {
       return goodsTypeProperty;
     }
     return null;
   }

   @Override
   public boolean delete(Long id) {
     try {
       this.goodsTypePropertyDao.deleteByPrimaryKey(id);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

   @Override
   public boolean batchDelete(List<Long> goodsTypePropertyIds)
   {
     for (Long id : goodsTypePropertyIds) {
       delete((Long)id);
     }
     return true;
   }



   @Override
   public boolean update(ShoppingGoodstypeproperty goodsTypeProperty) {
     try {
       this.goodsTypePropertyDao.updateByPrimaryKeySelective(goodsTypeProperty);
       return true;
     } catch (Exception e) {
       e.printStackTrace();
     }return false;
   }

     @Override
     public List<ShoppingGoodstypeproperty> queryByCondition(Map<String, Object> para) {
         return goodsTypePropertyDao.queryByCondition(para);
     }

     @Override
     public List<ShoppingGoodstypeproperty> queryByMany(Map<String, Object> para) {
         return goodsTypePropertyDao.queryByMany(para);
     }

 }




