package com.xdj.interfaces.mallinterface.service;



import com.xdj.www.entity.ShoppingBrandcategory;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public abstract interface IGoodsBrandCategoryService
{
  public abstract boolean save(ShoppingBrandcategory paramGoodsBrandCategory);

  public abstract ShoppingBrandcategory getObjById(Long paramLong);

  public abstract boolean delete(Long paramLong);

  public abstract boolean batchDelete(List<Long> paramList);

  public abstract boolean update(ShoppingBrandcategory paramGoodsBrandCategory);

  public abstract  List<ShoppingBrandcategory> queryByCondition (Map<String,Object> map);


}




