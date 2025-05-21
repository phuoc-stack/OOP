package com.longg.service.shop1;

import com.longg.common.CheckoutContext;
import com.longg.service.CheckOutService;
import com.longg.service.EmailService;
import com.longg.service.ShoppingCartService;

public class Shop1CheckOutService implements CheckOutService {

	@Override
	public void handleCheckOut(ShoppingCartService cartService, CheckoutContext context) {
		EmailService emailService = new EmailService();
		float total = cartService.showCost(context);
		emailService.sendEmail("Total Payment", Float.toString(total));
		System.out.println("Payment info sent to email");
	}

}
