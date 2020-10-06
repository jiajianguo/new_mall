package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoodsPhoto;
import com.xdj.www.entity.ShoppingGoodsPhotoExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoodsPhotoMapper {
    long countByExample(ShoppingGoodsPhotoExample example);

    int deleteByExample(ShoppingGoodsPhotoExample example);

    int insert(ShoppingGoodsPhoto record);

    int insertSelective(ShoppingGoodsPhoto record);

    List<ShoppingGoodsPhoto> selectByExample(ShoppingGoodsPhotoExample example);

    int updateByExampleSelective(@Param("record") ShoppingGoodsPhoto record, @Param("example") ShoppingGoodsPhotoExample example);

    int updateByExample(@Param("record") ShoppingGoodsPhoto record, @Param("example") ShoppingGoodsPhotoExample example);
}
