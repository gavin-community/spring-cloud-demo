package com.demo.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.demo.pojo.OrderItemPojo;
import com.demo.pojo.OrderPojo;
import com.demo.service.IOrderService;

@Service(value = "orderService")
public class OrderServiceImpl implements IOrderService {
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	//private static ConcurrentLinkedDeque<OrderPojo> orderList = new ConcurrentLinkedDeque<OrderPojo>();

	//@Autowired
	//private IUcService ucService;

	@Override
	public List<OrderPojo> createOrder(String size,String userId) {
		int count = StringUtils.isEmpty(size)?20:Integer.valueOf(size);
		List<OrderPojo> orderPojoList = new ArrayList<OrderPojo>();
		OrderPojo order = null;
		for (int i = 0; i < count; i++) {
			order = new OrderPojo();
			order.setCreateTime(new Date());
			order.setItems(Arrays.asList(new OrderItemPojo[] {}));
			order.setOrderName("玩具"+i);
			order.setOrderNo(UUID.randomUUID().toString());
			order.setOrderStatus("E");
			order.setUserId(Long.valueOf(userId));
			orderPojoList.add(order);
		}
		return orderPojoList;
	}

	@Override
	public void updateOrder(OrderPojo order) {
		log.trace(String.format(">>update:%S", order.toString()));
	}

	@Override
	public List<OrderPojo> getOrdersByUser(Long userId) {
		int count = 10;
		List<OrderPojo> orderPojoList = new ArrayList<OrderPojo>();
		OrderPojo order = null;
		for (int i = 0; i < count; i++) {
			order = new OrderPojo();
			order.setCreateTime(new Date());
			order.setItems(Arrays.asList(new OrderItemPojo[] {}));
			order.setOrderName("玩具"+i);
			order.setOrderNo(UUID.randomUUID().toString());
			order.setOrderStatus("E");
			order.setUserId(Long.valueOf(userId));
			orderPojoList.add(order);
		}
		return orderPojoList;
	}

}
