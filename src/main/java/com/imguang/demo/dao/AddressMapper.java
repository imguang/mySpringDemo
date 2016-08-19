package com.imguang.demo.dao;

import java.util.List;
import java.util.Map;

import com.imguang.demo.model.Address;

public interface AddressMapper {
	int deleteByPrimaryKey(Integer id);

	int deleteByPrimaryKeyAndUserName(Map<String, Object> map);

	int insert(Address record);

	int insertSelective(Address record);

	Address selectByPrimaryKey(Integer id);

	List<Address> selectAll(String userName);

	int updateByPrimaryKeySelective(Address record);

	int updateByPrimaryKey(Address record);
}