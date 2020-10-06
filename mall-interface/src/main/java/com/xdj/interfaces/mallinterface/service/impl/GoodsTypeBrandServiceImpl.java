package com.xdj.interfaces.mallinterface.service.impl;


import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsbrandMapper;
import com.xdj.interfaces.mallinterface.service.GoodsTypeBrandService;
import com.xdj.www.entity.ShoppingGoodsbrand;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Service("goodsTypeBrandService")
public class GoodsTypeBrandServiceImpl implements GoodsTypeBrandService {
    @Resource
    private ShoppingGoodsbrandMapper shoppingGoodsbrandMapper;

    @Override
    @Cacheable(cacheNames = "conditiongoodsbrand",unless = "#result==null")
    public List<ShoppingGoodsbrand>  queryByCondition(Map para){
        return shoppingGoodsbrandMapper.queryByMany(para);
    }
}
