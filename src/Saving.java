
public class Saving extends Account{
private static String accountType = "Checking";
	
	Saving (double initialDepoist){
		super();
		this.setBalance(initialDepoist);
		if(initialDepoist > 100000){
			this.setIntrest(5);
		}
		else{
			this.setIntrest(2);
		}
	}


public String toString(){
	return "Account Type:" + accountType + "Account\n" +
			"Account Number:" + this.getAccountNumber() + "/n"
			+ "Balace" + this.getBalance() + "/n" +
			"Intrest Rate" + this.getIntrest() + "%/n";
	}
}
