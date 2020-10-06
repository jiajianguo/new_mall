package com.xdj.interfaces.mallinterface.security;


import com.xdj.interfaces.mallinterface.service.IRoleService;
import com.xdj.www.entity.ShoppingRole;
import com.xdj.www.entity.ShoppingUser;

import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class AbstractPrincipalExtractor implements PrincipalExtractor {

  @Resource
  private IRoleService roleService;

  /**
   * 用户openid
   */
  public abstract ShoppingUser getUserByOpenId(String id);
  //用户角色，用“FACEBOOK"代表facebook用户，”GITHUB"代表"github用户
  public abstract ShoppingRole getUserRoleByOauth2ClientName();

  @Override
  public Object extractPrincipal(Map<String, Object> map) {
    //得到对于的社交平台的openid
    String id =  map.get("id").toString();
    ShoppingUser user = getUserByOpenId(id);
    if (user == null) {
      user = new ShoppingUser();
      user.setUsername(map.get("id").toString());
      List<ShoppingRole> roles = roleService.queryRoleByUserId(user.getId());
      List<GrantedAuthority> authorities = new ArrayList();
      if (roles != null) {
        Iterator roleIterator = roles.iterator();
        while (roleIterator.hasNext()) {
          ShoppingRole role = (ShoppingRole) roleIterator.next();
          if ("ADMIN".equalsIgnoreCase(role.getType())) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRolecode().toUpperCase());
            authorities.add(grantedAuthority);
          } else {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRolecode().toUpperCase());
            authorities.add(grantedAuthority);
          }
        }
      }
      user.setAuthorities(authorities);
    }
    return user.getUsername();
  }
}
