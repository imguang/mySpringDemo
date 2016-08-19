package com.imguang.demo.service;

import com.imguang.demo.model.OrderItem;
import com.imguang.demo.model.OrderTot;

public interface IOrderService {
	public OrderItem selectCasByPrimaryKeyOrderItem(Integer id);

	public OrderTot selectCasByPrimaryKeyOrder(Integer id);

	public OrderTot selectByPrimaryKeyOrder(Integer id);

}
