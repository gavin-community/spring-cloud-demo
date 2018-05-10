package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient // 向服务中心注册
@EnableHystrix//启用Hystrix容断器
@EnableHystrixDashboard//开启hystrixDashboard，打开监控页面http://127.0.0.1:8764/hystrix
public class RibbonServiceApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(RibbonServiceApplication.class, args);
	}

	@Bean
	@LoadBalanced // 开启负载均衡
	protected RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
