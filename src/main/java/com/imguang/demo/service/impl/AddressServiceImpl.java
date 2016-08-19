package com.imguang.demo.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imguang.demo.dao.AddressMapper;
import com.imguang.demo.model.Address;
import com.imguang.demo.service.IAddressService;

@Service
public class AddressServiceImpl implements IAddressService {

	@Resource
	AddressMapper addressMapper;

	@Override
	public List<Address> selectAllAddress(String userName) {
		List<Address> addresses = new ArrayList<Address>();
		addresses.addAll(addressMapper.selectAll(userName));
		return addresses;
	}

	@Override
	public boolean insertAddress(Address address) {
		int re = addressMapper.insert(address);
		if (re > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAddress(Integer id, String userName) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("userName", userName);
		int re = addressMapper.deleteByPrimaryKeyAndUserName(map);
		if (re > 0) {
			return true;
		}
		return false;
	}

}
