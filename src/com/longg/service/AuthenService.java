package com.longg.service;

import java.util.ArrayList;

import com.longg.db.Database;
import com.longg.dto.Customer;

// service class -> contain functions 
public class AuthenService {

	// login
	public boolean login(String id, String password) {
		for (Customer c : Database.CUSTOMER_DB) {
			if (c.id.equals(id) && c.password.equals(password)) {
				return true;
			}
		}
		return false;
	}

	// logout
}
