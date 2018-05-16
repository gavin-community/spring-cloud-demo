package com.demo.service;

import java.util.List;

import com.demo.pojo.OrderPojo;

public interface IOrderService {
	public void createOrder(OrderPojo order);
	
	public void updateOrder(OrderPojo order);
	
	public List<OrderPojo> getOrdersByUser(Long userId);
}
