package com.placefinderserver.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login(ModelMap model) {
		System.out.println("In the login method");
		
		return "login";
	}
	
	@RequestMapping(value="/loginFailed", method=RequestMethod.GET)
	public String loginFailed(ModelMap model) {
		System.out.println("Login Failed");
		
		model.addAttribute("error", "true");
		return "login";
	}
	
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(ModelMap model, HttpSession session) {
		System.out.println("In the logout method");
		SecurityContextHolder.clearContext();
		session.removeAttribute("user");
		return "home";
	}
	
	@RequestMapping(value="/403", method=RequestMethod.GET)
	public String error403(ModelMap model) {
		return "403";
	}
}
