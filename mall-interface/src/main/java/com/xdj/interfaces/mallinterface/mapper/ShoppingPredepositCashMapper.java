package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingPredepositCash;
import com.xdj.www.entity.ShoppingPredepositCashExample;
import com.xdj.www.entity.ShoppingPredepositCashWithBLOBs;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingPredepositCashMapper {
    long countByExample(ShoppingPredepositCashExample example);

    int deleteByExample(ShoppingPredepositCashExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingPredepositCashWithBLOBs record);

    int insertSelective(ShoppingPredepositCashWithBLOBs record);

    List<ShoppingPredepositCashWithBLOBs> selectByExampleWithBLOBs(ShoppingPredepositCashExample example);

    List<ShoppingPredepositCash> selectByExample(ShoppingPredepositCashExample example);

    ShoppingPredepositCashWithBLOBs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingPredepositCashWithBLOBs record, @Param("example") ShoppingPredepositCashExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingPredepositCashWithBLOBs record, @Param("example") ShoppingPredepositCashExample example);

    int updateByExample(@Param("record") ShoppingPredepositCash record, @Param("example") ShoppingPredepositCashExample example);

    int updateByPrimaryKeySelective(ShoppingPredepositCashWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ShoppingPredepositCashWithBLOBs record);

    int updateByPrimaryKey(ShoppingPredepositCash record);

    List<ShoppingPredepositCashWithBLOBs> queryByCondition(Map<String, Object> map);

    int count(Map<String, Object> map);
}
