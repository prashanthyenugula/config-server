package com.orders.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Orders {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer orderId; 
	private String nameOfOrder;
	private Integer quantity;
	private double price;
	private String itemDetails;
	
	public Orders(Integer orderId, String nameOfOrder, Integer quantity, double price, String itemDetails) {
		super();
		this.orderId = orderId;
		this.nameOfOrder = nameOfOrder;
		this.quantity = quantity;
		this.price = price;
		this.itemDetails = itemDetails;
	}

	public Orders() {
		super();
	}
	
	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getNameOfOrder() {
		return nameOfOrder;
	}
	public void setNameOfOrder(String nameOfOrder) {
		this.nameOfOrder = nameOfOrder;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getItemDetails() {
		return itemDetails;
	}
	public void setItemDetails(String itemDetails) {
		this.itemDetails = itemDetails;
	}
	
}
