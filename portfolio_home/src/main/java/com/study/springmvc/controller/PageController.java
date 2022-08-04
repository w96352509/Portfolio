package com.study.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/home")
	public String home() {
		return "home";
	}
	
	@RequestMapping("/classify")
	public String classify() {
		return "classify";
	}
	
}
