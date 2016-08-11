package com.imguang.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imguang.demo.model.UserT;
import com.imguang.demo.service.IUserService;

@Controller
@RequestMapping("/userInfo")
public class UserInfoControl {
	@Resource
	IUserService userServiceImpl;

	@RequestMapping(value = "/userIndex/{userName}", method = RequestMethod.GET)
	public String userIndex(@PathVariable("userName") String userName, HttpServletRequest request,
			HttpServletResponse response, Model model) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("userName") == null
				|| !session.getAttribute("userName").equals(userName)) {
			return "redirect:/count/RegisterAndLoginView";
		}
		UserT userT = userServiceImpl.selectUserByUserName(userName);
		model.addAttribute("userInfo", userT);
		return "userIndex";
	}

	@RequestMapping("/addressIndex")
	public String addressIndex() {
		return "addressInfo";
	}
}
