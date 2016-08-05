package com.imguang.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cart")
public class CartPage {

	@RequestMapping
	public String cart() {
		return "cartInfo";
	}
}
