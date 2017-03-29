import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
//Instance variables
	Scanner keyboard = new Scanner(System.in);
	Bank bank = new Bank();
	boolean exit = false;
	
	// where the project runs from
	public static void main(String[] argd){
		Menu menu = new Menu();
		menu.runMenu();
	}
	public void runMenu(){
		printHeader();
		while(!exit){
			printMenu();
			int choice = getInput();
			performAction(choice);
		}
	}
	private void printHeader() {
		System.out.println("-----------------------------------------");
		System.out.println("   Welcome to Bank of Cooper             ");
		System.out.println("            By Joe Cooper                ");
		System.out.println("------------------------------------------");
	}
	private void performAction(int choice) {
		switch(choice){
		case 0:
		System.out.println("Thank you for using our app");
		System.exit(0);
		break;
		case 1 :
			createAccount();
		break;
		case 2:
			makeDespoist();
		break;
		case 3:
			makeWithdraw();
		break;
		case 4:
			listBalence();
		break;
		default:
		System.out.println("Unkown error has occured.");
		}
		
	}
	private void listBalence() {
		int account = selectAccount();
		if(account >= 0){
			System.out.println(bank.getCustomer(account).getAccount());
		} 
	}
	
	private void makeWithdraw() {
		int account = selectAccount();
		if(account >= 0){
			System.out.print("How much would you liek to withdraw?");
			double amount = 0;
			try{
				amount = Double.parseDouble(keyboard.nextLine());
			}
			catch(NumberFormatException e){
				amount = 0;
			}
			bank.getCustomer(account).getAccount().withdraw(amount);
		}
		
	}
	
	
	private void makeDespoist() {
		int account = selectAccount();
		if(account >= 0){
			System.out.print("How much would you liek to depoist?");
			double amount = 0;
			try{
				amount = Double.parseDouble(keyboard.nextLine());
			}
			catch(NumberFormatException e){
				amount = 0;
			}
			bank.getCustomer(account).getAccount().deposit(amount);
		}
		
	}
	private void createAccount() {
		String firstName, lastName, ssn, accountType = "";
		double initialDepoist = 0;
		boolean valid = false;
		while(!valid){
			System.out.print("Please enter an account tyoe(checking/saving;");
			accountType = keyboard.nextLine();
			if(accountType.equalsIgnoreCase("checking") || accountType.equalsIgnoreCase("savings")){
				valid = true;
			}
			else{
				System.out.println("Invalid account type selected. Please enter checking or savings");
			}
		}
		System.out.print("Please enter your first name.");
		firstName = keyboard.nextLine();
		System.out.print("Please enter your last name");
		lastName = keyboard.nextLine();
		System.out.print("please enter your soical security number");
		ssn = keyboard.nextLine();
		valid = false;
		while(!valid){
			System.out.print("Please enter an inital depoist: ");
			try{
				initialDepoist = Double.parseDouble(keyboard.nextLine());
			}
			catch(NumberFormatException e){
				System.out.println("Depoist must be a number");
			}
			if(accountType.equalsIgnoreCase("checking")){
				if(initialDepoist < 100){
					System.out.println("Checking account requires a minimum of £100 pounds to open.");
				}
				else{
					valid = true;
				}
			}
			else if(accountType.equalsIgnoreCase("savings")){
				if(initialDepoist < 0){
					System.out.println("Savings account requires a minimum of £100 pounds to open.");
				}
				else{
					valid = true;
				}
			}
		}
		Account account;
		if(accountType.equalsIgnoreCase("checking")){
			account = new Checker (initialDepoist);
		}
		else{
			account = new Saving (initialDepoist);
		}
		Customer customer = new Customer (firstName, lastName, ssn, account);
		bank.addCustomer(customer);
	}
	private int getInput() {
		int choice = -1;
		do{
			System.out.print("Enter your choice");
		
		try{
			choice = Integer.parseInt(keyboard.nextLine());
		}
		catch(NumberFormatException e){
			System.out.println("Invalid selection. Numbers only.");
		}
		if(choice < 0 || choice > 4){
			System.out.println("Choice out of range. Please try again.");
		}
		}while(choice < 0 || choice > 4);
		return choice;
	}
	private void printMenu() {
		System.out.println(" Please make a selction");
		System.out.println("1) Create a new account");
		System.out.println("2) Make a despoist");
		System.out.println("3) Make a withdraw");
		System.out.println("4) List account balence");
		System.out.println("0) Exit");
		
	}
	private int selectAccount () {
		ArrayList<Customer> customers = bank.getCustomers();
		if(customers.size() <= 0){
			System.out.println("No customers at your bank");
			return -1;
		}
		System.out.println("Select an account:");
		for(int  i = 0; i < customers.size(); i++){
			System.out.println ((i+1) + ")" + customers.get(i).basicInfo());
		}
		int account = 0;
		System.out.print("Please enter your selection: ");
		try{
			account = Integer.parseInt(keyboard.nextLine()) -1;
		}
		catch(NumberFormatException e){
			account = -1;
		}
		if(account < 0 || account > customers.size()){
			System.out.println("Ibalid account selected.");
			account = -1;
		}
		return account;
	}
}
