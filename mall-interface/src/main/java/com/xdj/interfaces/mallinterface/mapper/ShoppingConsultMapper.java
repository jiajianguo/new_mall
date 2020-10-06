package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingConsult;
import com.xdj.www.entity.ShoppingConsultExample;
import com.xdj.www.entity.ShoppingConsultWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingConsultMapper {
    long countByExample(ShoppingConsultExample example);

    int deleteByExample(ShoppingConsultExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingConsultWithBLOBs record);

    int insertSelective(ShoppingConsultWithBLOBs record);

    List<ShoppingConsultWithBLOBs> selectByExampleWithBLOBs(ShoppingConsultExample example);

    List<ShoppingConsult> selectByExample(ShoppingConsultExample example);

    ShoppingConsultWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingConsultWithBLOBs record, @Param("example") ShoppingConsultExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingConsultWithBLOBs record, @Param("example") ShoppingConsultExample example);

    int updateByExample(@Param("record") ShoppingConsult record, @Param("example") ShoppingConsultExample example);

    int updateByPrimaryKeySelective(ShoppingConsultWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingConsultWithBLOBs record);

    int updateByPrimaryKey(ShoppingConsult record);

    List<ShoppingConsultWithBLOBs> queryByCondition(Map<String, Object> map);

    int count(Map<String, Object> map);
}
