package com.imguang.demo.service;

import java.util.List;

import com.imguang.demo.model.OrderItem;
import com.imguang.demo.model.OrderTot;

public interface IOrderService {
	public OrderItem selectCasByPrimaryKeyOrderItem(Integer id);

	public OrderTot selectCasByPrimaryKeyOrder(Integer id);

	public List<OrderTot> selectCasByUserNameOrder(String userName);
	
	public OrderTot selectByPrimaryKeyOrder(Integer id);

	public OrderTot insertOrderAndOrderItem(List<OrderItem> orderItems, OrderTot orderTot);

}
