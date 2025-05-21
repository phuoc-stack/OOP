package com.longg.service.shop2;

import com.longg.dto.Customer;
import com.longg.service.AuthenService;

public class Shop2AuthenService implements AuthenService {

	@Override 
	public void handleSuccessfulLogin(Customer customer) {
		System.out.println("Shop 2 logged in sucessful");
	}
}
