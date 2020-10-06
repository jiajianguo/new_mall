package com.xdj.interfaces.mallinterface.mapper;

import com.xdj.www.entity.ShoppingUser;
import com.xdj.www.entity.ShoppingUserExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 */
@Mapper
public interface ShoppingUserMapper {
    long countByExample(ShoppingUserExample example);

    int deleteByExample(ShoppingUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShoppingUser record);

    int insertSelective(ShoppingUser record);

    List<ShoppingUser> selectByExampleWithBLOBs(ShoppingUserExample example);

    List<ShoppingUser> selectByExample(ShoppingUserExample example);

    ShoppingUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShoppingUser record, @Param("example") ShoppingUserExample example);

    int updateByExampleWithBLOBs(@Param("record") ShoppingUser record, @Param("example") ShoppingUserExample example);

    int updateByExample(@Param("record") ShoppingUser record, @Param("example") ShoppingUserExample example);

    int updateByPrimaryKeySelective(ShoppingUser record);

    int updateByPrimaryKeyWithBLOBs(ShoppingUser record);

    int updateByPrimaryKey(ShoppingUser record);

    ShoppingUser getOne(Map<String, Object> map);

    ShoppingUser queryOneByStoreId(Long storeId);

    ShoppingUser findByUsername(@Param("username") String username);

    List<ShoppingUser> queryByCondition(Map<String, Object> map);

    int count(Map<String, Object> map);

    ShoppingUser getUserByOpenId(String openId);

    ShoppingUser findByEmail(@Param("email") String email);
}
