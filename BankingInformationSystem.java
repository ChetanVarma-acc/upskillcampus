package pack1;
import java.util.*;

public class BankingSystem {
	private Map<String, User> users;
    private Scanner scanner;

    public BankingSystem() {
        users = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void registerUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter address: ");
        String address = scanner.nextLine();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine();
        System.out.print("Enter initial deposit amount: ");
        double initialDeposit = scanner.nextDouble();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User newUser = new User(name, address, contactInfo, initialDeposit, password);
        users.put(newUser.getAccountNumber(), newUser);

        System.out.println("Registration successful! Your account number is " + newUser.getAccountNumber());
    }

    public void registerMultipleUsers() {
        System.out.print("Enter the number of users to register: ");
        int numberOfUsers = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < numberOfUsers; i++) {
            System.out.println("Registering user " + (i + 1) + ":");
            registerUser();
        }
    }

    public User login() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        User user = users.get(accountNumber);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        } else {
            System.out.println("Invalid account number or password!");
            return null;
        }
    }

    public void manageAccount(User user) {
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new address: ");
        String address = scanner.nextLine();
        System.out.print("Enter new contact info: ");
        String contactInfo = scanner.nextLine();

        user.setName(name);
        user.setAddress(address);
        user.setContactInfo(contactInfo);

        System.out.println("Account information updated successfully!");
    }

    public void deposit(User user) {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        user.deposit(amount);
        System.out.println("Deposit successful! New balance: $" + user.getBalance());
    }

    public void withdraw(User user) {
        try {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            user.withdraw(amount);
            System.out.println("Withdrawal successful! New balance: $" + user.getBalance());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void transferFunds(User user) {
        System.out.print("Enter recipient's account number: ");
        String recipientAccountNumber = scanner.nextLine();
        System.out.print("Enter amount to transfer: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        User recipient = users.get(recipientAccountNumber);
        if (recipient != null) {
            try {
                user.transfer(recipient, amount);
                System.out.println("Transfer successful! Your new balance: $" + user.getBalance());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Recipient account not found!");
        }
    }

    public void viewAccountStatement(User user) {
        System.out.println("Account statement for " + user.getAccountNumber() + ":");
        for (String transaction : user.getTransactions()) {
            System.out.println(transaction);
        }
        System.out.println("Current balance: $" + user.getBalance());
    }

    public void showMenu(User user) {
        int choice;
        do {
            System.out.println("\nBanking System Menu:");
            System.out.println("1. Manage Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Account Statement");
            System.out.println("6. Logout");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: manageAccount(user); break;
                case 2: deposit(user); break;
                case 3: withdraw(user); break;
                case 4: transferFunds(user); break;
                case 5: viewAccountStatement(user); break;
                case 6: System.out.println("Logging out..."); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 6);
    }

    public void start() {
        int choice;
        do {
            System.out.println("\nWelcome to the Banking System");
            System.out.println("1. Register");
            System.out.println("2. Register Multiple Users");
            System.out.println("3. Login");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: registerUser(); break;
                case 2: registerMultipleUsers(); break;
                case 3:
                    User user = login();
                    if (user != null) {
                        showMenu(user);
                    }
                    break;
                case 4: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 4);
    }

    public static void main(String[] args) {
        BankingSystem bankSystem = new BankingSystem();
        bankSystem.start();
    }
}