package com.demo.controller;

import org.springframework.stereotype.Component;

@Component
public class HelloWorldServiceHystrix implements HelloWorldService {

	@Override
	public String getHi(String name) {
		return "Sorry! Hystrix error name:"+name;
	}

}
