package com.springBoot.example;

import java.util.List;

import com.multi.dao.query.Customer2;
import com.multi.entity.Customer;

public interface Customer2Service {

	public Customer saveOrUpdate(int id, Customer customer);

	public List<Customer2> query12();
}
