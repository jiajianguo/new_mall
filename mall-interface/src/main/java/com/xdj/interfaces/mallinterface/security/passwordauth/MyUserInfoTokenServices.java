package com.xdj.interfaces.mallinterface.security.passwordauth;


import com.xdj.interfaces.mallinterface.mapper.ShoppingUserMapper;
import com.xdj.interfaces.mallinterface.security.AbstractPrincipalExtractor;
import com.xdj.interfaces.mallinterface.util.SpringUtils;
import com.xdj.www.entity.ShoppingUser;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;


/**
 * @author Administrator
 */
public class MyUserInfoTokenServices extends UserInfoTokenServices {


    private String oauth2Type;

    public MyUserInfoTokenServices(String userInfoEndPointUrl, String clienId, AbstractPrincipalExtractor principalExtractor) {
        super(userInfoEndPointUrl, clienId);
        super.setPrincipalExtractor(principalExtractor);
    }

    public ShoppingUser getUserByOpenId(String openId) {
        ShoppingUserMapper userMapper=SpringUtils.getBean("shoppingUserMapper",ShoppingUserMapper.class);
        return userMapper.getUserByOpenId(openId);
    }
}
