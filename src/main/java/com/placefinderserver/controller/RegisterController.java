package com.placefinderserver.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.placefinderserver.constant.ConfigConstant;
import com.placefinderserver.model.Registration;
import com.placefinderserver.model.UserLoginInfo;
import com.placefinderserver.service.UserService;
import com.placefinderserver.util.ConfigUtil;
import com.placefinderserver.util.PlaceFinderUtil;

/**
 * Controller Class RegistrationController for handling request/response from/to
 * Registration Page.
 * 
 * @author khalidsaif
 *
 */
@Controller
public class RegisterController {

	public static final String EMPLOYEE_ROLE_NAME_KEY = "role.employee.name";
	public static final String ADMIN_ROLE_NAME_KEY = "role.admin.name";

	@Autowired
	private UserService userService;

	@Resource(name = "clientAuthenticationManager")
    protected AuthenticationManager authenticationManager;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String redirectToLoginPage(Model model) {
		// List<String> authorities = getAuthorities();
		model.addAttribute("newUser", new Registration());
		model.addAttribute("authorities", getAllAuthorityNames());
		return "register";
	}

	private List<String> getAllAuthorityNames() {
		List<String> authorities = new ArrayList<String>();
		Properties config = ConfigUtil.getClientConfigProps(ConfigConstant.CONFIG_FILE_PATH);
		authorities.add(config.getProperty(EMPLOYEE_ROLE_NAME_KEY));
		authorities.add(config.getProperty(ADMIN_ROLE_NAME_KEY));
		return authorities;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String login(@Valid @ModelAttribute("newUser") Registration newUser, BindingResult bindingResult, Model model, HttpServletRequest request) {

		if (bindingResult.hasErrors() || !newUser.getNewUserPassword().equals(newUser.getNewUserConfirmPassword())) {
			model.addAttribute("authorities", getAllAuthorityNames());
			return "register";
		}
		UserLoginInfo userLoginInfo = getUserService().addUserLoginInfo(PlaceFinderUtil.getUserLoginInfo(newUser));
		getUserService().addUserAuthorities(newUser.getNewUserEmail(),
				PlaceFinderUtil.getUserAuthorities(newUser.getRole()));
		getUserService().addUserInfo(PlaceFinderUtil.getUserInfo(newUser));
		try {
			request.login(newUser.getNewUserEmail(), newUser.getNewUserPassword());
			HttpSession session = request.getSession();
			User authUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			session.setAttribute("user", authUser.getUsername());
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		authenticateUserAndSetSession(newUser, request);
		return "redirect:account.html";
	}
	
	private void authenticateUserAndSetSession(Registration userLoginInfo, HttpServletRequest request) {
        String username = userLoginInfo.getNewUserEmail();
        String password = userLoginInfo.getNewUserPassword();
        
        try{
        	UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
        	// generate session if one doesn't exist
        	request.getSession();
        	token.setDetails(new WebAuthenticationDetails(request));
        	Authentication authenticatedUser = authenticationManager.authenticate(token);
        	SecurityContextHolder.getContext().setAuthentication(authenticatedUser);
        } catch(Exception exception) {
        	exception.printStackTrace();
        }
    }
}
