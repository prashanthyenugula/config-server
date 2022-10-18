package com.customer.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.model.Customer;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {
	
	Customer findByEmail(String email);

}
