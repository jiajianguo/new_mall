package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingReportSubject;
import com.xdj.www.entity.ShoppingReportSubjectExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingReportSubjectMapper {
    long countByExample(ShoppingReportSubjectExample example);

    int deleteByExample(ShoppingReportSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingReportSubject record);

    int insertSelective(ShoppingReportSubject record);

    List<ShoppingReportSubject> selectByExample(ShoppingReportSubjectExample example);

    ShoppingReportSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingReportSubject record, @Param("example") ShoppingReportSubjectExample example);

    int updateByExample(@Param("record") ShoppingReportSubject record, @Param("example") ShoppingReportSubjectExample example);

    int updateByPrimaryKeySelective(ShoppingReportSubject record);

    int updateByPrimaryKey(ShoppingReportSubject record);

    List<ShoppingReportSubject> queryByCondition(Map<String, Object> params);
}
