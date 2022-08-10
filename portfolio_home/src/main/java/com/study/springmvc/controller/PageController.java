package com.study.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping("/home")
	public String getHomePage() {
		return "home";
	}
	
	@RequestMapping("/classify")
	public String getClassifyPage() {
		return "classify";
	}
	
	@RequestMapping("/tstock")
    public String getTStockPage() {
        return "tstock";
    }
	
}
