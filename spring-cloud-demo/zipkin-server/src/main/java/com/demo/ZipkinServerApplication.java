package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.EnableZipkinServer;

/**
 *服务追踪组件zipkin（ 服务链路追踪服务）
 * @description 
 * @project: zipkin-server
 * @Date:2018年5月10日
 * @version  1.0
 * @Company: yitd
 * @author hui.long
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinServerApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ZipkinServerApplication.class, args);
	}
}
