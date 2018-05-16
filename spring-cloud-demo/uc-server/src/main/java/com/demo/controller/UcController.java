package com.demo.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.OrderPojo;
import com.demo.pojo.UserPojo;
import com.demo.service.IUcService;

@RestController
public class UcController {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private DiscoveryClient client;

	@Autowired
	@Qualifier("ucService")
	private IUcService ucService;

	@RequestMapping("/services")
	public List<ServiceInstance> getServices(@RequestParam String serviceId) {
		List<ServiceInstance> list = client.getInstances(serviceId);
		String url = "";
		for (ServiceInstance serviceInstance : list) {
			log.info(serviceInstance.getServiceId());
			url = serviceInstance.getUri().toString();
			log.info(url);
			log.info("\n");
		}
		return list;
	}

	@RequestMapping("/user/list")
	public List<UserPojo> getAllUser(@RequestParam String pageSize) {
		return ucService.getAllUser(StringUtils.isEmpty(pageSize) ? null : Integer.valueOf(pageSize));
	}

	@RequestMapping("/user/{userId}")
	public UserPojo getUserById(@PathVariable String userId) {
		log.info(String.format(">>userId:%s", userId));
		return ucService.getUserById(Long.valueOf(userId));
	}

	@RequestMapping("/order/{userId}")
	public List<OrderPojo> createOrder(@RequestParam String size, @PathVariable String userId) {
		return ucService.createOrder(size, userId);
	}

	@RequestMapping("order/update")
	public void updateOrder(@RequestParam String orderName, @RequestParam String orderNo) {
		OrderPojo order = new OrderPojo();
		order.setCreateTime(new Date());
		order.setOrderName(orderName);
		order.setOrderNo(orderNo);
		order.setOrderStatus("TTTT");
		order.setUserId(123456789L);
		ucService.updateOrder(order);
	}
}
