package com.customer.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.customer.app.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
