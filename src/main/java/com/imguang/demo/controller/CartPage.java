package com.imguang.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imguang.demo.entity.CartItem;
import com.imguang.demo.service.IProductService;

@Controller
@RequestMapping("/cart")
public class CartPage {

	@Resource
	IProductService productServiceImpl;

	@RequestMapping
	public String cart(Model model, HttpServletRequest request,
			HttpServletResponse response) {

		// 3@TODO
		// 一些判断
		HttpSession session = request.getSession(false);
		/*if (session == null || session.getAttribute("userName") == null) {
			return "redirect:/count/RegisterAndLoginView";
		}*/
		@SuppressWarnings("unchecked")
		Map<Integer, Integer> cart = (Map<Integer, Integer>) session
				.getAttribute("cart");
		if (cart == null || cart.size() == 0) {
			model.addAttribute("total", 0);
		} else {
			List<CartItem> cartItems = new ArrayList<CartItem>();
			for (Map.Entry<Integer, Integer> mapEntry : cart.entrySet()) {
				CartItem cartItem = new CartItem();
				cartItem.setProduct(productServiceImpl
						.selectByPrimaryKey(mapEntry.getKey()));
				cartItem.setNeedNum(mapEntry.getValue());
				cartItems.add(cartItem);
			}
			model.addAttribute("rows", cartItems);
			model.addAttribute("total", cart.size());
		}
		return "cartInfo";
	}
}
