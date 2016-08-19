package com.imguang.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.imguang.demo.dao.OrderItemMapper;
import com.imguang.demo.dao.OrderTotMapper;
import com.imguang.demo.model.OrderItem;
import com.imguang.demo.model.OrderTot;
import com.imguang.demo.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {

	@Resource
	OrderItemMapper orderItemMapper;

	@Resource
	OrderTotMapper orderTotMapper;

	@Override
	public OrderItem selectCasByPrimaryKeyOrderItem(Integer id) {
		return orderItemMapper.selectCasByPrimaryKey(id);
	}

	@Override
	public OrderTot selectCasByPrimaryKeyOrder(Integer id) {
		return orderTotMapper.selectCasByPrimaryKey(id);
	}

	@Override
	public OrderTot selectByPrimaryKeyOrder(Integer id) {
		return orderTotMapper.selectByPrimaryKey(id);
	}

}
