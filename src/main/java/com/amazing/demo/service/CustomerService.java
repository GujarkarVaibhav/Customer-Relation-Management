package com.amazing.demo.service;

import java.util.List;
import com.amazing.demo.model.Customer;

public interface CustomerService {
	
	List<Customer> getAllCustomer() ;
	
	void saveCustomer(Customer customer) ;
	
	Customer getCustomerById(long id) ;
	
	void deleteCustomerById(long id) ;

}
