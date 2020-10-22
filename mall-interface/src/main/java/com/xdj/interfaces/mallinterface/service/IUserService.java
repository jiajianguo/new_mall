package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingUser;
import com.xdj.www.entity.ShoppingUserExample;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
public  interface IUserService {
  public abstract int save(ShoppingUser user);

  public abstract int delete(Long paramLong);

  public abstract int update(ShoppingUser paramUser);


  public abstract ShoppingUser getObjById(Long paramLong);

  public abstract ShoppingUser getOne(Map<String, Object> map);

  public abstract ShoppingUser queryOneByStoreId(Long id);

    List<ShoppingUser> selectByExample(ShoppingUserExample example);

    List<ShoppingUser> queryByCondition(Map<String, Object> map);

  ShoppingUser findByUsername(String username);

  int count(Map<String, Object> map);

  ShoppingUser getUserByOpenId(String openId);

  ShoppingUser findByEmail(String email);


}




