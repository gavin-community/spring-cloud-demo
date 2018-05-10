package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.service.IHelloWorldService;

@Service(value = "helloWorldService")
public class HelloWorldServiceImpl implements IHelloWorldService {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String getHelloWorld(String name) {
		return restTemplate.getForObject("http://HELLO-WORLD-SERVICE/helloWorld?name="+name,String.class);
	}

}
