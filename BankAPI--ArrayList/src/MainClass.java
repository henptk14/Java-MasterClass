
public class MainClass {
	public static void main(String[] args) {
		Bank bank = new Bank("Shwe Pin Le Bank");
		bank.addNewBranch("Seattle Branch");
		
		bank.addCustomerToBranch("Seattle Branch", "Pyi", 1000.00);
		bank.addCustomerToBranch("Seattle Branch", "Mike", 856.20);
		bank.addCustomerToBranch("Seattle Branch", "Jimmy", 550.21);
		bank.addCustomerToBranch("Seattle Branch", "Pensy", 2540.10);
		
		bank.addNewBranch("Yangon Branch");
		bank.addCustomerToBranch("Yangon Branch", "Tim", 200.60);
		bank.addCustomerToBranch("Yangon Branch", "Arturito", 320.20);
		bank.addCustomerToBranch("Yangon Branch", "Zaw", 540.70);
		
		bank.addCustomerTransaction("Seattle Branch", "Pyi", 3500.50);
		bank.addCustomerTransaction("Seattle Branch", "Pyi", 500);
		
		bank.listCustomers("Seattle Branch", true);
		//bank.listCustomers("Yangon Branch", true);
		
		bank.addNewBranch("Mandalay Branch");
		if(!bank.addCustomerToBranch("Mandalay Branch", "Bayless", 550)) {
			System.out.println("Mandaylay Branch does not exist yet");
		}
		
		if(!bank.addNewBranch("Seattle Branch")) {
			System.out.println("Seattle branch already exist");
		}
		
		if(!bank.addCustomerTransaction("Seattle Branch", "Fergie", 500)) {
			System.out.println("Customer does not exist");
		}
		
	}
}
