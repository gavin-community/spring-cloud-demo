package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.pojo.OrderPojo;
import com.demo.service.IUcService;

@RestController
@RequestMapping("/uc/v1")
public class UcController {
	@Autowired
	@Qualifier("ucService")
	private IUcService ucService;

	@RequestMapping(value = "/order/create")
	public List<OrderPojo> hi(@RequestParam("size") String size, @RequestParam("userId") String userId) {
		return ucService.createOrder(size, userId);
	}
}
