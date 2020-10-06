package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingAdvPos;
import com.xdj.www.entity.ShoppingAdvPosExample;
import com.xdj.www.entity.ShoppingAdvPosWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


@Mapper
public interface ShoppingAdvPosMapper {
    long countByExample(ShoppingAdvPosExample example);

    int deleteByExample(ShoppingAdvPosExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingAdvPosWithBLOBs record);

    int insertSelective(ShoppingAdvPosWithBLOBs record);

    List<ShoppingAdvPosWithBLOBs> selectByExampleWithBLOBs(ShoppingAdvPosExample example);

    List<ShoppingAdvPos> selectByExample(ShoppingAdvPosExample example);

    ShoppingAdvPosWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingAdvPosWithBLOBs record, @Param("example") ShoppingAdvPosExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingAdvPosWithBLOBs record, @Param("example") ShoppingAdvPosExample example);

    int updateByExample(@Param("record") ShoppingAdvPos record, @Param("example") ShoppingAdvPosExample example);

    int updateByPrimaryKeySelective(ShoppingAdvPosWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingAdvPosWithBLOBs record);

    int updateByPrimaryKey(ShoppingAdvPos record);

    ShoppingAdvPosWithBLOBs oneToManyById(Long id);
}
