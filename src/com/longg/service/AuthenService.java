package com.longg.service;

import java.util.ArrayList;
import com.longg.dto.Customer;
import com.longg.dto.Shop;
import com.longg.dto.Customer;


// service class -> contain functions 
public class AuthenService {
	CustomerService customerService = new CustomerService();
	// login
	public Customer login(String id, String password) {
		ArrayList<Customer> customers = customerService.getCustomerByShop();
		for (Customer c : customers) {
			if (c.id.equals(id) && c.password.equals(password)) {
				return c;
			}
		}
		return null;
	}
	// logout
}
