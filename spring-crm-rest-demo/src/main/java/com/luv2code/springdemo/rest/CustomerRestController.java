package com.luv2code.springdemo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {

	//autowire the CustomersService
	@Autowired
	private CustomerService customerService;
	
	// add the mapping for GET/customers
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	// add the mapping for GET/customers/{customerId}
		@GetMapping("/customers/{customerId}")
		public Customer getCustomer(@PathVariable int customerId){
			
			
			Customer theCustomer=customerService.getCustomer(customerId);
			
			//check the studentId against list size
			if((theCustomer==null)){
				throw new CustomerNotFoundException("Customer id is not found- "+customerId);
			
			}
			return theCustomer;
			
			}
		
		//add the mapping POST / customers - add new customer
		@PostMapping("/customers")
		public Customer addCustomer(@RequestBody Customer theCustomer) {
			
			
		//also just in case the pass an id in JSON set the id =0
		// this is force the hibernate session to save new item instead of making update on it 	
			theCustomer.setId(0);//if the id null or 0 DAO will insert new customer 
			
			
			customerService.saveCustomer(theCustomer);
			
			
			return theCustomer;
			
		}
		
		
		
		//add the mapping PUT / customers - Update the customer
				@PutMapping("/customers")
				public Customer updateCustomer(@RequestBody Customer theCustomer) {
		
				customerService.saveCustomer(theCustomer);
		
				return theCustomer;
		
		
		
				}
		
				// add the mapping fro GET/customers/{customerId}
				@DeleteMapping("/customers/{customerId}")
				public String deleteCustomer(@PathVariable int customerId){
					
					Customer tempCustomer =customerService.getCustomer(customerId);
					
					if((tempCustomer==null)){
						throw new CustomerNotFoundException("Customer id is not found- "+customerId);
					
					}
					customerService.deleteCustomer(customerId);
					
					//check the studentId against list size
					
					return "Deleted the customer id-"+customerId;
					
					}
				
		
		
		
		}
	
	

