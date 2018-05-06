package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cfg.DemoCfg;

@RestController
@RefreshScope //注解@RefreshScope指示Config客户端在服务器配置改变时，也刷新注入的属性值 
public class HelloController {
	
	@Autowired
	@Qualifier("demoCfg")
	private DemoCfg cfg;

	@Value("${demo.hello}")
	private String hello;

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("pring:"+cfg.getHello());
		return this.hello;
	}
}
