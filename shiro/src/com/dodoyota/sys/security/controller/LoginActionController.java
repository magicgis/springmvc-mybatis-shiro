package com.dodoyota.sys.security.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dodoyota.sys.security.po.UserPo;

@Controller
@RequestMapping("/login")
public class LoginActionController {

	
	Logger logger = Logger.getLogger(LoginActionController.class);
	@RequestMapping("/toLogin")
	public String toLogin() {
		
		return "index";
	}
	
	
	/***
	 * 用户登录
	 * 进行身份验证
	 * @return
	 */
	@RequestMapping("/login")
	public String login(UserPo userPo ) {
		Subject currentUser = SecurityUtils.getSubject();
		Session session = currentUser.getSession();
		
		if(!currentUser.isAuthenticated()) { //没有认证
			UsernamePasswordToken token = new UsernamePasswordToken(userPo.getUseraccount(), userPo.getPassword());
			token.setRememberMe(true);
			try {
				currentUser.login(token);
				
				session.setAttribute("user", userPo);
				return "admin/index";
			} catch (AuthenticationException e) {
				e.printStackTrace();
			}
		} else { //已经 进行过认证
			return "admin/index";
		}
		return "login";
		
	}
}
