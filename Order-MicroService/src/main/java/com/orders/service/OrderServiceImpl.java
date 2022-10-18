package com.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orders.model.Orders;

@Service
public class OrderServiceImpl implements IOrdersService {
	
	@Autowired
	IOrdersRepository ordersRepository;

	@Override
	public Integer saveOrders(Orders orders) {
		Orders savedOrders = ordersRepository.save(orders);
		return savedOrders.getOrderId();
	}

	@Override
	public List<Orders> getAllOrders() {
		return ordersRepository.findAll();
	}

	@Override
	public void deleteOrder(Integer id) {
		ordersRepository.deleteById(id);
	}

	@Override
	public void deleteAllOrders() {
		ordersRepository.deleteAll();
	}

}
