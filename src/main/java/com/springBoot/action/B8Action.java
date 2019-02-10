package com.springBoot.action;

import java.util.Date;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.entity.Customer;
import com.multi.entity.Order;
import com.multi.service.impl.CustomerImpl;
import com.multi.service.impl.OrderImpl;

@Controller
public class B8Action {

	@Resource
	CustomerImpl customerImpl;
	@Resource
	OrderImpl orderImpl;
	
	// postman
	// localhost:8007/b8.action
	@RequestMapping("/b8.action")
	public String test(Map<String, Object> map, Customer customer) {
		System.out.println("b8 ...");
		customer.setCreatedTime(new Date());
		customerImpl.saveOrUpdate(customer.getId(), customer);
		
		Order order = new Order(customer.getId(), "订单", customer.getId());
		orderImpl.saveOrUpdate(order.getCustomerId(), order);
		return "success";
	}
	
}
