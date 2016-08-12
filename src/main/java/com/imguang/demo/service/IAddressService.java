package com.imguang.demo.service;

import java.util.List;

import com.imguang.demo.model.Address;

public interface IAddressService {
	public List<Address> selectAllAddress(String userName);

	public boolean insertAddress(Address address);

	public boolean deleteAddress(Integer id, String userName);
}
