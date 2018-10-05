import java.util.ArrayList;

/*
 * Bank:
 * Add a new Branch
 * Add a customer to that branch with initial transaction
 * Show a list of customers for a particular branch and optionally a list of their transactions
 * 
 */
public class Bank {
	private ArrayList<Branch> branches;
	private String name;
	
	public Bank(String name) {
		this(name, null);
	}
	
	public Bank(String name, Branch branch) {
		this.name = name;
		branches = new ArrayList<Branch>();
		if(branch != null) {
			branches.add(branch);
		}
	}
	
	public boolean addNewBranch(String newBranchName) {
		if(findBranch(newBranchName) == null) {
			return branches.add(new Branch(newBranchName));
		}
		return false;
	}
	
	public boolean addCustomerToBranch(String branchName, String customerName, double init_amount) {
		Branch existingBranch = findBranch(branchName);
		if(existingBranch != null) {
			return existingBranch.addNewCustomer(customerName, init_amount);
		}
		return false;
	}
	
	public boolean addCustomerTransaction(String branchName, String customerName, double amount) {
		Branch existingBranch = findBranch(branchName);
		if(existingBranch != null) {
			return existingBranch.addCustomerTransaction(customerName, amount);
		}
		return false;
	}
	
	public boolean listCustomers(String branchName, boolean showTransaction) {
		Branch branch = findBranch(branchName);
		if(branch == null) {
			return false;
		}
		System.out.println("Customer details for branch " + branch.getName());
		int count = 1;
		for(Customer c : branch.getCustomers()) {
			System.out.println(count++ + ". Customer: " + c.getName());
			if(showTransaction) {
				System.out.println("\tTransactions");
				int tran_count = 1;
				for(double d : c.getTransactions()) {
					System.out.println("\t" + tran_count++ + ". Amount: " + d);
				}
				System.out.println();
			}
		}
		return true;
	}
	
	/**
	 * This private method returns a Branch object if the name matches
	 * else it returns null
	 * @param branchName
	 * @return
	 */
	private Branch findBranch(String branchName) {
		for(int i = 0; i < this.branches.size(); i++) {
			Branch existingBranch = this.branches.get(i);
			if(existingBranch.getName().equals(branchName)) {
				return existingBranch;
			}
		}
		return null;
	}
	
	public String getName() {
		return this.name;
	}
}
