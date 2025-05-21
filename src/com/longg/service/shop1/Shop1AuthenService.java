package com.longg.service.shop1;

import com.longg.dto.Customer;
import com.longg.service.AuthenService;

public class Shop1AuthenService implements AuthenService {

	@Override 
	public void handleSuccessfulLogin(Customer customer) {
		System.out.println("Shop 1 logged in sucessful and email is sent");
	}
}
