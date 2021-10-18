package com.amazing.demo.service;

import java.util.List;
import java.util.Optional ;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazing.demo.model.Customer;
import com.amazing.demo.repository.CustomerRepository;


@Service
public class CustomerServiceImpl  implements CustomerService{

	@Autowired
	private CustomerRepository customerrepository ;
	
	@Override
	public List<Customer> getAllCustomer() {		
		return customerrepository.findAll();
	}
	
	@Override
	public void saveCustomer(Customer customer) 
	{
		this.customerrepository.save(customer);
	}

	@Override
	public Customer getCustomerById(long id) {
		Optional<Customer> optional = customerrepository.findById(id) ;
		Customer customer = null ;
		
		if (optional.isPresent()) {
			customer = optional.get();
		} else {
			throw new RuntimeException(" Customer not found for id :: " + id);
		}
		return customer;
		
	}

	@Override
	public void deleteCustomerById(long id) {
		
		this.customerrepository.deleteById(id);
		
	}
	

}
