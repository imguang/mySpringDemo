package com.imguang.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.imguang.demo.entity.CartItem;
import com.imguang.demo.model.OrderItem;
import com.imguang.demo.model.OrderTot;
import com.imguang.demo.service.IAddressService;
import com.imguang.demo.service.IOrderService;
import com.imguang.demo.service.IProductService;

@Controller
@RequestMapping("/order")
public class OrderPage {

	@Resource
	IProductService productServiceImpl;

	@Resource
	IAddressService addressServiceImpl;

	@Resource
	IOrderService orderServiceImpl;

	@RequestMapping("/show")
	public String showPage(@RequestParam("ids") List<String> ids, @RequestParam("needNums") List<String> needNums,
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		String userName = (String) session.getAttribute("userName");
		int idLenth = ids.size();
		int needNumLenth = needNums.size();
		if (idLenth != needNumLenth) {
			throw new Exception("传输错误");
		}
		@SuppressWarnings("unchecked")
		Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
		int tot_money = 0;
		List<CartItem> cartItems = new ArrayList<CartItem>();
		for (int i = 0; i < idLenth; i++) {
			Integer id = Integer.valueOf(ids.get(i));
			Integer needNum = Integer.valueOf(needNums.get(i));
			cart.put(id, needNum);// 修改购物车内容
			CartItem cartItem = new CartItem();
			cartItem.setProduct(productServiceImpl.selectByPrimaryKey(id));
			cartItem.setNeedNum(needNum);
			cartItems.add(cartItem);
			tot_money += needNum * cartItem.getgPrice();
		}
		model.addAttribute("tot_money", tot_money);
		model.addAttribute("cartItems", cartItems);
		model.addAttribute("addresses", addressServiceImpl.selectAllAddress(userName));
		return "comfirmOrder";
	}

	/**
	 * @param productId
	 * @param needNum
	 * @param totPrice
	 * @param addressId
	 * @param request
	 * @param response
	 */
	@RequestMapping("/comfirm")
	public ModelAndView comfirmOrder(@RequestParam("productId") List<Integer> productId,
			@RequestParam("needNum") List<Integer> needNum, @RequestParam("totPrice") List<String> totPrice,
			@RequestParam("addressId") Integer addressId, HttpServletRequest request, HttpServletResponse response) {
		ModelAndView modelAndView = new ModelAndView();
		HttpSession session = request.getSession();
		String orderId = UUID.randomUUID().toString().replaceAll("-", "");
		int size = productId.size();
		// 准备订单项
		List<OrderItem> orderItems = new ArrayList<OrderItem>();
		Double totMoney = 0.0;
		for (int i = 0; i < size; i++) {
			OrderItem orderItem = new OrderItem();
			Double perPrice = Double.valueOf(totPrice.get(i));
			orderItem.setOrderid(orderId);
			orderItem.setpNum(needNum.get(i));
			orderItem.setpPrice(perPrice);
			orderItem.setProductid(productId.get(i));
			totMoney += perPrice;
			orderItems.add(orderItem);
		}
		// 准备订单主表
		OrderTot orderTot = new OrderTot();
		orderTot.setAddressid(addressId);
		orderTot.setOrderid(orderId);
		orderTot.setoState("1");
		orderTot.setTotMoney(totMoney);
		orderTot.setUserName((String) session.getAttribute("userName"));

		orderTot = orderServiceImpl.insertOrderAndOrderItem(orderItems, orderTot);
		System.out.println(orderTot);
		if (orderTot == null || orderTot.getId() == null) {
			// 插入失败时操作
			modelAndView.setViewName("/front/OrderError");
			return modelAndView;
		}

		// 删除购物车内容
		@SuppressWarnings("unchecked")
		Map<Integer, Integer> cart = (Map<Integer, Integer>) session.getAttribute("cart");
		for (int i = 0; i < size; i++) {
			cart.remove(productId.get(i));
		}
		session.setAttribute("cart", cart);

		modelAndView.addObject("OrderInfo", orderTot);
		modelAndView.setViewName("/front/OrderFinish");
		modelAndView.addObject("userName", session.getAttribute("userName"));
		modelAndView.addObject("cartNum", cart.size());
		return modelAndView;
	}

}
