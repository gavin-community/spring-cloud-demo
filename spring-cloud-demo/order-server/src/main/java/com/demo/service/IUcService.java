package com.demo.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.pojo.UserPojo;
import com.demo.service.impl.UserServiceHystrixComment;

@FeignClient(value="SERVICE-UC-FEIGN",fallback=UserServiceHystrixComment.class)
public interface IUcService {
	@RequestMapping("/user/list")
	List<UserPojo> getUser(@RequestParam(value="pageSize") String pageSize);
	
	@RequestMapping("/user/{userId}")
	UserPojo getUserById(@PathVariable(value="userId") String userId);
}
