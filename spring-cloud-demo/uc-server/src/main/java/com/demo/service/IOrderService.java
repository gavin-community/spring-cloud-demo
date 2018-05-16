package com.demo.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.pojo.OrderPojo;
import com.demo.service.impl.OrderServiceHystrixComment;

@FeignClient(value = "SERVICE-ORDER-FEIGN", fallback = OrderServiceHystrixComment.class)
public interface IOrderService {
	@RequestMapping("/order/create/{userId}")
	public List<OrderPojo> createOrder(@RequestParam(value="size") String size, @PathVariable(value="userId") String userId);

	@RequestMapping("/order/update")
	public void updateOrder(@ModelAttribute OrderPojo order);
}
