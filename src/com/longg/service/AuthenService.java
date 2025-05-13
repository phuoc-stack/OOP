package com.longg.service;

import java.util.ArrayList;

import com.longg.db.Database;
import com.longg.dto.Customer;
import com.longg.dto.Shop;

// service class -> contain functions 
public class AuthenService {

	// login
	public Customer login(Shop shop, String id, String password) {
		for (Customer c : shop.customers) {
			if (c.id.equals(id) && c.password.equals(password)) {
				return c;
			}
		}
		return null;
	}

	// logout
}
