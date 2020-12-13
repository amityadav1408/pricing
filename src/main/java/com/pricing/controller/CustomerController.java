package com.pricing.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pricing.model.Customer;
import com.pricing.repository.CustomerRepository;

@RestController
public class CustomerController {

	@Autowired
	private CustomerRepository customerRepository;

	@RequestMapping (value = "/customer", method = RequestMethod.GET) 
	public List<Customer> getAllNotes() 
	{ 
		return customerRepository.findAll(); 
	} 


}
