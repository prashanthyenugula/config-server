package com.customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.customer.model.Customer;
import com.customer.service.ICustomerService;

@RestController
@RequestMapping("/api/v1/customer")
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public CustomerController(ICustomerService customerService) {
		this.customerService = customerService;
	}
	
	@RequestMapping("/hello")
	public String hello() {
		return "Welcome";
	}
	
	@GetMapping("/login")
    public String login(){
        return "login";
    }
	
	@PostMapping("/register")
	Integer createCustomer(@RequestBody Customer customer) {
		Integer id = customerService.saveCustomer(customer);
		System.out.println(id);
		return id;
	}
	
	@GetMapping("/getAll")
	public List<Customer> getCustomers(){
		return customerService.getAllCustomers();
	}
	
}
