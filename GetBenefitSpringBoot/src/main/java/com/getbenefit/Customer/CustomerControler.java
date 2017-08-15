package com.getbenefit.Customer;

import java.sql.ResultSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RestController 
public class CustomerControler {
	
	@Autowired
	private  CustomerService CS;

	@RequestMapping(method=RequestMethod.POST, value="/customers/add")
	public void addCustomer(@RequestBody Customers c){
		CS.addCustomer(c);
	}
	
	@ResponseBody
	@RequestMapping(method=RequestMethod.GET, value="/customers")
	public String getCustomers(Model model){
		ModelAndView mav=new ModelAndView();
		List<Customers> list=CS.getAll();
		mav.addObject("list", list);
		mav.setViewName("customers");
		return "customers";
		
	}


	@RequestMapping(method=RequestMethod.PUT, value="/customers/{username}")
	public void updateCustomer(@RequestBody Customers c, @PathVariable String username){
		CS.updateCustomer(c, username);
	}
}
