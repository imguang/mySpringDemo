package com.imguang.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.imguang.demo.model.Product;
import com.imguang.demo.model.UserT;
import com.imguang.demo.service.impl.ProductServiceImpl;
import com.imguang.demo.service.impl.UserServiceImpl;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Resource
	UserServiceImpl userServiceImpl;
	@Resource
	ProductServiceImpl ProductServiceImpl;

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

	/*
	 * 添加商品
	 */
	@RequestMapping(value = "/dealAddPro", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> dealAddPro(
			@RequestParam("img") MultipartFile file, Product product,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> map = new HashMap<String, String>();
		String originString = file.getOriginalFilename();
		// 文件没上传或上传失败
		if (originString == null || originString.equals("")) {
			map.put("state", "2");
			return map;
		}
		String path = ProductServiceImpl.transferFile(file, request, response);
		product.setgImgurl(path);
		System.out.println(product.toString());
		String re = ProductServiceImpl.insertProduct(product);
		map.put("state", re);
		return map;
	}

	/*
	 * 商品首页
	 * abandoned
	 
	@RequestMapping(value = "/productInfo")
	public String showProductInfo(Model model) {
		model.addAttribute("products", ProductServiceImpl.selectAllProducts());
		return "back/temProductInfo";
	}*/

	/*
	 * 商品首页测试
	 */
	@RequestMapping(value = "/productInfo")
	public String test() {
		return "back/productInfo";
	}
}
