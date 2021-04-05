package org.studyeasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.studyeasy.model.User;
import org.studyeasy.service.MyUserDetailsService;

@Controller
public class HomeController 
{
	@Autowired
	MyUserDetailsService userDetailsService;
	
	@RequestMapping("/")
	public String home()
	{
		return "home.jsp";
	} 
	@RequestMapping("/login")
	public String loginPage()
	{
		return "login.jsp";
	}
	
	@RequestMapping("/logout-success")
	public String logoutPage()
	{
		return "logout.jsp";
	}
	
	@RequestMapping("/register")
	public String userRegister(Model model, User user)
	{
		model.addAttribute("user",user);
		if(user.getUsername()!= null && user.getPassword()!=null && !user.getUsername().equals(""))
		{
			
				userDetailsService.registerUser(user);
				return "login.jsp";
		}
		else
		{
			return "register.jsp";
		}
		
	}
}
