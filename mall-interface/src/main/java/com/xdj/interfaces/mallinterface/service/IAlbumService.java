package com.xdj.interfaces.mallinterface.service;


import com.xdj.www.entity.ShoppingAlbum;


import java.io.Serializable;
import java.util.List;
import java.util.Map;

public abstract interface IAlbumService
{
  public abstract int save(ShoppingAlbum paramAlbum);

  public abstract ShoppingAlbum getObjById(Long paramLong);

  public abstract int delete(Long paramLong);

  public abstract int batchDelete(List<Long> paramList);


  public abstract int update(ShoppingAlbum paramAlbum);


}




