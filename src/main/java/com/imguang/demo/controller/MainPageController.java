package com.imguang.demo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainPageController {

	@RequestMapping(value = "/index")
	public String IndexPage(Model model, HttpServletRequest request) {
		// @TODO 用拦截器
		HttpSession httpSession = request.getSession(false);
		if (httpSession == null || httpSession.getAttribute("userName") == null) {
			return "redirect:/count/RegisterAndLoginView";
		} else {
			return "mainPage";
		}
	}

}
