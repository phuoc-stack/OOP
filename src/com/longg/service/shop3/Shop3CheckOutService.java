package com.longg.service.shop3;

import com.longg.common.CheckoutContext;
import com.longg.service.CheckOutService;
import com.longg.service.LogService;
import com.longg.service.ShoppingCartService;

public class Shop3CheckOutService implements CheckOutService {

	@Override
	public void handleCheckOut(ShoppingCartService cartService, CheckoutContext context) {
		float total = cartService.showCost(context);
		LogService logService = new LogService();
		logService.logCheckOut(cartService, context, total);
		System.out.println("Payment info recorded in log");
	}
}
