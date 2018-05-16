package com.demo.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.pojo.OrderPojo;
import com.demo.pojo.UserPojo;
import com.demo.service.IOrderService;
import com.demo.service.IUcService;

@Service(value = "ucService")
public class UcServiceImpl implements IUcService {
	
	@Autowired
	private IOrderService orderService;

	public List<OrderPojo> createOrder(String size, String userId) {
		return orderService.createOrder(size, userId);
	}

	public void updateOrder(OrderPojo order) {
		orderService.updateOrder(order);
	}

	@Override
	public List<UserPojo> getAllUser(Integer pageSize) {
		List<UserPojo> userList = new ArrayList<UserPojo>();
		int count = null == pageSize ? 20 : pageSize.intValue();

		UserPojo userPojo = null;
		for (int i = 0; i < count; i++) {
			userPojo = new UserPojo();
			userPojo.setAddress("天津市滨海新区中新生态城中生大道" + i + "号");
			userPojo.setAge(i + 10);
			userPojo.setCompany("忘不了有限公司");
			userPojo.setEmail("WangBu" + i + "@qq.com");
			userPojo.setLoginName("testlogin" + i);
			userPojo.setSex("F");
			userPojo.setTelephone("00000" + i);
			userPojo.setUserId(Long.valueOf(i));
			userPojo.setUserName("随便" + i);
			userList.add(userPojo);
		}
		return userList;
	}

	@Override
	public UserPojo getUserById(Long userId) {
		UserPojo userPojo = new UserPojo();
		userPojo.setAddress("天津市滨海新区中新生态城中生大道20号");
		userPojo.setAge(10);
		userPojo.setCompany("忘不了有限公司");
		userPojo.setEmail("WangBu10@qq.com");
		userPojo.setLoginName("testlogin0");
		userPojo.setSex("F");
		userPojo.setTelephone("0000010");
		userPojo.setUserId(userId);
		userPojo.setUserName("随便10");
		return userPojo;
	}

}
