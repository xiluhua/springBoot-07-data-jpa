package com.multi.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.multi.dataSource.MultiDataSource;
import com.multi.entity.Order;
import com.multi.service.OrderService;
import com.springBoot.dao.OrderRepDao;

@MultiDataSource
@Transactional
@Service
public class OrderImpl implements OrderService{

	@Autowired
	OrderRepDao orderRepDao;
	
	@Override
	public Order saveOrUpdate(int id, Order entity) {
		Order exist 			= null;
		Optional<Order> opt 	= orderRepDao.findById(id);
		if (!opt.isPresent()) {
			exist = entity;
		} else {
			exist = opt.get();
			BeanUtils.copyProperties(entity, exist, "createdTime");
		}
		
		return orderRepDao.save(exist);
	}

}