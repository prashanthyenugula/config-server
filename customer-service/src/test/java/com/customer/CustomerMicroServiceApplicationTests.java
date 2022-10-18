package com.customer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.DynamicTest.stream;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.customer.model.Customer;
import com.customer.service.ICustomerRepository;
import com.customer.service.ICustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest
class CustomerMicroServiceApplicationTests {
	
	@Autowired
	private ICustomerService customerService;
	
	@MockBean
	private ICustomerRepository customerRepository;
	
	@Test
	public void getCustomersTest() {
		when(customerRepository.findAll()).thenReturn(Stream
				.of(new Customer(12, "Sam", "Viru", "sam@gmail.com", "password@123", "Hyd"),
				new Customer(12, "Shravan", "yuvi", "shra@gmail.com", "password@123", "Chennai"))
		.collect(Collectors.toList()));
		assertEquals(2, customerService.getAllCustomers().size());	
	}
	
	@Test
	public void registerCustomerTest() {
		Customer customer = new Customer(18, "Virat", "Kohli", "virat@gmail.com", "password@123", "Delhi");
		when(customerRepository.save(customer)).thenReturn(customer);
		assertEquals(customer.getId(), customerService.saveCustomer(customer));
		
	}

	@Test
	void contextLoads() {
	}

}
