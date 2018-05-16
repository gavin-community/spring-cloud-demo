package com.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.demo.pojo.OrderPojo;
import com.demo.service.IOrderService;

@Component
public class OrderServiceHystrixComment  implements IOrderService{

	@Override
	public List<OrderPojo> createOrder(String size, String userId) {
		return null;
	}

	@Override
	public void updateOrder(OrderPojo order) {
		
	}
}
