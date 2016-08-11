package com.imguang.demo.controller.ajaxController.front;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.imguang.demo.model.Address;

@Controller
@RequestMapping("/AddressAjax")
public class AddressMechod {

	@ResponseBody
	@RequestMapping(value = "/showAddress")
	public Map<String, Object> showAddress(int limit, int offset, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		System.out.println(limit + " " + offset);
		Map<String, Object> map = new HashMap<String, Object>();
		Address address = new Address("imguang", "石伟光", "福建省", "漳州市", "南靖县", "363600", "18650467392");
		List<Address> addresses = new ArrayList<Address>();
		addresses.add(address);
		map.put("rows", addresses);
		map.put("total", 1);
		return map;
	}

}
