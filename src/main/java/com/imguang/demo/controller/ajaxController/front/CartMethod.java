package com.imguang.demo.controller.ajaxController.front;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 购物车的异步操作
 */
@Controller
@RequestMapping("/cartAjax")
public class CartMethod {

	@RequestMapping("/addToCart")
	@ResponseBody
	public Map<String, String> addToCart(int productId, int number,
			HttpServletRequest request, HttpServletResponse response) {
		// 3@TODO
		// 一些判断
		HttpSession session = request.getSession(false);
		Map<String, String> map = new HashMap<String, String>();
		if (session == null || session.getAttribute("userName") == null) {
			map.put("state", "2");
			return map;
		}

		@SuppressWarnings("unchecked")
		Map<Integer, Integer> cart = (Map<Integer, Integer>) session
				.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Integer, Integer>();
			cart.put(productId, number);
		} else {
			cart.put(productId,
					cart.get(productId) == null ? number : cart.get(productId)
							+ number);
		}
		session.setAttribute("cart", cart);
		map.put("state", "1");
		map.put("cartNum", String.valueOf(cart.size()));
		return map;
	}
}
