package com.longg.service.shop2;

import com.longg.common.CheckoutContext;
import com.longg.dto.Customer;
import com.longg.service.AuthenService;
import com.longg.service.CheckOutService;
import com.longg.service.ShoppingCartService;

public class Shop2CheckOutService implements CheckOutService {

	@Override
	public void handleCheckOut(ShoppingCartService cartService, CheckoutContext context) {
		float total = cartService.showCost(context);
		System.out.println("Total: " + String.format("%.2f", total));
	}
	
}
