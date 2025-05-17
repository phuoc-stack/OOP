package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;

import com.longg.common.Storage;
import com.longg.dto.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService { 

	public ArrayList<Product> getProducts() {
		try {
			File myObj = new File(Storage.PRODUCT_FILE_PATH + Storage.currentShop.dbPath + "/products.txt");
			Scanner myReader = new Scanner(myObj);
			ArrayList<Product> products = new ArrayList<>();
			myReader.nextLine();
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				Product p = readProductRow(data);
				products.add(p);
			}
			myReader.close();

			return products;

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return new ArrayList<Product>();
	}

	static Product readProductRow(String line) {
		Scanner rowScanner = new Scanner(line);
		rowScanner.useDelimiter(",");
		String name = rowScanner.next();
		int price = Integer.parseInt(rowScanner.next());
		rowScanner.close();
		return new Product(name, price);

	}

}
