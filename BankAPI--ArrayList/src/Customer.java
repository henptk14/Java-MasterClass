		// The Customer class should have an arraylist of Doubles (transactions)
        // Customer:
        // Name, and the ArrayList of doubles.
import java.util.ArrayList;

public class Customer {
	private ArrayList<Double> transactions;
	private String Name;
	
	public Customer(String Name) {
		this(Name, 0);
	}
	
	public Customer(String Name, double Init_transaction) {
		transactions = new ArrayList<Double>();
		this.Name = Name;
		if(Init_transaction != 0)
			transactions.add(Init_transaction);
	}
	
	public boolean addTransaction(double amount) {
		return transactions.add(amount);
	}
	
	public boolean addTransaction(ArrayList<Double> d) {
		return transactions.addAll(d);
	}

	public ArrayList<Double> getTransactions() {
		return transactions;
	}

	public String getName() {
		return Name;
	}
}
