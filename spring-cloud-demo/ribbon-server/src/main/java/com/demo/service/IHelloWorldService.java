package com.demo.service;

public interface IHelloWorldService {
	public String getHelloWorld(String name);
	
	public String getHelloWorldForHystrix(String name);
}
