package com.wct.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wct.springdemo.dao.CustomerDAO;
import com.wct.springdemo.entity.Customer;
import com.wct.springdemo.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	//need to inject the DAO into the controller
	
	@Autowired
	private CustomerService thecustomerService;
	
		
	@GetMapping("/list")
	public String listCustomers(Model theModel){
		
		//get the customer form service
		List<Customer> theCustomer=thecustomerService.getCustomers();
		
		//Add those customer to the model
		theModel.addAttribute("customerlist",theCustomer);
		
		//Return the page
		return "list-customers";
	}

}
