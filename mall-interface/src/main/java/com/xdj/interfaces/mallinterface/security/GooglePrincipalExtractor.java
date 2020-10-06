package com.xdj.interfaces.mallinterface.security;

import com.xdj.interfaces.mallinterface.mapper.ShoppingUserMapper;
import com.xdj.www.entity.ShoppingRole;
import com.xdj.www.entity.ShoppingUser;

import javax.annotation.Resource;

/**
 * @author Administrator
 */
public class GooglePrincipalExtractor extends AbstractPrincipalExtractor {
    @Resource
    private ShoppingUserMapper userMapper;

    @Override
    public ShoppingUser getUserByOpenId(String id) {
        return userMapper.getUserByOpenId(id);
    }

    @Override
    public ShoppingRole getUserRoleByOauth2ClientName() {
        ShoppingRole role = new ShoppingRole();
        role.setRolename("GOOGLE");
        return role;
    }
}
