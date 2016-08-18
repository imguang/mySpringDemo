package com.imguang.demo.controller.ajaxController.back;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imguang.demo.model.Address;
import com.imguang.demo.model.UserT;
import com.imguang.demo.service.IUserService;

/**
 * 后台操作用户，处理ajax请求
 */
@Controller
@RequestMapping("/userInfoAjax")
public class UserInfoController {

	@Resource
	IUserService userServiceImpl;

	/**
	 * 后台页面ajax添加用户
	 * 
	 * @param userT
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping(value = "/addUser", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> addUser(UserT userT, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean re = userServiceImpl.insert(userT); // AddressEntity
		if (re) {
			map.put("state", "1");
			map.put("re", userT);
		} else {
			map.put("state", "2");
		}

		return map;
	}

	/**
	 * ajax删除后台用户信息
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteUser(@PathVariable Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean re = userServiceImpl.deleteByPrimaryKey(id);
		if (re) {
			map.put("state", "1");
		} else {
			map.put("state", "2");
		}
		return map;
	}

	/**
	 * ajax删除后台用户密码
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/resetUser/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> resetUser(@PathVariable Integer id) {
		Map<String, Object> map = new HashMap<String, Object>();
		String re = userServiceImpl.resetPasswordByPrimaryKey(id);
		if (!re.equals("0")) {
			map.put("state", "1");
			map.put("password", re);
		} else {
			map.put("state", "2");
		}
		return map;
	}

}
