package com.orders.model;

public class Item {
	
	private Integer quantity;
	private String itemName;
	
	public Item(Integer quantity, String itemName) {
		super();
		this.quantity = quantity;
		this.itemName = itemName;
	}
	
	public Item() {
		super();
	}

	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
}
