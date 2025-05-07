package com.longg;

public class CartItem extends Product {

	int quantity;

	public CartItem() {
	}

	CartItem(String name, int price) {
		super(name, price);
	}

	CartItem(Product product) {
		this.name = product.name;
		this.price = product.price;
		this.quantity = 1;
	}
}
