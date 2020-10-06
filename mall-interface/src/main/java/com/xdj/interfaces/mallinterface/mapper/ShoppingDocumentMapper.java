package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingDocument;
import com.xdj.www.entity.ShoppingDocumentExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingDocumentMapper {
    long countByExample(ShoppingDocumentExample example);

    int deleteByExample(ShoppingDocumentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingDocument record);

    int insertSelective(ShoppingDocument record);

    List<ShoppingDocument> selectByExampleWithBLOBs(ShoppingDocumentExample example);

    List<ShoppingDocument> selectByExample(ShoppingDocumentExample example);

    ShoppingDocument selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingDocument record, @Param("example") ShoppingDocumentExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingDocument record, @Param("example") ShoppingDocumentExample example);

    int updateByExample(@Param("record") ShoppingDocument record, @Param("example") ShoppingDocumentExample example);

    int updateByPrimaryKeySelective(ShoppingDocument record);

    int updateByPrimaryKeyWithBLOBs(ShoppingDocument record);

    int updateByPrimaryKey(ShoppingDocument record);
}
