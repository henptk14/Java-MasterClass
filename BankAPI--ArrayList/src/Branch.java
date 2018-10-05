// Branch:
// Need to be able to add a new customer and initial transaction amount.
// Also needs to add additional transactions for that customer/branch
import java.util.ArrayList;

public class Branch {
	private String name;
	private ArrayList<Customer> customers;
	
	public Branch(String name) {
		this(name, null);
	}
	
	public Branch(String name, Customer c) {
		this.name = name;
		this.customers = new ArrayList<Customer>();
		if(c != null) {
			this.customers.add(c);
		}
	}
	
	public boolean addNewCustomer(String CustomerName, double init_amount) {
		if(findCustomer(CustomerName) == null) {
			return this.customers.add(new Customer(CustomerName, init_amount));
		}
		return false;
	}
	
	public boolean addCustomerTransaction(String CustomerName, double amount) {
		Customer existingCustomer = findCustomer(CustomerName);
		if(existingCustomer != null) {
			return existingCustomer.addTransaction(amount);
		}
		return false;
	}
	
	private Customer findCustomer(String name) {
		for(int i = 0; i < this.customers.size(); i++) {
			Customer temp = this.customers.get(i);
			if(temp.getName().equals(name)) {
				return temp;
			}
		}
		return null;
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Customer> getCustomers(){
		return this.customers;
	}
}
