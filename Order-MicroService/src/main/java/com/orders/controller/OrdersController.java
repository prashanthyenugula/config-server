package com.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orders.model.Orders;
import com.orders.service.IOrdersService;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "http://localhost:4200")
public class OrdersController {
	
	@Autowired
	IOrdersService orderService;
	
//	@Value("${microservice.order-service.endpoints.endpoint.uri}")
//	private String endPoint_Url;
	
	@PostMapping("/placeAnOrder")
	Integer createBook(@RequestBody Orders orders) {
		Integer id = orderService.saveOrders(orders);
		System.out.println(id);
		return id;
	}
	
	@GetMapping("/getOrders")
	public List<Orders> getOrders(){
		return orderService.getAllOrders();
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<Orders> deleteOrder(@PathVariable Integer id){
		System.out.println(id);
		ResponseEntity<Orders> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		try {
			orderService.deleteOrder(id);
			System.out.println("Order is Deleted");
		}
		catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}
	
	@DeleteMapping("/deleteAllOrders")
	public String deleteAll() {
		orderService.deleteAllOrders();
		return "Orders are Deleted";
	}

}
