package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import com.longg.dto.Shop;

public class ShopService {

	private final String SHOP_FILE_PATH = "src/com/longg/db/shop/shop.txt";

	public ArrayList<Shop> getAllShops() {
		try {
			File file = new File(SHOP_FILE_PATH);
			Scanner myReader = new Scanner(file);
			ArrayList<Shop> list = new ArrayList<>();
			myReader.nextLine();
			while (myReader.hasNextLine()) {
				String row = myReader.nextLine();
				Shop s = readRow(row);
				list.add(s);
			}
			myReader.close();

			return list;
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		return null;
	}

	private Shop readRow(String line) {
		Shop shop;
		Scanner rowScanner = new Scanner(line);
		rowScanner.useDelimiter(",");
		String id = rowScanner.next();
		String name = rowScanner.next();
		String dbPath = rowScanner.next();
		rowScanner.close();

		int shopId = Integer.parseInt(id);

//		if (shopId == 1) {
//			shop = new Shop1(shopId,name,dbPath);
//		}
//		else if (shopId == 2) {
//			shop = new Shop2(shopId,name,dbPath);
//		}
//		else {
//			shop = new Shop3(shopId,name,dbPath);
//		}
		shop = new Shop(shopId, name, dbPath);
		return shop;
	}
}
