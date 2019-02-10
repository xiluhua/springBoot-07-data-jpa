package com.springBoot.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.multi.dao.query.Customer2;

@Repository
public class CustomerDao {
	
	// 获取和当前事务相关联的 EntityManager
	@PersistenceContext
	private EntityManager entityManager;
		
	/**
	 * @return Customer
	 */
	@SuppressWarnings("unchecked")
	public List<Customer2> query12() {
		StringBuilder jpql = new StringBuilder();
		jpql.append("SELECT c.id,c.last_name as lastName,a.city,c.createdTime as createTime ");
		jpql.append("FROM JPA_CUSTOMERS c,");
		jpql.append("	  JPA_ADDRESSES a ");
		jpql.append("WHERE c.age > ? and c.addr_id = a.id");
		Query query = entityManager.createNativeQuery(jpql.toString(),Customer2.class);
		query.setParameter(1, 1);
		List<Customer2> list = query.getResultList();
		return list;
	}

}