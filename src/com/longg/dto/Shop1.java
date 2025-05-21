//package com.longg.dto;
//
//import com.longg.common.CheckoutContext;
//import com.longg.dto.Shop;
//import com.longg.service.EmailService;
//import com.longg.service.ShoppingCartService;
//
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class Shop1 extends Shop {
//
//	public Shop1() {
//
//	}
//
//	public Shop1(int id, String name, String dbPath) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.dbPath = dbPath;
//
//	}
//
//	@Override
//	public void handleSuccessfulLogin(Customer customer) {
//		EmailService emailService = new EmailService();
//		emailService.sendEmail("Succesful Log in", "Bạn đã log in thành công");
//	}
//	
//	@Override
//	public void checkOut(ShoppingCartService cartService, CheckoutContext context) {
//		EmailService emailService = new EmailService();
//		float total = cartService.showCost(context);
//		emailService.sendEmail("Total Payment", Float.toString(total));
//	}
//}
