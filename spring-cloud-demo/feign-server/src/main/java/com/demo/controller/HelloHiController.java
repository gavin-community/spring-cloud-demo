package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloHiController {
	@Autowired
	private HelloWorldService helloWorldService;
	
	@RequestMapping(value="sayHi")
	public String sayHelloWorld(@RequestParam(value="name") String name) {
		return helloWorldService.getHi(name);
	}
}
