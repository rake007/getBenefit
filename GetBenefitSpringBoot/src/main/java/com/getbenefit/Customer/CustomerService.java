package com.getbenefit.Customer;

import java.util.ArrayList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	public void addCustomer(Customers c){
		customerRepo.save(c);
		
	}

	public boolean validate(Customers c){
		if(customerRepo.findByEmailid(c.getEmailid())==null){
			return false;
			
		}else{
			String p=c.getEmailid();
			System.out.println(p);
			System.out.println(customerRepo.findPasswordByEmailid(p).toString());
			
			
			List<Customers> passwords=new ArrayList<>();
			 passwords= customerRepo.findPasswordByEmailid(p);
			 System.out.println("The list passwords: " + passwords);
			 for(Customers w : passwords) {
				 System.out.println(w.getPassword());
			 }
			 Customers x=passwords.get(0);
			System.out.println(x);
			if(c.getPassword().equals(x.getPassword())){
				return true;
			}else{
				return false;
			}
			
		}
		
		
	}
	
	public List<Customers> getAll(){
		List<Customers> list=new ArrayList<>();
		customerRepo.findAll().forEach(list::add);
		return list;
	}
	public void updateCustomer(Customers c,String username){
		customerRepo.save(c);
	}
}
