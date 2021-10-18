package com.amazing.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amazing.demo.model.Customer;
import com.amazing.demo.service.CustomerService;

@Controller
public class CustomerController {
	
	//display list of Customers
	
	@Autowired
	private CustomerService customerservice ;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		System.out.println("viewHomePage gettting called");
		model.addAttribute("listCustomer", customerservice.getAllCustomer());
		System.out.println(customerservice.getAllCustomer().toString());
		return "index" ;
	}
	
	@GetMapping("/showNewCustomerForm")
	public String showNewCustomerForm(Model model) 
	{
		Customer customer = new Customer() ;
		model.addAttribute("customer" , customer) ;
		return "Customer" ;
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		
		//Save Customer to database
		
		customerservice.saveCustomer(customer) ;
		return "redirect:/" ;
		
	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable ( value = "id") long id, Model model) {
		
		// get employee from the service
		Customer customer = customerservice.getCustomerById(id);
		
		model.addAttribute("customer", customer);
		return "update_customer";
	}
	
	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable (value = "id") long id) {
		
		// call delete employee method 
		this.customerservice.deleteCustomerById(id);
		return "redirect:/";
	}
	

}
