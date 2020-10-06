package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingBargain;
import com.xdj.www.entity.ShoppingBargainExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingBargainMapper {
    long countByExample(ShoppingBargainExample example);

    int deleteByExample(ShoppingBargainExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingBargain record);

    int insertSelective(ShoppingBargain record);

    List<ShoppingBargain> selectByExampleWithBLOBs(ShoppingBargainExample example);

    List<ShoppingBargain> selectByExample(ShoppingBargainExample example);

    ShoppingBargain selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingBargain record, @Param("example") ShoppingBargainExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingBargain record, @Param("example") ShoppingBargainExample example);

    int updateByExample(@Param("record") ShoppingBargain record, @Param("example") ShoppingBargainExample example);

    int updateByPrimaryKeySelective(ShoppingBargain record);

    int updateByPrimaryKeyWithBLOBs(ShoppingBargain record);

    int updateByPrimaryKey(ShoppingBargain record);
}
