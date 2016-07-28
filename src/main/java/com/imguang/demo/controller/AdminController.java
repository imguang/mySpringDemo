package com.imguang.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imguang.demo.model.UserT;
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

	/*
	 * 删除记录
	 */
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteOne(@PathVariable("id") int id) {
		userServiceImpl.deleteByPrimaryKey(id);
		return "redirect:/admin";
	}

	/*
	 * 将密码重置
	 */
	@RequestMapping(value = "/reset/{id}", method = RequestMethod.GET)
	public String reSet(@PathVariable("id") int id) {
		userServiceImpl.resetPasswordByPrimaryKey(id);
		return "redirect:/admin";
	}

	/*
	 * 添加一个账号
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addAccount(
			@ModelAttribute("userName,password,email") UserT userT) {
		userServiceImpl.insert(userT);
		return "redirect:/admin";
	}

}
