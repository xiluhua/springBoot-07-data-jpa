package com.springBoot.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSON;
import com.multi.dao.query.Customer2;
import com.multi.service.impl.CustomerImpl;
import com.springBoot.dao.CustomerDao;
import com.springBoot.example.impl.Customer2Impl;

@Controller
public class B9Action {

	@Resource
	CustomerImpl customerImpl;
	@Resource
	Customer2Impl customer2Impl;
	@Resource
	CustomerDao customerDao;
	// postman
	// localhost:8007/b9.action
	@RequestMapping("/b9.action")
	public String test(Map<String, Object> map ) {
		System.out.println("b9 ...");
		
		List<Customer2> list = customer2Impl.query12();
		for (Customer2 customer2 : list) {
			System.out.println(JSON.toJSONString(customer2));
		}
		
		System.out.println();
		System.out.println("----------------------------");
		System.out.println();
		
		list = customerDao.query12();
		for (Customer2 customer2 : list) {
			System.out.println(JSON.toJSONString(customer2));
		}
		
		return "success";
	}
	
}
