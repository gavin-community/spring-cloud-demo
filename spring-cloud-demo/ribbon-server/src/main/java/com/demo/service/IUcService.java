package com.demo.service;

import java.util.List;

import com.demo.pojo.OrderPojo;

public interface IUcService {
	public List<OrderPojo> createOrder(String size, String userId);
}
