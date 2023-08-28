package com.customer.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.app.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

	List<Order> findByOrderId(int id);
}
