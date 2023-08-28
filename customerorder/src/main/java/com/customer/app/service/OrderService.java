package com.customer.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.app.globalexception.IdNotFoundException;
import com.customer.app.globalexception.OrderNotFoundException;
import com.customer.app.model.Customer;
import com.customer.app.model.Order;
import com.customer.app.repository.CustomerRepository;
import com.customer.app.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	OrderRepository orderRepository;

	@Autowired
	CustomerRepository customerRepository;

	public Order createOrder(Order order, int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isEmpty()) {
			optional.orElseThrow(() -> new IdNotFoundException());
		}
		order.setCustomer(optional.get());
		return orderRepository.save(order);
	}

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	public String updateOrder(List<Order> order, int id) {
		Optional<Customer> customer = customerRepository.findById(id);
		if (customer.isEmpty()) {
			customer.orElseThrow(() -> new IdNotFoundException());
		}
		order.forEach(ord -> ord.setCustomer(customer.get()));
		orderRepository.saveAll(order);
		return "Order details are updated successfully";
	}

	public Order getOrder(int orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		if (order.isEmpty()) {
			order.orElseThrow(() -> new OrderNotFoundException());
		}
		return order.get();
	}

	public String deleteOrder(int orderId) {
		Optional<Order> order = orderRepository.findById(orderId);
		if (order.isEmpty()) {
			order.orElseThrow(() -> new OrderNotFoundException());
		}
		orderRepository.deleteById(orderId);
		return "order deleted successfully";
	}

	public List<Order> ordersByCustomer(int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if (optional.isEmpty()) {
			optional.orElseThrow(() -> new IdNotFoundException());
		}
		return orderRepository.findAll().stream()
				.filter(order -> order.getCustomer().getCustomerId() == optional.get().getCustomerId()).toList();
	}
}
