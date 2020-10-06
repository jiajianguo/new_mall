package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingReport;
import com.xdj.www.entity.ShoppingReportExample;
import com.xdj.www.entity.ShoppingReportWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingReportMapper {
    long countByExample(ShoppingReportExample example);

    int deleteByExample(ShoppingReportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingReportWithBLOBs record);

    int insertSelective(ShoppingReportWithBLOBs record);

    List<ShoppingReportWithBLOBs> selectByExampleWithBLOBs(ShoppingReportExample example);

    List<ShoppingReport> selectByExample(ShoppingReportExample example);

    ShoppingReportWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingReportWithBLOBs record, @Param("example") ShoppingReportExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingReportWithBLOBs record, @Param("example") ShoppingReportExample example);

    int updateByExample(@Param("record") ShoppingReport record, @Param("example") ShoppingReportExample example);

    int updateByPrimaryKeySelective(ShoppingReportWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingReportWithBLOBs record);

    int updateByPrimaryKey(ShoppingReport record);

    List queryByCondition(Map<String, Object> params);

    int count(Map<String, Object> map);
}
