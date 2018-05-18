package com.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.demo.pojo.OrderPojo;
import com.demo.service.IOrderService;

@RestController
public class OrderController {
	
	@Autowired
	@Qualifier("orderService")
	private IOrderService orderService;
	
	@RequestMapping("/order/create/{userId}")
	public List<OrderPojo> createOrder(@RequestParam String size,@PathVariable String userId){
		return orderService.createOrder(size, userId);
	}
	
	@RequestMapping("/order/update")
	public void updateOrder(@ModelAttribute OrderPojo orderPojo) {
		orderService.updateOrder(orderPojo);
	}
}
