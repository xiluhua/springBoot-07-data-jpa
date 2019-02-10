package com.springBoot.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.entity.Customer;
import com.springBoot.example.impl.Customer3Impl;

@Controller
public class B6Action {

	@Resource
	Customer3Impl customer3Impl;
	// postman
	// localhost:8007/65.action
	@RequestMapping("/b6.action")
	public String test(Map<String, Object> map, Customer customer) {
		System.out.println("b6 ...");
		customer3Impl.saveOrUpdate(customer.getId(), customer);
		return "success";
	}
	
}
