package com.placefinderserver.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.placefinderserver.constant.ConfigConstant;
import com.placefinderserver.model.Authority;
import com.placefinderserver.model.Registration;
import com.placefinderserver.model.UserInfo;
import com.placefinderserver.model.UserLoginInfo;

public class PlaceFinderUtil {
	
	public static final String EMPLOYEE_ROLE_KEY = "role.employee";
	public static final String ADMIN_ROLE_KEY = "role.admin";
	public static final String ADMIN_ROLE_NAME_KEY = "role.admin.name";
	

	/**
	 * Method to create UserInfo object from Registration object
	 * 
	 * @param newUser
	 *            Registration Class object
	 * @return UserInfo Class object
	 */
	public static UserInfo getUserInfo(Registration newUser) {
		final UserInfo userInfo = new UserInfo();
		userInfo.setFirstName(newUser.getNewUserFirstName());
		userInfo.setLastName(newUser.getNewUserLastName());
		userInfo.setEmail(newUser.getNewUserEmail());
		userInfo.setMobile(newUser.getMobile());
		return userInfo;
	}
	
	/**
	 * Method to create UserLoginInfo object from Registration object
	 * 
	 * @param newUser
	 *            Registration Class object
	 * @return UserLoginInfo Class object
	 */
	public static UserLoginInfo getUserLoginInfo(Registration newUser) {
		final UserLoginInfo userLoginInfo = new UserLoginInfo();
		userLoginInfo.setUsername(newUser.getNewUserEmail());
		userLoginInfo.setPassword(getEncryptedPassword(newUser.getNewUserPassword()));
		userLoginInfo.setEnabled((byte) 1);
		return userLoginInfo;
	}
	
	public static String getEncryptedPassword(String password) {
		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = bCryptPasswordEncoder.encode(password);
		return encodedPassword;
	}
	
	public static Authority getAuthority(String username, String authority) {
		Authority authorityModel = new Authority();
		authorityModel.setUsername(username);
		authorityModel.setAuthority(authority);
		
		return authorityModel;
	}
	
	public static List<String> getUserAuthorities(String userPreferredAuthority) {
		Properties config = ConfigUtil.getClientConfigProps(ConfigConstant.CONFIG_FILE_PATH);
		List<String> userAuthorities = new ArrayList<String>();
		userAuthorities.add(config.getProperty(EMPLOYEE_ROLE_KEY));
		
		if(userPreferredAuthority.equals(config.getProperty(ADMIN_ROLE_NAME_KEY))) {
			userAuthorities.add(config.getProperty(ADMIN_ROLE_KEY));
		}
		
		return userAuthorities;
	}
}
