package com.wct.springdemo.dao;

import java.util.List;
import com.wct.springdemo.entity.*;

public interface CustomerDAO {
	
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

}
