import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Database {

	// constant
	static final ArrayList<Customer> CUSTOMER_DB = new ArrayList<Customer>();
	static final ArrayList<Product> PRODUCT_DB = new ArrayList<Product>();
	static final ArrayList<Shop> SHOP_DB = new ArrayList<Shop>();

	static {
		CustomerList shop1Customers = new CustomerList();
		CustomerList shop2Customers = new CustomerList();
		// path to text file
		try {
			String filePathCustomer = "src/Customer.txt";
			BufferedReader br = new BufferedReader(new FileReader(filePathCustomer));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty()) {
					continue;
				}
				String[] parts = line.split(",");
				String id = parts[0].trim();
				String password = parts[1].trim();
				String rank = parts[2].trim();
				String shop = parts[3].trim();

				Customer customer = new Customer(id, password, rank, shop);

				CUSTOMER_DB.add(customer);

				String shopCol = parts[3].trim();

				if (shopCol.equals("Shop1")) {
					shop1Customers.addCustomer(customer);
				} else if (shopCol.equals("Shop2")) {
					shop2Customers.addCustomer(customer);
				}
			}
			br.close();
		} catch (IOException e) {
			System.err.println("Error reading customer file: " + e.getMessage());
		}
		
		
		ProductList shop1Products = new ProductList();
		ProductList shop2Products = new ProductList();
		// path to text file
		try {
			String filePathProduct = "src/Product.txt";
			BufferedReader br = new BufferedReader(new FileReader(filePathProduct));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.trim().isEmpty()) {
					continue;
				}
				String[] parts = line.split(",");
				String name = parts[0].trim();
				double price = Double.parseDouble(parts[1].trim());
				String shop = parts[2].trim();

				
				Product product = new Product(name, price, shop);

				PRODUCT_DB.add(product);

				String shopCol = parts[2].trim();

				if (shopCol.equals("Shop1")) {
					shop1Products.addProduct(product);
				} else if (shopCol.equals("Shop2")) {
					shop2Products.addProduct(product);
				}
			}
			br.close();
			// Create the shops
			SHOP_DB.add(new Shop("Shop 1", shop1Customers, shop1Products));
			SHOP_DB.add(new Shop("Shop 2", shop2Customers, shop2Products));
		} catch (IOException e) {
			System.err.println("Error reading product file: " + e.getMessage());
		}
	}
}
