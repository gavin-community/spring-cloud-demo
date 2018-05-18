package com.demo.service;

import java.util.List;

import com.demo.pojo.OrderPojo;

public interface IOrderService {
	public List<OrderPojo> createOrder(String size,String userId);
	
	public void updateOrder(OrderPojo order);
	
	public List<OrderPojo> getOrdersByUser(Long userId);
}
