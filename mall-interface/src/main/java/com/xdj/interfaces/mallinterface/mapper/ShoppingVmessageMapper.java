package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingVmessage;
import com.xdj.www.entity.ShoppingVmessageExample;
import com.xdj.www.entity.ShoppingVmessageWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingVmessageMapper {
    long countByExample(ShoppingVmessageExample example);

    int deleteByExample(ShoppingVmessageExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingVmessageWithBLOBs record);

    int insertSelective(ShoppingVmessageWithBLOBs record);

    List<ShoppingVmessageWithBLOBs> selectByExampleWithBLOBs(ShoppingVmessageExample example);

    List<ShoppingVmessage> selectByExample(ShoppingVmessageExample example);

    ShoppingVmessageWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingVmessageWithBLOBs record, @Param("example") ShoppingVmessageExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingVmessageWithBLOBs record, @Param("example") ShoppingVmessageExample example);

    int updateByExample(@Param("record") ShoppingVmessage record, @Param("example") ShoppingVmessageExample example);

    int updateByPrimaryKeySelective(ShoppingVmessageWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingVmessageWithBLOBs record);

    int updateByPrimaryKey(ShoppingVmessage record);
}
