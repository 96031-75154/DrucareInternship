package com.customer.app.model;

import java.util.List;

public class OrderWithCustomer {
	private List<Order> orders;
	private List<Customer> customers;
	
	public OrderWithCustomer() {
		
	}
	public OrderWithCustomer(List<Order> orders, List<Customer> customers) {
		this.orders = orders;
		this.customers = customers;
	}
	public List<Order> getOrders() {
		return orders;
	}
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
