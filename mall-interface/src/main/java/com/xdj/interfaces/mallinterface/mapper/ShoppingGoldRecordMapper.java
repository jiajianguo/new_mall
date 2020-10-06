package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingGoldRecord;
import com.xdj.www.entity.ShoppingGoldRecordExample;
import com.xdj.www.entity.ShoppingGoldRecordWithBLOBs;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingGoldRecordMapper {
    long countByExample(ShoppingGoldRecordExample example);

    int deleteByExample(ShoppingGoldRecordExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingGoldRecordWithBLOBs record);

    int insertSelective(ShoppingGoldRecordWithBLOBs record);

    List<ShoppingGoldRecordWithBLOBs> selectByExampleWithBLOBs(ShoppingGoldRecordExample example);

    List<ShoppingGoldRecord> selectByExample(ShoppingGoldRecordExample example);

    ShoppingGoldRecordWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingGoldRecordWithBLOBs record, @Param("example") ShoppingGoldRecordExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingGoldRecordWithBLOBs record, @Param("example") ShoppingGoldRecordExample example);

    int updateByExample(@Param("record") ShoppingGoldRecord record, @Param("example") ShoppingGoldRecordExample example);

    int updateByPrimaryKeySelective(ShoppingGoldRecordWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingGoldRecordWithBLOBs record);

    int updateByPrimaryKey(ShoppingGoldRecord record);
}
