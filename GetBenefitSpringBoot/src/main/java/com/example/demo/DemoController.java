package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.getbenefit.Customer.CustomerService;
import com.getbenefit.Customer.Customers;

@Controller
@RequestMapping("/getbenefit")
public class DemoController {
	
	@Autowired
	private  CustomerService CS;

	@RequestMapping(value="/home" ,method=RequestMethod.GET)
	public String home(Model model){
		
		return "home"; 
	}
	@RequestMapping(value="/registerUser" ,method=RequestMethod.GET)
	public String register(Model model){
		
		return "registerUser"; 
	}
	

	@RequestMapping(value="/validate" ,method=RequestMethod.POST)
	public String verfiyUser(Model model, @ModelAttribute Customers customers){
		System.out.println(customers.getEmailid());
		System.out.println(customers.getPassword());
		if(CS.validate(customers)){
			return "account";
		}else{
			return "home";
		}
	 
	}
	
	@RequestMapping(value="/one" ,method=RequestMethod.GET)
	public String demo(Model model){
		model.addAttribute("list", CS.getAll());
		return "NewFile"; 
	}
	
	@RequestMapping(value="/customers/{emailid}/orders", method=RequestMethod.GET)
	public String getOrders(Model model){
		
		return " ";
	}
	
	
	@RequestMapping(method=RequestMethod.GET, value="/customers/list")
	public String getCustomers(Model model){
		model.addAttribute("list", CS.getAll());
		
		return "customers";
		
	}
}
