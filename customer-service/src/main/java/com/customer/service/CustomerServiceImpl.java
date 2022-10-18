package com.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.customer.model.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService{
	
	@Autowired
	ICustomerRepository customerRepository;
	@Autowired
	private IRoleRepository roleRepository;
//	@Autowired
//	private PasswordEncoder passwordEncoder;
	
//	public CustomerServiceImpl (ICustomerRepository customerRepository,
//			IRoleRepository roleRepository) {
//		this.customerRepository = customerRepository;
//		this.roleRepository = roleRepository;
//		this.passwordEncoder = passwordEncoder;
//	}
	
	@Override
	public Integer saveCustomer(Customer customer) {
		Customer savedCustomer = customerRepository.save(customer);
		return savedCustomer.getId();
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	@Override
	public Customer findCustomerByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

}
