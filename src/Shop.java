import java.util.ArrayList;

public class Shop {
	private String name;
	public CustomerList allCustomers;
	public ProductList allProducts;

	public Shop() {

	}

	Shop(String name, CustomerList customerList, ProductList productList) {
		this.name = name;
		this.allCustomers = customerList;
		this.allProducts = productList;
	}

	public static void showAllProducts(Shop currentShop) {
		ArrayList<Product> shopProducts = currentShop.allProducts.productList;

		for (int i = 0; i < shopProducts.size(); i++) {
			System.out.println((i + 1) + ". " + shopProducts.get(i).name + " : " + shopProducts.get(i).price + " aud");
		}
	}
}
