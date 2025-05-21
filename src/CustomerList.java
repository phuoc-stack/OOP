import java.util.ArrayList;

public class CustomerList {
	public ArrayList<Customer> customerList = new ArrayList<Customer>();
	
	public void addCustomer(Customer newCustomer) {
		customerList.add(newCustomer);
	}
	
}
