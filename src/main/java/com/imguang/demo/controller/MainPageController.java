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

import com.imguang.demo.entity.PageInfo;
import com.imguang.demo.model.Product;
import com.imguang.demo.service.IMainPageService;
import com.imguang.demo.service.IProductService;

@Controller
@RequestMapping("/main")
public class MainPageController {

	@Resource
	IProductService productServiceImpl;

	@Resource
	IMainPageService mainPageServiceImpl;

	@RequestMapping(value = "/index")
	public String IndexPage(Model model, HttpServletRequest request, HttpServletResponse response, PageInfo pageInfo) {
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("userName") == null) {
			model.addAttribute("state", "0");
		} else {
			model.addAttribute("state", "1");
			model.addAttribute("userName", session.getAttribute("userName"));
		}
		pageInfo = mainPageServiceImpl.dealPageInfo(pageInfo);
		List<Product> products = new ArrayList<Product>();
		products.addAll(productServiceImpl.selectLimit(pageInfo.getOnePageNum(),
				pageInfo.getOnePageNum() * (pageInfo.getNowPage() - 1)));
		model.addAttribute("pageInfo", pageInfo);
		model.addAttribute("products", products);
		return "mainPage";
	}
}
