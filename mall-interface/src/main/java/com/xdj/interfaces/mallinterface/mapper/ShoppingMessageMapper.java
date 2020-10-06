package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingMessage;
import com.xdj.www.entity.ShoppingMessageExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingMessageMapper {
    long countByExample(ShoppingMessageExample example);

    int deleteByExample(ShoppingMessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingMessage record);

    int insertSelective(ShoppingMessage record);

    List<ShoppingMessage> selectByExampleWithBLOBs(ShoppingMessageExample example);

    List<ShoppingMessage> selectByExample(ShoppingMessageExample example);

    ShoppingMessage selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingMessage record, @Param("example") ShoppingMessageExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingMessage record, @Param("example") ShoppingMessageExample example);

    int updateByExample(@Param("record") ShoppingMessage record, @Param("example") ShoppingMessageExample example);

    int updateByPrimaryKeySelective(ShoppingMessage record);

    int updateByPrimaryKeyWithBLOBs(ShoppingMessage record);

    int updateByPrimaryKey(ShoppingMessage record);

    List<ShoppingMessage> queryByCondition(Map<String, Object> params);

    int count(Map<String, Object> map);
}
