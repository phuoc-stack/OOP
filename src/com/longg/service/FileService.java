package com.longg.service;

import java.io.File;
import java.io.FileNotFoundException;

import com.longg.dto.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileService {
	
	public static ArrayList<Customer> readCustomerFile(String filename) {
		try {
		      File myObj = new File(filename);
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
	
	static Customer readCustomerRow(String line) {
		Scanner rowScanner = new Scanner(line);
		rowScanner.useDelimiter(",");
		String username = rowScanner.next();
		String password = rowScanner.next();
		rowScanner.close();
		return new Customer(username, password);
		
	}
	
	
	public static ArrayList<Product> readProductFile(String filename) {
		try {
		      File myObj = new File(filename);
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
