package com.dodoyota.sys.security.controller;

import org.apache.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class UserActionController {

	private Logger logger = Logger.getLogger(UserActionController.class);
	
	@RequestMapping("/addUser")
	@RequiresPermissions("user:add")
	public String addUser() {
		logger.info("添加用户");
		return "admin/addUser";
		
	}
	@RequestMapping("/editUser")
	@RequiresPermissions("user:edit")
	public String editUser() {
		logger.info("编辑用户");
		return "admin/editUser";
		
	}
}
