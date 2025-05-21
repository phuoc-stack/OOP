package com.longg.service.shop3;

import com.longg.dto.Customer;
import com.longg.service.AuthenService;

public class Shop3AuthenService implements AuthenService {

	@Override 
	public void handleSuccessfulLogin(Customer customer) {
		System.out.println("Shop 3 logged in sucessful and log is recorded");
	}
}
