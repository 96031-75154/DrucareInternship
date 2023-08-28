package com.customer.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.customer.app.model.Customer;
import com.customer.app.model.Order;
import com.customer.app.model.OrderWithCustomer;
import com.customer.app.service.CustomerService;
import com.customer.app.service.OrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	CustomerService customerService;

	@PostMapping("/order/{id}/add")
	public Order createOrder(@RequestBody Order order, @PathVariable int id) {
		return orderService.createOrder(order, id);
	}

	@GetMapping("/order/getAllOrders")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@GetMapping("/customer/{id}/order")
	public String ordersByCustomer(@PathVariable int id) throws JsonProcessingException {
		List<Order> orderList = orderService.ordersByCustomer(id);
		List<Customer> customerList = orderList.stream().map(order -> order.getCustomer()).toList();
		ObjectMapper objectMapper = new ObjectMapper();
		OrderWithCustomer orderWithCustomer = new OrderWithCustomer(orderList, customerList);
		return objectMapper.writeValueAsString(orderWithCustomer);
	}

	@GetMapping("/customer/order/{orderId}")
	public Order getParticularOrderByCustomer(@PathVariable int orderId) {
		return orderService.getOrder(orderId);
	}

	@PutMapping("/customer/{id}/update")
	public String updateOrderOfCustomer(@RequestBody List<Order> order, @PathVariable int id) {
		return orderService.updateOrder(order, id);
	}

	@DeleteMapping("/order/delete/{orderId}")
	public String deleteOrder(@PathVariable int orderId) {
		return orderService.deleteOrder(orderId);
	}
}
