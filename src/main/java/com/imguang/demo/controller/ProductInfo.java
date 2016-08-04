package com.imguang.demo.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imguang.demo.service.IProductService;

@Controller
@RequestMapping("/product")
public class ProductInfo {

	@Resource
	IProductService productServiceImpl;

	@RequestMapping("/{productId}")
	public String showProductInfo(@PathVariable int productId, Model model) {
		model.addAttribute("product",
				productServiceImpl.selectByPrimaryKey(productId));
		return "productInfo";
	}
}
