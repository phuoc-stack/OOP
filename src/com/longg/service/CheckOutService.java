package com.longg.service;

import com.longg.common.CheckoutContext;
import com.longg.dto.Shop;
import com.longg.service.shop1.Shop1CheckOutService;
import com.longg.service.shop2.Shop2CheckOutService;
import com.longg.service.shop3.Shop3CheckOutService;

public interface CheckOutService {
	
	static CheckOutService assignCheckOutService(Shop shop) {
		if (shop.id ==1) {
			return new Shop1CheckOutService();
		} else if (shop.id ==2) {
			return new Shop2CheckOutService();
		} else if (shop.id ==3) {
			return new Shop3CheckOutService();
		}
		return null;
	}
	void handleCheckOut(ShoppingCartService cartService, CheckoutContext context);
}
