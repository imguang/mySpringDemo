package com.imguang.demo.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imguang.demo.model.UserT;
import com.imguang.demo.service.impl.ConfirmCodeImpl;
import com.imguang.demo.service.impl.UserServiceImpl;
import com.imguang.demo.util.IconstLogin;

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
	@ResponseBody
	public Map<String, String> login(String userName, String password) {
		System.out.println(userName + password);
		Map<String, String> map = new HashMap<String, String>();
		boolean re = UserServiceImpl.selectUserByName(userName);
		if (!re) {// 没找到该用户名
			map.put("state", IconstLogin.STATE_NOFOUNDNAME);
		} else {
			re = UserServiceImpl
					.selectUserByNameAndPassword(userName, password);
			if (!re) {// 密码错误
				map.put("state", IconstLogin.STATE_PASSWORDREJECT);
			} else {
				map.put("state", IconstLogin.STATE_SUCCESS);
			}
		}
		return map;
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
