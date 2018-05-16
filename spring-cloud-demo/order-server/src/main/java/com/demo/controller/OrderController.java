package com.demo.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.OrderItemPojo;
import com.demo.pojo.OrderPojo;
import com.demo.service.IOrderService;

@RestController
public class OrderController {
	
	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	@RequestMapping("/order/create/{userId}")
	public List<OrderPojo> createOrder(@RequestParam String size,@PathVariable String userId){
		int count = StringUtils.isEmpty(size)?20:Integer.valueOf(size);
		
		OrderPojo order = null;
		for (int i = 0; i < count; i++) {
			order = new OrderPojo();
			order.setCreateTime(new Date());
			order.setItems(Arrays.asList(new OrderItemPojo[] {}));
			order.setOrderName("玩具"+i);
			order.setOrderNo(UUID.randomUUID().toString());
			order.setOrderStatus("E");
			order.setUserId(Long.valueOf(userId));
			orderService.createOrder(order);
			
		}
		
		return orderService.getOrdersByUser(Long.valueOf(userId));
	}
	
	@RequestMapping("/order/update")
	public void updateOrder(@ModelAttribute OrderPojo orderPojo) {
		orderService.updateOrder(orderPojo);
	}
}
