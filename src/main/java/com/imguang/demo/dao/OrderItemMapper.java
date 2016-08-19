package com.imguang.demo.dao;

import com.imguang.demo.model.OrderItem;

public interface OrderItemMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(OrderItem record);

	int insertSelective(OrderItem record);

	OrderItem selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(OrderItem record);

	int updateByPrimaryKey(OrderItem record);

	OrderItem selectCasByPrimaryKey(Integer id);

	OrderItem selectCasByOrderId(String id);
}