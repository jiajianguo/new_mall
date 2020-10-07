package com.xdj.interfaces.mallinterface.security.passwordauth;

import java.util.*;

import com.xdj.interfaces.mallinterface.mapper.ShoppingUserMapper;
import com.xdj.interfaces.mallinterface.service.IResService;
import com.xdj.interfaces.mallinterface.service.IRoleService;
import com.xdj.www.entity.ShoppingRes;
import com.xdj.www.entity.ShoppingResExample;
import com.xdj.www.entity.ShoppingRole;
import com.xdj.www.entity.ShoppingUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.helpers.SubstituteLogger;
import org.springframework.boot.autoconfigure.security.oauth2.resource.UserInfoTokenServices;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author Administrator
 */
@Service("userDetailsService")
public class UserDetailsServiceImpl  implements UserDetailsService {

	@Resource
	private ShoppingUserMapper userDAO;
	@Resource
	private IRoleService roleService;
	@Resource
	private IResService resService;

	private Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		log.info("------login-verify------{}",email);
		ShoppingUser user = userDAO.findByEmail(email);
		if(user != null) {
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
			return user;
		}
			return null;
	}

	public  Map<String, Object> loadUrlAuthorities(){
		Map<String, Object> urlAuthorities = new HashMap<String, Object>();
		Map<String, Object> params = new HashMap<String, Object>();
		//params.put("type", "URL");
		ShoppingResExample resExample = new ShoppingResExample();
		resExample.createCriteria().andTypeEqualTo("URL");
		List<ShoppingRes> urlResources =resService.selectByExample(resExample);
		for (ShoppingRes res : urlResources) {
			params.put("res_id",res.getId());
			List<ShoppingRole> roles = roleService.queryByCondition(params);
			List roleAuthorities = new ArrayList();
			for (ShoppingRole role : roles) {
				roleAuthorities.add(role.getRolecode());
			}
			urlAuthorities.put(res.getValue(), roleAuthorities);
		}
		return urlAuthorities;
	}


	public ShoppingUser getUserByOpenId(String id) {
		return userDAO.getUserByOpenId(id);
	}
}
