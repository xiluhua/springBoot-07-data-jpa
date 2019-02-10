package com.multi.service;

import java.util.List;

import com.multi.dao.query.Customer2;
import com.multi.entity.Customer;

public interface CustomerService {

	public int update13(String email, int id);
	
	public Customer save(int id, Customer customer);
	
	public Customer save(Customer customer);
	
	public List<Customer> save15(List<Customer> customers);
	
	public Customer findById(int id);
	
	public Customer saveOrUpdate(int id, Customer customer);
}