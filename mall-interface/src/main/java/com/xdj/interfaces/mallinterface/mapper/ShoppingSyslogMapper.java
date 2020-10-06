package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingSyslog;
import com.xdj.www.entity.ShoppingSyslogExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingSyslogMapper {
    long countByExample(ShoppingSyslogExample example);

    int deleteByExample(ShoppingSyslogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingSyslog record);

    int insertSelective(ShoppingSyslog record);

    List<ShoppingSyslog> selectByExampleWithBLOBs(ShoppingSyslogExample example);

    List<ShoppingSyslog> selectByExample(ShoppingSyslogExample example);

    ShoppingSyslog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingSyslog record, @Param("example") ShoppingSyslogExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingSyslog record, @Param("example") ShoppingSyslogExample example);

    int updateByExample(@Param("record") ShoppingSyslog record, @Param("example") ShoppingSyslogExample example);

    int updateByPrimaryKeySelective(ShoppingSyslog record);

    int updateByPrimaryKeyWithBLOBs(ShoppingSyslog record);

    int updateByPrimaryKey(ShoppingSyslog record);
}
