package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingVmenu;
import com.xdj.www.entity.ShoppingVmenuExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingVmenuMapper {
    long countByExample(ShoppingVmenuExample example);

    int deleteByExample(ShoppingVmenuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingVmenu record);

    int insertSelective(ShoppingVmenu record);

    List<ShoppingVmenu> selectByExampleWithBLOBs(ShoppingVmenuExample example);

    List<ShoppingVmenu> selectByExample(ShoppingVmenuExample example);

    ShoppingVmenu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingVmenu record, @Param("example") ShoppingVmenuExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingVmenu record, @Param("example") ShoppingVmenuExample example);

    int updateByExample(@Param("record") ShoppingVmenu record, @Param("example") ShoppingVmenuExample example);

    int updateByPrimaryKeySelective(ShoppingVmenu record);

    int updateByPrimaryKeyWithBLOBs(ShoppingVmenu record);

    int updateByPrimaryKey(ShoppingVmenu record);
}
