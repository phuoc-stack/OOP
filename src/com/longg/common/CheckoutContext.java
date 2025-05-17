package com.longg.common;

import com.longg.dto.Cart;
import com.longg.dto.Customer;
import com.longg.dto.Shop;
import java.util.Scanner;

public class CheckoutContext {
	public Cart cart;
    public Shop shop;
    public Customer customer;
    public Scanner scan;
    
    public CheckoutContext(Cart cart, Shop shop, Customer customer, Scanner scan) {
    	this.cart = cart;
        this.shop = shop;
        this.customer = customer;
        this.scan = scan;
    }
}
