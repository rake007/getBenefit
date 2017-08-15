package com.getbenefit.Orders;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.getbenefit.Customer.Customers;

@RestController
public class OrdersControler {
	
	@Autowired
	private  OrdersService OS;

	@RequestMapping(method=RequestMethod.POST, value="/customers/{emailid}/add")
	public void addOrder(@RequestBody Orders o , @PathVariable String emailid){
		o.setCustomers(new Customers(emailid, ""));
		OS.addOrder(o);
	}


	@RequestMapping(method=RequestMethod.GET,value="/customers/{emailid}/orders")
	public List<Orders> getOrdersByCustomer(@PathVariable String emailid){
		List<Orders> list=new ArrayList<>();
		OS.getOrderByCustomer(emailid).forEach(list::add);
		return list;
	}
}
