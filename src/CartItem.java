public class CartItem extends Product {

	int quantity;

	public CartItem() {
	}

	CartItem(String name, double price, String shop) {
		super(name, price, shop);
	}

	CartItem(Product product) {
		this.name = product.name;
		this.price = product.price;
		this.quantity = 1;
	}
}
