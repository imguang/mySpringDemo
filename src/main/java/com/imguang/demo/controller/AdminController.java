package com.imguang.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imguang.demo.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource
	UserServiceImpl userServiceImpl;

	@RequestMapping(method = RequestMethod.GET)
	public String showUserInfo(Model model) {
		model.addAttribute("users", userServiceImpl.selectAllUserTs());
		return "back/userInfo";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteOne(@PathVariable("id") int id) {
		userServiceImpl.deleteByPrimaryKey(id);
		return "redirect:/admin";
	}

}
