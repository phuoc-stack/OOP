package com.longg;

import java.util.ArrayList;

public class Database {

	// constant
	static final ArrayList<Customer> CUSTOMER_DB = new ArrayList<Customer>();
	static final ArrayList<Product> PRODUCT_DB = new ArrayList<Product>();

	static {
		CUSTOMER_DB.add(new Customer("1", "1"));
		CUSTOMER_DB.add(new Customer("2", "2"));

		PRODUCT_DB.add(new Product("Coffee", 5));
		PRODUCT_DB.add(new Product("Milk", 3));
	}

}
