package com.demo.service;

import java.util.List;

import com.demo.pojo.OrderPojo;
import com.demo.pojo.UserPojo;

public interface IUcService {
	public List<UserPojo> getAllUser(Integer pageSize);

	public UserPojo getUserById(Long userId);

	public List<OrderPojo> createOrder(String size, String userId);

	public void updateOrder(OrderPojo order);
}
