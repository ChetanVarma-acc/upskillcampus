package pack1;

public class AccountNumber {
	 private static int accountNumberCounter = 1000;

	    public static synchronized String generateAccountNumber() {
	        return "AC" + (++accountNumberCounter);
	    }
	    }

