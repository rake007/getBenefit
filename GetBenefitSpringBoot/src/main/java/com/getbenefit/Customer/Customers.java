package com.getbenefit.Customer;
// default package
// Generated Jun 29, 2017 3:30:28 PM by Hibernate Tools 5.2.1.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.getbenefit.Orders.Orders;

/**
 * Customers generated by hbm2java
 */
@Entity
@Table(name = "customers", schema = "public")
public class Customers implements java.io.Serializable {

	private String emailid;
	private String password;
	private Set<Orders> customerOrderses = new HashSet<Orders>(0);

	public Customers() {
	}

	public Customers(String emailid, String password) {
		this.emailid = emailid;
		this.password = password;
	}

	public Customers(String emailid, String password, Set<Orders> customerOrderses) {
		this.emailid = emailid;
		this.password = password;
		this.customerOrderses = customerOrderses;
	}

	@Id

	@Column(name = "emailid", unique = true, nullable = false)
	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany( mappedBy = "customers")
	@JsonIgnore
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	public Set<Orders> getCustomerOrderses() {
		return this.customerOrderses;
	}

	public void setCustomerOrderses(Set<Orders> customerOrderses) {
		this.customerOrderses = customerOrderses;
	}

}