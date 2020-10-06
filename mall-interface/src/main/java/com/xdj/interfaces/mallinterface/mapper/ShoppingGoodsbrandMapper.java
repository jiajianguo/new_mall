package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsbrand;
import com.xdj.www.entity.ShoppingGoodsbrandExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsbrandMapper {
    long countByExample(ShoppingGoodsbrandExample example);

    int deleteByExample(ShoppingGoodsbrandExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoodsbrand record);

    int insertSelective(ShoppingGoodsbrand record);

    List<ShoppingGoodsbrand> selectByExampleWithBLOBs(ShoppingGoodsbrandExample example);

    List<ShoppingGoodsbrand> selectByExample(ShoppingGoodsbrandExample example);

    ShoppingGoodsbrand selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoodsbrand record, @Param("example") ShoppingGoodsbrandExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGoodsbrand record, @Param("example") ShoppingGoodsbrandExample example);

    int updateByExample(@Param("record") ShoppingGoodsbrand record, @Param("example") ShoppingGoodsbrandExample example);

    int updateByPrimaryKeySelective(ShoppingGoodsbrand record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGoodsbrand record);

    int updateByPrimaryKey(ShoppingGoodsbrand record);

    List<ShoppingGoodsbrand> queryByCondition(Map<String, Object> para);

    List<ShoppingGoodsbrand> queryByMany(Map para);
}
