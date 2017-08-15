package com.getbenefit.Orders;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface OrdersRepository extends  CrudRepository<Orders, String>{

	public List<Orders> findByCustomersEmailid(String emailid);
}
