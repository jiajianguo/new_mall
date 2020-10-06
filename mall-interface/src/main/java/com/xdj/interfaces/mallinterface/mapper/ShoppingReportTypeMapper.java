package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingReportType;
import com.xdj.www.entity.ShoppingReportTypeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingReportTypeMapper {
    long countByExample(ShoppingReportTypeExample example);

    int deleteByExample(ShoppingReportTypeExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingReportType record);

    int insertSelective(ShoppingReportType record);

    List<ShoppingReportType> selectByExampleWithBLOBs(ShoppingReportTypeExample example);

    List<ShoppingReportType> selectByExample(ShoppingReportTypeExample example);

    ShoppingReportType selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingReportType record, @Param("example") ShoppingReportTypeExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingReportType record, @Param("example") ShoppingReportTypeExample example);

    int updateByExample(@Param("record") ShoppingReportType record, @Param("example") ShoppingReportTypeExample example);

    int updateByPrimaryKeySelective(ShoppingReportType record);

    int updateByPrimaryKeyWithBLOBs(ShoppingReportType record);

    int updateByPrimaryKey(ShoppingReportType record);

    List<ShoppingReportType> queryByCondition(Map<String, Object> params);
}
