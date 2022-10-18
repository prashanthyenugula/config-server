package com.customer.service;

import java.util.List;

import com.customer.model.Customer;

public interface ICustomerService {
	
	Integer saveCustomer(Customer customer);

	public List<Customer> getAllCustomers();
	
	Customer findCustomerByEmail(String email);

}
