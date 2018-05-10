package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.demo.service.IHelloWorldService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service(value = "helloWorldService")
public class HelloWorldServiceImpl implements IHelloWorldService {
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public String getHelloWorld(String name) {
		return restTemplate.getForObject("http://HELLO-WORLD-SERVICE/helloWorld?name=" + name, String.class);
	}

	@HystrixCommand(fallbackMethod = "hysError")
	@Override
	public String getHelloWorldForHystrix(String name) {
		return restTemplate.getForObject("http://HELLO-WORLD-SERVICE/helloWorld?name=" + name, String.class);
	}

	public String hysError(String name) {
		return "Hi " + name + ", is hystrix error!";
	}

}
