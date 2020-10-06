package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingSecondsKill;
import com.xdj.www.entity.ShoppingSecondsKillExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
/**
 * @author Administrator
 */

@Mapper
public interface ShoppingSecondsKillMapper {
    long countByExample(ShoppingSecondsKillExample example);

    int deleteByExample(ShoppingSecondsKillExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingSecondsKill record);

    int insertSelective(ShoppingSecondsKill record);

    List<ShoppingSecondsKill> selectByExample(ShoppingSecondsKillExample example);

    ShoppingSecondsKill selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingSecondsKill record, @Param("example") ShoppingSecondsKillExample example);

    int updateByExample(@Param("record") ShoppingSecondsKill record, @Param("example") ShoppingSecondsKillExample example);

    int updateByPrimaryKeySelective(ShoppingSecondsKill record);

    int updateByPrimaryKey(ShoppingSecondsKill record);

    List<ShoppingSecondsKill> queryByCondition(Map params);

}
