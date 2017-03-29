
public class Customer {
	private final String firstName;
	private final String lastName;
	private final String ssn;
	private final Account account;
	
	public Customer(String firstName, String lastName, String ssn, Account account) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.ssn = ssn;
		this.account = account;
	}
	public String toString(){
		return "\nCustomer Information\n" +
				"First Name: " + firstName + "\n" +
				"Last Name : " + lastName + "\n" +
				"ssn :" + ssn + "\n" + account;
	}
	public String basicInfo(){
		return "First Name: " + firstName +
				"Last Name : " + lastName +
				"ssn :" + ssn + "Account Number:" + account.getAccountNumber();
	}
	Account getAccount(){
		return account;
	}
}