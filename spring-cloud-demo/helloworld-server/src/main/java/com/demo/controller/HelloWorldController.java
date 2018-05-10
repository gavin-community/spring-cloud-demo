package com.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@Value("${server.port}")
	private String port;
	
	@RequestMapping("/helloWorld")
	public String helloWold(@RequestParam String name) {
		return "Hello "+name+"! This spring cloud hello world service! from port:"+port;
	}
}
