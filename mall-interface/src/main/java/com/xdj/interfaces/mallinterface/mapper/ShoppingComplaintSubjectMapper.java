package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingComplaintSubject;
import com.xdj.www.entity.ShoppingComplaintSubjectExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingComplaintSubjectMapper {
    long countByExample(ShoppingComplaintSubjectExample example);

    int deleteByExample(ShoppingComplaintSubjectExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingComplaintSubject record);

    int insertSelective(ShoppingComplaintSubject record);

    List<ShoppingComplaintSubject> selectByExampleWithBLOBs(ShoppingComplaintSubjectExample example);

    List<ShoppingComplaintSubject> selectByExample(ShoppingComplaintSubjectExample example);

    ShoppingComplaintSubject selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingComplaintSubject record, @Param("example") ShoppingComplaintSubjectExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingComplaintSubject record, @Param("example") ShoppingComplaintSubjectExample example);

    int updateByExample(@Param("record") ShoppingComplaintSubject record, @Param("example") ShoppingComplaintSubjectExample example);

    int updateByPrimaryKeySelective(ShoppingComplaintSubject record);

    int updateByPrimaryKeyWithBLOBs(ShoppingComplaintSubject record);

    int updateByPrimaryKey(ShoppingComplaintSubject record);

    List<ShoppingComplaintSubject> queryByCondition(Map<String, Object> params);
}
