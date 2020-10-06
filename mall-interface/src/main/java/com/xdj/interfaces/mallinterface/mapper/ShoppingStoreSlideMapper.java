package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingStoreSlide;
import com.xdj.www.entity.ShoppingStoreSlideExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingStoreSlideMapper {
    long countByExample(ShoppingStoreSlideExample example);

    int deleteByExample(ShoppingStoreSlideExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingStoreSlide record);

    int insertSelective(ShoppingStoreSlide record);

    List<ShoppingStoreSlide> selectByExample(ShoppingStoreSlideExample example);

    ShoppingStoreSlide selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingStoreSlide record, @Param("example") ShoppingStoreSlideExample example);

    int updateByExample(@Param("record") ShoppingStoreSlide record, @Param("example") ShoppingStoreSlideExample example);

    int updateByPrimaryKeySelective(ShoppingStoreSlide record);

    int updateByPrimaryKey(ShoppingStoreSlide record);

    List<ShoppingStoreSlide> queryByCondition(Map<String, Object> params);
}
