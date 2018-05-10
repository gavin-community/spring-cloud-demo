package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.service.IHelloWorldService;

@RestController
public class HelloWorldController {
	@Autowired
	@Qualifier("helloWorldService")
	private IHelloWorldService helloWorldService;

	@RequestMapping(value = "hi")
	public String hi(@RequestParam String name) {
		return helloWorldService.getHelloWorld(name);
	}
}
