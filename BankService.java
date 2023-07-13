package task_oops;

public class BankService {
	public static void main(String[] args) {

		Account account1 = new Account(9759834793L, 50000);
		Account account2 = new Account(9454549855L, 60000);

		Customer customer1 = new Customer("Raju", account1);
		Customer customer2 = new Customer("Kiran", account2);
		
		RBI sbiService = new SBI(4, 3000, 20000, customer1, account1);
		SBI sbi = (SBI)sbiService;
		sbi.bankName = "State Bank of India";
		sbi.branch = "Hyderabad";
		sbi.bankDetails();
		System.out.println("Customer name : "+sbi.customer.getCustomerName());
		System.out.println("Account number : "+sbi.customer.account.getAccountNumber());
		System.out.println("Available balance : "+sbi.customer.account.getBalance());
		System.out.print("--->>>	After amount Withdraw : ");
		sbi.account.withDraw(13000);
		System.out.print("--->>>	Interest details : ");
		sbi.account.interestCharge(sbi.interestRate);
		System.out.println("--->>>	Minimum balance : "+sbi.minimumBalance);
		
		RBI iciciService = new ICICI(4, 5000, 20000, customer2, account2);
		ICICI icici = (ICICI)iciciService;
		icici.bankName = "ICICI Bank";
		icici.branch = "Chennai";
		icici.bankDetails();
		System.out.println("Customer name : "+icici.customer.getCustomerName());
		System.out.println("Account number : "+icici.customer.account.getAccountNumber());
		System.out.println("Available balance : "+icici.customer.account.getBalance());
		System.out.print("--->>>	After amount Withdraw : ");
		sbi.account.withDraw(18000);
		System.out.print("--->>>	Interest details : ");
		sbi.account.interestCharge(icici.interestRate);
		System.out.println("--->>>	Minimum balance : "+icici.minimumBalance);
	}
}