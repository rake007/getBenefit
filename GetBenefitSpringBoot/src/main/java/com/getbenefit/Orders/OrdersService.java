package com.getbenefit.Orders;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {

	@Autowired
	private OrdersRepository orderRepo;
	
	public void addOrder(Orders o){
		orderRepo.save(o);
	}

	public void updateOrder(Orders o,String username){
		orderRepo.save(o);
	}
	
	public List<Orders> getOrderByCustomer(String username){
		/*List<Orders> list=new ArrayList<>();
		List<Orders> orders= orderRepo.findByCustomersEmailid(username);
		
		for(Orders O:orders){
			String item=O.getItem();
			Long price=O.getPrice();
			
		list.add(new Orders(price, item));
		}*/
		return orderRepo.findByCustomersEmailid(username);
		
	}
}
