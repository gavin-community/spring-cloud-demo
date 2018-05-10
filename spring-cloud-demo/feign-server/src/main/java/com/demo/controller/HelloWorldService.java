package com.demo.controller;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value="HELLO-WORLD-SERVICE",fallback=HelloWorldServiceHystrix.class)
public interface HelloWorldService {
	
	@RequestMapping(value="helloWorld",method=RequestMethod.GET)
	String getHi(@RequestParam(value="name") String name);
}
