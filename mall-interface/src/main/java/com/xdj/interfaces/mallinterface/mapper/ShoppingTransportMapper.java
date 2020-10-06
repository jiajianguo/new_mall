package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingTransport;
import com.xdj.www.entity.ShoppingTransportExample;
import com.xdj.www.entity.ShoppingTransportWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingTransportMapper {
    long countByExample(ShoppingTransportExample example);

    int deleteByExample(ShoppingTransportExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingTransportWithBLOBs record);

    int insertSelective(ShoppingTransportWithBLOBs record);

    List<ShoppingTransportWithBLOBs> selectByExampleWithBLOBs(ShoppingTransportExample example);

    List<ShoppingTransport> selectByExample(ShoppingTransportExample example);

    ShoppingTransportWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingTransportWithBLOBs record, @Param("example") ShoppingTransportExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingTransportWithBLOBs record, @Param("example") ShoppingTransportExample example);

    int updateByExample(@Param("record") ShoppingTransport record, @Param("example") ShoppingTransportExample example);

    int updateByPrimaryKeySelective(ShoppingTransportWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingTransportWithBLOBs record);

    int updateByPrimaryKey(ShoppingTransport record);
}
