package com.orders;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.orders.model.Orders;
import com.orders.service.IOrdersRepository;
import com.orders.service.IOrdersService;

@RunWith(SpringRunner.class)
@SpringBootTest
class OrderMicroServiceApplicationTests {
	
	@Autowired
	private IOrdersService orderService;
	
	@MockBean
	private IOrdersRepository ordersRepository;
	
	@Test
	public void getOrdersTest() {
		when(ordersRepository.findAll()).thenReturn(Stream
				.of(new Orders(12, "Watch", 11, 121.25, "boatXtend"),
					new Orders(12, "Watch", 11, 121.25, "boatXtend"))
		.collect(Collectors.toList()));
		assertEquals(2, orderService.getAllOrders().size());		
	}
	
	@Test
	public void registerCustomerTest() {
		Orders orders = new Orders(18, "TV", 11, 12112.25, "sony");
		when(ordersRepository.save(orders)).thenReturn(orders);
		assertEquals(orders.getOrderId(), orderService.saveOrders(orders));
		
	}
	
	
//	@Test
//	public void deleteOrderTest() {
//		Orders orders = new Orders(18, "TV", 11, 12112.25, "sony");
//		orderService.deleteAllOrders();
//		verify(ordersRepository,times(1)).delete(orders);
//	}

	@Test
	void contextLoads() {
	}

}
