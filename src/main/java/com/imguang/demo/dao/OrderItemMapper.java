package com.imguang.demo.dao;

import java.util.List;

import com.imguang.demo.model.OrderItem;

public interface OrderItemMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(OrderItem record);

	int insertBatch(List<OrderItem> orderItems);

	int insertSelective(OrderItem record);

	OrderItem selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(OrderItem record);

	int updateByPrimaryKey(OrderItem record);

	OrderItem selectCasByPrimaryKey(Integer id);

	List<OrderItem> selectCasByOrderId(String id);
}