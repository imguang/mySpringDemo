package com.imguang.demo.controller.ajaxController;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.imguang.demo.model.Product;
import com.imguang.demo.service.impl.ProductServiceImpl;

@Controller
@RequestMapping(value = "/backProductAjax")
public class backProductController {

	@Resource
	ProductServiceImpl productServiceImpl;

	@RequestMapping(value = "/deleteOneProduct/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> deleteOneProduct(@PathVariable("id") int id,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> reMap = new HashMap<String, String>();
		String re = productServiceImpl.deleteOneProducts(id, request, response);
		reMap.put("state", re);
		return reMap;
	}

	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, String> updateProduct(
			@RequestParam("img") MultipartFile file, Product product,
			HttpServletRequest request, HttpServletResponse response) {
		Map<String, String> reMap = new HashMap<String, String>();
		String re = productServiceImpl.updateProduct(file, product, request,
				response);
		reMap.put("state", re);
		return reMap;
	}
}
