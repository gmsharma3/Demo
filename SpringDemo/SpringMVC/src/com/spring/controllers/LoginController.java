package com.spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.model.User;

@Controller
public class LoginController {

	/*@RequestMapping(value = "/index" , method = RequestMethod.GET)
	public ModelAndView index(Model model) {
		model.addAttribute("user", new User());
		return new ModelAndView("index");
	}*/
	
	@RequestMapping("/home.htm")
	public ModelAndView loginCheck(User user){
		return new ModelAndView("home", "message", "Hello " + user.getUsername());
	}
	
}
