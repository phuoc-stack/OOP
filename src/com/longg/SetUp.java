package com.longg;

import java.io.File;
import java.util.ArrayList;

import com.longg.dto.Shop;
import com.longg.dto.rank.ShopARankingSystem;
import com.longg.service.FileService;
public class SetUp {
	
	public static final ArrayList<Shop> SHOPS = new ArrayList<>();
	
	static {
		Shop shopA = initShop("src/com/longg/db/shopA/customer.txt", "src/com/longg/db/shopA/products.txt");
		shopA.name = "shopA: boba shop";
		Shop shopB = initShop("src/com/longg/db/shopB/customer.txt", "src/com/longg/db/shopB/products.txt");
		shopB.name = "shopB: cafe";
		
		
		shopA.customers.get(0).rank = ShopARankingSystem.SILVER;
		
		
		SHOPS.add(shopA);
		SHOPS.add(shopB);
	}
	
	
	public static Shop initShop(String customerFile, String productFile) {
		Shop shop = new Shop();
		shop.customers = FileService.readCustomerFile(customerFile);
		shop.products = FileService.readProductFile(productFile);
		return shop;
	}
	
	
	

}
