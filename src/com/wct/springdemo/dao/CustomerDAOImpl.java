package com.wct.springdemo.dao;

import java.util.List;


import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wct.springdemo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	//need to inject the Hibernate session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		// Get the current Hibernate session
		
		Session currentSession= sessionFactory.getCurrentSession();
		
		//Create the query
		
		Query<Customer> query=currentSession.createQuery("from Customer", Customer.class);
		
		//Execute query and get result list
		
		List<Customer> listOfCustomers=query.getResultList();
		
		//Return the results
				
		return listOfCustomers;
	}
	
	

}
