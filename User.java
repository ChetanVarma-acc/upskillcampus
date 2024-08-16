package pack1;
import java.util.*;

public class User {
	private String name;
    private String address;
    private String contactInfo;
    private String accountNumber;
    private double balance;
    private String password;
    private List<String> transactions;

    public User(String name, String address, String contactInfo, double initialDeposit, String password) {
        this.name = name;
        this.address = address;
        this.contactInfo = contactInfo;
        this.accountNumber = AccountNumber.generateAccountNumber();
        this.balance = initialDeposit;
        this.password = password;
        this.transactions = new ArrayList<>();
        addTransaction("Initial deposit: $" + initialDeposit);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public String getAccountNumber() { return accountNumber; }

    public double getBalance() { return balance; }

    public String getPassword() { return password; }

    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    public List<String> getTransactions() { return transactions; }

    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposited: $" + amount);
    }

    public void withdraw(double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient funds!");
        }
        balance -= amount;
        addTransaction("Withdrew: $" + amount);
    }

    public void transfer(User recipient, double amount) throws Exception {
        if (amount > balance) {
            throw new Exception("Insufficient funds!");
        }
        balance -= amount;
        recipient.deposit(amount);
        addTransaction("Transferred: $" + amount + " to " + recipient.getAccountNumber());
        recipient.addTransaction("Received: $" + amount + " from " + accountNumber);
    }
}
