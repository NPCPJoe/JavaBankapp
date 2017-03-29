
public class Account {
	private double balance;
	private double intrest = 0.02;
	private int accountNumber;
	private int numberAccounts = 1000000;
	
	Account(){
		accountNumber = numberAccounts++;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getIntrest() {
		return intrest * 100;
	}
	public void setIntrest(double intrest) {
		this.intrest = intrest;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public void withdraw (double amount){
		if(amount + 5 > balance){
			System.out.println("You have insufficent funds");
			return;
		}
		balance -= amount + 5;
		checkIntrest(0);
		System.out.println("You have withdrawn £" + amount + "pounds and incurred a fee of £1");
		System.out.println("You now have a balance of £" + balance);
	}
	
	public void deposit (double amount){
		if(amount < 0){
			System.out.println("You cannot depoist negative money");
			return;
		}
		checkIntrest(amount);
		amount = amount + amount + intrest;
		balance += amount;
		System.out.println("You have depoisted £" + amount + "pounds and intrest rate of" + intrest + "%");
		System.out.println("You now have a balance of £" + balance);
	}
	public void checkIntrest(double amount){
		if(balance + amount > 1000){
			intrest = 0.5;
		}
		else{
			intrest = 0.02;
		}
	}
}
