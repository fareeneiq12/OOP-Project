import java.util.Scanner;

/**
 * Main BankingManagementSystem class with interactive menu
 */
public class BankingManagementSystem {
    private static Bank bank;
    private static Scanner scanner;
    private static String currentCustomerId;

    public static void main(String[] args) {
        bank = new Bank("TechBank International");
        scanner = new Scanner(System.in);

        while (true) {
            if (currentCustomerId == null) {
                displayMainMenu();
            } else {
                displayCustomerMenu();
            }
        }
    }

    /**
     * Display main menu
     */
    private static void displayMainMenu() {
        System.out.println("\n===== BANKING MANAGEMENT SYSTEM =====");
        System.out.println("1. Register New Customer");
        System.out.println("2. Login as Customer");
        System.out.println("3. View Bank Information");
        System.out.println("4. View Transaction History");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                registerCustomer();
                break;
            case 2:
                loginCustomer();
                break;
            case 3:
                bank.displayBankInfo();
                break;
            case 4:
                bank.displayTransactionHistory();
                break;
            case 5:
                System.out.println("Thank you for using Banking Management System. Goodbye!");
                System.exit(0);
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    /**
     * Display customer menu
     */
    private static void displayCustomerMenu() {
        System.out.println("\n===== CUSTOMER MENU =====");
        System.out.println("1. Create New Account");
        System.out.println("2. View Account Details");
        System.out.println("3. Deposit Money");
        System.out.println("4. Withdraw Money");
        System.out.println("5. Transfer Money");
        System.out.println("6. View All Accounts");
        System.out.println("7. Logout");
        System.out.print("Choose an option: ");

        int choice = getIntInput();

        switch (choice) {
            case 1:
                createAccount();
                break;
            case 2:
                viewAccountDetails();
                break;
            case 3:
                deposit();
                break;
            case 4:
                withdraw();
                break;
            case 5:
                transfer();
                break;
            case 6:
                viewAllAccounts();
                break;
            case 7:
                currentCustomerId = null;
                System.out.println("Logged out successfully.");
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    /**
     * Register a new customer
     */
    private static void registerCustomer() {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine().trim();

        if (bank.getCustomer(customerId) != null) {
            System.out.println("Customer ID already exists.");
            return;
        }

        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();

        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();

        System.out.print("Enter Phone Number: ");
        String phoneNumber = scanner.nextLine().trim();

        bank.registerCustomer(customerId, name, email, phoneNumber);
        currentCustomerId = customerId;
    }

    /**
     * Login as customer
     */
    private static void loginCustomer() {
        System.out.print("Enter Customer ID: ");
        String customerId = scanner.nextLine().trim();

        if (bank.getCustomer(customerId) != null) {
            currentCustomerId = customerId;
            System.out.println("Login successful!");
            bank.getCustomer(customerId).displayCustomerInfo();
        } else {
            System.out.println("Customer not found.");
        }
    }

    /**
     * Create a new account
     */
    private static void createAccount() {
        Customer customer = bank.getCustomer(currentCustomerId);
        if (customer == null) return;

        System.out.println("\n=== Create New Account ===");
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine().trim();

        System.out.print("Enter Initial Balance: $");
        double balance = getDoubleInput();

        System.out.println("Account Type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        System.out.print("Choose account type: ");
        int type = getIntInput();

        Account account = null;

        if (type == 1) {
            System.out.print("Enter Interest Rate (%): ");
            double interestRate = getDoubleInput();
            System.out.print("Enter Minimum Balance: $");
            double minimumBalance = getDoubleInput();
            account = new SavingsAccount(accountNumber, customer.getName(), balance, interestRate, minimumBalance);
        } else if (type == 2) {
            System.out.print("Enter Overdraft Limit: $");
            double overdraftLimit = getDoubleInput();
            System.out.print("Enter Monthly Fee: $");
            double monthlyFee = getDoubleInput();
            account = new CheckingAccount(accountNumber, customer.getName(), balance, overdraftLimit, monthlyFee);
        } else {
            account = new Account(accountNumber, customer.getName(), balance, "General");
        }

        customer.addAccount(account);
    }

    /**
     * View account details
     */
    private static void viewAccountDetails() {
        Customer customer = bank.getCustomer(currentCustomerId);
        if (customer == null) return;

        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine().trim();

        Account account = customer.getAccount(accountNumber);
        if (account != null) {
            account.displayAccountDetails();
        } else {
            System.out.println("Account not found.");
        }
    }

    /**
     * Deposit money
     */
    private static void deposit() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine().trim();

        System.out.print("Enter Deposit Amount: $");
        double amount = getDoubleInput();

        bank.processDeposit(currentCustomerId, accountNumber, amount);
    }

    /**
     * Withdraw money
     */
    private static void withdraw() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scanner.nextLine().trim();

        System.out.print("Enter Withdrawal Amount: $");
        double amount = getDoubleInput();

        bank.processWithdrawal(currentCustomerId, accountNumber, amount);
    }

    /**
     * Transfer money
     */
    private static void transfer() {
        System.out.print("Enter Your Account Number: ");
        String fromAccount = scanner.nextLine().trim();

        System.out.print("Enter Recipient Customer ID: ");
        String toCustomerId = scanner.nextLine().trim();

        System.out.print("Enter Recipient Account Number: ");
        String toAccount = scanner.nextLine().trim();

        System.out.print("Enter Transfer Amount: $");
        double amount = getDoubleInput();

        bank.processTransfer(currentCustomerId, fromAccount, toCustomerId, toAccount, amount);
    }

    /**
     * View all accounts
     */
    private static void viewAllAccounts() {
        Customer customer = bank.getCustomer(currentCustomerId);
        if (customer != null) {
            customer.displayAllAccounts();
        }
    }

    /**
     * Get integer input from user
     */
    private static int getIntInput() {
        try {
            int value = Integer.parseInt(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a number.");
            return 0;
        }
    }

    /**
     * Get double input from user
     */
    private static double getDoubleInput() {
        try {
            double value = Double.parseDouble(scanner.nextLine().trim());
            return value;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid amount.");
            return 0;
        }
    }
}