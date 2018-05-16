package com.demo.service.impl;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.demo.pojo.UserPojo;
import com.demo.service.IUcService;

/**
 * 断路器Hystrix容断异常处理组件
 * 
 * @description
 * @project: order-server
 * @Date:2018年5月11日
 * @version 1.0
 * @Company: yitd
 * @author hui.long
 */
@Component
public class UserServiceHystrixComment implements IUcService {
	private Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public List<UserPojo> getUser(String pageSize) {
		log.info("Sorry! Get user Hystrix error.");

		return Collections.emptyList();
	}

	@Override
	public UserPojo getUserById(String userId) {
		log.info("Sorry! Get userById Hystrix error.");
		return null;
	}

}
