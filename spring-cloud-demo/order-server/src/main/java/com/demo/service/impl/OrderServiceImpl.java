package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pojo.OrderPojo;
import com.demo.pojo.UserPojo;
import com.demo.service.IOrderService;
import com.demo.service.IUcService;

@Service(value="orderService")
public class OrderServiceImpl implements IOrderService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	public static List<OrderPojo> orderList = new ArrayList<OrderPojo>();
	
	@Autowired
	private IUcService ucService;

	@Override
	public void createOrder(OrderPojo order) {
		
		UserPojo user = ucService.getUserById(order.getUserId().toString());
		
		log.info(String.format(">>User:", user.toString()));
		
		log.info(String.format(">>createOrder:%S", order.toString()));
		orderList.add(order);
	}

	@Override
	public void updateOrder(OrderPojo order) {
		log.info(String.format(">>update:%S", order.toString()));
	}

	@Override
	public List<OrderPojo> getOrdersByUser(Long userId) {
		return orderList;
	}

}
