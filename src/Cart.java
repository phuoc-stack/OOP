import java.util.ArrayList;

public class Cart {
	ArrayList<CartItem> items;

	public void viewCart() {
		for (CartItem item : this.items) {
			System.out.println(item.name + " : " + item.price + " * " + item.quantity + " = " + (item.price * item.quantity) + " aud");
		}
	}

	public void addToCart(Product selectedProduct) {
		boolean isFound = false;
		CartItem item = new CartItem(selectedProduct);
		for (CartItem itemExisting : items) {
			if (selectedProduct.name.equalsIgnoreCase(itemExisting.name)) {
				isFound = true;
				itemExisting.quantity++;
			}
		}
		if (!isFound) {
			items.add(item);
		}
	}
}
