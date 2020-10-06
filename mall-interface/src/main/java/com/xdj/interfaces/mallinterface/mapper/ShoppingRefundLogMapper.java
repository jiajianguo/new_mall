package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingRefundLog;
import com.xdj.www.entity.ShoppingRefundLogExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingRefundLogMapper {
    long countByExample(ShoppingRefundLogExample example);

    int deleteByExample(ShoppingRefundLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingRefundLog record);

    int insertSelective(ShoppingRefundLog record);

    List<ShoppingRefundLog> selectByExample(ShoppingRefundLogExample example);

    ShoppingRefundLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingRefundLog record, @Param("example") ShoppingRefundLogExample example);

    int updateByExample(@Param("record") ShoppingRefundLog record, @Param("example") ShoppingRefundLogExample example);

    int updateByPrimaryKeySelective(ShoppingRefundLog record);

    int updateByPrimaryKey(ShoppingRefundLog record);

    List<ShoppingRefundLog> queryByCondition(Map<String, Object> params);
}
