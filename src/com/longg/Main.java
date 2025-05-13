package com.longg;

import java.util.ArrayList;
import java.util.Scanner;

import com.longg.db.Database;
import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Customer;
import com.longg.dto.Product;
import com.longg.dto.Shop;
import com.longg.service.AuthenService;
import com.longg.service.ShoppingCartService;

public class Main {

	static Cart cart;
	static Shop shop;
	static Customer customer;
	static Scanner scan = new Scanner(System.in);
	private static final int VIEW_CART_OPTION_ON_MENU = 0;

	private static ShoppingCartService cartService = new ShoppingCartService();
	private static AuthenService authenService = new AuthenService();

	public static void main(String[] args) {

		boolean isLoggedin;
		
		selectShop();

		do {
			isLoggedin = doLogin();
		} while (!isLoggedin);

		do {
			showMenu();

			System.out.print("Enter An Option: ");
			int option = scan.nextInt();
			scan.nextLine();

			if (option == VIEW_CART_OPTION_ON_MENU) {
				cartService.showCart(cart);
				cartService.showCost(cart, shop, customer);
			} else {
				doAddProductToCart(option);
			}

		} while (true);
	}
	
	
	private static void selectShop() {
		showShops();
		
		System.out.print("Enter An Option: ");
		int option = scan.nextInt();
		scan.nextLine();
		shop = SetUp.SHOPS.get(option-1);
		
		System.out.println("-------- Welcome to shop " + shop.name + "----------");
		
		
		
	}
	
	
	private static void showShops() {
		System.out.println("============ Shops ==========");
		for (int i = 0; i < SetUp.SHOPS.size(); i++) {
			System.out.println((i+1) + ". " + SetUp.SHOPS.get(i).name);
		}
		
		System.out.println("=============================");
	}
	
	

	private static void showMenu() {
		System.out.println("=========== Menu ============ ");
		System.out.println("0. View Cart");
		for (int i = 0; i < shop.products.size(); i++) {
			System.out.println(
					(i + 1) + ". " + shop.products.get(i).name + " : " + shop.products.get(i).price);
		}
	}

	private static boolean doLogin() {
		System.out.print("Enter ID: ");
		String userID = scan.nextLine();

		// Enter Password
		System.out.print("Enter Password: ");
		String userPassword = scan.nextLine();
		
		boolean isLoggedin = false;
		
		customer = authenService.login(shop, userID, userPassword);
		if (customer != null) {
			cart = new Cart();
			cart.items = new ArrayList<CartItem>();
			isLoggedin = true;
			
		}
		return isLoggedin;
	}

	private static void doAddProductToCart(int productIndex) {
		Product selectedProduct = shop.products.get(productIndex - 1);

		System.out.print("Enter quantity : ");
		int quantity = Integer.parseInt(scan.nextLine());

		cartService.addToCart(cart, selectedProduct, quantity);

		System.out.println("Added succesfully.");
	}

}
