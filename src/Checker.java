
public class Checker extends Account {
	private static String accountType = "Checking";
	
	Checker(double initialDepoist){
		super();
		this.setBalance(initialDepoist);
		this.checkIntrest(0);
	}


public String toString(){
	return "Account Type:" + accountType + "Account\n" +
			"Account Number:" + this.getAccountNumber() + "/n"
			+ "Balace" + this.getBalance() + "/n" +
			"Intrest Rate" + this.getIntrest() + "%/n";
	}
}