package com.longg.service;

import com.longg.dto.rank.*;
import com.longg.common.CheckoutContext;
import com.longg.dto.Cart;
import com.longg.dto.CartItem;
import com.longg.dto.Customer;
import com.longg.dto.Product;
import com.longg.dto.Shop;
import java.util.Scanner;

public class ShoppingCartService {

	public void addToCart(Cart cart, Product product, int quantity) {
		CartItem item = findProduct(cart, product);

		if (item != null) {
			item.quantity += quantity;
		} else {
			cart.items.add(new CartItem(product, quantity));
		}
	}

	private CartItem findProduct(Cart cart, Product product) {
		for (CartItem item : cart.items) {
			if (item.name.equals(product.name)) {
				return item;
			}
		}
		return null;
	}

	public void showCart(Cart cart) {
		if (cart.items.size() == 0) {
			System.out.println("\nYour cart is empty");
			return;
		}
		for (CartItem i : cart.items) {
			System.out.println(i.name + " = " + i.price + ". quantity = " + i.quantity);
		}
	}
	
	
	public float calculateInitialCost(Cart cart) {
		float cost = 0;
		for (CartItem i : cart.items) {
			cost += (i.price * i.quantity);
		}
		
		return cost;
	}
	
	public float calculateShippingFee(Shop s, Customer c) {
		return 5;
	}
	
	public float calculateFinalCost(CheckoutContext context, boolean hasVoucher) {
		float cost = calculateInitialCost(context.cart);
		float shippingFee = calculateShippingFee(context.shop, context.customer);
			    
		// apply rank promo if possible
		if (context.customer.rank == null) {
			return cost + shippingFee;
		}
		
		return context.customer.rank.applyRankPromo(cost, shippingFee, hasVoucher);
	}
	
	public float showCost(CheckoutContext context) {
		boolean hasVoucher = false;
		
		System.out.println("Subtotal " + calculateInitialCost(context.cart));
		System.out.println("Shipping fee " + calculateShippingFee(context.shop, context.customer));
		
		if (context.customer.rank != null) {
			System.out.println("Rank promo to apply: " + context.customer.rank.getDescription());
		}
		System.out.println("Do you have voucher AAA? (Y/N) ");
	    String payOption = context.scan.nextLine();
	    if (payOption.equalsIgnoreCase("Y")) {
	    	hasVoucher = true; 
	    	System.out.println("Voucher discount: -1.0");
	    }
		
	    float total = calculateFinalCost(context, hasVoucher);
	    return total;
	}
}
