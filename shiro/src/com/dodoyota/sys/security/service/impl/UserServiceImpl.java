package com.dodoyota.sys.security.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dodoyota.sys.security.dao.UserPoMapper;
import com.dodoyota.sys.security.service.UserService;

/**
 * 用户
 * @author gaoyuandong
 * @mailto 466862016@qq.com
 * 2013-8-14 上午10:00:08
 */
@Service
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserPoMapper userPoMapper;
}
