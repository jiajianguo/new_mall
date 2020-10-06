package com.xdj.interfaces.mallinterface.service;

import com.xdj.www.entity.ShoppingGoodsbrand;

import java.util.List;
import java.util.Map;

public interface GoodsTypeBrandService {

    public List<ShoppingGoodsbrand> queryByCondition(Map para);
}
