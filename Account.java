/**
 * Account class represents a bank account
 */
public class Account {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private String accountType; // Savings, Checking, Business
    private boolean isActive;

    /**
     * Constructor to create an account
     */
    public Account(String accountNumber, String accountHolder, double initialBalance, String accountType) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialBalance;
        this.accountType = accountType;
        this.isActive = true;
    }

    /**
     * Deposit money into account
     */
    public boolean deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return false;
        }
        balance += amount;
        System.out.println("Deposited: $" + amount + " into account " + accountNumber);
        return true;
    }

    /**
     * Withdraw money from account
     */
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
            return false;
        }
        if (amount > balance) {
            System.out.println("Insufficient balance. Current balance: $" + balance);
            return false;
        }
        balance -= amount;
        System.out.println("Withdrawn: $" + amount + " from account " + accountNumber);
        return true;
    }

    /**
     * Transfer money to another account
     */
    public boolean transfer(Account recipient, double amount) {
        if (!isActive) {
            System.out.println("Account is not active.");
            return false;
        }
        if (this.withdraw(amount)) {
            recipient.deposit(amount);
            System.out.println("Transferred: $" + amount + " from " + this.accountNumber + " to " + recipient.accountNumber);
            return true;
        }
        return false;
    }

    /**
     * Get account balance
     */
    public double getBalance() {
        return balance;
    }

    /**
     * Get account number
     */
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Get account holder name
     */
    public String getAccountHolder() {
        return accountHolder;
    }

    /**
     * Get account type
     */
    public String getAccountType() {
        return accountType;
    }

    /**
     * Display account details
     */
    public void displayAccountDetails() {
        System.out.println("\n=== Account Details ===");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: $" + String.format("%.2f", balance));
        System.out.println("Status: " + (isActive ? "Active" : "Inactive"));
        System.out.println("=======================");
    }

    /**
     * Deactivate account
     */
    public void deactivateAccount() {
        isActive = false;
        System.out.println("Account " + accountNumber + " has been deactivated.");
    }

    /**
     * Activate account
     */
    public void activateAccount() {
        isActive = true;
        System.out.println("Account " + accountNumber + " has been activated.");
    }
}