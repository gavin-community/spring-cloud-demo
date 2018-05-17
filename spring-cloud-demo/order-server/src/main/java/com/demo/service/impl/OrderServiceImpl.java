package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedDeque;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pojo.OrderPojo;
import com.demo.pojo.UserPojo;
import com.demo.service.IOrderService;
import com.demo.service.IUcService;

@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	private static ConcurrentLinkedDeque<OrderPojo> orderList = new ConcurrentLinkedDeque<OrderPojo>();

	@Autowired
	private IUcService ucService;

	@Override
	public void createOrder(OrderPojo order) {
		UserPojo user = ucService.getUserById(order.getUserId().toString());
		log.trace(String.format(">>User:", user.toString()));
		log.trace(String.format(">>createOrder:%S", order.toString()));
		orderList.add(order);
	}

	@Override
	public void updateOrder(OrderPojo order) {
		log.trace(String.format(">>update:%S", order.toString()));
	}

	@Override
	public List<OrderPojo> getOrdersByUser(Long userId) {
		List<OrderPojo> rst = new ArrayList<OrderPojo>();
		rst.addAll(orderList);
		orderList.clear();
		return rst;
	}

}
