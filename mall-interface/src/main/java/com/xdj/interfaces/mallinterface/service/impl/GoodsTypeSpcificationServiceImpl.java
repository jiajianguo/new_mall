package com.xdj.interfaces.mallinterface.service.impl;

import com.xdj.interfaces.mallinterface.mapper.GoodsTypeSpcificationMapper;
import com.xdj.interfaces.mallinterface.mapper.ShoppingGoodsspecificationMapper;
import com.xdj.interfaces.mallinterface.service.GoodsTypeSpcificationService;
import com.xdj.www.entity.ShoppingGoodsspecification;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */

@Service("goodsTypeSpcificationService")
public class GoodsTypeSpcificationServiceImpl implements GoodsTypeSpcificationService {
    @Resource
    private GoodsTypeSpcificationMapper goodsTypeMapper ;

    @Override
    @Cacheable(cacheNames = "goodsspecifications",unless = "#result==null")
    public List<ShoppingGoodsspecification> queryByCondition(Map para) {
        return goodsTypeMapper.queryByCondition(para);
    }
}
