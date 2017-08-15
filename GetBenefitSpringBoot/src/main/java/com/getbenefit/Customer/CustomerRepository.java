package com.getbenefit.Customer;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends  CrudRepository<Customers, String>{
     public List<Customers> findByEmailid(String emailid);
     public List<Customers> findPasswordByEmailid(String emailid);
     
  
}
