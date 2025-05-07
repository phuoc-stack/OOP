package com.longg;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Cart cart;
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {

		boolean isLoggedin;
		do {
			isLoggedin = doLogin();
		} while (isLoggedin == false);
		showProducts();
		// addProductToCart

		// let user input the number (product)
		System.out.print("Enter Product Number: ");
		int productNumber = scan.nextInt();

		Product selectedProduct = Database.PRODUCT_DB.get(productNumber - 1);
		CartItem item = new CartItem(selectedProduct);
		cart.items.add(item);

		System.out.println(cart.items.toString());

		for (CartItem i : cart.items) {
			System.out.println(i.name + " = " + i.price);
		}
	}

	private static void showProducts() {
		for (int i = 0; i < Database.CUSTOMER_DB.size(); i++) {
			System.out.println(
					(i + 1) + ". " + Database.PRODUCT_DB.get(i).name + " : " + Database.PRODUCT_DB.get(i).price);
		}
	}

	private static boolean doLogin() {
		// user input username + password
		System.out.print("Enter ID: ");
		String userID = scan.nextLine();

		// Enter Password
		System.out.print("Enter Password: ");
		String userPassword = scan.nextLine();

		for (Customer c : Database.CUSTOMER_DB) {
			if (c.id.equals(userID) && c.password.equals(userPassword)) {
				cart = new Cart();
				cart.items = new ArrayList<CartItem>();
				return true;
			}
		}
		return false;
	}

}
