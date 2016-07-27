package com.imguang.demo.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imguang.demo.model.UserT;
import com.imguang.demo.service.impl.ConfirmCodeImpl;
import com.imguang.demo.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/count")
public class RegisterAndLoginController {

	@Resource
	UserServiceImpl UserServiceImpl;
	@Resource
	ConfirmCodeImpl confirmCodeImpl;

	@RequestMapping(value = "/RegisterAndLoginView", method = RequestMethod.GET)
	public String showRegisterAndLoginView() {
		return "RegisterAndLoginView";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(String userName, String password) {
		boolean re = UserServiceImpl.selectUserByName(userName);
		if (!re) {
			return "LoginFailedName";
		} else {
			re = UserServiceImpl
					.selectUserByNameAndPassword(userName, password);
			if (!re) {
				return "LoginFailedTot";
			}
		}
		return "Login";
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(UserT userT, String code, HttpServletRequest request) {
		boolean codeRe = confirmCodeImpl.confirm(code, request);
		if (!codeRe) {
			return "CodeError";
		}
		boolean re = UserServiceImpl.insert(userT);
		if (re) {
			return "Register";
		}
		return "Register_fail";
	}

	@RequestMapping("/img")
	public void crimg(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		confirmCodeImpl.generate(request, response);
	}

}
