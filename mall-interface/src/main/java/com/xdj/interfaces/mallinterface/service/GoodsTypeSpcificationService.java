package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingGoodsspecification;

import java.util.List;
import java.util.Map;


/**
 * @author Administrator
 */
public abstract interface GoodsTypeSpcificationService {

    public List<ShoppingGoodsspecification> queryByCondition(Map para);

}
