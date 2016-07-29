package com.imguang.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainPageController {
	
	@RequestMapping(value = "/index")
	public String IndexPage() {
		return "Login";
	}

}
