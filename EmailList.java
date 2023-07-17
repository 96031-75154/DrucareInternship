package exceptionhandling;

import java.util.ArrayList;
import java.util.List;

public class EmailList {

	public static void main(String[] args) throws EmailNotFoundException {
		
		List<String> emails = new ArrayList<String>();
		emails.add("test988@gmail.com");
		emails.add("sample98@gmail.com");
		emails.add("demo56@gmail.com");
		
		String test = "demo56@gmail.com";
		String domain = "demo56!gmail.com";
		int symbol = domain.indexOf("@");
		
		if(emails.contains(test)) {
			System.out.println("Email is Found");
		}
		else {
			try
			{
				throw new EmailNotFoundException("Email is not found");
			}
			catch(EmailNotFoundException efe)
			{
				System.out.println(efe.getMessage());
			}
		}
		
		domainCheck(domain, symbol);
	}
	public static void domainCheck(String find, int index) {
		
		if(index != -1 && index != 0) {
			System.out.println("Email is valid");
		}
		else {
			try 
			{
				throw new InvalidDomainException("Email doesn't contain @ symbol");
			}
			catch(InvalidDomainException ide) 
			{
				System.out.println(ide.getMessage());
			}
		}
	}
}

class EmailNotFoundException extends Exception {
	public EmailNotFoundException(String str) {
		super(str);
	}
}

class InvalidDomainException extends RuntimeException {
	public InvalidDomainException(String str) {
		super(str);
	}
}