package com.wct.springdemo.dao;

import java.util.List;


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
	public List<Customer> getCustomers() {
		
		// Get the current Hibernate session
		
		Session currentSession= sessionFactory.getCurrentSession();
		
		//Create the query
		
		Query<Customer> query=currentSession.createQuery("from Customer order by lastName", Customer.class);
		
		//Execute query and get result list
		
		List<Customer> listOfCustomers=query.getResultList();
		
		//Return the results
				
		return listOfCustomers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		//Get the current session
		
		Session currentSession= sessionFactory.getCurrentSession();
		
		
		//Save/Update the customer 
		currentSession.saveOrUpdate(theCustomer);
		
			
		
	}

	@Override
	public Customer getCustomers(int theId) {
		
		
		Session currentSession= sessionFactory.getCurrentSession();
		
		//Create the query
		
		Customer theCustomer=currentSession.get(Customer.class, theId);
		
		
		
		//Return the results
				
		return theCustomer;
	}

	@Override
	public void  deleteCustomers(int theId) {
		
		Session currentSession= sessionFactory.getCurrentSession();
		
		//Create the query
		
		Query theQuery=  currentSession.createQuery("delete from Customer where id=:customerID");
		
		theQuery.setParameter("customerID", theId);
		
		theQuery.executeUpdate();
		
		
	}
	
	

}
