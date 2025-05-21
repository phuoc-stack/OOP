import java.util.ArrayList;

public class Customer {

	String id;
	String password;
	String rank;
	Cart customerCart;
	private String shop;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String id, String password, String rank, String shop) {
		super();
		this.id = id;
		this.password = password;
		this.rank = rank;
		this.shop = shop;
		this.customerCart = new Cart();
		this.customerCart.items = new ArrayList<CartItem>();
	}
}
