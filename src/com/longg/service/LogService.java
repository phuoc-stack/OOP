package com.longg.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.io.BufferedWriter;

import com.longg.common.CheckoutContext;
import com.longg.dto.Cart;
import com.longg.dto.Customer;
import com.longg.dto.Shop;
import com.longg.service.ShoppingCartService;


public class LogService {
	private final String LOGIN_DIRECTORY_PATH = "src/com/longg/db/logs";
	private final String CHECKOUT_DIRECTORY_PATH = "src/com/longg/db/logs";
	
	public static void main(String[] args) {

	}

	public void logLogIn(Customer customer) {
		File directory = new File(LOGIN_DIRECTORY_PATH);
		if (!directory.exists()) {
			directory.mkdirs();
			System.out.println("Created a folder at: " + directory.getAbsolutePath());
		}
		appendToFile(customer);
	}

	public void appendToFile(Customer customer) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(LOGIN_DIRECTORY_PATH + "/login_logging.txt", true));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
			String timestamp = LocalDateTime.now().format(formatter);
			String logEntry = timestamp + " User " + customer.id + " logged in successfully \n";
			writer.write(logEntry);
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred while appending to the file.");
			e.printStackTrace();
		}
	}
	
	public void logCheckOut(ShoppingCartService cartService, CheckoutContext context, float total) {
		File directory = new File(CHECKOUT_DIRECTORY_PATH);
		if (!directory.exists()) {
			directory.mkdirs();
			System.out.println("Created a folder at: " + directory.getAbsolutePath());
		}
		appendToCheckOutFile(cartService, context, total);
	}
	
	public void appendToCheckOutFile(ShoppingCartService cartService, CheckoutContext context, float total) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(CHECKOUT_DIRECTORY_PATH + "/checkout_logging.txt", true));
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
			String timestamp = LocalDateTime.now().format(formatter);
			String logEntry = " User " + context.customer.id + ". Total: " + String.format("%.2f", total) + ". Checkout time: " + timestamp + "\n";
			writer.write(logEntry);
			writer.close();
		} catch (IOException e) {
			System.out.println("An error occurred while appending to the file.");
			e.printStackTrace();
		}
	}
}

