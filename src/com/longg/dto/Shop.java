package com.longg.dto;

import java.util.ArrayList;
import java.util.Scanner;

import com.longg.common.CheckoutContext;
import com.longg.dto.Customer;
import com.longg.service.ShoppingCartService;

public class Shop {
	public int id;
	public String name;
	public String dbPath;

	public Shop() {

	}

	public Shop(int id, String name, String dbPath) {
		super();
		this.id = id;
		this.name = name;
		this.dbPath = dbPath;

	}

//	public void handleSuccessfulLogin(Customer customer) {
//
//	}
//
//	public void checkOut(ShoppingCartService cartService, CheckoutContext context) {
//		// TODO Auto-generated method stub
//		
//	}
}
