package com.dodoyota.sys.security.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import com.dodoyota.sys.security.dao.PermissionPoMapper;
import com.dodoyota.sys.security.dao.UserPoMapper;
import com.dodoyota.sys.security.po.UserPo;
import com.dodoyota.sys.security.po.UserPoQuery;
import com.dodoyota.sys.security.service.ShiroRealmService;


@Service
public class ShiroRealmServiceImpl extends AuthorizingRealm implements ShiroRealmService {

	@Resource
	private PermissionPoMapper permissionPoMapper;
	@Resource
	private UserPoMapper userPoMapper;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		String userAccount =(String) principals.fromRealm(getName()).iterator().next();
		if(userAccount!=null) {
			Collection<String> pres = this.permissionPoMapper.queryPermissionsByUseraccount(userAccount);
			if(pres!=null&&!pres.isEmpty()) {
				SimpleAuthorizationInfo authorizationInfo = new  SimpleAuthorizationInfo();
				for(String token :pres) {
					
					authorizationInfo.addStringPermission(token);
				}
				
				return authorizationInfo;
			}
		}
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken token2 = (UsernamePasswordToken) token;
		String userAccount = token2.getUsername();
		if(StringUtils.isNotBlank(userAccount)) {
			UserPoQuery example = new UserPoQuery();
			example.createCriteria().andUseraccountEqualTo(userAccount);
			List<UserPo> userPos = this.userPoMapper.selectByExample(example);
			
			if(userPos!=null&&!userPos.isEmpty()){
				return new SimpleAuthenticationInfo(userPos.get(0).getUseraccount(), userPos.get(0).getPassword(), getName());
			}
		}
		return null;
	}
	
}
