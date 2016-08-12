package com.imguang.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.imguang.demo.entity.CartItem;
import com.imguang.demo.service.IAddressService;
import com.imguang.demo.service.IProductService;

@Controller
@RequestMapping("/order")
public class OrderPage {

	@Resource
	IProductService productServiceImpl;

	@Resource
	IAddressService addressServiceImpl;

	@RequestMapping
	public String showPage(@RequestParam("ids") List<String> ids, @RequestParam("needNums") List<String> needNums,
			Model model, HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("userName") == null) {
			return "redirect:/count/RegisterAndLoginView";
		}
		String userName = (String) session.getAttribute("userName");
		int idLenth = ids.size();
		int needNumLenth = needNums.size();
		if (idLenth != needNumLenth) {
			throw new Exception("传输错误");
		}
		int tot_money = 0;
		List<CartItem> cartItems = new ArrayList<CartItem>();
		for (int i = 0; i < idLenth; i++) {
			Integer id = Integer.valueOf(ids.get(i));
			Integer needNum = Integer.valueOf(needNums.get(i));
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
}
