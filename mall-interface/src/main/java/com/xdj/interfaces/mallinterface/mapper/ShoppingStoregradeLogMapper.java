package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStoregradeLog;
import com.xdj.www.entity.ShoppingStoregradeLogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingStoregradeLogMapper {
    long countByExample(ShoppingStoregradeLogExample example);

    int deleteByExample(ShoppingStoregradeLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStoregradeLog record);

    int insertSelective(ShoppingStoregradeLog record);

    List<ShoppingStoregradeLog> selectByExample(ShoppingStoregradeLogExample example);

    ShoppingStoregradeLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStoregradeLog record, @Param("example") ShoppingStoregradeLogExample example);

    int updateByExample(@Param("record") ShoppingStoregradeLog record, @Param("example") ShoppingStoregradeLogExample example);

    int updateByPrimaryKeySelective(ShoppingStoregradeLog record);

    int updateByPrimaryKey(ShoppingStoregradeLog record);
}
