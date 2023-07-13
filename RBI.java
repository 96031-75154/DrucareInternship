package task_oops;

class Customer {
	String customerName;
	Account account;
	
	public Customer(String customerName, Account account) {
		super();
		this.customerName = customerName;
		this.account = account;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
}

class Account {
	long accountNumber;
	double balance;
	
	public Account(long accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public void deposit(double amount) {
		balance += amount;
	}
	
	public void withDraw(double amount) {
		if(amount <= balance) {
			balance -= amount;
			System.out.println("Available balance : "+getBalance());
		}
		else {
			System.out.println("Insufficient balance");
		}
	}
	public void interestCharge(double rate) {
		if(rate <= 4) {
			System.out.println("Upto 4% interest will be charged as per RBI guidelines");
		}
		else
		{
			System.out.println("Interest will be charged according to the concerned bank");
		}
	}
}

public class RBI {
	
	double interestRate;
	double minimumBalance;
	double minimumWithdrawLimit;
	
	Customer customer;
	Account account;
	
	public RBI(double interestRate, double minimumBalance, double minimumWithdrawLimit, Customer customer,
			Account account) {
		this.interestRate = interestRate;
		this.minimumBalance = minimumBalance;
		this.minimumWithdrawLimit = minimumWithdrawLimit;
		this.customer = customer;
		this.account = account;
	}

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}

	public double getMinimumBalance() {
		return minimumBalance;
	}

	public void setMinimumBalance(double minimumBalance) {
		this.minimumBalance = minimumBalance;
	}

	public double getMinimumWithdrawLimit() {
		return minimumWithdrawLimit;
	}

	public void setMinimumWithdrawLimit(double minimumWithdrawLimit) {
		this.minimumWithdrawLimit = minimumWithdrawLimit;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}

class SBI extends RBI {
	String bankName;
	String branch;
	
	public SBI(double interestRate, double minimumBalance, double minimumWithdrawLimit, Customer customer,
			Account account) {
		super(interestRate, minimumBalance, minimumWithdrawLimit, customer, account);
	}
	
	public void bankDetails() {
		System.out.println("------->>>>	SBI bank service ------>>>");
		System.out.println(bankName + "-"+branch+" branch");
	}
}

class ICICI extends RBI {
	String bankName;
	String branch;
	
	public ICICI(double interestRate, double minimumBalance, double minimumWithdrawLimit, Customer customer,
			Account account) {
		super(interestRate, minimumBalance, minimumWithdrawLimit, customer, account);
	}
	
	public void bankDetails() {
		System.out.println("-------->>>> ICICI bank service	------->>>");
		System.out.println(bankName + "-"+branch+" branch");
	}
}