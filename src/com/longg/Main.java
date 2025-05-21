package com.longg;

import java.util.ArrayList;
import java.util.Scanner;

import com.longg.common.CheckoutContext;
import com.longg.common.Storage;
import com.longg.dto.Cart;
import com.longg.dto.Customer;
import com.longg.dto.Product;
import com.longg.dto.Shop;
import com.longg.service.AuthenService;
import com.longg.service.CheckOutService;
import com.longg.service.ProductService;
import com.longg.service.ShopService;
import com.longg.service.ShoppingCartService;

public class Main {

	static Cart cart;
	static Shop selectedShop;
	static Customer customer;
	static Scanner scan = new Scanner(System.in);
	private static final int VIEW_CART_OPTION_ON_MENU = 1;
	private static final int EXIT_OPTION_ON_MENU = 0;
	private static ShoppingCartService cartService = new ShoppingCartService();
	private static AuthenService authenService = null;
	private static CheckOutService checkoutService = null;

	public static void main(String[] args) {

		boolean isLoggedin;
		boolean isExiting = false;

		selectedShop = selectShop();
		Storage.currentShop = selectedShop;
		
		authenService = AuthenService.assignAuthenService(selectedShop);

		do {
			isLoggedin = doLogin();
		} while (!isLoggedin);

		do {
			showMenu();

			System.out.print("Enter An Option: ");
			int option = scan.nextInt();
			scan.nextLine();

			if (option == VIEW_CART_OPTION_ON_MENU) {
			CheckoutContext checkoutContext = new CheckoutContext(cart, selectedShop, customer, scan);

			checkoutService = CheckOutService.assignCheckOutService(selectedShop);
			checkoutService.handleCheckOut(cartService, checkoutContext);
			} else if (option == EXIT_OPTION_ON_MENU) {
				isExiting = true;
			} else {
				doAddProductToCart(option);
			}
		} while (isLoggedin & !isExiting);
	}

	private static Shop selectShop() {
		ShopService shopService = new ShopService();
		ArrayList<Shop> shops = shopService.getAllShops();

		System.out.println("============ Shops ==========");
		for (int i = 0; i < shops.size(); i++) {
			System.out.println((i + 1) + ". " + shops.get(i).name);
		}

		System.out.println("=============================");

		System.out.print("Enter An Option: ");
		int option = scan.nextInt();
		scan.nextLine();

		System.out.println("-------- Welcome to " + shops.get(option - 1).name + "----------");

		return shops.get(option - 1);
	}

	private static void showMenu() {
		ProductService productService = new ProductService();
		ArrayList<Product> products = productService.getProducts();
		System.out.println("\n=========== Menu ============ ");
		System.out.println("1. View Cart");
		for (int i = 0; i < products.size(); i++) {
			System.out.println((i + 2) + ". " + products.get(i).name + " : " + products.get(i).price);
		}
		System.out.println("Press 0 to exit");
	}

	private static boolean doLogin() {
		System.out.print("Enter ID: ");
		String userID = scan.nextLine();

		// Enter Password
		System.out.print("Enter Password: ");
		String userPassword = scan.nextLine();

		boolean isLoggedin = false;

		customer = AuthenService.login(userID, userPassword);
		if (customer != null) {
			cart = new Cart();
			Storage.currentCart = cart;
			isLoggedin = true;
			customer.initializeRank(selectedShop);
//			selectedShop.handleSuccessfulLogin(customer);
			authenService.handleSuccessfulLogin(customer);
		}
		return isLoggedin;
	}

	private static void doAddProductToCart(int productIndex) {
		ProductService productService = new ProductService();
		ArrayList<Product> products = productService.getProducts();

		Product selectedProduct = productService.getProducts().get(productIndex - 2);

		System.out.print("Enter quantity : ");
		int quantity = Integer.parseInt(scan.nextLine());

		cartService.addToCart(cart, selectedProduct, quantity);

		System.out.println("Added succesfully.");
	}

}
