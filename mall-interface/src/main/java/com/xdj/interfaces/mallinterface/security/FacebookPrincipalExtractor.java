package com.xdj.interfaces.mallinterface.security;


import com.xdj.interfaces.mallinterface.mapper.ShoppingUserMapper;
import com.xdj.www.entity.ShoppingRole;
import com.xdj.www.entity.ShoppingUser;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @author Administrator
 */
@Component
public class FacebookPrincipalExtractor extends AbstractPrincipalExtractor {

    @Resource
    private ShoppingUserMapper userMapper;

    @Override
    public ShoppingUser getUserByOpenId(String id) {
        return userMapper.getUserByOpenId(id);
    }

    @Override
    public ShoppingRole getUserRoleByOauth2ClientName() {
        ShoppingRole role = new ShoppingRole();
        role.setRolename("FACEBOOK");
        return role;
    }


}
