package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsspecification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Administrator
 */
@Mapper
public interface GoodsTypeSpcificationMapper {
    List<ShoppingGoodsspecification> queryByCondition(Map para);
}
