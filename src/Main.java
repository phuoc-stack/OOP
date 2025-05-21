import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static Cart cart;
	static Scanner input = new Scanner(System.in);
	static Shop currentShop;
	static Customer currentCustomer;

	public static void main(String[] args) {
		boolean isLoggedin;
		do {
			isLoggedin = doLogin();
		} while (isLoggedin == false);

		boolean isExit = false;
		do {
			System.out.println("\n-----------------------------");
			System.out.println("Please enter value from 1-4 ");
			System.out.println("Main Menu");
			System.out.println("1. View Cart");
			System.out.println("2. View Rank");
			System.out.println("3. View Products");
			System.out.println("4. Exit");

			// Get input
			String option = input.nextLine();

			// Option 1
			if (option.equals("1")) {
				if (cart.items.isEmpty()) {
					System.out.println("Your cart is empty!");
					continue;
				}
				cart.viewCart(); 
				PaymentProcessor paymentProcessor = new PaymentProcessor();
				paymentProcessor.displayReceipt(currentCustomer, input);
			}

			// Option 2
			else if (option.equals("2")) {
				System.out.println(
						"Your rank is " + (currentCustomer.rank.isEmpty() ? "standard" : currentCustomer.rank));
			}

			// Option 3
			else if (option.equals("3")) {
				// Show all products
				Shop.showAllProducts(currentShop);
				
				System.out.println("Enter Product Number: ");

				int productNumber = input.nextInt();
				input.nextLine();
				
				Product selectedProduct = currentShop.allProducts.productList.get(productNumber - 1);

				cart.addToCart(selectedProduct);

				// Display product added to cart
				System.out.println("1 " + selectedProduct.name + " added");
			}

			// Option 4
			else if (option.equals("4")) {
				isExit = true;
			}

			else {
				System.out.println("Please only enter value from 1-4");
			}

		} while (!isExit);
		input.close();
	}

	private static boolean doLogin() {
		// user input user name + password
		System.out.print("Enter ID: ");
		String userID = input.nextLine();

		// Enter Password
		System.out.print("Enter Password: ");
		String userPassword = input.nextLine();

		for (Shop s : Database.SHOP_DB) {
			for (Customer c : s.allCustomers.customerList) {
				if (c.id.equals(userID) && c.password.equals(userPassword)) {
					currentShop = s;
					currentCustomer = c;
					cart = currentCustomer.customerCart;
					return true;
				}
			}
		}

		return false;
	}
}
