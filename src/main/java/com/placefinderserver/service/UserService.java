package com.placefinderserver.service;

import java.util.List;

import com.placefinderserver.model.Authority;
import com.placefinderserver.model.UserInfo;
import com.placefinderserver.model.UserLoginInfo;

public interface UserService {

	UserLoginInfo addUserLoginInfo(UserLoginInfo userLoginInfo);
	
	UserInfo addUserInfo(UserInfo userInfo);
	
	void addUserAuthorities(String username, List<String> authorities);
}
