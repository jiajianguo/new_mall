package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingAlbum;
import com.xdj.www.entity.ShoppingAlbumExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingAlbumMapper {
    long countByExample(ShoppingAlbumExample example);

    int deleteByExample(ShoppingAlbumExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingAlbum record);

    int insertSelective(ShoppingAlbum record);

    List<ShoppingAlbum> selectByExampleWithBLOBs(ShoppingAlbumExample example);

    List<ShoppingAlbum> selectByExample(ShoppingAlbumExample example);

    ShoppingAlbum selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingAlbum record, @Param("example") ShoppingAlbumExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingAlbum record, @Param("example") ShoppingAlbumExample example);

    int updateByExample(@Param("record") ShoppingAlbum record, @Param("example") ShoppingAlbumExample example);

    int updateByPrimaryKeySelective(ShoppingAlbum record);

    int updateByPrimaryKeyWithBLOBs(ShoppingAlbum record);

    int updateByPrimaryKey(ShoppingAlbum record);
}
