package com.imguang.demo.controller.ajaxController.front;

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

import com.imguang.demo.model.Address;
import com.imguang.demo.service.IAddressService;

@Controller
@RequestMapping("/AddressAjax")
public class AddressMechod {
	@Resource
	IAddressService addressServiceImpl;

	@ResponseBody
	@RequestMapping(value = "/showAddress")
	public Map<String, Object> showAddress(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		if (session == null || session.getAttribute("userName") == null) {
			map.put("state", "2");
			return map;
		}
		String userName = (String) session.getAttribute("userName");
		List<Address> addresses = addressServiceImpl.selectAllAddress(userName);
		map.put("rows", addresses);
		map.put("total", addresses.size());
		return map;
	}

	@RequestMapping(value = "/addAddress", method = RequestMethod.POST)
	@ResponseBody
	public Map<String, Object> showAddress(Address address, HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> map = new HashMap<String, Object>();
		boolean re = addressServiceImpl.insertAddress(address);
		// AddressEntity addressEntity = new AddressEntity(address);
		if (re) {
			map.put("state", "1");
			map.put("re", address/* Entity */);
		} else {
			map.put("state", "2");
		}
		return map;
	}

	@RequestMapping(value = "/deleteAddress/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, Object> deleteAddress(@PathVariable Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = request.getSession(false);
		Map<String, Object> map = new HashMap<String, Object>();
		if (session == null || session.getAttribute("userName") == null) {
			map.put("state", "2");
			return map;
		}
		boolean re = addressServiceImpl.deleteAddress(id, (String) session.getAttribute("userName"));
		if (re) {
			map.put("state", "1");
			return map;
		}
		map.put("state", "2");
		return map;
	}

}
