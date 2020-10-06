package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingComplaint;
import com.xdj.www.entity.ShoppingComplaintExample;
import com.xdj.www.entity.ShoppingComplaintWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingComplaintMapper {
    long countByExample(ShoppingComplaintExample example);

    int deleteByExample(ShoppingComplaintExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingComplaintWithBLOBs record);

    int insertSelective(ShoppingComplaintWithBLOBs record);

    List<ShoppingComplaintWithBLOBs> selectByExampleWithBLOBs(ShoppingComplaintExample example);

    List<ShoppingComplaint> selectByExample(ShoppingComplaintExample example);

    ShoppingComplaintWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingComplaintWithBLOBs record, @Param("example") ShoppingComplaintExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingComplaintWithBLOBs record, @Param("example") ShoppingComplaintExample example);

    int updateByExample(@Param("record") ShoppingComplaint record, @Param("example") ShoppingComplaintExample example);

    int updateByPrimaryKeySelective(ShoppingComplaintWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingComplaintWithBLOBs record);

    int updateByPrimaryKey(ShoppingComplaint record);

    List<ShoppingComplaintWithBLOBs> queryByCondition(Map<String, Object> map);

    int count(Map<String, Object> map);
}
