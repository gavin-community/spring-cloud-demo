package com.demo.service.impl;

import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.pojo.OrderPojo;
import com.demo.service.IUcService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service(value = "ucService")
public class UcServiceImpl implements IUcService {
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "hysError")
	@Override
	@SuppressWarnings("unchecked")
	public List<OrderPojo> createOrder(String size, String userId) {
		return exchange(size, userId, List.class);
	}

	public List<OrderPojo> hysError(String size, String userId) {
		System.out.println("hysError");
		return Collections.emptyList();
	}

	private <T> T exchange(String size, String userId, Class<T> clazz) {
		String url = String.format("http://SERVICE-ORDER-FEIGN/order/create/%s?size=%s", new Object[] { userId, size });
		long startTime = System.currentTimeMillis();
		ResponseEntity<T> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, clazz);
		System.out.println("耗时："+(System.currentTimeMillis()-startTime));
		T rst = responseEntity.getBody();
		return rst;
	}
}
