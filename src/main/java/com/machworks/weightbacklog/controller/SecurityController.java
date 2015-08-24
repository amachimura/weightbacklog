package com.machworks.weightbacklog.controller;

import com.machworks.weightbacklog.dto.GoalDto;
import com.machworks.weightbacklog.dto.SprintDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.machworks.weightbacklog.dto.UserDto;
import com.machworks.weightbacklog.service.SecurityServiceSpec;

@Controller
public class SecurityController {

	@Autowired
	private SecurityServiceSpec service;
	
	@RequestMapping("/")
	public String showLogin() {
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(@RequestParam(value="userName")String userName, @RequestParam(value="password")String password){
		UserDto user = new UserDto();
		user.setId(service.generateId());
		user.setUserName(userName);
		user.setPassword(password);
		if(!service.isExistUser(user)){
			return registerUser(userName,password);
		}
		return showDaily(userName);
	}
	
	@RequestMapping("/register")
	public String registerUser(@RequestParam(value="userName")String userName, @RequestParam(value="password")String password){
		UserDto user = new UserDto();
		user.setId(service.generateId());
		user.setUserName(userName);
		user.setPassword(password);
		service.registerUser(user);
		return "redirect:/admin/"+userName;
	}
	
	@RequestMapping("/admin/{userName}")
	public String showAdmin(@PathVariable("userName")String userName){
		return "admin";
	}
	
	@RequestMapping("/daily/{userName}")
	public String showDaily(@PathVariable("userName")String userName){

		return "dailyreport";
	}
}
