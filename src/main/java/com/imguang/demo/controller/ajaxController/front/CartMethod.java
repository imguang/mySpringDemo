package com.imguang.demo.controller.ajaxController.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imguang.demo.entity.CartItem;
import com.imguang.demo.service.IProductService;

/**
 * 购物车的异步操作
 */
@Controller
@RequestMapping("/cartAjax")
public class CartMethod {

	@Resource
	IProductService productServiceImpl;

	@RequestMapping("/addToCart")
	@ResponseBody
	public Map<String, String> addToCart(int productId, int number, HttpServletRequest request,
			HttpServletResponse response) {
		// 3@TODO 应再封装一层service层
		// 一些判断
		HttpSession session = request.getSession(false);
		Map<String, String> map = new HashMap<String, String>();
		if (session == null || session.getAttribute("userName") == null) {
			map.put("state", "2");
			return map;
		}

		@SuppressWarnings("unchecked")
		Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
		if (cart == null) {
			cart = new HashMap<Integer, Integer>();
			cart.put(productId, number);
		} else {
			cart.put(productId, cart.get(productId) == null ? number : cart.get(productId) + number);
		}
		session.setAttribute("cart", cart);
		map.put("state", "1");
		map.put("cartNum", String.valueOf(cart.size()));
		return map;
	}

	// 删除购物车中的商品
	@RequestMapping(value = "/deleteOneCart/{productId}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> deleteOneCart(@PathVariable int productId, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		Map<String, String> map = new HashMap<String, String>();
		@SuppressWarnings("unchecked")
		Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");

		if (cart.get(productId) == null) {
			map.put("state", "0");
		} else {
			cart.remove(productId);
			map.put("state", "1");
			session.setAttribute("cart", cart);
		}
		return map;
	}

	// abandon
	@RequestMapping(value = "/cartInfo", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> cartInfo(int limit, int offset, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		if (session == null || session.getAttribute("userName") == null) {
			map.put("total", 0);
			return map;
		}
		@SuppressWarnings("unchecked")
		Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
		if (cart == null || cart.size() == 0) {
			map.put("total", 0);
			return map;
		} else {
			List<CartItem> cartItems = new ArrayList<CartItem>();
			for (Map.Entry<Integer, Integer> mapEntry : cart.entrySet()) {
				CartItem cartItem = new CartItem();
				cartItem.setProduct(productServiceImpl.selectByPrimaryKey(mapEntry.getKey()));
				cartItem.setNeedNum(mapEntry.getValue());
				cartItems.add(cartItem);
			}
			map.put("rows", cartItems);
			map.put("total", cart.size());
		}
		return map;
	}
}
