package com.longg.service;

import java.util.ArrayList;
import com.longg.dto.Customer;
import com.longg.dto.Shop;
import com.longg.service.shop1.Shop1AuthenService;
import com.longg.service.shop2.Shop2AuthenService;
import com.longg.service.shop3.Shop3AuthenService;

// service class -> contain functions 
public interface AuthenService {
	CustomerService customerService = new CustomerService();

	// login
	static Customer login(String id, String password) {
		ArrayList<Customer> customers = customerService.getCustomerByShop();
		for (Customer c : customers) {
			if (c.id.equals(id) && c.password.equals(password)) {
				return c;
			}
		}
		return null;
	}


	static AuthenService assignAuthenService(Shop shop) {
		if (shop.id ==1) {
			return new Shop1AuthenService();
		} else if (shop.id ==2) {
			return new Shop2AuthenService();
		} else if (shop.id ==3) {
			return new Shop3AuthenService();
		}
		return null;
	}
	void handleSuccessfulLogin(Customer customer);


}