package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;

import com.longg.common.Storage;
import com.longg.dto.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CustomerService {

	public ArrayList<Customer> getCustomerByShop() {
		try {
			File myObj = new File(Storage.CUSTOMER_FILE_PATH + Storage.currentShop.dbPath + "/customer.txt");
			Scanner myReader = new Scanner(myObj);
			ArrayList<Customer> customers = new ArrayList<>();
			myReader.nextLine();
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				Customer c = readCustomerRow(data);
				customers.add(c);
			}
			myReader.close();

			return customers;

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		return new ArrayList<Customer>();
	}

	private Customer readCustomerRow(String line) {
		Scanner rowScanner = new Scanner(line);
		rowScanner.useDelimiter(",");
		String username = rowScanner.next();
		String password = rowScanner.next();
		String rank = rowScanner.next();
		rowScanner.close();
		return new Customer(username, password, rank);

	}

}
