package com.springBoot.example.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.dao.query.Customer2;
import com.multi.dataSource.MultiDataSource;
import com.multi.entity.Customer;
import com.multi.log.LogBefore;
import com.multi.log.LogCoreAfterReturning;
import com.springBoot.dao.CustomerDao;
import com.springBoot.dao.CustomerRepDao;
import com.springBoot.example.Customer2Service;

@Transactional
@Service
public class Customer3Impl implements Customer2Service{

	@Autowired
	private CustomerRepDao customerRepDao;
	@Autowired
	private CustomerDao customerDao;
	
	@LogBefore
	@LogCoreAfterReturning
	@MultiDataSource
	@Override
	public Customer saveOrUpdate(int id, Customer customer) {
		Customer exist 			= null;
		Optional<Customer> opt 	= customerRepDao.findById(id);
		if (!opt.isPresent()) {
			exist = customer;
		} else {
			exist = opt.get();
			BeanUtils.copyProperties(customer, exist, "createdTime");
		}
		
		return customerRepDao.save(exist);
	}

	@Override
	public List<Customer2> query12() {
		// TODO Auto-generated method stub
		return customerDao.query12();
	}
	
}
