package com.machworks.weightbacklog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.machworks.weightbacklog.service.SecurityServiceSpec;

@Controller
public class SecurityController {

	@Autowired
	private SecurityServiceSpec service;
	
	@RequestMapping("/")
	public String showLogin() {
		return "index";
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
