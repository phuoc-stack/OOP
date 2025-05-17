package com.longg.dto;

import com.longg.common.CheckoutContext;
import com.longg.dto.Shop;
import com.longg.service.EmailService;
import com.longg.service.LogService;
import com.longg.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.Scanner;

public class Shop3 extends Shop {

	public Shop3() {

	}

	public Shop3(int id, String name, String dbPath) {
		super();
		this.id = id;
		this.name = name;
		this.dbPath = dbPath;

	}

	@Override
	public void handleSuccessfulLogin(Customer customer) {
		LogService logService = new LogService();
		logService.logLogIn(customer);
	}
	
	@Override
	public void checkOut(ShoppingCartService cartService, CheckoutContext context) {
		float total = cartService.showCost(context);
		LogService logService = new LogService();
		logService.logCheckOut(cartService, context, total);
	}
}
