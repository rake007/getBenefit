package com.getbenefit.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller2 {

	@Autowired
	private CustomerService service;
	
	@RequestMapping(method=RequestMethod.POST, value="/register")
	public void  addUser(@RequestBody Customers customer){
		service.addCustomer(customer);
		
	}
	
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public String  loginUser(@RequestBody Customers customer){
		boolean res= service.validate(customer);
		if(res) {
			System.out.println("success");
			return "home";
		}else {
			System.out.println("error in service");
			return "register";
		}
		
	}
}
