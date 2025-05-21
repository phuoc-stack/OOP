//package com.longg.dto;
//
//import com.longg.common.CheckoutContext;
//import com.longg.dto.Shop;
//import com.longg.service.ShoppingCartService;
//import java.util.Scanner;
//
//public class Shop2 extends Shop {
//
//	public Shop2() {
//
//	}
//
//	public Shop2(int id, String name, String dbPath) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.dbPath = dbPath;
//
//	}
//
//	@Override
//	public void handleSuccessfulLogin(Customer customer) {
//		System.out.println("Bạn đã login thành công");
//	}
//	
//	@Override
//	public void checkOut(ShoppingCartService cartService, CheckoutContext context) {
//		float total = cartService.showCost(context);
//		System.out.println("Total: " + String.format("%.2f", total));
//	}
//}
