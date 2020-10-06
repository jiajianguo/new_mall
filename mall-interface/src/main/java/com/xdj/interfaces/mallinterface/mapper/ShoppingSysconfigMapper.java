package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingSysconfig;
import com.xdj.www.entity.ShoppingSysconfigExample;
import com.xdj.www.entity.ShoppingSysconfigWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingSysconfigMapper {
    long countByExample(ShoppingSysconfigExample example);

    int deleteByExample(ShoppingSysconfigExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingSysconfigWithBLOBs record);

    int insertSelective(ShoppingSysconfigWithBLOBs record);

    List<ShoppingSysconfigWithBLOBs> selectByExampleWithBLOBs(ShoppingSysconfigExample example);

    List<ShoppingSysconfig> selectByExample(ShoppingSysconfigExample example);

    ShoppingSysconfigWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingSysconfigWithBLOBs record, @Param("example") ShoppingSysconfigExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingSysconfigWithBLOBs record, @Param("example") ShoppingSysconfigExample example);

    int updateByExample(@Param("record") ShoppingSysconfig record, @Param("example") ShoppingSysconfigExample example);

    int updateByPrimaryKeySelective(ShoppingSysconfigWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingSysconfigWithBLOBs record);

    int updateByPrimaryKey(ShoppingSysconfig record);

    List<ShoppingSysconfigWithBLOBs> findAll();
}
