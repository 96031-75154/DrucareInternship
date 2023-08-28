package com.customer.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.customer.app.globalexception.IdNotFoundException;
import com.customer.app.model.Customer;
import com.customer.app.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	CustomerRepository customerRepository;
	
	public Customer addCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public Customer getCustomer(int id) {
		
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isEmpty()) {
			optional.orElseThrow(() -> new IdNotFoundException());
		}
		return optional.get();
	}

	public List<Customer> getCustomersList() {
		return customerRepository.findAll();
	}

	public String updateCustomer(Customer customer) {
		Optional<Customer> optional = customerRepository.findById(customer.getCustomerId());
		if(optional.isEmpty()) {
			optional.orElseThrow(() -> new IdNotFoundException());
		}
		customerRepository.save(customer);
		return "Customer details are updated successfully";
	}

	public String deleteCustomer(int id) {
		Optional<Customer> optional = customerRepository.findById(id);
		if(optional.isEmpty()) {
			optional.orElseThrow(() -> new IdNotFoundException());
		}
		customerRepository.deleteById(id);
		return "customer details are deleted successfully";
	}
}
