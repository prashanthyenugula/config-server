package com.orders.service;

import java.util.List;

import com.orders.model.Orders;

public interface IOrdersService {
	
	Integer saveOrders(Orders orders);

	public List<Orders> getAllOrders();
	
	public void deleteOrder(Integer id);

	public void deleteAllOrders();
	
	
}
