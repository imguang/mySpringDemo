package com.imguang.demo.service.impl;

import java.util.List;

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
	public List<Address> selectAllAddress() {
//		addressMapper;
		return null;
	}

}
