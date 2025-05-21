import java.util.ArrayList;

public class ProductList {
	ArrayList<Product> productList = new ArrayList<Product>();
	
	public void addProduct(Product newProduct) {
		productList.add(newProduct);
	}
}
