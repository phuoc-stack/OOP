package com.longg.common;

import com.longg.dto.Cart;
import com.longg.dto.Customer;
import com.longg.dto.Shop;

public class Storage {
	
	// environment  variable
	public static Shop currentShop = null;
	
	public static Customer currentCustmer = null;
	
	public static Cart currentCart = null;
	
	public static final String CUSTOMER_FILE_PATH = "src/com/longg/db/";
	
	public static final String PRODUCT_FILE_PATH = "src/com/longg/db/";
}
