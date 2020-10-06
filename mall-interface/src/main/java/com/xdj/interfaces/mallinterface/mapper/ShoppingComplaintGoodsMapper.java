package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingComplaintGoods;
import com.xdj.www.entity.ShoppingComplaintGoodsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface ShoppingComplaintGoodsMapper {
    long countByExample(ShoppingComplaintGoodsExample example);

    int deleteByExample(ShoppingComplaintGoodsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingComplaintGoods record);

    int insertSelective(ShoppingComplaintGoods record);

    List<ShoppingComplaintGoods> selectByExampleWithBLOBs(ShoppingComplaintGoodsExample example);

    List<ShoppingComplaintGoods> selectByExample(ShoppingComplaintGoodsExample example);

    ShoppingComplaintGoods selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingComplaintGoods record, @Param("example") ShoppingComplaintGoodsExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingComplaintGoods record, @Param("example") ShoppingComplaintGoodsExample example);

    int updateByExample(@Param("record") ShoppingComplaintGoods record, @Param("example") ShoppingComplaintGoodsExample example);

    int updateByPrimaryKeySelective(ShoppingComplaintGoods record);

    int updateByPrimaryKeyWithBLOBs(ShoppingComplaintGoods record);

    int updateByPrimaryKey(ShoppingComplaintGoods record);
}
